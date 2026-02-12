package com.doupay.api.payments.creditcontract;

import com.douyinpay.api.DefaultDouyinpayClient;
import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.payments.common.ApiTransaction;
import com.douyinpay.api.payments.creditcontract.ApiCreditContractPaymentsService;
import com.douyinpay.api.payments.creditcontract.models.*;
import com.douyinpay.define.Constants;
import com.douyinpay.define.DomainName;
import com.douyinpay.define.GlobalConfig;
import com.douyinpay.exception.DouyinpayException;
import com.douyinpay.exception.ServiceException;
import com.douyinpay.util.GsonUtil;
import org.junit.Assert;
import org.junit.Before;
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

public class ApiCreditContractTest {
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
    public  static void init() {
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
    public void testPrepayApp() {

        ApiCreditContractPaymentsService apiCreditContractPaymentsService = new ApiCreditContractPaymentsService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();

        ApiPrepayRequest request = new ApiPrepayRequest();
        request.setAppid(APPID);
        request.setMchid(MCHID);
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

        ApiSettleInfo apiSettleInfo = new ApiSettleInfo();
        apiSettleInfo.setProfitSharing(false);

        ContractInfo contractInfo = new ContractInfo();
        contractInfo.setContractAppId(APPID);
        contractInfo.setContractMerchantId(MCHID);
        contractInfo.setContractDisplayAccount("test");
        contractInfo.setContractNotifyUrl("https://www.mock.douyinpay.com");
        contractInfo.setOutContractCode("contract"+  Instant.now().getLong(ChronoField.INSTANT_SECONDS));
        contractInfo.setServiceId("569");
        contractInfo.setRequestSerial(1L);

        request.setDetail(apiDetail);
        request.setSceneInfo(apiSceneInfo);
        request.setSettleInfo(apiSettleInfo);
        request.setContractInfo(contractInfo);
        request.setTradeType(TradeType.TradeTypeApp);


        System.out.println(GsonUtil.objectToJson(request));
        try {
            ApiPrepayResponse prepayResponse = apiCreditContractPaymentsService.prepay(request);
            System.out.println(prepayResponse);
            Assert.assertNotNull(prepayResponse);

            Assert.assertNotNull(prepayResponse.getPrepayId());
        }catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n",e.getErrorCode(),e.getErrorMessage(),e.getResponseBody());
        }catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }

    }


    @Test
    public void testPrepayJSAPI() {

        ApiCreditContractPaymentsService apiCreditContractPaymentsService = new ApiCreditContractPaymentsService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();

        ApiPrepayRequest request = new ApiPrepayRequest();
        request.setAppid(APPID);
        request.setMchid(MCHID);
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

        request.setOpenId("invalidopenid");
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

        ApiSettleInfo apiSettleInfo = new ApiSettleInfo();
        apiSettleInfo.setProfitSharing(false);

        ContractInfo contractInfo = new ContractInfo();
        contractInfo.setContractAppId(APPID);
        contractInfo.setContractMerchantId(MCHID);
        contractInfo.setContractDisplayAccount("test");
        contractInfo.setContractNotifyUrl("https://www.mock.douyinpay.com");
        contractInfo.setOutContractCode("contract"+  Instant.now().getLong(ChronoField.INSTANT_SECONDS));
        contractInfo.setServiceId("569");
        contractInfo.setRequestSerial(1L);

        request.setDetail(apiDetail);
        request.setSceneInfo(apiSceneInfo);
        request.setSettleInfo(apiSettleInfo);
        request.setContractInfo(contractInfo);
        request.setTradeType(TradeType.TradeTypeJsapi);


        System.out.println(GsonUtil.objectToJson(request));
        try {
            ApiPrepayResponse prepayResponse = apiCreditContractPaymentsService.prepay(request);
            System.out.println(prepayResponse);
            Assert.assertNotNull(prepayResponse);

            Assert.assertNotNull(prepayResponse.getPrepayId());
        }catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n",e.getErrorCode(),e.getErrorMessage(),e.getResponseBody());
        }catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }

    }
    @Test
    public void testCloseOrder() {
        ApiCreditContractPaymentsService apiCreditContractPaymentsService = new ApiCreditContractPaymentsService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
        String outTradeNo = "OUT_1729144829";
        ApiCloseOrderRequest request = new ApiCloseOrderRequest();
        request.setMchid(MCHID);
        request.setOutTradeNo(outTradeNo);
        try {
            apiCreditContractPaymentsService.closeOrder(request);
            Assert.assertNotNull(request);

        }catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n",e.getErrorCode(),e.getErrorMessage(),e.getResponseBody());
            Assert.assertNotNull(request);
        }catch (DouyinpayException e) {
            System.out.println(e.getMessage());
            Assert.assertNotNull(request);
        }
    }


    @Test
    public void testQueryOrderByOutTradeNo() {
        ApiCreditContractPaymentsService apiCreditContractPaymentsService = new ApiCreditContractPaymentsService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
        String outTradeNo = "OUT_1729144829";
        ApiQueryOrderByOutTradeNoRequest request = new ApiQueryOrderByOutTradeNoRequest();
        request.setMchid(MCHID);
        request.setOutTradeNo(outTradeNo);
        try {
            ApiTransaction response = apiCreditContractPaymentsService.queryOrderByOutTradeNo(request);
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
        ApiCreditContractPaymentsService apiCreditContractPaymentsService = new ApiCreditContractPaymentsService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
        String id = "2105012410170500033671971584";
        ApiQueryOrderByIdRequest request = new ApiQueryOrderByIdRequest();
        request.setMchid(MCHID);
        request.setTransactionId(id);
        try {
            ApiTransaction response = apiCreditContractPaymentsService.queryOrderById(request);
            System.out.println(response);
            Assert.assertNotNull(response);
        }catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n",e.getErrorCode(),e.getErrorMessage(),e.getResponseBody());
        }catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }

    }
}
