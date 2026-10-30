## 回调通知验签和解密

可以使用 [notification](/src/main/java/com/douyinpay/api/notification) 中的 `NotificationParser` 解析回调通知。具体步骤如下：

1. 获取HTTP请求头中的 `douyinpay-signature` 、 `douyinpay-nonce` 、 `douyinpay-timestamp` 、 `douyinpay-serial` 对应的值，构建 `RequestParam` 。
2. 获取 HTTP 请求体的 `JSON` 纯文本。
3. 根据解密后的通知数据数据结构，构造解密对象类 `DecryptObject` 。支付结果通知和代扣结果通知解密对象类为 [`ApiTransaction`](src/main/java/com/douyinpay/api/payments/common/ApiTransaction.java)，退款结果通知解密对象类为 [ApiRefundNotification](src/main/java/com/douyinpay/api/refund/model/ApiRefundNotification.java)。
4. 使用抖音支付平台证书（验签）和商户API密钥（解密）初始化 `NotificationConfig` 和 `NotificationParser` 。
5. 使用请求参数 `requestParam` 和 `DecryptObject.class` ，调用 `parser.parse` 验签并解密报文。

```java
// 构造 RequestParam
//签名、随机数、时间戳从header中获取
RequestParam requestParam =  new RequestParam.Builder().serialNumber(verifySerial)
        .nonce(verifyNonce)
        .signature(signature)
        .signType(verifyAlgorithm)
        .timestamp(timestamp)
        .body(notifyStr)
         .build();

// 初始化 NotificationConfig
NotificationConfig notificationConfig = new NotificationConfig.Builder()
        .signType(Constants.SIGN_TYPE_RSA)
        .cipherType(Constants.ENCRYPT_TYPE_AES)
        .platformCertPath(platformPath)
        .encryptKey(aesKey).build();

// 初始化 NotificationParser
NotificationParser parser=new NotificationParser(notificationConfig);

// 验签并解密报文
try {
    DecryptObject decryptObject = parser.parse(requestParam, DecryptObject.class);
    // 验签成功后，再按业务单号或通知 ID 幂等处理业务。
} catch (DouyinpayException e) {
    // 按通知接口约定返回失败，并记录错误阶段；不要记录密钥、签名原文或完整通知。
}
```

SDK 在验签通过后检查应答和回调的时间戳，默认允许与本机时间相差最多 300 秒（含边界），超过时间窗则抛出 `DouyinpayException`。请保持服务器时间同步，并按业务单号或通知 ID 做持久化幂等处理；时间窗校验不能替代幂等，也不能识别时间窗内的重复通知。

如需调整时间窗，普通客户端在初始化前调用 `GlobalConfig.setMaxClockOffsetSeconds(seconds)`；通知解析器使用 `NotificationConfig.Builder.maxClockOffsetSeconds(seconds)`。自动证书模式在构造客户端和通知解析器前调用 `AutoPlatformCertificateConfig.setMaxClockOffsetSeconds(seconds)`，两者共用该配置。只接受正数；非正数会记录警告并回退到 300 秒，不会关闭校验。扩大时间窗会增加重放风险，应按实际时钟偏差谨慎配置。平台重试通知是否刷新签名时间戳，需要接入方与平台确认；使用保留旧时间戳的重试报文时，要评估投递时延与时间窗。

六参数 `DefaultDouyinpayClient` 构造器保留原签名并标记为废弃，仅允许访问官方 HTTPS 平台证书下载接口，禁止重定向、业务请求和文件上传。业务接入请使用 `DefaultDouyinpayClient(GlobalConfig)`、`AutoRSABuilder` 或 `AutoSM2Builder`，以便使用平台证书验签。初始化时直接捕获 `DouyinpayException` 并处理密钥、证书或下载失败。

`GlobalConfig` 和 `AutoPlatformCertificateConfig` 的自定义 Header 在设置和读取时均返回副本。修改 `getCustomHeaders()` 的结果后，如需更新配置，请再次调用 `setCustomHeaders()`，并在构造客户端前完成设置。

## 间连商户接口

可以使用 [indirectmerchant](/src/main/java/com/douyinpay/api/indirectmerchant) 中的 `ApiIndirectMerchantService` 调用间连商户相关接口，包含入驻申请、查询/撤销申请单、查询商户、修改商户、绑定/查询应用 APPID、图片上传等能力，以及申请状态通知（`INDIRECT_MERCHANT_APPLYMENT_STATUS`）的解析。

- 入驻申请（`createApply`）中的证件持有人姓名、证件号码为敏感字段，SDK 发送前使用抖音支付平台证书公钥加密（加密作用于请求副本，不修改调用方传入的对象）。
- 查询商户（`queryMerchant`）返回的证件持有人姓名、证件号码由抖音支付加密下发，SDK 使用服务商私钥自动解密。
- 图片上传（`upload`）为 multipart/form-data 请求，参与签名计算的仅为 `meta` 的 JSON 串。

接口的使用方法可以参考 `src/test/java/com/douyinpay/api/indirectmerchant` 下的测试用例。
