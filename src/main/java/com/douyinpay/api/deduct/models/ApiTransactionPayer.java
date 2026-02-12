package com.douyinpay.api.deduct.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiTransactionPayer {
    /** openid */
    @SerializedName("openid")
    private String openid;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Override
    public String toString() {
        return GsonUtil.getGson().toJson(this);
    }
}

