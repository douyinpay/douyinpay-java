package com.doupay.api.deduct;

import com.doupay.api.secret.Config;
import com.douyinpay.api.DefaultDouyinpayClient;
import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.deduct.ApiDeductService;
import com.douyinpay.api.deduct.models.*;
import com.douyinpay.define.Constants;
import com.douyinpay.define.DomainName;
import com.douyinpay.define.GlobalConfig;
import com.douyinpay.exception.DouyinpayException;
import com.douyinpay.exception.ServiceException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApiDeductTest {
    private static DouyinpayClient douyinpayClient;


    @BeforeClass
    public static void init() {
        GlobalConfig globalConfig = new GlobalConfig();

        globalConfig.setMchId(Config.MCHID);
        globalConfig.setEncryptKey(Config.ENCRYPT_KEY);
        globalConfig.setEncryptType(Constants.ENCRYPT_TYPE_AES);
        globalConfig.setSignType(Constants.SIGN_TYPE_RSA);
        globalConfig.setMerchantSerialNumber(Config.MERCHANT_SERIAL_NO);

        // 二选一即可
        // globalConfig.setPrivateKeyPath(MERCHANT_PRIVATE_KEY_PATH);
        globalConfig.setPrivateKey(Config.MERCHANT_PRIVATE_KEY);

        //二选一即可,
        // globalConfig.setPlatformCertPath(PLATFORM_CERTIFICATE_PATH);
        globalConfig.setPlatformCertificate(Config.PLATFORM_CERTIFICATE);


        Map<String, String> headerMap = new ConcurrentHashMap<>();

        globalConfig.setCustomHeaders(headerMap);

        douyinpayClient = new DefaultDouyinpayClient(globalConfig);
    }

    @Test
    public void testDeduct() {

        ApiDeductService apiDeduct = new ApiDeductService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();

        ApiDeductRequest request = new ApiDeductRequest();
        request.setAppid(Config.APPID);
        request.setMchid(Config.MCHID);
        String outTradeNo = "OUT_175695587412";
        request.setOutTradeNo(outTradeNo);

        Date currDate = Date.from(Instant.now().plus(24, ChronoUnit.HOURS));
        String timeExpire = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").format(currDate);
        request.setTimeExpire(timeExpire);

        request.setContractId(Config.DEDUCT_CONTRACT_ID); // 委托代扣协议id
        request.setTradeType("SGP1"); // 交易类型

        request.setDescription("抖音支付测试");
        request.setNotifyUrl("https://www.mock.douyinpay.com");
        request.setAttach("");

        ApiDetail apiDetail = new ApiDetail();
        apiDetail.setCostPrice(2652);
        apiDetail.setInvoiceId("dy123");
        ApiGoodsDetail apiGoodsDetail = new ApiGoodsDetail();
        apiGoodsDetail.setGoodsName("iphonex");
        apiGoodsDetail.setMerchantGoodsId("1243");
        apiGoodsDetail.setQuantity(1);
        apiGoodsDetail.setUnitPrice(1231);
        apiGoodsDetail.setDouyinpayGoodsId("dy123");
        List<ApiGoodsDetail> goodsDetails = new ArrayList<>();
        goodsDetails.add(apiGoodsDetail);
        apiDetail.setGoodsDetail(goodsDetails);
        request.setDetail(apiDetail);
        request.setGoodsTag("{}");

        Amount amount = new Amount();
        amount.setCurrency("CNY");
        amount.setTotal(1);
        request.setAmount(amount);

        ApiSceneInfo apiSceneInfo = new ApiSceneInfo();
        apiSceneInfo.setDeviceId("2545512454");
        apiSceneInfo.setPayerClientIp("195.23.1.2");
        request.setSceneInfo(apiSceneInfo);

        ApiSettleInfo apiSettleInfo = new ApiSettleInfo();
        apiSettleInfo.setProfitSharing(false);
        request.setSettleInfo(apiSettleInfo);

        System.out.println(request);
        try {
            ApiDeductResponse response = apiDeduct.deduct(request);
            System.out.println(response);
            Assert.assertNotNull(response);
        }catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n",e.getErrorCode(),e.getErrorMessage(),e.getResponseBody());
        }catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testCloseOrder() {
        ApiDeductService apiDeductService = new ApiDeductService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
        String outTradeNo = "OUT_1677919636";
        ApiCloseOrderRequest request = new ApiCloseOrderRequest();
        request.setMchid(Config.MCHID);
        request.setOutTradeNo(outTradeNo);
        apiDeductService.closeOrder(request);
    }

    @Test
    public void testQueryOrderByOutTradeNo() {
        ApiDeductService apiDeductService = new ApiDeductService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
        String outTradeNo = "OUT_1677919636";
        ApiQueryOrderByOutTradeNoRequest request = new ApiQueryOrderByOutTradeNoRequest();
        request.setMchid(Config.MCHID);
        request.setOutTradeNo(outTradeNo);
        try {
            ApiTransaction response = apiDeductService.queryOrderByOutTradeNo(request);
            System.out.println(response);
            Assert.assertNotNull(response);
        }catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n",e.getErrorCode(),e.getErrorMessage(),e.getResponseBody());
        }catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void testQueryOrderById() {
        ApiDeductService apiDeductService = new ApiDeductService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
        String id = "TP2023030416470700067010644542";
        ApiQueryOrderByIdRequest request = new ApiQueryOrderByIdRequest();
        request.setMchid(Config.MCHID);
        request.setTransactionId(id);
        try {
            ApiTransaction response = apiDeductService.queryOrderById(request);
            System.out.println(response);
            Assert.assertNotNull(response);
        }catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n",e.getErrorCode(),e.getErrorMessage(),e.getResponseBody());
        }catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }

    }
    @Test
    public void testDeductNotify() {
        ApiDeductService apiDeductService = new ApiDeductService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
        ApiDeductNotifyRequest request = new ApiDeductNotifyRequest();
        request.setMchid(Config.MCHID);
        request.setContractId(Config.DEDUCT_CONTRACT_ID);
        request.setAppid(Config.APPID);
        EstimatedAmount amount = new EstimatedAmount();
        amount.setCurrency("CNY");
        amount.setAmount(1);
        request.setEstimatedAmount(amount);
        System.out.println(request);
        try {
            apiDeductService.deductNotify(request);
        }catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n",e.getErrorCode(),e.getErrorMessage(),e.getResponseBody());
        }catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }
}
