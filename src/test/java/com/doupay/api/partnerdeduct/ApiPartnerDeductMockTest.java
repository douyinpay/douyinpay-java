package com.doupay.api.partnerdeduct;
import org.junit.Assert;
import org.junit.Test;

import com.doupay.api.secret.PartnerConfig;
import com.douyinpay.api.contract.models.ApiDetail;
import com.douyinpay.api.contract.models.ApiGoodsDetail;
import com.douyinpay.api.contract.models.ApiSceneInfo;
import com.douyinpay.api.partnerdeduct.ApiPartnerDeductService;
import com.douyinpay.api.partnerdeduct.models.ApiPartnerContractScheduleRequest;
import com.douyinpay.api.partnerdeduct.models.ApiPartnerContractScheduleResponse;
import com.douyinpay.api.partnerdeduct.models.ApiPartnerDeductRequest;
import com.douyinpay.api.partnerdeduct.models.ApiPartnerDeductResponse;
import com.douyinpay.api.partnerdeduct.models.ScheduleAmount;
import com.douyinpay.api.partnerdeduct.models.ApiPartnerQueryContractScheduleResponse;
import com.douyinpay.api.partnerdeduct.models.ApiPartnerQueryContractScheduleRequest;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class ApiPartnerDeductMockTest {

    @Test
    public void testDeduct() {
       ApiPartnerDeductService apiPartnerDeductService = mock(ApiPartnerDeductService.class);
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

       ApiSceneInfo apiSceneInfo = new ApiSceneInfo();
       apiSceneInfo.setPayerClientIp("14.23.150.211");
       apiSceneInfo.setDeviceId("013467007045764");
       ApiPartnerDeductResponse resp = new ApiPartnerDeductResponse();
       resp.setResultCode("SUCCESS");
       when(apiPartnerDeductService.partnerDeduct(req)).thenReturn(resp);

       ApiPartnerDeductResponse result = apiPartnerDeductService.partnerDeduct(req);
       Assert.assertNotNull(result);
       Assert.assertEquals("SUCCESS",result.getResultCode());

    }

    @Test
    public void testSchedule(){
        ApiPartnerDeductService apiPartnerDeductService = mock(ApiPartnerDeductService.class);
        ApiPartnerContractScheduleRequest req = new ApiPartnerContractScheduleRequest();
        req.setContractId("");
        req.setSpMchid(PartnerConfig.SP_MCHID);
        req.setSubMchid("");
        ScheduleAmount scheduleAmount = new ScheduleAmount();
        scheduleAmount.setTotal(100);
        scheduleAmount.setCurrency("CNY");
        req.setScheduleAmount(scheduleAmount);
        
        ApiPartnerContractScheduleResponse resp = new ApiPartnerContractScheduleResponse();
        resp.setDeductEndDate("2025-09-10");
        resp.setDeductStartDate("2025-09-04");
        when(apiPartnerDeductService.partnerContractSchedule(req)).thenReturn(resp);
        ApiPartnerContractScheduleResponse result = apiPartnerDeductService.partnerContractSchedule(req);
        Assert.assertNotNull(result);
        Assert.assertEquals("2025-09-10",result.getDeductEndDate());
    }
    

    @Test
    public void testQuerySchedule() {
        ApiPartnerDeductService apiPartnerDeductService = mock(ApiPartnerDeductService.class);
        ApiPartnerQueryContractScheduleRequest req = new ApiPartnerQueryContractScheduleRequest();
        req.setContractId("");
        req.setSpMchid(PartnerConfig.SP_MCHID);
        req.setSubMchid("");
        ApiPartnerQueryContractScheduleResponse resp = new ApiPartnerQueryContractScheduleResponse();
        resp.setScheduleState("schedule");
        when(apiPartnerDeductService.partnerQueryContractSchedule(req)).thenReturn(resp);
        ApiPartnerQueryContractScheduleResponse result = apiPartnerDeductService.partnerQueryContractSchedule(req);
        Assert.assertNotNull(result);
        Assert.assertEquals("schedule",result.getScheduleState());
    }

}
