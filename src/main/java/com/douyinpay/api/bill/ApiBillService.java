package com.douyinpay.api.bill;

import org.apache.commons.lang3.StringUtils;

import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.DouyinpayRequest;
import com.douyinpay.api.DouyinpayResponse;
import com.douyinpay.api.bill.models.ApiBillApplyRequest;
import com.douyinpay.api.bill.models.ApiBillReponse;
import com.douyinpay.api.bill.models.ApplyFundFlowBillRequest;
import com.douyinpay.api.bill.models.ApplySplitBillRequest;
import com.douyinpay.component.http.HttpMethod;
import com.douyinpay.component.http.QueryParameter;
import com.douyinpay.define.DomainName;
import com.douyinpay.util.StringUtil;

/**
 * 账单服务。
 *
 * 官方文档：
 * - 申请交易账单：GET /v1/bill/billapply
 * https://pay.douyinpay.com/wiki/639fd48f17c2f3021d237f61/667e6bc444a74902ead102ad
 * - 申请资金账单：GET /v1/bill/fundflowbill
 * https://pay.douyinpay.com/wiki/639fd48f17c2f3021d237f61/667e69daa998e00305dcec48
 * - 申请分账账单：GET /v1/bill/splitbill
 * https://pay.douyinpay.com/wiki/639fd48f17c2f3021d237f61/68355a92994b190515a2af86
 */
public class ApiBillService {

    /**
     * 申请下载资金账单
     */
    private static final String ApplyFundFlowBillURI = "/v1/bill/fundflowbill";
    /**
     * 申请下载分账账单
     */
    private static final String ApplySplitBillURI = "/v1/bill/splitbill";

    private final DouyinpayClient douyinpayClient;
    private final DomainName domainName;// 请求域名

    private ApiBillService(DouyinpayClient douyinpayClient, DomainName domainName) {
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
        public ApiBillService.Builder domainName(DomainName domainName) {
            this.domainName = domainName;
            return this;
        }

        /**
         * 设置自定义httpclient
         *
         * @param douyinpayClient
         * @return Builder
         */
        public ApiBillService.Builder douyinpayClient(DouyinpayClient douyinpayClient) {
            this.douyinpayClient = douyinpayClient;
            return this;
        }

        /**
         * 构造服务
         *
         * @return AppService
         */
        public ApiBillService build() {
            return new ApiBillService(douyinpayClient, domainName);
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
     * 申请交易账单。
     *
     * @param request 请求参数
     * @return ApiBillReponse
     */
    public ApiBillReponse billApply(ApiBillApplyRequest request) {

        String requestPath = "/v1/bill/billapply";
        String requestUrl = getRequestUrl();

        ApiBillApplyRequest realRequest = request;

        // 添加 query param
        QueryParameter queryParameter = new QueryParameter();
        queryParameter.add("mchid", StringUtil.urlEncode(realRequest.getMchid()));
        queryParameter.add("bill_date", StringUtil.urlEncode(realRequest.getBillDate()));
        if (StringUtils.isNotEmpty(realRequest.getBillType())) {
            queryParameter.add("bill_type", realRequest.getBillType());
        }
        if (StringUtils.isNotEmpty(realRequest.getTarType())) {
            queryParameter.add("tar_type", realRequest.getTarType());
        }
        requestPath += queryParameter.getQueryStr();

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.GET, requestUrl, requestPath, null, null);

        DouyinpayResponse<ApiBillReponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiBillReponse.class);
        return apiResponse.getApiResponse();
    }

    /**
     * 申请资金账单。
     *
     * @param request 请求参数
     * @return ApiBillReponse
     */
    public ApiBillReponse applyFundFlowBill(ApplyFundFlowBillRequest request) {
        String requestUrl = getRequestUrl();
        // 添加 query param
        QueryParameter queryParameter = new QueryParameter();
        queryParameter.add("mchid", StringUtil.urlEncode(request.getMchid()));
        queryParameter.add("bill_date", StringUtil.urlEncode(request.getBillDate()));
        if (StringUtils.isNotEmpty(request.getAccountType())) {
            queryParameter.add("account_type", request.getAccountType());
        }
        queryParameter.add("tar_type", request.getTarType());
        String requestPath = ApplyFundFlowBillURI + queryParameter.getQueryStr();
        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.GET, requestUrl, requestPath, null, null);
        DouyinpayResponse<ApiBillReponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiBillReponse.class);
        return apiResponse.getApiResponse();
    }

    /**
     * 申请分账账单。
     *
     * @param request 请求参数
     * @return ApiBillReponse
     */
    public ApiBillReponse applySplitBill(ApplySplitBillRequest request) {
        String requestUrl = getRequestUrl();
        // 添加 query param
        QueryParameter queryParameter = new QueryParameter();
        queryParameter.add("mchid", StringUtil.urlEncode(request.getMchid()));
        queryParameter.add("bill_date", StringUtil.urlEncode(request.getBillDate()));
        queryParameter.add("tar_type", request.getTarType());
        String requestPath = ApplySplitBillURI + queryParameter.getQueryStr();
        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.GET, requestUrl, requestPath, null, null);
        DouyinpayResponse<ApiBillReponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiBillReponse.class);
        return apiResponse.getApiResponse();
    }
}
