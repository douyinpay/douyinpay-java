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
 * 直连商户账单服务。
 *
 * <p>支持申请交易账单、资金账单和分账账单下载地址。申请成功后会返回 download_url、hash_type
 * 和 hash_value，其中 download_url 有效期为 5 分钟，建议下载完成后比对 hash_value 校验账单完整性。</p>
 */
public class ApiBillService {

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
        public ApiBillService.Builder domainName(DomainName domainName) {
            this.domainName = domainName;
            return this;
        }

        /**
         * 设置自定义 DouyinpayClient。
         *
         * @param douyinpayClient 抖音支付客户端
         * @return Builder
         */
        public ApiBillService.Builder douyinpayClient(DouyinpayClient douyinpayClient) {
            this.douyinpayClient = douyinpayClient;
            return this;
        }

        /**
         * 构造账单服务。
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
     * 申请交易账单下载地址。
     *
     * <p>交易账单按天生成，包含交易相关的金额、时间、营销等信息，供商户核对订单交易完成、退款、撤销等情况。
     * 抖音侧未成功下单的交易不会出现在对账单中，支付成功后撤销的交易会出现在对账单中且沿用原支付单订单号。
     * 账单涉及金额字段的单位为元，账单文件通常建议在 T+1 日 10 点后获取。</p>
     *
     * @param request 请求参数，包含商户号、账单日期、账单类型和压缩类型
     * @return 账单下载响应，包含下载地址和文件摘要信息
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
     * 申请资金账单下载地址。
     *
     * <p>资金账单按天生成，用于反映抖音支付账户的资金变动情况，包含业务单号、收支金额和记账时间等信息。
     * 账单涉及金额字段的单位为元；account_type 可选值包括 BaseAccount（基本账户）和
     * OperationAccount（运营账户），OpenAPI 文档中默认值为 BaseAccount。</p>
     *
     * @param request 请求参数，包含商户号、账单日期、账户类型和压缩类型
     * @return 账单下载响应，包含下载地址和文件摘要信息
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
     * 申请分账账单下载地址。
     *
     * <p>分账账单按天生成，包含分账相关的金额、时间和状态等信息，供商户核对到账和分账结果。
     * 账单涉及金额字段的单位为元，tar_type 常用值为 GZIP。</p>
     *
     * @param request 请求参数，包含商户号、账单日期和压缩类型
     * @return 账单下载响应，包含下载地址和文件摘要信息
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
