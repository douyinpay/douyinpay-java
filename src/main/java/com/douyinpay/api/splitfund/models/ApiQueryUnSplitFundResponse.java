package com.douyinpay.api.splitfund.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiQueryUnSplitFundResponse {

    /**
     * 字段含义：直连商户号。
     * 格式规则：字符串。
     * 业务规则：由抖音支付生成并下发。
     * 示例：6020240223833009
     */
    @SerializedName("mchid")
    private String merchantId;

    /**
     * 字段含义：抖音支付订单号。
     * 格式规则：字符串。
     * 业务规则：用于标识原支付订单。
     * 示例：21000125010103000993845301123
     */
    @SerializedName("transaction_id")
    private String transactionId;

    /**
     * 字段含义：剩余待分金额。
     * 格式规则：单位为分的整数。
     * 业务规则：表示订单当前剩余未分账的金额。
     * 示例：100
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
