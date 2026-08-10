package com.douyinpay.api.splitfund.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiFinishSplitFundResponse {

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
     * 字段含义：商户分账单号。
     * 格式规则：仅支持数字、大小写字母、_、-、*。
     * 业务规则：用于标识商户侧的分账单。
     * 示例：OUT_1666688488
     */
    @SerializedName("out_order_no")
    private String outOrderNo;

    /**
     * 字段含义：抖音支付分账单号。
     * 格式规则：字符串。
     * 业务规则：由抖音支付生成，用于标识分账单。
     * 示例：11777200250103110500000223502022
     */
    @SerializedName("order_id")
    private String orderId;

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

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return GsonUtil.objectToJson(this);
    }
}
