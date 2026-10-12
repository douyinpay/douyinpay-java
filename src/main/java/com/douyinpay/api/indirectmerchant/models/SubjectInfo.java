package com.douyinpay.api.indirectmerchant.models;

/**
 * 主体资料。
 *
 * 对应入驻申请（create_apply）/查询间连商户（query_merchant）中的 subject_info。
 */
public class SubjectInfo {

    /**
     * 主体类型，需与营业执照/登记证书一致，枚举包括 SUBJECT_TYPE_INDIVIDUAL（个体户）、
     * SUBJECT_TYPE_ENTERPRISE（企业）、SUBJECT_TYPE_GOVERNMENT（政府机关）、
     * SUBJECT_TYPE_INSTITUTIONS（事业单位）、SUBJECT_TYPE_OTHERS（其他组织）、
     * SUBJECT_TYPE_MICRO（小微商户）。
     */
    public String subjectType;

    /**
     * 主体证件信息，主体为企业/个体户/政府机关/事业单位/其他组织时必填，小微商户无需填写。
     */
    public CertificateInfo certificateInfo;
}
