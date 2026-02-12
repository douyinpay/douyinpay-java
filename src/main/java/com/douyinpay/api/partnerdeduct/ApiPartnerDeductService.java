package com.douyinpay.api.partnerdeduct;

import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.DouyinpayRequest;
import com.douyinpay.api.DouyinpayResponse;
import com.douyinpay.api.partnerdeduct.models.ApiPartnerDeductRequest;
import com.douyinpay.api.partnerdeduct.models.ApiPartnerDeductResponse;
import com.douyinpay.api.partnerdeduct.models.ApiPartnerQueryContractScheduleResponse;
import com.douyinpay.api.partnerdeduct.models.ApiPartnerQueryContractScheduleRequest;
import com.douyinpay.api.partnerdeduct.models.ApiPartnerContractScheduleResponse;
import com.douyinpay.api.partnerdeduct.models.ApiPartnerContractScheduleRequest;
import com.douyinpay.component.http.HttpMethod;
import com.douyinpay.component.http.QueryParameter;
import com.douyinpay.define.DomainName;
import com.douyinpay.util.GsonUtil;
import com.douyinpay.util.StringUtil;

public class ApiPartnerDeductService {
    private final DouyinpayClient douyinpayClient;
    private final DomainName domainName;//请求域名

    private ApiPartnerDeductService(DouyinpayClient douyinpayClient, DomainName domainName) {
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
        public ApiPartnerDeductService build() {
            return new ApiPartnerDeductService(douyinpayClient, domainName);
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
     * 服务商申请扣款
     *
     * @param request 请求参数
     * @return PrepayResponse
     */
    public ApiPartnerDeductResponse partnerDeduct(ApiPartnerDeductRequest request) {
        String requestPath = "/v1/trade/partner/deduct/payapply";
        String requestUrl = getRequestUrl();


        String body = GsonUtil.objectToJson(request);

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, requestPath, null, body);

        DouyinpayResponse<ApiPartnerDeductResponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiPartnerDeductResponse.class);

        return apiResponse.getApiResponse();
    }

    /**
     * 服务商预约扣费
     *
     * @param request 请求参数
     * @return PrepayResponse
     */
    public ApiPartnerContractScheduleResponse partnerContractSchedule(ApiPartnerContractScheduleRequest request) {
        String requestPath = "/v1/agreementauth/partner/schedules/contract-id/{contract_id}/schedule";

        String requestUrl = getRequestUrl();
        if (request.getContractId() == null || request.getContractId().trim().isEmpty()) {
            throw new IllegalArgumentException("contractId cannot be null or empty");
        }
        requestPath = requestPath.replace("{contract_id}", request.getContractId());

        String body = GsonUtil.objectToJson(request);

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, requestPath, null, body);

        DouyinpayResponse<ApiPartnerContractScheduleResponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiPartnerContractScheduleResponse.class);

        return apiResponse.getApiResponse();
    }

    /**
     * 服务商扣费结果查询
     *
     * @param request 请求参数
     * @return PrepayResponse
     */
    public ApiPartnerQueryContractScheduleResponse partnerQueryContractSchedule(ApiPartnerQueryContractScheduleRequest request) {
        String requestPath = "/v1/agreementauth/partner/schedules/contract-id/{contract_id}";
        String requestUrl = getRequestUrl();
        if (request.getContractId() == null || request.getContractId().trim().isEmpty()) {
            throw new IllegalArgumentException("contractId cannot be null or empty");
        }
        requestPath = requestPath.replace("{contract_id}", request.getContractId());

        QueryParameter queryParameter = new QueryParameter();
        if (request.getSpMchid() != null) {
            queryParameter.add("sp_mchid", StringUtil.urlEncode(request.getSpMchid()));
        }
        if (request.getSubMchid() != null) {
            queryParameter.add("sub_mchid", StringUtil.urlEncode(request.getSubMchid()));
        }
        requestPath += queryParameter.getQueryStr();

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.GET, requestUrl, requestPath, null, null);

        DouyinpayResponse<ApiPartnerQueryContractScheduleResponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiPartnerQueryContractScheduleResponse.class);

        return apiResponse.getApiResponse();
    }

}
