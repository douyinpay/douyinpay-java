package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

/**
 * 查询用户先享后付授权记录请求。
 */
public class ApiCreditSrvSignQueryRequest {
    // 字段含义：直连商户号。
    // 格式规则：string[1,32]。
    // 业务规则：直连商户的商户号，由抖音支付生成并下发。
    // 示例：6020230307605084。
    @SerializedName("mchid")
    private String mchid;
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
