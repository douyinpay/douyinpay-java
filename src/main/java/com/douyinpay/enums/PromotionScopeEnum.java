
package com.douyinpay.enums;

import com.google.gson.annotations.SerializedName;

/** GLOBAL - 全场代金券，全场优惠类型 SINGLE - 单品优惠，单品优惠类型 */
public enum PromotionScopeEnum {
  @SerializedName("GLOBAL")
  GLOBAL,

  @SerializedName("SINGLE")
  SINGLE
}
