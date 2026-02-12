package com.douyinpay.api.payments.contractorder.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

/**
 * CloseOrderRequest
 */
public class ApiCloseOrderRequest {
    /**
     * outTradeNo
     */
    @SerializedName("out_trade_no")
    @Expose(serialize = false)
    private String outTradeNo;
    /**
     * mchid 说明：直连商户号
     */
    @SerializedName("mchid")
    private String mchid;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiCloseOrderRequest {\n");
        sb.append("    outTradeNo: ").append(toIndentedString(outTradeNo)).append("\n");
        sb.append("    mchid: ").append(toIndentedString(mchid)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}