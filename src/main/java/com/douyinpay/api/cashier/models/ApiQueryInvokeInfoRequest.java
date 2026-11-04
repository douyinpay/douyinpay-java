package com.douyinpay.api.cashier.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** ApiQueryInvokeInfoRequest */
public class ApiQueryInvokeInfoRequest {
  /**
   * 字段含义：直连商户号。
   * 格式规则：string[1,32]。
   * 业务规则：商家入驻抖音支付商家平台分配的商户号。
   * 示例：1230000109
   */
  @SerializedName("mchid")
  private String mchid;
  /**
   * 字段含义：预支付交易会话标识。
   * 格式规则：string[1,64]，可包含字母、数字、下划线。
   * 业务规则：下单接口返回的 prepay_id，需保证在商户端不重复。
   * 示例：dy9pvo8xyxpyop7u7t735u5s41527t5t8uytv101rs5t477vy989q7q5
   */
  @SerializedName("prepayid")
  private String prepayid;
  /**
   * 字段含义：订单附加信息。
   * 格式规则：string[1,1024]，JSON 格式。
   * 业务规则：订单附加信息，需与抖音支付协商后传递。
   */
  @SerializedName("ext_info")
  private String extInfo;

  public String getMchid() {
    return mchid;
  }

  public void setMchid(String mchid) {
    this.mchid = mchid;
  }

  public String getPrepayid() {
    return prepayid;
  }

  public void setPrepayid(String prepayid) {
    this.prepayid = prepayid;
  }

  public String getExtInfo() {
    return extInfo;
  }

  public void setExtInfo(String extInfo) {
    this.extInfo = extInfo;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiQueryInvokeInfoRequest {\n");
    sb.append("    mchid: ").append(toIndentedString(mchid)).append("\n");
    sb.append("    prepayid: ").append(toIndentedString(prepayid)).append("\n");
    sb.append("    extInfo: ").append(toIndentedString(extInfo)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
