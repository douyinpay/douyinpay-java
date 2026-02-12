package com.doupay.api.transferreturn;

import com.douyinpay.api.DefaultDouyinpayClient;
import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.tranferreturn.ApiTransferReturnService;
import com.douyinpay.api.tranferreturn.models.*;
import com.douyinpay.define.Constants;
import com.douyinpay.define.DomainName;
import com.douyinpay.define.GlobalConfig;
import com.douyinpay.exception.DouyinpayException;
import com.douyinpay.exception.ServiceException;
import com.douyinpay.util.GsonUtil;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApiTransferReturnServiceTest {
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
    public void testTransferReturn() {
        ApiTransferReturnService service = new ApiTransferReturnService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();

        ApiTransferReturnRequest request = new ApiTransferReturnRequest();
        //填充基础字段
        String OUT_TRADE_NO = "";
        String TRADE_NO = "";
        Integer REFUND_AMOUNT = 1;
        String remark = "";
        request.setAppId(APPID);
        request.setMerchantId(MCHID);
        request.setOutRequestNo(OUT_TRADE_NO);
        request.setOrderId(TRADE_NO);

        //填充金额
        Amount amount = new Amount();
        amount.setCurrency("CNY");
        amount.setTotal(REFUND_AMOUNT);
        request.setRefundAmount(amount);
        request.setRemark(remark);

        //构造扩展字段
        TansferReturnExtParam param = new TansferReturnExtParam();
        param.setNeedPayeeNotify(true);
        Map<String, Object> notifypayeeParams = new HashMap<>();
        notifypayeeParams.put("", "");
        param.setPayeeNotifyParams(GsonUtil.objectToJson(notifypayeeParams));
        request.setExtParams( param);
        try {
            ApiTransferReturnResponse response = service.transferReturn(request);
            System.out.println(GsonUtil.objectToJson(response));
            Assert.assertNotNull(response);
        }catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n",e.getErrorCode(),e.getErrorMessage(),e.getResponseBody());
        }catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testQueryTransferReturnById() {
        ApiTransferReturnService service = new ApiTransferReturnService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
        String OUT_TRADE_NO = "";
        String TRADE_NO = "";
        ApiTransferReturnQueryByIdRequest request = new ApiTransferReturnQueryByIdRequest();
        request.setMerchantId(MCHID);
        request.setRefundOrderId(TRADE_NO);

        try {
            ApiTransferReturnQueryResponse response = service.queryTransferReturnById(request);
            System.out.println(GsonUtil.objectToJson(response));
            Assert.assertNotNull(response);
            Assert.assertNotNull(response.getMerchantId());
            Assert.assertFalse(response.getRefundOrderId().isEmpty());
        }catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n",e.getErrorCode(),e.getErrorMessage(),e.getResponseBody());
        }catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testQueryTransferReturnByOutRequestNo() {
        ApiTransferReturnService service = new ApiTransferReturnService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
        String OUT_TRADE_NO = "";
        String TRADE_NO = "";
        ApiTransferReturnQueryByOutTradeNoRequest request = new ApiTransferReturnQueryByOutTradeNoRequest();
        request.setMerchantId(MCHID);
        request.setOutRequestNo(OUT_TRADE_NO);

        try {
            ApiTransferReturnQueryResponse response = service.queryTransferReturnByRequestNo(request);
            System.out.println(GsonUtil.objectToJson(response));
            Assert.assertNotNull(response);
            Assert.assertNotNull(response.getOutRequestNo());
            Assert.assertFalse(response.getOrderId().isEmpty());
        }catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n",e.getErrorCode(),e.getErrorMessage(),e.getResponseBody());
        }catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }
}
