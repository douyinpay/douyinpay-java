package com.douyinpay.api.indirectmerchant.models;

/**
 * 撤销入驻申请单请求（cancel_apply）。
 *
 * 仅当申请单处于待提交和审核中时可撤销，通过申请单号或业务申请编号二选一。
 *
 * 官方文档：
 * https://partner.douyinpay.com/wiki/682c7a8e82b07604fd4deccb/682d919583179e04f6aaff0e
 */
public class CancelApplyRequest {

    /** 抖音支付申请单号，由抖音支付生成并下发。 */
    public String applymentId;

    /** 业务申请编号，提交时自定义的唯一编号。 */
    public String businessCode;
}
