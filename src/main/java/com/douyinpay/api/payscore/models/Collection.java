package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

// 收款信息
public class Collection {
    /**
     * 收款状态
     */
    @SerializedName("state")
    private String state;
    /**
     * 总收款金额
     */
    @SerializedName("total_amount")
    private Integer totalAmount;
    /**
     * 待收款金额
     */
    @SerializedName("paying_amount")
    private Integer payingAmount;
    /**
     * 已收款金额
     */
    @SerializedName("paid_amount")
    private Integer paidAmount;
    /**
     * 收款明细列表
     */
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
