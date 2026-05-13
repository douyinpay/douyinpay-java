package com.douyinpay.component.crypto;

import com.douyinpay.define.Constants;
import com.douyinpay.exception.DouyinpayException;

/**
 * 敏感字段加解密器工厂
 */
public class CryptorFactory {

    public static ICryptor getByName(String type) throws DouyinpayException {
        if (Constants.SIGN_TYPE_RSA.equals(type)) {
            return new RsaCryptor();
        }

        throw new DouyinpayException(String.format("无效的敏感字段加密算法:[%s]，目前仅支持：RSA。", type));
    }
}
