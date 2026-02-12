package com.douyinpay.api.splitfund.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiSplitFundResponse {

    /**
     * 交易单号
     */
    @SerializedName("transaction_id")
    private String tradeNo;

    /**
     * 外部商户单号
     */
    @SerializedName("out_order_no")
    private String outTradeNo;

    /**
     * 抖音支付分账单号
     */
    @SerializedName("order_id")
    private String orderId;

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
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
