package com.douyinpay.api.indirectmerchant.models;

import java.util.List;

/**
 * 查询入驻申请单响应（query_apply）。
 *
 * 官方文档：
 * https://partner.douyinpay.com/wiki/682c7a8e82b07604fd4deccb/682d9177e78abd05159f2401
 */
public class QueryApplyResponse {

    /** 业务申请编号。 */
    public String businessCode;

    /** 抖音支付申请单号。 */
    public String applymentId;

    /** 抖音支付间连商户号，申请单状态为 APPLYMENT_STATE_PASSED 时返回。 */
    public String indirectMerchantId;

    /**
     * 申请单状态，枚举包括 APPLYMENT_STATE_WAITTING_FOR_AUDIT（审核中）、
     * APPLYMENT_STATE_REJECTED（已驳回）、APPLYMENT_STATE_PASSED（已完成）、
     * APPLYMENT_STATE_CANCELED（已作废）。
     */
    public String applymentState;

    /** 驳回原因详情，申请单状态为 APPLYMENT_STATE_REJECTED 时返回。 */
    public List<AuditDetail> auditDetail;
}
