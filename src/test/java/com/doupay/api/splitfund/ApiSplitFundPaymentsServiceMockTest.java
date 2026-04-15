package com.doupay.api.splitfund;

import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;

import com.doupay.api.secret.Config;
import com.douyinpay.api.splitfund.ApiSplitFundPaymentsService;
import com.douyinpay.api.splitfund.models.ApiDeleteSplitReceiverRequest;
import com.douyinpay.api.splitfund.models.ApiDeleteSplitReceiverResponse;
import com.douyinpay.api.splitfund.models.ApiFinishSplitFundRequest;
import com.douyinpay.api.splitfund.models.ApiFinishSplitFundResponse;
import com.douyinpay.api.splitfund.models.ApiQuerySplitFundRequest;
import com.douyinpay.api.splitfund.models.ApiQuerySplitFundResponse;
import com.douyinpay.api.splitfund.models.ApiQueryReturnSplitFundRequest;
import com.douyinpay.api.splitfund.models.ApiQueryReturnSplitFundResponse;
import com.douyinpay.api.splitfund.models.ApiQueryUnSplitFundRequest;
import com.douyinpay.api.splitfund.models.ApiQueryUnSplitFundResponse;
import com.douyinpay.api.splitfund.models.ApiReturnSplitFundRequest;
import com.douyinpay.api.splitfund.models.ApiReturnSplitFundResponse;
import com.douyinpay.api.splitfund.models.ApiSplitFundRequest;
import com.douyinpay.api.splitfund.models.ApiSplitFundResponse;
import com.douyinpay.api.splitfund.models.ReceiverInfoDto;
import com.douyinpay.api.splitfund.models.ReceiverSplitResultDto;
import com.douyinpay.api.splitfund.models.SplitFundReceiverType;

import java.util.ArrayList;
import java.util.List;

public class ApiSplitFundPaymentsServiceMockTest {

    @Test
    public void testSplitFund() {
        ApiSplitFundPaymentsService service = mock(ApiSplitFundPaymentsService.class);

        ReceiverInfoDto receiverInfoDto = new ReceiverInfoDto();
        receiverInfoDto.setType(SplitFundReceiverType.MERCHANT_ID);
        receiverInfoDto.setAccount("6020231219024876");
        receiverInfoDto.setAmount(10);
        receiverInfoDto.setDescription("测试分账");
        List<ReceiverInfoDto> receiverInfoDtos = new ArrayList<>();
        receiverInfoDtos.add(receiverInfoDto);

        ApiSplitFundRequest request = new ApiSplitFundRequest();
        request.setAppId(Config.APPID);
        request.setMerchantId(Config.MCHID);
        request.setTradeNo("TP2022101317144741443210681000");
        request.setOutTradeNo("OUT_31357802300250606199830");
        request.setReceiverInfoDtos(receiverInfoDtos);
        request.setUnfreezeUnsplit(false);

        ApiSplitFundResponse expectedResponse = new ApiSplitFundResponse();
        expectedResponse.setTradeNo("TP2022101317144741443210681000");
        expectedResponse.setOutTradeNo("OUT_31357802300250606199830");
        expectedResponse.setOrderId("11777200250103110500000223512022");

        when(service.splitFund(request)).thenReturn(expectedResponse);
        ApiSplitFundResponse response = service.splitFund(request);
        Assert.assertNotNull(response);
        Assert.assertEquals("TP2022101317144741443210681000", response.getTradeNo());
        Assert.assertEquals("OUT_31357802300250606199830", response.getOutTradeNo());
        Assert.assertEquals("11777200250103110500000223512022", response.getOrderId());
    }

    @Test
    public void testQuerySplitFund() {
        ApiSplitFundPaymentsService service = mock(ApiSplitFundPaymentsService.class);

        ApiQuerySplitFundRequest request = new ApiQuerySplitFundRequest();
        request.setMerchantId(Config.MCHID);
        request.setTradeNo("TP2022101317144741443210681000");
        request.setOutTradeNo("OUT_31357802300250606199830");
        request.setOrderId("11777200250103110500000223512022");

        ReceiverSplitResultDto receiverSplitResultDto = new ReceiverSplitResultDto();
        receiverSplitResultDto.setAmount(10);
        receiverSplitResultDto.setDescription("测试分账");
        receiverSplitResultDto.setType(SplitFundReceiverType.MERCHANT_ID);
        receiverSplitResultDto.setAccount("6020231219024876");
        receiverSplitResultDto.setResult("SUCCESS");
        receiverSplitResultDto.setCreateTime("2025-01-03T11:46:32+08:00");
        receiverSplitResultDto.setFinishTime("2025-01-03T11:46:33+08:00");
        receiverSplitResultDto.setDetailId("11777200250103110500000222552022");
        List<ReceiverSplitResultDto> receiverSplitResultDtos = new ArrayList<>();
        receiverSplitResultDtos.add(receiverSplitResultDto);

        ApiQuerySplitFundResponse expectedResponse = new ApiQuerySplitFundResponse();
        expectedResponse.setTradeNo("TP2022101317144741443210681000");
        expectedResponse.setOutTradeNO("OUT_31357802300250606199830");
        expectedResponse.setOrderId("11777200250103110500000223512022");
        expectedResponse.setState("FINISHED");
        expectedResponse.setReceiverSplitResultDtos(receiverSplitResultDtos);
        expectedResponse.setFinishAmount(10);
        expectedResponse.setFinishDescription("分账完成");
        expectedResponse.setSplitFinishTime("2025-01-03T11:46:33+08:00");

        when(service.querySplitFund(request)).thenReturn(expectedResponse);
        ApiQuerySplitFundResponse response = service.querySplitFund(request);
        Assert.assertNotNull(response);
        Assert.assertEquals("FINISHED", response.getState());
        Assert.assertEquals(Integer.valueOf(10), response.getFinishAmount());
        Assert.assertEquals(1, response.getReceiverSplitResultDtos().size());
        Assert.assertEquals("SUCCESS", response.getReceiverSplitResultDtos().get(0).getResult());
    }

    @Test
    public void testReturnSplitFund() {
        ApiSplitFundPaymentsService service = mock(ApiSplitFundPaymentsService.class);

        ApiReturnSplitFundRequest request = new ApiReturnSplitFundRequest();
        request.setMerchantId(Config.MCHID);
        request.setOrderId("11777200250103110500000223512022");
        request.setOutOrderNo("OUT_31357802300250606199830");
        request.setOutReturnNo("OUT_338004");
        request.setReturnMchid("6020231219024876");
        request.setAmount(10);
        request.setDescription("退分账");

        ApiReturnSplitFundResponse expectedResponse = new ApiReturnSplitFundResponse();
        expectedResponse.setOutOrderNo("OUT_31357802300250606199830");
        expectedResponse.setOutReturnNo("OUT_338004");
        expectedResponse.setReturnId("11777200250103110500000222552022");
        expectedResponse.setReturnMchid("6020231219024876");
        expectedResponse.setAmount(10);
        expectedResponse.setDescription("退分账测试");
        expectedResponse.setResult("SUCCESS");
        expectedResponse.setCreateTime("2025-01-03T11:46:32+08:00");
        expectedResponse.setFinishTime("2025-01-03T11:46:33+08:00");

        when(service.returnSplitFund(request)).thenReturn(expectedResponse);
        ApiReturnSplitFundResponse response = service.returnSplitFund(request);
        Assert.assertNotNull(response);
        Assert.assertEquals("OUT_338004", response.getOutReturnNo());
        Assert.assertEquals("SUCCESS", response.getResult());
        Assert.assertEquals(Integer.valueOf(10), response.getAmount());
    }

    @Test
    public void testQueryReturnSplitFund() {
        ApiSplitFundPaymentsService service = mock(ApiSplitFundPaymentsService.class);

        String outReturnNo = "OUT_3380044";
        ApiQueryReturnSplitFundRequest request = new ApiQueryReturnSplitFundRequest();
        request.setOutReturnNo(outReturnNo);
        request.setMerchantId(Config.MCHID);
        request.setOutOrderNo("OUT_3135780230025060619983");

        ApiQueryReturnSplitFundResponse expectedResponse = new ApiQueryReturnSplitFundResponse();
        expectedResponse.setOrderId("11777200250103120500000220632022");
        expectedResponse.setOutOrderNo("OUT_3135780230025060619983");
        expectedResponse.setOutReturnNo(outReturnNo);
        expectedResponse.setReturnId("11777200250103120500000239102022");
        expectedResponse.setReturnMchid("6020240223833009");
        expectedResponse.setAmount(10);
        expectedResponse.setDescription("退分账测试");
        expectedResponse.setResult("SUCCESS");
        expectedResponse.setCreateTime("2025-01-03T12:05:34+08:00");
        expectedResponse.setFinishTime("2025-01-03T12:05:34+08:00");

        when(service.queryReturnSplitFund(request)).thenReturn(expectedResponse);
        ApiQueryReturnSplitFundResponse response = service.queryReturnSplitFund(request);
        Assert.assertNotNull(response);
        Assert.assertEquals(outReturnNo, response.getOutReturnNo());
        Assert.assertEquals("SUCCESS", response.getResult());
        Assert.assertEquals("11777200250103120500000220632022", response.getOrderId());
    }

    @Test
    public void testFinishSplitFund() {
        ApiSplitFundPaymentsService service = mock(ApiSplitFundPaymentsService.class);

        ApiFinishSplitFundRequest request = new ApiFinishSplitFundRequest();
        request.setTransactionId("TP2022101317144741443210681000");
        request.setOutOrderNo("OUT_1666688488");
        request.setMerchantId(Config.MCHID);
        request.setDescription("测试商品分账");
        request.setNotifyUrl("https://www.mock.douyinpay.com");

        ApiFinishSplitFundResponse expectedResponse = new ApiFinishSplitFundResponse();
        expectedResponse.setMerchantId(Config.MCHID);
        expectedResponse.setTransactionId("TP2022101317144741443210681000");
        expectedResponse.setOutOrderNo("OUT_1666688488");
        expectedResponse.setOrderId("11777200260111180300003115170066");

        when(service.finishSplitFund(request)).thenReturn(expectedResponse);
        ApiFinishSplitFundResponse response = service.finishSplitFund(request);
        Assert.assertNotNull(response);
        Assert.assertEquals("TP2022101317144741443210681000", response.getTransactionId());
        Assert.assertEquals("OUT_1666688488", response.getOutOrderNo());
        Assert.assertEquals("11777200260111180300003115170066", response.getOrderId());
    }

    @Test
    public void testQueryUnSplitFund() {
        ApiSplitFundPaymentsService service = mock(ApiSplitFundPaymentsService.class);

        String transactionId = "TP2022101317144741443210681000";
        ApiQueryUnSplitFundRequest request = new ApiQueryUnSplitFundRequest();
        request.setTransactionId(transactionId);
        request.setMerchantId(Config.MCHID);

        ApiQueryUnSplitFundResponse expectedResponse = new ApiQueryUnSplitFundResponse();
        expectedResponse.setMerchantId(Config.MCHID);
        expectedResponse.setTransactionId(transactionId);
        expectedResponse.setUnsplitAmount(100);

        when(service.queryUnSplitFund(request)).thenReturn(expectedResponse);
        ApiQueryUnSplitFundResponse response = service.queryUnSplitFund(request);
        Assert.assertNotNull(response);
        Assert.assertEquals(transactionId, response.getTransactionId());
        Assert.assertEquals(Integer.valueOf(100), response.getUnsplitAmount());
    }

    @Test
    public void testDeleteSplitReceiver() {
        ApiSplitFundPaymentsService service = mock(ApiSplitFundPaymentsService.class);

        ApiDeleteSplitReceiverRequest request = new ApiDeleteSplitReceiverRequest();
        request.setMerchantId("6020221212167701");
        request.setAppId(Config.APPID);
        request.setType("MERCHANT_ID");
        request.setAccount("6020230307605084");

        ApiDeleteSplitReceiverResponse expectedResponse = new ApiDeleteSplitReceiverResponse();
        expectedResponse.setMerchantId("6020221212167701");
        expectedResponse.setType("MERCHANT_ID");
        expectedResponse.setAccount("6020230307605084");

        when(service.deleteSplitReceiver(request)).thenReturn(expectedResponse);
        ApiDeleteSplitReceiverResponse response = service.deleteSplitReceiver(request);
        Assert.assertNotNull(response);
        Assert.assertEquals("MERCHANT_ID", response.getType());
        Assert.assertEquals("6020230307605084", response.getAccount());
    }
}
