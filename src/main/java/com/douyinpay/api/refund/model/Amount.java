
package com.douyinpay.api.refund.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** Amount */
public class Amount {
  /**
   * 字段含义：原订单金额。
   * 格式规则：单位为分的整数。
   * 业务规则：表示原支付交易的订单总金额。
   * 示例：100
   */
  @SerializedName("total")
  private Long total;
  /**
   * 字段含义：退款金额。
   * 格式规则：单位为分的整数。
   * 业务规则：不能超过原订单支付金额。
   * 示例：100
   */
  @SerializedName("refund")
  private Long refund;
  /**
   * 字段含义：退款出资账户信息。
   * 格式规则：数组。
   * 业务规则：用于指定各账户的退款出资金额。
   * 示例：
   */
  @SerializedName("from")
  private List<ApiFundsFromItem> from;
  /**
   * 字段含义：用户支付金额。
   * 格式规则：单位为分的整数。
   * 业务规则：表示现金支付金额。
   * 示例：100
   */
  @SerializedName("payer_total")
  private Long payerTotal;
  /**
   * 字段含义：用户退款金额。
   * 格式规则：单位为分的整数。
   * 业务规则：表示退款给用户的金额，不包含所有优惠券金额。
   * 示例：100
   */
  @SerializedName("payer_refund")
  private Long payerRefund;
  /**
   * 字段含义：应结退款金额。
   * 格式规则：单位为分的整数。
   * 业务规则：退款金额等于申请退款金额减去非充值代金券退款金额。
   * 示例：100
   */
  @SerializedName("settlement_refund")
  private Long settlementRefund;
  /**
   * 字段含义：应结订单金额。
   * 格式规则：单位为分的整数。
   * 业务规则：等于订单金额减去免充值代金券金额。
   * 示例：100
   */
  @SerializedName("settlement_total")
  private Long settlementTotal;
  /**
   * 字段含义：优惠退款金额。
   * 格式规则：单位为分的整数。
   * 业务规则：表示代金券或立减优惠的退款金额。
   * 示例：0
   */
  @SerializedName("discount_refund")
  private Long discountRefund;
  /**
   * 字段含义：币种。
   * 格式规则：符合 ISO 4217 标准的三位字母代码。
   * 业务规则：当前仅支持人民币。
   * 示例：CNY
   */
  @SerializedName("currency")
  private String currency;
  /**
   * 字段含义：手续费退款金额。
   * 格式规则：单位为分的整数。
   * 业务规则：表示随退款一并退回的手续费金额。
   * 示例：0
   */
  @SerializedName("refund_fee")
  private Long refundFee;

  public Long getTotal() {
    return total;
  }

  public void setTotal(Long total) {
    this.total = total;
  }

  public Long getRefund() {
    return refund;
  }

  public void setRefund(Long refund) {
    this.refund = refund;
  }

  public List<ApiFundsFromItem> getFrom() {
    return from;
  }

  public void setFrom(List<ApiFundsFromItem> from) {
    this.from = from;
  }

  public Long getPayerTotal() {
    return payerTotal;
  }

  public void setPayerTotal(Long payerTotal) {
    this.payerTotal = payerTotal;
  }

  public Long getPayerRefund() {
    return payerRefund;
  }

  public void setPayerRefund(Long payerRefund) {
    this.payerRefund = payerRefund;
  }

  public Long getSettlementRefund() {
    return settlementRefund;
  }

  public void setSettlementRefund(Long settlementRefund) {
    this.settlementRefund = settlementRefund;
  }

  public Long getSettlementTotal() {
    return settlementTotal;
  }

  public void setSettlementTotal(Long settlementTotal) {
    this.settlementTotal = settlementTotal;
  }

  public Long getDiscountRefund() {
    return discountRefund;
  }

  public void setDiscountRefund(Long discountRefund) {
    this.discountRefund = discountRefund;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Long getRefundFee() {
    return refundFee;
  }

  public void setRefundFee(Long refundFee) {
    this.refundFee = refundFee;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Amount {\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    refund: ").append(toIndentedString(refund)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    payerTotal: ").append(toIndentedString(payerTotal)).append("\n");
    sb.append("    payerRefund: ").append(toIndentedString(payerRefund)).append("\n");
    sb.append("    settlementRefund: ").append(toIndentedString(settlementRefund)).append("\n");
    sb.append("    settlementTotal: ").append(toIndentedString(settlementTotal)).append("\n");
    sb.append("    discountRefund: ").append(toIndentedString(discountRefund)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    refundFee: ").append(toIndentedString(refundFee)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
