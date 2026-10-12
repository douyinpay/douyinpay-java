package com.douyinpay.api.indirectmerchant.models;

/**
 * 查询间连商户响应（query_merchant）。
 *
 * 响应中的证件持有人姓名、证件号码为抖音支付加密下发字段，SDK 在返回后自动使用服务商私钥解密后回填。
 *
 * 官方文档：
 * https://partner.douyinpay.com/wiki/682c7a8e82b07604fd4deccb/6a6ab6add3c3490537736353
 */
public class QueryMerchantResponse {

    /** 外部间连商户号。 */
    public String outIndirectMerchantId;

    /** 外部从业机构商户号。 */
    public String outPaymentInstId;

    /** 外部渠道商户号。 */
    public String outChannelSpId;

    /** 业务申请编号，对应该间连商户入驻成功的业务申请编号。 */
    public String businessCode;

    /** 申请单号，对应该间连商户入驻成功的申请单号。 */
    public String applymentId;

    /** 抖音支付间连商户号。 */
    public String indirectMerchantId;

    /** 主体资料。 */
    public SubjectInfo subjectInfo;

    /** 经营者/法人身份证件信息，其中证件持有人姓名、证件号码由抖音支付加密下发，SDK 自动解密。 */
    public IdentificationInfo identificationInfo;

    /** 经营信息。 */
    public BusinessInfo businessInfo;
}
