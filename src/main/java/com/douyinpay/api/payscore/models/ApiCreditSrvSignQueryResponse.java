package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

/**
 * 查询用户先享后付授权记录响应。
 */
public class ApiCreditSrvSignQueryResponse {
    // 字段含义：应用ID。
    // 格式规则：string。
    // 业务规则：商户在抖音开放平台申请的应用ID，全局唯一；此处请填写移动应用类型的AppID，并确保该AppID与mchid有绑定关系。
    // 示例：awofz9bncda6w2w4。
    @SerializedName("appid")
    private String appid;
    // 字段含义：直连商户号。
    // 格式规则：string。
    // 业务规则：直连商户的商户号，由抖音支付生成并下发。
    // 示例：6020230307605084。
    @SerializedName("mchid")
    private String mchid;
    // 字段含义：服务ID。
    // 格式规则：string。
    // 业务规则：业务接入时分配，用于配置商户和场景维度信息。
    // 示例：101。
    @SerializedName("service_id")
    private String serviceId;
    // 字段含义：用户标识。
    // 格式规则：string。
    // 业务规则：用户在直连商户appid下的唯一标识。
    // 示例：oUpF8uMuAJO_M2pxb1Q9zNjWeS6o。
    @SerializedName("openid")
    private String openId;
    // 字段含义：商户协议号。
    // 格式规则：string。
    // 业务规则：商户侧生成的协议号，在同一个商户号下唯一。
    // 示例：1736173225954193889。
    @SerializedName("authorization_code")
    private String authorizationCode;
    // 字段含义：授权状态。
    // 格式规则：string。
    // 业务规则：标识用户授权服务情况： UNAVAILABLE: 用户未授权服务 AVAILABLE: 用户已授权服务。
    // 示例：AVAILABLE。
    @SerializedName("authorization_state")
    private String authorizationState;
    // 字段含义：解除授权时间。
    // 格式规则：string，遵循rfc3339标准格式，格式为yyyy-MM-DDTHH:mm:ss.sss+TIMEZONE 。
    // 示例："2026-05-28T13:22:45.120+08:00"。
    @SerializedName("cancel_authorization_time")
    private String cancelAuthorizationTime;
    // 字段含义：授权成功时间。
    // 格式规则：string，遵循rfc3339标准格式，格式为yyyy-MM-DDTHH:mm:ss.sss+TIMEZONE 。
    // 示例：2026-05-22T13:22:45.120+08:00。
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
