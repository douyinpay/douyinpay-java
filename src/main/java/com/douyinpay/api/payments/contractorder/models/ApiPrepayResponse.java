
package com.douyinpay.api.payments.contractorder.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** PrepayResponse */
public class ApiPrepayResponse {
  /** prepayId 说明：预支付交易会话标识 */
  @SerializedName("prepay_id")
  private String prepayId;

  /** h5支付跳转链接 */
  @SerializedName("h5_url")
  private String h5Url;

  public String getPrepayId() {
    return prepayId;
  }

  public void setPrepayId(String prepayId) {
    this.prepayId = prepayId;
  }

  public String getH5Url() {
    return h5Url;
  }

  public void setH5Url(String h5Url) {
    this.h5Url = h5Url;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiPrepayResponse {\n");
    sb.append("    prepayId: ").append(toIndentedString(prepayId)).append("\n");
    sb.append("    h5Url: ").append(toIndentedString(h5Url)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
