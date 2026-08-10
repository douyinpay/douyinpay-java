
package com.douyinpay.api.refund.model;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** FundsFromItem */
public class ApiFundsFromItem {
  /**
   * 字段含义：金额信息。
   * 格式规则：对象。
   * 业务规则：包含退款金额、原订单金额和退款币种等字段。
   * 示例：{"refund":100,"total":100,"currency":"CNY"}
   */
  @SerializedName("amount")
  private Long amount;
  /**
   * 字段含义：出资账户类型。
   * 格式规则：枚举字符串。
   * 业务规则：开放文档示例包含 AVAILABLE、UNAVAILABLE。
   * 示例：AVAILABLE
   */
  @SerializedName("account")
  private Account account;

  public Long getAmount() {
    return amount;
  }

  public void setAmount(Long amount) {
    this.amount = amount;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FundsFromItem {\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
