package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

// 后付费信息
public class PostItem {
    // 字段含义：付费名称。
    // 格式规则：string[1,20]。
    // 示例：服务费。
    @SerializedName("name")
    private String name;
    // 字段含义：付费金额。
    // 格式规则：int。
    // 业务规则：此付费项目总金额，必须≥0（单位分），等于0时代表不需要扣费。如果填写了name（付费名称），amount或description必须填写其一或都填。
    // 示例：100。
    @SerializedName("amount")
    private Integer amount;
    // 字段含义：付费说明。
    // 格式规则：string[1,30]。
    // 示例：服务费：100/小时。
    @SerializedName("description")
    private String description;
    // 字段含义：付费数量。
    // 格式规则：int。
    // 示例：100。
    @SerializedName("count")
    private Integer count;

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "PostItem{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", count=" + count +
                '}';
    }
}
