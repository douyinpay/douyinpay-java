package com.douyinpay.api.partnerpayments.h5.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiQueryOrderByIdRequest {
    /**
     * 支付订单号
     */
    @SerializedName("transaction_id")
    @Expose(serialize = false)
    private String transactionId;
    /**
     * 服务商户号
     */
    @SerializedName("sp_mchid")
    private String spMchid;
    /**
     * 子商户号
     */
    @SerializedName("sub_mchid")
    private String subMchid;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
    /**
     * 服务商户号
     */
    public String getSpMchid() {
        return spMchid;
    }

    /**
     * 服务商户号
     */
    public void setSpMchid(String spMchid) {
        this.spMchid = spMchid;
    }
    /**
     * 子商户号
     */
    public String getSubMchid() {
        return subMchid;
    }

    /**
     * 子商户号
     */
    public void setSubMchid(String subMchid) {
        this.subMchid = subMchid;
    }

    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class QueryOrderByIdRequest {\n");
        sb.append("    transactionId: ").append(toIndentedString(transactionId)).append("\n");
        sb.append("    spMchid: ").append(toIndentedString(spMchid)).append("\n");
        sb.append("    subMchid: ").append(toIndentedString(subMchid)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
