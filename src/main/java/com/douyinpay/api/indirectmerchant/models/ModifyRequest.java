package com.douyinpay.api.indirectmerchant.models;

/**
 * 修改商户资料请求（modify）。
 *
 * 目前仅支持修改商户简称和客服电话，通过商户定位信息指定目标商户（外部定位或抖音支付间连商户号二选一）。
 *
 * 官方文档：
 * https://partner.douyinpay.com/wiki/682c7a8e82b07604fd4deccb/682d9151b3825304f979c5e6
 */
public class ModifyRequest extends Locator {

    /** 商户简称，在支付完成页向买家展示。 */
    public String merchantShortName;

    /** 客服电话，将在交易记录中向买家展示。 */
    public String servicePhone;
}
