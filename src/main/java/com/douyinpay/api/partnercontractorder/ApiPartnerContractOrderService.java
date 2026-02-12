package com.douyinpay.api.partnercontractorder;

import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.DouyinpayRequest;
import com.douyinpay.api.DouyinpayResponse;
import com.douyinpay.api.partnercontractorder.models.ApiPartnerContractOrderRequest;
import com.douyinpay.api.partnercontractorder.models.ApiPartnerContractOrderResponse;
import com.douyinpay.component.http.HttpMethod;
import com.douyinpay.define.DomainName;
import com.douyinpay.util.GsonUtil;

public class ApiPartnerContractOrderService {
        private final DouyinpayClient douyinpayClient;
    private final DomainName domainName;//请求域名

    private ApiPartnerContractOrderService(DouyinpayClient douyinpayClient, DomainName domainName) {
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
         * @return AppService
         */
        public ApiPartnerContractOrderService build() {
            return new ApiPartnerContractOrderService(douyinpayClient, domainName);
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
     * 服务商支付中签约下单
     *
     * @param request 请求参数
     * @return PrepayResponse
     */
    public ApiPartnerContractOrderResponse partnerContractOrder(ApiPartnerContractOrderRequest request) {
        String requestPath = "/v1/trade/partner/transactions/contractorder";
        String requestUrl = getRequestUrl();

        String body = GsonUtil.objectToJson(request);

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, requestPath, null, body);

        DouyinpayResponse<ApiPartnerContractOrderResponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiPartnerContractOrderResponse.class);

        return apiResponse.getApiResponse();
    }
}
