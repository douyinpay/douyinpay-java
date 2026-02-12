package com.douyinpay.util;


import com.douyinpay.define.Constants;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemWriter;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * pem格式证书解析
 */
public class PemUtil {

    /**
     * 从字符串中加载私钥。
     *
     * @param keyString 私钥字符串
     * @return 私钥base64
     */
    public static String loadPrivateKeyBase64(String keyString) {
        keyString =
                keyString
                        .replace("-----BEGIN PRIVATE KEY-----", "")
                        .replace("-----END PRIVATE KEY-----", "")
                        .replaceAll("\\s+", "");
        return keyString;
    }

    public static String loadPublicKeyBase64(String publicKeyString) {
        publicKeyString =
                publicKeyString
                        .replace("-----BEGIN PUBLIC KEY-----", "")
                        .replace("-----END PUBLIC KEY-----", "")
                        .replaceAll("\\s+", "");
        return publicKeyString;
    }

    /**
     * 加载x509证书。
     *
     * @param keyString x509证书
     * @return base64
     */
    public static String loadX509Base64(String keyString) {
        keyString =
                keyString
                        .replace("-----BEGIN CERTIFICATE-----", "")
                        .replace("-----END CERTIFICATE-----", "")
                        .replaceAll("\\s+", "");
        return keyString;
    }


    /**
     * 读取pem字符串
     *
     * @param keyPath 私钥路径
     * @return 私钥
     */
    private static String readPemFromPath(String keyPath) {
        try (FileInputStream inputStream = new FileInputStream(keyPath)) {
            return new String(IOUtil.toByteArray(inputStream), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * 读取私钥base64字符串
     *
     * @param path 私钥pem路径
     * @return base64串
     */
    public static String readPemPrivateKeyBase64(String path) {
        String content = readPemFromPath(path);

        return loadPrivateKeyBase64(content);

    }

    /**
     * 公钥x509格式证书读取
     *
     * @param path 证书path
     * @return base64串
     */
    public static String readX509Base64(String path) {
        String content = readPemFromPath(path);

        return loadX509Base64(content);

    }

    public static String getSerialNumber(X509Certificate certificate) {
        return certificate.getSerialNumber().toString(Constants.HEX).toUpperCase();
    }

    /**
     * 从字符串加载X.509证书
     *
     * @param certificateString 证书字符串
     * @return X.509证书
     */

    public static X509Certificate loadX509FromString(String certificateString) {
        try (ByteArrayInputStream inputStream =
                     new ByteArrayInputStream(certificateString.getBytes(StandardCharsets.UTF_8))) {
            return loadX509CertificateFromStream(inputStream);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static X509Certificate loadX509CertificateFromStream(InputStream inputStream) {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(inputStream);
        } catch (CertificateException e) {
            throw new IllegalArgumentException("公钥证书解析失败", e);
        }
    }


    public static X509Certificate loadSMX509FromString(String certificateString) {
        try (ByteArrayInputStream inputStream =
                     new ByteArrayInputStream(certificateString.getBytes(StandardCharsets.UTF_8))) {
            return loadSMX509CertificateFromStream(inputStream);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static X509Certificate loadSMX509CertificateFromStream(InputStream inputStream) {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X.509", "BC").generateCertificate(inputStream);
        } catch (CertificateException e) {
            throw new IllegalArgumentException("公钥证书解析失败", e);
        } catch (NoSuchProviderException e) {
            throw new RuntimeException(e);
        }
    }


}


  