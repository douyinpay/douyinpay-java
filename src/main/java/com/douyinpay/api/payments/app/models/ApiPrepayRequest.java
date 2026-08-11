package com.douyinpay.api.payments.app.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import static com.douyinpay.util.StringUtil.toIndentedString;



/** ApiPrepayRequest */
public class ApiPrepayRequest {
  /**
   * 字段含义：应用ID。
   * 格式规则：字符串。
   * 业务规则：由抖音开放平台生成，需与当前商户号完成绑定。
   * 示例：awofz9bncda6w123
   */
  @SerializedName("appid")
  private String appid;
  /**
   * 字段含义：直连商户号。
   * 格式规则：字符串。
   * 业务规则：由抖音支付生成并下发，用于标识当前直连商户。
   * 示例：6020230307605084
   */
  @SerializedName("mchid")
  private String mchid;
  /**
   * 字段含义：商品描述。
   * 格式规则：字符串。
   * 业务规则：用于描述本次交易商品或服务信息。
   * 示例：抖音支付测试
   */
  @SerializedName("description")
  private String description;
  /**
   * 字段含义：商户订单号。
   * 格式规则：仅支持数字、大小写字母、_、-、*。
   * 业务规则：同一商户号下需保持唯一；同一订单号重复请求按同一笔订单处理。
   * 示例：OUT_1666688488
   */
  @SerializedName("out_trade_no")
  private String outTradeNo;
  /**
   * 字段含义：交易结束时间。
   * 格式规则：遵循 RFC 3339 标准格式。
   * 业务规则：需在下单时间 15 天内；若用户支付已超时，应使用新的商户订单号重新下单。
   * 示例：2018-06-08T10:34:56+08:00
   */
  @SerializedName("time_expire")
  private String timeExpire;
  /**
   * 字段含义：附加数据。
   * 格式规则：字符串。
   * 业务规则：在查询接口和支付通知中原样返回，可作为商户自定义透传参数。
   * 示例：自定义数据
   */
  @SerializedName("attach")
  private String attach;
  /**
   * 字段含义：通知地址。
   * 格式规则：HTTPS 外网可访问地址，且不允许携带查询串。
   * 业务规则：用于接收抖音支付异步通知。
   * 示例：https://www.mock.douyinpay.com
   */
  @SerializedName("notify_url")
  private String notifyUrl;
  /**
   * 字段含义：优惠标记。
   * 格式规则：JSON 字符串。
   * 业务规则：需与抖音支付协商使用，可区分业务场景、产品标签或指定优惠信息。
   * 示例：{"biz_scene":"","product_tag":"","assign_discounts":""}
   */
  @SerializedName("goods_tag")
  private String goodsTag;
  /**
   * 字段含义：电子发票入口开放标识。
   * 格式规则：boolean。
   * 业务规则：预留字段，开放文档说明商户无需传入。
   * 示例：false
   */
  @SerializedName("support_fapiao")
  private Boolean supportFapiao;
  /**
   * 字段含义：金额信息。
   * 格式规则：对象。
   * 业务规则：包含订单或退款金额相关字段。
   * 示例：{"total":100,"currency":"CNY"}
   */
  @SerializedName("amount")
  private Amount amount;
  /**
   * 字段含义：优惠信息。
   * 格式规则：对象。
   * 业务规则：包含订单原价、商品小票 ID 和单品列表等信息。
   * 示例：
   */
  @SerializedName("detail")
  private ApiDetail detail;
  /**
   * 字段含义：支付场景信息。
   * 格式规则：对象。
   * 业务规则：用于补充终端 IP、设备号、门店信息等场景数据。
   * 示例：
   */
  @SerializedName("scene_info")
  private ApiSceneInfo sceneInfo;
  /**
   * 字段含义：结算信息。
   * 格式规则：对象。
   * 业务规则：可指定订单是否支持分账。
   * 示例：{"profit_sharing":false}
   */
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
