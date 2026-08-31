package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

/**
 * 直连服务商查询用户授权请求。
 */
public class ApiCreditSrvSignQueryForSPRequest {
    // 字段含义：服务ID。
    // 格式规则：string[1,32]。
    // 业务规则：业务接入时分配，用于配置商户和场景维度信息。
    // 示例：101。
    @SerializedName("service_id")
    private String serviceId;
    // 字段含义：商户协议号。
    // 格式规则：string[1,64]。
    // 业务规则：商户侧生成的协议号，在同一个商户号下唯一。
    // 示例：1736173225954193889。
    @SerializedName("authorization_code")
    private String authorizationCode;
    // 字段含义：服务商商户号。
    // 格式规则：string[1,32]。
    // 业务规则：服务商的商户号，由抖音支付生成并下发。
    // 示例：6020230307605084。
    @SerializedName("sp_mchid")
    private String spMchid;
    // 字段含义：子商户商户号。
    // 格式规则：string[1,32]。
    // 业务规则：子商户的商户号，由抖音支付生成并下发。
    // 示例：6020230307605085。
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
