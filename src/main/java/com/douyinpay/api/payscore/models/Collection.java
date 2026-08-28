package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

// 收款信息
public class Collection {
    // 字段含义：收款状态。
    // 格式规则：string。
    // 业务规则：枚举值：USER_PAYING：待支付；USER_PAID：已支付。
    // 示例：DOING。
    @SerializedName("state")
    private String state;
    // 字段含义：总收款金额。
    // 格式规则：int64。
    // 业务规则：必须≥0（单位：分）。
    // 示例：10000。
    @SerializedName("total_amount")
    private Integer totalAmount;
    // 字段含义：待收金额。
    // 格式规则：int64。
    // 业务规则：单位为分。
    // 示例：100。
    @SerializedName("paying_amount")
    private Integer payingAmount;
    // 字段含义：已收金额。
    // 格式规则：int64。
    // 业务规则：单位为分。
    // 示例：100。
    @SerializedName("paid_amount")
    private Integer paidAmount;
    // 字段含义：收款明细列表。
    // 格式规则：array。
    // 示例：[{"transaction_id":"TP2022101314262940644982204453","amount":100,"paid_type":"JSAPI","paid_time":"20220208060910"}]。
    @SerializedName("details")
    private List<CollectionDetail> details;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getPayingAmount() {
        return payingAmount;
    }

    public void setPayingAmount(Integer payingAmount) {
        this.payingAmount = payingAmount;
    }

    public Integer getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Integer paidAmount) {
        this.paidAmount = paidAmount;
    }

    public List<CollectionDetail> getDetails() {
        return details;
    }

    public void setDetails(List<CollectionDetail> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "state='" + state + '\'' +
                ", totalAmount=" + totalAmount +
                ", payingAmount=" + payingAmount +
                ", paidAmount=" + paidAmount +
                ", details=" + details +
                '}';
    }
}
