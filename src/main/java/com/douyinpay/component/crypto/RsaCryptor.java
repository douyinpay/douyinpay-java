package com.douyinpay.component.crypto;

import com.douyinpay.exception.DouyinpayException;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.Base64;

/**
 * RSA PKCS#1 v1.5 加解密器
 */
public class RsaCryptor implements ICryptor {

    private static final String RSA_ALGORITHM = "RSA";
    private static final String RSA_PKCS1_PADDING = "RSA/ECB/PKCS1Padding";
    private static final String PEM_TYPE_PUBLIC_KEY = "PUBLIC KEY";
    private static final String PEM_TYPE_RSA_PUBLIC_KEY = "RSA PUBLIC KEY";
    private static final String PEM_TYPE_CERTIFICATE = "CERTIFICATE";

    /**
     * 使用证书中的 RSA 公钥进行 PKCS#1 v1.5 加密，并返回 Base64 编码结果。
     *
     * @param plainText   待加密原文
     * @param certificate X509 证书
     * @return Base64 编码密文
     * @throws DouyinpayException 加密失败时抛出
     */
    @Override
    public String encrypt(String plainText, X509Certificate certificate) throws DouyinpayException {
        if (certificate == null) {
            throw new DouyinpayException("RSA加密证书不能为空");
        }
        return encrypt(plainText, certificate.getPublicKey());
    }

    /**
     * 参考官方文档实现 RSA PKCS#1 v1.5 私钥解密。
     *
     * @param ciphertext 待解密密文
     * @param privateKey RSA 私钥
     * @return 解密后的原文
     * @throws DouyinpayException 解密失败时抛出
     */
    @Override
    public String decrypt(String ciphertext, PrivateKey privateKey) throws DouyinpayException {
        if (StringUtils.isEmpty(ciphertext)) {
            throw new DouyinpayException("RSA解密密文不能为空");
        }
        if (privateKey == null) {
            throw new DouyinpayException("RSA解密私钥不能为空");
        }
        try {
            Cipher cipher = Cipher.getInstance(RSA_PKCS1_PADDING);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] data = Base64.getDecoder().decode(ciphertext);
            byte[] decryptedData = cipher.doFinal(data);
            return new String(decryptedData, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new DouyinpayException("RSA PKCS#1 v1.5 解密失败", e);
        }
    }

    private String encrypt(String plainText, PublicKey publicKey) throws DouyinpayException {
        try {
            Cipher cipher = Cipher.getInstance(RSA_PKCS1_PADDING);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] cipherData = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(cipherData);
        } catch (GeneralSecurityException e) {
            throw new DouyinpayException("RSA PKCS#1 v1.5 加密失败", e);
        }
    }
}
