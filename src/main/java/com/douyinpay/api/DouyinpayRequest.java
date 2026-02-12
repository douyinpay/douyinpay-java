package com.douyinpay.api;

import com.douyinpay.component.http.HttpMethod;
import com.douyinpay.util.GsonUtil;

import java.util.Map;

/**
 * HTTP请求
 */
public class DouyinpayRequest {

    private static final int NONCE_LENGTH = 32;

    public static final String SCHEMA_PREFIX = "DouyinPay-";

    private HttpMethod httpMethod;
    private String url;

    private String path;
    private Map<String, String> headers;
    private String body;

    private boolean isSign;

    /**
     * 商户证书序列号
     */
    private String merchantSerialNumber;


    public DouyinpayRequest( HttpMethod httpMethod, String url, String path, Map<String, String> headers, String body) {
        this.httpMethod = httpMethod;
        this.url = url;
        this.path = path;
        this.headers = headers;
        this.body = body;
    }

    /**
     * 获取HttpMethod
     *
     * @return httpMethod
     */
    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    /**
     * 获取请求URL
     *
     * @return 请求URL
     */
    public String getUrl() {
        return url + path;
    }

    /**
     * 获取请求头
     *
     * @return 请求头
     */
    public Map<String, String> getHeaders() {
        return headers;
    }

    /**
     * 获取请求体
     *
     * @return 请求体
     */
    public String getBody() {
        return body;
    }

    public boolean isSign() {
        return isSign;
    }

    public String getPath() {
        return path;
    }


    public String getSchema(String algorithmName) {
        return SCHEMA_PREFIX + algorithmName;
    }

    public String getMerchantSerialNumber() {
        return merchantSerialNumber;
    }


    public String buildMessage(String nonceStr, long timestamp) {

        return this.getHttpMethod().name() + "\n" + this.getPath() + "\n" + timestamp + "\n" + nonceStr + "\n" + (this.getBody() == null ? "" : this.getBody()) + "\n";
    }


    public String getToken(String mchId, String nonceStr, String merchantSerialNumber, long timestamp, String signature) {
        String token = "mchid=\"" + mchId + "\"," + "nonce_str=\"" + nonceStr + "\"," + "timestamp=\"" + timestamp + "\"," + "serial_no=\"" + merchantSerialNumber + "\"," + "signature=\"" + signature + "\"";
        return token;
    }

    @Override
    public String toString() {
        return GsonUtil.getGson().toJson(this);
    }


}
