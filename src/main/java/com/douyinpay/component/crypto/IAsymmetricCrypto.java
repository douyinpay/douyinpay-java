package com.douyinpay.component.crypto;

import com.douyinpay.exception.DouyinpayException;

import java.io.InputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;

/**
 * 非对称加密算法
 */
public interface IAsymmetricCrypto {

    public String getSignAlgorithmName();

    /**
     * 计算签名
     *
     * @param plainText  原文
     * @param privateKey 私钥
     * @return 签名字符串
     * @throws DouyinpayException
     */
    public String sign(String plainText, PrivateKey privateKey) throws DouyinpayException;


    /**
     * 加载私钥
     *
     * @param privateKeyBase64 私钥base64字符串
     * @return 私钥
     * @throws DouyinpayException
     */

    public PrivateKey loadPrivateKey(String privateKeyBase64) throws DouyinpayException;



    /**
     * 加载证书
     *
     * @param inputStream 证书数据流
     * @return x509证书
     */
    public X509Certificate loadX509Certificate(InputStream inputStream);

    /**
     * 解析公钥
     *
     * @param keyBase64 公钥base64
     * @return 公钥
     */
    public PublicKey convertX509PublicKey(String keyBase64);


}
