package com.douyinpay.define;

/**
 * 常量
 */
public class Constants {

    public static final String SIGN_TYPE_RSA = "RSA";
    public static final String SIGN_TYPE_SM2 = "SM2";
    public static final String SIGN_PROVIDER_SM2 = "BC";
    public static final String SIGN_KEY_EC = "EC";//签名key算法


    public static final String ENCRYPT_TYPE_AES = "AEAD-AES-256-GCM";
    public static final String ENCRYPT_TYPE_SM4 = "SM4";
    public static final String SIGN_SHA256RSA_ALGORITHMS = "SHA256WithRSA";
    public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

    public static final String AUTHORIZATION = "Authorization";

    public static final String APPLICATION_JSON = "application/json; charset=utf-8";

    public static final String ACCEPT = "Accept";
    public static final String CONTENT_TYPE = "Content-Type";

    public static final String DOUYIN_REQUEST_ID = "Request-Id";
    public static final String DOUYIN_PAY_SERIAL = "Douyinpay-Serial";
    public static final String DOUYIN_PAY_SIGNATURE = "Douyinpay-Signature";
    public static final String DOUYIN_PAY_TIMESTAMP = "Douyinpay-Timestamp";
    public static final String DOUYIN_PAY_NONCE = "Douyinpay-Nonce";

    public static final String DOUYIN_PAY_SDK_AGENT = "Douyinpay-Sdk-Agent"; // Header 中的 Douyinpay-Sdk-Agent 字段


    public static final int HEX = 16;

    public static final String VERIFY_RESPONSE_SIGNATURE_FORAMT = "%s\n%s\n%s\n";


}
