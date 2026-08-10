package com.douyinpay.api.payments.common;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiTransactionSceneInfo {

    /**
     * 字段含义：商户端设备号。
     * 格式规则：字符串。
     * 业务规则：查询订单时返回场景信息中的设备号。
     * 示例：13467007045123
     */
    @SerializedName("device_id")
    private String deviceId;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public String toString() {
        return GsonUtil.getGson().toJson(this);
    }

}
