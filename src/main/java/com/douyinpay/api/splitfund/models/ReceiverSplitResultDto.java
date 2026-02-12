package com.douyinpay.api.splitfund.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ReceiverSplitResultDto {

    /**
     * 分账金额，单位为分，只能为整数，不能超过原订单支付金额及最大分账比例金额
     */
    @SerializedName("amount")
    private Integer amount;

    /**
     * 分账的原因描述，分账账单中需要体现
     */
    @SerializedName("description")
    private String description;

    /**
     * 1、MERCHANT_ID：商户号  2、PERSONAL_OPENID：个人openid（待确认）
     */
    @SerializedName("type")
    private SplitFundReceiverType type;

    /**
     * 分账接收方类型为MERCHANT_ID时，分账接收方账号为商户号
     */
    @SerializedName("account")
    private String account;

    /**
     * 枚举值：PENDING：待分账  2、SUCCESS：分账成功  3、CLOSED：已关闭
     */
    @SerializedName("result")
    private String result;

    /**
     * 分账失败原因，当分账结果result为CLOSED（已关闭）时，返回该字段
     */
    @SerializedName("fail_reason")
    private String failReason;

    /**
     * 分账创建时间，例如：2015-05-20T13:29:35+08:00表示，北京时间2015年5月20日 13点29分35秒
     */
    @SerializedName("create_time")
    private String createTime;

    /**
     * 分账完成时间
     */
    @SerializedName("finish_time")
    private String finishTime;

    /**
     * 抖音支付分账明细单号，每笔分账业务执行的明细单号，可与资金账单对账使用
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

    public SplitFundReceiverType getType() {
        return type;
    }

    public void setType(SplitFundReceiverType type) {
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
