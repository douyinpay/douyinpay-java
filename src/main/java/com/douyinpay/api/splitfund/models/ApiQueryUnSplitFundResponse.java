package com.douyinpay.api.splitfund.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiQueryUnSplitFundResponse {

    /**
     * 直连商户号
     */
    @SerializedName("mchid")
    private String merchantId;

    /**
     * 抖音支付订单号
     */
    @SerializedName("transaction_id")
    private String transactionId;

    /**
     * 订单剩余待分金额，单位为分
     */
    @SerializedName("unsplit_amount")
    private Integer unsplitAmount;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
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
