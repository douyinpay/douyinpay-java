package com.doupay.api.contract;

import com.doupay.api.secret.Config;
import org.junit.Assert;
import org.junit.Test;

import com.doupay.api.secret.PartnerConfig;
import com.douyinpay.api.contract.models.Amount;
import com.douyinpay.api.partnercontract.ApiPartnerContractService;
import com.douyinpay.api.partnercontract.models.ApiPartnerQueryContractResponse;
import com.douyinpay.api.partnercontract.models.ApiPartnerQueryContractRequest;
import com.douyinpay.api.partnercontract.models.ApiPartnerTerminateContractRequest;
import com.douyinpay.api.partnercontract.models.ApiPartnerTerminateContractResponse;
import com.douyinpay.api.partnercontractorder.ApiPartnerContractOrderService;
import com.douyinpay.api.partnercontractorder.models.ApiPartnerContractOrderRequest;
import com.douyinpay.api.partnercontractorder.models.ApiPartnerContractOrderResponse;

import static org.mockito.Mockito.*;

public class ApiPartnerContractMockTest {
    
    @Test
    public void partnerQueryContractTest(){
        ApiPartnerQueryContractRequest req = new ApiPartnerQueryContractRequest();
        req.setOutContractCode(PartnerConfig.CONTRACT_CODE);
        req.setSpMchid(PartnerConfig.SP_MCHID);
        req.setSubMchid(PartnerConfig.SUB_MCHID);
        req.setPlanId(1781);
        System.out.println(req);
        ApiPartnerContractService apiContractService = mock(ApiPartnerContractService.class);
        ApiPartnerQueryContractResponse resp = new ApiPartnerQueryContractResponse();
        resp.setContractId(PartnerConfig.CONTRACT_ID);
        when(apiContractService.partnerQueryContract(req)).thenReturn(resp);
        ApiPartnerQueryContractResponse result = apiContractService.partnerQueryContract(req);
        Assert.assertNotNull(result);
        Assert.assertEquals(resp.getContractId(), result.getContractId());
    }

    @Test
    public void partnerTerminateContractTest(){
        ApiPartnerContractService apiContractService = mock(ApiPartnerContractService.class);
        ApiPartnerTerminateContractRequest req = new ApiPartnerTerminateContractRequest();
        req.setOutContractCode(PartnerConfig.CONTRACT_CODE);
        req.setSpMchid(PartnerConfig.SP_MCHID);
        req.setSubMchid(PartnerConfig.SUB_MCHID);
        req.setPlanId(1781);
        req.setContractTerminationRemark("测试解约");
        ApiPartnerTerminateContractResponse resp = new ApiPartnerTerminateContractResponse();
        resp.setContractId(PartnerConfig.CONTRACT_ID);
        when(apiContractService.partnerTerminateContract(req)).thenReturn(resp);
        ApiPartnerTerminateContractResponse result = apiContractService.partnerTerminateContract(req);
        Assert.assertNotNull(result);
        Assert.assertEquals(resp.getContractId(), result.getContractId());
    }
           



    @Test
    public void partnerContractOrderTest(){
        ApiPartnerContractOrderService apiContractService = mock(ApiPartnerContractOrderService.class);
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
        ApiPartnerContractOrderResponse resp = new ApiPartnerContractOrderResponse();
        resp.setPrepayId(Config.CONTRACT_ID);
        when(apiContractService.partnerContractOrder(req)).thenReturn(resp);
        ApiPartnerContractOrderResponse result = apiContractService.partnerContractOrder(req);
        Assert.assertNotNull(result);
        Assert.assertEquals(resp.getPrepayId(), result.getPrepayId());
        }
}
