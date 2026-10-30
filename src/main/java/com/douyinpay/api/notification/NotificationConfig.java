package com.douyinpay.api.notification;

import com.douyinpay.exception.DouyinpayException;
import com.douyinpay.util.GsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 用于解析通知的配置
 */
public class NotificationConfig {

    private static final Logger logger = LoggerFactory.getLogger(NotificationConfig.class);
    private static final int DEFAULT_MAX_CLOCK_OFFSET_SECONDS = 300;
    private int maxClockOffsetSeconds = DEFAULT_MAX_CLOCK_OFFSET_SECONDS;

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

    /**
     * 回调时间戳与本机时间允许的最大偏差，单位：秒，默认 300 秒。
     *
     * @return 最大时间偏差
     */
    public int getMaxClockOffsetSeconds() {
        return maxClockOffsetSeconds;
    }

    public InputStream getCetificate() {
        if (StringUtils.isEmpty(platformCertPath)) {
            throw new DouyinpayException("缺少平台证书配置信息");
        }

        try {
            byte[] bytes = Files.readAllBytes(Paths.get(platformCertPath));
            return new ByteArrayInputStream(bytes);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

    }

    @Override
    public String toString() {
        return GsonUtil.getGson().toJson(this);
    }


    public static class Builder {

        private int maxClockOffsetSeconds = DEFAULT_MAX_CLOCK_OFFSET_SECONDS;

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

        /**
         * 设置回调时间戳允许的最大偏差。非正数回退到默认值，不关闭时间校验。
         *
         * @param maxClockOffsetSeconds 最大时间偏差，单位：秒
         * @return 当前构造器
         */
        public NotificationConfig.Builder maxClockOffsetSeconds(int maxClockOffsetSeconds) {
            if (maxClockOffsetSeconds <= 0) {
                logger.warn("callback timestamp tolerance must be positive; using {} seconds",
                        DEFAULT_MAX_CLOCK_OFFSET_SECONDS);
                this.maxClockOffsetSeconds = DEFAULT_MAX_CLOCK_OFFSET_SECONDS;
            } else {
                this.maxClockOffsetSeconds = maxClockOffsetSeconds;
            }
            return this;
        }

        public NotificationConfig build() {
            NotificationConfig config = new NotificationConfig(signType, cipherType, platformCertPath, encryptKey);
            config.maxClockOffsetSeconds = maxClockOffsetSeconds;
            return config;
        }
    }

}
