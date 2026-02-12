package com.doupay.api.partnerpayments.app;

import static org.mockito.Mockito.*;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.time.Instant;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import com.douyinpay.api.partnerpayments.common.ApiTransaction;

import com.doupay.api.secret.PartnerConfig;
import com.douyinpay.api.partnerpayments.app.*;
import com.douyinpay.api.partnerpayments.app.model.*;


public class ApiPartnerAppPaymentServiceMockTest {
    @Test
    public void testPrepay() {

        ApiPartnerAppPaymentService apiAppPaymentsService = mock(ApiPartnerAppPaymentService.class);
        ApiPrepayRequest request = new ApiPrepayRequest();
        request.setSpAppid(PartnerConfig.SP_APPID);
        request.setSpMchid(PartnerConfig.SP_MCHID);
        request.setSubMchid(PartnerConfig.SUB_MCHID);
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
        amount.setTotal(100);
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
        ApiSettleInfo apiSettleInfo = new ApiSettleInfo();
        apiSettleInfo.setProfitSharing(false);
        request.setDetail(apiDetail);
        request.setSceneInfo(apiSceneInfo);
        request.setSettleInfo(apiSettleInfo);
        ApiPrepayResponse apiPrepayResponse = new ApiPrepayResponse();
        apiPrepayResponse.setPrepayId("prepay_id_123");
        when(apiAppPaymentsService.prepay(request)).thenReturn(apiPrepayResponse);
        ApiPrepayResponse response = apiAppPaymentsService.prepay(request);
        Assert.assertEquals(apiPrepayResponse.getPrepayId(), response.getPrepayId());
    }

    @Test
    public void testCloseOrder() {
        ApiPartnerAppPaymentService apiAppPaymentsService = mock(ApiPartnerAppPaymentService.class);
        String outTradeNo = "OUT_1762325194";
        ApiCloseOrderRequest request = new ApiCloseOrderRequest();
        request.setSpMchid(PartnerConfig.SP_MCHID);
        request.setSubMchid(PartnerConfig.SUB_MCHID);
        request.setOutTradeNo(outTradeNo);
        Mockito.doAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                ApiCloseOrderRequest closeOrderRequest = (ApiCloseOrderRequest) args[0];
                Assert.assertEquals(outTradeNo, closeOrderRequest.getOutTradeNo());
                return args;
            }
        }).when(apiAppPaymentsService).closeOrder(request);
    }

    @Test
    public void testQueryOrderByOutTradeNo() {
        ApiPartnerAppPaymentService apiAppPaymentsService = mock(ApiPartnerAppPaymentService.class);
        String outTradeNo = "OUT_1762325194";
        ApiQueryOrderByOutTradeNoRequest request = new ApiQueryOrderByOutTradeNoRequest();
        request.setSpMchid(PartnerConfig.SP_MCHID);
        request.setSubMchid(PartnerConfig.SUB_MCHID);
        request.setOutTradeNo(outTradeNo);
        ApiTransaction apiTransaction = new ApiTransaction();
        apiTransaction.setOutTradeNo(outTradeNo);
        when(apiAppPaymentsService.queryOrderByOutTradeNo(request)).thenReturn(apiTransaction);
        ApiTransaction response = apiAppPaymentsService.queryOrderByOutTradeNo(request);
        Assert.assertEquals(outTradeNo, response.getOutTradeNo());
        Assert.assertNotNull(response);
    }

    @Test
    public void queryOrderById(){
        ApiPartnerAppPaymentService apiAppPaymentsService = mock(ApiPartnerAppPaymentService.class);
        String id = "2100012510290300097868167869";
        ApiQueryOrderByIdRequest request = new ApiQueryOrderByIdRequest();
        request.setSpMchid(PartnerConfig.SP_MCHID);
        request.setSubMchid(PartnerConfig.SUB_MCHID);
        request.setTransactionId(id);
        ApiTransaction apiTransaction = new ApiTransaction();
        apiTransaction.setTransactionId(id);
        when(apiAppPaymentsService.queryOrderById(request)).thenReturn(apiTransaction);
        ApiTransaction response = apiAppPaymentsService.queryOrderById(request);
        Assert.assertNotNull(response);
        Assert.assertEquals(id, response.getTransactionId());

    }

}
