package com.douyinpay.component.http;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import java.util.concurrent.TimeUnit;
import static okhttp3.internal.Util.immutableListOf;

/**
 * httpclient（默认okhttp）
 */
public class DefaultHttpClientBuilder {

    private int readTimeoutMs = -1;//读超时
    private int writeTimeoutMs = -1;//写超时
    private int connectTimeoutMs = -1;//连接超时
    private static final OkHttpClient defaultOkHttpClient = new okhttp3.OkHttpClient();

    private OkHttpClient customizeOkHttpClient;


    public DefaultHttpClientBuilder readTimeoutMs(int readTimeoutMs) {
        this.readTimeoutMs = readTimeoutMs;
        return this;
    }

    /**
     * 设置写超时
     *
     * @param writeTimeoutMs 写超时，单位毫秒
     * @return defaultHttpClientBuilder
     */
    public DefaultHttpClientBuilder writeTimeoutMs(int writeTimeoutMs) {
        this.writeTimeoutMs = writeTimeoutMs;
        return this;
    }

    /**
     * 设置连接超时
     *
     * @param connectTimeoutMs 连接超时，单位毫秒
     * @return defaultHttpClientBuilder
     */
    public DefaultHttpClientBuilder connectTimeoutMs(int connectTimeoutMs) {
        this.connectTimeoutMs = connectTimeoutMs;
        return this;
    }

    public DefaultHttpClientBuilder okHttpClient(okhttp3.OkHttpClient okHttpClient) {
        this.customizeOkHttpClient = okHttpClient;
        return this;
    }

    public OkHttpClient build() {
        OkHttpClient.Builder okHttpClientBuilder = (customizeOkHttpClient == null ? defaultOkHttpClient : customizeOkHttpClient).newBuilder();
        okHttpClientBuilder.protocols(immutableListOf(Protocol.HTTP_1_1));

        if (readTimeoutMs >= 0) {
            okHttpClientBuilder.readTimeout(readTimeoutMs, TimeUnit.MILLISECONDS);
        }

        if (writeTimeoutMs >= 0) {
            okHttpClientBuilder.writeTimeout(writeTimeoutMs, TimeUnit.MILLISECONDS);
        }

        if (connectTimeoutMs >= 0) {
            okHttpClientBuilder.connectTimeout(connectTimeoutMs, TimeUnit.MILLISECONDS);
        }

        return okHttpClientBuilder.build();
    }
}
