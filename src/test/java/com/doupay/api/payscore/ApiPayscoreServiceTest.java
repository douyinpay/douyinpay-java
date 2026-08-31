package com.doupay.api.payscore;

import com.douyinpay.api.DefaultDouyinpayClient;
import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.payscore.ApiPayscoreService;
import com.douyinpay.api.payscore.models.*;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class ApiPayscoreServiceTest {
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
     * service_id
     */
    private final static String SERVICE_ID = "";
    /**
     * 服务商商户号
     */
    private final static String SP_MCHID = "";
    /**
     * 服务商appid
     */
    private final static String SP_APPID = "";
    /**
     * 子商户商户号
     */
    private final static String SUB_MCHID = "";
    /**
     * 子商户appid
     */
    private final static String SUB_APPID = "";
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
//        globalConfig.setPrivateKeyPath(MERCHANT_PRIVATE_KEY_PATH);
        globalConfig.setPrivateKey(MERCHANT_PRIVATE_KEY);

        //二选一即可,
//        globalConfig.setPlatformCertPath(PLATFORM_CERTIFICATE_PATH);
        globalConfig.setPlatformCertificate(PLATFORM_CERTIFICATE);


        Map<String, String> headerMap = new ConcurrentHashMap<>();

        globalConfig.setCustomHeaders(headerMap);

        douyinpayClient = new DefaultDouyinpayClient(globalConfig);
    }

    @Test
    public void testCreateServiceOrder() {
        ApiPayscoreService apiPayscoreService = new ApiPayscoreService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.PAYSCORE_API).build();

        ApiCreateServiceOrderRequest request = new ApiCreateServiceOrderRequest();
        String outOrderNo = String.format("%s_%d", "OUT", Instant.now().getLong(ChronoField.INSTANT_SECONDS));
        request.setAppid(APPID);
        request.setMchid(MCHID);
        request.setServiceId(SERVICE_ID);
        request.setOutOrderNo(outOrderNo);
        request.setServiceIntroduction("抖音先享后付测试");
        request.setNotifyUrl("https://www.mock.douyinpay.com");
        request.setAttach("自定义数据");
        request.setGoodsTag("{}");
        request.setAuthorizationCode("OUT_123456");

        RiskFund riskFund = new RiskFund();
        riskFund.setAmount(1);
        riskFund.setName("ESTIMATE_ORDER_COST");
        riskFund.setDescription("预估订单费用");
        request.setRiskFund(riskFund);

        PostItem pi = new PostItem();
        pi.setAmount(1);
        pi.setCount(1);
        pi.setDescription("测试");
        pi.setName("测试");
        List<PostItem> postList = new ArrayList<>();
        postList.add(pi);
        request.setPostPayments(postList);

        TimeRange tr = new TimeRange();
        tr.setStartTime("20220806091010");
        tr.setStartTimeRemark("开始时间");
        tr.setEndTime("20220806091010");
        tr.setEndTimeRemark("结束时间");
        request.setTimeRange(tr);

        Location location = new Location();
        location.setStartLocation("北京市海淀区北三环西路43号");
        location.setEndLocation("北京市海淀区北三环西路43号");
        request.setLocation(location);

        SceneInfo sceneInfo = new SceneInfo();
        sceneInfo.setClientIp("127.0.0.1");
        sceneInfo.setDeviceId("013467007045764");
        request.setSceneInfo(sceneInfo);

        System.out.println(request);
        try {
            ApiCreateServiceOrderResponse response = apiPayscoreService.createServiceOrder(request);
            System.out.println(response);
            Assert.assertNotNull(response);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(), e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testCompleteServiceOrder() {
        ApiPayscoreService apiPayscoreService = new ApiPayscoreService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.PAYSCORE_API).build();

        ApiCompleteServiceOrderRequest request = new ApiCompleteServiceOrderRequest();
        String outOrderNo = String.format("%s_%d", "OUT", Instant.now().getLong(ChronoField.INSTANT_SECONDS));
        request.setAppid(APPID);
        request.setMchid(MCHID);
        request.setServiceId(SERVICE_ID);
        request.setOutOrderNo(outOrderNo);
        request.setAttach("自定义数据");
        request.setGoodsTag("{}");
        request.setTotalAmount(1);

        PostItem pi = new PostItem();
        pi.setAmount(1);
        pi.setCount(1);
        pi.setDescription("测试");
        pi.setName("测试");
        List<PostItem> postList = new ArrayList<>();
        postList.add(pi);
        request.setPostPayments(postList);

        TimeRange tr = new TimeRange();
        tr.setStartTime("20220806091010");
        tr.setStartTimeRemark("开始时间");
        tr.setEndTime("20220806091010");
        tr.setEndTimeRemark("结束时间");
        request.setTimeRange(tr);

        Location location = new Location();
        location.setStartLocation("北京市海淀区北三环西路43号");
        location.setEndLocation("北京市海淀区北三环西路43号");
        request.setLocation(location);

        SceneInfo sceneInfo = new SceneInfo();
        sceneInfo.setClientIp("127.0.0.1");
        sceneInfo.setDeviceId("013467007045764");
        request.setSceneInfo(sceneInfo);

        System.out.println(request);
        try {
            ApiCompleteServiceOrderResponse response = apiPayscoreService.completeServiceOrder(request);
            System.out.println(response);
            Assert.assertNotNull(response);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(), e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testQueryServiceOrder() {
        ApiPayscoreService apiPayscoreService = new ApiPayscoreService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.PAYSCORE_API).build();

        ApiQueryServiceOrderRequest request = new ApiQueryServiceOrderRequest();
        request.setAppid(APPID);
        request.setMchid(MCHID);
        request.setServiceId(SERVICE_ID);
        String outOrderNo = String.format("%s_%d", "OUT", Instant.now().getLong(ChronoField.INSTANT_SECONDS));
        request.setOutOrderNo(outOrderNo);
        System.out.println(request);
        try {
            ApiQueryServiceOrderResponse response = apiPayscoreService.queryServiceOrder(request);
            System.out.println(response);
            Assert.assertNotNull(response);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(), e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testCancelServiceOrder() {
        ApiPayscoreService apiPayscoreService = new ApiPayscoreService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.PAYSCORE_API).build();

        ApiCancelServiceOrderRequest request = new ApiCancelServiceOrderRequest();
        request.setAppid(APPID);
        request.setMchid(MCHID);
        request.setServiceId(SERVICE_ID);
        String outOrderNo = String.format("%s_%d", "OUT", Instant.now().getLong(ChronoField.INSTANT_SECONDS));
        request.setOutOrderNo(outOrderNo);
        request.setReason("测试");
        System.out.println(request);

        try {
            ApiCancelServiceOrderResponse response = apiPayscoreService.cancelServiceOrder(request);
            System.out.println(response);
            Assert.assertNotNull(response);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(), e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testModifyAmount() {
        ApiPayscoreService apiPayscoreService = new ApiPayscoreService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.PAYSCORE_API).build();

        ApiModifyAmountRequest request = new ApiModifyAmountRequest();
        request.setAppid(APPID);
        request.setMchid(MCHID);
        request.setServiceId(SERVICE_ID);
        String outOrderNo = String.format("%s_%d", "OUT", Instant.now().getLong(ChronoField.INSTANT_SECONDS));
        request.setOutOrderNo(outOrderNo);
        request.setTotalAmount(1);
        request.setReason("测试");

        PostItem pi = new PostItem();
        pi.setAmount(1);
        pi.setCount(1);
        pi.setDescription("测试");
        pi.setName("测试");
        List<PostItem> postList = new ArrayList<>();
        postList.add(pi);
        request.setPostPayments(postList);
        System.out.println(request);

        try {
            ApiModifyAmountResponse response = apiPayscoreService.modifyAmount(request);
            System.out.println(response);
            Assert.assertNotNull(response);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(), e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testSynchronizeServiceOrderInfo() {
        ApiPayscoreService apiPayscoreService = new ApiPayscoreService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.PAYSCORE_API).build();

        ApiSynchronizeServiceOrderInfoRequest request = new ApiSynchronizeServiceOrderInfoRequest();
        request.setAppid(APPID);
        request.setMchid(MCHID);
        request.setServiceId(SERVICE_ID);
        String outOrderNo = String.format("%s_%d", "OUT", Instant.now().getLong(ChronoField.INSTANT_SECONDS));
        request.setOutOrderNo(outOrderNo);
        request.setType("ORDER_PAID");

        SyncDetail detail = new SyncDetail();
        detail.setPaidTime("20220806091010");
        request.setDetail(detail);
        System.out.println(request);

        try {
            ApiSynchronizeServiceOrderInfoResponse response = apiPayscoreService.synchronizeServiceOrderInfo(request);
            System.out.println(response);
            Assert.assertNotNull(response);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(), e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void testServiceOrderPay() {
        ApiPayscoreService apiPayscoreService = new ApiPayscoreService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.PAYSCORE_API).build();

        ApiServiceOrderPayRequest request = new ApiServiceOrderPayRequest();
        request.setAppid(APPID);
        request.setMchid(MCHID);
        request.setServiceId(SERVICE_ID);
        String outOrderNo = String.format("%s_%d", "OUT", Instant.now().getLong(ChronoField.INSTANT_SECONDS));
        request.setOutOrderNo(outOrderNo);
        System.out.println(request);

        try {
            ApiServiceOrderPayResponse response = apiPayscoreService.serviceOrderPay(request);
            System.out.println(response);
            Assert.assertNotNull(response);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(), e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testCreditSrvSignApply() {
        ApiPayscoreService apiPayscoreService = new ApiPayscoreService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.PAYSCORE_API).build();

        ApiCreditSrvSignApplyRequest request = new ApiCreditSrvSignApplyRequest();
        request.setAppid(APPID);
        request.setMchid(MCHID);
        request.setServiceId(SERVICE_ID);
        String authorizationCode = String.format("%s_%d", "OUT", Instant.now().getLong(ChronoField.INSTANT_SECONDS));
        request.setAuthorizationCode(authorizationCode);
        request.setNotifyUrl("https://www.mock.douyinpay.com");
        request.setGoodsTag("{}");
        request.setExtInfo("{}");
        System.out.println(request);

        try {
            ApiCreditSrvSignApplyResponse response = apiPayscoreService.creditSrvSignApply(request);
            System.out.println(response);
            Assert.assertNotNull(response);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(), e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void testCreditSrvSignQuery() {
        ApiPayscoreService apiPayscoreService = new ApiPayscoreService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.PAYSCORE_API).build();

        ApiCreditSrvSignQueryRequest request = new ApiCreditSrvSignQueryRequest();
        request.setMchid(MCHID);
        request.setServiceId(SERVICE_ID);
        String authorizationCode = String.format("%s_%d", "OUT", Instant.now().getLong(ChronoField.INSTANT_SECONDS));
        request.setAuthorizationCode(authorizationCode);
        System.out.println(request);

        try {
            ApiCreditSrvSignQueryResponse response = apiPayscoreService.creditSrvSignQuery(request);
            System.out.println(response);
            Assert.assertNotNull(response);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(), e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testCloseCreditService() {
        ApiPayscoreService apiPayscoreService = new ApiPayscoreService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.PAYSCORE_API).build();

        ApiCloseCreditServiceRequest request = new ApiCloseCreditServiceRequest();
        request.setAppid(APPID);
        request.setMchid(MCHID);
        request.setServiceId(SERVICE_ID);
        String authorizationCode = String.format("%s_%d", "OUT", Instant.now().getLong(ChronoField.INSTANT_SECONDS));
        request.setAuthorizationCode(authorizationCode);
        request.setReason("测试");
        System.out.println(request);

        try {
            apiPayscoreService.closeCreditService(request);
            Assert.assertNotNull(0);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(), e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        DouyinpayClient douyinpayClient1 = init1();

        ApiPayscoreService apiPayscoreService = new ApiPayscoreService.Builder().douyinpayClient(douyinpayClient1).domainName(DomainName.PAYSCORE_API).build();

        ApiCloseCreditServiceRequest request = new ApiCloseCreditServiceRequest();
        request.setAppid(APPID);
        request.setMchid(MCHID);
        request.setServiceId(SERVICE_ID);
        String authorizationCode = String.format("%s_%d", "OUT", Instant.now().getLong(ChronoField.INSTANT_SECONDS));
        request.setAuthorizationCode(authorizationCode);
        request.setReason("测试");
        System.out.println(request);

        try {
            apiPayscoreService.closeCreditService(request);
            Assert.assertNotNull(0);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(), e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    public static DouyinpayClient init1() {
        GlobalConfig globalConfig = new GlobalConfig();

        globalConfig.setMchId(MCHID);
        globalConfig.setEncryptKey(ENCRYPT_KEY);
        globalConfig.setEncryptType(Constants.ENCRYPT_TYPE_AES);
        globalConfig.setSignType(Constants.SIGN_TYPE_RSA);
        globalConfig.setMerchantSerialNumber(MERCHANT_SERIAL_NO);

        // 二选一即可
        globalConfig.setPrivateKeyPath(MERCHANT_PRIVATE_KEY_PATH);
        globalConfig.setPrivateKey("QJvBrsJpzIz13JotzlwRPT45Vs2jWZA");

        //二选一即可,
        globalConfig.setPlatformCertPath(PLATFORM_CERTIFICATE_PATH);
        //globalConfig.setPlatformCertificate(PLATFORM_CERTIFICATE);


        Map<String, String> headerMap = new ConcurrentHashMap<>();

        globalConfig.setCustomHeaders(headerMap);

        douyinpayClient = new DefaultDouyinpayClient(globalConfig);
        return douyinpayClient;
    }

    @Test
    public void testCreditSrvSignApplyForSP() {
        ApiPayscoreService apiPayscoreService = new ApiPayscoreService.Builder()
                .douyinpayClient(douyinpayClient).domainName(DomainName.PAYSCORE_API).build();
        ApiCreditSrvSignApplyForSPRequest request = new ApiCreditSrvSignApplyForSPRequest();
        request.setSpMchid(SP_MCHID);
        request.setSpAppid(SP_APPID);
        request.setSubMchid(SUB_MCHID);
        request.setSubAppid(SUB_APPID);
        request.setServiceId(SERVICE_ID);
        request.setAuthorizationCode("AUTH_1666688488_1");
        request.setNotifyUrl("https://www.test.com");
        request.setAttach("attach");
        request.setGoodsTag("{}");
        request.setExtInfo("{}");
        request.setSceneInfo(new SceneInfo());
        request.getSceneInfo().setClientIp("127.0.0.1");
        request.getSceneInfo().setDeviceId("123456");
        request.getSceneInfo().setStoreInfo(new StoreInfo());
        request.getSceneInfo().getStoreInfo().setId("1");
        request.getSceneInfo().getStoreInfo().setName("测试门店");
        request.getSceneInfo().getStoreInfo().setAreaCode("100000");
        request.getSceneInfo().getStoreInfo().setAddress("1");
        System.out.println(request);
        try {
            ApiCreditSrvSignApplyForSPResponse response = apiPayscoreService.creditSrvSignApplyForSP(request);
            System.out.println(response);
            Assert.assertNotNull(response);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(), e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testCreditSrvSignQueryForSP() {
        ApiPayscoreService apiPayscoreService = new ApiPayscoreService.Builder()
                .douyinpayClient(douyinpayClient).domainName(DomainName.PAYSCORE_API).build();
        ApiCreditSrvSignQueryForSPRequest request = new ApiCreditSrvSignQueryForSPRequest();
        request.setSpMchid(SP_MCHID);
        request.setSubMchid(SUB_MCHID);
        request.setServiceId(SERVICE_ID);
        request.setAuthorizationCode("xxx");
        System.out.println(request);
        try {
            ApiCreditSrvSignQueryForSPResponse response = apiPayscoreService.creditSrvSignQueryForSP(request);
            System.out.println(response);
            Assert.assertNotNull(response);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(), e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testCloseCreditServiceForSP() {
        ApiPayscoreService apiPayscoreService = new ApiPayscoreService.Builder()
                .douyinpayClient(douyinpayClient).domainName(DomainName.PAYSCORE_API).build();
        ApiCreditSrvUnSignForSPRequest request = new ApiCreditSrvUnSignForSPRequest();
        request.setSpMchid(SP_MCHID);
        request.setSpAppid(SP_APPID);
        request.setSubMchid(SUB_MCHID);
        request.setSubAppid(SUB_APPID);
        request.setServiceId(SERVICE_ID);
        request.setAuthorizationCode("xxx");
        request.setReason("解约");
        System.out.println(request);
        try {
            apiPayscoreService.closeCreditServiceForSP(request);
            Assert.assertNotNull(0);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(), e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testCreateServiceOrderForSP() {
        ApiPayscoreService apiPayscoreService = new ApiPayscoreService.Builder()
                .douyinpayClient(douyinpayClient).domainName(DomainName.PAYSCORE_API).build();
        ApiCreateServiceOrderForSPRequest request = new ApiCreateServiceOrderForSPRequest();
        request.setSpMchid(SP_MCHID);
        request.setSpAppid(SP_APPID);
        request.setSubMchid(SUB_MCHID);
        request.setSubAppid(SUB_APPID);
        request.setServiceId(SERVICE_ID);
        request.setOutOrderNo("OUT_1666688488_10");
        request.setAuthorizationCode("xxx");
        request.setServiceIntroduction("某某酒店");
        request.setNotifyUrl("https://service-provider.example.com/callback");
        request.setAttach("attach");

        RiskFund riskFund = new RiskFund();
        riskFund.setAmount(3);
        riskFund.setName("ESTIMATE_ORDER_COST");
        riskFund.setDescription("预估订单费用");
        request.setRiskFund(riskFund);

        PostItem pi = new PostItem();
        pi.setAmount(3);
        pi.setCount(1);
        pi.setDescription("测试");
        pi.setName("测试");
        List<PostItem> postList = new ArrayList<>();
        postList.add(pi);
        request.setPostPayments(postList);

        PostItem pi2 = new PostItem();
        pi2.setAmount(1);
        pi2.setCount(1);
        pi2.setDescription("测试");
        pi2.setName("测试");
        List<PostItem> postList2 = new ArrayList<>();
        postList2.add(pi2);
        request.setPostDiscounts(postList2);

        TimeRange tr = new TimeRange();
        tr.setStartTime("20220806091010");
        tr.setStartTimeRemark("开始时间");
        tr.setEndTime("20220806091010");
        tr.setEndTimeRemark("结束时间");
        request.setTimeRange(tr);

        Location location = new Location();
        location.setStartLocation("北京市海淀区北三环西路43号");
        location.setEndLocation("北京市海淀区北三环西路43号");
        request.setLocation(location);

        SceneInfo sceneInfo = new SceneInfo();
        request.setSceneInfo(sceneInfo);
        sceneInfo.setClientIp("127.0.0.1");
        sceneInfo.setDeviceId("013467007045764");
        sceneInfo.setStoreInfo(new StoreInfo());
        request.getSceneInfo().getStoreInfo().setId("1");
        request.getSceneInfo().getStoreInfo().setName("测试门店");
        request.getSceneInfo().getStoreInfo().setAreaCode("100000");
        request.getSceneInfo().getStoreInfo().setAddress("1");

        request.setNeedUserConfirm(false);
        request.setGoodsTag("{}");
        request.setExtInfo("{}");
        System.out.println(request);
        try {
            ApiCreateServiceOrderForSPResponse response = apiPayscoreService.createServiceOrderForSP(request);
            System.out.println(response);
            Assert.assertNotNull(response);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(), e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testCompleteServiceOrderForSP() {
        ApiPayscoreService apiPayscoreService = new ApiPayscoreService.Builder()
                .douyinpayClient(douyinpayClient).domainName(DomainName.PAYSCORE_API).build();
        ApiCompleteServiceOrderForSPRequest request = new ApiCompleteServiceOrderForSPRequest();
        request.setSpMchid(SP_MCHID);
        request.setSpAppid(SP_APPID);
        request.setSubMchid(SUB_MCHID);
        request.setSubAppid(SUB_APPID);
        request.setServiceId(SERVICE_ID);
        request.setOutOrderNo("OUT_1666688488_10");
        request.setTotalAmount(2L);
        request.setAttach("attach");

        PostItem pi = new PostItem();
        pi.setAmount(3);
        pi.setCount(1);
        pi.setDescription("测试");
        pi.setName("测试");
        List<PostItem> postList = new ArrayList<>();
        postList.add(pi);
        request.setPostPayments(postList);

        PostItem pi2 = new PostItem();
        pi2.setAmount(1);
        pi2.setCount(1);
        pi2.setDescription("测试");
        pi2.setName("测试");
        List<PostItem> postList2 = new ArrayList<>();
        postList2.add(pi2);
        request.setPostDiscounts(postList2);

        TimeRange tr = new TimeRange();
        tr.setStartTime("20220806091010");
        tr.setStartTimeRemark("开始时间");
        tr.setEndTime("20220806091010");
        tr.setEndTimeRemark("结束时间");
        request.setTimeRange(tr);

        Location location = new Location();
        location.setStartLocation("北京市海淀区北三环西路43号");
        location.setEndLocation("北京市海淀区北三环西路43号");
        request.setLocation(location);

        SceneInfo sceneInfo = new SceneInfo();
        request.setSceneInfo(sceneInfo);
        sceneInfo.setClientIp("127.0.0.1");
        sceneInfo.setDeviceId("013467007045764");
        sceneInfo.setStoreInfo(new StoreInfo());
        request.getSceneInfo().getStoreInfo().setId("1");
        request.getSceneInfo().getStoreInfo().setName("测试门店");
        request.getSceneInfo().getStoreInfo().setAreaCode("100000");
        request.getSceneInfo().getStoreInfo().setAddress("1");

        request.setGoodsTag("{}");

        System.out.println(request);
        try {
            ApiCompleteServiceOrderForSPResponse response = apiPayscoreService.completeServiceOrderForSP(request);
            System.out.println(response);
            Assert.assertNotNull(response);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(), e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testQueryServiceOrderForSP() {
        ApiPayscoreService apiPayscoreService = new ApiPayscoreService.Builder()
                .douyinpayClient(douyinpayClient).domainName(DomainName.PAYSCORE_API).build();
        ApiQueryServiceOrderForSPRequest request = new ApiQueryServiceOrderForSPRequest();
        request.setSpMchid(SP_MCHID);
        request.setSpAppid(SP_APPID);
        request.setSubMchid(SUB_MCHID);
        request.setSubAppid("");
        request.setServiceId(SERVICE_ID);
        request.setOutOrderNo("OUT_1666688488_3");
        System.out.println(request);
        try {
            ApiQueryServiceOrderForSPResponse response = apiPayscoreService.queryServiceOrderForSP(request);
            System.out.println(response);
            Assert.assertNotNull(response);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(), e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testCancelServiceOrderForSP() {
        ApiPayscoreService apiPayscoreService = new ApiPayscoreService.Builder()
                .douyinpayClient(douyinpayClient).domainName(DomainName.PAYSCORE_API).build();
        ApiCancelServiceOrderForSPRequest request = new ApiCancelServiceOrderForSPRequest();
        request.setSpMchid(SP_MCHID);
        request.setSpAppid(SP_APPID);
        request.setSubMchid(SUB_MCHID);
        request.setSubAppid(SUB_APPID);
        request.setServiceId(SERVICE_ID);
        request.setOutOrderNo("OUT_1666688488_6");
        request.setReason("用户取消");

        System.out.println(request);
        try {
            ApiCancelServiceOrderForSPResponse response = apiPayscoreService.cancelServiceOrderForSP(request);
            System.out.println(response);
            Assert.assertNotNull(response);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(), e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testSynchronizeServiceOrderInfoForSP() {
        ApiPayscoreService apiPayscoreService = new ApiPayscoreService.Builder()
                .douyinpayClient(douyinpayClient).domainName(DomainName.PAYSCORE_API).build();
        ApiSynchronizeServiceOrderInfoForSPRequest request = new ApiSynchronizeServiceOrderInfoForSPRequest();
        request.setSpMchid(SP_MCHID);
        request.setSpAppid(SP_APPID);
        request.setSubMchid(SUB_MCHID);
        request.setSubAppid(SUB_APPID);
        request.setServiceId(SERVICE_ID);
        request.setType("ORDER_PAID");
        request.setOutOrderNo("OUT_1666688488_10");

        SyncDetail detail = new SyncDetail();
        detail.setPaidTime("20220806091010");
        request.setDetail(detail);
        System.out.println(request);
        try {
            apiPayscoreService.synchronizeServiceOrderInfoForSP(request);
            Assert.assertNotNull(0);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(), e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testModifyAmountForSP() {
        ApiPayscoreService apiPayscoreService = new ApiPayscoreService.Builder()
                .douyinpayClient(douyinpayClient).domainName(DomainName.PAYSCORE_API).build();
        ApiModifyAmountForSPRequest request = new ApiModifyAmountForSPRequest();
        request.setSpMchid(SP_MCHID);
        request.setSpAppid(SP_APPID);
        request.setSubMchid(SUB_MCHID);
        request.setSubAppid(SUB_APPID);
        request.setServiceId(SERVICE_ID);
        request.setOutOrderNo("OUT_1666688488_10");
        request.setTotalAmount(1L);
        request.setReason("修改原因");

        PostItem pi = new PostItem();
        pi.setAmount(2);
        pi.setCount(1);
        pi.setDescription("测试");
        pi.setName("测试");
        List<PostItem> postList = new ArrayList<>();
        postList.add(pi);
        request.setPostPayments(postList);

        PostItem pi2 = new PostItem();
        pi2.setAmount(1);
        pi2.setCount(1);
        pi2.setDescription("测试");
        pi2.setName("测试");
        List<PostItem> postList2 = new ArrayList<>();
        postList2.add(pi2);
        request.setPostDiscounts(postList2);

        System.out.println(request);
        try {
            ApiModifyAmountForSPResponse response = apiPayscoreService.modifyAmountForSP(request);
            System.out.println(response);
            Assert.assertNotNull(response);
        } catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n", e.getErrorCode(), e.getErrorMessage(), e.getResponseBody());
        } catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }
    }
}
