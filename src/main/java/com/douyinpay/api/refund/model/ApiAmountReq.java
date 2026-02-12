package com.douyinpay.api.refund.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** AmountReq */
public class ApiAmountReq {
  /** 退款金额 说明：退款金额，币种的最小单位，只能为整数，不能超过原订单支付金额。 */
  @SerializedName("refund")
  private Integer refund;
  @SerializedName("from")
  private List<ApiFundsFromItem> from;
  /** 原订单金额 说明：原支付交易的订单总金额，币种的最小单位，只能为整数。 */
  @SerializedName("total")
  private Integer total;
  /** 退款币种 说明：符合ISO 4217标准的三位字母代码，目前只支持人民币：CNY。 */
  @SerializedName("currency")
  private String currency;

  public Integer getRefund() {
    return refund;
  }

  public void setRefund(Integer refund) {
    this.refund = refund;
  }

  public List<ApiFundsFromItem> getFrom() {
    return from;
  }

  public void setFrom(List<ApiFundsFromItem> from) {
    this.from = from;
  }

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
    sb.append("class ApiAmountReq {\n");
    sb.append("    refund: ").append(toIndentedString(refund)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
