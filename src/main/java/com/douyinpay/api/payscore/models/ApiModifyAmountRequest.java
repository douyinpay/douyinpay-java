package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiModifyAmountRequest {
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
     * 总金额
     */
    @SerializedName("total_amount")
    private Integer totalAmount;
    /**
     * 修改原因
     */
    @SerializedName("reason")
    private String reason;
    /**
     * 后付费项目
     */
    @SerializedName("post_payments")
    private List<PostItem> postPayments;
    /**
     * 后付费商户优惠
     */
    @SerializedName("post_discounts")
    private List<PostItem> postDiscounts;


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

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<PostItem> getPostPayments() {
        return postPayments;
    }

    public void setPostPayments(List<PostItem> postPayments) {
        this.postPayments = postPayments;
    }

    public List<PostItem> getPostDiscounts() {
        return postDiscounts;
    }

    public void setPostDiscounts(List<PostItem> postDiscounts) {
        this.postDiscounts = postDiscounts;
    }

    @Override
    public String toString() {
        return "ApiModifyAmountRequest{" +
                "appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", outOrderNo='" + outOrderNo + '\'' +
                ", totalAmount=" + totalAmount +
                ", reason='" + reason + '\'' +
                ", postPayments=" + postPayments +
                ", postDiscounts=" + postDiscounts +
                '}';
    }
}
