
package com.douyinpay.enums;

import com.google.gson.annotations.SerializedName;

/**
 * CASH：充值；NOCASH：预充值。
 * */
public enum PayPromotionTypeEnum {
  @SerializedName("CASH")
  CASH,

  @SerializedName("NOCASH")
  NOCASH
}
