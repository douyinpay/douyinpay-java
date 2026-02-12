package com.doupay.api.partnerpayments.h5;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.BeforeClass;
import org.junit.Test;

import com.doupay.api.secret.PartnerConfig;
import com.douyinpay.api.DefaultDouyinpayClient;
import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.partnerpayments.common.ApiTransaction;
import com.douyinpay.api.partnerpayments.h5.ApiPartnerH5PaymentService;
import com.douyinpay.api.partnerpayments.h5.model.Amount;
import com.douyinpay.api.partnerpayments.h5.model.ApiCloseOrderRequest;
import com.douyinpay.api.partnerpayments.h5.model.ApiDetail;
import com.douyinpay.api.partnerpayments.h5.model.ApiGoodsDetail;
import com.douyinpay.api.partnerpayments.h5.model.ApiH5Info;
import com.douyinpay.api.partnerpayments.h5.model.ApiPrepayRequest;
import com.douyinpay.api.partnerpayments.h5.model.ApiPrepayResponse;
import com.douyinpay.api.partnerpayments.h5.model.ApiQueryOrderByIdRequest;
import com.douyinpay.api.partnerpayments.h5.model.ApiQueryOrderByOutTradeNoRequest;
import com.douyinpay.api.partnerpayments.h5.model.ApiSceneInfo;
import com.douyinpay.api.partnerpayments.h5.model.ApiSettleInfo;
import com.douyinpay.api.partnerpayments.h5.model.ApiStoreInfo;
import com.douyinpay.define.Constants;
import com.douyinpay.define.DomainName;
import com.douyinpay.define.GlobalConfig;
import com.douyinpay.exception.DouyinpayException;
import com.douyinpay.exception.ServiceException;

import junit.framework.Assert;

public class ApiPartnerH5PaymentServiceTest {
    private static DouyinpayClient douyinpayClient;

    @BeforeClass
    public static void init() {
        GlobalConfig globalConfig = new GlobalConfig();
 
        globalConfig.setMchId(PartnerConfig.SP_MCHID);
        globalConfig.setEncryptKey(PartnerConfig.ENCRYPT_KEY);
        globalConfig.setEncryptType(Constants.ENCRYPT_TYPE_AES);
        globalConfig.setSignType(Constants.SIGN_TYPE_RSA);
        globalConfig.setMerchantSerialNumber(PartnerConfig.MERCHANT_SERIAL_NO);
 
        // 二选一即可
        // globalConfig.setPrivateKeyPath(MERCHANT_PRIVATE_KEY_PATH);
        globalConfig.setPrivateKey(PartnerConfig.MERCHANT_PRIVATE_KEY);
 
        //二选一即可,
        // globalConfig.setPlatformCertPath(PLATFORM_CERTIFICATE_PATH);
        globalConfig.setPlatformCertificate(PartnerConfig.PLATFORM_CERTIFICATE);
 
        Map<String, String> headerMap = new ConcurrentHashMap<>();
 
        globalConfig.setCustomHeaders(headerMap);
 
        douyinpayClient = new DefaultDouyinpayClient(globalConfig);
    }
 
    @Test
    public void prepay() {
     ApiPartnerH5PaymentService apiPartnerH5PaymentService = new ApiPartnerH5PaymentService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
    
     ApiPrepayRequest request = new ApiPrepayRequest();
     request.setSpAppid(PartnerConfig.SP_APPID);
     request.setSpMchid(PartnerConfig.SP_MCHID);
     request.setSubMchid(PartnerConfig.SUB_MCHID);
     String outTradeNo = String.format("%s_%d", "OUT", Instant.now().getLong(ChronoField.INSTANT_SECONDS));
     request.setOutTradeNo(outTradeNo);
     request.setDescription("抖音支付测试");
     Date currDate = Date.from(Instant.now().plus(24, ChronoUnit.HOURS));



     String timeExpire = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").format(currDate);

     request.setTimeExpire(timeExpire);

     request.setAttach("");
     request.setNotifyUrl("https://www.mock.douyinpay.com");
     request.setGoodsTag("DouyingPay");

     request.setSupportFapiao(false);
     Amount amount = new Amount();
     amount.setCurrency("CNY");
     amount.setTotal(1);
     request.setAmount(amount);

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

     ApiSceneInfo apiSceneInfo = new ApiSceneInfo();

     ApiStoreInfo apiStoreInfo = new ApiStoreInfo();
     apiStoreInfo.setAddress("北京市海淀区王府井大街");
     apiStoreInfo.setAreaCode("440305");
     apiStoreInfo.setId("0002");
     apiStoreInfo.setName("apm");
     apiSceneInfo.setStoreInfo(apiStoreInfo);

     apiSceneInfo.setDeviceId("2545512454");
     apiSceneInfo.setPayerClientIp("195.23.1.2");
     apiSceneInfo.setPayerDeviceId("sljlsk-sdflkd-sjfljsd-skdf");

     ApiH5Info apiH5Info = new ApiH5Info();
     apiH5Info.setType("wap");
     apiSceneInfo.setH5Info(apiH5Info);

     ApiSettleInfo apiSettleInfo = new ApiSettleInfo();
     apiSettleInfo.setProfitSharing(false);

     request.setDetail(apiDetail);
     request.setSceneInfo(apiSceneInfo);
     request.setSettleInfo(apiSettleInfo);

     System.out.println(request);
     try {
         ApiPrepayResponse prepayResponse = apiPartnerH5PaymentService.prepay(request);
         System.out.println(prepayResponse);
         Assert.assertNotNull(prepayResponse);
     }catch (ServiceException e) {
         System.out.printf("code:%s,message:%s,httpbody:%s\n",e.getErrorCode(),e.getErrorMessage(),e.getResponseBody());
     }catch (DouyinpayException e) {
         System.out.println(e.getMessage());
     }
     }
 
     @Test
     public void testQueryOrderByOutTradeNo() {
        ApiPartnerH5PaymentService apiPartnerH5PaymentService = new ApiPartnerH5PaymentService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
        String outTradeNo = "lt_2025111415531397725027";
         // String outTradeNo = "OUT_1761650114";
         ApiQueryOrderByOutTradeNoRequest request = new ApiQueryOrderByOutTradeNoRequest();
         request.setSpMchid(PartnerConfig.SP_MCHID);
         request.setSubMchid(PartnerConfig.SUB_MCHID);
         request.setOutTradeNo(outTradeNo);
         System.out.println(request);
         try {
             ApiTransaction response = apiPartnerH5PaymentService.queryOrderByOutTradeNo(request);
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
        ApiPartnerH5PaymentService apiPartnerH5PaymentService = new ApiPartnerH5PaymentService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
         String id = "2100012511140300098867447576";
         ApiQueryOrderByIdRequest request = new ApiQueryOrderByIdRequest();
         request.setSpMchid(PartnerConfig.SP_MCHID);
         request.setSubMchid(PartnerConfig.SUB_MCHID);
         request.setTransactionId(id);
         System.out.println(request);
         try {
             ApiTransaction response = apiPartnerH5PaymentService.queryOrderById(request);
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
        ApiPartnerH5PaymentService apiPartnerH5PaymentService = new ApiPartnerH5PaymentService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
         String outTradeNo = "OUT_1763106579";
         ApiCloseOrderRequest request = new ApiCloseOrderRequest();
         request.setSpMchid(PartnerConfig.SP_MCHID);
         request.setSubMchid(PartnerConfig.SUB_MCHID);
         request.setOutTradeNo(outTradeNo);
         System.out.println(request);
         try {
            apiPartnerH5PaymentService.closeOrder(request);
         }catch (ServiceException e) {
             System.out.printf("code:%s,message:%s,httpbody:%s\n",e.getErrorCode(),e.getErrorMessage(),e.getResponseBody());
         }catch (DouyinpayException e) {
             System.out.println(e.getMessage());
         }
 
     }
}
