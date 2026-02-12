## 版本变更记录

代码位置：src/main/java/com/douyinpay/api/DouyinpayClient.java

ClientVersion 每次sdk升级，需要更新版本号


v 1.0.0 - 2026-01-26
--------------------
* 新增平台证书下载api功能
* 新增平台证书自动更新和验签功能
* 接口枚举类调整为String


v 0.0.4 - 2025-07-04
--------------------
* 消息通知回调（SymmetricFactory），中 ENCRYPT_TYPE_AES 枚举值由“AES”调整为”AEAD-AES-256-GCM“，匹配线上文档描述


v 0.0.3 - 2025-07-03
--------------------
* 商家账单商家平台新增分账账单下载接口
* 商家账单合作伙伴平台补齐交易账单、资金账单、分账账单下载接口

v 0.0.2 - 2025-05-28
--------------------
* 商户代扣接口（com.douyinpay.api.deduct.ApiDeductService.deduct），响应体增加ResultCode字段
