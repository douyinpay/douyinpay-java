package com.douyinpay.api;

public interface DouyinpayClient {

    public final String ClientVersion = "JAVA-v1.0.13";

    /**
     * 发送HTTP请求
     *
     * @param request       HTTP请求
     * @param responseClass 业务返回类的Class对象，如果不确定业务返回类型，或该请求没有返回体，可以传入Object.class
     * @param <T>           由Class对象建模的类的类型
     * @return HTTP返回
     */
    <T> DouyinpayResponse<T> execute(DouyinpayRequest request, Class<T> responseClass);

    /**
     * Executes an upload request. Implementations that do not support uploads
     * may retain the default failure.
     */
    default <T> DouyinpayResponse<T> executeMultipart(DouyinpayMultipartRequest request, Class<T> responseClass) {
        throw new UnsupportedOperationException("multipart request is not supported");
    }

    /**
     * 使用抖音支付平台证书公钥对上送的敏感字段进行 RSA PKCS#1 v1.5 加密，返回 Base64 编码密文。
     *
     * <p>敏感字段加解密说明：
     * https://partner.douyinpay.com/wiki/662b13c27bbf8802fade4b4e/6809e6ecc10e9e05e71f6f1e
     *
     * @param plainText 待加密原文
     * @return Base64 编码密文
     */
    default String encryptSensitive(String plainText) {
        throw new UnsupportedOperationException("sensitive field encryption is not supported");
    }

    /**
     * 使用服务商私钥对下行的敏感字段密文进行 RSA PKCS#1 v1.5 解密，返回原文。
     *
     * <p>敏感字段加解密说明：
     * https://partner.douyinpay.com/wiki/662b13c27bbf8802fade4b4e/6809e6ecc10e9e05e71f6f1e
     *
     * @param cipherText Base64 编码密文
     * @return 解密后的原文
     */
    default String decryptSensitive(String cipherText) {
        throw new UnsupportedOperationException("sensitive field decryption is not supported");
    }
}
