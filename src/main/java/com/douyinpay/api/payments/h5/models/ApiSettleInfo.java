package com.douyinpay.api.payments.h5.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** SettleInfo */
public class ApiSettleInfo {
  /** profitSharing 说明：是否指定分账 */
  @SerializedName("profit_sharing")
  private Boolean profitSharing;

  public Boolean getProfitSharing() {
    return profitSharing;
  }

  public void setProfitSharing(Boolean profitSharing) {
    this.profitSharing = profitSharing;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiSettleInfo {\n");
    sb.append("    profitSharing: ").append(toIndentedString(profitSharing)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
