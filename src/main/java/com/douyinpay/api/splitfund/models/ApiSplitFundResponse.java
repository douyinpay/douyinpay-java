package com.douyinpay.api.splitfund.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiSplitFundResponse {

    /**
     * 抖音支付订单号
     */
    @SerializedName("transaction_id")
    private String tradeNo;

    /**
     * 商户分账单号
     */
    @SerializedName("out_order_no")
    private String outTradeNo;

    /**
     * 抖音支付分账单号
     */
    @SerializedName("order_id")
    private String orderId;

    /**
     * 直连商户号
     */
    @SerializedName("mchid")
    private String merchantId;

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
