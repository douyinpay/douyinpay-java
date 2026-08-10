package com.douyinpay.api.refund.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** AmountReq */
public class ApiAmountReq {
  /**
   * 字段含义：退款金额。
   * 格式规则：单位为分的整数。
   * 业务规则：不能超过原订单支付金额。
   * 示例：100
   */
  @SerializedName("refund")
  private Integer refund;
  /**
   * 字段含义：退款出资账户信息。
   * 格式规则：数组。
   * 业务规则：用于指定各账户的退款出资金额。
   * 示例：
   */
  @SerializedName("from")
  private List<ApiFundsFromItem> from;
  /**
   * 字段含义：原订单金额。
   * 格式规则：单位为分的整数。
   * 业务规则：表示原支付交易的订单总金额。
   * 示例：100
   */
  @SerializedName("total")
  private Integer total;
  /**
   * 字段含义：币种。
   * 格式规则：符合 ISO 4217 标准的三位字母代码。
   * 业务规则：当前仅支持人民币。
   * 示例：CNY
   */
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
