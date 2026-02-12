package com.doupay.api.contract;

import com.doupay.api.secret.PartnerConfig;
import com.douyinpay.api.DefaultDouyinpayClient;
import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.contract.ApiContractService;
import com.douyinpay.api.partnercontract.ApiPartnerContractService;
import com.douyinpay.api.partnercontract.models.ApiPartnerQueryContractResponse;
import com.douyinpay.api.partnercontract.models.ApiPartnerQueryContractRequest;
import com.douyinpay.api.partnercontract.models.ApiPartnerTerminateContractRequest;
import com.douyinpay.api.partnercontract.models.ApiPartnerTerminateContractResponse;
import com.douyinpay.api.partnercontractorder.ApiPartnerContractOrderService;
import com.douyinpay.api.partnercontractorder.models.Amount;
import com.douyinpay.api.partnercontractorder.models.ApiPartnerContractOrderRequest;
import com.douyinpay.api.partnercontractorder.models.ApiPartnerContractOrderResponse;
import com.douyinpay.api.partnercontractorder.models.ApiSceneInfo;
import com.douyinpay.api.partnercontractorder.models.ApiStoreInfo;
import com.douyinpay.api.partnercontractorder.models.ContractInfo;
import com.douyinpay.api.partnercontractorder.models.Payer;
import com.douyinpay.define.Constants;
import com.douyinpay.define.DomainName;
import com.douyinpay.define.GlobalConfig;
import com.douyinpay.exception.DouyinpayException;
import com.douyinpay.exception.ServiceException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApiPartnerContractTest {

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
    public void testQueryContractInfo(){
        ApiPartnerContractService apiContractService = new ApiPartnerContractService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
        ApiPartnerQueryContractRequest req = new ApiPartnerQueryContractRequest();
        req.setOutContractCode(PartnerConfig.CONTRACT_CODE);
        req.setSpMchid(PartnerConfig.SP_MCHID);
        req.setSubMchid(PartnerConfig.SUB_MCHID);
        req.setPlanId(1781);
        System.out.println(req);
        try {
            ApiPartnerQueryContractResponse resp = apiContractService.partnerQueryContract(req);
            System.out.println(resp);
            Assert.assertNotNull(resp);
        }catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n",e.getErrorCode(),e.getErrorMessage(),e.getResponseBody());
        }catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testTerminateContract(){
        ApiPartnerContractService apiContractService = new ApiPartnerContractService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
        ApiPartnerTerminateContractRequest req = new ApiPartnerTerminateContractRequest();
        req.setOutContractCode(PartnerConfig.CONTRACT_CODE);
        req.setSpMchid(PartnerConfig.SP_MCHID);
        req.setSubMchid(PartnerConfig.SUB_MCHID);
        req.setPlanId(1781);
        req.setContractTerminationRemark("测试解约");
        System.out.println(req);
        try {
            ApiPartnerTerminateContractResponse resp = apiContractService.partnerTerminateContract(req);
            System.out.println(resp);
            Assert.assertNotNull(resp);
        }catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n",e.getErrorCode(),e.getErrorMessage(),e.getResponseBody());
        }catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
        
    }

    @Test
    public void testPrepay(){
        ApiPartnerContractOrderService apiContractService = new ApiPartnerContractOrderService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
        ApiPartnerContractOrderRequest req = new ApiPartnerContractOrderRequest();
        req.setSpAppid(PartnerConfig.SP_APPID);
        req.setSpMchid(PartnerConfig.SP_MCHID);
        req.setSubMchid(PartnerConfig.SUB_MCHID);
        req.setSubAppid(PartnerConfig.SUB_APPID);
        req.setDescription("测试商品");
        req.setOutTradeNo("OUT_16666884881234");
        req.setTimeExpire("2025-09-08T10:34:56+08:00");
        req.setTradeType("APP");
        req.setAttach("自定义数据");
        req.setNotifyUrl("https://123123.com");
        req.setGoodsTag("{}");
        Amount amount = new Amount();
        amount.setTotal(100);
        amount.setCurrency("CNY");
        req.setAmount(amount);
        Payer payer = new Payer();
        // payer.setSpOpenid("897ae8bd9f194107-9cb3-85f5672037de");
        // payer.setSubOpenid("823ae8bd9f893402-9cb3-85f8794657ea");
        req.setPayer(payer);
        ApiSceneInfo sceneInfo = new ApiSceneInfo();
        sceneInfo.setPayerClientIp("14.23.150.211");
        sceneInfo.setPayerDeviceId("IDFA");
        sceneInfo.setDeviceId("13467007045764");
            ApiStoreInfo storeInfo = new ApiStoreInfo();
            storeInfo.setId("123");
            storeInfo.setName("测试门店");
            storeInfo.setAddress("测试门店地址");
            storeInfo.setAreaCode("11039");
            sceneInfo.setStoreInfo(storeInfo);
        req.setSceneInfo(sceneInfo);
        ContractInfo contractInfo = new ContractInfo();
        contractInfo.setContractMerchantId(PartnerConfig.SUB_MCHID);
        contractInfo.setContractAppId(PartnerConfig.SUB_APPID);
        contractInfo.setOutContractCode(PartnerConfig.CONTRACT_CODE);
        contractInfo.setRequestSerial(1000L);
        contractInfo.setContractDisplayAccount("13000000000");
        contractInfo.setContractNotifyUrl("https://1231.com");
        contractInfo.setContractExt("{\"goods_tag\":\"{\\\"product_tag\\\":\\\"商品信息\\\",\\\"third_part_right_info\\\":\\\"{\\\\\\\"right_id\\\\\\\":\\\\\\\"123\\\\\\\",\\\\\\\"prize_type\\\\\\\":\\\\\\\"XXX\\\\\\\"}\\\"}\"}");
        req.setContractInfo(contractInfo);

              System.out.println(req);
        try {
            ApiPartnerContractOrderResponse resp = apiContractService.partnerContractOrder(req);
            System.out.println(resp);
            Assert.assertNotNull(resp);
        }catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n",e.getErrorCode(),e.getErrorMessage(),e.getResponseBody());
        }catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
        }

}
