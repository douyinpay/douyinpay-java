package com.douyinpay.component.crypto;

import com.douyinpay.define.Constants;
import com.douyinpay.exception.DouyinpayException;
import com.douyinpay.component.certificate.CertificateProvider;

public class VerifierFactory {
    public static IVerifier getByName(String type) throws DouyinpayException {
        if (Constants.SIGN_TYPE_RSA.equals(type)) {
            return new RsaVerifier();
        }
        if (Constants.SIGN_TYPE_SM2.equals(type)) {
            return new Sm2Verifier();
        }
        throw new DouyinpayException(String.format("无效的签名算法:[%s]，目前仅支持：RSA和SM2。", type));
    }

    public static IVerifier getByName(String type, CertificateProvider provider) throws DouyinpayException {
        if (Constants.SIGN_TYPE_RSA.equals(type)) {
            return new AutoRsaVerifier(provider);
        }
        if (Constants.SIGN_TYPE_SM2.equals(type)) {
            return new AutoSm2Verifier(provider);
        }
        throw new DouyinpayException(String.format("无效的签名算法:[%s]，目前仅支持：RSA和SM2。", type));
    }
}
