package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

/**
 * 直连服务商查询用户授权响应。
 */
public class ApiCreditSrvSignQueryForSPResponse {
    // 字段含义：服务ID。
    // 格式规则：string。
    // 业务规则：业务接入时分配，用于配置商户和场景维度信息。
    // 示例：101。
    @SerializedName("service_id")
    private String serviceId;
    // 字段含义：服务商应用ID。
    // 格式规则：string。
    // 业务规则：由抖音支付生成的应用ID，全局唯一。
    // 示例：awofz9bncda6w2w4。
    @SerializedName("sp_appid")
    private String spAppid;
    // 字段含义：服务商商户号。
    // 格式规则：string。
    // 业务规则：服务商的商户号，由抖音支付生成并下发。
    // 示例：6020230307605084。
    @SerializedName("sp_mchid")
    private String spMchid;
    // 字段含义：服务商商户下用户标识。
    // 格式规则：string。
    // 业务规则：用户在服务商户对应appid下的唯一标识。传入appid，未传入sub_appid时返回。
    // 示例：示例：oUpF8uMuAJO_M2pxb1Q9zNjWeS6o。。
    @SerializedName("sp_openid")
    private String spOpenId;
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
    // 字段含义：授权成功时间。
    // 格式规则：string，遵循rfc3339标准格式，格式为yyyy-MM-DDTHH:mm:ss.sss+TIMEZONE 。
    // 示例：2026-05-22T13:22:45.120+08:00。
    @SerializedName("authorization_success_time")
    private String authorizationSuccessTime;
    // 字段含义：解除授权时间。
    // 格式规则：string，遵循rfc3339标准格式，格式为yyyy-MM-DDTHH:mm:ss.sss+TIMEZONE 。
    // 示例："2026-05-28T13:22:45.120+08:00"。
    @SerializedName("cancel_authorization_time")
    private String authorizationCancelTime;
    // 字段含义：子商户商户号。
    // 格式规则：string。
    // 业务规则：子商户的商户号，由抖音支付生成并下发。
    // 示例：6020230307605085。
    @SerializedName("sub_mchid")
    private String subMchid;
    // 字段含义：子商户应用ID。
    // 格式规则：string。
    // 业务规则：由抖音支付生成的应用ID，全局唯一。
    // 示例：awofz9bncda6w2w4。
    @SerializedName("sub_appid")
    private String subAppid;
    // 字段含义：子商户下用户标识。
    // 格式规则：string。
    // 业务规则：用户在子商户对应appid下的唯一标识，sub_appid传入时返回。
    // 示例：oUpF8uMuAJO_M2pxb1Q9zNjWeS6o。
    @SerializedName("sub_openid")
    private String subOpenId;

    public String getServiceId() { return serviceId; }
    public void setServiceId(String serviceId) { this.serviceId = serviceId; }
    public String getSpAppid() { return spAppid; }
    public void setSpAppid(String spAppid) { this.spAppid = spAppid; }
    public String getSpMchid() { return spMchid; }
    public void setSpMchid(String spMchid) { this.spMchid = spMchid; }
    public String getSpOpenId() { return spOpenId; }
    public void setSpOpenId(String spOpenId) { this.spOpenId = spOpenId; }
    public String getAuthorizationCode() { return authorizationCode; }
    public void setAuthorizationCode(String authorizationCode) { this.authorizationCode = authorizationCode; }
    public String getAuthorizationState() { return authorizationState; }
    public void setAuthorizationState(String authorizationState) { this.authorizationState = authorizationState; }
    public String getAuthorizationSuccessTime() { return authorizationSuccessTime; }
    public void setAuthorizationSuccessTime(String authorizationSuccessTime) { this.authorizationSuccessTime = authorizationSuccessTime; }
    public String getAuthorizationCancelTime() { return authorizationCancelTime; }
    public void setAuthorizationCancelTime(String authorizationCancelTime) { this.authorizationCancelTime = authorizationCancelTime; }
    public String getSubMchid() { return subMchid; }
    public void setSubMchid(String subMchid) { this.subMchid = subMchid; }
    public String getSubAppid() { return subAppid; }
    public void setSubAppid(String subAppid) { this.subAppid = subAppid; }
    public String getSubOpenId() { return subOpenId; }
    public void setSubOpenId(String subOpenId) { this.subOpenId = subOpenId; }
}
