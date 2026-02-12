package com.douyinpay.api.partnerpayments.app.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import static com.douyinpay.util.StringUtil.toIndentedString;


public class ApiPrepayRequest {
  /** 服务商应用ID */
  @SerializedName("sp_appid")
  private String spAppid;
  /** 服务商户号 */
  @SerializedName("sp_mchid")
  private String spMchid;
 /** 子商户应用ID */
 @SerializedName("sub_appid")
 private String subAppid;
 /** 子商户号 */
 @SerializedName("sub_mchid")
 private String subMchid;
  /** 商品描述 */
  @SerializedName("description")
  private String description;
  /** 商户订单号 */
  @SerializedName("out_trade_no")
  private String outTradeNo;
  /** 交易结束时间*/
  @SerializedName("time_expire")
  private String timeExpire;
  /** 附加数据 */
  @SerializedName("attach")
  private String attach;
  /** 通知地址*/
  @SerializedName("notify_url")
  private String notifyUrl;
  /** 优惠标记 */
  @SerializedName("goods_tag")
  private String goodsTag;
  /** 电子发票入口开放标识 */
  @SerializedName("support_fapiao")
  private Boolean supportFapiao;
  /** 订单金额 */
  @SerializedName("amount")
  private Amount amount;
  /** 优惠信息 */
  @SerializedName("detail")
  private ApiDetail detail;
  /** 场景信息 */
  @SerializedName("scene_info")
  private ApiSceneInfo sceneInfo;
  /** 结算信息 */
  @SerializedName("settle_info")
  private ApiSettleInfo settleInfo;

  public String getSpAppid() {
      return spAppid;
  }
  public void setSpAppid(String spAppid) {
      this.spAppid = spAppid;
  }
  public String getSpMchid() {
      return spMchid;
  }
  public void setSpMchid(String spMchid) {
      this.spMchid = spMchid;
  }
  public String getSubAppid() {
      return subAppid;
  }
  public void setSubAppid(String subAppid) {
      this.subAppid = subAppid;
  }
  public String getSubMchid() {
      return subMchid;
  }
  public void setSubMchid(String subMchid) {
      this.subMchid = subMchid;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getOutTradeNo() {
    return outTradeNo;
  }

  public void setOutTradeNo(String outTradeNo) {
    this.outTradeNo = outTradeNo;
  }

  public String getTimeExpire() {
    return timeExpire;
  }

  public void setTimeExpire(String timeExpire) {
    this.timeExpire = timeExpire;
  }

  public String getAttach() {
    return attach;
  }

  public void setAttach(String attach) {
    this.attach = attach;
  }

  public String getNotifyUrl() {
    return notifyUrl;
  }

  public void setNotifyUrl(String notifyUrl) {
    this.notifyUrl = notifyUrl;
  }

  public String getGoodsTag() {
    return goodsTag;
  }

  public void setGoodsTag(String goodsTag) {
    this.goodsTag = goodsTag;
  }

  public Boolean getSupportFapiao() {
    return supportFapiao;
  }

  public void setSupportFapiao(Boolean supportFapiao) {
    this.supportFapiao = supportFapiao;
  }

  public Amount getAmount() {
    return amount;
  }

  public void setAmount(Amount amount) {
    this.amount = amount;
  }

  public ApiDetail getDetail() {
    return detail;
  }

  public void setDetail(ApiDetail detail) {
    this.detail = detail;
  }

  public ApiSceneInfo getSceneInfo() {
    return sceneInfo;
  }

  public void setSceneInfo(ApiSceneInfo sceneInfo) {
    this.sceneInfo = sceneInfo;
  }

  public ApiSettleInfo getSettleInfo() {
    return settleInfo;
  }

  public void setSettleInfo(ApiSettleInfo settleInfo) {
    this.settleInfo = settleInfo;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiPrepayRequest {\n");
    sb.append("    spAppid: ").append(toIndentedString(spAppid)).append("\n");
    sb.append("    spMchid: ").append(toIndentedString(spMchid)).append("\n");
    sb.append("    subAppid: ").append(toIndentedString(subAppid)).append("\n");
    sb.append("    subMchid: ").append(toIndentedString(subMchid)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    outTradeNo: ").append(toIndentedString(outTradeNo)).append("\n");
    sb.append("    timeExpire: ").append(toIndentedString(timeExpire)).append("\n");
    sb.append("    attach: ").append(toIndentedString(attach)).append("\n");
    sb.append("    notifyUrl: ").append(toIndentedString(notifyUrl)).append("\n");
    sb.append("    goodsTag: ").append(toIndentedString(goodsTag)).append("\n");
    sb.append("    supportFapiao: ").append(toIndentedString(supportFapiao)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    sceneInfo: ").append(toIndentedString(sceneInfo)).append("\n");
    sb.append("    settleInfo: ").append(toIndentedString(settleInfo)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
