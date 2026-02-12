
package com.douyinpay.enums;

import com.google.gson.annotations.SerializedName;

/** SUCCESS - 退款成功，退款状态 CLOSED - 退款关闭，退款状态 PROCESSING - 退款处理中，退款状态 ABNORMAL - 退款异常，退款状态 */
public enum RefundStatusEnum {
  @SerializedName("SUCCESS")
  SUCCESS,

  /**
   * 暂未开放
   */
  @SerializedName("CLOSED")
  CLOSED,

  @SerializedName("PROCESSING")
  PROCESSING,

  /**
   * 暂未开放
   */
  @SerializedName("ABNORMAL")
  ABNORMAL
}
