package com.doupay.api.splitfund;

import com.douyinpay.api.DefaultDouyinpayClient;
import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.splitfund.ApiSplitFundPaymentsService;
import com.douyinpay.api.splitfund.models.ApiAddSplitReceiverRequest;
import com.douyinpay.api.splitfund.models.ApiAddSplitReceiverResponse;
import com.douyinpay.api.splitfund.models.ApiDeleteSplitReceiverRequest;
import com.douyinpay.api.splitfund.models.ApiDeleteSplitReceiverResponse;
import com.douyinpay.api.splitfund.models.ApiFinishSplitFundRequest;
import com.douyinpay.api.splitfund.models.ApiFinishSplitFundResponse;
import com.douyinpay.api.splitfund.models.ApiQuerySplitFundRequest;
import com.douyinpay.api.splitfund.models.ApiQuerySplitFundResponse;
import com.douyinpay.api.splitfund.models.ApiQueryReturnSplitFundRequest;
import com.douyinpay.api.splitfund.models.ApiQueryReturnSplitFundResponse;
import com.douyinpay.api.splitfund.models.ApiQueryUnSplitFundRequest;
import com.douyinpay.api.splitfund.models.ApiQueryUnSplitFundResponse;
import com.douyinpay.api.splitfund.models.ApiReturnSplitFundRequest;
import com.douyinpay.api.splitfund.models.ApiReturnSplitFundResponse;
import com.douyinpay.api.splitfund.models.ApiSplitFundRequest;
import com.douyinpay.api.splitfund.models.ApiSplitFundResponse;
import com.douyinpay.api.splitfund.models.ReceiverInfoDto;
import com.douyinpay.define.Constants;
import com.douyinpay.define.DomainName;
import com.douyinpay.define.GlobalConfig;
import com.douyinpay.exception.DouyinpayException;
import com.douyinpay.exception.ServiceException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApiSplitFundPaymentsServiceTest {

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

    @BeforeClass
    public static void init() {
        GlobalConfig globalConfig = new GlobalConfig();

        globalConfig.setMchId(MCHID);
        globalConfig.setEncryptKey(ENCRYPT_KEY);
        globalConfig.setEncryptType(Constants.ENCRYPT_TYPE_AES);
        globalConfig.setSignType(Constants.SIGN_TYPE_RSA);
        globalConfig.setMerchantSerialNumber(MERCHANT_SERIAL_NO);

        // 二选一即可
        globalConfig.setPrivateKeyPath(MERCHANT_PRIVATE_KEY_PATH);
        // globalConfig.setPrivateKey(MERCHANT_PRIVATE_KEY);

        // 二选一即可,
        globalConfig.setPlatformCertPath(PLATFORM_CERTIFICATE_PATH);
        // globalConfig.setPlatformCertificate(PLATFORM_CERTIFICATE);

        Map<String, String> headerMap = new ConcurrentHashMap<>();

        globalConfig.setCustomHeaders(headerMap);

        douyinpayClient = new DefaultDouyinpayClient(globalConfig);
    }

    @Test
    public void testAddSplitReceiver() {
        ApiSplitFundPaymentsService service = new ApiSplitFundPaymentsService.Builder().douyinpayClient(douyinpayClient)
                .domainName(DomainName.API).build();

        ApiAddSplitReceiverRequest request = new ApiAddSplitReceiverRequest();
        request.setMerchantId(MCHID);
        request.setAppId(APPID);
        request.setType("MERCHANT_ID");
        request.setAccount("6020260126898210");
        request.setName("CDEgKhcAkOQVESRENiMsdtfoRDOsLPOfCmJPR");
        request.setRelationType("STORE");

        System.out.println(request);
        try {
            ApiAddSplitReceiverResponse response = service.addSplitReceiver(request);
            System.out.println(response);
            Assert.assertNotNull(response);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(),
                    e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testSplitFund() {
        ApiSplitFundPaymentsService service = new ApiSplitFundPaymentsService.Builder().douyinpayClient(douyinpayClient)
                .domainName(DomainName.API).build();

        ReceiverInfoDto receiverInfoDto = new ReceiverInfoDto();
        receiverInfoDto.setType("MERCHANT_ID");
        receiverInfoDto.setAccount("6020231219024876");
        receiverInfoDto.setAmount(10);
        receiverInfoDto.setDescription("测试分账");
        receiverInfoDto.setName("");
        List<ReceiverInfoDto> receiverInfoDtos = new ArrayList<>();
        receiverInfoDtos.add(receiverInfoDto);

        ApiSplitFundRequest request = new ApiSplitFundRequest();
        request.setAppId(APPID);
        request.setMerchantId(MCHID);
        request.setTradeNo("TP2022101317144741443210681000");
        request.setOutTradeNo("OUT_31357802300250606199830");
        request.setReceiverInfoDtos(receiverInfoDtos);
        request.setUnfreezeUnsplit(false);
        request.setNotifyUrl("https://www.mock.douyinpay.com");

        System.out.println(request);
        try {
            ApiSplitFundResponse response = service.splitFund(request);
            System.out.println(response);
            Assert.assertNotNull(response);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(),
                    e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testQuerySplitFund() {
        ApiSplitFundPaymentsService service = new ApiSplitFundPaymentsService.Builder().douyinpayClient(douyinpayClient)
                .domainName(DomainName.API).build();

        ApiQuerySplitFundRequest request = new ApiQuerySplitFundRequest();
        request.setMerchantId(MCHID);
        request.setTradeNo("TP2022101317144741443210681000");
        request.setOutTradeNo("OUT_31357802300250606199830");
        request.setOrderId("11777200250103110500000223512022");

        System.out.println(request);
        try {
            ApiQuerySplitFundResponse response = service.querySplitFund(request);
            System.out.println(response);
            Assert.assertNotNull(response);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(),
                    e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testReturnSplitFund() {
        ApiSplitFundPaymentsService service = new ApiSplitFundPaymentsService.Builder().douyinpayClient(douyinpayClient)
                .domainName(DomainName.API).build();

        ApiReturnSplitFundRequest request = new ApiReturnSplitFundRequest();
        request.setMerchantId(MCHID);
        request.setOrderId("11777200250103110500000223512022");
        request.setOutOrderNo("OUT_31357802300250606199830");
        request.setOutReturnNo("OUT_338004");
        request.setReturnMchid("6020231219024876");
        request.setAmount(10);
        request.setDescription("退分账");

        System.out.println(request);
        try {
            ApiReturnSplitFundResponse response = service.returnSplitFund(request);
            System.out.println(response);
            Assert.assertNotNull(response);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(),
                    e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testQueryReturnSplitFund() {
        ApiSplitFundPaymentsService service = new ApiSplitFundPaymentsService.Builder().douyinpayClient(douyinpayClient)
                .domainName(DomainName.API).build();

        ApiQueryReturnSplitFundRequest request = new ApiQueryReturnSplitFundRequest();
        request.setOutReturnNo("OUT_3380044");
        request.setMerchantId(MCHID);
        request.setOutOrderNo("OUT_3135780230025060619983");

        System.out.println(request);
        try {
            ApiQueryReturnSplitFundResponse response = service.queryReturnSplitFund(request);
            System.out.println(response);
            Assert.assertNotNull(response);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(),
                    e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testFinishSplitFund() {
        ApiSplitFundPaymentsService service = new ApiSplitFundPaymentsService.Builder().douyinpayClient(douyinpayClient)
                .domainName(DomainName.API).build();

        ApiFinishSplitFundRequest request = new ApiFinishSplitFundRequest();
        request.setTransactionId("TP2022101317144741443210681000");
        request.setOutOrderNo("OUT_1666688488");
        request.setMerchantId(MCHID);
        request.setDescription("测试商品分账");
        request.setNotifyUrl("https://www.mock.douyinpay.com");

        System.out.println(request);
        try {
            ApiFinishSplitFundResponse response = service.finishSplitFund(request);
            System.out.println(response);
            Assert.assertNotNull(response);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(),
                    e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testQueryUnSplitFund() {
        ApiSplitFundPaymentsService service = new ApiSplitFundPaymentsService.Builder().douyinpayClient(douyinpayClient)
                .domainName(DomainName.API).build();

        ApiQueryUnSplitFundRequest request = new ApiQueryUnSplitFundRequest();
        request.setTransactionId("TP2022101317144741443210681000");
        request.setMerchantId(MCHID);

        System.out.println(request);
        try {
            ApiQueryUnSplitFundResponse response = service.queryUnSplitFund(request);
            System.out.println(response);
            Assert.assertNotNull(response);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(),
                    e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testDeleteSplitReceiver() {
        ApiSplitFundPaymentsService service = new ApiSplitFundPaymentsService.Builder().douyinpayClient(douyinpayClient)
                .domainName(DomainName.API).build();

        ApiDeleteSplitReceiverRequest request = new ApiDeleteSplitReceiverRequest();
        request.setMerchantId(MCHID);
        request.setAppId(APPID);
        request.setType("MERCHANT_ID");
        request.setAccount("6020230307605084");

        System.out.println(request);
        try {
            ApiDeleteSplitReceiverResponse response = service.deleteSplitReceiver(request);
            System.out.println(response);
            Assert.assertNotNull(response);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(),
                    e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }
}
