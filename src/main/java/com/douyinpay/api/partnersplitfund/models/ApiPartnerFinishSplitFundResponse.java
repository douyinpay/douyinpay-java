package com.douyinpay.api.partnersplitfund.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiPartnerFinishSplitFundResponse {
    /**
     * 字段含义：服务商户号。
     */
    @SerializedName("sp_mchid")
    private String spMchid;

    /**
     * 字段含义：特约商户号。
     */
    @SerializedName("sub_mchid")
    private String subMchid;

    /**
     * 字段含义：抖音支付订单号。
     */
    @SerializedName("transaction_id")
    private String transactionId;

    /**
     * 字段含义：商户分账单号。
     */
    @SerializedName("out_order_no")
    private String outOrderNo;

    /**
     * 字段含义：抖音支付分账单号。
     */
    @SerializedName("order_id")
    private String orderId;

    /**
     * 字段含义：分账单状态，PROCESSING 表示处理中，FINISHED 表示分账完成。
     */
    @SerializedName("state")
    private String state;

    public String getSpMchid() {
        return spMchid;
    }

    public void setSpMchid(String spMchid) {
        this.spMchid = spMchid;
    }

    public String getSubMchid() {
        return subMchid;
    }

    public void setSubMchid(String subMchid) {
        this.subMchid = subMchid;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return GsonUtil.objectToJson(this);
    }
}
