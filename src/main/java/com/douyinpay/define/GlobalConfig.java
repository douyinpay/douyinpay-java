package com.douyinpay.define;

import com.douyinpay.exception.DouyinpayException;
import com.douyinpay.util.PemUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class GlobalConfig {

    private String mchId;//商户id

    /**
     * 签名算法类型，推荐：RSA
     */
    private String signType = "RSA";

    /**
     * 证书序列号
     */
    private String merchantSerialNumber;


    /**
     * 商户私钥；下面二者传任意一个就可以
     */
    private String privateKey;
    /**
     * 商户私钥路径
     */
    private String privateKeyPath;


    /**
     * 平台证书；下面二者传任意一个就可以
     */
    private String platformCertificate;

    /**
     * 平台证书路径
     */
    private String platformCertPath;


    /**
     * 敏感信息对称加密算法类型，推荐：AEAD-AES-256-GCM
     */
    private String encryptType = "AEAD-AES-256-GCM";

    /**
     * 敏感信息对称加密算法密钥
     */
    private String encryptKey;

    /**
     * 自定义HTTP Header
     */
    private Map<String, String> customHeaders;

    /**
     * 连接超时，单位：毫秒
     */
    private int connectTimeout = 3000;

    /**
     * 读取超时，单位：毫秒
     */
    private int readTimeout = 15000;


    private int writeTimeout = 15000;

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getPrivateKey() {
        return PemUtil.loadPrivateKeyBase64(privateKey);
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getEncryptType() {
        return encryptType;
    }

    public void setEncryptType(String encryptType) {
        this.encryptType = encryptType;
    }

    public String getEncryptKey() {
        return encryptKey;
    }

    public void setEncryptKey(String encryptKey) {
        this.encryptKey = encryptKey;
    }

    public Map<String, String> getCustomHeaders() {
        return customHeaders;
    }

    public void setCustomHeaders(Map<String, String> customHeaders) {
        this.customHeaders = customHeaders;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    public int getWriteTimeout() {
        return writeTimeout;
    }

    public void setWriteTimeout(int writeTimeout) {
        this.writeTimeout = writeTimeout;
    }

    public String getMerchantSerialNumber() {
        return merchantSerialNumber;
    }

    public void setMerchantSerialNumber(String merchantSerialNumber) {
        this.merchantSerialNumber = merchantSerialNumber;
    }

    public String getPlatformCertPath() {
        return platformCertPath;
    }

    public void setPlatformCertPath(String platformCertPath) {
        this.platformCertPath = platformCertPath;
    }

    public String getPlatformCertificate() {
        return platformCertificate;
    }

    public void setPlatformCertificate(String platformCertificate) {
        this.platformCertificate = platformCertificate;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getPrivateKeyPath() {
        return privateKeyPath;
    }


    public void setPrivateKeyPath(String privateKeyPath) {
        this.privateKeyPath = privateKeyPath;
    }


    /**
     * 实际使用的商户私钥
     *
     * @return
     */
    public String praticalPrivateKey() {
        if (StringUtils.isEmpty(privateKeyPath) && StringUtils.isEmpty(privateKey)) {
            throw new DouyinpayException("缺少私钥配置信息");
        }
        // 优先使用配置的私钥
        if (StringUtils.isNotEmpty(privateKey)) {
            return getPrivateKey();
        }

        return PemUtil.readPemPrivateKeyBase64(privateKeyPath);

    }

    public InputStream praticalCetificate() {
        if (StringUtils.isEmpty(platformCertificate) && StringUtils.isEmpty(platformCertPath)) {
            throw new DouyinpayException("缺少平台证书配置信息");
        }
        // 优先使用配置的证书
        if (StringUtils.isNotEmpty(platformCertificate)) {
            return new ByteArrayInputStream(platformCertificate.getBytes(StandardCharsets.UTF_8));
        }
        try (InputStream inputStream = Files.newInputStream(Paths.get(platformCertPath))) {
            return inputStream;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

    }

}
