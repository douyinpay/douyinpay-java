package com.doupay.api.bill;

import com.douyinpay.api.DefaultDouyinpayClient;
import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.bill.ApiBillService;
import com.douyinpay.api.bill.models.ApiBillApplyRequest;
import com.douyinpay.api.bill.models.ApiBillReponse;
import com.douyinpay.api.bill.models.ApplyFundFlowBillRequest;
import com.douyinpay.api.bill.models.ApplySplitBillRequest;
import com.douyinpay.define.Constants;
import com.douyinpay.define.DomainName;
import com.douyinpay.define.GlobalConfig;
import com.douyinpay.util.PemUtil;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApiBillTest {

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
        //globalConfig.setPrivateKey(MERCHANT_PRIVATE_KEY_RSA);

        //二选一即可,
        globalConfig.setPlatformCertPath(PLATFORM_CERTIFICATE_PATH);
        //globalConfig.setPlatformCertificate(PLATFORM_CERTIFICATE);


        Map<String, String> headerMap = new ConcurrentHashMap<>();
        globalConfig.setCustomHeaders(headerMap);

        douyinpayClient = new DefaultDouyinpayClient(globalConfig);
    }

    @Test
    public void testBillApply(){
        ApiBillService apiBillService = new ApiBillService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
        ApiBillApplyRequest req = new ApiBillApplyRequest();
        req.setBillDate("2025-06-10");
        req.setBillType("TRADE");
        req.setMchid(MCHID);
        req.setTarType("GZIP");
        System.out.println(req);
        ApiBillReponse resp = apiBillService.billApply(req);
        System.out.println(resp);
        Assert.assertNotNull(resp);

    }

    @Test
    public void testApplySettlementBill(){
        ApiBillService apiBillService = new ApiBillService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
        ApiBillApplyRequest req = new ApiBillApplyRequest();
        req.setBillDate("2025-06-10");
        req.setBillType("SETTLEMENT");
        req.setMchid(MCHID);
        req.setTarType("GZIP");
        System.out.println(req);
        ApiBillReponse resp = apiBillService.billApply(req);
        System.out.println(resp);
        Assert.assertNotNull(resp);

    }

    @Test
    public void testApplyFundFlowBill(){
        ApiBillService apiBillService = new ApiBillService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
        ApplyFundFlowBillRequest req = new ApplyFundFlowBillRequest();
        req.setBillDate("2025-06-10");
        req.setAccountType("BaseAccount");
        req.setMchid(MCHID);
        req.setTarType("GZIP");
        System.out.println(req);
        ApiBillReponse resp = apiBillService.applyFundFlowBill(req);
        System.out.println(resp);
        Assert.assertNotNull(resp);

    }

    @Test
    public void testApplySplitBill(){
        ApiBillService apiBillService = new ApiBillService.Builder().douyinpayClient(douyinpayClient).domainName(DomainName.API).build();
        ApplySplitBillRequest req = new ApplySplitBillRequest();
        req.setBillDate("2025-06-10");
        req.setMchid(MCHID);
        req.setTarType("GZIP");
        System.out.println(req);
        ApiBillReponse resp = apiBillService.applySplitBill(req);
        System.out.println(resp);
        Assert.assertNotNull(resp);

    }
}
