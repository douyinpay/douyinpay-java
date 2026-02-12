package com.douyinpay.component.crypto;

import com.douyinpay.exception.DouyinpayException;

/**
 * 非对称加密算法
 */
public interface ISymmetricCrypto {

    /**
     * 对称加密
     *
     * @param plainText      原文
     * @param symmKey        对称密钥
     * @param iv_nonce       iv随机数
     * @param associatedData AAD，额外的认证加密数据，可以为空
     * @return base64密文
     * @throws DouyinpayException
     */
    public String encrypt(String plainText, String symmKey, String iv_nonce, String associatedData) throws DouyinpayException;

    /**
     * 解密
     *
     * @param ciphertext     密文
     * @param symmKey        对称密钥
     * @param iv_nonce       随机数
     * @param associatedData AAD，额外的认证加密数据，可以为空
     * @return 原文
     * @throws DouyinpayException
     */
    public String decrypt(String ciphertext, String symmKey, String iv_nonce, String associatedData) throws DouyinpayException;

}
