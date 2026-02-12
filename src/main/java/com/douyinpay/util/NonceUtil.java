package com.douyinpay.util;

import java.security.SecureRandom;

/**
 * 随机数生成工具类
 */
public class NonceUtil {

    private static final String NONCE_CHAR =
            "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final SecureRandom random = new SecureRandom();

    /**
     * 生成随机数
     *
     * @param length 随机数长度
     * @return
     */
    public static String randomNonce(int length) {

        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < length; i++) {

            int index = random.nextInt(NONCE_CHAR.length());

            buffer.append(NONCE_CHAR.charAt(index));

        }

        return buffer.toString();

    }
}
