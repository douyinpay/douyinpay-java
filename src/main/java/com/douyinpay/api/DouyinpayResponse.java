package com.douyinpay.api;

import com.douyinpay.define.Constants;
import com.douyinpay.exception.DouyinpayException;
import com.douyinpay.exception.ServiceException;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

import static java.net.HttpURLConnection.HTTP_MULT_CHOICE;
import static java.net.HttpURLConnection.HTTP_OK;

/**
 * HTTP返回
 *
 * @param <T> 业务返回体类型
 */
public final class DouyinpayResponse<T> {

    private DouyinpayRequest request;
    private Map<String, String> headers;
    private String body;

    private T apiResponse;

    private int statusCode;

    private String contentType;


    public DouyinpayResponse(
            DouyinpayRequest request, int statusCode, String contentType, Map<String, String> headers, String body) {
        this.request = request;
        this.headers = headers;
        this.body = body;
        this.statusCode = statusCode;
        this.contentType = contentType;
    }

    /**
     * 获取返回头
     *
     * @return 返回头
     */
    public Map<String, String> getHeaders() {
        return headers;
    }

    /**
     * 获取返回对应的请求
     *
     * @return 请求
     */
    public DouyinpayRequest getRequest() {
        return request;
    }

    /**
     * 获取返回体
     *
     * @return 返回体
     */
    public String getBody() {
        return body;
    }

    /**
     * 获取业务返回
     *
     * @return 业务返回
     */
    public T getApiResponse() {
        return apiResponse;
    }

    public void setApiResponse(T apiResponse) {
        this.apiResponse = apiResponse;
    }


    public void validate() {
        if (isInvalidHttpCode(this.statusCode)) {
            throw new ServiceException(this.request,this.body,this.statusCode);
        }
    }


    private boolean isInvalidHttpCode(int httpCode) {
        return httpCode < HTTP_OK || httpCode >= HTTP_MULT_CHOICE;
    }


}
