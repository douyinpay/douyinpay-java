package com.douyinpay.api.partnersplitfund.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiPartnerQueryUnSplitFundResponse {
    /**
     * 字段含义：服务商户号。
     */
    @SerializedName("sp_mchid")
    private String spMchid;

    /**
     * 字段含义：抖音支付订单号。
     */
    @SerializedName("transaction_id")
    private String transactionId;

    /**
     * 字段含义：订单剩余待分金额，单位为分。
     */
    @SerializedName("unsplit_amount")
    private Integer unsplitAmount;

    public String getSpMchid() {
        return spMchid;
    }

    public void setSpMchid(String spMchid) {
        this.spMchid = spMchid;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getUnsplitAmount() {
        return unsplitAmount;
    }

    public void setUnsplitAmount(Integer unsplitAmount) {
        this.unsplitAmount = unsplitAmount;
    }

    @Override
    public String toString() {
        return GsonUtil.objectToJson(this);
    }
}
