package com.douyinpay.api.partnersplitfund.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class PartnerReceiverSplitResultDto {
    /**
     * 字段含义：分账金额。
     */
    @SerializedName("amount")
    private Integer amount;

    /**
     * 字段含义：分账描述。
     */
    @SerializedName("description")
    private String description;

    /**
     * 字段含义：分账接收方类型。
     */
    @SerializedName("type")
    private String type;

    /**
     * 字段含义：分账接收方账号。
     */
    @SerializedName("account")
    private String account;

    /**
     * 字段含义：分账结果，PENDING 表示待分账，SUCCESS 表示分账成功，CLOSED 表示已关闭。
     */
    @SerializedName("result")
    private String result;

    /**
     * 字段含义：分账失败原因。
     */
    @SerializedName("fail_reason")
    private String failReason;

    /**
     * 字段含义：分账创建时间。
     */
    @SerializedName("create_time")
    private String createTime;

    /**
     * 字段含义：分账完成时间。
     */
    @SerializedName("finish_time")
    private String finishTime;

    /**
     * 字段含义：分账明细单号。
     */
    @SerializedName("detail_id")
    private String detailId;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    @Override
    public String toString() {
        return GsonUtil.objectToJson(this);
    }
}
