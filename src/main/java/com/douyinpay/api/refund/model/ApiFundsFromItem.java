
package com.douyinpay.api.refund.model;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** FundsFromItem */
public class ApiFundsFromItem {
  /**
   * 字段含义：对应账户出资金额。
   * 格式规则：整数。
   * 业务规则：单位为分，只能为整数。
   * 示例：100
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
