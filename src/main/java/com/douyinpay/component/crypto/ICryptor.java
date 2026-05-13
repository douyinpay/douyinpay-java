package com.douyinpay.component.crypto;

import com.douyinpay.exception.DouyinpayException;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;

/**
 * 敏感字段加解密器
 */
public interface ICryptor {

    /**
     * 使用平台证书对敏感字段加密
     *
     * @param plainText   待加密原文
     * @param certificate 平台证书
     * @return Base64 编码密文
     * @throws DouyinpayException 加密失败时抛出
     */
    String encrypt(String plainText, X509Certificate certificate) throws DouyinpayException;

    /**
     * 使用私钥对敏感字段解密
     *
     * @param cipherText  待解密密文
     * @param privateKey  私钥
     * @return 解密后的原文
     * @throws DouyinpayException 解密失败时抛出
     */
    String decrypt(String cipherText, PrivateKey privateKey) throws DouyinpayException;
}
