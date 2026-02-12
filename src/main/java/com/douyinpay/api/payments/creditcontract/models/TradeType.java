package com.douyinpay.api.payments.creditcontract.models;

import com.google.gson.annotations.SerializedName;

public enum TradeType {

    @SerializedName("APP")
    TradeTypeApp,                  // APP支付
    @SerializedName("JSAPI")
    TradeTypeJsapi,                // JSAPI支付/小程序支付
    @SerializedName("NATIVE")
    TradeTypeNative,               // 扫码支付（仅线上场景）
    @SerializedName("MWEB")
    TradeTypeMweb,                 // H5支付
}
