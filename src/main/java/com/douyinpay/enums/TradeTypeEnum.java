package com.douyinpay.enums;

import com.google.gson.annotations.SerializedName;


/**
 * 交易类型枚举
 * 可作为取值参考，不建议直接使用，可能会有变动
 */
public enum TradeTypeEnum {

    /**
     * tradeType
     */
    @SerializedName("JSAPI")
    JSAPI,

    @SerializedName("NATIVE")
    NATIVE,

    @SerializedName("APP")
    APP,

    @SerializedName("MICROPAY")
    MICROPAY,

    @SerializedName("MWEB")
    MWEB,

    @SerializedName("CCP")
    CCP, // 周期扣款

    @SerializedName("SGP")
    SGP, // 商户代扣

    @SerializedName("NPP")
    NPP, // 极速付/免密支付

    @SerializedName("XXP")
    XXP, // 先享后付


}
