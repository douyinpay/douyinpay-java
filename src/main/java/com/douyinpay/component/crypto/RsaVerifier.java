package com.douyinpay.component.crypto;

import com.douyinpay.exception.DouyinpayException;

import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Base64;

public class RsaVerifier implements IVerifier {


    @Override
    public boolean verifyPlatformSign(String plainText, X509Certificate platformCertificate, String sign, String serialNumber) throws DouyinpayException {
        if (platformCertificate == null) {
            throw new DouyinpayException("平台证书不能为空");
        }
        String serial = com.douyinpay.util.PemUtil.getSerialNumber(platformCertificate);
        if (!serial.equals(serialNumber)) {
            throw new DouyinpayException(String.format("response serialNo[%s] not equal platformCertificate serialNo[%s]", serialNumber, serial));
        }
        return verify(plainText, platformCertificate.getPublicKey(), sign);
    }

    protected boolean verify(String plainText, PublicKey publicKey, String sign) throws DouyinpayException {
        if (plainText == null || plainText.isEmpty()) {
            throw new DouyinpayException("RSA签名原文[plainText]不能为空");
        }
        if (publicKey == null) {
            throw new DouyinpayException("RSA公钥[publicKey]不能为空");
        }
        if (sign == null || sign.isEmpty()) {
            throw new DouyinpayException("RSA待验证的签名[sign]不能为空");
        }
        try {
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify(publicKey);
            signature.update(plainText.getBytes(StandardCharsets.UTF_8));
            return signature.verify(Base64.getDecoder().decode(sign));
        } catch (SignatureException e) {
            throw new DouyinpayException("RSA签名失败", e);
        } catch (InvalidKeyException e) {
            throw new DouyinpayException("rsa verify uses an illegal certificate.", e);
        } catch (NoSuchAlgorithmException e) {
            throw new DouyinpayException("The current Java environment does not support SHA256withRSA", e);
        }
    }
}
