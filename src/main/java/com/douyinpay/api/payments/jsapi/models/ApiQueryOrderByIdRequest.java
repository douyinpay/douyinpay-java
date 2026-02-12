package com.douyinpay.api.payments.jsapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

/**
 * ApiQueryOrderByIdRequest
 */
public class ApiQueryOrderByIdRequest {
    /**
     * transactionId
     */
    @SerializedName("transaction_id")
    @Expose(serialize = false)
    private String transactionId;
    /**
     * mchid 说明：直连商户号
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
