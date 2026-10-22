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
RequestParam requestParam =  new RequestParam.Builder().serialNumber("623DFCD5354E06BC")
        .nonce(verifyNonce)
        .signature(signature);
        .signType(verifyAlgorithm)
        .timestamp(timestamp)
        .body(notifyStr)
         .build();

// 初始化 NotificationConfig
NotificationConfig notificationConfig = new NotificationConfig.Builder()
        .signType(Constants.SIGN_TYPE_RSA)
        .cipherType(Constants.ENCRYPT_TYPE_AES)
        .platformPublicKey("")
        .platformCertPath(platformPath)
        .encryptKey(aesKey).build();

// 初始化 NotificationParser
NotificationParser parser=new NotificationParser(rsaNotificationConfig);

// 验签并解密报文
DecryptObject decryptObject = parser.parse(requestParam,DecryptObject.class);
```

## 间连商户接口

可以使用 [indirectmerchant](/src/main/java/com/douyinpay/api/indirectmerchant) 中的 `ApiIndirectMerchantService` 调用间连商户相关接口，包含入驻申请、查询/撤销申请单、查询商户、修改商户、绑定/查询应用 APPID、图片上传等能力，以及申请状态通知（`INDIRECT_MERCHANT_APPLYMENT_STATUS`）的解析。

- 入驻申请（`createApply`）中的证件持有人姓名、证件号码为敏感字段，SDK 发送前使用抖音支付平台证书公钥加密（加密作用于请求副本，不修改调用方传入的对象）。
- 查询商户（`queryMerchant`）返回的证件持有人姓名、证件号码由抖音支付加密下发，SDK 使用服务商私钥自动解密。
- 图片上传（`upload`）为 multipart/form-data 请求，参与签名计算的仅为 `meta` 的 JSON 串。

接口的使用方法可以参考 `src/test/java/com/douyinpay/api/indirectmerchant` 下的测试用例。