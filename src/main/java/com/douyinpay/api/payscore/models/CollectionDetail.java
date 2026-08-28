package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

// 收款明细
public class CollectionDetail {
    // 字段含义：抖音支付交易单号。
    // 格式规则：string。
    // 业务规则：抖音支付交易单号，等于普通支付接口中的transaction_id，可以使用该订单号进行查询订单、申请退款操作。只有单据状态为USER_PAID，且收款成功渠道为抖音支付渠道, 收款金额大于0，才会返回该交易单号。
    // 示例：1001。
    @SerializedName("transaction_id")
    private String transactionId;
    // 字段含义：单笔收款金额。
    // 格式规则：int。
    // 示例：100。
    @SerializedName("amount")
    private Integer amount;
    // 字段含义：收款成功渠道。
    // 格式规则：string。
    // 业务规则：枚举值：抖音支付：DOUYINPAY；商户渠道：MCH。
    // 示例：DOUYINPAY。
    @SerializedName("paid_type")
    private String paidType;
    // 字段含义：收款成功时间。
    // 格式规则：string。
    // 示例：20220208060910。
    @SerializedName("paid_time")
    private String paidTime;
    // 字段含义：收款银行。
    // 格式规则：string。
    // 业务规则：银行类型，采用字符串类型的银行标识。默认不返回，若需获取具体信息请联系抖音支付运营。
    // 示例：ICBC。
    @SerializedName("bank_type")
    private String bankType;
    // 字段含义：优惠信息。
    // 格式规则：array。
    // 示例：[{"coupon_id":"109519","name":"满20减1元","scope":"GLOBAL","type":"CASH","amount":100,"currency":"CNY"}]。
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
