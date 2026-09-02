package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

// 场景信息
public class SceneInfo {
    // 字段含义：用户终端IP。
    // 格式规则：string[1,45]，支持IPv4和IPv6两种格式的IP地址。
    // 示例：14.23.150.211。
    @SerializedName("client_ip")
    private String clientIp;
    // 字段含义：商户端设备号。
    // 格式规则：string[1,32]。
    // 业务规则：门店号或收银设备ID。
    // 示例：13467007045764。
    @SerializedName("device_id")
    private String deviceId;
    // 字段含义：门店信息。
    // 格式规则：object。
    // 示例：{"id":"1089","name":"辉煌购物中心店","area_code":"100089","address":"北京市海淀区辉煌购物中心5层505"}。
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
