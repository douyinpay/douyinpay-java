package com.douyinpay.api.payments.jsapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** ApiQueryOrderByOutTradeNoRequest */
public class ApiQueryOrderByOutTradeNoRequest {
  /** outTradeNo */
  @SerializedName("out_trade_no")
  @Expose(serialize = false)
  private String outTradeNo;
  /** mchid 说明：直连商户号 */
  @SerializedName("mchid")
  @Expose(serialize = false)
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
    sb.append("class ApiQueryOrderByOutTradeNoRequest {\n");
    sb.append("    outTradeNo: ").append(toIndentedString(outTradeNo)).append("\n");
    sb.append("    mchid: ").append(toIndentedString(mchid)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
