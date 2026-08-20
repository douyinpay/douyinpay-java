package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

/**
 * 直连服务商申请服务授权响应。
 */
public class ApiCreditSrvSignApplyForSPResponse {
    /** 先享后付申请令牌。 */
    @SerializedName("payscore_apply_token")
    private String payscoreApplyToken;
    /** H5 签约页面地址。 */
    @SerializedName("h5_sign_service_url")
    private String h5SignServiceUrl;

    public String getPayscoreApplyToken() {
        return payscoreApplyToken;
    }

    public void setPayscoreApplyToken(String payscoreApplyToken) {
        this.payscoreApplyToken = payscoreApplyToken;
    }

    public String getH5SignServiceUrl() {
        return h5SignServiceUrl;
    }

    public void setH5SignServiceUrl(String h5SignServiceUrl) {
        this.h5SignServiceUrl = h5SignServiceUrl;
    }
}
