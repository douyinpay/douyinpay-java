package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

public class ApiCreditSrvSignQueryResponse {
    @SerializedName("appid")
    private String appid;
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
     * 用户标识
     */
    @SerializedName("openid")
    private String openId;
    /**
     * 商户协议号
     */
    @SerializedName("authorization_code")
    private String authorizationCode;
    /**
     * 授权状态
     */
    @SerializedName("authorization_state")
    private String authorizationState;
    /**
     * 最近一次解除授权时间
     */
    @SerializedName("cancel_authorization_time")
    private String cancelAuthorizationTime;
    /**
     * 最近一次授权成功时间
     */
    @SerializedName("authorization_success_time")
    private String authorizationSuccessTime;


    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public String getAuthorizationState() {
        return authorizationState;
    }

    public void setAuthorizationState(String authorizationState) {
        this.authorizationState = authorizationState;
    }

    public String getCancelAuthorizationTime() {
        return cancelAuthorizationTime;
    }

    public void setCancelAuthorizationTime(String cancelAuthorizationTime) {
        this.cancelAuthorizationTime = cancelAuthorizationTime;
    }

    public String getAuthorizationSuccessTime() {
        return authorizationSuccessTime;
    }

    public void setAuthorizationSuccessTime(String authorizationSuccessTime) {
        this.authorizationSuccessTime = authorizationSuccessTime;
    }

    @Override
    public String toString() {
        return "ApiCreditSrvSignQueryResponse{" +
                "appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", openId='" + openId + '\'' +
                ", authorizationCode='" + authorizationCode + '\'' +
                ", authorizationState='" + authorizationState + '\'' +
                ", cancelAuthorizationTime='" + cancelAuthorizationTime + '\'' +
                ", authorizationSuccessTime='" + authorizationSuccessTime + '\'' +
                '}';
    }
}
