package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

/**
 * 直连服务商解除用户授权请求。
 */
public class ApiCreditSrvUnSignForSPRequest {
    /** 服务 ID。 */
    @SerializedName("service_id")
    private String serviceId;
    /** 商户协议号。 */
    @SerializedName("authorization_code")
    private String authorizationCode;
    /** 服务商商户号。 */
    @SerializedName("sp_mchid")
    private String spMchid;
    /** 服务商应用 ID。 */
    @SerializedName("sp_appid")
    private String spAppid;
    /** 子商户商户号。 */
    @SerializedName("sub_mchid")
    private String subMchid;
    /** 子商户应用 ID。 */
    @SerializedName("sub_appid")
    private String subAppid;
    /** 解约原因。 */
    @SerializedName("reason")
    private String reason;

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

    public String getSpMchid() {
        return spMchid;
    }

    public void setSpMchid(String spMchid) {
        this.spMchid = spMchid;
    }

    public String getSpAppid() {
        return spAppid;
    }

    public void setSpAppid(String spAppid) {
        this.spAppid = spAppid;
    }

    public String getSubMchid() {
        return subMchid;
    }

    public void setSubMchid(String subMchid) {
        this.subMchid = subMchid;
    }

    public String getSubAppid() {
        return subAppid;
    }

    public void setSubAppid(String subAppid) {
        this.subAppid = subAppid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
