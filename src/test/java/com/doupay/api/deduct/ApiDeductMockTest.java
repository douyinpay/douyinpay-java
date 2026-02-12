package com.doupay.api.deduct;
import org.junit.Assert;
import org.junit.Test;

import com.doupay.api.secret.Config;
import com.douyinpay.api.deduct.ApiDeductService;
import com.douyinpay.api.deduct.models.ApiDeductNotifyRequest;
import com.douyinpay.api.deduct.models.ApiDeductNotifyResponse;
import com.douyinpay.api.deduct.models.EstimatedAmount;

import static org.mockito.Mockito.*;

public class ApiDeductMockTest {

        @Test
    public void testDeductNotify(){
        ApiDeductService apiDeductService = mock(ApiDeductService.class);
        ApiDeductNotifyRequest request = new ApiDeductNotifyRequest();
        request.setMchid(Config.MCHID);
        request.setContractId(Config.DEDUCT_CONTRACT_ID);
        request.setAppid(Config.APPID);
        EstimatedAmount amount = new EstimatedAmount();
        amount.setCurrency("CNY");
        amount.setAmount(1);
        request.setEstimatedAmount(amount);
        when(apiDeductService.deductNotify(request)).thenReturn(new ApiDeductNotifyResponse());
        apiDeductService.deductNotify(request);
        verify(apiDeductService, times(1)).deductNotify(request);

    }
}
