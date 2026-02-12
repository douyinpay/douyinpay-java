package com.douyinpay.api.payscore;

import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.DouyinpayRequest;
import com.douyinpay.api.DouyinpayResponse;
import com.douyinpay.api.payscore.models.*;
import com.douyinpay.component.http.HttpMethod;
import com.douyinpay.component.http.QueryParameter;
import com.douyinpay.define.DomainName;
import com.douyinpay.util.GsonUtil;
import com.douyinpay.util.StringUtil;

public class ApiPayscoreService {

    private final String OUT_ORDER_NO_PATTERN = "{out_order_no}";
    private final String OUT_AUTHORIZATION_CODE_PATTERN = "{authorization_code}";


    private final DouyinpayClient douyinpayClient;
    private final DomainName domainName;//请求域名

    public ApiPayscoreService(DouyinpayClient douyinpayClient, DomainName domainName) {
        this.douyinpayClient = douyinpayClient;
        this.domainName = domainName;
    }

    public static class Builder {

        private DouyinpayClient douyinpayClient;
        private DomainName domainName;

        /**
         * 设置抖音先享后付域名 默认为api.doupay.com
         *
         * @param domainName 抖音支付域名
         * @return Builder
         */
        public ApiPayscoreService.Builder domainName(DomainName domainName) {
            this.domainName = domainName;
            return this;
        }

        /**
         * 设置自定义httpclient
         *
         * @param douyinpayClient
         * @return Builder
         */
        public ApiPayscoreService.Builder douyinpayClient(DouyinpayClient douyinpayClient) {
            this.douyinpayClient = douyinpayClient;
            return this;
        }

        /**
         * 构造服务
         *
         * @return AppService
         */
        public ApiPayscoreService build() {
            return new ApiPayscoreService(douyinpayClient, domainName);
        }
    }

    public String getRequestUrl() {
        String domainName = DomainName.PAYSCORE_API.getValue();


        if (this.domainName != null) {
            domainName = this.domainName.getValue();
        }

        return domainName;
    }

    /**
     * 创建服务订单
     *
     * @param request
     * @return ApiCreateServiceOrderResponse
     */
    public ApiCreateServiceOrderResponse createServiceOrder(ApiCreateServiceOrderRequest request) {
        String requestPath = "/v1/payscore/serviceorder/create";
        String requestUrl = getRequestUrl();

        String body = GsonUtil.objectToJson(request);

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, requestPath, null, body);

        DouyinpayResponse<ApiCreateServiceOrderResponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiCreateServiceOrderResponse.class);

        return apiResponse.getApiResponse();
    }

    /**
     * 完结服务订单
     *
     * @param request
     * @return ApiCompleteServiceOrderResponse
     */
    public ApiCompleteServiceOrderResponse completeServiceOrder(ApiCompleteServiceOrderRequest request) {
        String requestPath = "/v1/payscore/serviceorder/complete";
        String requestUrl = getRequestUrl();

        String body = GsonUtil.objectToJson(request);

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, requestPath, null, body);

        DouyinpayResponse<ApiCompleteServiceOrderResponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiCompleteServiceOrderResponse.class);

        return apiResponse.getApiResponse();
    }

    /**
     * 查询服务订单
     *
     * @param request
     * @return ApiQueryServiceOrderResponse
     */
    public ApiQueryServiceOrderResponse queryServiceOrder(ApiQueryServiceOrderRequest request) {
        String requestPath = "/v1/payscore/serviceorder/query";
        String requestUrl = getRequestUrl();

        // 添加 query param
        QueryParameter queryParameter = new QueryParameter();
        if (request.getAppid() != null) {
            queryParameter.add("appid", request.getAppid());
        }
        if (request.getServiceId() != null) {
            queryParameter.add("service_id", request.getServiceId());
        }
        if (request.getMchid() != null) {
            queryParameter.add("mchid", StringUtil.urlEncode(request.getMchid()));
        }
        if (request.getOutOrderNo() != null) {
            queryParameter.add("out_order_no", StringUtil.urlEncode(request.getOutOrderNo()));
        }
        requestPath += queryParameter.getQueryStr();

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.GET, requestUrl, requestPath, null, null);

        DouyinpayResponse<ApiQueryServiceOrderResponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiQueryServiceOrderResponse.class);

        return apiResponse.getApiResponse();
    }

    /**
     * 取消服务订单
     *
     * @param request
     * @return ApiCancelServiceOrderResponse
     */
    public ApiCancelServiceOrderResponse cancelServiceOrder(ApiCancelServiceOrderRequest request) {
        String requestPath = "/v1/payscore/serviceorder/cancel";
        String requestUrl = getRequestUrl();

        String body = GsonUtil.objectToJson(request);

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, requestPath, null, body);

        DouyinpayResponse<ApiCancelServiceOrderResponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiCancelServiceOrderResponse.class);

        return apiResponse.getApiResponse();
    }

    /**
     * 修改订单金额
     *
     * @param request
     * @return ApiModifyAmountResponse
     */
    public ApiModifyAmountResponse modifyAmount(ApiModifyAmountRequest request) {
        String requestPath = "/v1/payscore/serviceorder/modify";
        String requestUrl = getRequestUrl();

        String body = GsonUtil.objectToJson(request);

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, requestPath, null, body);

        DouyinpayResponse<ApiModifyAmountResponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiModifyAmountResponse.class);

        return apiResponse.getApiResponse();
    }

    /**
     * 同步服务订单信息
     *
     * @param request
     * @return ApiSynchronizeServiceOrderInfoResponse
     */
    public ApiSynchronizeServiceOrderInfoResponse synchronizeServiceOrderInfo(ApiSynchronizeServiceOrderInfoRequest request) {
        String requestPath = "/v1/payscore/serviceorder/{out_order_no}/sync";
        String requestUrl = getRequestUrl();

        // 添加 path param
        requestPath = requestPath.replace(OUT_ORDER_NO_PATTERN, StringUtil.urlEncode(request.getOutOrderNo()));

        String body = GsonUtil.objectToJson(request);

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, requestPath, null, body);

        DouyinpayResponse<ApiSynchronizeServiceOrderInfoResponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiSynchronizeServiceOrderInfoResponse.class);

        return apiResponse.getApiResponse();
    }


    /**
     * 商户发起催收扣款
     *
     * @param request
     * @return ApiServiceOrderPayResponse
     */
    public ApiServiceOrderPayResponse serviceOrderPay(ApiServiceOrderPayRequest request) {
        String requestPath = "/v1/payscore/serviceorder/{out_order_no}/pay";
        String requestUrl = getRequestUrl();

        // 添加 path param
        requestPath = requestPath.replace(OUT_ORDER_NO_PATTERN, StringUtil.urlEncode(request.getOutOrderNo()));

        String body = GsonUtil.objectToJson(request);

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, requestPath, null, body);

        DouyinpayResponse<ApiServiceOrderPayResponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiServiceOrderPayResponse.class);

        return apiResponse.getApiResponse();
    }

    /**
     * 申请服务授权
     *
     * @param request
     * @return ApiCreditSrvSignApplyResponse
     */
    public ApiCreditSrvSignApplyResponse creditSrvSignApply(ApiCreditSrvSignApplyRequest request) {
        String requestPath = "/v1/payscore/permissions";
        String requestUrl = getRequestUrl();

        String body = GsonUtil.objectToJson(request);

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, requestPath, null, body);

        DouyinpayResponse<ApiCreditSrvSignApplyResponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiCreditSrvSignApplyResponse.class);

        return apiResponse.getApiResponse();
    }

    /**
     * 查询用户授权记录
     *
     * @param request
     * @return ApiCreditSrvSignQueryResponse
     */
    public ApiCreditSrvSignQueryResponse creditSrvSignQuery(ApiCreditSrvSignQueryRequest request) {
        String requestPath = "/v1/payscore/permissions/authorization-code/{authorization_code}";
        String requestUrl = getRequestUrl();

        // 添加 path param
        requestPath = requestPath.replace(OUT_AUTHORIZATION_CODE_PATTERN, StringUtil.urlEncode(request.getAuthorizationCode()));

        // 添加 query param
        QueryParameter queryParameter = new QueryParameter();
        if (request.getServiceId() != null) {
            queryParameter.add("service_id", request.getServiceId());
        }
        if (request.getMchid() != null) {
            queryParameter.add("mchid", StringUtil.urlEncode(request.getMchid()));
        }

        requestPath += queryParameter.getQueryStr();

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.GET, requestUrl, requestPath, null, null);

        DouyinpayResponse<ApiCreditSrvSignQueryResponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiCreditSrvSignQueryResponse.class);

        return apiResponse.getApiResponse();
    }

    /**
     * 解除用户授权关系
     *
     * @param request
     */
    public void closeCreditService(ApiCloseCreditServiceRequest request) {
        String requestPath = "/v1/payscore/permissions/authorization-code/{authorization_code}/terminate";
        String requestUrl = getRequestUrl();

        // 添加 path param
        requestPath = requestPath.replace(OUT_AUTHORIZATION_CODE_PATTERN, StringUtil.urlEncode(request.getAuthorizationCode()));

        String body = GsonUtil.objectToJson(request);

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, requestPath, null, body);

        douyinpayClient.execute(douyinpayRequest, null);

    }
}
