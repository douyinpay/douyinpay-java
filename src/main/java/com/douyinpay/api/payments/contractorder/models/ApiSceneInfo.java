package com.douyinpay.api.payments.contractorder.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** 支付场景描述 */
public class ApiSceneInfo {
  /** 用户终端IP 说明：用户终端IP */
  @SerializedName("payer_client_ip")
  private String payerClientIp;
  /** 商户端设备号 说明：商户端设备号 （预留字段）*/
  @SerializedName("device_id")
  private String deviceId;
  /** 用户终端ID 说明： 用户终端ID */
  @SerializedName("payer_device_id")
  private String payerDeviceId;
  /** storeInfo */
  @SerializedName("store_info")
  private ApiStoreInfo storeInfo;
  @SerializedName("h5_info")
  private ApiH5Info h5Info;

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

  public ApiStoreInfo getStoreInfo() {
    return storeInfo;
  }

  public void setStoreInfo(ApiStoreInfo storeInfo) {
    this.storeInfo = storeInfo;
  }

  public ApiH5Info getH5Info() {
    return h5Info;
  }

  public void setH5Info(ApiH5Info h5Info) {
    this.h5Info = h5Info;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiSceneInfo {\n");
    sb.append("    payerClientIp: ").append(toIndentedString(payerClientIp)).append("\n");
    sb.append("    deviceId: ").append(toIndentedString(deviceId)).append("\n");
    sb.append("    payerDeviceId: ").append(toIndentedString(payerDeviceId)).append("\n");
    sb.append("    storeInfo: ").append(toIndentedString(storeInfo)).append("\n");
    sb.append("    h5Info: ").append(toIndentedString(h5Info)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
