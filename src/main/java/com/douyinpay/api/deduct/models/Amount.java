package com.douyinpay.api.deduct.models;

import com.douyinpay.util.StringUtil;
import com.google.gson.annotations.SerializedName;

/** Amount */
public class Amount {
  /**
   * 字段含义：总金额。
   * 格式规则：整型，单位为分。
   * 业务规则：表示订单总金额。
   * 示例：100
   */
  @SerializedName("total")
  private Integer total;
  /**
   * 字段含义：货币种类。
   * 格式规则：字符串，长度 1-16 位。
   * 业务规则：`CNY` 表示人民币，境内商户号仅支持人民币。
   * 示例：CNY
   */
  @SerializedName("currency")
  private String currency;

  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Amount {\n");
    sb.append("    total: ").append(StringUtil.toIndentedString(total)).append("\n");
    sb.append("    currency: ").append(StringUtil.toIndentedString(currency)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
