package com.doupay.api.refund;

import com.douyinpay.api.DefaultDouyinpayClient;
import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.refund.ApiRefundService;
import com.douyinpay.api.refund.model.ApiAmountReq;
import com.douyinpay.api.refund.model.ApiCreateRequest;
import com.douyinpay.api.refund.model.ApiQueryByOutRefundNoRequest;
import com.douyinpay.api.refund.model.ApiRefund;
import com.douyinpay.define.Constants;
import com.douyinpay.define.DomainName;
import com.douyinpay.define.GlobalConfig;
import com.douyinpay.exception.DouyinpayException;
import com.douyinpay.exception.ServiceException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.Instant;
import java.time.temporal.ChronoField;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RefundServiceTest {

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
        //globalConfig.setPrivateKey(MERCHANT_PRIVATE_KEY);

        //二选一即可,
        globalConfig.setPlatformCertPath(PLATFORM_CERTIFICATE_PATH);
        //globalConfig.setPlatformCertificate(PLATFORM_CERTIFICATE);


        Map<String, String> headerMap = new ConcurrentHashMap<>();

        globalConfig.setCustomHeaders(headerMap);

        douyinpayClient = new DefaultDouyinpayClient(globalConfig);
    }

    @Test
    public void testRefund() {
        ApiRefundService refundService = new ApiRefundService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
        String outTradeNo = "OUT_1678411035";
        String outRefundNo = String.format("%s_%d", "REFUND", Instant.now().getLong(ChronoField.INSTANT_SECONDS));

        ApiCreateRequest request = new ApiCreateRequest();
        request.setAppid(APPID);
        request.setMchid(MCHID);
        request.setOutTradeNo(outTradeNo);
        request.setOutRefundNo(outRefundNo);
        request.setNotifyUrl("https://www.mock.douyinpay.com");
        request.setReason("no reason");
        ApiAmountReq amountReq = new ApiAmountReq();
        amountReq.setTotal(1);
        amountReq.setRefund(1);
        amountReq.setCurrency("CNY");
        request.setAmount(amountReq);

        System.out.println(request);
        try {
            ApiRefund refundResponse = refundService.create(request);
            System.out.println(refundResponse);
            Assert.assertNotNull(refundResponse);
        }catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n",e.getErrorCode(),e.getErrorMessage(),e.getResponseBody());
        }catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void TestQueryRefund() {
        ApiRefundService refundService = new ApiRefundService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
        ApiQueryByOutRefundNoRequest request = new ApiQueryByOutRefundNoRequest();
        String outRefundNo = "REFUND_1677924851";
        request.setOutRefundNo(outRefundNo);
        request.setMchid(MCHID);
        System.out.println(request);

        System.out.println(request);
        try {
            ApiRefund refundResponse = refundService.queryByOutRefundNo(request);
            System.out.println(refundResponse);
            Assert.assertNotNull(refundResponse);
        }catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n",e.getErrorCode(),e.getErrorMessage(),e.getResponseBody());
        }catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }

    }
}
