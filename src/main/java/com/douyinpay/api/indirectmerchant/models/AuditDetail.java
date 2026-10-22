package com.douyinpay.api.indirectmerchant.models;

/**
 * 驳回原因详情。
 *
 * 对应查询入驻申请单响应（query_apply）中 audit_detail 列表元素。
 */
public class AuditDetail {

    /** 提交申请单的资料项字段名。 */
    public String field;

    /** 提交资料项被驳回的原因。 */
    public String rejectReason;
}
