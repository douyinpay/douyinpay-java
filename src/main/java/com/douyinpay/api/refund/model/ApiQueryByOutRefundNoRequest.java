
package com.douyinpay.api.refund.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** QueryByOutRefundNoRequest */
public class ApiQueryByOutRefundNoRequest {
  /** 商户退款单号 说明：商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。 */
  @SerializedName("out_refund_no")
  @Expose(serialize = false)
  private String outRefundNo;
  /** 子商户号 说明：子商户的商户号，由抖音支付生成并下发。服务商模式下必须传递此参数 */
  @SerializedName("mchid")
  @Expose(serialize = false)
  private String mchid;

  /** 服务商户号 */
  @SerializedName("sp_mchid")
  @Expose(serialize = false)
  private String spMchid;

  /** 子商户号 */
  @SerializedName("sub_mchid")
  @Expose(serialize = false)
  private String subMchid;

public String getSpMchid() {
    return spMchid;
}

  public String getSubMchid() {
    return subMchid;
  }

  public void setSubMchid(String subMchid) {
    this.subMchid = subMchid;
  }

  public String getOutRefundNo() {
    return outRefundNo;
  }

  public void setOutRefundNo(String outRefundNo) {
    this.outRefundNo = outRefundNo;
  }

  public String getMchid() {
    return mchid;
  }

  public void setMchid(String mchid) {
    this.mchid = mchid;
  }

  public void setSpMchid(String spMchid) {
      this.spMchid = spMchid;
  }
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiQueryByOutRefundNoRequest {\n");
    sb.append("    outRefundNo: ").append(toIndentedString(outRefundNo)).append("\n");
    sb.append("    mchid: ").append(toIndentedString(mchid)).append("\n");
    sb.append("    spMchid: ").append(toIndentedString(spMchid)).append("\n");
    sb.append("    subMchid: ").append(toIndentedString(subMchid)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
