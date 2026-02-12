package com.douyinpay.component.crypto;

import com.douyinpay.define.Constants;
import com.douyinpay.exception.DouyinpayException;

/**
 * 签名工厂类
 */
public class AsymmetricFactory {

    public static IAsymmetricCrypto getByName(String type) throws DouyinpayException {
        if (Constants.SIGN_TYPE_RSA.equals(type)) {
            return new RsaSigner();
        }
        if (Constants.SIGN_TYPE_SM2.equals(type)) {
            return new Sm2Signer();
        }

        throw new DouyinpayException(String.format("无效的签名算法:[%s]，目前仅支持：RSA和SM2。", type));
    }

}
