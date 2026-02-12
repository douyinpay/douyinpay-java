package com.douyinpay.api.partnerpayments.jsapi;

import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.DouyinpayRequest;
import com.douyinpay.api.DouyinpayResponse;
import com.douyinpay.api.partnerpayments.common.ApiTransaction;
import com.douyinpay.api.partnerpayments.jsapi.model.ApiCloseOrderRequest;
import com.douyinpay.api.partnerpayments.jsapi.model.ApiPrepayRequest;
import com.douyinpay.api.partnerpayments.jsapi.model.ApiPrepayResponse;
import com.douyinpay.api.partnerpayments.jsapi.model.ApiQueryOrderByIdRequest;
import com.douyinpay.api.partnerpayments.jsapi.model.ApiQueryOrderByOutTradeNoRequest;
import com.douyinpay.component.http.HttpMethod;
import com.douyinpay.component.http.QueryParameter;
import com.douyinpay.define.DomainName;
import com.douyinpay.util.GsonUtil;
import com.douyinpay.util.StringUtil; 

public class ApiPartnerJsapiPaymentService{

    private final String OUT_TRADE_NO_PATTERN = "{out_trade_no}";
    private final String TRANSACTION_ID_PATTERN = "{transaction_id}";

    private final DouyinpayClient douyinpayClient;
    private final DomainName domainName;//请求域名

    private ApiPartnerJsapiPaymentService(DouyinpayClient douyinpayClient, DomainName domainName) {
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
        public ApiPartnerJsapiPaymentService build() {
            return new ApiPartnerJsapiPaymentService(douyinpayClient, domainName);
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
     * jsapi支付下单
     *
     * @param request 请求参数
     * @return PrepayResponse
     */
    public ApiPrepayResponse prepay(ApiPrepayRequest request) {
        String requestPath = "/v1/trade/partner/transactions/jsapi";
        String requestUrl = getRequestUrl();


        String body = GsonUtil.objectToJson(request);

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, requestPath, null, body);

        DouyinpayResponse<ApiPrepayResponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiPrepayResponse.class);

        return apiResponse.getApiResponse();
    }


    /**
     * 关闭订单
     *
     * @param request
     */
    public void closeOrder(ApiCloseOrderRequest request) {
        String requestUrl = getRequestUrl();

        String requestPath = "/v1/trade/partner/transactions/out-trade-no/{out_trade_no}/close";


        // 添加 path param
        requestPath = requestPath.replace(OUT_TRADE_NO_PATTERN, StringUtil.urlEncode(request.getOutTradeNo()));


        String body = GsonUtil.objectToJson(request);

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, requestPath, null, body);

        douyinpayClient.execute(douyinpayRequest, null);


    }

    /**
     * 根据支付订单号查询订单
     *
     * @param request
     * @return ApiTransaction
     */
    public ApiTransaction queryOrderById(ApiQueryOrderByIdRequest request) {

        String requestPath = "/v1/trade/partner/transactions/id/{transaction_id}";
        String requestUrl = getRequestUrl();


        // 添加 path param
        requestPath = requestPath.replace(TRANSACTION_ID_PATTERN, StringUtil.urlEncode(request.getTransactionId()));

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

        DouyinpayResponse<ApiTransaction> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiTransaction.class);

        return apiResponse.getApiResponse();
    }


    /**
     * 根据商户订单号查询订单
     *
     * @param request
     * @return
     */
    public ApiTransaction queryOrderByOutTradeNo(ApiQueryOrderByOutTradeNoRequest request) {

        String requestPath = "/v1/trade/partner/transactions/out-trade-no/{out_trade_no}";
        String requestUrl = getRequestUrl();

        // 添加 path param
        requestPath = requestPath.replace(OUT_TRADE_NO_PATTERN, StringUtil.urlEncode(request.getOutTradeNo()));

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
  
        DouyinpayResponse<ApiTransaction> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiTransaction.class);

        return apiResponse.getApiResponse();
    }

}

