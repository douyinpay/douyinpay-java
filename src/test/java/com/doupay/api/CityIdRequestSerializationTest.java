package com.doupay.api;

import com.douyinpay.util.GsonUtil;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.Test;

public class CityIdRequestSerializationTest {
    private static final String CITY_ID = "110100";

    @Test
    public void testSupportedRequestsSerializeCityId() {
        com.douyinpay.api.payments.jsapi.models.ApiPrepayRequest jsapiRequest =
                new com.douyinpay.api.payments.jsapi.models.ApiPrepayRequest();
        com.douyinpay.api.payments.jsapi.models.ApiSceneInfo jsapiSceneInfo =
                new com.douyinpay.api.payments.jsapi.models.ApiSceneInfo();
        jsapiSceneInfo.setCityId(CITY_ID);
        jsapiRequest.setSceneInfo(jsapiSceneInfo);
        assertCityId(jsapiSceneInfo.getCityId(), jsapiRequest);

        com.douyinpay.api.payments.app.models.ApiPrepayRequest appRequest =
                new com.douyinpay.api.payments.app.models.ApiPrepayRequest();
        com.douyinpay.api.payments.app.models.ApiSceneInfo appSceneInfo =
                new com.douyinpay.api.payments.app.models.ApiSceneInfo();
        appSceneInfo.setCityId(CITY_ID);
        appRequest.setSceneInfo(appSceneInfo);
        assertCityId(appSceneInfo.getCityId(), appRequest);

        com.douyinpay.api.payments.contractorder.models.ApiPrepayRequest contractOrderRequest =
                new com.douyinpay.api.payments.contractorder.models.ApiPrepayRequest();
        com.douyinpay.api.payments.contractorder.models.ApiSceneInfo contractOrderSceneInfo =
                new com.douyinpay.api.payments.contractorder.models.ApiSceneInfo();
        contractOrderSceneInfo.setCityId(CITY_ID);
        contractOrderRequest.setSceneInfo(contractOrderSceneInfo);
        assertCityId(contractOrderSceneInfo.getCityId(), contractOrderRequest);

        com.douyinpay.api.deduct.models.ApiDeductRequest deductRequest =
                new com.douyinpay.api.deduct.models.ApiDeductRequest();
        com.douyinpay.api.deduct.models.ApiSceneInfo deductSceneInfo =
                new com.douyinpay.api.deduct.models.ApiSceneInfo();
        deductSceneInfo.setCityId(CITY_ID);
        deductRequest.setSceneInfo(deductSceneInfo);
        assertCityId(deductSceneInfo.getCityId(), deductRequest);
    }

    private void assertCityId(String cityId, Object request) {
        Assert.assertEquals(CITY_ID, cityId);
        JsonObject json = GsonUtil.getGson().toJsonTree(request).getAsJsonObject();
        Assert.assertFalse(json.has("city_id"));
        Assert.assertEquals(CITY_ID, json.getAsJsonObject("scene_info").get("city_id").getAsString());
    }
}
