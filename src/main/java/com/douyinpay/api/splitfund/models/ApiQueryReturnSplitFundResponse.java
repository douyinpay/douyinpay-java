package com.douyinpay.api.splitfund.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiQueryReturnSplitFundResponse {

    /**
     * 字段含义：抖音支付分账单号。
     * 格式规则：字符串。
     * 业务规则：由抖音支付生成，用于标识分账单。
     * 示例：11777200250103110500000223502022
     */
    @SerializedName("order_id")
    private String orderId;

    /**
     * 字段含义：商户分账单号。
     * 格式规则：仅支持数字、大小写字母、_、-、*。
     * 业务规则：用于标识商户侧的分账单。
     * 示例：OUT_1666688488
     */
    @SerializedName("out_order_no")
    private String outOrderNo;

    /**
     * 字段含义：商户回退单号。
     * 格式规则：字符串。
     * 业务规则：用于标识商户侧的分账回退单。
     * 示例：RETURN_1666688488
     */
    @SerializedName("out_return_no")
    private String outReturnNo;

    /**
     * 字段含义：抖音支付回退单号。
     * 格式规则：字符串。
     * 业务规则：由抖音支付生成，用于标识分账回退单。
     * 示例：1200000000000001
     */
    @SerializedName("return_id")
    private String returnId;

    /**
     * 字段含义：回退商户号。
     * 格式规则：字符串。
     * 业务规则：表示分账回退资金的接收商户号。
     * 示例：6020240223833009
     */
    @SerializedName("return_mchid")
    private String returnMchid;

    /**
     * 字段含义：金额。
     * 格式规则：单位为分的整数。
     * 业务规则：具体语义取决于所在结构，可能表示分账金额、回退金额或完结金额。
     * 示例：10
     */
    @SerializedName("amount")
    private Integer amount;

    /**
     * 字段含义：描述。
     * 格式规则：字符串。
     * 业务规则：用于说明分账、回退或完结分账的原因。
     * 示例：分给合作方
     */
    @SerializedName("description")
    private String description;

    /**
     * 字段含义：结果。
     * 格式规则：枚举字符串。
     * 业务规则：分账结果开放文档示例包含 PENDING、SUCCESS、CLOSED；回退结果请以接口文档枚举为准。
     * 示例：SUCCESS
     * @see com.douyinpay.enums.SplitFundReturnResultEnum
     */
    @SerializedName("result")
    private String result;

    /**
     * 字段含义：失败原因。
     * 格式规则：字符串。
     * 业务规则：当结果为关闭或失败时返回。
     * 示例：ACCOUNT_ABNORMAL
     */
    @SerializedName("fail_reason")
    private String failReason;

    /**
     * 字段含义：创建时间。
     * 格式规则：遵循 RFC 3339 标准格式。
     * 业务规则：表示分账或回退单的创建时间。
     * 示例：2015-05-20T13:29:35+08:00
     */
    @SerializedName("create_time")
    private String createTime;

    /**
     * 字段含义：完成时间。
     * 格式规则：遵循 RFC 3339 标准格式。
     * 业务规则：表示分账或回退完成时间。
     * 示例：2015-05-20T13:29:35+08:00
     */
    @SerializedName("finish_time")
    private String finishTime;

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
