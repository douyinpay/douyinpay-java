package com.doupay.api.partnerdeduct;

import com.doupay.api.secret.PartnerConfig;
import com.douyinpay.api.DefaultDouyinpayClient;
import com.douyinpay.api.DouyinpayClient;

import com.douyinpay.api.partnerdeduct.models.ApiDetail;
import com.douyinpay.api.partnerdeduct.models.ApiGoodsDetail;
import com.douyinpay.api.partnerdeduct.models.ApiSceneInfo;
import com.douyinpay.api.partnerdeduct.models.ApiPartnerContractScheduleResponse;
import com.douyinpay.api.partnerdeduct.models.ApiPartnerContractScheduleRequest;
import com.douyinpay.api.partnerdeduct.models.ScheduleAmount;
import com.douyinpay.api.partnerdeduct.models.Amount;
import com.douyinpay.api.partnerdeduct.ApiPartnerDeductService;
import com.douyinpay.api.partnerdeduct.models.ApiPartnerDeductRequest;
import com.douyinpay.api.partnerdeduct.models.ApiPartnerDeductResponse;
import com.douyinpay.api.partnerdeduct.models.ApiPartnerQueryContractScheduleResponse;
import com.douyinpay.api.partnerdeduct.models.ApiPartnerQueryContractScheduleRequest;
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

public class ApiPartnerDeductTest {
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
     public void testDeduct() {
        ApiPartnerDeductService apiPartnerDeductService = new ApiPartnerDeductService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
        ApiPartnerDeductRequest req = new ApiPartnerDeductRequest();
        req.setSpAppid(PartnerConfig.SP_APPID);
        req.setSpMchid(PartnerConfig.SP_MCHID);
        req.setSubAppid(PartnerConfig.SUB_APPID);
        req.setSubMchid(PartnerConfig.SUB_MCHID);
        req.setOutTradeNo("OUT_12345678");
        req.setTimeExpire("2025-09-29T10:34:56+08:00");
        req.setContractId(PartnerConfig.DEDUCT_CONTRACT_ID);
        req.setTradeType("SGP");
        req.setDescription("测试商品");
        req.setNotifyUrl("https://www.123.com");
        req.setGoodsTag("{}");
        ApiDetail apiDetail = new ApiDetail();
        apiDetail.setCostPrice(100);
        apiDetail.setInvoiceId("dy12345678");
        List<ApiGoodsDetail> goodsDetailList = new ArrayList<>();
        ApiGoodsDetail goodsDetail = new ApiGoodsDetail();
        goodsDetail.setMerchantGoodsId("ABC");
        goodsDetail.setGoodsName("测试商品");
        goodsDetail.setQuantity(1);
        goodsDetail.setUnitPrice(100);
        goodsDetailList.add(goodsDetail);
        apiDetail.setGoodsDetail(goodsDetailList);
        req.setDetail(apiDetail);

        ApiSceneInfo apiSceneInfo = new ApiSceneInfo();
        apiSceneInfo.setPayerClientIp("");
        apiSceneInfo.setDeviceId("");
        req.setSceneInfo(apiSceneInfo);
        Amount amount = new Amount();
        amount.setTotal(100);
        amount.setCurrency("CNY");
        req.setAmount(amount);

        System.out.println(req);
        try {
            ApiPartnerDeductResponse resp = apiPartnerDeductService.partnerDeduct(req);
            System.out.println(resp);
            Assert.assertNotNull(resp);
        }catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n",e.getErrorCode(),e.getErrorMessage(),e.getResponseBody());
        }catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
     }

     @Test
     public void testSchedule() {
        ApiPartnerDeductService apiPartnerDeductService = new ApiPartnerDeductService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
        ApiPartnerContractScheduleRequest req = new ApiPartnerContractScheduleRequest();
        req.setContractId(PartnerConfig.DEDUCT_CONTRACT_ID);
        req.setSpMchid(PartnerConfig.SP_MCHID);
        req.setSubMchid(PartnerConfig.SUB_MCHID);
        ScheduleAmount scheduleAmount = new ScheduleAmount();
        scheduleAmount.setTotal(100);
        scheduleAmount.setCurrency("CNY");
        req.setScheduleAmount(scheduleAmount);
        System.out.println(req);
        try {
            ApiPartnerContractScheduleResponse resp = apiPartnerDeductService.partnerContractSchedule(req);
            System.out.println(resp);
            Assert.assertNotNull(resp);
        }catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n",e.getErrorCode(),e.getErrorMessage(),e.getResponseBody());
        }catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
     }

     @Test
     public void testQuerySchedule() {
        ApiPartnerDeductService apiPartnerDeductService = new ApiPartnerDeductService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
        ApiPartnerQueryContractScheduleRequest req = new ApiPartnerQueryContractScheduleRequest();
        req.setContractId(PartnerConfig.DEDUCT_CONTRACT_ID);
        req.setSpMchid(PartnerConfig.SP_MCHID);
        req.setSubMchid(PartnerConfig.SUB_MCHID);
        System.out.println(req);
        try {
            ApiPartnerQueryContractScheduleResponse resp = apiPartnerDeductService.partnerQueryContractSchedule(req);
            System.out.println(resp);
            Assert.assertNotNull(resp);
        }catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n",e.getErrorCode(),e.getErrorMessage(),e.getResponseBody());
        }catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
     }
}
