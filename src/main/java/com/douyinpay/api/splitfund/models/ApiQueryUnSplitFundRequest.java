package com.douyinpay.api.splitfund.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiQueryUnSplitFundRequest {

    /**
     * 抖音支付订单号
     */
    @SerializedName("transaction_id")
    private String transactionId;

    /**
     * 直连商户号
     */
    @SerializedName("mchid")
    private String merchantId;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    @Override
    public String toString() {
        return GsonUtil.objectToJson(this);
    }
}
