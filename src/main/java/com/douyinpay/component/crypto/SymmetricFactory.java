package com.douyinpay.component.crypto;

import com.douyinpay.define.Constants;
import com.douyinpay.exception.DouyinpayException;

/**
 * 对称算法工厂
 */
public class SymmetricFactory {

    public static ISymmetricCrypto getByName(String type) throws DouyinpayException {
        if (Constants.ENCRYPT_TYPE_AES.equals(type)) {
            return new AesEncryptor();
        }
        if (Constants.ENCRYPT_TYPE_SM4.equals(type)) {
            return new Sm4Encyptor();
        }

        throw new DouyinpayException(String.format("无效的对称加密算法:[%s]，目前仅支持：AES和SM4。", type));
    }
}
