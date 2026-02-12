package com.douyinpay.api.partnerpayments.common;

import com.google.gson.annotations.SerializedName;

import com.douyinpay.util.GsonUtil;

public class ApiSceneInfo {
  /** 商户端设备号 （预留字段）*/
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
