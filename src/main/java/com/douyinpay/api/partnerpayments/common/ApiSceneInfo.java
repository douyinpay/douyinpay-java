package com.douyinpay.api.partnerpayments.common;

import com.google.gson.annotations.SerializedName;

import com.douyinpay.util.GsonUtil;

public class ApiSceneInfo {
  /**
   * 字段含义：商户端设备号。
   * 格式规则：字符串。
   * 业务规则：开放文档标注为预留字段，可用于标识商户侧设备。
   * 示例：013467007045764
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
