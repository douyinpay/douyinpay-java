package com.douyinpay.api.partnerpayments.common;

import com.google.gson.annotations.SerializedName;

import com.douyinpay.util.GsonUtil;

public class ApiTransactionPayer {
    /** 用户服务标识 */
    @SerializedName("sp_openid")
    private String spOpenId;
    /** 用户子标识 */
    @SerializedName("sub_openid")
    private String SubOpenId;
    public String getSpOpenId() {
        return spOpenId;
    }
    public String getSubOpenId() {
        return SubOpenId;
    }
    public void setSpOpenId(String spOpenId) {
        this.spOpenId = spOpenId;
    }
    public void setSubOpenId(String subOpenId) {
        SubOpenId = subOpenId;
    }

    @Override
    public String toString() {
        return GsonUtil.getGson().toJson(this);
    }
}

