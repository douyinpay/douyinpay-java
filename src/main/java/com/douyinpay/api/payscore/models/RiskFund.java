package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

// 服务风险金
public class RiskFund {
    // 字段含义：风险金名称。
    // 格式规则：string[1,30]。
    // 业务规则：枚举值：DEPOSIT：押金；ADVANCE：预付款；CASH_DEPOSIT：保证金；ESTIMATE_ORDER_COST：预估订单费用。
    // 示例：ESTIMATE_ORDER_COST。
    @SerializedName("name")
    private String name;
    // 字段含义：风险金额。
    // 格式规则：int。
    // 业务规则：1、数字，必须>0（单位分）2、风险金额≤每个服务ID的风险金额上限 3、当商户优惠字段为空时，付费项目总金额≤服务ID的风险金额上限。
    // 示例：100。
    @SerializedName("amount")
    private Integer amount;
    // 字段含义：风险说明。
    // 格式规则：string[1,30]。
    // 示例：服务费：100/小时。
    @SerializedName("description")
    private String description;

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
        return "RiskFund{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
