package com.douyinpay.api.payments.h5.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

/**
 * ApiQueryOrderByIdRequest
 */
public class ApiQueryOrderByIdRequest {
    /**
     * 字段含义：抖音支付订单号。
     * 格式规则：字符串。
     * 业务规则：由抖音支付生成，用于标识支付订单。
     * 示例：21000125010103000993845301123
     */
    @SerializedName("transaction_id")
    @Expose(serialize = false)
    private String transactionId;
    /**
     * 字段含义：直连商户号。
     * 格式规则：字符串。
     * 业务规则：由抖音支付生成并下发，用于标识当前直连商户。
     * 示例：6020230307605084
     */
    @SerializedName("mchid")
    @Expose(serialize = false)
    private String mchid;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class QueryOrderByIdRequest {\n");
        sb.append("    transactionId: ").append(toIndentedString(transactionId)).append("\n");
        sb.append("    mchid: ").append(toIndentedString(mchid)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
