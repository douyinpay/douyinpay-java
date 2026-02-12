package com.douyinpay.api.refund;

import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.DouyinpayRequest;
import com.douyinpay.api.DouyinpayResponse;
import com.douyinpay.api.refund.model.ApiCreateRequest;
import com.douyinpay.api.refund.model.ApiQueryByOutRefundNoRequest;
import com.douyinpay.api.refund.model.ApiRefund;
import com.douyinpay.component.http.HttpMethod;
import com.douyinpay.component.http.QueryParameter;
import com.douyinpay.define.DomainName;
import com.douyinpay.util.GsonUtil;
import com.douyinpay.util.StringUtil;

public class ApiRefundService {

    private final DouyinpayClient douyinpayClient;
    private final DomainName domainName;//请求域名

    private ApiRefundService(DouyinpayClient douyinpayClient, DomainName domainName) {
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
        public ApiRefundService.Builder domainName(DomainName domainName) {
            this.domainName = domainName;
            return this;
        }

        /**
         * 设置自定义httpclient
         *
         * @param douyinpayClient
         * @return Builder
         */
        public ApiRefundService.Builder douyinpayClient(DouyinpayClient douyinpayClient) {
            this.douyinpayClient = douyinpayClient;
            return this;
        }

        /**
         * 构造服务
         *
         * @return AppService
         */
        public ApiRefundService build() {
            return new ApiRefundService(douyinpayClient, domainName);
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
     * 退款申请
     *
     * @param request
     * @return
     */
    public ApiRefund create(ApiCreateRequest request) {
        String requestPath = "/v1/trade/refund/domestic/refunds";
        String requestUrl = getRequestUrl();

        String body = GsonUtil.objectToJson(request);

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, requestPath, null, body);

        DouyinpayResponse<com.douyinpay.api.refund.model.ApiRefund> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiRefund.class);

        return apiResponse.getApiResponse();
    }

    /**
     * 查询单笔退款（通过商户退款单号）
     *
     * @param request
     * @return ApiRefund
     */
    public ApiRefund queryByOutRefundNo(ApiQueryByOutRefundNoRequest request) {

        String requestPath = "/v1/trade/refund/domestic/refunds/{out_refund_no}";
        String requestUrl = getRequestUrl();
        ApiQueryByOutRefundNoRequest realRequest = request;

        // 添加 path param
        requestPath =
                requestPath.replace("{" + "out_refund_no" + "}", StringUtil.urlEncode(realRequest.getOutRefundNo()));

        // 添加 query param
        QueryParameter queryParameter = new QueryParameter();
        if (realRequest.getMchid() != null) {
            queryParameter.add("mchid", StringUtil.urlEncode(realRequest.getMchid()));
        }
        if (realRequest.getSpMchid() != null) {
            queryParameter.add("sp_mchid", StringUtil.urlEncode(realRequest.getSpMchid()));
        }
        if (realRequest.getSubMchid() != null) {
            queryParameter.add("sub_mchid", StringUtil.urlEncode(realRequest.getSubMchid()));
        }
        requestPath += queryParameter.getQueryStr();

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.GET, requestUrl, requestPath, null, null);

        DouyinpayResponse<com.douyinpay.api.refund.model.ApiRefund> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiRefund.class);

        return apiResponse.getApiResponse();
    }

}
