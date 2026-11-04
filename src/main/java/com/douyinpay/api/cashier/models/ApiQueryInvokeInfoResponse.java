package com.douyinpay.api.cashier.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** ApiQueryInvokeInfoResponse */
public class ApiQueryInvokeInfoResponse {
  /**
   * 字段含义：唤起抖音支付链接。
   * 格式规则：string。
   * 业务规则：通过该链接唤起抖音支付收银台。
   */
  @SerializedName("invoke_url")
  private String invokeUrl;

  public String getInvokeUrl() {
    return invokeUrl;
  }

  public void setInvokeUrl(String invokeUrl) {
    this.invokeUrl = invokeUrl;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiQueryInvokeInfoResponse {\n");
    sb.append("    invokeUrl: ").append(toIndentedString(invokeUrl)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
