package com.douyinpay.api.deduct.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** 支付场景描述 */
public class ApiSceneInfo {
  /**
   * 字段含义：用户终端IP。
   * 格式规则：字符串，长度 1-45 位，支持 IPv4 和 IPv6。
   * 业务规则：表示用户的客户端 IP。
   * 示例：14.23.150.211
   */
  @SerializedName("payer_client_ip")
  private String payerClientIp;
  /**
   * 字段含义：商户端设备号。
   * 格式规则：字符串，长度 1-32 位。
   * 业务规则：表示商户端设备号（门店号或收银设备ID）。
   * 示例：13467007045764
   */
  @SerializedName("device_id")
  private String deviceId;
  /**
   * 字段含义：用户设备号。
   * 格式规则：字符串，长度 1-32 位。
   * 业务规则：安卓优先传 android_id（openudid），若没有则传 IMEI；iOS 优先传 IDFV，若没有
   * IDFV 则传 IDFA。
   * 示例：
   */
  @SerializedName("payer_device_id")
  private String payerDeviceId;

  public String getPayerClientIp() {
    return payerClientIp;
  }

  public void setPayerClientIp(String payerClientIp) {
    this.payerClientIp = payerClientIp;
  }

  public String getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }

  public String getPayerDeviceId() {
    return payerDeviceId;
  }

  public void setPayerDeviceId(String payerDeviceId) {
    this.payerDeviceId = payerDeviceId;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiSceneInfo {\n");
    sb.append("    payerClientIp: ").append(toIndentedString(payerClientIp)).append("\n");
    sb.append("    deviceId: ").append(toIndentedString(deviceId)).append("\n");
    sb.append("    payerDeviceId: ").append(toIndentedString(payerDeviceId)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
