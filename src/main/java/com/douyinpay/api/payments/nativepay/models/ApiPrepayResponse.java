package com.douyinpay.api.payments.nativepay.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** PrepayResponse */
public class ApiPrepayResponse {
  /**
   * 字段含义：二维码链接。
   * 格式规则：URL。
   * 业务规则：由 Native 下单接口返回，商户需将该链接生成二维码供用户扫码支付。
   */
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
