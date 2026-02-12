package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

public class ApiServiceOrderPayResponse {
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
     * 抖音支付服务订单号
     */
    @SerializedName("order_id")
    private String orderId;

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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "ApiServiceOrderPayResponse{" +
                "appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", outOrderNo='" + outOrderNo + '\'' +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
