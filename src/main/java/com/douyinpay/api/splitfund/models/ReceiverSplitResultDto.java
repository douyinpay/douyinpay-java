package com.douyinpay.api.splitfund.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ReceiverSplitResultDto {

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
     * 补充说明：该描述会在分账账单中体现。
     */
    @SerializedName("description")
    private String description;

    /**
     * 字段含义：分账接收方类型。
     * 格式规则：枚举字符串。
     * 业务规则：开放文档示例包含 MERCHANT_ID、PERSONAL_OPENID。
     * 示例：MERCHANT_ID
     * 补充说明：MERCHANT_ID 表示商户号，PERSONAL_OPENID 表示个人 OpenID。
     * @see com.douyinpay.enums.SplitFundReceiverTypeEnum
     */
    @SerializedName("type")
    private String type;

    /**
     * 字段含义：分账接收方账号。
     * 格式规则：字符串。
     * 业务规则：当类型为 MERCHANT_ID 时传商户号；当类型为 PERSONAL_OPENID 时传个人 OpenID。
     * 示例：6020260126898210
     */
    @SerializedName("account")
    private String account;

    /**
     * 字段含义：结果。
     * 格式规则：枚举字符串。
     * 业务规则：分账结果开放文档示例包含 PENDING、SUCCESS、CLOSED；回退结果请以接口文档枚举为准。
     * 示例：SUCCESS
     * 补充说明：PENDING 表示待分账，SUCCESS 表示分账成功，CLOSED 表示已关闭。
     */
    @SerializedName("result")
    private String result;

    /**
     * 字段含义：失败原因。
     * 格式规则：字符串。
     * 业务规则：当结果为关闭或失败时返回。
     * 示例：ACCOUNT_ABNORMAL
     * 补充说明：当分账结果 result 为 CLOSED 时返回该字段。
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

    /**
     * 字段含义：分账明细单号。
     * 格式规则：字符串。
     * 业务规则：可用于与资金账单进行对账。
     * 示例：11777200260111180300003115170066
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
