package com.douyinpay.api.indirectmerchant;

import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.DouyinpayMultipartRequest;
import com.douyinpay.api.DouyinpayRequest;
import com.douyinpay.api.indirectmerchant.models.ApplyResponse;
import com.douyinpay.api.indirectmerchant.models.BindAppRequest;
import com.douyinpay.api.indirectmerchant.models.BindAppResponse;
import com.douyinpay.api.indirectmerchant.models.CancelApplyRequest;
import com.douyinpay.api.indirectmerchant.models.CreateApplyRequest;
import com.douyinpay.api.indirectmerchant.models.IdentificationInfo;
import com.douyinpay.api.indirectmerchant.models.Locator;
import com.douyinpay.api.indirectmerchant.models.ModifyRequest;
import com.douyinpay.api.indirectmerchant.models.QueryAppRequest;
import com.douyinpay.api.indirectmerchant.models.QueryAppResponse;
import com.douyinpay.api.indirectmerchant.models.QueryApplyRequest;
import com.douyinpay.api.indirectmerchant.models.QueryApplyResponse;
import com.douyinpay.api.indirectmerchant.models.QueryMerchantResponse;
import com.douyinpay.api.indirectmerchant.models.UploadResponse;
import com.douyinpay.component.http.HttpMethod;
import com.douyinpay.component.http.QueryParameter;
import com.douyinpay.define.DomainName;
import com.douyinpay.exception.DouyinpayException;
import com.douyinpay.util.GsonUtil;
import com.douyinpay.util.StringUtil;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

/**
 * 间连商户服务。
 *
 * 覆盖入驻申请、申请单查询/撤销、商户信息查询/修改、应用 APPID 绑定/查询，以及商户资质图片上传。
 * 其中入驻申请的证件持有人姓名、证件号码为敏感字段，SDK 在发送前自动使用平台公钥加密、
 * 在查询商户返回后自动使用服务商私钥解密，调用方无需手动处理加解密。
 *
 * 官方文档：
 * - 入驻申请：POST /v1/merchant/indirect_merchant/create_apply
 *   https://partner.douyinpay.com/wiki/682c7a8e82b07604fd4deccb/682d90a7f6171b04e93c7b83
 * - 查询申请单：GET /v1/merchant/indirect_merchant/query_apply
 *   https://partner.douyinpay.com/wiki/682c7a8e82b07604fd4deccb/682d9177e78abd05159f2401
 * - 撤销申请单：POST /v1/merchant/indirect_merchant/cancel_apply
 *   https://partner.douyinpay.com/wiki/682c7a8e82b07604fd4deccb/682d919583179e04f6aaff0e
 * - 查询间连商户：GET /v1/merchant/indirect_merchant/query_merchant
 *   https://partner.douyinpay.com/wiki/682c7a8e82b07604fd4deccb/6a6ab6add3c3490537736353
 * - 修改商户资料：POST /v1/merchant/indirect_merchant/modify
 *   https://partner.douyinpay.com/wiki/682c7a8e82b07604fd4deccb/682d9151b3825304f979c5e6
 * - 绑定应用 APPID：POST /v1/merchant/indirect_merchant/bind_app_id
 *   https://partner.douyinpay.com/wiki/682c7a8e82b07604fd4deccb/693fc694da453b056b7353d0
 * - 查询应用 APPID：GET /v1/merchant/indirect_merchant/query_app_id
 *   https://partner.douyinpay.com/wiki/682c7a8e82b07604fd4deccb/6940170bda453b056b767637
 * - 图片上传：POST /v1/merchant/upload
 *   https://partner.douyinpay.com/wiki/682c7a8e82b07604fd4deccb/682d9110291141050f330872
 */
public class ApiIndirectMerchantService {

    private static final String BASE = "/v1/merchant/indirect_merchant/";
    private static final String UPLOAD_PATH = "/v1/merchant/upload";

    private final DouyinpayClient douyinpayClient;
    private final DomainName domainName;

    private ApiIndirectMerchantService(DouyinpayClient douyinpayClient, DomainName domainName) {
        this.douyinpayClient = douyinpayClient;
        this.domainName = domainName;
    }

    public static class Builder {
        private DouyinpayClient douyinpayClient;
        private DomainName domainName;

        /**
         * 设置自定义 httpclient。
         *
         * @param douyinpayClient 抖音支付客户端
         * @return Builder
         */
        public Builder douyinpayClient(DouyinpayClient douyinpayClient) {
            this.douyinpayClient = douyinpayClient;
            return this;
        }

        /**
         * 设置抖音支付域名，默认为 api.douyinpay.com。
         *
         * @param domainName 抖音支付域名
         * @return Builder
         */
        public Builder domainName(DomainName domainName) {
            this.domainName = domainName;
            return this;
        }

        public ApiIndirectMerchantService build() {
            return new ApiIndirectMerchantService(douyinpayClient, domainName);
        }
    }

    private String getRequestUrl() {
        return domainName == null ? DomainName.API.getValue() : domainName.getValue();
    }

    private <T> T post(String path, Object body, Class<T> type) {
        DouyinpayRequest request = new DouyinpayRequest(HttpMethod.POST, getRequestUrl(), path, null,
                GsonUtil.objectToJson(body));
        return douyinpayClient.execute(request, type).getApiResponse();
    }

    private <T> T get(String path, Class<T> type) {
        DouyinpayRequest request = new DouyinpayRequest(HttpMethod.GET, getRequestUrl(), path, null, null);
        return douyinpayClient.execute(request, type).getApiResponse();
    }

    /**
     * 提交间连商户入驻申请（create_apply）。
     *
     * <p>证件持有人姓名、证件号码为敏感字段，发送前自动使用平台公钥加密；加密作用于请求副本，
     * 不修改调用方传入的对象。
     *
     * @param request 入驻申请请求
     * @return 入驻申请响应，包含抖音支付分配的申请单号
     */
    public ApplyResponse createApply(CreateApplyRequest request) {
        request.validate();
        CreateApplyRequest toSend = request;
        if (request.identificationInfo != null) {
            toSend = copyWithEncryptedIdentification(request);
        }
        return post(BASE + "create_apply", toSend, ApplyResponse.class);
    }

    /**
     * 查询入驻申请单（query_apply），申请单号或业务申请编号二选一。
     *
     * @param request 查询申请单请求
     * @return 查询申请单响应
     */
    public QueryApplyResponse queryApply(QueryApplyRequest request) {
        QueryParameter queryParameter = new QueryParameter();
        if (isNotEmpty(request.applymentId)) {
            queryParameter.add("applyment_id", StringUtil.urlEncode(request.applymentId));
        }
        if (isNotEmpty(request.businessCode)) {
            queryParameter.add("business_code", StringUtil.urlEncode(request.businessCode));
        }
        return get(BASE + "query_apply" + queryParameter.getQueryStr(), QueryApplyResponse.class);
    }

    /**
     * 撤销入驻申请单（cancel_apply），仅在待提交和审核中可撤销。
     *
     * @param request 撤销申请单请求
     */
    public void cancelApply(CancelApplyRequest request) {
        post(BASE + "cancel_apply", request, Void.class);
    }

    /**
     * 查询间连商户信息（query_merchant）。
     *
     * <p>响应中的证件持有人姓名、证件号码为抖音支付加密下发字段，使用服务商私钥解密后原位回填。
     *
     * @param request 商户定位信息，外部定位或抖音支付间连商户号二选一
     * @return 查询间连商户响应
     */
    public QueryMerchantResponse queryMerchant(Locator request) {
        request.validate();
        QueryParameter queryParameter = new QueryParameter();
        if (isNotEmpty(request.outIndirectMerchantId)) {
            queryParameter.add("out_indirect_merchant_id", StringUtil.urlEncode(request.outIndirectMerchantId));
        }
        if (isNotEmpty(request.outPaymentInstId)) {
            queryParameter.add("out_payment_inst_id", StringUtil.urlEncode(request.outPaymentInstId));
        }
        if (isNotEmpty(request.outChannelSpId)) {
            queryParameter.add("out_channel_sp_id", StringUtil.urlEncode(request.outChannelSpId));
        }
        if (isNotEmpty(request.indirectMerchantId)) {
            queryParameter.add("indirect_merchant_id", StringUtil.urlEncode(request.indirectMerchantId));
        }
        QueryMerchantResponse response = get(BASE + "query_merchant" + queryParameter.getQueryStr(),
                QueryMerchantResponse.class);
        if (response != null && response.identificationInfo != null) {
            decryptIdentification(response.identificationInfo);
        }
        return response;
    }

    /**
     * 修改商户资料（modify），目前仅支持修改商户简称和客服电话。
     *
     * @param request 修改商户资料请求
     */
    public void modifyMerchant(ModifyRequest request) {
        request.validate();
        post(BASE + "modify", request, Void.class);
    }

    /**
     * 为间连子商户绑定应用 APPID（bind_app_id），仅支持新增配置。
     *
     * @param request 绑定应用 APPID 请求
     * @return 绑定应用 APPID 响应
     */
    public BindAppResponse bindAppId(BindAppRequest request) {
        request.validate();
        return post(BASE + "bind_app_id", request, BindAppResponse.class);
    }

    /**
     * 查询间连子商户配置的应用 APPID 信息（query_app_id），可按 appId 过滤。
     *
     * @param request 查询应用 APPID 请求
     * @return 查询应用 APPID 响应
     */
    public QueryAppResponse queryAppId(QueryAppRequest request) {
        request.validate();
        QueryParameter queryParameter = new QueryParameter();
        if (isNotEmpty(request.outIndirectMerchantId)) {
            queryParameter.add("out_indirect_merchant_id", StringUtil.urlEncode(request.outIndirectMerchantId));
        }
        if (isNotEmpty(request.outPaymentInstId)) {
            queryParameter.add("out_payment_inst_id", StringUtil.urlEncode(request.outPaymentInstId));
        }
        if (isNotEmpty(request.outChannelSpId)) {
            queryParameter.add("out_channel_sp_id", StringUtil.urlEncode(request.outChannelSpId));
        }
        if (isNotEmpty(request.indirectMerchantId)) {
            queryParameter.add("indirect_merchant_id", StringUtil.urlEncode(request.indirectMerchantId));
        }
        if (isNotEmpty(request.appId)) {
            queryParameter.add("app_id", StringUtil.urlEncode(request.appId));
        }
        return get(BASE + "query_app_id" + queryParameter.getQueryStr(), QueryAppResponse.class);
    }

    /**
     * 上传商户资质图片（/v1/merchant/upload），返回图片 MediaID。
     *
     * <p>请求为 multipart/form-data，参与签名计算的仅为 meta 的 JSON 串。
     *
     * @param filename 媒体图片名称，须以 JPG、BMP、PNG 为后缀
     * @param mime     图片 MIME 类型，例如 image/jpeg
     * @param file     图片文件二进制内容
     * @return 图片上传响应，包含媒体文件标识 ID
     */
    public UploadResponse upload(String filename, String mime, byte[] file) {
        if (file == null || file.length == 0) {
            throw new IllegalArgumentException("file is empty");
        }
        Map<String, String> meta = new HashMap<>();
        meta.put("filename", filename);
        meta.put("sha256", sha256Hex(file));
        String metaJson = GsonUtil.objectToJson(meta);
        DouyinpayMultipartRequest request = new DouyinpayMultipartRequest(getRequestUrl(), UPLOAD_PATH, null,
                metaJson, filename, mime, file);
        return douyinpayClient.executeMultipart(request, UploadResponse.class).getApiResponse();
    }

    /**
     * 复制入驻申请请求并对其证件持有人敏感字段（姓名、证件号码）做副本加密，
     * 保持调用方传入的 request 及其 identificationInfo 不变。
     */
    private CreateApplyRequest copyWithEncryptedIdentification(CreateApplyRequest request) {
        CreateApplyRequest copy = new CreateApplyRequest();
        copy.outIndirectMerchantId = request.outIndirectMerchantId;
        copy.outPaymentInstId = request.outPaymentInstId;
        copy.outChannelSpId = request.outChannelSpId;
        copy.outPaymentInstSubId = request.outPaymentInstSubId;
        copy.businessCode = request.businessCode;
        copy.subjectInfo = request.subjectInfo;
        copy.businessInfo = request.businessInfo;
        copy.additionInfo = request.additionInfo;
        copy.indirectMerchantId = request.indirectMerchantId;
        copy.identificationInfo = encryptIdentificationCopy(request.identificationInfo);
        return copy;
    }

    /**
     * 对证件信息做副本加密，返回加密后的新对象，不修改入参。
     * 字段为空时跳过，密钥未配置或加密失败时抛出带上下文的异常。
     */
    private IdentificationInfo encryptIdentificationCopy(IdentificationInfo info) {
        IdentificationInfo copy = new IdentificationInfo();
        copy.identificationType = info.identificationType;
        copy.periodBegin = info.periodBegin;
        copy.periodEnd = info.periodEnd;
        copy.identificationFrontCopy = info.identificationFrontCopy;
        copy.identificationBackCopy = info.identificationBackCopy;
        copy.identificationName = info.identificationName;
        copy.identificationNumber = info.identificationNumber;
        if (isNotEmpty(info.identificationName)) {
            try {
                copy.identificationName = douyinpayClient.encryptSensitive(info.identificationName);
            } catch (DouyinpayException e) {
                throw new DouyinpayException("encrypt identification_name failed", e);
            }
        }
        if (isNotEmpty(info.identificationNumber)) {
            try {
                copy.identificationNumber = douyinpayClient.encryptSensitive(info.identificationNumber);
            } catch (DouyinpayException e) {
                throw new DouyinpayException("encrypt identification_number failed", e);
            }
        }
        return copy;
    }

    /**
     * 原位解密下行证件持有人敏感字段（姓名、证件号码）。
     * 字段为空时跳过，密钥未配置或密文非法时抛出带上下文的异常。
     */
    private void decryptIdentification(IdentificationInfo info) {
        if (isNotEmpty(info.identificationName)) {
            try {
                info.identificationName = douyinpayClient.decryptSensitive(info.identificationName);
            } catch (DouyinpayException e) {
                throw new DouyinpayException("decrypt identification_name failed", e);
            }
        }
        if (isNotEmpty(info.identificationNumber)) {
            try {
                info.identificationNumber = douyinpayClient.decryptSensitive(info.identificationNumber);
            } catch (DouyinpayException e) {
                throw new DouyinpayException("decrypt identification_number failed", e);
            }
        }
    }

    private static String sha256Hex(byte[] file) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] sum = digest.digest(file);
            StringBuilder sb = new StringBuilder(sum.length * 2);
            for (byte b : sum) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new IllegalArgumentException("cannot build upload meta", e);
        }
    }

    private static boolean isNotEmpty(String s) {
        return s != null && !s.isEmpty();
    }
}
