package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiCreateServiceOrderResponse {
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
     * 服务信息
     */
    @SerializedName("service_introduction")
    private String serviceIntroduction;
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
    /**
     * 服务订单状态
     */
    @SerializedName("state")
    private String state;
    /**
     * 服务订单状态描述
     */
    @SerializedName("state_description")
    private String stateDescription;
    /**
     * 服务风险金
     */
    @SerializedName("risk_fund")
    private RiskFund riskFund;
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
     * 是否需要用户确认
     */
    @SerializedName("need_user_confirm")
    private Boolean needUserConfirm;
    /**
     * 先享后付申请token
     */
    @SerializedName("payscore_apply_token")
    private String payscoreApplyToken;
    /**
     * 用户标识
     */
    @SerializedName("openid")
    private String openId;
    /**
     * 商户协议号
     */
    @SerializedName("authorization_code")
    private String authorizationCode;
    /**
     * 商户数据包
     */
    @SerializedName("attach")
    private String attach;
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

    public Boolean getNeedUserConfirm() {
        return needUserConfirm;
    }

    public void setNeedUserConfirm(Boolean needUserConfirm) {
        this.needUserConfirm = needUserConfirm;
    }

    public String getPayscoreApplyToken() {
        return payscoreApplyToken;
    }

    public void setPayscoreApplyToken(String payscoreApplyToken) {
        this.payscoreApplyToken = payscoreApplyToken;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
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

    @Override
    public String toString() {
        return "ApiCreateServiceOrderResponse{" +
                "appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", serviceIntroduction='" + serviceIntroduction + '\'' +
                ", outOrderNo='" + outOrderNo + '\'' +
                ", orderId='" + orderId + '\'' +
                ", state='" + state + '\'' +
                ", stateDescription='" + stateDescription + '\'' +
                ", riskFund=" + riskFund +
                ", postPayments=" + postPayments +
                ", postDiscounts=" + postDiscounts +
                ", timeRange=" + timeRange +
                ", location=" + location +
                ", sceneInfo=" + sceneInfo +
                ", needUserConfirm=" + needUserConfirm +
                ", payscoreApplyToken='" + payscoreApplyToken + '\'' +
                ", openId='" + openId + '\'' +
                ", authorizationCode='" + authorizationCode + '\'' +
                ", attach='" + attach + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                ", goodsTag='" + goodsTag + '\'' +
                '}';
    }
}
