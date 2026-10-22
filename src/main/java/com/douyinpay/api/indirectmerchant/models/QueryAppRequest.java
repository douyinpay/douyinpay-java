package com.douyinpay.api.indirectmerchant.models;

/**
 * 查询应用 APPID 请求（query_app_id）。
 *
 * 查询间连子商户配置的 APPID 信息，通过商户定位信息指定目标商户（外部定位或抖音支付间连商户号二选一），
 * 可按 appId 过滤。
 *
 * 官方文档：
 * https://partner.douyinpay.com/wiki/682c7a8e82b07604fd4deccb/6940170bda453b056b767637
 */
public class QueryAppRequest extends Locator {

    /** 应用 APPID，用于按应用过滤查询结果。 */
    public String appId;
}
