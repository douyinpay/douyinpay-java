
package com.douyinpay.api.payments.h5.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** PrepayResponse */
public class ApiPrepayResponse {
  /** h5Url 说明：支付跳转链接 */
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
