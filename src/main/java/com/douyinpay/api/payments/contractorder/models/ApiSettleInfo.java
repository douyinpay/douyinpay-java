package com.douyinpay.api.payments.contractorder.models;

import static com.douyinpay.util.StringUtil.toIndentedString;

import com.google.gson.annotations.SerializedName;

/** SettleInfo */
public class ApiSettleInfo {
  /**
   * 字段含义：是否分账。
   * 格式规则：boolean。
   * 业务规则：传入 true 表示订单支付成功后可进行分账操作；传入 false 或不传时默认为
   * false，订单收款成功后资金不会被冻结，而是直接转入基本账户可用余额。
   * 示例：false
   */
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
