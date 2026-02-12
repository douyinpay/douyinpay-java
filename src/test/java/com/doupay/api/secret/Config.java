package com.doupay.api.secret;

/* 直连商户配置 */
public class Config {
    /**
     * 商户号
     */
    public final static String MCHID = "";
    /**
     * appid
     */
    public final static String APPID = "";
    /**
     * 对称加密的密钥
     */
    public final static String ENCRYPT_KEY = "";
    /**
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



    /**** RSA 签名测试商户数据 START ***/

    public final static String RSA_MCHID = "";

    public final static String RSA_MERCHANT_SERIAL_NO = "";

    public final static String RSA_MERCHANT_PRIVATE_KEY ="-----BEGIN PRIVATE KEY-----\n" +
            "-----END PRIVATE KEY-----";

    public final static String RSA_PLATFORM_CERTIFICATE = "-----BEGIN CERTIFICATE-----\n" +
            "-----END CERTIFICATE-----";
    

    public final static String RSA_MERCHANT_ENCRYPT_KEY = "";
    
    /**** RSA 签名测试商户数据  END ***/

    /**** SM2 签名测试商户数据 START ***/
    public final static String SM2_MCHID = "";
    
    public final static String SM2_MERCHANT_SERIAL_NO = "";

    public final static String SM2_MERCHANT_PRIVATE_KEY = "-----BEGIN PRIVATE KEY-----\n" +
            "-----END PRIVATE KEY-----";

    public final static String SM2_PLATFORM_CERTIFICATE = "-----BEGIN CERTIFICATE-----\n" +
            "-----END CERTIFICATE-----";

    public final static String SM2_MERCHANT_ENCRYPT_KEY = "";

    /**** SM2 签名测试商户数据 START ***/


}
