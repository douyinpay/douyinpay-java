package com.douyinpay.api.tranferreturn;

import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.DouyinpayRequest;
import com.douyinpay.api.DouyinpayResponse;
import com.douyinpay.api.tranferreturn.models.*;
import com.douyinpay.component.http.HttpMethod;
import com.douyinpay.component.http.QueryParameter;
import com.douyinpay.define.DomainName;
import com.douyinpay.util.GsonUtil;
import com.douyinpay.util.StringUtil;

public class ApiTransferReturnService {
    /**
     * 转账退回请求接口URI
     */
    private static final String TANSFER_RETURN_URI = "/v1/transfer/transfer-return";

    /**
     * 转账退回查询接口URI(通过抖音单号查询)
     */
    private static final String QUERY_TANSFER_RETURN__BY_ID_URI = "/v1/transfer/transfer-return/id/{order_id}";

    private static final String ORDER_ID_PATTERN = "{order_id}";

    /**
     * 转账退回查询接口URI(通过商家单号查询)
     */
    private static final String QUERY_TANSFER_RETURN__BY_OUT_TRADE_NO_URI = "/v1/transfer/transfer-return/out-request-no/{out_request_no}";

    private static final String OUT_REQUEST_NO_PATTERN = "{out_request_no}";

    private final DouyinpayClient douyinpayClient;
    private final DomainName domainName;//请求域名

    public static class Builder {

        private DouyinpayClient douyinpayClient;
        private DomainName domainName;

        /**
         * 设置抖音支付域名 默认为api.douyinpay.com
         *
         * @param domainName 抖音支付域名
         * @return Builder
         */
        public ApiTransferReturnService.Builder domainName(DomainName domainName) {
            this.domainName = domainName;
            return this;
        }

        /**
         * 设置自定义httpclient
         *
         * @param douyinpayClient
         * @return Builder
         */
        public ApiTransferReturnService.Builder douyinpayClient(DouyinpayClient douyinpayClient) {
            this.douyinpayClient = douyinpayClient;
            return this;
        }

        /**
         * 构造服务
         *
         * @return AppService
         */
        public ApiTransferReturnService build() {
            return new ApiTransferReturnService(douyinpayClient, domainName);
        }
    }


    private ApiTransferReturnService(DouyinpayClient douyinpayClient, DomainName domainName) {
        this.douyinpayClient = douyinpayClient;
        this.domainName = domainName;
    }
    public String getRequestUrl() {
        String domainName = DomainName.API.getValue();
        if (this.domainName != null) {
            domainName = this.domainName.getValue();
        }
        return domainName;
    }

    /**
     * 转账退回
     *
     * @param request 请求参数
     * @return ApiSplitFundResponse
     */
    public ApiTransferReturnResponse transferReturn(ApiTransferReturnRequest request) {
        String requestUrl = getRequestUrl();
        String body = GsonUtil.objectToJson(request);

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, TANSFER_RETURN_URI, null, body);
        DouyinpayResponse<ApiTransferReturnResponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiTransferReturnResponse.class);

        return apiResponse.getApiResponse();
    }


    /**
     * 转账退回查询（通过抖音单号）
     *
     * @param request 请求参数
     * @return ApiSplitFundResponse
     */
    public ApiTransferReturnQueryResponse queryTransferReturnById(ApiTransferReturnQueryByIdRequest request) {
        String requestUrl = getRequestUrl();
        // path填充outTradeNo
        String requestPath = QUERY_TANSFER_RETURN__BY_ID_URI.replace(ORDER_ID_PATTERN, StringUtil.urlEncode(request.getRefundOrderId()));
        // 追加query param
        QueryParameter queryParameter = new QueryParameter();
        if (request.getMerchantId() != null) {
            queryParameter.add("mchid", StringUtil.urlEncode(request.getMerchantId()));
        }
        if (request.getRefundOrderId() != null) {
            queryParameter.add("refund_order_id", StringUtil.urlEncode(request.getRefundOrderId()));
        }
        requestPath += queryParameter.getQueryStr();

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.GET, requestUrl, requestPath, null, null);
        DouyinpayResponse<ApiTransferReturnQueryResponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiTransferReturnQueryResponse.class);

        return apiResponse.getApiResponse();
    }


    /**
     * 转账退回查询（通过商家单号）
     *
     * @param request 请求参数
     * @return ApiSplitFundResponse
     */
    public ApiTransferReturnQueryResponse queryTransferReturnByRequestNo(ApiTransferReturnQueryByOutTradeNoRequest request) {
        String requestUrl = getRequestUrl();
        // path填充outTradeNo
        String requestPath = QUERY_TANSFER_RETURN__BY_ID_URI.replace(ORDER_ID_PATTERN, StringUtil.urlEncode(request.getOutRequestNo()));
        // 追加query param
        QueryParameter queryParameter = new QueryParameter();
        if (request.getMerchantId() != null) {
            queryParameter.add("mchid", StringUtil.urlEncode(request.getMerchantId()));
        }
        if (request.getOutRequestNo() != null) {
            queryParameter.add("out_request_no", StringUtil.urlEncode(request.getOutRequestNo()));
        }
        requestPath += queryParameter.getQueryStr();
        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.GET, requestUrl, requestPath, null, null);
        DouyinpayResponse<ApiTransferReturnQueryResponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiTransferReturnQueryResponse.class);
        return apiResponse.getApiResponse();
    }
}
