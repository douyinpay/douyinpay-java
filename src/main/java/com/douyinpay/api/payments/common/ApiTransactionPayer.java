package com.douyinpay.api.payments.common;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiTransactionPayer {
    /**
     * 字段含义：用户标识。
     * 格式规则：字符串。
     * 业务规则：表示用户在商户 AppID 下的唯一标识。
     * 示例：b8e6c6fe-fc06-573b-9987-deda78c15000
     */
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

