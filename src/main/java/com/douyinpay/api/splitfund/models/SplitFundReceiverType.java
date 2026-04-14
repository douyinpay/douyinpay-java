package com.douyinpay.api.splitfund.models;

import com.google.gson.annotations.SerializedName;

public enum SplitFundReceiverType {
    @SerializedName("MERCHANT_ID")
    MERCHANT_ID,

    @SerializedName("PERSONAL_OPENID")
    PERSONAL_OPENID;
}
