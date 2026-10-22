package com.douyinpay.api.indirectmerchant.models;

/**
 * 查询入驻申请单请求（query_apply）。
 *
 * 通过申请单号或业务申请编号查询，两种方式二选一，结果相同。
 *
 * 官方文档：
 * https://partner.douyinpay.com/wiki/682c7a8e82b07604fd4deccb/682d9177e78abd05159f2401
 */
public class QueryApplyRequest {

    /** 抖音支付申请单号，由抖音支付生成并下发。 */
    public String applymentId;

    /** 业务申请编号，提交时自定义的唯一编号。 */
    public String businessCode;
}
