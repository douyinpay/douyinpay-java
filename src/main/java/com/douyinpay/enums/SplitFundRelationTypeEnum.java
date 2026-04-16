package com.douyinpay.enums;

import com.google.gson.annotations.SerializedName;

public enum SplitFundRelationTypeEnum {
    @SerializedName("SERVICE_PROVIDER")
    SERVICE_PROVIDER,

    @SerializedName("STORE")
    STORE,

    @SerializedName("STAFF")
    STAFF,

    @SerializedName("STORE_OWNER")
    STORE_OWNER,

    @SerializedName("PARTNER")
    PARTNER,

    @SerializedName("HEADQUARTER")
    HEADQUARTER,

    @SerializedName("BRAND")
    BRAND,

    @SerializedName("DISTRIBUTOR")
    DISTRIBUTOR,

    @SerializedName("USER")
    USER,

    @SerializedName("SUPPLIER")
    SUPPLIER,

    @SerializedName("CUSTOM")
    CUSTOM
}
