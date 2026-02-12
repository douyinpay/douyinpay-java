package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

public class ApiCreditSrvSignApplyResponse {
    /**
     * 先享后付申请token
     */
    @SerializedName("payscore_apply_token")
    private String payscoreApplyToken;

    public String getPayscoreApplyToken() {
        return payscoreApplyToken;
    }

    public void setPayscoreApplyToken(String payscoreApplyToken) {
        this.payscoreApplyToken = payscoreApplyToken;
    }

    @Override
    public String toString() {
        return "ApiCreditSrvSignApplyResponse{" +
                "payscoreApplyToken='" + payscoreApplyToken + '\'' +
                '}';
    }
}
