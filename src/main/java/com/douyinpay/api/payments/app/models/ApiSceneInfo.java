package com.douyinpay.api.payments.app.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** 支付场景描述 */
public class ApiSceneInfo {
  /**
   * 字段含义：用户终端 IP。
   * 格式规则：IP 地址字符串。
   * 业务规则：用于标识发起支付请求的用户终端 IP。
   * 示例：14.23.150.211
   */
  @SerializedName("payer_client_ip")
  private String payerClientIp;
  /**
   * 字段含义：商户端设备号。
   * 格式规则：字符串。
   * 业务规则：预留字段，可用于标识商户侧设备。
   * 示例：013467007045764
   */
  @SerializedName("device_id")
  private String deviceId;
  /**
   * 字段含义：门店信息。
   * 格式规则：对象。
   * 业务规则：用于补充门店编号、名称和地址等信息。
   * 示例：
   */
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
