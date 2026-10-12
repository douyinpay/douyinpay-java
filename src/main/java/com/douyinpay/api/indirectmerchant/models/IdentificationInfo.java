package com.douyinpay.api.indirectmerchant.models;

/**
 * 经营者/法人身份证件信息。
 *
 * 其中证件持有人姓名、证件号码为敏感字段：上送时使用抖音支付平台证书公钥加密，
 * 下行时使用服务商私钥解密。SDK 在 createApply 发送前自动加密、在 queryMerchant 返回后自动解密，
 * 调用方无需手动处理加解密。
 *
 * 敏感字段加解密说明：
 * https://partner.douyinpay.com/wiki/662b13c27bbf8802fade4b4e/6809e6ecc10e9e05e71f6f1e
 */
public class IdentificationInfo {

    /**
     * 证件类型，枚举包括 IDENTIFICATION_TYPE_IDCARD（中国大陆居民身份证）、
     * IDENTIFICATION_TYPE_OVERSEA_PASSPORT（护照）、IDENTIFICATION_TYPE_HONGKONG_PASSPORT、
     * IDENTIFICATION_TYPE_MACAO_PASSPORT、IDENTIFICATION_TYPE_TAIWAN_PASSPORT、
     * IDENTIFICATION_TYPE_FOREIGN_RESIDENT、IDENTIFICATION_TYPE_HONGKONG_MACAO_RESIDENT、
     * IDENTIFICATION_TYPE_TAIWAN_RESIDENT。
     */
    public String identificationType;

    /**
     * 证件持有人姓名，为敏感字段。
     * 上送时使用抖音支付平台证书公钥加密，下行时使用服务商私钥解密；
     * SDK 在 createApply 发送前自动加密、在 queryMerchant 返回后自动解密。
     */
    public String identificationName;

    /**
     * 证件持有人证件号码，为敏感字段。
     * 上送时使用抖音支付平台证书公钥加密，下行时使用服务商私钥解密；
     * SDK 在 createApply 发送前自动加密、在 queryMerchant 返回后自动解密。
     */
    public String identificationNumber;

    /** 证件持有人有效期开始时间，YYYY-MM-DD 格式。 */
    public String periodBegin;

    /** 证件持有人有效期结束时间，YYYY-MM-DD 格式或“长期”。 */
    public String periodEnd;

    /** 证件正面照片的 MediaID，身份证为人像面。 */
    public String identificationFrontCopy;

    /** 证件背面照片的 MediaID，身份证为国徽面。 */
    public String identificationBackCopy;
}
