package com.douyinpay.api.partnerbill;

import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.DouyinpayRequest;
import com.douyinpay.api.DouyinpayResponse;
import com.douyinpay.api.partnerbill.models.ApplyTradeBillRequest;
import com.douyinpay.api.partnerbill.models.ApiBillReponse;
import com.douyinpay.api.partnerbill.models.ApplyFundFlowBillRequest;
import com.douyinpay.api.partnerbill.models.ApplySplitBillRequest;
import com.douyinpay.component.http.HttpMethod;
import com.douyinpay.component.http.QueryParameter;
import com.douyinpay.define.DomainName;
import com.douyinpay.util.StringUtil;
import org.apache.commons.lang3.StringUtils;

public class ApiBillService {
    /**
     * 申请下载交易账单
     */
    private static final String ApplyTradeBillURI = "/v1/bill/tradebill";
    /**
     * 申请下载资金账单
     */
    private static final String ApplyFundFlowBillURI = "/v1/bill/fundflowbill";
    /**
     * 申请下载分账账单
     */
    private static final String ApplySplitBillURI = "/v1/bill/splitbill";

    private final DouyinpayClient douyinpayClient;
    private final DomainName domainName;//请求域名

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


    public ApiBillReponse applyTradeBill(ApplyTradeBillRequest request) {
        String requestUrl = getRequestUrl();
        // 添加 query param
        QueryParameter queryParameter = new QueryParameter();
        queryParameter.add("sp_mchid", StringUtil.urlEncode(request.getSpMchid()));
        queryParameter.add("bill_date", StringUtil.urlEncode(request.getBillDate()));
        queryParameter.add("tar_type", request.getTarType());
        if (StringUtils.isNotEmpty(request.getSubMchid())){
            queryParameter.add("sub_mchid", request.getSubMchid());
        }
        String requestPath = ApplyTradeBillURI + queryParameter.getQueryStr();
        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.GET, requestUrl, requestPath, null, null);
        DouyinpayResponse<ApiBillReponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiBillReponse.class);
        return apiResponse.getApiResponse();
    }

    public ApiBillReponse applyFundFlowBill(ApplyFundFlowBillRequest request) {
        String requestUrl = getRequestUrl();
        // 添加 query param
        QueryParameter queryParameter = new QueryParameter();
        queryParameter.add("sp_mchid", StringUtil.urlEncode(request.getSpMchid()));
        queryParameter.add("bill_date", StringUtil.urlEncode(request.getBillDate()));
        queryParameter.add("tar_type", request.getTarType());
        if (StringUtils.isNotEmpty(request.getAccountType())){
            queryParameter.add("account_type", request.getAccountType());
        }
        if (StringUtils.isNotEmpty(request.getSubMchid())){
            queryParameter.add("sub_mchid", request.getSubMchid());
        }
        String requestPath = ApplyFundFlowBillURI + queryParameter.getQueryStr();
        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.GET, requestUrl, requestPath, null, null);
        DouyinpayResponse<ApiBillReponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiBillReponse.class);
        return apiResponse.getApiResponse();
    }

    public ApiBillReponse applySplitBill(ApplySplitBillRequest request) {
        String requestUrl = getRequestUrl();
        // 添加 query param
        QueryParameter queryParameter = new QueryParameter();
        queryParameter.add("sp_mchid", StringUtil.urlEncode(request.getSpMchid()));
        queryParameter.add("bill_date", StringUtil.urlEncode(request.getBillDate()));
        queryParameter.add("tar_type", request.getTarType());
        if (StringUtils.isNotEmpty(request.getSubMchid())){
            queryParameter.add("sub_mchid", request.getSubMchid());
        }
        String requestPath = ApplySplitBillURI + queryParameter.getQueryStr();
        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.GET, requestUrl, requestPath, null, null);
        DouyinpayResponse<ApiBillReponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiBillReponse.class);
        return apiResponse.getApiResponse();
    }
}
