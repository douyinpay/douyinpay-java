package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

// 后付费信息
public class PostItem {
    @SerializedName("name")
    private String name;
    @SerializedName("amount")
    private Integer amount;
    @SerializedName("description")
    private String description;
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
