package com.douyinpay.api.splitfund.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiReturnSplitFundRequest {

    /**
     * 直连商户号
     */
    @SerializedName("mchid")
    private String merchantId;

    /**
     * 抖音支付分账单号
     */
    @SerializedName("order_id")
    private String orderId;

    /**
     * 商户分账单号
     */
    @SerializedName("out_order_no")
    private String outOrderNo;

    /**
     * 商户回退单号
     */
    @SerializedName("out_return_no")
    private String outReturnNo;

    /**
     * 回退商户号
     */
    @SerializedName("return_mchid")
    private String returnMchid;

    /**
     * 回退金额，单位为分
     */
    @SerializedName("amount")
    private Integer amount;

    /**
     * 回退描述
     */
    @SerializedName("description")
    private String description;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public String getOutReturnNo() {
        return outReturnNo;
    }

    public void setOutReturnNo(String outReturnNo) {
        this.outReturnNo = outReturnNo;
    }

    public String getReturnMchid() {
        return returnMchid;
    }

    public void setReturnMchid(String returnMchid) {
        this.returnMchid = returnMchid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return GsonUtil.objectToJson(this);
    }
}
