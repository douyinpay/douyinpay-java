package com.douyinpay.api.partnerdeduct.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiSceneInfo {
  /** 用户终端IP */
  @SerializedName("payer_client_ip")
  private String payerClientIp;
  /** 商户端设备号 （预留字段）*/
  @SerializedName("device_id")
  private String deviceId;
  /** 用户设备号 */
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
