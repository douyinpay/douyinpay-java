package com.doupay.api.splitfund;

import com.douyinpay.api.DefaultDouyinpayClient;
import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.splitfund.ApiSplitFundPaymentsService;
import com.douyinpay.api.splitfund.models.*;
import com.douyinpay.define.Constants;
import com.douyinpay.define.DomainName;
import com.douyinpay.define.GlobalConfig;
import com.douyinpay.exception.DouyinpayException;
import com.douyinpay.exception.ServiceException;
import com.douyinpay.util.GsonUtil;
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
        //globalConfig.setPrivateKey(MERCHANT_PRIVATE_KEY);

        //二选一即可,
        globalConfig.setPlatformCertPath(PLATFORM_CERTIFICATE_PATH);
        //globalConfig.setPlatformCertificate(PLATFORM_CERTIFICATE);


        Map<String, String> headerMap = new ConcurrentHashMap<>();

        globalConfig.setCustomHeaders(headerMap);

        douyinpayClient = new DefaultDouyinpayClient(globalConfig);
    }

    @Test
    public void testSplitFund() {
        ApiSplitFundPaymentsService service = new ApiSplitFundPaymentsService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();

        ApiSplitFundRequest request = new ApiSplitFundRequest();
        String OUT_TRADE_NO = "";
        String TRADE_NO = "";
        String RECEIVER_ACCOUNT = "";
        Integer SPLIT_AMOUNT = 0; // 分账金额测试时修改;
        String SPLIT_DESC = "";
        request.setAppId(APPID);
        request.setMerchantId(MCHID);
        request.setOutTradeNo(OUT_TRADE_NO);
        request.setTradeNo(TRADE_NO);
        request.setUnfreezeUnsplit(true);
        List<ReceiverInfoDto> receiverInfoDtos = new ArrayList<>();
        ReceiverInfoDto infoDto = new ReceiverInfoDto();
        receiverInfoDtos.add(infoDto);
        infoDto.setType(SplitFundReceiverType.MERCHANT_ID);
        infoDto.setAccount(RECEIVER_ACCOUNT);
        infoDto.setAmount(SPLIT_AMOUNT);
        infoDto.setDescription(SPLIT_DESC);
        request.setReceiverInfoDtos(receiverInfoDtos);

        try {
            ApiSplitFundResponse response = service.splitFund(request);
            System.out.println(GsonUtil.objectToJson(response));
            Assert.assertNotNull(response);
        }catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n",e.getErrorCode(),e.getErrorMessage(),e.getResponseBody());
        }catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void testQuerySplitFund() {
        ApiSplitFundPaymentsService service = new ApiSplitFundPaymentsService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();

        String OUT_TRADE_NO = "";
        String TRADE_NO = "";
        ApiQuerySplitFundRequest request = new ApiQuerySplitFundRequest();
        request.setMerchantId(MCHID);
        request.setTradeNo(TRADE_NO);
        request.setOutTradeNo(OUT_TRADE_NO);

        try {
            ApiQuerySplitFundResponse response = service.querySplitFund(request);
            System.out.println(GsonUtil.objectToJson(response));
            Assert.assertNotNull(response);
            Assert.assertNotNull(response.getTradeNo());
            Assert.assertFalse(response.getTradeNo().isEmpty());
        }catch (ServiceException e) {
            System.out.printf("code:%s,message:%s,httpbody:%s\n",e.getErrorCode(),e.getErrorMessage(),e.getResponseBody());
        }catch (DouyinpayException e) {
            System.out.println(e.getMessage());
        }

    }
}
