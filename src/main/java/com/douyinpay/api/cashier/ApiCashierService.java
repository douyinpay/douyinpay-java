package com.douyinpay.api.cashier;

import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.DouyinpayRequest;
import com.douyinpay.api.DouyinpayResponse;
import com.douyinpay.api.cashier.models.ApiPrePayConsultRequest;
import com.douyinpay.api.cashier.models.ApiPrePayConsultResponse;
import com.douyinpay.component.http.HttpMethod;
import com.douyinpay.define.DomainName;
import com.douyinpay.util.GsonUtil;

/**
 * 收银服务。
 */
public class ApiCashierService {

    private final DouyinpayClient douyinpayClient;
    private final DomainName domainName;// 请求域名

    private ApiCashierService(DouyinpayClient douyinpayClient, DomainName domainName) {
        this.douyinpayClient = douyinpayClient;
        this.domainName = domainName;
    }

    public static class Builder {

        private DouyinpayClient douyinpayClient;
        private DomainName domainName;

        /**
         * 设置抖音支付域名 默认为api.douyinpay.com
         *
         * @param domainName 抖音支付域名
         * @return Builder
         */
        public Builder domainName(DomainName domainName) {
            this.domainName = domainName;
            return this;
        }

        /**
         * 设置自定义httpclient
         *
         * @param douyinpayClient
         * @return Builder
         */
        public Builder douyinpayClient(DouyinpayClient douyinpayClient) {
            this.douyinpayClient = douyinpayClient;
            return this;
        }

        /**
         * 构造服务
         *
         * @return ApiCashierService
         */
        public ApiCashierService build() {
            return new ApiCashierService(douyinpayClient, domainName);
        }
    }

    public String getRequestUrl() {
        String domainName = DomainName.API.getValue();

        if (this.domainName != null) {
            domainName = this.domainName.getValue();
        }

        return domainName;
    }

    /**
     * 前置咨询。
     *
     * 商户在支付前咨询当前用户的支付渠道可用性与营销内容，用于在商户侧提前展示营销文案。
     * 当前支持「普通支付」（APP支付、H5支付、JSAPI支付、Native支付）、「签约并支付」、「免密支付」、
     * 「商户代扣」、「先享后付」，具体的 product_code、commerical_product_code、trade_type 组合见官方文档映射表。
     *
     * @param request 请求参数
     * @return ApiPrePayConsultResponse
     */
    public ApiPrePayConsultResponse prePayConsult(ApiPrePayConsultRequest request) {
        String requestPath = "/v1/cashier/prepay/consult";
        String requestUrl = getRequestUrl();

        String body = GsonUtil.objectToJson(request);

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, requestPath, null, body);

        DouyinpayResponse<ApiPrePayConsultResponse> apiResponse = douyinpayClient.execute(douyinpayRequest,
                ApiPrePayConsultResponse.class);

        return apiResponse.getApiResponse();
    }
}
