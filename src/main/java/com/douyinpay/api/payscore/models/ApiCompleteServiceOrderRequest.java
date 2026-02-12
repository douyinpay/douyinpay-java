package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiCompleteServiceOrderRequest {
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
     * 后付费项目
     */
    @SerializedName("post_payments")
    private List<PostItem> postPayments;
    /**
     * 后付费商户优惠
     */
    @SerializedName("post_discounts")
    private List<PostItem> postDiscounts;
    /**
     * 服务时间段
     */
    @SerializedName("time_range")
    private TimeRange timeRange;
    /**
     * 服务位置
     */
    @SerializedName("location")
    private Location location;
    /**
     * 场景信息
     */
    @SerializedName("scene_info")
    private SceneInfo sceneInfo;
    /**
     * 商户数据包
     */
    @SerializedName("attach")
    private String attach;
    /**
     * 优惠标记
     */
    @SerializedName("goods_tag")
    private String goodsTag;

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

    public TimeRange getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(TimeRange timeRange) {
        this.timeRange = timeRange;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public SceneInfo getSceneInfo() {
        return sceneInfo;
    }

    public void setSceneInfo(SceneInfo sceneInfo) {
        this.sceneInfo = sceneInfo;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    @Override
    public String toString() {
        return "ApiCompleteServiceOrderRequest{" +
                "appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", outOrderNo='" + outOrderNo + '\'' +
                ", totalAmount=" + totalAmount +
                ", postPayments=" + postPayments +
                ", postDiscounts=" + postDiscounts +
                ", timeRange=" + timeRange +
                ", location=" + location +
                ", sceneInfo=" + sceneInfo +
                ", attach='" + attach + '\'' +
                ", goodsTag='" + goodsTag + '\'' +
                '}';
    }
}
