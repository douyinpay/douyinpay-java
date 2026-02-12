package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

// 场景信息
public class SceneInfo {
    // 用户终端IP
    @SerializedName("client_ip")
    private String clientIp;
    // 商户端设备号（预留字段）
    @SerializedName("device_id")
    private String deviceId;
    // 门店信息（预留字段）
    @SerializedName("store_info")
    private StoreInfo storeInfo;

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public StoreInfo getStoreInfo() {
        return storeInfo;
    }

    public void setStoreInfo(StoreInfo storeInfo) {
        this.storeInfo = storeInfo;
    }

    @Override
    public String toString() {
        return "SceneInfo{" +
                "clientIp='" + clientIp + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", storeInfo=" + storeInfo +
                '}';
    }
}
