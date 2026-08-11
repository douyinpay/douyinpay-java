package com.douyinpay.api.deduct.models;

import com.google.gson.annotations.SerializedName;

public class EstimatedAmount {
    /**
     * 字段含义：预计扣费金额。
     * 格式规则：整型，单位为分。
     * 业务规则：表示预约扣费通知中的预计扣费金额。
     * 示例：
     */
    @SerializedName("amount")
    private int amount;
    /**
     * 字段含义：货币种类。
     * 格式规则：字符串。
     * 业务规则：当前文档未单独展开该字段规则，预计扣费金额场景下通常表示币种信息。
     * 示例：
     */
    @SerializedName("currency")
    private String currency;

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("EstimatedAmount{")
                .append("amount=").append(amount)
                .append(", currency='").append(currency).append('\'')
                .append('}');
        return sb.toString();
    }
}
