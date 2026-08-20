package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

/**
 * 直连服务商查询用户授权响应。
 */
public class ApiCreditSrvSignQueryForSPResponse {
    /** 服务实体 ID。 */
    @SerializedName("service_id")
    private String serviceId;
    /** 服务商应用 ID。 */
    @SerializedName("sp_appid")
    private String spAppid;
    /** 服务商商户号。 */
    @SerializedName("sp_mchid")
    private String spMchid;
    /** 用户在服务商应用下的唯一标识。 */
    @SerializedName("sp_openid")
    private String spOpenId;
    /** 商户协议号。 */
    @SerializedName("authorization_code")
    private String authorizationCode;
    /** 签约状态。 */
    @SerializedName("authorization_state")
    private String authorizationState;
    /** 最近一次授权成功时间。 */
    @SerializedName("authorization_success_time")
    private String authorizationSuccessTime;
    /** 最近一次解除授权时间。 */
    @SerializedName("cancel_authorization_time")
    private String authorizationCancelTime;
    /** 子商户商户号。 */
    @SerializedName("sub_mchid")
    private String subMchid;
    /** 子商户应用 ID。 */
    @SerializedName("sub_appid")
    private String subAppid;
    /** 用户在子商户应用下的唯一标识。 */
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
