package com.douyinpay.api.indirectmerchant.models;

/**
 * 主体证件信息。
 *
 * 对应入驻申请（create_apply）/查询间连商户（query_merchant）中的 subject_info.certificate_info。
 */
public class CertificateInfo {

    /** 证件编号，营业执照/登记证书上的统一社会信用代码。 */
    public String certNo;

    /** 商户名称，对应证件的主体名称，小微商户使用法人名称。 */
    public String merchantName;

    /** 证件图片，通过图片上传接口预先上传生成的 MediaID。 */
    public String certCopy;

    /** 注册地址，营业执照/登记证书的注册地址。 */
    public String registerAddress;

    /** 经营者/法人姓名，营业执照的经营者/法定代表人姓名。 */
    public String legalPersonName;

    /** 有效期限开始日期，YYYY-MM-DD 格式。 */
    public String periodBegin;

    /** 有效期限结束日期，YYYY-MM-DD 格式或“长期”。 */
    public String periodEnd;
}
