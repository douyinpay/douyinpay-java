package com.douyinpay.api.partnersplitfund.models;

import com.douyinpay.enums.SplitFundReturnResultEnum;
import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiPartnerReturnSplitFundResponse {
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
     * 字段含义：抖音支付分账单号。
     */
    @SerializedName("order_id")
    private String orderId;

    /**
     * 字段含义：商户分账单号。
     */
    @SerializedName("out_order_no")
    private String outOrderNo;

    /**
     * 字段含义：商户回退单号。
     */
    @SerializedName("out_return_no")
    private String outReturnNo;

    /**
     * 字段含义：抖音支付回退单号。
     */
    @SerializedName("return_id")
    private String returnId;

    /**
     * 字段含义：回退商户号。
     */
    @SerializedName("return_mchid")
    private String returnMchid;

    /**
     * 字段含义：回退金额。
     */
    @SerializedName("amount")
    private Integer amount;

    /**
     * 字段含义：回退描述。
     */
    @SerializedName("description")
    private String description;

    /**
     * 字段含义：回退结果，PROCESSING 表示处理中，SUCCESS 表示已成功，FAILED 表示已失败。
     * @see SplitFundReturnResultEnum
     */
    @SerializedName("result")
    private String result;

    /**
     * 字段含义：失败原因。
     */
    @SerializedName("fail_reason")
    private String failReason;

    /**
     * 字段含义：创建时间。
     */
    @SerializedName("create_time")
    private String createTime;

    /**
     * 字段含义：完成时间。
     */
    @SerializedName("finish_time")
    private String finishTime;

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

    public String getReturnId() {
        return returnId;
    }

    public void setReturnId(String returnId) {
        this.returnId = returnId;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    @Override
    public String toString() {
        return GsonUtil.objectToJson(this);
    }
}
