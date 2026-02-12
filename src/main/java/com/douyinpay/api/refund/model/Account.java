package com.douyinpay.api.refund.model;

import com.google.gson.annotations.SerializedName;

/** AVAILABLE - 可用余额，多账户资金准备退款可用余额出资账户类型 UNAVAILABLE - 不可用余额，多账户资金准备退款不可用余额出资账户类型 */
public enum Account {
  @SerializedName("AVAILABLE")
  AVAILABLE,

  @SerializedName("UNAVAILABLE")
  UNAVAILABLE
}
