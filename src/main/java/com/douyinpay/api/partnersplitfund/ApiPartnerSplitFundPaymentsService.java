package com.douyinpay.api.partnersplitfund;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.douyinpay.api.DefaultDouyinpayClient;
import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.DouyinpayRequest;
import com.douyinpay.api.DouyinpayResponse;
import com.douyinpay.api.notification.NotificationParser;
import com.douyinpay.api.notification.RequestParam;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerAddSplitReceiverRequest;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerAddSplitReceiverResponse;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerDeleteSplitReceiverRequest;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerDeleteSplitReceiverResponse;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerFinishSplitFundRequest;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerFinishSplitFundResponse;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerQueryMerchantConfigRequest;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerQueryMerchantConfigResponse;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerQueryReturnSplitFundRequest;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerQueryReturnSplitFundResponse;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerQuerySplitFundRequest;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerQuerySplitFundResponse;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerQueryUnSplitFundRequest;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerQueryUnSplitFundResponse;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerReturnSplitFundRequest;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerReturnSplitFundResponse;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerSplitFundNotification;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerSplitFundRequest;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerSplitFundResponse;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerSplitReceiverNotification;
import com.douyinpay.api.partnersplitfund.models.PartnerReceiverInfoDto;
import com.douyinpay.component.crypto.CryptorFactory;
import com.douyinpay.component.crypto.ICryptor;
import com.douyinpay.component.http.HttpMethod;
import com.douyinpay.component.http.QueryParameter;
import com.douyinpay.define.Constants;
import com.douyinpay.define.DomainName;
import com.douyinpay.exception.DouyinpayException;
import com.douyinpay.util.GsonUtil;
import com.douyinpay.util.PemUtil;
import com.douyinpay.util.StringUtil;

public class ApiPartnerSplitFundPaymentsService {
    private static final String SPLIT_FUND_URI = "/v1/trade/profitsharing/orders";
    private static final String QUERY_SPLIT_FUND_URI = "/v1/trade/profitsharing/orders/{out_order_no}";
    private static final String RETURN_SPLIT_FUND_URI = "/v1/trade/profitsharing/return-orders";
    private static final String QUERY_RETURN_SPLIT_FUND_URI = "/v1/trade/profitsharing/return-orders/{out_return_no}";
    private static final String FINISH_SPLIT_FUND_URI = "/v1/trade/profitsharing/finish-orders";
    private static final String QUERY_UNSPLIT_FUND_URI = "/v1/trade/profitsharing/order/{transaction_id}/amounts";
    private static final String QUERY_MERCHANT_CONFIG_URI = "/v1/trade/profitsharing/merchant-configs/{sub_mchid}";
    private static final String ADD_SPLIT_RECEIVER_URI = "/v1/trade/profitsharing/receivers/add";
    private static final String DELETE_SPLIT_RECEIVER_URI = "/v1/trade/profitsharing/receivers/delete";
    private static final String OUT_ORDER_NO_PATTERN = "{out_order_no}";
    private static final String OUT_RETURN_NO_PATTERN = "{out_return_no}";
    private static final String TRANSACTION_ID_PATTERN = "{transaction_id}";
    private static final String SUB_MCHID_PATTERN = "{sub_mchid}";

    private final DouyinpayClient douyinpayClient;
    private final DomainName domainName;
    private ICryptor cryptor;

    private ApiPartnerSplitFundPaymentsService(DouyinpayClient douyinpayClient, DomainName domainName) {
        this.douyinpayClient = douyinpayClient;
        this.domainName = domainName;
    }

    /**
     * 服务商分账服务。
     */
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

        public ApiPartnerSplitFundPaymentsService build() {
            return new ApiPartnerSplitFundPaymentsService(douyinpayClient, domainName);
        }
    }

    public String getRequestUrl() {
        String requestDomainName = DomainName.API.getValue();
        if (this.domainName != null) {
            requestDomainName = this.domainName.getValue();
        }
        return requestDomainName;
    }

    /**
     * 服务商请求分账。
     *
     * @param request 请求参数
     * @return ApiPartnerSplitFundResponse
     */
    public ApiPartnerSplitFundResponse splitFund(ApiPartnerSplitFundRequest request) {
        String requestUrl = getRequestUrl();
        encryptSplitFundReceiverNames(request);
        String body = GsonUtil.objectToJson(request);
        Map<String, String> headers = buildPlatformCertificateSerialHeaders();
        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, SPLIT_FUND_URI, headers,
                body);
        DouyinpayResponse<ApiPartnerSplitFundResponse> apiResponse = douyinpayClient.execute(douyinpayRequest,
                ApiPartnerSplitFundResponse.class);
        return apiResponse.getApiResponse();
    }

    /**
     * 服务商查询分账结果。
     *
     * @param request 请求参数
     * @return ApiPartnerQuerySplitFundResponse
     */
    public ApiPartnerQuerySplitFundResponse querySplitFund(ApiPartnerQuerySplitFundRequest request) {
        String requestUrl = getRequestUrl();
        String requestPath = QUERY_SPLIT_FUND_URI.replace(OUT_ORDER_NO_PATTERN,
                StringUtil.urlEncode(request.getOutOrderNo()));
        QueryParameter queryParameter = new QueryParameter();
        if (request.getSpMchid() != null) {
            queryParameter.add("sp_mchid", StringUtil.urlEncode(request.getSpMchid()));
        }
        if (request.getSubMchid() != null) {
            queryParameter.add("sub_mchid", StringUtil.urlEncode(request.getSubMchid()));
        }
        if (request.getTradeNo() != null) {
            queryParameter.add("transaction_id", StringUtil.urlEncode(request.getTradeNo()));
        }
        if (request.getOrderId() != null) {
            queryParameter.add("order_id", StringUtil.urlEncode(request.getOrderId()));
        }
        requestPath += queryParameter.getQueryStr();

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.GET, requestUrl, requestPath, null, null);
        DouyinpayResponse<ApiPartnerQuerySplitFundResponse> apiResponse = douyinpayClient.execute(douyinpayRequest,
                ApiPartnerQuerySplitFundResponse.class);
        return apiResponse.getApiResponse();
    }

    /**
     * 服务商请求分账回退。
     *
     * @param request 请求参数
     * @return ApiPartnerReturnSplitFundResponse
     */
    public ApiPartnerReturnSplitFundResponse returnSplitFund(ApiPartnerReturnSplitFundRequest request) {
        String requestUrl = getRequestUrl();
        String body = GsonUtil.objectToJson(request);
        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, RETURN_SPLIT_FUND_URI,
                null, body);
        DouyinpayResponse<ApiPartnerReturnSplitFundResponse> apiResponse = douyinpayClient.execute(douyinpayRequest,
                ApiPartnerReturnSplitFundResponse.class);
        return apiResponse.getApiResponse();
    }

    /**
     * 服务商查询分账回退结果。
     *
     * @param request 请求参数
     * @return ApiPartnerQueryReturnSplitFundResponse
     */
    public ApiPartnerQueryReturnSplitFundResponse queryReturnSplitFund(ApiPartnerQueryReturnSplitFundRequest request) {
        String requestUrl = getRequestUrl();
        String requestPath = QUERY_RETURN_SPLIT_FUND_URI.replace(OUT_RETURN_NO_PATTERN,
                StringUtil.urlEncode(request.getOutReturnNo()));
        QueryParameter queryParameter = new QueryParameter();
        if (request.getSpMchid() != null) {
            queryParameter.add("sp_mchid", StringUtil.urlEncode(request.getSpMchid()));
        }
        if (request.getSubMchid() != null) {
            queryParameter.add("sub_mchid", StringUtil.urlEncode(request.getSubMchid()));
        }
        if (request.getOutOrderNo() != null) {
            queryParameter.add("out_order_no", StringUtil.urlEncode(request.getOutOrderNo()));
        }
        requestPath += queryParameter.getQueryStr();

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.GET, requestUrl, requestPath, null, null);
        DouyinpayResponse<ApiPartnerQueryReturnSplitFundResponse> apiResponse = douyinpayClient
                .execute(douyinpayRequest, ApiPartnerQueryReturnSplitFundResponse.class);
        return apiResponse.getApiResponse();
    }

    /**
     * 服务商完结分账。
     *
     * @param request 请求参数
     * @return ApiPartnerFinishSplitFundResponse
     */
    public ApiPartnerFinishSplitFundResponse finishSplitFund(ApiPartnerFinishSplitFundRequest request) {
        String requestUrl = getRequestUrl();
        String body = GsonUtil.objectToJson(request);
        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, FINISH_SPLIT_FUND_URI,
                null, body);
        DouyinpayResponse<ApiPartnerFinishSplitFundResponse> apiResponse = douyinpayClient.execute(douyinpayRequest,
                ApiPartnerFinishSplitFundResponse.class);
        return apiResponse.getApiResponse();
    }

    /**
     * 服务商查询剩余待分金额。
     *
     * @param request 请求参数
     * @return ApiPartnerQueryUnSplitFundResponse
     */
    public ApiPartnerQueryUnSplitFundResponse queryUnSplitFund(ApiPartnerQueryUnSplitFundRequest request) {
        String requestUrl = getRequestUrl();
        String requestPath = QUERY_UNSPLIT_FUND_URI.replace(TRANSACTION_ID_PATTERN,
                StringUtil.urlEncode(request.getTransactionId()));
        QueryParameter queryParameter = new QueryParameter();
        if (request.getSpMchid() != null) {
            queryParameter.add("sp_mchid", StringUtil.urlEncode(request.getSpMchid()));
        }
        requestPath += queryParameter.getQueryStr();

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.GET, requestUrl, requestPath, null, null);
        DouyinpayResponse<ApiPartnerQueryUnSplitFundResponse> apiResponse = douyinpayClient.execute(douyinpayRequest,
                ApiPartnerQueryUnSplitFundResponse.class);
        return apiResponse.getApiResponse();
    }

    /**
     * 服务商查询特约商户分账配置。
     *
     * @param request 请求参数
     * @return ApiPartnerQueryMerchantConfigResponse
     */
    public ApiPartnerQueryMerchantConfigResponse queryMerchantConfig(ApiPartnerQueryMerchantConfigRequest request) {
        String requestUrl = getRequestUrl();
        String requestPath = QUERY_MERCHANT_CONFIG_URI.replace(SUB_MCHID_PATTERN,
                StringUtil.urlEncode(request.getSubMchid()));
        QueryParameter queryParameter = new QueryParameter();
        if (request.getSpMchid() != null) {
            queryParameter.add("sp_mchid", StringUtil.urlEncode(request.getSpMchid()));
        }
        requestPath += queryParameter.getQueryStr();

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.GET, requestUrl, requestPath, null, null);
        DouyinpayResponse<ApiPartnerQueryMerchantConfigResponse> apiResponse = douyinpayClient.execute(douyinpayRequest,
                ApiPartnerQueryMerchantConfigResponse.class);
        return apiResponse.getApiResponse();
    }

    /**
     * 服务商添加分账接收方。
     *
     * @param request 请求参数
     * @return ApiPartnerAddSplitReceiverResponse
     */
    public ApiPartnerAddSplitReceiverResponse addSplitReceiver(ApiPartnerAddSplitReceiverRequest request) {
        String requestUrl = getRequestUrl();
        request.setName(encryptSensitiveName(request.getName()));
        String body = GsonUtil.objectToJson(request);
        Map<String, String> headers = buildPlatformCertificateSerialHeaders();
        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, ADD_SPLIT_RECEIVER_URI,
                headers, body);
        DouyinpayResponse<ApiPartnerAddSplitReceiverResponse> apiResponse = douyinpayClient.execute(douyinpayRequest,
                ApiPartnerAddSplitReceiverResponse.class);
        ApiPartnerAddSplitReceiverResponse response = apiResponse.getApiResponse();
        if (response != null) {
            response.setName(decryptSensitiveName(response.getName()));
        }
        return response;
    }

    /**
     * 服务商删除分账接收方。
     *
     * @param request 请求参数
     * @return ApiPartnerDeleteSplitReceiverResponse
     */
    public ApiPartnerDeleteSplitReceiverResponse deleteSplitReceiver(ApiPartnerDeleteSplitReceiverRequest request) {
        String requestUrl = getRequestUrl();
        String body = GsonUtil.objectToJson(request);
        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.POST, requestUrl, DELETE_SPLIT_RECEIVER_URI,
                null, body);
        DouyinpayResponse<ApiPartnerDeleteSplitReceiverResponse> apiResponse = douyinpayClient.execute(douyinpayRequest,
                ApiPartnerDeleteSplitReceiverResponse.class);
        return apiResponse.getApiResponse();
    }

    /**
     * 解析服务商分账结果通知。
     *
     * @param requestParam       通知请求参数
     * @param notificationParser 通知解析器
     * @return ApiPartnerSplitFundNotification
     */
    public ApiPartnerSplitFundNotification parseNotification(RequestParam requestParam,
            NotificationParser notificationParser) {
        return notificationParser.parse(requestParam, ApiPartnerSplitFundNotification.class);
    }

    /**
     * 解析服务商分账接收方入账通知。
     *
     * @param requestParam       通知请求参数
     * @param notificationParser 通知解析器
     * @return ApiPartnerSplitReceiverNotification
     */
    public ApiPartnerSplitReceiverNotification parseReceiverNotification(RequestParam requestParam,
            NotificationParser notificationParser) {
        return notificationParser.parse(requestParam, ApiPartnerSplitReceiverNotification.class);
    }

    private void encryptSplitFundReceiverNames(ApiPartnerSplitFundRequest request) {
        List<PartnerReceiverInfoDto> receivers = request.getReceivers();
        if (receivers == null || receivers.isEmpty()) {
            return;
        }
        for (PartnerReceiverInfoDto receiver : receivers) {
            if (receiver == null) {
                continue;
            }
            receiver.setName(encryptSensitiveName(receiver.getName()));
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
        return getCryptor().encrypt(name, platformCertificate);
    }

    private String decryptSensitiveName(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        PrivateKey merchantPrivateKey = getMerchantPrivateKey();
        if (merchantPrivateKey == null) {
            throw new DouyinpayException("缺少商户私钥信息，无法解密敏感字段");
        }
        return getCryptor().decrypt(name, merchantPrivateKey);
    }

    private ICryptor getCryptor() {
        if (cryptor == null) {
            cryptor = CryptorFactory.getByName(getSignType());
        }
        return cryptor;
    }

    private X509Certificate getPlatformCertificate() {
        if (douyinpayClient instanceof DefaultDouyinpayClient) {
            return ((DefaultDouyinpayClient) douyinpayClient).getPlatformCertificate();
        }
        throw new DouyinpayException("当前DouyinpayClient不支持自动加密敏感字段");
    }

    private String getSignType() {
        if (douyinpayClient instanceof DefaultDouyinpayClient) {
            return ((DefaultDouyinpayClient) douyinpayClient).getSignType();
        }
        throw new DouyinpayException("当前DouyinpayClient不支持自动识别敏感字段加密算法");
    }

    private PrivateKey getMerchantPrivateKey() {
        if (douyinpayClient instanceof DefaultDouyinpayClient) {
            return ((DefaultDouyinpayClient) douyinpayClient).getMerchantPrivateKey();
        }
        throw new DouyinpayException("当前DouyinpayClient不支持自动解密敏感字段");
    }

    private Map<String, String> buildPlatformCertificateSerialHeaders() {
        X509Certificate platformCertificate = getPlatformCertificate();
        Map<String, String> headers = new HashMap<String, String>();
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
}
