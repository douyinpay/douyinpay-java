package com.douyinpay.api.transfer.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class PayerInfo {
    /** 付款方标识 */
    @SerializedName("identity")
    private String identity;

    public String getIdentity() {
        return identity;
    }
    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Override
    public String toString() {
        return GsonUtil.getGson().toJson(this);
    }
}
