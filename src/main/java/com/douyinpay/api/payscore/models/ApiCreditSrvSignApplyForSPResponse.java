package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

/**
 * 直连服务商申请服务授权响应。
 */
public class ApiCreditSrvSignApplyForSPResponse {
    // 字段含义：先享后付申请token。
    // 格式规则：string。
    // 示例：5778aadY9nlt1234XixCkFIGYnV2V。
    @SerializedName("payscore_apply_token")
    private String payscoreApplyToken;

    public String getPayscoreApplyToken() {
        return payscoreApplyToken;
    }

    public void setPayscoreApplyToken(String payscoreApplyToken) {
        this.payscoreApplyToken = payscoreApplyToken;
    }
}
