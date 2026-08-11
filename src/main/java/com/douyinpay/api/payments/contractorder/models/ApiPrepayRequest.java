package com.douyinpay.api.payments.contractorder.models;

import static com.douyinpay.util.StringUtil.toIndentedString;

import com.google.gson.annotations.SerializedName;

/** ApiPrepayRequest */
public class ApiPrepayRequest {
  /**
   * 字段含义：应用ID。
   * 格式规则：字符串，长度 1-32 位。
   * 业务规则：商户在抖音开放平台申请的应用 ID，全局唯一。
   * 示例：awofz9bncda6w2w4
   */
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
  /**
   * 字段含义：电子发票入口开放标识。
   * 格式规则：boolean。
   * 业务规则：预留字段，商户无需传入。
   * 示例：
   */
  @SerializedName("support_fapiao")
  private Boolean supportFapiao;
  /**
   * 字段含义：订单金额信息。
   * 格式规则：对象。
   * 业务规则：包含订单总金额和货币种类，其中金额单位为分。
   * 示例：{"total":100,"currency":"CNY"}
   */
  @SerializedName("amount")
  private Amount amount;
  /**
   * 字段含义：优惠信息。
   * 格式规则：对象。
   * 业务规则：预留字段，商户无需传入。
   * 示例：
   */
  @SerializedName("detail")
  private ApiDetail detail;
  /**
   * 字段含义：场景信息。
   * 格式规则：对象。
   * 业务规则：用于传递用户终端 IP、商户端设备号和用户终端设备号等支付场景描述信息。
   * 示例：{"device_id":"013467007045764","payer_client_ip":"14.23.150.211","payer_device_id":"a0e4b456-c9e5-3783-a422"}
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
   * 字段含义：交易类型。
   * 格式规则：枚举字符串。
   * 业务规则：APP 表示 APP 支付；JSAPI 表示 JSAPI 支付；MWEB 表示 H5 支付。
   * 示例：APP
   *
   * @see com.douyinpay.enums.TradeTypeEnum
   */
  @SerializedName("trade_type")
  private String tradeType;

  /**
   * 字段含义：用户标识。
   * 格式规则：字符串，长度 1-128 位。
   * 业务规则：当 trade_type=JSAPI 时传入，表示用户在商户 appid 下的唯一标识。
   * 示例：oUpF8uMuAJO_M2pxb1Q9zNjWeS6o
   */
  @SerializedName("openid")
  private String openId;

  /**
   * 字段含义：签约信息。
   * 格式规则：对象。
   * 业务规则：包含签约商户号、签约应用 ID、模板 ID、签约协议号和签约通知地址等信息。
   * 示例：{"contract_mchid":"6020230307605084","contract_appid":"awofz9bncda6w2w4","plan_id":"48","out_contract_code":"100001258","request_serial":1,"contract_display_account":"测试账号","contract_notify_url":"https://yoursite.com"}
   */
  private ContractInfo contractInfo;

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

  public String getTradeType() {
    return tradeType;
  }

  public void setTradeType(String tradeType) {
    this.tradeType = tradeType;
  }

  public String getOpenId() {
    return openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }

  public ContractInfo getContractInfo() {
    return contractInfo;
  }

  public void setContractInfo(ContractInfo contractInfo) {
    this.contractInfo = contractInfo;
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
    sb.append("    tradeType: ").append(toIndentedString(tradeType)).append("\n");
    sb.append("    openId: ").append(toIndentedString(openId)).append("\n");
    sb.append("    contractInfo: ").append(toIndentedString(contractInfo)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
