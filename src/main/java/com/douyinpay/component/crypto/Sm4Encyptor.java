package com.douyinpay.component.crypto;

import com.douyinpay.exception.DouyinpayException;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.util.Base64;

/**
 * sm4国密加密
 */
public class Sm4Encyptor implements ISymmetricCrypto {
    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    static final int KEY_LENGTH_BYTE = 16;
    static final String SM4_CBC_PADDING = "SM4/CBC/PKCS5Padding";
    static final String ALGORITHM_SM4 = "SM4";

    @Override
    public String encrypt(String plainText, String symmKey, String iv_nonce, String associatedData) throws DouyinpayException {

        if (StringUtils.isEmpty(plainText)) {
            throw new DouyinpayException("sm4加密原文不能为空");
        }
        if (StringUtils.isEmpty(symmKey)) {
            throw new DouyinpayException("sm4加密对称密钥不能为空");
        }
        if (StringUtils.isEmpty(iv_nonce)) {
            throw new DouyinpayException("sm4加密iv_nonce不能为空");

        }


        try {

            byte[] keyBytes = symmKey.getBytes();


            if (keyBytes.length != KEY_LENGTH_BYTE) {
                throw new DouyinpayException("无效的sm4 Key，长度必须为32个字节");
            }

            Cipher cipher = generateCbcCipher(SM4_CBC_PADDING, Cipher.ENCRYPT_MODE, keyBytes, iv_nonce.getBytes());

            if (StringUtils.isNotEmpty(associatedData)) {
                cipher.updateAAD(associatedData.getBytes());
            }

            return Base64.getEncoder().encodeToString(cipher.doFinal(plainText.getBytes()));

        } catch (Exception e) {
            throw new DouyinpayException("sm4加密失败", e);
        }
    }

    @Override
    public String decrypt(String ciphertext, String symmKey, String iv_nonce, String associatedData) throws DouyinpayException {

        if (StringUtils.isEmpty(ciphertext)) {
            throw new DouyinpayException("sm4加密密文不能为空");
        }
        if (StringUtils.isEmpty(symmKey)) {
            throw new DouyinpayException("sm4加密对称密钥不能为空");
        }
        if (StringUtils.isEmpty(iv_nonce)) {
            throw new DouyinpayException("sm4加密iv_nonce不能为空");
        }

        try {

            byte[] keyBytes = symmKey.getBytes();

            if (keyBytes.length != KEY_LENGTH_BYTE) {
                throw new IllegalArgumentException("无效的sm4 Key，长度必须为32个字节");
            }

            Cipher cipher = generateCbcCipher(SM4_CBC_PADDING, Cipher.DECRYPT_MODE, keyBytes, iv_nonce.getBytes());

            if (StringUtils.isNotEmpty(associatedData)) {
                cipher.updateAAD(associatedData.getBytes());
            }
            return new String(cipher.doFinal(Base64.getDecoder().decode(ciphertext)));
        } catch (Exception e) {
            throw new DouyinpayException("aes加密失败", e);
        }
    }

    private Cipher generateCbcCipher(String algorithmName, int mode, byte[] key, byte[] iv)
            throws InvalidKeyException, InvalidAlgorithmParameterException, NoSuchAlgorithmException,
            NoSuchProviderException, NoSuchPaddingException {
        Cipher cipher = Cipher.getInstance(algorithmName, BouncyCastleProvider.PROVIDER_NAME);
        Key sm4Key = new SecretKeySpec(key, ALGORITHM_SM4);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
        cipher.init(mode, sm4Key, ivParameterSpec);
        return cipher;
    }

}
