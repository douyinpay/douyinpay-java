package com.douyinpay.api.payments.nativepay.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** PrepayResponse */
public class ApiPrepayResponse {
  /** codeUrl 说明：预支付交易会话标识 */
  @SerializedName("code_url")
  private String codeUrl;

  public String getCodeUrl() {
    return codeUrl;
  }

  public void setCodeUrl(String codeUrl) {
    this.codeUrl = codeUrl;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiPrepayResponse {\n");
    sb.append("    codeUrl: ").append(toIndentedString(codeUrl)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
