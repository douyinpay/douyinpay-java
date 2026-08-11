package com.douyinpay.api.payments.app.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** ApiQueryOrderByOutTradeNoRequest */
public class ApiQueryOrderByOutTradeNoRequest {
  /**
   * 字段含义：商户订单号。
   * 格式规则：仅支持数字、大小写字母、_、-、*。
   * 业务规则：同一商户号下需保持唯一；同一订单号重复请求按同一笔订单处理。
   * 示例：OUT_1666688488
   */
  @SerializedName("out_trade_no")
  @Expose(serialize = false)
  private String outTradeNo;
  /**
   * 字段含义：直连商户号。
   * 格式规则：字符串。
   * 业务规则：由抖音支付生成并下发，用于标识当前直连商户。
   * 示例：6020230307605084
   */
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
