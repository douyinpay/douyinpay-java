package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

public class ApiCreditSrvSignApplyRequest {
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
     * 商户协议号
     */
    @SerializedName("authorization_code")
    private String authorizationCode;
    /**
     * 通知地址
     */
    @SerializedName("notify_url")
    private String notifyUrl;
    /**
     * 优惠标记
     */
    @SerializedName("goods_tag")
    private String goodsTag;
    /**
     * 扩展参数
     */
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
