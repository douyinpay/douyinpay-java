package com.douyinpay.api.splitfund.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ReceiverInfoDto {

    /**
     * 字段含义：分账接收方类型。
     * 格式规则：枚举字符串。
     * 业务规则：开放文档示例包含 MERCHANT_ID、PERSONAL_OPENID。
     * 示例：MERCHANT_ID
     * 补充说明：MERCHANT_ID 表示商户号，PERSONAL_OPENID 表示个人 OpenID。
     *
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
     * 字段含义：分账接收方全称。
     * 格式规则：字符串。
     * 业务规则：商户类型接收方传商户名称；个人类型接收方可传姓名，且需满足实名匹配校验。
     * 补充说明：个人姓名传入后会进行实名匹配校验。
     * 示例：分账接收方名称
     */
    @SerializedName("name")
    private String name;

    /**
     * 字段含义：分账金额。
     * 格式规则：单位为分的整数。
     * 业务规则：不能超过原订单支付金额及最大分账比例金额。
     * 示例：10
     */
    @SerializedName("amount")
    private Integer amount;

    /**
     * 字段含义：描述。
     * 格式规则：字符串。
     * 业务规则：用于说明分账、回退或完结分账的原因。
     * 补充说明：该描述会在分账账单中体现。
     * 示例：分给合作方
     */
    @SerializedName("description")
    private String description;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
