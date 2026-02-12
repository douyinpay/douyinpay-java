package com.douyinpay.api.notification;

import com.douyinpay.exception.DouyinpayException;
import com.douyinpay.util.GsonUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 用于解析通知的配置
 */
public class NotificationConfig {

    /**
     * 签名类型
     */
    private String signType;

    /**
     * 加密类型
     */
    private String cipherType;

    private String platformCertPath;//平台公钥证书路径

    /**
     * 敏感信息对称加密算法密钥
     */
    private String encryptKey;//敏感信息加密密钥


    private NotificationConfig(String signType, String cipherType, String platformCertPath, String encryptKey) {
        this.signType = signType;
        this.cipherType = cipherType;
        this.platformCertPath = platformCertPath;
        this.encryptKey = encryptKey;
    }

    public String getSignType() {
        return signType;
    }

    public String getCipherType() {
        return cipherType;
    }

    public String getPlatformCertPath() {
        return platformCertPath;
    }

    public String getEncryptKey() {
        return encryptKey;
    }

    public InputStream getCetificate() {
        if (StringUtils.isEmpty(platformCertPath)){
            throw new DouyinpayException("缺少平台证书配置信息");
        }

        try (InputStream inputStream = Files.newInputStream(Paths.get(platformCertPath))) {
            return inputStream;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

    }

    @Override
    public String toString() {
        return GsonUtil.getGson().toJson(this);
    }


    public static class Builder {

        private String signType;

        /**
         * 加密类型
         */
        private String cipherType;

        private String platformCertPath;//平台证书路径

        /**
         * 敏感信息对称加密算法密钥
         */
        private String encryptKey;//敏感信息加密密钥

        public NotificationConfig.Builder signType(String signType) {
            this.signType = signType;
            return this;
        }


        public NotificationConfig.Builder cipherType(String cipherType) {
            this.cipherType = cipherType;
            return this;
        }

        public NotificationConfig.Builder platformCertPath(String platformCertPath) {
            this.platformCertPath = platformCertPath;
            return this;
        }

        public NotificationConfig.Builder encryptKey(String encryptKey) {
            this.encryptKey = encryptKey;
            return this;
        }

        public NotificationConfig build() {
            return new NotificationConfig(signType, cipherType, platformCertPath, encryptKey);
        }
    }

}
