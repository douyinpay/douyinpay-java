package com.douyinpay.api.splitfund.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiQueryReturnSplitFundRequest {

    /**
     * 商户回退单号
     */
    @SerializedName("out_return_no")
    private String outReturnNo;

    /**
     * 直连商户号
     */
    @SerializedName("mchid")
    private String merchantId;

    /**
     * 商户分账单号
     */
    @SerializedName("out_order_no")
    private String outOrderNo;

    public String getOutReturnNo() {
        return outReturnNo;
    }

    public void setOutReturnNo(String outReturnNo) {
        this.outReturnNo = outReturnNo;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    @Override
    public String toString() {
        return GsonUtil.objectToJson(this);
    }
}
