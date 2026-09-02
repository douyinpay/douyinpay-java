package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

/**
 * 申请先享后付服务授权请求。
 */
public class ApiCreditSrvSignApplyRequest {
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
    // 字段含义：通知地址。
    // 格式规则：string[1,255]，必须为https地址。请确保回调URL是外部可正常访问的，且不能携带后缀参数。
    // 示例：https://www.bytedance.com。
    @SerializedName("notify_url")
    private String notifyUrl;
    // 字段含义：优惠标记。
    // 格式规则：string[1,512]，json格式。
    // 业务规则：和抖音支付协商后可用。
    // 示例：{"product_tag":"xxxx","biz_scene":"aaaa"}。
    @SerializedName("goods_tag")
    private String goodsTag;
    // 字段含义：扩展参数。
    // 格式规则：string[1,2048]，json字符串。
    // 业务规则：和抖音支付协商后可用。
    // 示例：{"A":"a"}。
    @SerializedName("ext_info")
    private String extInfo;

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

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }

    @Override
    public String toString() {
        return "ApiCreditSrvSignApplyRequest{" +
                "appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", authorizationCode='" + authorizationCode + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                ", goodsTag='" + goodsTag + '\'' +
                ", extInfo='" + extInfo + '\'' +
                '}';
    }
}
