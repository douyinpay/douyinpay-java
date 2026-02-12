package com.doupay.api.contract;
import com.doupay.api.secret.Config;
import com.douyinpay.api.contract.ApiContractService;
import com.douyinpay.api.contract.models.ApiH5EntrustWebRequest;
import com.douyinpay.api.contract.models.ApiH5EntrustWebResponse;
import com.douyinpay.api.contract.models.ApiPreEntrustWebRequest;
import com.douyinpay.api.contract.models.ApiPreEntrustWebResponse;
import com.douyinpay.api.contract.models.ApiQueryContractRequest;
import com.douyinpay.api.contract.models.ApiQueryContractResponse;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class ApiContractMockTest {


    @Test // 测试方法   
    public void preEntrustWebMockTest() {
        ApiPreEntrustWebRequest req = new ApiPreEntrustWebRequest();
        req.setAppid(Config.APPID);
        req.setMchid(Config.MCHID);
        req.setOutContractCode(Config.CONTRACT_ID);
        req.setPlanId("141"); 
        req.setRequestSerial(9223372036854775807L);
        req.setContractDisplayAccount("13000000000");
        req.setNotifyUrl("https://123.com");
        req.setContractExt("{\"goods_tag\":\"{\\\"product_tag\\\":\\\"商品信息\\\",\\\"third_part_right_info\\\":\\\"{\\\\\\\"right_id\\\\\\\":\\\\\\\"123\\\\\\\",\\\\\\\"prize_type\\\\\\\":\\\\\\\"XXX\\\\\\\"}\\\"}\"}");
        System.out.println(req);
        ApiContractService apiContractService = mock(ApiContractService.class);
        ApiPreEntrustWebResponse resp = new ApiPreEntrustWebResponse();
        resp.setPreEntrustwebId("2025091714224453309325828");
        when(apiContractService.preEntrustWeb(req)).thenReturn(resp);
        ApiPreEntrustWebResponse result = apiContractService.preEntrustWeb(req); // 调用被测试的方法
        Assert.assertNotNull(result);
        Assert.assertEquals(resp.getPreEntrustwebId(), result.getPreEntrustwebId());
    }

    @Test
    public void h5EntrustWebMockTest() {
        ApiH5EntrustWebRequest req = new ApiH5EntrustWebRequest();
        req.setAppid(Config.APPID);
        req.setMchid(Config.MCHID);
        req.setOutContractCode(Config.CONTRACT_ID);
        req.setPlanId("141"); 
        req.setRequestSerial(1000L);
        req.setContractDisplayAccount("13000000000");
        req.setNotifyUrl("https://123.com");
        req.setContractExt("{\"goods_tag\":\"{\\\"product_tag\\\":\\\"商品信息\\\",\\\"third_part_right_info\\\":\\\"{\\\\\\\"right_id\\\\\\\":\\\\\\\"123\\\\\\\",\\\\\\\"prize_type\\\\\\\":\\\\\\\"XXX\\\\\\\"}\\\"}\"}");
        req.setTimestamp("1414488825");
        req.setClientip("119.145.83.6");
        System.out.println(req);
        ApiContractService apiContractService = mock(ApiContractService.class);
        ApiH5EntrustWebResponse resp = new ApiH5EntrustWebResponse();
        resp.setRedirectUrl("https://cashier.douyinpay.com/bytepay-cashdesk/bytepay-invoke?product_type=sign&pre_entrustweb_id=2025090411141250046155273");
        when(apiContractService.h5EntrustWeb(req)).thenReturn(resp);
        ApiH5EntrustWebResponse result = apiContractService.h5EntrustWeb(req); // 调用被测试的方法
        Assert.assertNotNull(result);
        Assert.assertEquals(resp.getRedirectUrl(), result.getRedirectUrl());
    }

    @Test
    public void queryContractMockTest() {
        ApiContractService apiContractService = mock(ApiContractService.class);
        ApiQueryContractRequest req = new ApiQueryContractRequest();
        req.setContractId(Config.CONTRACT_ID);
        req.setAppid(Config.APPID);
        req.setMchid(Config.MCHID);  
        ApiQueryContractResponse resp = new ApiQueryContractResponse();
        resp.setContractStatus("1");
        when(apiContractService.queryContract(req)).thenReturn(resp);
        ApiQueryContractResponse result = apiContractService.queryContract(req); // 调用被测试的方法
        Assert.assertNotNull(result);
        Assert.assertEquals(resp.getContractStatus(), result.getContractStatus());
    }   


}
