package com.douyinpay.api.partnerpayments.common;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiTransaction {
    /* 服务商户号 */
    @SerializedName("sp_mchid")
    private String spMchid;
    /* 服务商应用ID */
    @SerializedName("sp_appid")
    private String spAppid;
    /* 子商户号 */
    @SerializedName("sub_mchid")
    private String subMchid;
    /* 子商户应用ID */
    @SerializedName("sub_appid")
    private String subAppid;
    /* 订单金额 */
    @SerializedName("amount")
    private ApiTransactionAmount amount;
    /* 附加数据 */
    @SerializedName("attach")
    private String attach;
    /* 付款银行 */
    @SerializedName("bank_type")
    private String bankType;
    /* 商户订单号 */
    @SerializedName("out_trade_no")
    private String outTradeNo;
    /* 支付者 */
    @SerializedName("payer")
    private ApiTransactionPayer payer;
    /* 优惠功能 */
    @SerializedName("promotion_detail")
    private List<ApiPromotionDetail> promotionDetail;
    /* 支付完成时间 */
    @SerializedName("success_time")
    private String successTime;
    /* 交易状态 */
    @SerializedName("trade_state")
    private String tradeState;
    /* 交易状态描述 */
    @SerializedName("trade_state_desc")
    private String tradeStateDesc;
    /* 交易类型 */
    @SerializedName("trade_type")
    private String tradeType;
    /* 抖音支付订单号 */
    @SerializedName("transaction_id")
    private String transactionId;
    /*场景信息 */
    @SerializedName("scene_info")
    private ApiSceneInfo sceneInfo;

    public String getSpMchid() {
        return spMchid;
    }

    public void setSpMchid(String spMchid) {
        this.spMchid = spMchid;
    }

    public String getSpAppid() {
        return spAppid;
    }

    public void setSpAppid(String spAppid) {
        this.spAppid = spAppid;
    }

    public String getSubMchid() {
        return subMchid;
    }

    public void setSubMchid(String subMchid) {
        this.subMchid = subMchid;
    }

    public String getSubAppid() {
        return subAppid;
    }

    public void setSubAppid(String subAppid) {
        this.subAppid = subAppid;
    }

    public ApiTransactionAmount getAmount() {
        return amount;
    }

    public void setAmount(ApiTransactionAmount amount) {
        this.amount = amount;
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

    public String getTradeState() {
        return tradeState;
    }

    public void setTradeState(String tradeState) {
        this.tradeState = tradeState;
    }

    public String getTradeStateDesc() {
        return tradeStateDesc;
    }

    public void setTradeStateDesc(String tradeStateDesc) {
        this.tradeStateDesc = tradeStateDesc;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
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

