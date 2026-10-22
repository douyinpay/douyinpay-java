package com.douyinpay.api.indirectmerchant;

import com.douyinpay.api.DefaultDouyinpayClient;
import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.indirectmerchant.models.ApplyResponse;
import com.douyinpay.api.indirectmerchant.models.BindAppRequest;
import com.douyinpay.api.indirectmerchant.models.BindAppResponse;
import com.douyinpay.api.indirectmerchant.models.BusinessInfo;
import com.douyinpay.api.indirectmerchant.models.CancelApplyRequest;
import com.douyinpay.api.indirectmerchant.models.CertificateInfo;
import com.douyinpay.api.indirectmerchant.models.CreateApplyRequest;
import com.douyinpay.api.indirectmerchant.models.IdentificationInfo;
import com.douyinpay.api.indirectmerchant.models.Locator;
import com.douyinpay.api.indirectmerchant.models.ModifyRequest;
import com.douyinpay.api.indirectmerchant.models.QueryAppRequest;
import com.douyinpay.api.indirectmerchant.models.QueryAppResponse;
import com.douyinpay.api.indirectmerchant.models.QueryApplyRequest;
import com.douyinpay.api.indirectmerchant.models.QueryApplyResponse;
import com.douyinpay.api.indirectmerchant.models.QueryMerchantResponse;
import com.douyinpay.api.indirectmerchant.models.SubjectInfo;
import com.douyinpay.api.indirectmerchant.models.UploadResponse;
import com.douyinpay.define.Constants;
import com.douyinpay.define.DomainName;
import com.douyinpay.define.GlobalConfig;
import com.douyinpay.exception.DouyinpayException;
import com.douyinpay.exception.ServiceException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApiIndirectMerchantServiceTest {

    private static DouyinpayClient douyinpayClient;
    /**
     * 商户号
     */
    private final static String MCHID = "";
    /**
     * appid
     */
    private final static String APPID = "";
    /**
     * 对称加密的密钥
     */
    private final static String ENCRYPT_KEY = "";
    /**
     * 商户证书序列号
     */
    private final static String MERCHANT_SERIAL_NO = "";

    /**
     * 商户私钥
     */
    private final static String MERCHANT_PRIVATE_KEY = "";
    /**
     * 商户私钥路径
     */
    private final static String MERCHANT_PRIVATE_KEY_PATH = "";
    /**
     * 平台证书
     */
    private final static String PLATFORM_CERTIFICATE = "";
    /**
     * 平台证书路径
     */
    private final static String PLATFORM_CERTIFICATE_PATH = "";


    @Before
    public void init() {
        GlobalConfig globalConfig = new GlobalConfig();

        globalConfig.setMchId(MCHID);
        globalConfig.setEncryptKey(ENCRYPT_KEY);
        globalConfig.setEncryptType(Constants.ENCRYPT_TYPE_AES);
        globalConfig.setSignType(Constants.SIGN_TYPE_RSA);
        globalConfig.setMerchantSerialNumber(MERCHANT_SERIAL_NO);

        // 二选一即可
//        globalConfig.setPrivateKeyPath(MERCHANT_PRIVATE_KEY_PATH);
        globalConfig.setPrivateKey(MERCHANT_PRIVATE_KEY);

        //二选一即可,
        //globalConfig.setPlatformCertPath(PLATFORM_CERTIFICATE_PATH);
        globalConfig.setPlatformCertificate(PLATFORM_CERTIFICATE);


        Map<String, String> headerMap = new ConcurrentHashMap<>();

        globalConfig.setCustomHeaders(headerMap);

        douyinpayClient = new DefaultDouyinpayClient(globalConfig);
    }

    @Test
    public void testCreateApply() {
        ApiIndirectMerchantService service = new ApiIndirectMerchantService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();

        CreateApplyRequest request = new CreateApplyRequest();
        request.outIndirectMerchantId = "20434920032";
        request.outPaymentInstId = "4043424032";
        request.businessCode = "biz_6120241204339424";

        SubjectInfo subjectInfo = new SubjectInfo();
        subjectInfo.subjectType = "SUBJECT_TYPE_ENTERPRISE";
        CertificateInfo certificateInfo = new CertificateInfo();
        certificateInfo.certNo = "91110000000000000X";
        certificateInfo.merchantName = "示例科技有限公司";
        certificateInfo.certCopy = "media-cert-copy";
        certificateInfo.legalPersonName = "张三";
        subjectInfo.certificateInfo = certificateInfo;
        request.subjectInfo = subjectInfo;

        IdentificationInfo identificationInfo = new IdentificationInfo();
        identificationInfo.identificationType = "IDENTIFICATION_TYPE_IDCARD";
        identificationInfo.identificationName = "张三";
        identificationInfo.identificationNumber = "110101199001011234";
        request.identificationInfo = identificationInfo;

        BusinessInfo businessInfo = new BusinessInfo();
        businessInfo.merchantShortName = "示例商户";
        businessInfo.servicePhone = "4001234567";
        businessInfo.mcc = "1234";
        request.businessInfo = businessInfo;

        System.out.println(request);
        try {
            ApplyResponse response = service.createApply(request);
            System.out.println(response);
            Assert.assertNotNull(response);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(), e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testQueryApply() {
        ApiIndirectMerchantService service = new ApiIndirectMerchantService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();

        QueryApplyRequest request = new QueryApplyRequest();
        request.applymentId = "NIM7696048001306091521";
        System.out.println(request);
        try {
            QueryApplyResponse response = service.queryApply(request);
            System.out.println(response);
            Assert.assertNotNull(response);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(), e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testCancelApply() {
        ApiIndirectMerchantService service = new ApiIndirectMerchantService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();

        CancelApplyRequest request = new CancelApplyRequest();
        request.applymentId = "NIM7696048001306091521";
        System.out.println(request);
        try {
            service.cancelApply(request);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(), e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testQueryMerchant() {
        ApiIndirectMerchantService service = new ApiIndirectMerchantService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();

        Locator request = new Locator();
        request.indirectMerchantId = "6120241204339424";
        System.out.println(request);
        try {
            QueryMerchantResponse response = service.queryMerchant(request);
            System.out.println(response);
            Assert.assertNotNull(response);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(), e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testModifyMerchant() {
        ApiIndirectMerchantService service = new ApiIndirectMerchantService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();

        ModifyRequest request = new ModifyRequest();
        request.indirectMerchantId = "6120241204339424";
        request.merchantShortName = "示例商户";
        request.servicePhone = "4001234567";
        System.out.println(request);
        try {
            service.modifyMerchant(request);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(), e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testBindAppId() {
        ApiIndirectMerchantService service = new ApiIndirectMerchantService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();

        BindAppRequest request = new BindAppRequest();
        request.indirectMerchantId = "6120241204339424";
        request.appId = APPID;
        System.out.println(request);
        try {
            BindAppResponse response = service.bindAppId(request);
            System.out.println(response);
            Assert.assertNotNull(response);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(), e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testQueryAppId() {
        ApiIndirectMerchantService service = new ApiIndirectMerchantService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();

        QueryAppRequest request = new QueryAppRequest();
        request.indirectMerchantId = "6120241204339424";
        request.appId = APPID;
        System.out.println(request);
        try {
            QueryAppResponse response = service.queryAppId(request);
            System.out.println(response);
            Assert.assertNotNull(response);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(), e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testUpload() {
        ApiIndirectMerchantService service = new ApiIndirectMerchantService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();

        byte[] file = "fake-image-bytes".getBytes();
        try {
            UploadResponse response = service.upload("license.png", "image/png", file);
            System.out.println(response);
            Assert.assertNotNull(response);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(), e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }
}
