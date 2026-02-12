package com.douyinpay.api.partnercontractorder.models;

import com.douyinpay.util.StringUtil;
import com.google.gson.annotations.SerializedName;


public class Amount {
  /** 总金额 */
  @SerializedName("total")
  private Integer total;
  /** 货币类型 */
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
