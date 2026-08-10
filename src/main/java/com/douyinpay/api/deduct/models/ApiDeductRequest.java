package com.douyinpay.api.deduct.models;

import com.google.gson.annotations.SerializedName;
import static com.douyinpay.util.StringUtil.toIndentedString;

/** ApiDeductRequest */
public class ApiDeductRequest {
  /**
   * 字段含义：应用ID。
   * 格式规则：字符串，长度 1-32 位。
   * 业务规则：由抖音支付生成的应用ID，全局唯一。
   * 示例：awofz9bncda6w2w4
   */
  @SerializedName("appid")
  private String appid;
  /** 直连商户号 说明：直连商户号 */
  @SerializedName("mchid")
  private String mchid;
  /** 商户订单号 说明：商户订单号 */
  @SerializedName("out_trade_no")
  private String outTradeNo;
  /** 交易结束时间 说明：订单失效时间，格式为rfc3339格式 */
  @SerializedName("time_expire")
  private String timeExpire;
  /**
   * 字段含义：委托代扣协议ID。
   * 格式规则：字符串，长度 1-64 位。
   * 业务规则：签约成功后，抖音支付返回的委托代扣协议ID。
   * 示例：MSN20230314112037389849955326013
   */
  @SerializedName("contract_id")
  private String contractId;
  /**
   * 字段含义：交易类型。
   * 格式规则：字符串，长度 1-3 位。
   * 业务规则：`SGP` 表示商户代扣；`NPP` 表示免密支付。
   * 示例：SGP
   */
  @SerializedName("trade_type")
  private String tradeType;
  /** 商品描述 说明：商品描述 */
  @SerializedName("description")
  private String description;
  /** 通知地址 说明：有效性：1. HTTPS；2. 不允许携带查询串。 */
  @SerializedName("notify_url")
  private String notifyUrl;
  /** 附加数据 说明：附加数据 */
  @SerializedName("attach")
  private String attach;
  /**
   * 字段含义：优惠信息。
   * 格式规则：对象。
   * 业务规则：为预留字段，商户不需要传。
   * 示例：{"cost_price":608800,"invoice_id":"dy123","goods_detail":[{"goods_name":"iPhoneX 256G","merchant_goods_id":"ABC","quantity":1,"unit_price":828800,"douyinpay_goods_id":"1001"}]}
   */
  @SerializedName("detail")
  private ApiDetail detail;
  /**
   * 字段含义：订单金额信息。
   * 格式规则：对象。
   * 业务规则：包含订单总金额和货币种类，其中金额单位为分。
   * 示例：{"currency":"CNY","total":100}
   */
  @SerializedName("amount")
  private Amount amount;
  /**
   * 字段含义：场景信息。
   * 格式规则：对象。
   * 业务规则：支付场景描述，免密支付产品需要传。
   * 示例：{"device_id":"13467007045764","payer_client_ip":"14.23.150.211","payer_device_id":"a0e4b456-c9e5-3783-a422"}
   */
  @SerializedName("scene_info")
  private ApiSceneInfo sceneInfo;
  /**
   * 字段含义：结算信息。
   * 格式规则：对象。
   * 业务规则：用于指定订单支付成功后是否支持分账。
   * 示例：{"profit_sharing":false}
   */
  @SerializedName("settle_info")
  private ApiSettleInfo settleInfo;
  /**
   * 字段含义：优惠标记。
   * 格式规则：JSON 字符串，长度 1-512 位。
   * 业务规则：与抖音支付协商后可用。
   * 示例：
   */
  @SerializedName("goods_tag")
  private String goodsTag;

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

  public String getContractId() {
    return contractId;
  }

  public void setContractId(String contractId) {
    this.contractId = contractId;
  }

  public String getTradeType() {
    return tradeType;
  }

  public void setTradeType(String tradeType) {
    this.tradeType = tradeType;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getNotifyUrl() {
    return notifyUrl;
  }

  public void setNotifyUrl(String notifyUrl) {
    this.notifyUrl = notifyUrl;
  }

  public String getAttach() {
    return attach;
  }

  public void setAttach(String attach) {
    this.attach = attach;
  }

  public ApiDetail getDetail() {
    return detail;
  }

  public void setDetail(ApiDetail detail) {
    this.detail = detail;
  }

  public Amount getAmount() {
    return amount;
  }

  public void setAmount(Amount amount) {
    this.amount = amount;
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

  public String getGoodsTag() {
    return goodsTag;
  }

  public void setGoodsTag(String goodsTag) {
    this.goodsTag = goodsTag;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiDeductRequest {\n");
    sb.append("    appid: ").append(toIndentedString(appid)).append("\n");
    sb.append("    mchid: ").append(toIndentedString(mchid)).append("\n");
    sb.append("    outTradeNo: ").append(toIndentedString(outTradeNo)).append("\n");
    sb.append("    timeExpire: ").append(toIndentedString(timeExpire)).append("\n");
    sb.append("    contractId: ").append(toIndentedString(contractId)).append("\n");
    sb.append("    tradeType: ").append(toIndentedString(tradeType)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    notifyUrl: ").append(toIndentedString(notifyUrl)).append("\n");
    sb.append("    attach: ").append(toIndentedString(attach)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    sceneInfo: ").append(toIndentedString(sceneInfo)).append("\n");
    sb.append("    settleInfo: ").append(toIndentedString(settleInfo)).append("\n");
    sb.append("    goodsTag: ").append(toIndentedString(goodsTag)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
