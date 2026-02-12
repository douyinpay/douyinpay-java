## 回调通知验签和解密

可以使用 [notification](/src/main/java/com/douyinpay/api/notification) 中的 `NotificationParser` 解析回调通知。具体步骤如下：

1. 获取HTTP请求头中的 `douyinpay-signature` 、 `douyinpay-nonce` 、 `douyinpay-timestamp` 、 `douyinpay-serial` 对应的值，构建 `RequestParam` 。
2. 获取 HTTP 请求体的 `JSON` 纯文本。
3. 根据解密后的通知数据数据结构，构造解密对象类 `DecryptObject` 。支付结果通知解密对象类为 [`ApiTransaction`](src/main/java/com/douyinpay/api/payments/common/ApiTransaction.java)，退款结果通知解密对象类为 [ApiRefundNotification](src/main/java/com/douyinpay/api/refund/model/ApiRefundNotification.java)。
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
