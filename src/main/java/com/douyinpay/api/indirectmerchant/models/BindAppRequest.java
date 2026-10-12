package com.douyinpay.api.indirectmerchant.models;

/**
 * 绑定应用 APPID 请求（bind_app_id）。
 *
 * 为间连子商户配置 APPID 绑定关系，仅支持新增配置，通过商户定位信息指定目标商户
 * （外部定位或抖音支付间连商户号二选一）。
 *
 * 官方文档：
 * https://partner.douyinpay.com/wiki/682c7a8e82b07604fd4deccb/693fc694da453b056b7353d0
 */
public class BindAppRequest extends Locator {

    /** 需要给间连商户绑定的应用 APPID。 */
    public String appId;
}
