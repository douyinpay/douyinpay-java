package com.douyinpay.api.splitfund.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiReturnSplitFundResponse {

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
     * 抖音支付回退单号
     */
    @SerializedName("return_id")
    private String returnId;

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

    /**
     * 回退结果
     */
    @SerializedName("result")
    private String result;

    /**
     * 失败原因
     */
    @SerializedName("fail_reason")
    private String failReason;

    /**
     * 创建时间
     */
    @SerializedName("create_time")
    private String createTime;

    /**
     * 完成时间
     */
    @SerializedName("finish_time")
    private String finishTime;

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
