
package com.douyinpay.enums;

import com.google.gson.annotations.SerializedName;

public enum FundsAccountEnum {
  @SerializedName("UNSETTLED")
  UNSETTLED,

  @SerializedName("AVAILABLE")
  AVAILABLE,

  @SerializedName("UNAVAILABLE")
  UNAVAILABLE,

  @SerializedName("OPERATION")
  OPERATION,

  @SerializedName("BASIC")
  BASIC,

}
