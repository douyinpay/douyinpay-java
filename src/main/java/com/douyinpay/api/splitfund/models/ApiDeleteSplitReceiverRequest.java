package com.douyinpay.api.splitfund.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiDeleteSplitReceiverRequest {

    /**
     * 直连商户号
     */
    @SerializedName("mchid")
    private String merchantId;

    /**
     * 应用ID
     */
    @SerializedName("appid")
    private String appId;

    /**
     * 分账接收方类型
     */
    @SerializedName("type")
    private String type;

    /**
     * 分账接收方账号
     */
    @SerializedName("account")
    private String account;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return GsonUtil.objectToJson(this);
    }
}
