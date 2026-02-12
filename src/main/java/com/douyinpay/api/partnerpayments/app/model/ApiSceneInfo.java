package com.douyinpay.api.partnerpayments.app.model;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiSceneInfo {
  /** 用户终端IP */
  @SerializedName("payer_client_ip")
  private String payerClientIp;
  /** 商户端设备号 （预留字段）*/
  @SerializedName("device_id")
  private String deviceId;
  /** 商户门店信息 （预留字段）*/
  @SerializedName("store_info")
  private ApiStoreInfo storeInfo;

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

  public ApiStoreInfo getStoreInfo() {
    return storeInfo;
  }

  public void setStoreInfo(ApiStoreInfo storeInfo) {
    this.storeInfo = storeInfo;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiSceneInfo {\n");
    sb.append("    payerClientIp: ").append(toIndentedString(payerClientIp)).append("\n");
    sb.append("    deviceId: ").append(toIndentedString(deviceId)).append("\n");
    sb.append("    storeInfo: ").append(toIndentedString(storeInfo)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
