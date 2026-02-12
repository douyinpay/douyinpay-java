package com.doupay.api.secret;

/* 服务商户配置 */
public class PartnerConfig {

    public final static String SP_MCHID = ""; // RSA商户号

    public final static String SUB_MCHID = ""; // RSA商户号

    public final static String ENCRYPT_KEY = "";
 
    public final static String SP_APPID = "";

    public final static String SUB_APPID = "";
     /* 
    * 商户证书序列号
    */
    public final static String MERCHANT_SERIAL_NO = "";
 
   /**
    * 商户私钥
    */
    public final static String MERCHANT_PRIVATE_KEY = "-----BEGIN PRIVATE KEY-----\n" +
           "-----END PRIVATE KEY-----"; // 商户RSA私钥

   /**
    * 商户私钥路径
    */
    public final static String MERCHANT_PRIVATE_KEY_PATH = "";
   /**
    * 平台证书
    */
    public final static String PLATFORM_CERTIFICATE  = "-----BEGIN CERTIFICATE-----\n" +
           "-----END CERTIFICATE-----";

    /**
    * 平台证书路径
    */
    public final static String PLATFORM_CERTIFICATE_PATH = "";

        /**
     * 签约协议号
     */
    public final static String CONTRACT_CODE = "";

        /**
     * 签约协议号
     */
    public final static String CONTRACT_ID = "";

    /**
     * 签约协议号
     */
    public final static String DEDUCT_CONTRACT_ID = "";
}
