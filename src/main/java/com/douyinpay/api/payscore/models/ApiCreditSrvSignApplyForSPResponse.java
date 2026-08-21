package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

/**
 * 直连服务商申请服务授权响应。
 */
public class ApiCreditSrvSignApplyForSPResponse {
    /** 先享后付申请token。 */
    @SerializedName("payscore_apply_token")
    private String payscoreApplyToken;

    public String getPayscoreApplyToken() {
        return payscoreApplyToken;
    }

    public void setPayscoreApplyToken(String payscoreApplyToken) {
        this.payscoreApplyToken = payscoreApplyToken;
    }
}
