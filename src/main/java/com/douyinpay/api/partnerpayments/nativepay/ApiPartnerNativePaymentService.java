
package com.douyinpay.api.partnerpayments.nativepay;

import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.DouyinpayRequest;
import com.douyinpay.api.DouyinpayResponse;
import com.douyinpay.api.partnerpayments.common.ApiTransaction;
import com.douyinpay.api.partnerpayments.nativepay.model.ApiCloseOrderRequest;
import com.douyinpay.api.partnerpayments.nativepay.model.ApiPrepayRequest;
import com.douyinpay.api.partnerpayments.nativepay.model.ApiPrepayResponse;
import com.douyinpay.api.partnerpayments.nativepay.model.ApiQueryOrderByIdRequest;
import com.douyinpay.api.partnerpayments.nativepay.model.ApiQueryOrderByOutTradeNoRequest;
import com.douyinpay.component.http.HttpMethod;
import com.douyinpay.component.http.QueryParameter;
import com.douyinpay.define.DomainName;
import com.douyinpay.util.GsonUtil;
import com.douyinpay.util.StringUtil;

/**
 * 服务商 Native 支付服务。
 *
 * 官方文档：
 * - Native 下单：POST /v1/trade/partner/transactions/native
 * https://partner.douyinpay.com/wiki/682c7a8e82b07604fd4deccb/69e2edebfa370204da33c579
 * - 查询订单：GET /v1/trade/partner/transactions/id/{transaction_id}
 * https://partner.douyinpay.com/wiki/682c7a8e82b07604fd4deccb/6852bb22fe022d05166966c5
 * - 关闭订单：POST /v1/trade/partner/transactions/out-trade-no/{out_trade_no}/close
 * https://partner.douyinpay.com/wiki/682c7a8e82b07604fd4deccb/6852bb25d479e6051ac20fb4
 */
public class ApiPartnerNativePaymentService {

    private final String OUT_TRADE_NO_PATTERN = "{out_trade_no}";
    private final String TRANSACTION_ID_PATTERN = "{transaction_id}";

    private final DouyinpayClient douyinpayClient;
    private final DomainName domainName;

    private ApiPartnerNativePaymentService(DouyinpayClient douyinpayClient, DomainName domainName) {
        this.douyinpayClient = douyinpayClient;
        this.domainName = domainName;
    }

    public static class Builder {
        private DouyinpayClient douyinpayClient;
        private DomainName domainName;

        public Builder domainName(DomainName domainName) {
            this.domainName = domainName;
            return this;
        }

        public Builder douyinpayClient(DouyinpayClient douyinpayClient) {
            this.douyinpayClient = douyinpayClient;
            return this;
        }

        public ApiPartnerNativePaymentService build() {
            return new ApiPartnerNativePaymentService(douyinpayClient, domainName);
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
     * Native支付下单。
     *
     * 官方文档：
     * https://partner.douyinpay.com/wiki/682c7a8e82b07604fd4deccb/69e2edebfa370204da33c579
     *
     * @param request 请求参数
     * @return ApiPrepayResponse
     */
    public ApiPrepayResponse prepay(ApiPrepayRequest request) {
        String requestPath = "/v1/trade/partner/transactions/native";
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

        requestPath = requestPath.replace(TRANSACTION_ID_PATTERN, StringUtil.urlEncode(request.getTransactionId()));

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

        requestPath = requestPath.replace(OUT_TRADE_NO_PATTERN, StringUtil.urlEncode(request.getOutTradeNo()));

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
