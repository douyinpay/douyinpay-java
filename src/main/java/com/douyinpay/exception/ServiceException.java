package com.douyinpay.exception;

import com.douyinpay.api.DouyinpayRequest;
import com.douyinpay.define.Constants;
import com.douyinpay.util.GsonUtil;
import com.google.gson.JsonObject;

import java.util.Map;

public class ServiceException extends DouyinpayException {
    private static final long serialVersionUID = -325006813541288231L;


    private final DouyinpayRequest request;
    private final int httpStatusCode;
    private final String responseBody;
    private String errorCode;
    private String errorMessage;

    public ServiceException(DouyinpayRequest request, String responseBody, int httpStatusCode)
    {
        super(String.format(
                "Invalid HttpStatusCode[%d]%nhttResponseBody[%.1024s]\tHttpRequest[%s]",
                httpStatusCode,responseBody, request));
        this.request = request;
        this.responseBody = responseBody;
        this.httpStatusCode = httpStatusCode;
        if (responseBody!=null && !responseBody.isEmpty()) {
            JsonObject jsonObject =  GsonUtil.getGson().fromJson(responseBody, JsonObject.class);
            this.errorCode = jsonObject.get("code").getAsString();
            this.errorMessage = jsonObject.get("message").getAsString();
        }
    }

    public DouyinpayRequest getRequest() {
        return request;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
