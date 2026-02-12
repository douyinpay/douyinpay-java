package com.douyinpay.api.payscore.models;


import com.google.gson.annotations.SerializedName;

public class SyncDetail {
    /**
     * 支付时间
     */
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
