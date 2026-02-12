package com.douyinpay.api.partnerpayments.jsapi.model;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;


public class ApiCloseOrderRequest {
    /** 服务商户号 */
    @SerializedName("sp_mchid")
    private String spMchid;
    /* 子商户号 */
    @SerializedName("sub_mchid")
    private String subMchid; 
    /* 商户订单号 */
    @SerializedName("out_trade_no")
    private String outTradeNo; 
    public String getOutTradeNo() {
        return outTradeNo;
    }
    public String getSpMchid() {
        return spMchid;
    }
    public String getSubMchid() {
        return subMchid;
    }
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
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
        sb.append("ApiCloseOrderRequest{");
        sb.append("spMchid='").append(toIndentedString(spMchid)).append("', ");
        sb.append("subMchid='").append(toIndentedString(subMchid)).append("', ");
        sb.append("outTradeNo='").append(toIndentedString(outTradeNo));
        sb.append('}');
        return sb.toString();
    }
}