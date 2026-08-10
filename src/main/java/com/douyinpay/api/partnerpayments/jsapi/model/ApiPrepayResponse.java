
package com.douyinpay.api.partnerpayments.jsapi.model;
import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;


public class ApiPrepayResponse {
  /**
   * 字段含义：预支付交易会话标识。
   * 格式规则：字符串。
   * 业务规则：由下单接口返回，用于前端拉起支付。
   * 示例：dy1217752501201407033233368018
   */
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
