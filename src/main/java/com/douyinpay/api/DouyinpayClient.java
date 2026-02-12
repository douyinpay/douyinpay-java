package com.douyinpay.api;

public interface DouyinpayClient {

    public final String ClientVersion = "JAVA-v1.0.0";

    /**
     * 发送HTTP请求
     *
     * @param request       HTTP请求
     * @param responseClass 业务返回类的Class对象，如果不确定业务返回类型，或该请求没有返回体，可以传入Object.class
     * @param <T>           由Class对象建模的类的类型
     * @return HTTP返回
     */
    <T> DouyinpayResponse<T> execute(DouyinpayRequest request, Class<T> responseClass);
}
