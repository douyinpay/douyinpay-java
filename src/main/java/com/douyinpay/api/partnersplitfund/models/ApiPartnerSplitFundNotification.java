package com.douyinpay.api.partnersplitfund.models;

import java.util.List;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiPartnerSplitFundNotification {
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
    private String tradeNo;

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

    /**
     * 字段含义：分账接收方列表。
     */
    @SerializedName("receivers")
    private List<PartnerReceiverSplitResultDto> receivers;

    /**
     * 字段含义：完结分账金额。
     */
    @SerializedName("finish_amount")
    private Integer finishAmount;

    /**
     * 字段含义：完结分账描述。
     */
    @SerializedName("finish_description")
    private String finishDescription;

    /**
     * 字段含义：完结分账时间。
     */
    @SerializedName(value = "split_finish_time", alternate = { "spilt_finish_time" })
    private String splitFinishTime;

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

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
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

    public List<PartnerReceiverSplitResultDto> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<PartnerReceiverSplitResultDto> receivers) {
        this.receivers = receivers;
    }

    public Integer getFinishAmount() {
        return finishAmount;
    }

    public void setFinishAmount(Integer finishAmount) {
        this.finishAmount = finishAmount;
    }

    public String getFinishDescription() {
        return finishDescription;
    }

    public void setFinishDescription(String finishDescription) {
        this.finishDescription = finishDescription;
    }

    public String getSplitFinishTime() {
        return splitFinishTime;
    }

    public void setSplitFinishTime(String splitFinishTime) {
        this.splitFinishTime = splitFinishTime;
    }

    @Override
    public String toString() {
        return GsonUtil.objectToJson(this);
    }
}
