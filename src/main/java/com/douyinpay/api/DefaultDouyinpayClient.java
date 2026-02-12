package com.douyinpay.api;

import com.douyinpay.component.certificate.AutoCertificateProvider;
import com.douyinpay.component.crypto.AsymmetricFactory;
import com.douyinpay.component.crypto.IAsymmetricCrypto;
import com.douyinpay.component.crypto.ISymmetricCrypto;
import com.douyinpay.component.crypto.SymmetricFactory;
import com.douyinpay.component.crypto.IVerifier;
import com.douyinpay.component.crypto.VerifierFactory;
import com.douyinpay.component.http.DefaultHttpClientBuilder;
import com.douyinpay.define.Constants;
import com.douyinpay.exception.DouyinpayException;
import com.douyinpay.define.GlobalConfig;
import com.douyinpay.define.AutoPlatformCertificateConfig;
import com.douyinpay.exception.ServiceException;
import com.douyinpay.util.GsonUtil;
import com.douyinpay.util.NonceUtil;
import com.douyinpay.util.StringUtil;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoField;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.requireNonNull;

public class DefaultDouyinpayClient implements DouyinpayClient {

    private String AgentName;

    private static final int NONCE_LENGTH = 32;

    private static final long RESPONSE_EXPIRED_MINUTES = 5 * 60;

    private PrivateKey merchantPrivateKey;//私钥（pem格式）

    private X509Certificate platformCertificate; //平台证书
    private String encryptKey;//对称密钥
    private IAsymmetricCrypto signer;//非对称算法
    private IVerifier verifier;
    private ISymmetricCrypto encryptor;//对称算法

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


    private int writeTimeout = 15000;


    public DefaultDouyinpayClient(GlobalConfig globalConfig) {

        this.AgentName = globalConfig.getSignType() + "-" + ClientVersion + "-" + globalConfig.getMchId();

        this.encryptKey = requireNonNull(globalConfig.getEncryptKey());
        this.mchId = globalConfig.getMchId();
        this.signType = requireNonNull(globalConfig.getSignType());
        this.connectTimeout = globalConfig.getConnectTimeout();
        this.readTimeout = globalConfig.getReadTimeout();
        this.writeTimeout = globalConfig.getWriteTimeout();
        this.encryptType = globalConfig.getEncryptType();

        defaultOkHttpClient = new DefaultHttpClientBuilder().readTimeoutMs(this.readTimeout).connectTimeoutMs(this.connectTimeout).writeTimeoutMs(this.writeTimeout).build();

        this.signer = AsymmetricFactory.getByName(this.signType);
        this.verifier = VerifierFactory.getByName(this.signType);
        this.encryptor = SymmetricFactory.getByName(this.encryptType);
        this.merchantSerialNumber = requireNonNull(globalConfig.getMerchantSerialNumber());

        this.headers = globalConfig.getCustomHeaders();

        this.merchantPrivateKey = this.signer.loadPrivateKey(globalConfig.praticalPrivateKey());

        this.platformCertificate = this.signer.loadX509Certificate(globalConfig.praticalCetificate());

    }

    public static class AutoRSABuilder {

        private String mchId;
        private String merchantSerialNumber;
        private String encryptKey;

        // 二选一
        private String privateKey;
        private String privateKeyPath;


        public AutoRSABuilder mchId(String mchId) {
            this.mchId = mchId;
            return this;
        }

        public AutoRSABuilder merchantSerialNumber(String merchantSerialNumber) {
            this.merchantSerialNumber = merchantSerialNumber;
            return this;
        }

        public AutoRSABuilder privateKeyPath(String privateKeyPath) {
            this.privateKeyPath = privateKeyPath;
            return this;
        }

        public AutoRSABuilder privateKey(String privateKey) {
            this.privateKey = privateKey;
            return this;
        }

        public AutoRSABuilder encryptKey(String encryptKey) {
            this.encryptKey = encryptKey;
            return this;
        }

        public DefaultDouyinpayClient build() {

            if (StringUtils.isEmpty(mchId)) {
                throw new DouyinpayException("mchId不能为空");
            }
            if (StringUtils.isEmpty(merchantSerialNumber)) {
                throw new DouyinpayException("merchantSerialNumber不能为空");
            }
            if (StringUtils.isEmpty(encryptKey)) {
                throw new DouyinpayException("encryptKey不能为空");
            }
            if (StringUtils.isEmpty(privateKey) && StringUtils.isEmpty(privateKeyPath)) {
                throw new DouyinpayException("缺少私钥配置信息");
            }

            AutoPlatformCertificateConfig config = new AutoPlatformCertificateConfig();
            config.setMchId(mchId);
            config.setSignType(Constants.SIGN_TYPE_RSA);
            config.setMerchantSerialNumber(merchantSerialNumber);
            config.setEncryptType(Constants.ENCRYPT_TYPE_AES);
            config.setEncryptKey(encryptKey);
            config.setPrivateKey(privateKey);
            config.setPrivateKeyPath(privateKeyPath);
            config.setCertificateProvider(
                    new AutoCertificateProvider.Builder()
                            .merchantId(mchId)
                            .signType(Constants.SIGN_TYPE_RSA)
                            .encryptKey(encryptKey)
                            .douyinpayClient(new DefaultDouyinpayClient(mchId, Constants.SIGN_TYPE_RSA, Constants.ENCRYPT_TYPE_AES, config.praticalPrivateKey(), encryptKey, merchantSerialNumber))
                            .build());

            return new DefaultDouyinpayClient(config);
        }

    }


    public static class AutoSM2Builder {

        private String mchId;
        private String merchantSerialNumber;
        private String encryptKey;

        // 二选一
        private String privateKey;
        private String privateKeyPath;


        public AutoSM2Builder mchId(String mchId) {
            this.mchId = mchId;
            return this;
        }

        public AutoSM2Builder merchantSerialNumber(String merchantSerialNumber) {
            this.merchantSerialNumber = merchantSerialNumber;
            return this;
        }

        public AutoSM2Builder privateKeyPath(String privateKeyPath) {
            this.privateKeyPath = privateKeyPath;
            return this;
        }

        public AutoSM2Builder privateKey(String privateKey) {
            this.privateKey = privateKey;
            return this;
        }

        public AutoSM2Builder encryptKey(String encryptKey) {
            this.encryptKey = encryptKey;
            return this;
        }

        public DefaultDouyinpayClient build() {
            if (StringUtils.isEmpty(mchId)) {
                throw new DouyinpayException("mchId不能为空");
            }
            if (StringUtils.isEmpty(merchantSerialNumber)) {
                throw new DouyinpayException("merchantSerialNumber不能为空");
            }
            if (StringUtils.isEmpty(encryptKey)) {
                throw new DouyinpayException("encryptKey不能为空");
            }
            if (StringUtils.isEmpty(privateKey) && StringUtils.isEmpty(privateKeyPath)) {
                throw new DouyinpayException("缺少私钥配置信息");
            }
            AutoPlatformCertificateConfig config = new AutoPlatformCertificateConfig();
            config.setMchId(mchId);
            config.setSignType(Constants.SIGN_TYPE_SM2);
            config.setMerchantSerialNumber(merchantSerialNumber);
            config.setEncryptType(Constants.ENCRYPT_TYPE_SM4);
            config.setEncryptKey(encryptKey);
            config.setPrivateKey(privateKey);
            config.setPrivateKeyPath(privateKeyPath);
            config.setCertificateProvider(
                    new AutoCertificateProvider.Builder()
                            .merchantId(mchId)
                            .signType(Constants.SIGN_TYPE_SM2)
                            .encryptKey(encryptKey)
                            .douyinpayClient(new DefaultDouyinpayClient(mchId, Constants.SIGN_TYPE_SM2, Constants.ENCRYPT_TYPE_SM4, config.praticalPrivateKey(), encryptKey, merchantSerialNumber))
                            .build());
            return new DefaultDouyinpayClient(config);
        }

    }


    public DefaultDouyinpayClient(AutoPlatformCertificateConfig config) {

        this.AgentName = "Auto" + config.getSignType() + "-" + ClientVersion + "-" + config.getMchId();

        this.encryptKey = requireNonNull(config.getEncryptKey());
        this.mchId = config.getMchId();
        this.signType = requireNonNull(config.getSignType());
        this.encryptType = requireNonNull(config.getEncryptType());

        defaultOkHttpClient = new DefaultHttpClientBuilder().readTimeoutMs(this.readTimeout).connectTimeoutMs(this.connectTimeout).writeTimeoutMs(this.writeTimeout).build();

        this.signer = AsymmetricFactory.getByName(this.signType);
        this.verifier = VerifierFactory.getByName(this.signType, config.getCertificateProvider());
        this.encryptor = SymmetricFactory.getByName(this.encryptType);
        this.merchantSerialNumber = requireNonNull(config.getMerchantSerialNumber());

        this.headers = config.getCustomHeaders();
        this.merchantPrivateKey = this.signer.loadPrivateKey(config.praticalPrivateKey());

    }


    public <T> DouyinpayResponse<T> execute(DouyinpayRequest input, Class<T> reponseClass) throws DouyinpayException {


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
        Instant responseTime = Instant.ofEpochSecond(Long.parseLong(timestamp));
        String requestId = headerMap.get(Constants.DOUYIN_REQUEST_ID);
        responseBody = responseBody == null ? "" : responseBody;

        if (Duration.between(responseTime, Instant.now()).abs().toMinutes() >= RESPONSE_EXPIRED_MINUTES) {
            throw new DouyinpayException(String.format("httpResponse is expires,requestId[%s],timestamp[%s]", requestId, timestamp));
        }

        String message = String.format(Constants.VERIFY_RESPONSE_SIGNATURE_FORAMT, timestamp, nonceStr, responseBody);

        if (!this.verifier.verifyPlatformSign(message, this.platformCertificate, signature, douyinpaySerial)) {
            throw new DouyinpayException(String.format(
                    "Validate response failed,the douiyinpay signature is incorrect\n." +
                            "requestId[%s]\tresponseHeader[%s]\tresponseBody[%.1024s]",
                    requestId, headerMap, responseBody));
        }

    }


    /**
     * 仅auto 下载时的client构造器，不校验平台签名，慎用！！！
     *
     * @param mchId
     * @param signType
     * @param encryptType
     * @param praticalPrivateKey
     * @param encryptKey
     * @param merchantSerialNumber
     */

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
        this.defaultOkHttpClient = new DefaultHttpClientBuilder().readTimeoutMs(this.readTimeout).connectTimeoutMs(this.connectTimeout).writeTimeoutMs(this.writeTimeout).build();
        this.verifier = (plainText, platformCertificate, sign, serialNumber) -> true;
    }

}
