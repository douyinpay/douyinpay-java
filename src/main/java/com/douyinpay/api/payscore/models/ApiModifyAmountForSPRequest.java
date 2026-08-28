package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 直连服务商修改订单金额请求。
 */
public class ApiModifyAmountForSPRequest {
    // 字段含义：服务商商户号。
    // 格式规则：string[1,32]。
    // 业务规则：服务商的商户号，由抖音支付生成并下发。
    // 示例：6020230307605084。
    @SerializedName("sp_mchid")
    private String spMchid;
    // 字段含义：服务商应用ID。
    // 格式规则：string[1,32]。
    // 业务规则：由抖音支付生成的应用ID，全局唯一。
    // 示例：awofz9bncda6w2w4。
    @SerializedName("sp_appid")
    private String spAppid;
    // 字段含义：子商户商户号。
    // 格式规则：string[1,32]。
    // 业务规则：子商户的商户号，由抖音支付生成并下发。
    // 示例：6020230307605085。
    @SerializedName("sub_mchid")
    private String subMchid;
    // 字段含义：子商户应用ID。
    // 格式规则：string[1,32]。
    // 业务规则：由抖音支付生成的应用ID，全局唯一。
    // 示例：awofz9bncda6w2w4。
    @SerializedName("sub_appid")
    private String subAppid;
    // 字段含义：商户服务单号。
    // 格式规则：string，只能是数字、大小写字母_-*。
    // 业务规则：商户系统内部服务订单号，在同一个商户号下唯一。
    // 示例：OUT_1666688488。
    @SerializedName("out_order_no")
    private String outOrderNo;
    // 字段含义：服务ID。
    // 格式规则：string[1,32]。
    // 业务规则：业务接入时分配，用于配置商户和场景维度信息。
    // 示例：101。
    @SerializedName("service_id")
    private String serviceId;
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
    // 字段含义：订单总金额。
    // 格式规则：int64。
    // 业务规则："1. 金额：数字，必须≥0（单位：分） 2. 总金额 =（完结付费项目1…+完结付费项目n）-（完结商户优惠项目1…+完结商户优惠项目n） "。
    // 示例：10000。
    @SerializedName("total_amount")
    private Integer totalAmount;
    // 字段含义：解约原因。
    // 格式规则：string[1, 50]。
    // 示例：用户取消。
    @SerializedName("reason")
    private String reason;

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
}
