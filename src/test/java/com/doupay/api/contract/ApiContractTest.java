package com.doupay.api.contract;

import com.doupay.api.secret.Config;
import com.douyinpay.api.DefaultDouyinpayClient;
import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.contract.ApiContractService;
import com.douyinpay.api.contract.models.Amount;
import com.douyinpay.api.contract.models.ApiDeleteContractRequest;
import com.douyinpay.api.contract.models.ApiDeleteContractResponse;
import com.douyinpay.api.contract.models.ApiDetail;
import com.douyinpay.api.contract.models.ApiH5EntrustWebRequest;
import com.douyinpay.api.contract.models.ApiH5EntrustWebResponse;
import com.douyinpay.api.contract.models.ApiQueryContractRequest;
import com.douyinpay.api.contract.models.ApiQueryContractResponse;
import com.douyinpay.api.contract.models.ApiSceneInfo;
import com.douyinpay.api.contract.models.ApiStoreInfo;
import com.douyinpay.api.contract.models.ContractInfo;
import com.douyinpay.api.contract.models.Payer;
import com.douyinpay.api.partnercontractorder.models.ApiPartnerContractOrderRequest;
import com.douyinpay.api.contract.models.ApiPreEntrustWebRequest;
import com.douyinpay.api.contract.models.ApiPreEntrustWebResponse;
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

 
public class ApiContractTest {

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
    public void testQueryContractByContractId(){
        ApiContractService apiContractService = new ApiContractService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
        ApiQueryContractRequest req = new ApiQueryContractRequest();
        req.setContractId(Config.CONTRACT_ID);
        req.setAppid(Config.APPID);
        req.setMchid(Config.MCHID);
        System.out.println(req);

        try {
            ApiQueryContractResponse resp = apiContractService.queryContract(req);
            System.out.println(resp);
            Assert.assertNotNull(resp);
        }catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n",e.getErrorCode(),e.getErrorMessage(),e.getResponseBody());
        }catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testQueryContractByContractIdFail(){
        ApiContractService apiContractService = new ApiContractService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
        ApiQueryContractRequest req = new ApiQueryContractRequest();
        req.setContractId(Config.CONTRACT_ID);
        req.setAppid("");
        req.setMchid(Config.MCHID);
        System.out.println(req);

        try {
            ApiQueryContractResponse resp = apiContractService.queryContract(req);
            System.out.println(resp);
            Assert.assertNotNull(resp);
        }catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n",e.getErrorCode(),e.getErrorMessage(),e.getResponseBody());
        }catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testQueryContractByContractCodeAndPlanId(){
        ApiContractService apiContractService = new ApiContractService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
        ApiQueryContractRequest req = new ApiQueryContractRequest();
        req.setContractCode(Config.CONTRACT_ID);
        req.setAppid(Config.APPID);
        req.setMchid(Config.MCHID);
        req.setPlanId("84");
        System.out.println(req);

        try {
            ApiQueryContractResponse resp = apiContractService.queryContract(req);
            System.out.println(resp);
            Assert.assertNotNull(resp);
        }catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n",e.getErrorCode(),e.getErrorMessage(),e.getResponseBody());
        }catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }


    }

    @Test
    public void testDeleteContractByContractId(){
        ApiContractService apiContractService = new ApiContractService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
        ApiDeleteContractRequest req = new ApiDeleteContractRequest();
        req.setContractId(Config.CONTRACT_ID);
        req.setContractTerminationRemark("test");
        req.setAppid(Config.APPID);
        req.setMchid(Config.MCHID);
        System.out.println(req);
        try {
            ApiDeleteContractResponse resp = apiContractService.deleteContract(req);
            System.out.println(resp);
            Assert.assertNotNull(resp);
        }catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n",e.getErrorCode(),e.getErrorMessage(),e.getResponseBody());
        }catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testDeleteContractByContractCodeAndPlanId(){
        ApiContractService apiContractService = new ApiContractService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
        ApiDeleteContractRequest req = new ApiDeleteContractRequest();
        req.setContractCode(Config.CONTRACT_ID);
        req.setContractTerminationRemark("test");
        req.setPlanId("84");
        req.setAppid(Config.APPID);
        req.setMchid(Config.MCHID);
        System.out.println(req);
        try {
            ApiDeleteContractResponse resp = apiContractService.deleteContract(req);
            System.out.println(resp);
            Assert.assertNotNull(resp);
        }catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n",e.getErrorCode(),e.getErrorMessage(),e.getResponseBody());
        }catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }

    }
    @Test
    public void testPreContract(){
        ApiContractService apiContractService = new ApiContractService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
        ApiPreEntrustWebRequest req = new ApiPreEntrustWebRequest();
        req.setAppid(Config.APPID);
        req.setMchid(Config.MCHID);
        req.setOutContractCode(Config.CONTRACT_ID);
        req.setPlanId("141"); 
        req.setRequestSerial(1000L);
        req.setContractDisplayAccount("13000000000");
        req.setNotifyUrl("https://123.com");
        req.setContractExt("{\"goods_tag\":\"{\\\"product_tag\\\":\\\"商品信息\\\",\\\"third_part_right_info\\\":\\\"{\\\\\\\"right_id\\\\\\\":\\\\\\\"123\\\\\\\",\\\\\\\"prize_type\\\\\\\":\\\\\\\"XXX\\\\\\\"}\\\"}\"}");
        System.out.println(req);
        try {
            ApiPreEntrustWebResponse resp = apiContractService.preEntrustWeb(req);
            System.out.println(resp);
            Assert.assertNotNull(resp);
        }catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n",e.getErrorCode(),e.getErrorMessage(),e.getResponseBody());
        }catch (DouyinpayException e) {
            System.out.println(e.getMessage());
    }
    }

    @Test
    public void testH5EntrustWeb() {
        ApiContractService ApiContractService = new ApiContractService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
        ApiH5EntrustWebRequest req = new ApiH5EntrustWebRequest();
        req.setMchid(Config.MCHID);
        req.setAppid(Config.APPID);
        req.setOutContractCode(Config.CONTRACT_ID);
        req.setPlanId("141"); 
        req.setRequestSerial(1000L);
        req.setContractDisplayAccount("13000000000");
        req.setNotifyUrl("https://123.com");
        req.setContractExt("{\"goods_tag\":\"{\\\"product_tag\\\":\\\"商品信息\\\",\\\"third_part_right_info\\\":\\\"{\\\\\\\"right_id\\\\\\\":\\\\\\\"123\\\\\\\",\\\\\\\"prize_type\\\\\\\":\\\\\\\"XXX\\\\\\\"}\\\"}\"}");
        req.setTimestamp("1414488825");
        req.setClientip("119.145.83.6");
        System.out.println(req);
        try {
            ApiH5EntrustWebResponse resp = ApiContractService.h5EntrustWeb(req);
            System.out.println(resp);
            Assert.assertNotNull(resp);
        }catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n",e.getErrorCode(),e.getErrorMessage(),e.getResponseBody());
        }catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
