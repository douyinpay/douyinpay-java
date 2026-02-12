package com.douyinpay.api.partnercontract;

import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.DouyinpayRequest;
import com.douyinpay.api.DouyinpayResponse;
import com.douyinpay.api.partnercontract.models.ApiPartnerQueryContractResponse;
import com.douyinpay.api.partnercontract.models.ApiPartnerQueryContractRequest;
import com.douyinpay.api.partnercontract.models.ApiPartnerTerminateContractRequest;
import com.douyinpay.api.partnercontract.models.ApiPartnerTerminateContractResponse;
import com.douyinpay.component.http.HttpMethod;
import com.douyinpay.component.http.QueryParameter;
import com.douyinpay.define.DomainName;
import com.douyinpay.util.StringUtil;
import com.douyinpay.util.GsonUtil;

public class ApiPartnerContractService {

    private final String OUT_CONTRACT_CODE_PATTERN = "{out_contract_code}";
    private final String PLAN_ID_PATTERN = "{plan_id}";

    private final DouyinpayClient douyinpayClient;
    private final DomainName domainName;//请求域名

    private ApiPartnerContractService(DouyinpayClient douyinpayClient, DomainName domainName) {
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
        public ApiPartnerContractService build() {
            return new ApiPartnerContractService(douyinpayClient, domainName);
        }
    }

    public String getRequestUrl() {
        String domainName = DomainName.API.getValue();


        if (this.domainName != null) {
            domainName = this.domainName.getValue();
        }

        return domainName;
    }



    public ApiPartnerQueryContractResponse partnerQueryContract(ApiPartnerQueryContractRequest request) {

        String requestPath = "/v1/agreementauth/partner/contracts/plan-id/{plan_id}/out-contract-code/{out_contract_code}";
        String requestUrl = getRequestUrl();
        checkParam(request.getPlanId(), request.getOutContractCode());
        // 添加 path param
        requestPath = requestPath.replace(OUT_CONTRACT_CODE_PATTERN, StringUtil.urlEncode(request.getOutContractCode()));
        requestPath = requestPath.replace(PLAN_ID_PATTERN, StringUtil.urlEncode(request.getPlanId().toString()));

               // 添加 query param
        QueryParameter queryParameter = new QueryParameter();
        if (request.getSpMchid() != null) {
            queryParameter.add("sp_mchid", StringUtil.urlEncode(request.getSpMchid()));
        }
        if (request.getSubMchid() != null) {
            queryParameter.add("sub_mchid", StringUtil.urlEncode(request.getSubMchid()));
        }
        requestPath += queryParameter.getQueryStr();

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.GET, requestUrl, requestPath, null, null);

        DouyinpayResponse<ApiPartnerQueryContractResponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiPartnerQueryContractResponse.class);

        return apiResponse.getApiResponse();
    }
    /**
     * 终止签约
     *
     * @param request
     * @return
     */
    public ApiPartnerTerminateContractResponse partnerTerminateContract(ApiPartnerTerminateContractRequest request) {

        String requestPath = "/v1/agreementauth/partner/contracts/plan-id/{plan_id}/out-contract-code/{out_contract_code}/terminate";
        String requestUrl = getRequestUrl();
        checkParam(request.getPlanId(), request.getOutContractCode());
        // 添加 path param
        requestPath = requestPath.replace(OUT_CONTRACT_CODE_PATTERN, StringUtil.urlEncode(request.getOutContractCode()));
        requestPath = requestPath.replace(PLAN_ID_PATTERN, StringUtil.urlEncode(request.getPlanId().toString()));

        String body = GsonUtil.objectToJson(request);

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, requestPath, null, body);

        DouyinpayResponse<ApiPartnerTerminateContractResponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiPartnerTerminateContractResponse.class);

        return apiResponse.getApiResponse();
    }

    private void checkParam(Integer planId, String outContractCode) {
            if (planId == null) {
                throw new IllegalArgumentException("planId cannot be null or empty");
            }
            if (outContractCode == null || outContractCode.trim().isEmpty()) {
                throw new IllegalArgumentException("outContractCode cannot be null or empty");
            }
    }

}