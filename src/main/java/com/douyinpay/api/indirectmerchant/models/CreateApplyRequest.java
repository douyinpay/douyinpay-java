package com.douyinpay.api.indirectmerchant.models;

import java.util.Map;

/**
 * 间连商户入驻申请请求（create_apply）。
 *
 * 从业机构提交商户资料入驻成为抖音支付间连商户。证件持有人姓名、证件号码为敏感字段，
 * SDK 在发送前自动使用平台公钥加密（加密作用于请求副本，不修改调用方对象）。
 *
 * 官方文档：
 * https://partner.douyinpay.com/wiki/682c7a8e82b07604fd4deccb/682d90a7f6171b04e93c7b83
 */
public class CreateApplyRequest {

    /** 间连商户外部商户号，从业机构在清算机构侧登记的间连商户唯一标识。 */
    public String outIndirectMerchantId;

    /** 从业机构外部商户号，从业机构在清算机构侧登记的商户号。 */
    public String outPaymentInstId;

    /** 渠道商外部商户号，渠道商在清算机构侧登记的商户号。 */
    public String outChannelSpId;

    /**
     * 子从业机构外部商户号，支持银联下同一从业机构按地区拆分子从业机构的场景，
     * 子从业机构号需与从业机构号（outPaymentInstId）前 4 位一致，后续交易需使用该子从业机构。
     */
    public String outPaymentInstSubId;

    /**
     * 业务申请编号，由数字、小写字母或下划线组成的自定义唯一编号，
     * 每个编号对应一个申请单，审核通过后生成一个抖音支付商户号。
     */
    public String businessCode;

    /** 主体资料，商家的营业执照/登记证书、经营者/法人证件等信息。 */
    public SubjectInfo subjectInfo;

    /** 经营者/法人身份证件信息，其中证件持有人姓名、证件号码为敏感字段。 */
    public IdentificationInfo identificationInfo;

    /** 经营信息，商家的经营业务、售卖商品/提供服务场景信息。 */
    public BusinessInfo businessInfo;

    /** 补充信息，根据审核情况额外要求商家提供的补充资料。 */
    public AdditionInfo additionInfo;

    /** 抖音支付间连商户号，传入已有商户号时会校验一致性，未传则按新入驻创建。 */
    public String indirectMerchantId;

    /** 扩展信息，预留的额外业务字段。 */
    public Map<String, Object> extInfo;

    /**
     * 校验入驻申请的商户定位组合与业务申请编号。
     *
     * @throws IllegalArgumentException 必填定位信息或业务申请编号缺失时抛出
     */
    public void validate() {
        if (isEmpty(outIndirectMerchantId) || isEmpty(outPaymentInstId)) {
            throw new IllegalArgumentException("out_indirect_merchant_id and out_payment_inst_id are required");
        }
        if (isEmpty(businessCode)) {
            throw new IllegalArgumentException("business_code is required");
        }
    }

    private static boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }
}
