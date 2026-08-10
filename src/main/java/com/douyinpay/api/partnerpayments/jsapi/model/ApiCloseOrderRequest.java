package com.douyinpay.api.partnerpayments.jsapi.model;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;


public class ApiCloseOrderRequest {
    /**
     * 字段含义：服务商户号。
     * 格式规则：字符串。
     * 业务规则：由抖音支付生成并下发，用于标识服务商主体。
     * 示例：6020230301343000
     */
    @SerializedName("sp_mchid")
    private String spMchid;
    /**
     * 字段含义：子商户号。
     * 格式规则：字符串。
     * 业务规则：由抖音支付生成并下发，用于标识子商户主体。
     * 示例：6020230307605000
     */
    @SerializedName("sub_mchid")
    private String subMchid; 
    /**
     * 字段含义：商户订单号。
     * 格式规则：仅支持数字、大小写字母、_、-、*。
     * 业务规则：服务商系统内部订单号，在同一服务商商户号下需保持唯一；同一订单号重复请求按同一笔订单处理。
     * 示例：OUT_1666688488
     */
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