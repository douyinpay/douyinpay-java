package com.doupay.api.cashier;

import java.util.Arrays;

import org.junit.Test;

import com.doupay.api.secret.Config;
import com.douyinpay.api.cashier.ApiCashierService;
import com.douyinpay.api.cashier.models.ApiPrePayConsultRequest;
import com.douyinpay.api.cashier.models.ApiPrePayConsultResponse;
import com.douyinpay.api.cashier.models.ApiQueryInvokeInfoRequest;
import com.douyinpay.api.cashier.models.ApiQueryInvokeInfoResponse;
import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.DouyinpayRequest;
import com.douyinpay.api.DouyinpayResponse;

import org.mockito.ArgumentCaptor;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ApiCashierMockTest {

    @Test
    public void testPrePayConsult() {
        ApiCashierService apiCashierService = mock(ApiCashierService.class);
        ApiPrePayConsultRequest request = new ApiPrePayConsultRequest();
        request.setAppid(Config.APPID);
        request.setMchid(Config.MCHID);
        request.setTotalAmount("2000");
        request.setProductCode(Arrays.asList("NormalPay"));
        request.setCommericalProductCode("CO_PAY_APP");
        request.setTradeType("APP");
        request.setGoodsTag("{\"biz_scene\":\"pre_consult\"}");
        request.setEncryptType("SHA256");
        request.setBlindMobileList(
                Arrays.asList("66d0fba82f83396b8c37c47e151f8076a479064eccd78517b604646040e8fcfd"));

        when(apiCashierService.prePayConsult(request)).thenReturn(new ApiPrePayConsultResponse());
        apiCashierService.prePayConsult(request);
        verify(apiCashierService, times(1)).prePayConsult(request);
    }

    @Test
    public void testQueryInvokeInfo() {
        DouyinpayClient douyinpayClient = mock(DouyinpayClient.class);
        DouyinpayResponse<ApiQueryInvokeInfoResponse> response =
                new DouyinpayResponse<>(null, 200, null, null, null);
        ApiQueryInvokeInfoResponse apiResponse = new ApiQueryInvokeInfoResponse();
        apiResponse.setInvokeUrl("https://cashier.douyinpay.com/bytepay-cashdesk/bytepay-invoke");
        response.setApiResponse(apiResponse);

        when(douyinpayClient.execute(any(DouyinpayRequest.class), eq(ApiQueryInvokeInfoResponse.class)))
                .thenReturn(response);

        ApiCashierService apiCashierService = new ApiCashierService.Builder()
                .douyinpayClient(douyinpayClient)
                .build();

        ApiQueryInvokeInfoRequest request = new ApiQueryInvokeInfoRequest();
        request.setMchid(Config.MCHID);
        request.setPrepayid("dy9pvo8xyxpyop7u7t735u5s41527t5t8uytv101rs5t477vy989q7q5");

        ApiQueryInvokeInfoResponse result = apiCashierService.queryInvokeInfo(request);

        ArgumentCaptor<DouyinpayRequest> requestCaptor = ArgumentCaptor.forClass(DouyinpayRequest.class);
        verify(douyinpayClient, times(1)).execute(requestCaptor.capture(), eq(ApiQueryInvokeInfoResponse.class));
        assertEquals("POST", requestCaptor.getValue().getHttpMethod().toString());
        assertEquals("/v1/cashier/query_invoke_info", requestCaptor.getValue().getPath());
        assertEquals("{\"mchid\":\"" + Config.MCHID + "\",\"prepayid\":\"dy9pvo8xyxpyop7u7t735u5s41527t5t8uytv101rs5t477vy989q7q5\"}",
                requestCaptor.getValue().getBody());
        assertEquals("https://cashier.douyinpay.com/bytepay-cashdesk/bytepay-invoke", result.getInvokeUrl());
    }
}
