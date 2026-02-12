package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

// 服务风险金
public class RiskFund {
    // 风险金名称
    @SerializedName("name")
    private String name;
    // 风险金额
    @SerializedName("amount")
    private Integer amount;
    // 风险说明
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
