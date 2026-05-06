package com.douyinpay.component.crypto;

import com.douyinpay.exception.DouyinpayException;

import java.security.cert.X509Certificate;

/**
 * 敏感字段加密器抽象类
 */
public abstract class Encryptor {

    /**
     * 使用平台证书对敏感字段加密
     *
     * @param plainText   待加密原文
     * @param certificate 平台证书
     * @return Base64 编码密文
     * @throws DouyinpayException 加密失败时抛出
     */
    public abstract String encrypt(String plainText, X509Certificate certificate) throws DouyinpayException;
}
