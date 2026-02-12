package com.doupay.api.partnerpayments.jsapi;

import static org.mockito.Mockito.*;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.douyinpay.api.partnerpayments.jsapi.model.Amount;
import com.douyinpay.api.partnerpayments.jsapi.model.ApiCloseOrderRequest;
import com.douyinpay.api.partnerpayments.jsapi.model.ApiDetail;
import com.douyinpay.api.partnerpayments.jsapi.model.ApiGoodsDetail;
import com.douyinpay.api.partnerpayments.jsapi.model.ApiPayerInfo;
import com.doupay.api.secret.PartnerConfig;
import com.douyinpay.api.partnerpayments.common.ApiTransaction;
import com.douyinpay.api.partnerpayments.jsapi.ApiPartnerJsapiPaymentService;
import com.douyinpay.api.partnerpayments.jsapi.model.ApiPrepayRequest;
import com.douyinpay.api.partnerpayments.jsapi.model.ApiPrepayResponse;
import com.douyinpay.api.partnerpayments.jsapi.model.ApiQueryOrderByIdRequest;
import com.douyinpay.api.partnerpayments.jsapi.model.ApiQueryOrderByOutTradeNoRequest;
import com.douyinpay.api.partnerpayments.jsapi.model.ApiSceneInfo;
import com.douyinpay.api.partnerpayments.jsapi.model.ApiSettleInfo;
import com.douyinpay.api.partnerpayments.jsapi.model.ApiStoreInfo;
import com.douyinpay.api.refund.ApiRefundService;
import com.douyinpay.api.refund.model.ApiAmountReq;
import com.douyinpay.api.refund.model.ApiCreateRequest;
import com.douyinpay.api.refund.model.ApiQueryByOutRefundNoRequest;
import com.douyinpay.api.refund.model.ApiRefund;


public class ApiJsapiPaymentsServiceMockTest {

    @Test
    public void prepayMock() {
        ApiPartnerJsapiPaymentService apiJsapiPaymentsService = mock(ApiPartnerJsapiPaymentService.class);
        ApiPrepayRequest request = new ApiPrepayRequest();
        request.setSpAppid(PartnerConfig.SP_APPID);
        // request.setSubAppid(SUB_APPID);
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
        // payer
        ApiPayerInfo payerInfo = new ApiPayerInfo();
        payerInfo.setSpOpenid("f39e42bd-d607-5a5b-ab4d-74fddcdbfaf3");
        request.setDetail(apiDetail);
        request.setSceneInfo(apiSceneInfo);
        request.setSettleInfo(apiSettleInfo);
        request.setPayer(payerInfo);
        ApiPrepayResponse prepayResponse = new ApiPrepayResponse();
        prepayResponse.setPrepayId("prepay_id_123456");
        when(apiJsapiPaymentsService.prepay(request)).thenReturn(prepayResponse);
        ApiPrepayResponse response = apiJsapiPaymentsService.prepay(request);
        Assert.assertNotNull(response);
        Assert.assertEquals(prepayResponse.getPrepayId(), response.getPrepayId());
    }

    @Test
    public void testCloseOrder() {
        ApiPartnerJsapiPaymentService apiJsapiPaymentsService = mock(ApiPartnerJsapiPaymentService.class);
        String outTradeNo = "OUT_1761650114";
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
        }).when(apiJsapiPaymentsService).closeOrder(request);
    }

    @Test
    public void queryOrderById(){
        ApiPartnerJsapiPaymentService apiJsapiPaymentsService = mock(ApiPartnerJsapiPaymentService.class);
        String id = "2100012510290300097868167869";
        ApiQueryOrderByIdRequest request = new ApiQueryOrderByIdRequest();
        request.setSpMchid(PartnerConfig.SP_MCHID);
        request.setSubMchid(PartnerConfig.SUB_MCHID);
        request.setTransactionId(id);
        ApiTransaction apiTransaction = new ApiTransaction();
        apiTransaction.setTransactionId(id);
        when(apiJsapiPaymentsService.queryOrderById(request)).thenReturn(apiTransaction);
        ApiTransaction response = apiJsapiPaymentsService.queryOrderById(request);
        Assert.assertNotNull(response);
        Assert.assertEquals(id, response.getTransactionId());

    }

    @Test
    public void testQueryOrderByOutTradeNo() {
        ApiPartnerJsapiPaymentService apiJsapiPaymentsService = mock(ApiPartnerJsapiPaymentService.class);        // String outTradeNo = "lt_202510291542139453477";
        String outTradeNo = "OUT_1761650114";
        ApiQueryOrderByOutTradeNoRequest request = new ApiQueryOrderByOutTradeNoRequest();
        request.setSpMchid(PartnerConfig.SP_MCHID);
        request.setSubMchid(PartnerConfig.SUB_MCHID);
        request.setOutTradeNo(outTradeNo);
        ApiTransaction apiTransaction = new ApiTransaction();
        apiTransaction.setOutTradeNo(outTradeNo);
        when(apiJsapiPaymentsService.queryOrderByOutTradeNo(request)).thenReturn(apiTransaction);
        ApiTransaction response = apiJsapiPaymentsService.queryOrderByOutTradeNo(request);
        Assert.assertEquals(outTradeNo, response.getOutTradeNo());
        Assert.assertNotNull(response);
    }

    @Test
    public void testRefund() {
        ApiRefundService refundService = mock(ApiRefundService.class);   
        String id = "2100012510290300097868167869";
        String outRefundNo = String.format("%s_%d", "REFUND", Instant.now().getLong(ChronoField.INSTANT_SECONDS));

        ApiCreateRequest request = new ApiCreateRequest();
        request.setSpMchid(PartnerConfig.SP_MCHID);
        request.setSubMchid(PartnerConfig.SUB_MCHID);
        request.setTransactionId(id);
        request.setOutRefundNo(outRefundNo);
        request.setNotifyUrl("https://www.mock.douyinpay.com");
        request.setReason("no reason");
        ApiAmountReq amountReq = new ApiAmountReq();
        amountReq.setTotal(100);
        amountReq.setRefund(1);
        amountReq.setCurrency("CNY");
        request.setAmount(amountReq);
        
        ApiRefund refundResponse = new ApiRefund();
        refundResponse.setOutRefundNo(outRefundNo);
        when(refundService.create(request)).thenReturn(refundResponse);
        ApiRefund response = refundService.create(request);
        Assert.assertEquals(outRefundNo, response.getOutRefundNo());
        Assert.assertNotNull(response);
    }

    @Test
    public void TestQueryRefund() {
        ApiRefundService refundService = mock(ApiRefundService.class);   
        ApiQueryByOutRefundNoRequest request = new ApiQueryByOutRefundNoRequest();
        String outRefundNo = "REFUND_1761729212";
        request.setOutRefundNo(outRefundNo);
        request.setSpMchid(PartnerConfig.SP_MCHID);
        request.setSubMchid(PartnerConfig.SUB_MCHID);
        ApiRefund refundResponse = new ApiRefund();
        refundResponse.setOutRefundNo(outRefundNo);
        when(refundService.queryByOutRefundNo(request)).thenReturn(refundResponse);
        ApiRefund response = refundService.queryByOutRefundNo(request);
        Assert.assertEquals(outRefundNo, response.getOutRefundNo());
        Assert.assertNotNull(response);
    }
}