package com.douyinpay.api.partnerpayments.jsapi.model;
import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiQueryOrderByOutTradeNoRequest {
    /** 支付订单号 */
    @SerializedName("out_trade_no")
    private String outTradeNo;

    /** 服务商户号 */
    @SerializedName("sp_mchid")
    private String spMchid;

    /** 子商户号 */
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

    public void setSpMchid(String spMchid) {
        this.spMchid = spMchid;
    }

    public String getSubMchid() {
        return subMchid;
    }

    public void setSubMchid(String subMchid) {
        this.subMchid = subMchid;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append(" {");
        sb.append("\n    outTradeNo=").append(toIndentedString(outTradeNo));
        sb.append(",\n    spMchid=").append(toIndentedString(spMchid));
        sb.append(",\n    subMchid=").append(toIndentedString(subMchid));
        sb.append("\n}");
        return sb.toString();
    }
}
