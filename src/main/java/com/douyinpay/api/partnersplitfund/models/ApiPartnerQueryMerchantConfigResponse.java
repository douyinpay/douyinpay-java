package com.douyinpay.api.partnersplitfund.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiPartnerQueryMerchantConfigResponse {
    /**
     * 字段含义：特约商户商户号。
     */
    @SerializedName("sub_mchid")
    private String subMchid;

    /**
     * 字段含义：最大分账比例，单位万分比。
     */
    @SerializedName("max_ratio")
    private Integer maxRatio;

    public String getSubMchid() {
        return subMchid;
    }

    public void setSubMchid(String subMchid) {
        this.subMchid = subMchid;
    }

    public Integer getMaxRatio() {
        return maxRatio;
    }

    public void setMaxRatio(Integer maxRatio) {
        this.maxRatio = maxRatio;
    }

    @Override
    public String toString() {
        return GsonUtil.objectToJson(this);
    }
}
