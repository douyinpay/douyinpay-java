package com.doupay.api.cashier;

import java.util.Arrays;

import org.junit.Test;

import com.doupay.api.secret.Config;
import com.douyinpay.api.cashier.ApiCashierService;
import com.douyinpay.api.cashier.models.ApiPrePayConsultRequest;
import com.douyinpay.api.cashier.models.ApiPrePayConsultResponse;

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
}
