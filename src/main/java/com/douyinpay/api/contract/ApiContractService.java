package com.douyinpay.api.contract;

import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.DouyinpayRequest;
import com.douyinpay.api.DouyinpayResponse;
import com.douyinpay.api.contract.models.ApiDeleteContractRequest;
import com.douyinpay.api.contract.models.ApiDeleteContractResponse;
import com.douyinpay.api.contract.models.ApiH5EntrustWebRequest;
import com.douyinpay.api.contract.models.ApiH5EntrustWebResponse;
import com.douyinpay.api.contract.models.ApiQueryContractRequest;
import com.douyinpay.api.contract.models.ApiQueryContractResponse;
import com.douyinpay.api.contract.models.ApiPreEntrustWebRequest;
import com.douyinpay.api.contract.models.ApiPreEntrustWebResponse;
import com.douyinpay.component.http.HttpMethod;
import com.douyinpay.define.DomainName;
import com.douyinpay.util.GsonUtil;

public class ApiContractService {

    private final DouyinpayClient douyinpayClient;
    private final DomainName domainName;//请求域名

    private ApiContractService(DouyinpayClient douyinpayClient, DomainName domainName) {
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
        public ApiContractService build() {
            return new ApiContractService(douyinpayClient, domainName);
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
     * 查询签约协议
     *
     * @param request 请求参数
     * @return QueryContractResponse
     */
    public ApiQueryContractResponse queryContract(ApiQueryContractRequest request) {
        String requestPath = "/v1/member/querycontract";
        String requestUrl = getRequestUrl();


        String body = GsonUtil.objectToJson(request);

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, requestPath, null, body);

        DouyinpayResponse<ApiQueryContractResponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiQueryContractResponse.class);

        return apiResponse.getApiResponse();
    }
    /**
     * 删除签约协议
     *
     * @param request 请求参数
     * @return DeleteContractResponse
     */
    public ApiDeleteContractResponse deleteContract(ApiDeleteContractRequest request) {
        String requestUrl = getRequestUrl();
        String requestPath = "/v1/member/deletecontract";


        String body = GsonUtil.objectToJson(request);

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, requestPath, null, body);

        DouyinpayResponse<ApiDeleteContractResponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiDeleteContractResponse.class);

        return apiResponse.getApiResponse();
    }

    /**
     * app预签约下单
     *
     * @param request 请求参数
     * @return PreContractResponse
     */
    public ApiPreEntrustWebResponse preEntrustWeb(ApiPreEntrustWebRequest request) {
        String requestUrl = getRequestUrl();
        String requestPath = "/v1/agreementauth/preentrustweb";


        String body = GsonUtil.objectToJson(request);

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, requestPath, null, body);

        DouyinpayResponse<ApiPreEntrustWebResponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiPreEntrustWebResponse.class);

        return apiResponse.getApiResponse();
    }

    /**
     * h5预签约下单
     *
     * @param request 请求参数
     * @return PreContractResponse
     */
    public ApiH5EntrustWebResponse h5EntrustWeb(ApiH5EntrustWebRequest request) {
        String requestPath = "/v1/agreementauth/h5entrustweb";
        String requestUrl = getRequestUrl();

        String body = GsonUtil.objectToJson(request);

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, requestPath, null, body);

        DouyinpayResponse<ApiH5EntrustWebResponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiH5EntrustWebResponse.class);

        return apiResponse.getApiResponse();
    }

}
