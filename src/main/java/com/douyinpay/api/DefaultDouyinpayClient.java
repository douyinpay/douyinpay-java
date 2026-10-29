package com.douyinpay.api;

import com.douyinpay.component.certificate.AutoCertificateProvider;
import com.douyinpay.component.certificate.CertificateProvider;
import com.douyinpay.component.crypto.AsymmetricFactory;
import com.douyinpay.component.crypto.IAsymmetricCrypto;
import com.douyinpay.component.crypto.ICryptor;
import com.douyinpay.component.crypto.ISymmetricCrypto;
import com.douyinpay.component.crypto.RsaCryptor;
import com.douyinpay.component.crypto.SymmetricFactory;
import com.douyinpay.component.crypto.IVerifier;
import com.douyinpay.component.crypto.VerifierFactory;
import com.douyinpay.component.http.DefaultHttpClientBuilder;
import com.douyinpay.component.http.HttpMethod;
import com.douyinpay.define.Constants;
import com.douyinpay.define.DomainName;
import com.douyinpay.exception.DouyinpayException;
import com.douyinpay.define.GlobalConfig;
import com.douyinpay.define.AutoPlatformCertificateConfig;
import com.douyinpay.define.AutoPlatformCertificateConfig.AutoRSAConfigBuilder;
import com.douyinpay.define.AutoPlatformCertificateConfig.AutoSM2ConfigBuilder;
import com.douyinpay.exception.ServiceException;
import com.douyinpay.util.GsonUtil;
import com.douyinpay.util.NonceUtil;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.MultipartBody;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.time.Instant;
import java.time.temporal.ChronoField;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.requireNonNull;

public class DefaultDouyinpayClient implements DouyinpayClient {

    private String AgentName;

    private static final int NONCE_LENGTH = 32;

    private static final int DEFAULT_MAX_CLOCK_OFFSET_SECONDS = 300;
    private static final String PLATFORM_CERTIFICATES_PATH =
            "/v1/merchant/certificates/getPlatformCertificates";

    private boolean certificateDownloadOnly;
    private int maxClockOffsetSeconds = DEFAULT_MAX_CLOCK_OFFSET_SECONDS;

    private PrivateKey merchantPrivateKey;//私钥（pem格式）

    private X509Certificate platformCertificate; //平台证书
    private CertificateProvider certificateProvider; // 自动更新平台证书提供器
    private String encryptKey;//对称密钥
    private IAsymmetricCrypto signer;//非对称算法
    private IVerifier verifier;
    private ISymmetricCrypto encryptor;//对称算法

    /**
     * 敏感字段加解密器（RSA PKCS#1 v1.5）：上送用平台证书公钥加密，下行用服务商私钥解密。
     */
    private final ICryptor sensitiveCryptor = new RsaCryptor();

    /**
     * 商户证书序列号
     */
    private String merchantSerialNumber;


    private Map<String, String> headers;

    private OkHttpClient defaultOkHttpClient;

    private String mchId;//商户id
    private String signType;
    private String encryptType;

    /**
     * 连接超时，单位：毫秒
     */
    private int connectTimeout = 3000;

    /**
     * 读取超时，单位：毫秒
     */
    private int readTimeout = 15000;

    /**
     * 写超时，单位：毫秒
     */
    private int writeTimeout = 15000;


    public DefaultDouyinpayClient(GlobalConfig globalConfig) {

        this.AgentName = globalConfig.getSignType() + "-" + ClientVersion + "-" + globalConfig.getMchId();

        this.encryptKey = requireNonNull(globalConfig.getEncryptKey());
        this.mchId = globalConfig.getMchId();
        this.signType = requireNonNull(globalConfig.getSignType());
        this.encryptType = globalConfig.getEncryptType();

        this.connectTimeout = globalConfig.getConnectTimeout();
        this.readTimeout = globalConfig.getReadTimeout();
        this.writeTimeout = globalConfig.getWriteTimeout();
        this.maxClockOffsetSeconds = globalConfig.getMaxClockOffsetSeconds();

        defaultOkHttpClient = new DefaultHttpClientBuilder().readTimeoutMs(this.readTimeout).connectTimeoutMs(this.connectTimeout).writeTimeoutMs(this.writeTimeout).build();

        this.signer = AsymmetricFactory.getByName(this.signType);
        this.verifier = VerifierFactory.getByName(this.signType);
        this.encryptor = SymmetricFactory.getByName(this.encryptType);
        this.merchantSerialNumber = requireNonNull(globalConfig.getMerchantSerialNumber());

        this.headers = copyHeaders(globalConfig.getCustomHeaders());

        this.merchantPrivateKey = this.signer.loadPrivateKey(globalConfig.praticalPrivateKey());

        this.platformCertificate = this.signer.loadX509Certificate(globalConfig.praticalCetificate());

    }

    public X509Certificate getPlatformCertificate() {
        if (platformCertificate != null) {
            return platformCertificate;
        }
        if (certificateProvider != null) {
            return certificateProvider.getAvailableCertificate();
        }
        return platformCertificate;
    }

    public String getSignType() {
        return signType;
    }

    public PrivateKey getMerchantPrivateKey() {
        return merchantPrivateKey;
    }

    /**
     * 使用抖音支付平台证书公钥对上送的敏感字段进行 RSA PKCS#1 v1.5 加密，返回 Base64 编码密文。
     *
     * @param plainText 待加密原文
     * @return Base64 编码密文
     * @throws DouyinpayException 平台证书缺失或加密失败时抛出
     */
    @Override
    public String encryptSensitive(String plainText) {
        X509Certificate certificate = getPlatformCertificate();
        if (certificate == null) {
            throw new DouyinpayException("platform certificate is required for sensitive field encryption");
        }
        return sensitiveCryptor.encrypt(plainText, certificate);
    }

    /**
     * 使用服务商私钥对下行的敏感字段密文进行 RSA PKCS#1 v1.5 解密，返回原文。
     *
     * @param cipherText Base64 编码密文
     * @return 解密后的原文
     * @throws DouyinpayException 服务商私钥缺失或解密失败时抛出
     */
    @Override
    public String decryptSensitive(String cipherText) {
        if (merchantPrivateKey == null) {
            throw new DouyinpayException("merchant private key is required for sensitive field decryption");
        }
        return sensitiveCryptor.decrypt(cipherText, merchantPrivateKey);
    }

    public static class AutoRSABuilder {

        private AutoRSAConfigBuilder cb = new AutoRSAConfigBuilder();

        public AutoRSABuilder mchId(String mchId) {
            cb.mchId(mchId);
            return this;
        }

        public AutoRSABuilder merchantSerialNumber(String merchantSerialNumber) {
            cb.merchantSerialNumber(merchantSerialNumber);
            return this;
        }

        public AutoRSABuilder privateKeyPath(String privateKeyPath) {
            cb.privateKeyPath(privateKeyPath);
            return this;
        }

        public AutoRSABuilder privateKey(String privateKey) {
            cb.privateKey(privateKey);
            return this;
        }

        public AutoRSABuilder encryptKey(String encryptKey) {
            cb.encryptKey(encryptKey);
            return this;
        }

        public DefaultDouyinpayClient build() {
            AutoPlatformCertificateConfig config = cb.build();
            return new DefaultDouyinpayClient(config);
        }

    }

    public static class AutoSM2Builder {

        private AutoSM2ConfigBuilder cb = new AutoSM2ConfigBuilder();

        public AutoSM2Builder mchId(String mchId) {
            cb.mchId(mchId);
            return this;
        }

        public AutoSM2Builder merchantSerialNumber(String merchantSerialNumber) {
            cb.merchantSerialNumber(merchantSerialNumber);
            return this;
        }

        public AutoSM2Builder privateKeyPath(String privateKeyPath) {
            cb.privateKeyPath(privateKeyPath);
            return this;
        }

        public AutoSM2Builder privateKey(String privateKey) {
            cb.privateKey(privateKey);
            return this;
        }

        public AutoSM2Builder encryptKey(String encryptKey) {
            cb.encryptKey(encryptKey);
            return this;
        }

        public DefaultDouyinpayClient build() {
            AutoPlatformCertificateConfig config = cb.build();
            return new DefaultDouyinpayClient(config);
        }

    }


    public DefaultDouyinpayClient(AutoPlatformCertificateConfig config) {

        this.AgentName = "Auto" + config.getSignType() + "-" + ClientVersion + "-" + config.getMchId();

        this.encryptKey = requireNonNull(config.getEncryptKey());
        this.mchId = config.getMchId();
        this.signType = requireNonNull(config.getSignType());
        this.encryptType = requireNonNull(config.getEncryptType());

        this.connectTimeout = config.getConnectTimeout();
        this.readTimeout = config.getReadTimeout();
        this.writeTimeout = config.getWriteTimeout();
        this.maxClockOffsetSeconds = config.getMaxClockOffsetSeconds();

        defaultOkHttpClient = new DefaultHttpClientBuilder().readTimeoutMs(this.readTimeout).connectTimeoutMs(this.connectTimeout).writeTimeoutMs(this.writeTimeout).build();

        this.signer = AsymmetricFactory.getByName(this.signType);
        this.verifier = VerifierFactory.getByName(this.signType, config.getCertificateProvider());
        this.encryptor = SymmetricFactory.getByName(this.encryptType);
        this.merchantSerialNumber = requireNonNull(config.getMerchantSerialNumber());

        this.headers = copyHeaders(config.getCustomHeaders());
        this.certificateProvider = config.getCertificateProvider();
        this.merchantPrivateKey = this.signer.loadPrivateKey(config.praticalPrivateKey());

    }


    public <T> DouyinpayResponse<T> execute(DouyinpayRequest input, Class<T> reponseClass) throws DouyinpayException {

        if (certificateDownloadOnly && (input == null
                || input.getHttpMethod() != HttpMethod.GET
                || !PLATFORM_CERTIFICATES_PATH.equals(input.getPath())
                || !(DomainName.API.getValue() + PLATFORM_CERTIFICATES_PATH).equals(input.getUrl())
                || input.getBody() != null)) {
            throw new DouyinpayException("request payment: this client supports certificate download only; "
                    + "use GlobalConfig or AutoRSABuilder/AutoSM2Builder for business requests");
        }

        Request okHttpRequest = buildOkHttpRequest(input);

        try (Response okHttpResponse = defaultOkHttpClient.newCall(okHttpRequest).execute()) {

            if (okHttpResponse == null) {
                throw new RuntimeException("okhttp client response is empty");
            }

            if (okHttpResponse.body() == null) {
                throw new RuntimeException("okhttp client response body is empty");
            }

            Map<String, String> responseHeaders = new ConcurrentHashMap<>();
            // use an OkHttp3.x compatible method
            int headerSize = okHttpResponse.headers().size();
            for (int i = 0; i < headerSize; ++i) {
                responseHeaders.put(okHttpResponse.headers().name(i), okHttpResponse.headers().value(i));
            }

            String contentType = okHttpResponse.body() == null || okHttpResponse.body().contentType() == null
                    ? null
                    : okHttpResponse.body().contentType().toString();

            DouyinpayResponse<T> douyinpayResponse = new DouyinpayResponse(input, okHttpResponse.code(), contentType, responseHeaders, okHttpResponse.body().string());
            //校验response返回
            douyinpayResponse.validate();
            //校验签名&返回信息有效性
            validatePlatformSign(douyinpayResponse.getHeaders(), douyinpayResponse.getBody());

            if (reponseClass != null) {
                T bizResponse = GsonUtil.getGson().fromJson(douyinpayResponse.getBody(), reponseClass);

                douyinpayResponse.setApiResponse(bizResponse);
            }


            return douyinpayResponse;


        } catch (ServiceException e) {
            throw e;
        } catch (DouyinpayException e) {
            throw e;
        } catch (Exception e) {
            throw new DouyinpayException(String.format("Send Http Request failed,httpRequest[%s]", okHttpRequest), e);
        }


    }

    @Override
    public <T> DouyinpayResponse<T> executeMultipart(DouyinpayMultipartRequest input, Class<T> responseClass) {
        if (certificateDownloadOnly) {
            throw new DouyinpayException("request payment: this client supports certificate download only; "
                    + "use GlobalConfig or AutoRSABuilder/AutoSM2Builder for business requests");
        }
        Request.Builder builder = new Request.Builder().url(input.getUrl());
        if (this.headers != null) this.headers.forEach(builder::addHeader);
        if (input.getHeaders() != null) input.getHeaders().forEach(builder::addHeader);
        String auth = input.getSchema(this.signer.getSignAlgorithmName()) + " " + buildToken(input);
        builder.addHeader(Constants.AUTHORIZATION, auth);
        builder.addHeader(Constants.ACCEPT, Constants.APPLICATION_JSON);
        if (StringUtils.isNotEmpty(this.AgentName)) builder.addHeader(Constants.DOUYIN_PAY_SDK_AGENT, this.AgentName);
        MultipartBody body = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("meta", null,
                        RequestBody.create(MediaType.parse(Constants.APPLICATION_JSON), input.getMeta()))
                .addFormDataPart("file", input.getFileName(),
                        RequestBody.create(MediaType.parse(input.getFileType()), input.getFile()))
                .build();
        builder.addHeader(Constants.CONTENT_TYPE, body.contentType().toString());
        builder.method(input.getHttpMethod().name(), body);
        Request request = builder.build();
        try (Response response = defaultOkHttpClient.newCall(request).execute()) {
            if (response.body() == null) throw new DouyinpayException("http response body is empty");
            String responseBody = response.body().string();
            Map<String, String> responseHeaders = new ConcurrentHashMap<>();
            for (int i = 0; i < response.headers().size(); i++) responseHeaders.put(response.headers().name(i), response.headers().value(i));
            DouyinpayResponse<T> result = new DouyinpayResponse<>(input, response.code(),
                    response.header(Constants.CONTENT_TYPE), responseHeaders, responseBody);
            result.validate();
            validatePlatformSign(result.getHeaders(), responseBody);
            if (responseClass != null) result.setApiResponse(GsonUtil.getGson().fromJson(responseBody, responseClass));
            return result;
        } catch (DouyinpayException e) {
            throw e;
        } catch (Exception e) {
            throw new DouyinpayException("Send multipart request failed", e);
        }
    }


    private Request buildOkHttpRequest(DouyinpayRequest douyinpayRequest) {
        Request.Builder okHttpRequestBuilder = new Request.Builder().url(douyinpayRequest.getUrl());
        if (this.headers != null) {
            this.headers.forEach(okHttpRequestBuilder::addHeader);
        }

        Map<String, String> headers = douyinpayRequest.getHeaders();
        if (headers != null) {
            headers.forEach(okHttpRequestBuilder::addHeader);
        }
        String auth = douyinpayRequest.getSchema(this.signer.getSignAlgorithmName()) + " " + buildToken(douyinpayRequest);
        okHttpRequestBuilder.addHeader(Constants.AUTHORIZATION, auth);
        okHttpRequestBuilder.addHeader(Constants.ACCEPT, Constants.APPLICATION_JSON);
        okHttpRequestBuilder.addHeader(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON);
        if (StringUtils.isNotEmpty(this.AgentName)) {
            okHttpRequestBuilder.addHeader(Constants.DOUYIN_PAY_SDK_AGENT, this.AgentName);
        }
        String method = douyinpayRequest.getHttpMethod().name();
        RequestBody okHttpRequestBody = buildOkHttpRequestBody(douyinpayRequest.getBody());
        okHttpRequestBuilder.method(method, okHttpRequestBody);
        return okHttpRequestBuilder.build();
    }

    private RequestBody buildOkHttpRequestBody(String body) {
        if (body == null) {
            return null;
        }
        return okhttp3.RequestBody.create(MediaType.parse("application/json"), body);
    }


    private String buildToken(DouyinpayRequest input) {
        String nonceStr = NonceUtil.randomNonce(NONCE_LENGTH);
        long timestamp = Instant.now().getLong(ChronoField.INSTANT_SECONDS);
        String message = input.buildMessage(nonceStr, timestamp);
        String signature = this.signer.sign(message, this.merchantPrivateKey);
        String token = input.getToken(this.mchId, nonceStr, this.merchantSerialNumber, timestamp, signature);
        return token;

    }

    private void validatePlatformSign(Map<String, String> headerMap, String responseBody) {

        String timestamp = headerMap.get(Constants.DOUYIN_PAY_TIMESTAMP);
        String nonceStr = headerMap.get(Constants.DOUYIN_PAY_NONCE);
        String signature = headerMap.get(Constants.DOUYIN_PAY_SIGNATURE);
        String douyinpaySerial = headerMap.get(Constants.DOUYIN_PAY_SERIAL);
        String requestId = headerMap.get(Constants.DOUYIN_REQUEST_ID);
        responseBody = responseBody == null ? "" : responseBody;

        if (StringUtils.isBlank(timestamp) || StringUtils.isBlank(nonceStr)
                || StringUtils.isBlank(signature) || StringUtils.isBlank(douyinpaySerial)) {
            throw new DouyinpayException("verify response: missing signature headers");
        }

        String message = String.format(Constants.VERIFY_RESPONSE_SIGNATURE_FORAMT, timestamp, nonceStr, responseBody);

        if (!certificateDownloadOnly) {
            boolean verified;
            try {
                verified = this.verifier.verifyPlatformSign(message, this.platformCertificate, signature, douyinpaySerial);
            } catch (DouyinpayException | IllegalArgumentException e) {
                throw new DouyinpayException(String.format("verify response: signature verification failed, requestId[%s]", requestId), e);
            }
            if (!verified) {
                throw new DouyinpayException(String.format("verify response: invalid signature, requestId[%s]", requestId));
            }
        }
        long responseTimestamp;
        try {
            responseTimestamp = Long.parseLong(timestamp);
        } catch (NumberFormatException e) {
            throw new DouyinpayException("verify response: invalid timestamp", e);
        }
        long now = Instant.now().getEpochSecond();
        if (responseTimestamp < now - maxClockOffsetSeconds
                || responseTimestamp > now + maxClockOffsetSeconds) {
            throw new DouyinpayException(String.format("verify response: timestamp expired, requestId[%s]", requestId));
        }

    }

    private static Map<String, String> copyHeaders(Map<String, String> headers) {
        return headers == null ? null : new HashMap<>(headers);
    }


    /**
     * 平台证书下载构造器，保留已发布的六参数签名。
     * 仅允许从抖音支付官方 HTTPS 地址下载平台证书，不支持业务请求或文件上传。
     * 下载通过 HTTPS 和 API 密钥解密验证证书；业务请求必须使用配置了平台证书的客户端验签。
     *
     * @param mchId 商户号
     * @param signType 签名算法，RSA 或 SM2
     * @param encryptType 证书解密算法
     * @param praticalPrivateKey Base64 编码的商户私钥
     * @param encryptKey 商户 API 密钥
     * @param merchantSerialNumber 商户证书序列号
     * @deprecated 业务接入请使用 {@link DefaultDouyinpayClient#DefaultDouyinpayClient(GlobalConfig)}、
     *             {@link AutoRSABuilder} 或 {@link AutoSM2Builder}。
     */

    @Deprecated
    public DefaultDouyinpayClient(String mchId,
                                  String signType,
                                  String encryptType,
                                  String praticalPrivateKey,
                                  String encryptKey,
                                  String merchantSerialNumber
    ) {
        this.mchId = requireNonNull(mchId);
        this.signType = requireNonNull(signType);
        this.encryptType = requireNonNull(encryptType);
        this.signer = AsymmetricFactory.getByName(signType);
        this.merchantPrivateKey = signer.loadPrivateKey(praticalPrivateKey);
        this.encryptKey = requireNonNull(encryptKey);
        this.encryptor = SymmetricFactory.getByName(encryptType);
        this.merchantSerialNumber = requireNonNull(merchantSerialNumber);
        this.defaultOkHttpClient = new DefaultHttpClientBuilder().readTimeoutMs(this.readTimeout).connectTimeoutMs(this.connectTimeout).writeTimeoutMs(this.writeTimeout).build()
                .newBuilder().followRedirects(false).followSslRedirects(false).build();
        this.certificateDownloadOnly = true;
    }

}
