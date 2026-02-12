package com.douyinpay.component.crypto;

import com.douyinpay.exception.DouyinpayException;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * aes加密
 */
public class AesEncryptor implements ISymmetricCrypto {

    static final int KEY_LENGTH_BYTE = 32;
    static final int TAG_LENGTH_BIT = 128;

    @Override
    public String encrypt(String plainText, String symmKey, String iv_nonce,String associatedData) throws DouyinpayException {

        if (StringUtils.isEmpty(plainText)) {
            throw new DouyinpayException("aes加密原文不能为空");
        }
        if (StringUtils.isEmpty(symmKey)) {
            throw new DouyinpayException("aes加密对称密钥不能为空");
        }
        if (StringUtils.isEmpty(iv_nonce)) {
            throw new DouyinpayException("aes加密iv_nonce不能为空");
        }

        try {

            byte[] keyBytes = symmKey.getBytes();

            if (keyBytes.length != KEY_LENGTH_BYTE) {
                throw new DouyinpayException("无效的aes Key，长度必须为32个字节");
            }


            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, new SecretKeySpec(keyBytes, "AES"), new GCMParameterSpec(TAG_LENGTH_BIT, iv_nonce.getBytes()));

            if (StringUtils.isNotEmpty(associatedData)) {
                cipher.updateAAD(associatedData.getBytes());
            }


            return Base64.getEncoder().encodeToString(cipher.doFinal(plainText.getBytes()));


        } catch (InvalidKeyException | InvalidAlgorithmParameterException | BadPaddingException |
                 IllegalBlockSizeException | NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new DouyinpayException("aes解密失败", e);
        }
    }

    @Override
    public String decrypt(String ciphertext, String symmKey, String iv_nonce,String associatedData) throws DouyinpayException {

        if (StringUtils.isEmpty(ciphertext)) {
            throw new DouyinpayException("aes加密密文不能为空");
        }
        if (StringUtils.isEmpty(symmKey)) {
            throw new DouyinpayException("aes加密对称密钥不能为空");
        }
        if (StringUtils.isEmpty(iv_nonce)) {
            throw new DouyinpayException("aes加密iv_nonce不能为空");
        }

        try {

            byte[] keyBytes = symmKey.getBytes();

            if (keyBytes.length != KEY_LENGTH_BYTE) {
                throw new IllegalArgumentException("无效的aes Key，长度必须为32个字节");
            }

            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");

            SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
            GCMParameterSpec spec = new GCMParameterSpec(TAG_LENGTH_BIT, iv_nonce.getBytes());

            cipher.init(Cipher.DECRYPT_MODE, key, spec);

            if (StringUtils.isNotEmpty(associatedData)) {
                cipher.updateAAD(associatedData.getBytes());
            }

            return new String(cipher.doFinal(Base64.getDecoder().decode(ciphertext)));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException |
                 InvalidKeyException | InvalidAlgorithmParameterException e) {
            throw new DouyinpayException("aes解密失败", e);
        }
    }
}
