package com.douyinpay.api.partnerpayments.h5;

import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.DouyinpayRequest;
import com.douyinpay.api.DouyinpayResponse;
import com.douyinpay.api.partnerpayments.common.ApiTransaction;
import com.douyinpay.api.partnerpayments.h5.model.ApiCloseOrderRequest;
import com.douyinpay.api.partnerpayments.h5.model.ApiPrepayRequest;
import com.douyinpay.api.partnerpayments.h5.model.ApiPrepayResponse;
import com.douyinpay.api.partnerpayments.h5.model.ApiQueryOrderByIdRequest;
import com.douyinpay.api.partnerpayments.h5.model.ApiQueryOrderByOutTradeNoRequest;
import com.douyinpay.component.http.HttpMethod;
import com.douyinpay.component.http.QueryParameter;
import com.douyinpay.define.DomainName;
import com.douyinpay.util.GsonUtil;
import com.douyinpay.util.StringUtil;

/**
 * 服务商 H5 支付服务。
 *
 * 官方文档：
 * - H5 下单：POST /v1/trade/partner/transactions/h5
 * https://partner.douyinpay.com/wiki/682c7a8e82b07604fd4deccb/6911f7c7f09d4f04f443b5e4
 * - 查询订单：GET /v1/trade/partner/transactions/id/{transaction_id}
 * https://partner.douyinpay.com/wiki/682c7a8e82b07604fd4deccb/6852bb22fe022d05166966c5
 * - 关闭订单：POST /v1/trade/partner/transactions/out-trade-no/{out_trade_no}/close
 * https://partner.douyinpay.com/wiki/682c7a8e82b07604fd4deccb/6852bb25d479e6051ac20fb4
 */
public class ApiPartnerH5PaymentService {

    private final String OUT_TRADE_NO_PATTERN = "{out_trade_no}";
    private final String TRANSACTION_ID_PATTERN = "{transaction_id}";
    private final DouyinpayClient douyinpayClient;
    private final DomainName domainName;// 请求域名

    private ApiPartnerH5PaymentService(DouyinpayClient douyinpayClient, DomainName domainName) {
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
        public ApiPartnerH5PaymentService.Builder domainName(DomainName domainName) {
            this.domainName = domainName;
            return this;
        }

        /**
         * 设置自定义httpclient
         *
         * @param douyinpayClient
         * @return Builder
         */
        public ApiPartnerH5PaymentService.Builder douyinpayClient(DouyinpayClient douyinpayClient) {
            this.douyinpayClient = douyinpayClient;
            return this;
        }

        /**
         * 构造服务
         *
         * @return AppService
         */
        public ApiPartnerH5PaymentService build() {
            return new ApiPartnerH5PaymentService(douyinpayClient, domainName);
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
     * H5 支付下单。
     *
     * 官方文档：
     * https://partner.douyinpay.com/wiki/682c7a8e82b07604fd4deccb/6911f7c7f09d4f04f443b5e4
     *
     * @param request 请求参数
     * @return PrepayResponse
     */
    public ApiPrepayResponse prepay(ApiPrepayRequest request) {
        String requestPath = "/v1/trade/partner/transactions/h5";
        String requestUrl = getRequestUrl();

        String body = GsonUtil.objectToJson(request);

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, requestPath, null, body);

        DouyinpayResponse<ApiPrepayResponse> apiResponse = douyinpayClient.execute(douyinpayRequest,
                ApiPrepayResponse.class);

        return apiResponse.getApiResponse();
    }

    /**
     * 关闭订单。
     *
     * 官方文档：
     * https://partner.douyinpay.com/wiki/682c7a8e82b07604fd4deccb/6852bb25d479e6051ac20fb4
     *
     * @param request 请求参数
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
     * 根据支付订单号查询订单。
     *
     * 官方文档：
     * https://partner.douyinpay.com/wiki/682c7a8e82b07604fd4deccb/6852bb22fe022d05166966c5
     *
     * @param request 请求参数
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
     * 根据商户订单号查询订单。
     *
     * 官方文档：
     * https://partner.douyinpay.com/wiki/682c7a8e82b07604fd4deccb/6852bb22fe022d05166966c5
     *
     * @param request 请求参数
     * @return ApiTransaction
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
