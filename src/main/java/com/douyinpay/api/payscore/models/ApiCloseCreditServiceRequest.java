package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

/**
 * 解除先享后付服务授权请求。
 */
public class ApiCloseCreditServiceRequest {
    // 字段含义：应用ID。
    // 格式规则：string[1,32]。
    // 业务规则：商户在抖音开放平台申请的应用ID，全局唯一；此处请填写移动应用类型的AppID，并确保该AppID与mchid有绑定关系。
    // 示例：awofz9bncda6w2w4。
    @SerializedName("appid")
    private String appid;
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
    // 字段含义：解约原因。
    // 格式规则：string[1, 50]。
    // 示例：用户取消。
    @SerializedName("reason")
    private String reason;

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

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "ApiCloseCreditServiceRequest{" +
                "appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", authorizationCode='" + authorizationCode + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
