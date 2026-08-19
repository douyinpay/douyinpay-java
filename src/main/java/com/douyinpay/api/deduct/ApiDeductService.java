package com.douyinpay.api.deduct;

import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.DouyinpayRequest;
import com.douyinpay.api.DouyinpayResponse;
import com.douyinpay.api.deduct.models.ApiCloseOrderRequest;
import com.douyinpay.api.deduct.models.ApiDeductNotifyRequest;
import com.douyinpay.api.deduct.models.ApiDeductNotifyResponse;
import com.douyinpay.api.deduct.models.ApiDeductRequest;
import com.douyinpay.api.deduct.models.ApiDeductResponse;
import com.douyinpay.api.deduct.models.ApiQueryOrderByIdRequest;
import com.douyinpay.api.deduct.models.ApiQueryOrderByOutTradeNoRequest;
import com.douyinpay.api.deduct.models.ApiTransaction;
import com.douyinpay.component.http.HttpMethod;
import com.douyinpay.component.http.QueryParameter;
import com.douyinpay.define.DomainName;
import com.douyinpay.util.GsonUtil;
import com.douyinpay.util.StringUtil;

/**
 * 直连商户代扣服务。
 *
 * 接口路径：
 * - 申请扣款：POST /v1/deduct/payapply
 * - 关闭订单：POST /v1/trade/transactions/out-trade-no/{out_trade_no}/close
 * - 按抖音支付订单号查询订单：GET /v1/trade/transactions/id/{transaction_id}
 * - 按商户订单号查询订单：GET /v1/trade/transactions/out-trade-no/{out_trade_no}
 * - 预约扣费通知：POST /v1/agreementauth/deductNotify
 */
public class ApiDeductService {

    private final String OUT_TRADE_NO_PATTERN = "{out_trade_no}";
    private final String TRANSACTION_ID_PATTERN = "{transaction_id}";

    private final DouyinpayClient douyinpayClient;
    private final DomainName domainName;// 请求域名

    private ApiDeductService(DouyinpayClient douyinpayClient, DomainName domainName) {
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
         * 设置自定义 HTTP 客户端。
         *
         * @param douyinpayClient 自定义 HTTP 客户端
         * @return 当前构建器
         */
        public Builder douyinpayClient(DouyinpayClient douyinpayClient) {
            this.douyinpayClient = douyinpayClient;
            return this;
        }

        /**
         * 构造直连商户代扣服务。
         *
         * @return ApiDeductService
         */
        public ApiDeductService build() {
            return new ApiDeductService(douyinpayClient, domainName);
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
     * 申请扣款
     *
     * @param request 请求参数
     * @return ApiDeductResponse
     */
    public ApiDeductResponse deduct(ApiDeductRequest request) {
        String requestPath = "/v1/deduct/payapply";
        String requestUrl = getRequestUrl();

        String body = GsonUtil.objectToJson(request);

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, requestPath, null, body);

        DouyinpayResponse<ApiDeductResponse> apiResponse = douyinpayClient.execute(douyinpayRequest,
                ApiDeductResponse.class);

        return apiResponse.getApiResponse();
    }

    /**
     * 关闭订单。
     *
     * 官方文档：
     * https://pay.douyinpay.com/wiki/639fd48f17c2f3021d237f61/639fd5d617c2f3021d2381b2
     *
     * @param request 请求参数
     */
    public void closeOrder(ApiCloseOrderRequest request) {
        String requestUrl = getRequestUrl();

        String requestPath = "/v1/trade/transactions/out-trade-no/{out_trade_no}/close";

        // 添加 path param
        requestPath = requestPath.replace(OUT_TRADE_NO_PATTERN, StringUtil.urlEncode(request.getOutTradeNo()));

        String body = GsonUtil.objectToJson(request);

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, requestPath, null, body);

        douyinpayClient.execute(douyinpayRequest, null);

    }

    /**
     * 根据支付订单号查询订单。
     *
     * 官方文档：
     * https://pay.douyinpay.com/wiki/639fd48f17c2f3021d237f61/63f445410b970c0209070167
     *
     * @param request 请求参数
     * @return ApiTransaction
     */
    public ApiTransaction queryOrderById(ApiQueryOrderByIdRequest request) {

        String requestPath = "/v1/trade/transactions/id/{transaction_id}";
        String requestUrl = getRequestUrl();

        // 添加 path param
        requestPath = requestPath.replace(TRANSACTION_ID_PATTERN, StringUtil.urlEncode(request.getTransactionId()));

        // 添加 query param
        QueryParameter queryParameter = new QueryParameter();
        if (request.getMchid() != null) {
            queryParameter.add("mchid", StringUtil.urlEncode(request.getMchid()));
        }
        requestPath += queryParameter.getQueryStr();

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.GET, requestUrl, requestPath, null, null);

        DouyinpayResponse<ApiTransaction> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiTransaction.class);

        return apiResponse.getApiResponse();
    }

    /**
     * 根据商户订单号查询订单。
     *
     * 官方文档：
     * https://pay.douyinpay.com/wiki/639fd48f17c2f3021d237f61/63f445410b970c0209070167
     *
     * @param request 请求参数
     * @return ApiTransaction
     */
    public ApiTransaction queryOrderByOutTradeNo(ApiQueryOrderByOutTradeNoRequest request) {

        String requestPath = "/v1/trade/transactions/out-trade-no/{out_trade_no}";
        String requestUrl = getRequestUrl();

        // 添加 path param
        requestPath = requestPath.replace(OUT_TRADE_NO_PATTERN, StringUtil.urlEncode(request.getOutTradeNo()));

        // 添加 query param
        QueryParameter queryParameter = new QueryParameter();
        if (request.getMchid() != null) {
            queryParameter.add("mchid", StringUtil.urlEncode(request.getMchid()));
        }
        requestPath += queryParameter.getQueryStr();

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.GET, requestUrl, requestPath, null, null);

        DouyinpayResponse<ApiTransaction> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiTransaction.class);

        return apiResponse.getApiResponse();
    }

    /**
     * 预约扣费通知
     *
     * @param request 请求参数
     * @return ApiDeductNotifyResponse
     */
    public ApiDeductNotifyResponse deductNotify(ApiDeductNotifyRequest request) {
        String requestPath = "/v1/agreementauth/deductNotify";
        String requestUrl = getRequestUrl();

        String body = GsonUtil.objectToJson(request);

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, requestPath, null, body);

        DouyinpayResponse<ApiDeductNotifyResponse> apiResponse = douyinpayClient.execute(douyinpayRequest,
                ApiDeductNotifyResponse.class);

        return apiResponse.getApiResponse();
    }

}
