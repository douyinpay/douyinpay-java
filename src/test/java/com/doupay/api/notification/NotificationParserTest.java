package com.doupay.api.notification;

import com.doupay.api.secret.Config;
import com.douyinpay.api.notification.NotificationConfig;
import com.douyinpay.api.notification.NotificationParser;
import com.douyinpay.api.notification.RequestParam;
import com.douyinpay.component.crypto.AesEncryptor;
import com.douyinpay.component.crypto.RsaSigner;
import com.douyinpay.define.Constants;
import com.douyinpay.util.PemUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.security.PrivateKey;

public class NotificationParserTest {

    private static NotificationConfig config;
 


    private static final String body = "";
    private static final String data = "";
    @BeforeClass
    public static void init() {
        config = new NotificationConfig.Builder()
                .signType(Constants.SIGN_TYPE_RSA)
                .cipherType(Constants.ENCRYPT_TYPE_AES)
                .platformCertPath(Config.PLATFORM_CERTIFICATE_PATH)
                .encryptKey(Config.ENCRYPT_KEY)
                .build();
    }


    @Test
    public void TestParse() throws Exception{
        NotificationParser parser = new NotificationParser(config) ;
        String timeStamp = "";
        String nonce = "";
        String sign = "";
        RequestParam param = new RequestParam.Builder()
                .body(body)
                .signType(Constants.SIGN_TYPE_RSA)
                .signature(sign)
                .timestamp(timeStamp)
                .nonce(nonce)
                .serialNumber("")
                .build();
        String originData = parser.parse(param,String.class);
        System.out.println(originData);
        Assert.assertEquals(data,originData);
    }
}
