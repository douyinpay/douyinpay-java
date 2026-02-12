package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

public class ApiCreditSrvSignQueryRequest {
    /**
     * 直连商户号 说明：直连商户号
     */
    @SerializedName("mchid")
    private String mchid;
    /**
     * 服务id
     */
    @SerializedName("service_id")
    private String serviceId;
    /**
     * 商户协议号
     */
    @SerializedName("authorization_code")
    private String authorizationCode;

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    @Override
    public String toString() {
        return "ApiCreditSrvSignQueryRequest{" +
                "mchid='" + mchid + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", authorizationCode='" + authorizationCode + '\'' +
                '}';
    }
}
