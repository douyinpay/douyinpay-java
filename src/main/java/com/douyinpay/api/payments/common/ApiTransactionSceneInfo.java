package com.douyinpay.api.payments.common;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiTransactionSceneInfo {

    /**
     * device_id
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
