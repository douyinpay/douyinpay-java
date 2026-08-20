package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 直连服务商完结服务订单请求。
 */
public class ApiCompleteServiceOrderForSPRequest {
    /** 服务商商户号。 */
    @SerializedName("sp_mchid")
    private String spMchid;
    /** 服务商应用 ID。 */
    @SerializedName("sp_appid")
    private String spAppid;
    /** 子商户商户号。 */
    @SerializedName("sub_mchid")
    private String subMchid;
    /** 子商户应用 ID。 */
    @SerializedName("sub_appid")
    private String subAppid;
    /** 商户服务单号。 */
    @SerializedName("out_order_no")
    private String outOrderNo;
    /** 服务 ID。 */
    @SerializedName("service_id")
    private String serviceId;
    /** 服务总金额。 */
    @SerializedName("total_amount")
    private Long totalAmount;
    /** 商户透传数据。 */
    @SerializedName("attach")
    private String attach;
    /** 后付费项目。 */
    @SerializedName("post_payments")
    private List<PostItem> postPayments;
    /** 后付费优惠。 */
    @SerializedName("post_discounts")
    private List<PostItem> postDiscounts;
    /** 服务时间范围。 */
    @SerializedName("time_range")
    private TimeRange timeRange;
    /** 服务地点。 */
    @SerializedName("location")
    private Location location;
    /** 业务场景信息。 */
    @SerializedName("scene_info")
    private SceneInfo sceneInfo;
    /** 营销透传参数。 */
    @SerializedName("goods_tag")
    private String goodsTag;
    /** 扩展字段。 */
    @SerializedName("ext_info")
    private String extInfo;
    /** 支付渠道信息。 */
    @SerializedName("channel_info")
    private ChannelInfo channelInfo;

    public String getSpMchid() {
        return spMchid;
    }

    public void setSpMchid(String spMchid) {
        this.spMchid = spMchid;
    }

    public String getSpAppid() {
        return spAppid;
    }

    public void setSpAppid(String spAppid) {
        this.spAppid = spAppid;
    }

    public String getSubMchid() {
        return subMchid;
    }

    public void setSubMchid(String subMchid) {
        this.subMchid = subMchid;
    }

    public String getSubAppid() {
        return subAppid;
    }

    public void setSubAppid(String subAppid) {
        this.subAppid = subAppid;
    }

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
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

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }

    public ChannelInfo getChannelInfo() {
        return channelInfo;
    }

    public void setChannelInfo(ChannelInfo channelInfo) {
        this.channelInfo = channelInfo;
    }
}
