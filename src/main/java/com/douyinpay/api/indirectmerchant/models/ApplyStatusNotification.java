package com.douyinpay.api.indirectmerchant.models;

/**
 * 间连商户申请状态通知（event_type=INDIRECT_MERCHANT_APPLYMENT_STATUS）
 * 回调密文解密后的业务数据。
 *
 * 官方文档：
 * https://partner.douyinpay.com/wiki/682c7a8e82b07604fd4deccb/6a7489dbaa9a5804d014c2ce
 */
public class ApplyStatusNotification {

    /** 从业机构户号，由抖音支付生成并下发。 */
    public String spMchid;

    /** 抖音支付生成的申请单号。 */
    public String applymentId;

    /** 商户自提交的申请单号，站点页面提交情况下为空。 */
    public String businessCode;

    /** 抖音支付间连商户号，申请单状态为 APPLYMENT_STATE_PASSED 时返回。 */
    public String indirectMerchantId;

    /**
     * 申请单状态，枚举包括 APPLYMENT_STATE_REJECTED（已驳回）、
     * APPLYMENT_STATE_PASSED（已完成）、APPLYMENT_STATE_CANCELED（已作废）。
     */
    public String applymentState;

    /** 失败原因详情，驳回时返回驳回原因，撤销时返回申请单已撤销。 */
    public String failReason;
}
