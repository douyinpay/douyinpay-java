package com.douyinpay.api.partnerpayments.h5.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiCloseOrderRequest {
    /**
     * 商户订单号
     */
    @SerializedName("out_trade_no")
    @Expose(serialize = false)
    private String outTradeNo;
    /**
     * 服务商户号
     */
    @SerializedName("sp_mchid")
    private String spMchid;
    /**
     * 子商户号
     */
    @SerializedName("sub_mchid")
    private String subMchid;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getSpMchid() {
        return spMchid;
    }

    public String getSubMchid() {
        return subMchid;
    }

    public void setSpMchid(String spMchid) {
        this.spMchid = spMchid;
    }

    public void setSubMchid(String subMchid) {
        this.subMchid = subMchid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiCloseOrderRequest {\n");
        sb.append("    outTradeNo: ").append(toIndentedString(outTradeNo)).append("\n");
        sb.append("    spMchid: ").append(toIndentedString(spMchid)).append("\n");
        sb.append("    subMchid: ").append(toIndentedString(subMchid)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}