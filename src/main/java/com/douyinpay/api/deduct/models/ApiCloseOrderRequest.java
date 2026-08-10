package com.douyinpay.api.deduct.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

/**
 * CloseOrderRequest
 */
public class ApiCloseOrderRequest {
    /**
     * 字段含义：商户订单号。
     * 格式规则：字符串，长度 6-32 位，仅支持数字、大小写字母、_、-、*。
     * 业务规则：商户系统内部订单号，在同一商户号下唯一。
     * 示例：OUT_1666688488
     */
    @SerializedName("out_trade_no")
    @Expose(serialize = false)
    private String outTradeNo;
    /**
     * 字段含义：直连商户号。
     * 格式规则：字符串，长度 1-32 位。
     * 业务规则：由抖音支付生成并下发，用于标识直连商户主体。
     * 示例：600000000000001
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
