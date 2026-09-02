package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

/**
 * 申请先享后付服务授权响应。
 */
public class ApiCreditSrvSignApplyResponse {
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

    @Override
    public String toString() {
        return "ApiCreditSrvSignApplyResponse{" +
                "payscoreApplyToken='" + payscoreApplyToken + '\'' +
                '}';
    }
}
