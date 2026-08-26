package com.douyinpay.api.partnerbill;

import org.apache.commons.lang3.StringUtils;

import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.DouyinpayRequest;
import com.douyinpay.api.DouyinpayResponse;
import com.douyinpay.api.partnerbill.models.ApiBillReponse;
import com.douyinpay.api.partnerbill.models.ApplyFundFlowBillRequest;
import com.douyinpay.api.partnerbill.models.ApplySplitBillRequest;
import com.douyinpay.api.partnerbill.models.ApplyTradeBillRequest;
import com.douyinpay.component.http.HttpMethod;
import com.douyinpay.component.http.QueryParameter;
import com.douyinpay.define.DomainName;
import com.douyinpay.util.StringUtil;

/**
 * 服务商账单服务。
 *
 * <p>适用于普通服务商和平台商户。申请成功后会返回 download_url、hash_type 和 hash_value，
 * 其中 download_url 有效期为 5 分钟，建议下载完成后比对 hash_value 校验账单完整性。</p>
 */
public class ApiBillService {
    /**
     * 申请下载交易账单。
     */
    private static final String ApplyTradeBillURI = "/v1/bill/tradebill";
    /**
     * 申请下载资金账单。
     */
    private static final String ApplyFundFlowBillURI = "/v1/bill/fundflowbill";
    /**
     * 申请下载分账账单。
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
         * 设置抖音支付域名，默认为 api.douyinpay.com。
         *
         * @param domainName 抖音支付请求域名
         * @return Builder
         */
        public Builder domainName(DomainName domainName) {
            this.domainName = domainName;
            return this;
        }

        /**
         * 设置自定义 DouyinpayClient。
         *
         * @param douyinpayClient 抖音支付客户端
         * @return Builder
         */
        public Builder douyinpayClient(DouyinpayClient douyinpayClient) {
            this.douyinpayClient = douyinpayClient;
            return this;
        }

        /**
         * 构造服务商账单服务。
         *
         * @return ApiBillService
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
     * 申请服务商交易账单下载地址。
     *
     * <p>交易账单按天生成，包含交易相关的金额、时间、营销等信息，供商户核对订单交易完成、退款、撤销等情况。
     * 二级商户不单独提供对账单下载；如需下载某个子商户下的交易或退款数据，可传入 sub_mchid，平台商户不支持该字段。</p>
     *
     * @param request 请求参数，包含商户号、子商户号、账单日期和压缩类型
     * @return 账单下载响应，包含下载地址和文件摘要信息
     */
    public ApiBillReponse applyTradeBill(ApplyTradeBillRequest request) {
        String requestUrl = getRequestUrl();
        // 添加 query param
        QueryParameter queryParameter = new QueryParameter();
        queryParameter.add("sp_mchid", StringUtil.urlEncode(request.getSpMchid()));
        queryParameter.add("bill_date", StringUtil.urlEncode(request.getBillDate()));
        queryParameter.add("tar_type", request.getTarType());
        if (StringUtils.isNotEmpty(request.getSubMchid())) {
            queryParameter.add("sub_mchid", request.getSubMchid());
        }
        String requestPath = ApplyTradeBillURI + queryParameter.getQueryStr();
        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.GET, requestUrl, requestPath, null, null);
        DouyinpayResponse<ApiBillReponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiBillReponse.class);
        return apiResponse.getApiResponse();
    }

    /**
     * 申请服务商资金账单下载地址。
     *
     * <p>资金账单按天生成，反映商户账户的资金变动情况，包含业务单号、收支金额和记账时间等信息。
     * account_type 选填，可选值包括 BaseAccount（基本账户）、OperationAccount（运营账户）和 FeeAccount（手续费账户），默认值为 BaseAccount。</p>
     *
     * @param request 请求参数，包含商户号、子商户号、账单日期、账户类型和压缩类型
     * @return 账单下载响应，包含下载地址和文件摘要信息
     */
    public ApiBillReponse applyFundFlowBill(ApplyFundFlowBillRequest request) {
        String requestUrl = getRequestUrl();
        // 添加 query param
        QueryParameter queryParameter = new QueryParameter();
        queryParameter.add("sp_mchid", StringUtil.urlEncode(request.getSpMchid()));
        queryParameter.add("bill_date", StringUtil.urlEncode(request.getBillDate()));
        queryParameter.add("tar_type", request.getTarType());
        if (StringUtils.isNotEmpty(request.getAccountType())) {
            queryParameter.add("account_type", request.getAccountType());
        }
        if (StringUtils.isNotEmpty(request.getSubMchid())) {
            queryParameter.add("sub_mchid", request.getSubMchid());
        }
        String requestPath = ApplyFundFlowBillURI + queryParameter.getQueryStr();
        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.GET, requestUrl, requestPath, null, null);
        DouyinpayResponse<ApiBillReponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiBillReponse.class);
        return apiResponse.getApiResponse();
    }

    /**
     * 申请服务商分账账单下载地址。
     *
     * <p>分账账单按天生成，包含分账相关的金额、时间等信息，供商户核对到账等情况。
     * 抖音侧未成功的分账单不会出现在对账单中；如需下载某个子商户下的分账账单，可传入 sub_mchid。</p>
     *
     * @param request 请求参数，包含商户号、子商户号、账单日期和压缩类型
     * @return 账单下载响应，包含下载地址和文件摘要信息
     */
    public ApiBillReponse applySplitBill(ApplySplitBillRequest request) {
        String requestUrl = getRequestUrl();
        // 添加 query param
        QueryParameter queryParameter = new QueryParameter();
        queryParameter.add("sp_mchid", StringUtil.urlEncode(request.getSpMchid()));
        queryParameter.add("bill_date", StringUtil.urlEncode(request.getBillDate()));
        queryParameter.add("tar_type", request.getTarType());
        if (StringUtils.isNotEmpty(request.getSubMchid())) {
            queryParameter.add("sub_mchid", request.getSubMchid());
        }
        String requestPath = ApplySplitBillURI + queryParameter.getQueryStr();
        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.GET, requestUrl, requestPath, null, null);
        DouyinpayResponse<ApiBillReponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiBillReponse.class);
        return apiResponse.getApiResponse();
    }
}
