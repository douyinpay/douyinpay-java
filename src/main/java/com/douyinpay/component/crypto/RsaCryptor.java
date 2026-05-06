package com.douyinpay.component.crypto;

import com.douyinpay.exception.DouyinpayException;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.asn1.pkcs.RSAPublicKey;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;

import javax.crypto.Cipher;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
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
     * 使用 RSA PKCS#1 v1.5 算法加密文本，并返回 Base64 编码结果。
     *
     * @param plainText 待加密原文
     * @param keyPem    PEM 格式公钥或证书
     * @return Base64 编码密文
     * @throws DouyinpayException 加密失败时抛出
     */
    public String encrypt(String plainText, String keyPem) throws DouyinpayException {
        if (StringUtils.isEmpty(plainText)) {
            throw new DouyinpayException("RSA加密原文不能为空");
        }
        if (StringUtils.isEmpty(keyPem)) {
            throw new DouyinpayException("RSA加密公钥或证书不能为空");
        }

        PublicKey publicKey = parseRSAPublicKey(keyPem);
        return encrypt(plainText, publicKey);
    }

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

    /**
     * 解析 PEM 中的 RSA 公钥，兼容 PUBLIC KEY / RSA PUBLIC KEY / CERTIFICATE。
     *
     * @param keyPem PEM 字符串
     * @return RSA 公钥
     * @throws DouyinpayException 解析失败时抛出
     */
    public PublicKey parseRSAPublicKey(String keyPem) throws DouyinpayException {
        try (PemReader pemReader = new PemReader(new StringReader(keyPem))) {
            PemObject pemObject = pemReader.readPemObject();
            if (pemObject == null) {
                throw new DouyinpayException("PEM解析失败");
            }

            String type = pemObject.getType();
            byte[] content = pemObject.getContent();
            KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);

            if (PEM_TYPE_PUBLIC_KEY.equals(type)) {
                return keyFactory.generatePublic(new X509EncodedKeySpec(content));
            }

            if (PEM_TYPE_RSA_PUBLIC_KEY.equals(type)) {
                RSAPublicKey rsaPublicKey = RSAPublicKey.getInstance(content);
                RSAPublicKeySpec publicKeySpec = new RSAPublicKeySpec(rsaPublicKey.getModulus(), rsaPublicKey.getPublicExponent());
                return keyFactory.generatePublic(publicKeySpec);
            }

            if (PEM_TYPE_CERTIFICATE.equals(type)) {
                Certificate certificate = CertificateFactory.getInstance("X.509")
                        .generateCertificate(new ByteArrayInputStream(content));
                PublicKey publicKey = certificate.getPublicKey();
                if (!RSA_ALGORITHM.equalsIgnoreCase(publicKey.getAlgorithm())) {
                    throw new DouyinpayException("证书中的公钥不是RSA类型");
                }
                return publicKey;
            }

            throw new DouyinpayException(String.format("不支持的PEM类型: %s", type));
        } catch (IOException e) {
            throw new DouyinpayException("PEM读取失败", e);
        } catch (GeneralSecurityException e) {
            throw new DouyinpayException("RSA公钥解析失败", e);
        } catch (IllegalArgumentException e) {
            throw new DouyinpayException("RSA公钥解析失败", e);
        }
    }
}
