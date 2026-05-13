package com.douyinpay.enums;

import com.google.gson.annotations.SerializedName;

public enum SplitFundReturnResultEnum {
    /**
     * 处理中，非终态
     */
    @SerializedName("PROCESSING")
    PROCESSING,

    /**
     * 已成功，终态
     */
    @SerializedName("SUCCESS")
    SUCCESS,

    /**
     * 已失败，终态
     */
    @SerializedName("FAILED")
    FAILED
}
