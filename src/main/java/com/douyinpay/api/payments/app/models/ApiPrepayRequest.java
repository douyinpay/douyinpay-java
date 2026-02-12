package com.douyinpay.api.payments.app.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import static com.douyinpay.util.StringUtil.toIndentedString;



/** ApiPrepayRequest */
public class ApiPrepayRequest {
  @SerializedName("appid")
  private String appid;
  /** 直连商户号 说明：直连商户号 */
  @SerializedName("mchid")
  private String mchid;
  /** 商品描述 说明：商品描述 */
  @SerializedName("description")
  private String description;
  /** 商户订单号 说明：商户订单号 */
  @SerializedName("out_trade_no")
  private String outTradeNo;
  /** 交易结束时间 说明：订单失效时间，格式为rfc3339格式 */
  @SerializedName("time_expire")
  private String timeExpire;
  /** 附加数据 说明：附加数据 */
  @SerializedName("attach")
  private String attach;
  /** 通知地址 说明：有效性：1. HTTPS；2. 不允许携带查询串。 */
  @SerializedName("notify_url")
  private String notifyUrl;
  /** 订单优惠标记 说明：商品标记，代金券或立减优惠功能的参数。 */
  @SerializedName("goods_tag")
  private String goodsTag;
  @SerializedName("support_fapiao")
  private Boolean supportFapiao;
  /** amount */
  @SerializedName("amount")
  private Amount amount;
  /** detail */
  @SerializedName("detail")
  private ApiDetail detail;
  /** sceneInfo */
  @SerializedName("scene_info")
  private ApiSceneInfo sceneInfo;
  /** settleInfo */
  @SerializedName("settle_info")
  private ApiSettleInfo settleInfo;

  public String getAppid() {
    return appid;
  }

  public void setAppid(String appid) {
    this.appid = appid;
  }

  public String getMchid() {
    return mchid;
  }

  public void setMchid(String mchid) {
    this.mchid = mchid;
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
    sb.append("    appid: ").append(toIndentedString(appid)).append("\n");
    sb.append("    mchid: ").append(toIndentedString(mchid)).append("\n");
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
