package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 直连服务商创建服务订单响应。
 */
public class ApiCreateServiceOrderForSPResponse {
    /** 服务商商户号。 */
    @SerializedName("sp_mchid") private String spMchid;
    /** 服务商应用 ID。 */
    @SerializedName("sp_appid") private String spAppid;
    /** 子商户商户号。 */
    @SerializedName("sub_mchid") private String subMchid;
    /** 子商户应用 ID。 */
    @SerializedName("sub_appid") private String subAppid;
    /** 商户服务单号。 */
    @SerializedName("out_order_no") private String outOrderNo;
    /** 服务 ID。 */
    @SerializedName("service_id") private String serviceId;
    /** 服务信息。 */
    @SerializedName("service_introduction") private String serviceIntroduction;
    /** 抖音支付服务订单号。 */
    @SerializedName("order_id") private String orderId;
    /** 服务订单状态。 */
    @SerializedName("state") private String state;
    /** 订单状态说明。 */
    @SerializedName("state_description") private String stateDescription;
    /** 子商户下用户标识。 */
    @SerializedName("sub_openid") private String subOpenId;
    /** 商户数据包。 */
    @SerializedName("attach") private String attach;
    /** 通知地址。 */
    @SerializedName("notify_url") private String notifyUrl;
    /** 后付费项目。 */
    @SerializedName("post_payments") private List<PostItem> postPayments;
    /** 商户优惠。 */
    @SerializedName("post_discounts") private List<PostItem> postDiscounts;
    /** 实际服务时间段。 */
    @SerializedName("time_range") private TimeRange timeRange;
    /** 服务位置。 */
    @SerializedName("location") private Location location;
    /** 场景信息。 */
    @SerializedName("scene_info") private SceneInfo sceneInfo;
    /** 服务风险金。 */
    @SerializedName("risk_fund") private RiskFund riskFund;
    /** 是否需要用户确认。 */
    @SerializedName("need_user_confirm") private Boolean needUserConfirm;
    /** 优惠标记。 */
    @SerializedName("goods_tag") private String goodsTag;
    /** 跳转抖音支付token。 */
    @SerializedName("payscore_apply_token") private String payscoreApplyToken;
    /** 商户协议号。 */
    @SerializedName("authorization_code") private String authorizationCode;
    /** 服务商商户下用户标识 */
    @SerializedName("sp_openid") private String spOpenId;

    public String getSpMchid() { return spMchid; }
    public void setSpMchid(String spMchid) { this.spMchid = spMchid; }
    public String getSpAppid() { return spAppid; }
    public void setSpAppid(String spAppid) { this.spAppid = spAppid; }
    public String getSubMchid() { return subMchid; }
    public void setSubMchid(String subMchid) { this.subMchid = subMchid; }
    public String getSubAppid() { return subAppid; }
    public void setSubAppid(String subAppid) { this.subAppid = subAppid; }
    public String getOutOrderNo() { return outOrderNo; }
    public void setOutOrderNo(String outOrderNo) { this.outOrderNo = outOrderNo; }
    public String getServiceId() { return serviceId; }
    public void setServiceId(String serviceId) { this.serviceId = serviceId; }
    public String getServiceIntroduction() { return serviceIntroduction; }
    public void setServiceIntroduction(String serviceIntroduction) { this.serviceIntroduction = serviceIntroduction; }
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    public String getStateDescription() { return stateDescription; }
    public void setStateDescription(String stateDescription) { this.stateDescription = stateDescription; }
    public String getSubOpenId() { return subOpenId; }
    public void setSubOpenId(String subOpenId) { this.subOpenId = subOpenId; }
    public String getAttach() { return attach; }
    public void setAttach(String attach) { this.attach = attach; }
    public String getNotifyUrl() { return notifyUrl; }
    public void setNotifyUrl(String notifyUrl) { this.notifyUrl = notifyUrl; }
    public List<PostItem> getPostPayments() { return postPayments; }
    public void setPostPayments(List<PostItem> postPayments) { this.postPayments = postPayments; }
    public List<PostItem> getPostDiscounts() { return postDiscounts; }
    public void setPostDiscounts(List<PostItem> postDiscounts) { this.postDiscounts = postDiscounts; }
    public TimeRange getTimeRange() { return timeRange; }
    public void setTimeRange(TimeRange timeRange) { this.timeRange = timeRange; }
    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }
    public SceneInfo getSceneInfo() { return sceneInfo; }
    public void setSceneInfo(SceneInfo sceneInfo) { this.sceneInfo = sceneInfo; }
    public RiskFund getRiskFund() { return riskFund; }
    public void setRiskFund(RiskFund riskFund) { this.riskFund = riskFund; }
    public Boolean getNeedUserConfirm() { return needUserConfirm; }
    public void setNeedUserConfirm(Boolean needUserConfirm) { this.needUserConfirm = needUserConfirm; }
    public String getGoodsTag() { return goodsTag; }
    public void setGoodsTag(String goodsTag) { this.goodsTag = goodsTag; }
    public String getPayscoreApplyToken() { return payscoreApplyToken; }
    public void setPayscoreApplyToken(String payscoreApplyToken) { this.payscoreApplyToken = payscoreApplyToken; }
    public String getAuthorizationCode() { return authorizationCode; }
    public void setAuthorizationCode(String authorizationCode) { this.authorizationCode = authorizationCode; }
    public String getSpOpenId() { return spOpenId; }
    public void setSpOpenId(String spOpenId) { this.spOpenId = spOpenId; }
}
