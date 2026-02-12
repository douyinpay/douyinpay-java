
package com.douyinpay.api.partnerpayments.app.model;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiPrepayResponse {
  /** 预支付交易会话标识 */
  @SerializedName("prepay_id")
  private String prepayId;

  public String getPrepayId() {
    return prepayId;
  }

  public void setPrepayId(String prepayId) {
    this.prepayId = prepayId;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiPrepayResponse {\n");
    sb.append("    prepayId: ").append(toIndentedString(prepayId)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
