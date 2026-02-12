package com.douyinpay.api.splitfund;

import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.DouyinpayRequest;
import com.douyinpay.api.DouyinpayResponse;
import com.douyinpay.api.splitfund.models.ApiQuerySplitFundRequest;
import com.douyinpay.api.splitfund.models.ApiQuerySplitFundResponse;
import com.douyinpay.api.splitfund.models.ApiSplitFundRequest;
import com.douyinpay.api.splitfund.models.ApiSplitFundResponse;
import com.douyinpay.component.http.HttpMethod;
import com.douyinpay.component.http.QueryParameter;
import com.douyinpay.define.DomainName;
import com.douyinpay.util.GsonUtil;
import com.douyinpay.util.StringUtil;

public class ApiSplitFundPaymentsService {
    /**
     * 分账请求接口URI
     */
    private static final String SPLIT_FUND_URI = "/v1/trade/profitsharing/orders";

    /**
     * 分账查询接口URI
     */
    private static final String QUERY_SPLIT_FUND_URI = "/v1/trade/profitsharing/orders/{out_trade_no}";

    private static final String OUT_TRADE_NO_PATTERN = "{out_trade_no}";

    private final DouyinpayClient douyinpayClient;
    private final DomainName domainName;//请求域名

    private ApiSplitFundPaymentsService(DouyinpayClient douyinpayClient, DomainName domainName) {
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
        public ApiSplitFundPaymentsService.Builder domainName(DomainName domainName) {
            this.domainName = domainName;
            return this;
        }

        /**
         * 设置自定义httpclient
         *
         * @param douyinpayClient
         * @return Builder
         */
        public ApiSplitFundPaymentsService.Builder douyinpayClient(DouyinpayClient douyinpayClient) {
            this.douyinpayClient = douyinpayClient;
            return this;
        }

        /**
         * 构造服务
         *
         * @return AppService
         */
        public ApiSplitFundPaymentsService build() {
            return new ApiSplitFundPaymentsService(douyinpayClient, domainName);
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
     * 分账
     *
     * @param request 请求参数
     * @return ApiSplitFundResponse
     */
    public ApiSplitFundResponse splitFund(ApiSplitFundRequest request) {
        String requestUrl = getRequestUrl();
        String body = GsonUtil.objectToJson(request);

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, SPLIT_FUND_URI, null, body);
        DouyinpayResponse<ApiSplitFundResponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiSplitFundResponse.class);

        return apiResponse.getApiResponse();
    }

    /**
     * 分账查询
     *
     * @param request 请求参数
     * @return ApiSplitFundResponse
     */
    public ApiQuerySplitFundResponse querySplitFund(ApiQuerySplitFundRequest request) {
        String requestUrl = getRequestUrl();
        // path填充outTradeNo
        String requestPath = QUERY_SPLIT_FUND_URI.replace(OUT_TRADE_NO_PATTERN, StringUtil.urlEncode(request.getOutTradeNo()));
        // 追加query param
        QueryParameter queryParameter = new QueryParameter();
        if (request.getMerchantId() != null) {
            queryParameter.add("mchid", StringUtil.urlEncode(request.getMerchantId()));
        }
        if (request.getTradeNo() != null) {
            queryParameter.add("transaction_id", StringUtil.urlEncode(request.getTradeNo()));
        }
        if (request.getOrderId() != null) {
            queryParameter.add("order_id", StringUtil.urlEncode(request.getOrderId()));
        }
        requestPath += queryParameter.getQueryStr();

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.GET, requestUrl, requestPath, null, null);
        DouyinpayResponse<ApiQuerySplitFundResponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiQuerySplitFundResponse.class);

        return apiResponse.getApiResponse();
    }
}
