
package com.douyinpay.api.payments.h5.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** PrepayResponse */
public class ApiPrepayResponse {
  /**
   * 字段含义：支付跳转链接。
   * 格式规则：URL。
   * 业务规则：由 H5 下单接口返回，商户通过该链接调起抖音支付中间页。
   */
  @SerializedName("h5_url")
  private String h5Url;

  public String getH5Url() {
    return h5Url;
  }

  public void setH5Url(String h5Url) {
    this.h5Url = h5Url;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class H5PrepayResponse {\n");
    sb.append("    h5Url: ").append(toIndentedString(h5Url)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
