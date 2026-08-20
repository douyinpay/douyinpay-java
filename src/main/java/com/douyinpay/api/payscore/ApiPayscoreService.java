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

/**
 * 先享后付服务接口。
 *
 * <p>提供服务订单创建、查询、完结、取消、金额修改、信息同步、催收扣款，以及用户服务授权管理能力。</p>
 *
 * <p>credit_product 相关接口用例：以下接口的请求 URL 可在
 * {@code credit_product/idl/credit_product.thrift} 的 {@code path} 中找到，纳入本服务的先享后付服务商接口范围。</p>
 *
 * <ul>
 *     <li>申请服务授权：{@code POST /v1/payscore/partner/permissions}</li>
 *     <li>查询用户授权记录：{@code GET /v1/payscore/partner/permissions/authorization-code/{authorization_code}}</li>
 *     <li>解除用户授权记录：{@code POST /v1/payscore/partner/permissions/authorization-code/{authorization_code}/terminate}</li>
 *     <li>创建服务订单：{@code POST /v1/payscore/partner/serviceorder/create}</li>
 *     <li>完结服务订单：{@code POST /v1/payscore/partner/serviceorder/complete}</li>
 *     <li>查询服务订单：{@code GET /v1/payscore/partner/serviceorder/query}</li>
 *     <li>取消服务订单：{@code POST /v1/payscore/partner/serviceorder/cancel}</li>
 *     <li>同步服务订单信息：{@code POST /v1/payscore/partner/serviceorder/{out_order_no}/sync}</li>
 *     <li>修改订单金额：{@code POST /v1/payscore/partner/serviceorder/modify}</li>
 * </ul>
 *
 * <p>前置咨询、支付并签约、退款和账单等接口未出现在上述 IDL path 中，不属于本组接口用例。</p>
 */
public class ApiPayscoreService {

    /**
     * 服务订单号路径占位符。
     * 业务规则：调用订单相关接口时替换为经过 URL 编码的商户订单号。
     */
    private final String OUT_ORDER_NO_PATTERN = "{out_order_no}";

    /**
     * 商户协议号路径占位符。
     * 业务规则：调用用户授权相关接口时替换为经过 URL 编码的商户协议号。
     */
    private final String OUT_AUTHORIZATION_CODE_PATTERN = "{authorization_code}";


    /**
     * HTTP 请求客户端。
     * 业务规则：由构造方法注入，用于发送已组装的支付接口请求。
     */
    private final DouyinpayClient douyinpayClient;

    /**
     * 请求域名。
     * 业务规则：为空时使用先享后付接口默认域名；不为空时使用调用方指定的域名。
     */
    private final DomainName domainName;

    /**
     * 创建先享后付服务接口实例。
     *
     * @param douyinpayClient HTTP 请求客户端
     * @param domainName 请求域名；为空时使用默认域名
     */
    public ApiPayscoreService(DouyinpayClient douyinpayClient, DomainName domainName) {
        this.douyinpayClient = douyinpayClient;
        this.domainName = domainName;
    }

    /**
     * 先享后付服务接口构造器。
     */
    public static class Builder {

        private DouyinpayClient douyinpayClient;
        private DomainName domainName;

        /**
         * 设置先享后付请求域名。
         *
         * <p>格式规则：域名由 {@link DomainName} 提供，不包含接口路径。</p>
         * 业务规则：未设置时使用 {@link DomainName#PAYSCORE_API} 对应的默认域名。
         * @param domainName 请求域名
         * @return Builder
         */
        public ApiPayscoreService.Builder domainName(DomainName domainName) {
            this.domainName = domainName;
            return this;
        }

        /**
         * 设置 HTTP 请求客户端。
         *
         * @param douyinpayClient HTTP 请求客户端
         * @return Builder
         */
        public ApiPayscoreService.Builder douyinpayClient(DouyinpayClient douyinpayClient) {
            this.douyinpayClient = douyinpayClient;
            return this;
        }

        /**
         * 构造先享后付服务接口实例。
         *
         * @return 先享后付服务接口实例
         */
        public ApiPayscoreService build() {
            return new ApiPayscoreService(douyinpayClient, domainName);
        }
    }

    /**
     * 获取先享后付接口请求域名。
     *
     * <p>业务规则：调用方未指定域名时返回 {@link DomainName#PAYSCORE_API} 对应的默认域名。</p>
     *
     * @return 请求域名
     */
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
     * @param request 创建服务订单请求参数
     * @return 创建服务订单响应
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
     * @param request 完结服务订单请求参数
     * @return 完结服务订单响应
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
     * @param request 查询服务订单请求参数
     * @return 查询服务订单响应
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
     * @param request 取消服务订单请求参数
     * @return 取消服务订单响应
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
     * @param request 修改订单金额请求参数
     * @return 修改订单金额响应
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
     * @param request 同步服务订单信息请求参数
     * @return 同步服务订单信息响应
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
     * @param request 催收扣款请求参数
     * @return 催收扣款响应
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
     * @param request 服务授权申请请求参数
     * @return 服务授权申请响应
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
     * @param request 用户授权记录查询请求参数
     * @return 用户授权记录查询响应
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
     * @param request 解除用户授权关系请求参数
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

    /**
     * 直连服务商申请服务授权。
     *
     * @param request 直连服务商服务授权申请请求参数
     * @return 服务授权申请响应
     */
    public ApiCreditSrvSignApplyForSPResponse creditSrvSignApplyForSP(ApiCreditSrvSignApplyForSPRequest request) {
        return executePartnerPost(
                "/v1/payscore/partner/permissions",
                request,
                ApiCreditSrvSignApplyForSPResponse.class);
    }

    /**
     * 直连服务商查询用户授权记录。
     *
     * @param request 直连服务商用户授权查询请求参数
     * @return 用户授权记录查询响应
     */
    public ApiCreditSrvSignQueryForSPResponse creditSrvSignQueryForSP(ApiCreditSrvSignQueryForSPRequest request) {
        String requestPath = "/v1/payscore/partner/permissions/authorization-code/{authorization_code}";
        requestPath = requestPath.replace(
                OUT_AUTHORIZATION_CODE_PATTERN,
                StringUtil.urlEncode(request.getAuthorizationCode()));

        QueryParameter queryParameter = new QueryParameter();
        addQueryParameter(queryParameter, "service_id", request.getServiceId());
        addQueryParameter(queryParameter, "sp_mchid", request.getSpMchid());
        addQueryParameter(queryParameter, "sub_mchid", request.getSubMchid());
        requestPath += queryParameter.getQueryStr();

        return executePartnerGet(requestPath, ApiCreditSrvSignQueryForSPResponse.class);
    }

    /**
     * 直连服务商解除用户授权关系。
     *
     * @param request 直连服务商解除授权请求参数
     * @return 解除用户授权响应
     */
    public ApiCreditSrvUnSignForSPResponse closeCreditServiceForSP(ApiCreditSrvUnSignForSPRequest request) {
        String requestPath = "/v1/payscore/partner/permissions/authorization-code/{authorization_code}/terminate";
        requestPath = requestPath.replace(
                OUT_AUTHORIZATION_CODE_PATTERN,
                StringUtil.urlEncode(request.getAuthorizationCode()));

        return executePartnerPost(requestPath, request, ApiCreditSrvUnSignForSPResponse.class);
    }

    /**
     * 直连服务商创建服务订单。
     *
     * @param request 直连服务商创建服务订单请求参数
     * @return 创建服务订单响应
     */
    public ApiCreateServiceOrderForSPResponse createServiceOrderForSP(ApiCreateServiceOrderForSPRequest request) {
        return executePartnerPost(
                "/v1/payscore/partner/serviceorder/create",
                request,
                ApiCreateServiceOrderForSPResponse.class);
    }

    /**
     * 直连服务商完结服务订单。
     *
     * @param request 直连服务商完结服务订单请求参数
     * @return 完结服务订单响应
     */
    public ApiCompleteServiceOrderForSPResponse completeServiceOrderForSP(ApiCompleteServiceOrderForSPRequest request) {
        return executePartnerPost(
                "/v1/payscore/partner/serviceorder/complete",
                request,
                ApiCompleteServiceOrderForSPResponse.class);
    }

    /**
     * 直连服务商查询服务订单。
     *
     * @param request 直连服务商查询服务订单请求参数
     * @return 查询服务订单响应
     */
    public ApiQueryServiceOrderForSPResponse queryServiceOrderForSP(ApiQueryServiceOrderForSPRequest request) {
        QueryParameter queryParameter = new QueryParameter();
        addQueryParameter(queryParameter, "sp_mchid", request.getSpMchid());
        addQueryParameter(queryParameter, "sp_appid", request.getSpAppid());
        addQueryParameter(queryParameter, "sub_mchid", request.getSubMchid());
        addQueryParameter(queryParameter, "sub_appid", request.getSubAppid());
        addQueryParameter(queryParameter, "out_order_no", request.getOutOrderNo());
        addQueryParameter(queryParameter, "order_id", request.getOrderId());
        addQueryParameter(queryParameter, "service_id", request.getServiceId());

        return executePartnerGet(
                "/v1/payscore/partner/serviceorder/query" + queryParameter.getQueryStr(),
                ApiQueryServiceOrderForSPResponse.class);
    }

    /**
     * 直连服务商取消服务订单。
     *
     * @param request 直连服务商取消服务订单请求参数
     * @return 取消服务订单响应
     */
    public ApiCancelServiceOrderForSPResponse cancelServiceOrderForSP(ApiCancelServiceOrderForSPRequest request) {
        return executePartnerPost(
                "/v1/payscore/partner/serviceorder/cancel",
                request,
                ApiCancelServiceOrderForSPResponse.class);
    }

    /**
     * 直连服务商同步服务订单信息。
     *
     * @param request 直连服务商同步服务订单信息请求参数
     * @return 同步服务订单信息响应
     */
    public ApiSynchronizeServiceOrderInfoForSPResponse synchronizeServiceOrderInfoForSP(
            ApiSynchronizeServiceOrderInfoForSPRequest request) {
        String requestPath = "/v1/payscore/partner/serviceorder/{out_order_no}/sync";
        requestPath = requestPath.replace(
                OUT_ORDER_NO_PATTERN,
                StringUtil.urlEncode(request.getOutOrderNo()));

        return executePartnerPost(requestPath, request, ApiSynchronizeServiceOrderInfoForSPResponse.class);
    }

    /**
     * 直连服务商修改订单金额。
     *
     * @param request 直连服务商修改订单金额请求参数
     * @return 修改订单金额响应
     */
    public ApiModifyAmountForSPResponse modifyAmountForSP(ApiModifyAmountForSPRequest request) {
        return executePartnerPost(
                "/v1/payscore/partner/serviceorder/modify",
                request,
                ApiModifyAmountForSPResponse.class);
    }

    private <T> T executePartnerPost(String requestPath, Object request, Class<T> responseClass) {
        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(
                HttpMethod.POST,
                getRequestUrl(),
                requestPath,
                null,
                GsonUtil.objectToJson(request));
        DouyinpayResponse<T> apiResponse = douyinpayClient.execute(douyinpayRequest, responseClass);
        return apiResponse == null ? null : apiResponse.getApiResponse();
    }

    private <T> T executePartnerGet(String requestPath, Class<T> responseClass) {
        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(
                HttpMethod.GET,
                getRequestUrl(),
                requestPath,
                null,
                null);
        DouyinpayResponse<T> apiResponse = douyinpayClient.execute(douyinpayRequest, responseClass);
        return apiResponse == null ? null : apiResponse.getApiResponse();
    }

    private void addQueryParameter(QueryParameter queryParameter, String name, String value) {
        if (value != null) {
            queryParameter.add(name, StringUtil.urlEncode(value));
        }
    }
}
