package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

/**
 * 直连服务商查询用户授权请求。
 */
public class ApiCreditSrvSignQueryForSPRequest {
    /** 服务 ID。 */
    @SerializedName("service_id")
    private String serviceId;
    /** 商户协议号。 */
    @SerializedName("authorization_code")
    private String authorizationCode;
    /** 服务商商户号。 */
    @SerializedName("sp_mchid")
    private String spMchid;
    /** 子商户商户号。 */
    @SerializedName("sub_mchid")
    private String subMchid;

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

    public String getSubMchid() {
        return subMchid;
    }

    public void setSubMchid(String subMchid) {
        this.subMchid = subMchid;
    }
}
