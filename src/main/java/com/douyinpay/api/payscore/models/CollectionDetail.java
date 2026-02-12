package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

// 收款明细
public class CollectionDetail {
    /**
     * 抖音支付交易单号
     */
    @SerializedName("transaction_id")
    private String transactionId;
    /**
     * 单笔收款金额
     */
    @SerializedName("amount")
    private Integer amount;
    /**
     * 收款成功渠道
     */
    @SerializedName("paid_type")
    private String paidType;
    /**
     * 收款成功时间
     */
    @SerializedName("paid_time")
    private String paidTime;
    /**
     * 收款银行
     */
    @SerializedName("bank_type")
    private String bankType;
    /**
     * 收款银行
     */
    @SerializedName("promotion_detail")
    private List<PromotionDetail> promotionDetail;


    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getPaidType() {
        return paidType;
    }

    public void setPaidType(String paidType) {
        this.paidType = paidType;
    }

    public String getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(String paidTime) {
        this.paidTime = paidTime;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public List<PromotionDetail> getPromotionDetail() {
        return promotionDetail;
    }

    public void setPromotionDetail(List<PromotionDetail> promotionDetail) {
        this.promotionDetail = promotionDetail;
    }

    @Override
    public String toString() {
        return "CollectionDetail{" +
                "transactionId='" + transactionId + '\'' +
                ", amount=" + amount +
                ", paidType='" + paidType + '\'' +
                ", paidTime='" + paidTime + '\'' +
                ", bankType='" + bankType + '\'' +
                ", promotionDetail=" + promotionDetail +
                '}';
    }
}
