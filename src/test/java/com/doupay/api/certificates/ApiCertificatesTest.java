package com.doupay.api.certificates;

import com.doupay.api.secret.Config;
import com.douyinpay.api.DefaultDouyinpayClient;
import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.certificates.ApiCertificateService;
import com.douyinpay.api.certificates.models.DownCertificatesResponse;
import com.douyinpay.define.Constants;
import com.douyinpay.define.DomainName;
import com.douyinpay.define.GlobalConfig;
import com.douyinpay.exception.DouyinpayException;
import com.douyinpay.exception.ServiceException;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class ApiCertificatesTest {

    private static DouyinpayClient douyinpayClient;

    @BeforeClass
    public static void init() {
        GlobalConfig globalConfig = new GlobalConfig();

        globalConfig.setEncryptKey(Config.ENCRYPT_KEY);
        globalConfig.setEncryptType(Constants.ENCRYPT_TYPE_AES);
        // 二选一即可
        // globalConfig.setPrivateKeyPath(MERCHANT_PRIVATE_KEY_PATH);
        //二选一即可,
        // globalConfig.setPlatformCertPath(PLATFORM_CERTIFICATE_PATH);

        // RSA 配置
        globalConfig.setMchId(Config.RSA_MCHID);
        globalConfig.setSignType(Constants.SIGN_TYPE_RSA);
        globalConfig.setMerchantSerialNumber(Config.RSA_MERCHANT_SERIAL_NO);
        globalConfig.setPrivateKey(Config.RSA_MERCHANT_PRIVATE_KEY);
        globalConfig.setPlatformCertificate(Config.RSA_PLATFORM_CERTIFICATE);
        globalConfig.setEncryptKey(Config.RSA_MERCHANT_ENCRYPT_KEY);

        // SM2 配置
        // globalConfig.setMchId(Config.SM2_MCHID);
        // globalConfig.setSignType(Constants.SIGN_TYPE_SM2);
        // globalConfig.setMerchantSerialNumber(Config.SM2_MERCHANT_SERIAL_NO);
        // globalConfig.setPrivateKey(Config.SM2_MERCHANT_PRIVATE_KEY);
        // globalConfig.setPlatformCertificate(Config.SM2_PLATFORM_CERTIFICATE);
//        globalConfig.setEncryptKey(Config.SM2_MERCHANT_ENCRYPT_KEY);


        Map<String, String> headerMap = new ConcurrentHashMap<>();

        globalConfig.setCustomHeaders(headerMap);

        douyinpayClient = new DefaultDouyinpayClient(globalConfig);
    }

    @Test
    public void TestGetPlatformCertificates(){
        ApiCertificateService apiCertificateService = new ApiCertificateService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
        try {
            DownCertificatesResponse resp = apiCertificateService.getPlatformCertificates();
            System.out.println(resp);
        }catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n",e.getErrorCode(),e.getErrorMessage(),e.getResponseBody());
        }catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
