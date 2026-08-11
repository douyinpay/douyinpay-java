
package com.douyinpay.api.partnerpayments.nativepay.model;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** PrepayResponse */
public class ApiPrepayResponse {
  /**
   * 字段含义：二维码链接。
   * 格式规则：URL。
   * 业务规则：用于生成支付二维码供用户扫码支付；有效期为 2 分钟，失效后需重新请求下单接口获取新的 code_url。
   * 示例：https://qr.douyinpay.com/ntv05QEWlPLYOm9JkJTonzzwZNA8p2
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
