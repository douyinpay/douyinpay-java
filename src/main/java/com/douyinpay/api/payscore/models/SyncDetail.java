package com.douyinpay.api.payscore.models;


import com.google.gson.annotations.SerializedName;

/**
 * 服务订单同步详情。
 */
public class SyncDetail {
    // 字段含义：收款完成时间。
    // 格式规则：string[14]。
    // 示例：20220208060910。
    @SerializedName("paid_time")
    private String paidTime;

    public String getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(String paidTime) {
        this.paidTime = paidTime;
    }

    @Override
    public String toString() {
        return "SyncDetail{" +
                "paidTime='" + paidTime + '\'' +
                '}';
    }
}
