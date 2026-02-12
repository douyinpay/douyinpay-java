package com.douyinpay.api.deduct.models;

import com.douyinpay.enums.TradeStatusEnum;
import com.douyinpay.enums.TradeTypeEnum;
import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * ApiTransaction
 */
public class ApiTransaction {
    /**
     * amount
     */
    @SerializedName("amount")
    private ApiTransactionAmount amount;
    /**
     * appid
     */
    @SerializedName("appid")
    private String appid;
    /**
     * attach
     */
    @SerializedName("attach")
    private String attach;
    /**
     * bankType
     */
    @SerializedName("bank_type")
    private String bankType;
    /**
     * mchid
     */
    @SerializedName("mchid")
    private String mchid;
    /**
     * outTradeNo
     */
    @SerializedName("out_trade_no")
    private String outTradeNo;
    /**
     * payer
     */
    @SerializedName("payer")
    private ApiTransactionPayer payer;
    /**
     * promotionDetail
     */
    @SerializedName("promotion_detail")
    private List<ApiPromotionDetail> promotionDetail;
    /**
     * successTime
     */
    @SerializedName("success_time")
    private String successTime;

    /**
     * @see TradeStatusEnum
     */
    @SerializedName("trade_state")
    private String tradeState;
    /**
     * tradeStateDesc
     */
    @SerializedName("trade_state_desc")
    private String tradeStateDesc;

    /**
     * @see TradeTypeEnum
     */
    @SerializedName("trade_type")
    private String tradeType;
    /**
     * transactionId
     */
    @SerializedName("transaction_id")
    private String transactionId;

    public ApiTransactionAmount getAmount() {
        return amount;
    }

    public void setAmount(ApiTransactionAmount amount) {
        this.amount = amount;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public ApiTransactionPayer getPayer() {
        return payer;
    }

    public void setPayer(ApiTransactionPayer payer) {
        this.payer = payer;
    }

    public List<ApiPromotionDetail> getPromotionDetail() {
        return promotionDetail;
    }

    public void setPromotionDetail(List<ApiPromotionDetail> promotionDetail) {
        this.promotionDetail = promotionDetail;
    }

    public String getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(String successTime) {
        this.successTime = successTime;
    }

    public void setTradeState(String tradeState) {
        this.tradeState = tradeState;
    }
    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getTradeStateDesc() {
        return tradeStateDesc;
    }

    public void setTradeStateDesc(String tradeStateDesc) {
        this.tradeStateDesc = tradeStateDesc;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return GsonUtil.getGson().toJson(this);
    }
}

