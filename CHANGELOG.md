## 版本变更记录

代码位置：src/main/java/com/douyinpay/api/DouyinpayClient.java

ClientVersion 每次sdk升级，需要更新版本号

## 未发布

- 保留六参数公开客户端构造器并标记废弃，将其用途限定为官方 HTTPS 平台证书下载；业务请求使用已配置平台证书的客户端验签
- 修正应答时间窗单位，补充回调时间窗校验，默认允许正负 300 秒；支持正数配置，非正数回退默认值
- 修正时间戳溢出和未来时间边界处理，验签失败信息不再包含签名原文和完整报文
- 平台证书缓存返回独立证书对象，兼容 RSA/SM2，未命中返回 null；自定义 Header 设置和读取使用副本
- 补充通知幂等、服务器时间同步及构造器和 Header 配置迁移说明

## v1.0.13 - 2026-10-12

- 新增间连商户相关接口能力（com.douyinpay.api.indirectmerchant.ApiIndirectMerchantService）：入驻申请、查询/撤销申请单、查询商户、修改商户、绑定/查询应用 APPID、图片上传
- 新增间连商户申请状态通知解析（INDIRECT_MERCHANT_APPLYMENT_STATUS），复用通用 NotificationParser 验签与 AES-256-GCM 解密
- 新增敏感字段加解密能力（DouyinpayClient.encryptSensitive/decryptSensitive）：入驻申请对证件持有人姓名、证件号码使用平台证书公钥加密，查询商户对下行密文使用服务商私钥解密
- 新增图片上传 multipart 传输能力（DouyinpayClient.executeMultipart），签名正文仅覆盖 meta
- 补充间连商户接口与字段注释说明

## v1.0.12 - 2026-09-06

- 补充平台证书、账单、先享后付等模块的接口与字段注释说明

## v1.0.11 - 2026-08-24

- 新增服务商分账能力（com.douyinpay.api.partnersplitfundpayments.ApiPartnerSplitFundPaymentsService），包括分账、完结分账、回退分账、接收方管理、商户配置与通知模型
- 补充服务商分账相关示例测试

## v1.0.10 - 2026-08-17

- 新增前置咨询接口（com.douyinpay.api.cashier.ApiCashierService.prePayConsult），支持咨询抖音支付渠道、先享后付渠道的可用性与营销信息
- 补充前置咨询接口的字段注释和文档说明

## v1.0.9 - 2026-08-04

- 复用 ApiTransaction 支持扣款结果通知
- autoConfig 补充超时时间设置
- 补充直连与服务商开放接口的字段注释和文档说明

## v 1.0.0 - 2026-01-26

- 新增平台证书下载api功能
- 新增平台证书自动更新和验签功能
- 接口枚举类调整为String

## v 0.0.4 - 2025-07-04

- 消息通知回调（SymmetricFactory），中 ENCRYPT\_TYPE\_AES 枚举值由“AES”调整为”AEAD-AES-256-GCM“，匹配线上文档描述

## v 0.0.3 - 2025-07-03

- 商家账单商家平台新增分账账单下载接口
- 商家账单合作伙伴平台补齐交易账单、资金账单、分账账单下载接口

## v 0.0.2 - 2025-05-28

- 商户代扣接口（com.douyinpay.api.deduct.ApiDeductService.deduct），响应体增加ResultCode字段
