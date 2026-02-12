package com.douyinpay.api.partnerpayments.jsapi.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiQueryOrderByIdRequest {
    /* 支付订单号 */
    @SerializedName("transaction_id")
    private String transactionId;
    /* 服务商户号 */
    @SerializedName("sp_mchid")
    private String spMchid;
    /* 子商户号 */
    @SerializedName("sub_mchid")
    private String subMchid;

    public String getSpMchid() {
        return spMchid;
    }
    public String getSubMchid() {
        return subMchid;
    }
    public String getTransactionId() {
        return transactionId;
    }
    public void setSpMchid(String spMchid) {
        this.spMchid = spMchid;
    }
    public void setSubMchid(String subMchid) {
        this.subMchid = subMchid;
    }
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ApiQueryOrderByIdRequest{");
        sb.append("transactionId='").append(toIndentedString(transactionId)).append("', ");
        sb.append("spMchid='").append(toIndentedString(spMchid)).append("', ");
        sb.append("subMchid='").append(toIndentedString(subMchid));
        sb.append('}');
        return sb.toString();
    }
}
