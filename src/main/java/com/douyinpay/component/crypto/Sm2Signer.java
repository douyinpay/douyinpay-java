package com.douyinpay.component.crypto;

import com.douyinpay.define.Constants;
import com.douyinpay.exception.DouyinpayException;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.asn1.gm.GMObjectIdentifiers;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * 默认sm2签名
 */
public class Sm2Signer implements IAsymmetricCrypto {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }


    public String getSignAlgorithm() {
        return GMObjectIdentifiers.sm2sign_with_sm3.toString();
    }

    @Override
    public String getSignAlgorithmName() {
        return Constants.SIGN_TYPE_SM2;
    }

    @Override
    public String sign(String plainText, PrivateKey privateKey) throws DouyinpayException {


        if (StringUtils.isEmpty(plainText)) {
            throw new DouyinpayException("SM2待签名内容不能为空");
        }

        if (privateKey == null) {
            throw new DouyinpayException("Sm2私钥[privateKey]不能为空");
        }

        try {
            Signature sign = Signature.getInstance(getSignAlgorithm());
            sign.initSign(privateKey);
            sign.update(plainText.getBytes(StandardCharsets.UTF_8));

            return Base64.getEncoder().encodeToString(sign.sign());
        } catch (NoSuchAlgorithmException e) {
            throw new DouyinpayException("当前环境不支持Sm2withSm3签名算法", e);
        } catch (InvalidKeyException e) {
            throw new DouyinpayException("非法的SM2公钥", e);
        } catch (SignatureException e) {
            throw new DouyinpayException("SM2数据签名失败", e);
        }
    }

 

    public PrivateKey loadPrivateKey(String privateKeyBase64) throws DouyinpayException {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(Constants.SIGN_KEY_EC);
            byte[] privateByte = Base64.getDecoder().decode(privateKeyBase64);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateByte);
            return keyFactory.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new DouyinpayException("当前环境不支持Sm2解析", e);
        } catch (InvalidKeySpecException e) {
            throw new DouyinpayException("SM2无效的私钥", e);
        }
    }

    @Override
    public X509Certificate loadX509Certificate(InputStream inputStream) {
        try {
            return (X509Certificate)
                    CertificateFactory.getInstance("X.509", "BC").generateCertificate(inputStream);
        } catch (CertificateException e) {
            throw new RuntimeException("公钥证书解析失败", e);
        } catch (NoSuchProviderException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public PublicKey convertX509PublicKey(String keyBase64) {
        try {
            byte[] pbBytes = Base64.getDecoder().decode(keyBase64);
            return KeyFactory.getInstance(Constants.SIGN_KEY_EC).generatePublic(new X509EncodedKeySpec(pbBytes));
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
