package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 完结先享后付服务订单请求。
 */
public class ApiCompleteServiceOrderRequest {
    // 字段含义：应用ID。
    // 格式规则：[1,32]。
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
    // 字段含义：商户服务单号。
    // 格式规则：string，只能是数字、大小写字母_-*。
    // 业务规则：商户系统内部服务订单号，在同一个商户号下唯一。
    // 示例：OUT_1666688488。
    @SerializedName("out_order_no")
    private String outOrderNo;
    // 字段含义：订单总金额。
    // 格式规则：int。
    // 业务规则：1. 金额：数字，必须≥0（单位：分）2. 总金额=后付费项目金额之和-后付费商户优惠项目金额之和，且小于等于服务风险金额。取消订单时，该字段必须为0 。
    // 示例：10000。
    @SerializedName("total_amount")
    private Integer totalAmount;
    // 字段含义：后付费项目。
    // 格式规则：array。
    // 示例：[{"name":"出行费用","amount":4000,"description":"美味餐厅","count":1}]。
    @SerializedName("post_payments")
    private List<PostItem> postPayments;
    // 字段含义：商户优惠。
    // 格式规则：array。
    // 示例：[{"name":"满20减1元","amount":100,"description":"美味餐厅","count":1}]。
    @SerializedName("post_discounts")
    private List<PostItem> postDiscounts;
    // 字段含义：实际服务时间段。
    // 格式规则：object。
    // 示例：{"start_time":"20220208060910","end_time":"20220208060920","start_time_remark":"备注1","end_time_remark":"备注2"}。
    @SerializedName("time_range")
    private TimeRange timeRange;
    // 字段含义：服务位置。
    // 格式规则：object。
    // 示例：{"start_location":"美味餐厅","end_location":"美味餐厅"}。
    @SerializedName("location")
    private Location location;
    // 字段含义：场景信息。
    // 格式规则：object。
    // 示例：{"client_ip":"14.23.150.211","device_id":"13467007045764","store_info":{"id":"1089"}}。
    @SerializedName("scene_info")
    private SceneInfo sceneInfo;
    // 字段含义：商户数据包。
    // 格式规则：string[1,1024]。
    // 示例：{"out_product_category":"BATTERY_CHANGE"}。
    @SerializedName("attach")
    private String attach;
    // 字段含义：优惠标记。
    // 格式规则：string[1,512]，json格式。
    // 业务规则：和抖音支付协商后可用。
    // 示例：{"product_tag":"xxxx","biz_scene":"aaaa"}。
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
