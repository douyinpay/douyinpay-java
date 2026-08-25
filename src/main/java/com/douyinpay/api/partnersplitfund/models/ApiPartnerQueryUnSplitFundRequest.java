package com.douyinpay.api.partnersplitfund.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiPartnerQueryUnSplitFundRequest {
    /**
     * 字段含义：抖音支付订单号。
     * 格式规则：字符串，长度为 1-32 位。
     * 业务规则：用于定位需要查询剩余待分金额的交易订单。
     * 示例：TP2022101317144741443210681000
     */
    @SerializedName("transaction_id")
    private String transactionId;

    /**
     * 字段含义：服务商户号。
     * 格式规则：字符串，长度为 1-32 位。
     * 业务规则：由抖音支付生成并下发，用于标识服务商主体。
     * 示例：6000000000000001
     */
    @SerializedName("sp_mchid")
    private String spMchid;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getSpMchid() {
        return spMchid;
    }

    public void setSpMchid(String spMchid) {
        this.spMchid = spMchid;
    }

    @Override
    public String toString() {
        return GsonUtil.objectToJson(this);
    }
}
