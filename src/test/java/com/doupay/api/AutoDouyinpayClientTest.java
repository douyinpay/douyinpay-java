package com.doupay.api;

import com.doupay.api.secret.Config;
import com.douyinpay.api.DefaultDouyinpayClient;
import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.certificates.ApiCertificateService;
import com.douyinpay.api.certificates.models.DownCertificatesResponse;
import com.douyinpay.define.DomainName;
import com.douyinpay.exception.DouyinpayException;
import com.douyinpay.exception.ServiceException;
import org.junit.Test;

public class AutoDouyinpayClientTest {

    @Test
    public void SM2AutoClientDemo() {

        // 示例参数，实际使用时请自行初始化
        DouyinpayClient douyinpayClient = new DefaultDouyinpayClient.AutoSM2Builder()
                .mchId(Config.SM2_MCHID)
                .merchantSerialNumber(Config.SM2_MERCHANT_SERIAL_NO)
                .privateKey(Config.SM2_MERCHANT_PRIVATE_KEY)
                .encryptKey(Config.SM2_MERCHANT_ENCRYPT_KEY)
                .build();

        // 使用client 发起业务请求
        ApiCertificateService apiCertificateService = new ApiCertificateService.Builder()
                .douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
        try {
            DownCertificatesResponse resp = apiCertificateService.getPlatformCertificates();
            System.out.println(resp);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(), e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void RSAAutoClientDemo() {

        // 示例参数，实际使用时请自行初始化
        DouyinpayClient douyinpayClient = new DefaultDouyinpayClient.AutoRSABuilder()
                .mchId(Config.RSA_MCHID)
                .merchantSerialNumber(Config.RSA_MERCHANT_SERIAL_NO)
                .privateKey(Config.RSA_MERCHANT_PRIVATE_KEY)
                .encryptKey(Config.RSA_MERCHANT_ENCRYPT_KEY)
                .build();

        // 使用client 发起业务请求
        ApiCertificateService apiCertificateService = new ApiCertificateService.Builder()
                .douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
        try {
            DownCertificatesResponse resp = apiCertificateService.getPlatformCertificates();
            System.out.println(resp);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(), e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }


    }
}
