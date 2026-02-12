package com.douyinpay.enums;

import com.google.gson.annotations.SerializedName;


/**
 * ORIGINAL - 原路退款，退款渠道 BALANCE - 退回到余额，退款渠道 OTHER_BALANCE - 原账户异常退到其他余额账户，退款渠道 OTHER_BANKCARD -
 * 原银行卡异常退到其他银行卡，退款渠道
 */
public enum RefundChannelEnum {

    @SerializedName("ORIGINAL")
    ORIGINAL,

    @SerializedName("BALANCE")
    BALANCE,

    @SerializedName("OTHER_BALANCE")
    OTHER_BALANCE,

    @SerializedName("OTHER_BANKCARD")
    OTHER_BANKCARD
}
