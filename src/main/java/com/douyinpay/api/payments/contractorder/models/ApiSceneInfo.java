package com.douyinpay.api.payments.contractorder.models;

import static com.douyinpay.util.StringUtil.toIndentedString;

import com.google.gson.annotations.SerializedName;

/** 支付场景描述 */
public class ApiSceneInfo {
  /**
   * 字段含义：用户终端 IP。
   * 格式规则：IP 地址字符串，支持 IPv4 和 IPv6。
   * 业务规则：用于标识发起支付请求的用户终端 IP。
   * 示例：14.23.150.211
   */
  @SerializedName("payer_client_ip")
  private String payerClientIp;
  /**
   * 字段含义：商户端设备号。
   * 格式规则：字符串，长度 1-32 位。
   * 业务规则：用于标识门店号或收银设备 ID。
   * 示例：13467007045764
   */
  @SerializedName("device_id")
  private String deviceId;
  /**
   * 字段含义：用户终端设备号。
   * 格式规则：字符串，长度 1-45 位。
   * 业务规则：Android 优先传 android_id（openudid），若没有则传 IMEI；iOS 优先传 IDFV，若没有 IDFV 则传
   * IDFA。
   * 示例：
   */
  @SerializedName("payer_device_id")
  private String payerDeviceId;
  /**
   * 字段含义：门店信息。
   * 格式规则：对象。
   * 业务规则：当前接口文档未明确说明 store_info 字段的使用规则，暂保留该字段以兼容现有模型。
   * 示例：
   */
  @SerializedName("store_info")
  private ApiStoreInfo storeInfo;
  /**
   * 字段含义：H5 场景信息。
   * 格式规则：对象。
   * 业务规则：当前接口文档未明确说明 h5_info 字段的使用规则，暂保留该字段以兼容现有模型。
   * 示例：
   */
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
