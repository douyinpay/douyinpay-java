
package com.douyinpay.api.partnerpayments.h5.model;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** PrepayResponse */
public class ApiPrepayResponse {
  /**
   * 字段含义：H5支付跳转链接。
   * 格式规则：URL。
   * 业务规则：用于拉起抖音支付收银台中间页；有效期为 5 分钟，失效后需重新请求下单接口获取新的 h5_url。
   * 示例：https://cashier.ulpay.com/bytepay-cashdesk/bytepay-invoke?prepay_id=dy96y894ox66yv43x10uquv34s5s7sx3oso28squqsx
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
