package com.douyinpay.api.splitfund;

import com.douyinpay.api.DefaultDouyinpayClient;
import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.DouyinpayRequest;
import com.douyinpay.api.DouyinpayResponse;
import com.douyinpay.api.splitfund.models.ApiAddSplitReceiverRequest;
import com.douyinpay.api.splitfund.models.ApiAddSplitReceiverResponse;
import com.douyinpay.api.splitfund.models.ApiDeleteSplitReceiverRequest;
import com.douyinpay.api.splitfund.models.ApiDeleteSplitReceiverResponse;
import com.douyinpay.api.splitfund.models.ApiFinishSplitFundRequest;
import com.douyinpay.api.splitfund.models.ApiFinishSplitFundResponse;
import com.douyinpay.api.splitfund.models.ApiQueryReturnSplitFundRequest;
import com.douyinpay.api.splitfund.models.ApiQueryReturnSplitFundResponse;
import com.douyinpay.api.splitfund.models.ApiQuerySplitFundRequest;
import com.douyinpay.api.splitfund.models.ApiQuerySplitFundResponse;
import com.douyinpay.api.splitfund.models.ApiQueryUnSplitFundRequest;
import com.douyinpay.api.splitfund.models.ApiQueryUnSplitFundResponse;
import com.douyinpay.api.splitfund.models.ApiReturnSplitFundRequest;
import com.douyinpay.api.splitfund.models.ApiReturnSplitFundResponse;
import com.douyinpay.api.splitfund.models.ApiSplitFundRequest;
import com.douyinpay.api.splitfund.models.ApiSplitFundResponse;
import com.douyinpay.api.splitfund.models.ReceiverInfoDto;
import com.douyinpay.component.crypto.RsaEncryptor;
import com.douyinpay.component.http.HttpMethod;
import com.douyinpay.component.http.QueryParameter;
import com.douyinpay.define.Constants;
import com.douyinpay.define.DomainName;
import com.douyinpay.exception.DouyinpayException;
import com.douyinpay.util.GsonUtil;
import com.douyinpay.util.PemUtil;
import com.douyinpay.util.StringUtil;

import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiSplitFundPaymentsService {
    /**
     * 分账请求接口URI
     */
    private static final String SPLIT_FUND_URI = "/v1/trade/profitsharing/orders";

    /**
     * 分账查询接口URI
     */
    private static final String QUERY_SPLIT_FUND_URI = "/v1/trade/profitsharing/orders/{out_trade_no}";

    /**
     * 分账回退接口URI
     */
    private static final String RETURN_SPLIT_FUND_URI = "/v1/trade/profitsharing/return-orders";

    /**
     * 分账回退查询接口URI
     */
    private static final String QUERY_RETURN_SPLIT_FUND_URI = "/v1/trade/profitsharing/return-orders/{out_return_no}";

    /**
     * 完结分账接口URI
     */
    private static final String FINISH_SPLIT_FUND_URI = "/v1/trade/profitsharing/finish-orders";

    /**
     * 查询剩余待分金额接口URI
     */
    private static final String QUERY_UNSPLIT_FUND_URI = "/v1/trade/profitsharing/order/{transaction_id}/amounts";

    /**
     * 添加分账接收方接口URI
     */
    private static final String ADD_SPLIT_RECEIVER_URI = "/v1/trade/profitsharing/receivers/add";

    /**
     * 删除分账接收方接口URI
     */
    private static final String DELETE_SPLIT_RECEIVER_URI = "/v1/trade/profitsharing/receivers/delete";

    private static final String OUT_TRADE_NO_PATTERN = "{out_trade_no}";

    private static final String OUT_RETURN_NO_PATTERN = "{out_return_no}";

    private static final String TRANSACTION_ID_PATTERN = "{transaction_id}";

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
        encryptSplitFundReceiverNames(request);
        String body = GsonUtil.objectToJson(request);
        Map<String, String> headers = buildPlatformCertificateSerialHeaders();
        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, SPLIT_FUND_URI, headers, body);
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

    /**
     * 分账回退
     *
     * @param request 请求参数
     * @return ApiReturnSplitFundResponse
     */
    public ApiReturnSplitFundResponse returnSplitFund(ApiReturnSplitFundRequest request) {
        String requestUrl = getRequestUrl();
        String body = GsonUtil.objectToJson(request);

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, RETURN_SPLIT_FUND_URI, null, body);
        DouyinpayResponse<ApiReturnSplitFundResponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiReturnSplitFundResponse.class);

        return apiResponse.getApiResponse();
    }

    /**
     * 查询分账回退结果
     *
     * @param request 请求参数
     * @return ApiQueryReturnSplitFundResponse
     */
    public ApiQueryReturnSplitFundResponse queryReturnSplitFund(ApiQueryReturnSplitFundRequest request) {
        String requestUrl = getRequestUrl();
        String requestPath = QUERY_RETURN_SPLIT_FUND_URI.replace(OUT_RETURN_NO_PATTERN, StringUtil.urlEncode(request.getOutReturnNo()));
        QueryParameter queryParameter = new QueryParameter();
        if (request.getMerchantId() != null) {
            queryParameter.add("mchid", StringUtil.urlEncode(request.getMerchantId()));
        }
        if (request.getOutOrderNo() != null) {
            queryParameter.add("out_order_no", StringUtil.urlEncode(request.getOutOrderNo()));
        }
        requestPath += queryParameter.getQueryStr();

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.GET, requestUrl, requestPath, null, null);
        DouyinpayResponse<ApiQueryReturnSplitFundResponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiQueryReturnSplitFundResponse.class);

        return apiResponse.getApiResponse();
    }

    /**
     * 完结分账
     *
     * @param request 请求参数
     * @return ApiFinishSplitFundResponse
     */
    public ApiFinishSplitFundResponse finishSplitFund(ApiFinishSplitFundRequest request) {
        String requestUrl = getRequestUrl();
        String body = GsonUtil.objectToJson(request);

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, FINISH_SPLIT_FUND_URI, null, body);
        DouyinpayResponse<ApiFinishSplitFundResponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiFinishSplitFundResponse.class);

        return apiResponse.getApiResponse();
    }

    /**
     * 查询剩余待分金额
     *
     * @param request 请求参数
     * @return ApiQueryUnSplitFundResponse
     */
    public ApiQueryUnSplitFundResponse queryUnSplitFund(ApiQueryUnSplitFundRequest request) {
        String requestUrl = getRequestUrl();
        String requestPath = QUERY_UNSPLIT_FUND_URI.replace(TRANSACTION_ID_PATTERN, StringUtil.urlEncode(request.getTransactionId()));
        QueryParameter queryParameter = new QueryParameter();
        if (request.getMerchantId() != null) {
            queryParameter.add("mchid", StringUtil.urlEncode(request.getMerchantId()));
        }
        requestPath += queryParameter.getQueryStr();

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.GET, requestUrl, requestPath, null, null);
        DouyinpayResponse<ApiQueryUnSplitFundResponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiQueryUnSplitFundResponse.class);

        return apiResponse.getApiResponse();
    }

    /**
     * 添加分账接收方
     *
     * @param request 请求参数
     * @return ApiAddSplitReceiverResponse
     */
    public ApiAddSplitReceiverResponse addSplitReceiver(ApiAddSplitReceiverRequest request) {
        String requestUrl = getRequestUrl();
        request.setName(encryptSensitiveName(request.getName()));
        String body = GsonUtil.objectToJson(request);
        Map<String, String> headers = buildPlatformCertificateSerialHeaders();
        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, ADD_SPLIT_RECEIVER_URI, headers, body);
        DouyinpayResponse<ApiAddSplitReceiverResponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiAddSplitReceiverResponse.class);

        return apiResponse.getApiResponse();
    }

    private void encryptSplitFundReceiverNames(ApiSplitFundRequest request) {
        List<ReceiverInfoDto> receiverInfoDtos = request.getReceiverInfoDtos();
        if (receiverInfoDtos == null || receiverInfoDtos.isEmpty()) {
            return;
        }
        for (ReceiverInfoDto receiverInfoDto : receiverInfoDtos) {
            if (receiverInfoDto == null) {
                continue;
            }
            receiverInfoDto.setName(encryptSensitiveName(receiverInfoDto.getName()));
        }
    }

    private String encryptSensitiveName(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        X509Certificate platformCertificate = getPlatformCertificate();
        if (platformCertificate == null) {
            throw new DouyinpayException("缺少平台证书信息，无法加密敏感字段");
        }
        if (isAlreadyEncrypted(name, platformCertificate)) {
            return name;
        }
        return getRsaEncryptor().encrypt(name, platformCertificate);
    }

    private X509Certificate getPlatformCertificate() {
        if (douyinpayClient instanceof DefaultDouyinpayClient) {
            return ((DefaultDouyinpayClient) douyinpayClient).getPlatformCertificate();
        }
        throw new DouyinpayException("当前DouyinpayClient不支持自动加密敏感字段");
    }

    private RsaEncryptor getRsaEncryptor() {
        if (douyinpayClient instanceof DefaultDouyinpayClient) {
            return ((DefaultDouyinpayClient) douyinpayClient).getRsaEncryptor();
        }
        throw new DouyinpayException("当前DouyinpayClient不支持自动加密敏感字段");
    }

    private Map<String, String> buildPlatformCertificateSerialHeaders() {
        X509Certificate platformCertificate = getPlatformCertificate();
        Map<String, String> headers = new HashMap<>();
        headers.put(Constants.DOUYIN_PAY_SERIAL, PemUtil.getSerialNumber(platformCertificate));
        return headers;
    }

    private boolean isAlreadyEncrypted(String value, X509Certificate certificate) {
        try {
            if (!(certificate.getPublicKey() instanceof RSAPublicKey)) {
                return false;
            }
            byte[] decoded = Base64.getDecoder().decode(value);
            RSAPublicKey publicKey = (RSAPublicKey) certificate.getPublicKey();
            int keySize = (publicKey.getModulus().bitLength() + 7) / 8;
            return decoded.length == keySize;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * 删除分账接收方
     *
     * @param request 请求参数
     * @return ApiDeleteSplitReceiverResponse
     */
    public ApiDeleteSplitReceiverResponse deleteSplitReceiver(ApiDeleteSplitReceiverRequest request) {
        String requestUrl = getRequestUrl();
        String body = GsonUtil.objectToJson(request);

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, DELETE_SPLIT_RECEIVER_URI, null, body);
        DouyinpayResponse<ApiDeleteSplitReceiverResponse> apiResponse = douyinpayClient.execute(douyinpayRequest, ApiDeleteSplitReceiverResponse.class);

        return apiResponse.getApiResponse();
    }
}
