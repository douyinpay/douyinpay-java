package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 直连服务商查询服务订单响应。
 */
public class ApiQueryServiceOrderForSPResponse {
    // 字段含义：子商户应用ID。
    // 格式规则：string。
    // 业务规则：由抖音支付生成的应用ID，全局唯一。
    // 示例：awofz9bncda6w2w4。
    @SerializedName("sub_appid") private String subAppid;
    // 字段含义：子商户商户号。
    // 格式规则：string。
    // 业务规则：子商户的商户号，由抖音支付生成并下发。
    // 示例：6020230307605085。
    @SerializedName("sub_mchid") private String subMchid;
    // 字段含义：服务商商户号。
    // 格式规则：string。
    // 业务规则：服务商的商户号，由抖音支付生成并下发。
    // 示例：6020230307605084。
    @SerializedName("sp_mchid") private String spMchid;
    // 字段含义：服务商应用ID。
    // 格式规则：string。
    // 业务规则：由抖音支付生成的应用ID，全局唯一。
    // 示例：awofz9bncda6w2w4。
    @SerializedName("sp_appid") private String spAppid;
    // 字段含义：商户服务单号。
    // 格式规则：string，只能是数字、大小写字母_-*。
    // 业务规则：商户系统内部服务订单号，在同一个商户号下唯一。
    // 示例：OUT_1666688488。
    @SerializedName("out_order_no") private String outOrderNo;
    // 字段含义：服务ID。
    // 格式规则：string。
    // 业务规则：业务接入时分配，用于配置商户和场景维度信息。
    // 示例：101。
    @SerializedName("service_id") private String serviceId;
    // 字段含义：服务信息。
    // 格式规则：string。
    // 业务规则：服务信息，用于介绍本订单所提供的服务。
    // 示例：某某酒店。
    @SerializedName("service_introduction") private String serviceIntroduction;
    // 字段含义：抖音支付服务订单号。
    // 格式规则：string。
    // 业务规则：每个抖音支付服务订单号与商户号下对应的商户服务订单号一一对应。
    // 示例：10050100220208060900000023310957。
    @SerializedName("order_id") private String orderId;
    // 字段含义：服务订单状态。
    // 格式规则：string。
    // 业务规则：枚举值：CREATED表示商户已创建服务订单；DOING表示服务订单进行中；DONE表示服务订单完成；REVOKED表示商户取消服务订单；EXPIRED表示服务订单已失效。
    // 示例：DOING。
    @SerializedName("state") private String state;
    // 字段含义：订单状态说明。
    // 格式规则：string。
    // 业务规则：对服务订单“进行中”状态的附加说明：MCH_COMPLETE: 商户完结；USER_PAYING: 用户支付中；USER_CONFIRM: 用户已确认。
    // 示例：USER_PAYING。
    @SerializedName("state_description") private String stateDescription;
    // 字段含义：订单总金额。
    // 格式规则：int64。
    // 业务规则："1. 金额：数字，必须≥0（单位：分） 2. 总金额 =（完结付费项目1…+完结付费项目n）-（完结商户优惠项目1…+完结商户优惠项目n） "。
    // 示例：10000。
    @SerializedName("total_amount")
    private String totalAmount;
    // 字段含义：服务风险金。
    // 格式规则：object。
    // 示例：{"name":"ESTIMATE_ORDER_COST","amount":10000,"description":"预估订单费用"}。
    @SerializedName("risk_fund") private RiskFund riskFund;
    // 字段含义：服务商商户下用户标识。
    // 格式规则：string。
    // 业务规则：用户在服务商户对应appid下的唯一标识。传入appid，未传入sub_appid时返回。
    // 示例：示例：oUpF8uMuAJO_M2pxb1Q9zNjWeS6o。。
    @SerializedName("sp_openid") private String spOpenId;
    // 字段含义：商户数据包。
    // 格式规则：string。
    // 示例：{"out_product_category":"BATTERY_CHANGE"}。
    @SerializedName("attach") private String attach;
    // 字段含义：通知地址。
    // 格式规则：string，必须为https地址。请确保回调URL是外部可正常访问的，且不能携带后缀参数。
    // 示例：https://www.bytedance.com。
    @SerializedName("notify_url") private String notifyUrl;
    // 字段含义：收款信息。
    // 格式规则：object。
    // 示例：{"state":"PROCESSING","total_amount":10000,"paying_amount":10000,"paid_amount":0,"details":[]}。
    @SerializedName("collection") private Collection collection;
    // 字段含义：后付费项目。
    // 格式规则：array。
    // 示例：[{"name":"出行费用","amount":4000,"description":"美味餐厅","count":1}]。
    @SerializedName("post_payments") private List<PostItem> postPayments;
    // 字段含义：商户优惠。
    // 格式规则：array。
    // 示例：[{"name":"满20减1元","amount":100,"description":"美味餐厅","count":1}]。
    @SerializedName("post_discounts") private List<PostItem> postDiscounts;
    // 字段含义：实际服务时间段。
    // 格式规则：object。
    // 示例：{"start_time":"20220208060910","end_time":"20220208060920","start_time_remark":"备注1","end_time_remark":"备注2"}。
    @SerializedName("time_range") private TimeRange timeRange;
    // 字段含义：服务位置。
    // 格式规则：object。
    // 示例：{"start_location":"美味餐厅","end_location":"美味餐厅"}。
    @SerializedName("location") private Location location;
    // 字段含义：场景信息。
    // 格式规则：object。
    // 示例：{"client_ip":"14.23.150.211","device_id":"13467007045764","store_info":{"id":"1089"}}。
    @SerializedName("scene_info") private SceneInfo sceneInfo;
    // 字段含义：商户协议号。
    // 格式规则：string。
    // 业务规则：商户侧生成的协议号，在同一个商户号下唯一。
    // 示例：1736173225954193889。
    @SerializedName("authorization_code") private String authorizationCode;
    // 字段含义：子商户下用户标识。
    // 格式规则：string。
    // 业务规则：用户在子商户对应appid下的唯一标识，sub_appid传入时返回。
    // 示例：oUpF8uMuAJO_M2pxb1Q9zNjWeS6o。
    @SerializedName("sub_openid") private String subOpenId;

    public String getSubAppid() { return subAppid; }
    public void setSubAppid(String subAppid) { this.subAppid = subAppid; }
    public String getSubMchid() { return subMchid; }
    public void setSubMchid(String subMchid) { this.subMchid = subMchid; }
    public String getSpMchid() { return spMchid; }
    public void setSpMchid(String spMchid) { this.spMchid = spMchid; }
    public String getSpAppid() { return spAppid; }
    public void setSpAppid(String spAppid) { this.spAppid = spAppid; }
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
    public RiskFund getRiskFund() { return riskFund; }
    public void setRiskFund(RiskFund riskFund) { this.riskFund = riskFund; }
    public String getSpOpenId() { return spOpenId; }
    public void setSpOpenId(String spOpenId) { this.spOpenId = spOpenId; }
    public String getAttach() { return attach; }
    public void setAttach(String attach) { this.attach = attach; }
    public String getNotifyUrl() { return notifyUrl; }
    public void setNotifyUrl(String notifyUrl) { this.notifyUrl = notifyUrl; }
    public Collection getCollection() { return collection; }
    public void setCollection(Collection collection) { this.collection = collection; }
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
    public String getAuthorizationCode() { return authorizationCode; }
    public void setAuthorizationCode(String authorizationCode) { this.authorizationCode = authorizationCode; }
    public String getSubOpenId() { return subOpenId; }
    public void setSubOpenId(String subOpenId) { this.subOpenId = subOpenId; }
    public String getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
}
