package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

public class ApiSynchronizeServiceOrderInfoRequest {
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
     * 商户订单号 说明：商户订单号
     */
    @SerializedName("out_order_no")
    private String outOrderNo;
    /**
     * 同步类型
     */
    @SerializedName("type")
    private String type;
    /**
     * 同步内容信息详情
     */
    @SerializedName("detail")
    private SyncDetail detail;

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

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public SyncDetail getDetail() {
        return detail;
    }

    public void setDetail(SyncDetail detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "ApiSynchronizeServiceOrderInfoRequest{" +
                "appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", outOrderNo='" + outOrderNo + '\'' +
                ", type='" + type + '\'' +
                ", detail=" + detail +
                '}';
    }
}



