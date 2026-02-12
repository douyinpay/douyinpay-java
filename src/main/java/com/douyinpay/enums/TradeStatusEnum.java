package com.douyinpay.enums;

import com.google.gson.annotations.SerializedName;

/**
 * 交易状态枚举
 * 可作为取值参考，不建议直接使用，可能会有变动
 */
public enum TradeStatusEnum {

        @SerializedName("SUCCESS")
        SUCCESS,

        /**
         * 暂不支持
         */
        @SerializedName("REFUND")
        REFUND,

        @SerializedName("NOTPAY")
        NOTPAY,

        @SerializedName("CLOSED")
        CLOSED,

        /**
         * 暂不支持
         */
        @SerializedName("USERPAYING")
        USERPAYING,


        /**
         * 暂不支持
         */
        @SerializedName("PAYERROR")
        PAYERROR,

}
