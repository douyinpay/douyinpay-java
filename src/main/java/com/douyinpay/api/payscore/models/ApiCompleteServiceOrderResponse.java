package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 完结先享后付服务订单响应。
 */
public class ApiCompleteServiceOrderResponse {
    // 字段含义：应用ID。
    // 格式规则：string。
    // 业务规则：商户在抖音开放平台申请的应用ID，全局唯一；此处请填写移动应用类型的AppID，并确保该AppID与mchid有绑定关系。
    // 示例：awofz9bncda6w2w4。
    @SerializedName("appid")
    private String appid;
    // 字段含义：直连商户号。
    // 格式规则：string。
    // 业务规则：直连商户的商户号，由抖音支付生成并下发。
    // 示例：6020230307605084。
    @SerializedName("mchid")
    private String mchid;
    // 字段含义：服务ID。
    // 格式规则：string。
    // 业务规则：业务接入时分配，用于配置商户和场景维度信息。
    // 示例：101。
    @SerializedName("service_id")
    private String serviceId;
    // 字段含义：服务信息。
    // 格式规则：string。
    // 业务规则：服务信息，用于介绍本订单所提供的服务。
    // 示例：某某酒店。
    @SerializedName("service_introduction")
    private String serviceIntroduction;
    // 字段含义：商户服务单号。
    // 格式规则：string，只能是数字、大小写字母_-*。
    // 业务规则：商户系统内部服务订单号，在同一个商户号下唯一。
    // 示例：OUT_1666688488。
    @SerializedName("out_order_no")
    private String outOrderNo;
    // 字段含义：抖音支付服务订单号。
    // 格式规则：string。
    // 业务规则：每个抖音支付服务订单号与商户号下对应的商户服务订单号一一对应。
    // 示例：10050100220208060900000023310957。
    @SerializedName("order_id")
    private String orderId;
    // 字段含义：服务订单状态。
    // 格式规则：string。
    // 业务规则：枚举值：CREATED表示商户已创建服务订单；DOING表示服务订单进行中；DONE表示服务订单完成；REVOKED表示商户取消服务订单；EXPIRED表示服务订单已失效。
    // 示例：DOING。
    @SerializedName("state")
    private String state;
    // 字段含义：订单状态说明。
    // 格式规则：string。
    // 业务规则：对服务订单“进行中”状态的附加说明：MCH_COMPLETE: 商户完结；USER_PAYING: 用户支付中；USER_CONFIRM: 用户已确认。
    // 示例：USER_PAYING。
    @SerializedName("state_description")
    private String stateDescription;
    // 字段含义：订单总金额。
    // 格式规则：int64。
    // 业务规则："1. 金额：数字，必须≥0（单位：分） 2. 总金额 =（完结付费项目1…+完结付费项目n）-（完结商户优惠项目1…+完结商户优惠项目n） "。
    // 示例：10000。
    @SerializedName("total_amount")
    private String totalAmount;
    // 字段含义：服务风险金。
    // 格式规则：object。
    // 示例：{"name":"ESTIMATE_ORDER_COST","amount":10000,"description":"预估订单费用"}。
    @SerializedName("risk_fund")
    private RiskFund riskFund;
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
    // 字段含义：优惠标记。
    // 格式规则：string，json格式。
    // 业务规则：和抖音支付协商后可用。
    // 示例：{"product_tag":"xxxx","biz_scene":"aaaa"}。
    @SerializedName("goods_tag")
    private String goodsTag;
    // 字段含义：商户数据包。
    // 格式规则：string。
    // 示例：{"out_product_category":"BATTERY_CHANGE"}。
    @SerializedName("attach")
    private String attach;

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

    public String getServiceIntroduction() {
        return serviceIntroduction;
    }

    public void setServiceIntroduction(String serviceIntroduction) {
        this.serviceIntroduction = serviceIntroduction;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateDescription() {
        return stateDescription;
    }

    public void setStateDescription(String stateDescription) {
        this.stateDescription = stateDescription;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public RiskFund getRiskFund() {
        return riskFund;
    }

    public void setRiskFund(RiskFund riskFund) {
        this.riskFund = riskFund;
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

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    @Override
    public String toString() {
        return "ApiCompleteServiceOrderResponse{" +
                "appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", serviceIntroduction='" + serviceIntroduction + '\'' +
                ", outOrderNo='" + outOrderNo + '\'' +
                ", orderId='" + orderId + '\'' +
                ", state='" + state + '\'' +
                ", stateDescription='" + stateDescription + '\'' +
                ", totalAmount='" + totalAmount + '\'' +
                ", riskFund=" + riskFund +
                ", postPayments=" + postPayments +
                ", postDiscounts=" + postDiscounts +
                ", timeRange=" + timeRange +
                ", location=" + location +
                ", sceneInfo=" + sceneInfo +
                ", goodsTag='" + goodsTag + '\'' +
                ", attach='" + attach + '\'' +
                '}';
    }
}
