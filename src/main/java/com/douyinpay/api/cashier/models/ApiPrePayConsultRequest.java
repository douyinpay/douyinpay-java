package com.douyinpay.api.cashier.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import static com.douyinpay.util.StringUtil.toIndentedString;

/** ApiPrePayConsultRequest */
public class ApiPrePayConsultRequest {
  /**
   * 字段含义：应用ID。
   * 格式规则：string[1,32]。
   * 业务规则：商家入驻抖音开放平台时分配的应用 ID，需与商户号有绑定关系。
   * 示例：awofz9bncda6w2w4
   */
  @SerializedName("appid")
  private String appid;
  /**
   * 字段含义：直连商户号。
   * 格式规则：string[1,32]。
   * 业务规则：商家入驻抖音支付商家平台分配的商户号。
   * 示例：6020230307605084
   */
  @SerializedName("mchid")
  private String mchid;
  /**
   * 字段含义：商户订单号。
   * 格式规则：string[6,32]，只能是数字、大小写字母、_、-、*。
   * 业务规则：商户系统内部订单号，在同一商户号下唯一。
   * 示例：OUT_1666688488
   */
  @SerializedName("out_trade_no")
  private String outTradeNo;
  /**
   * 字段含义：服务ID。
   * 格式规则：string[1,32]。
   * 业务规则：先享后付业务接入时分配，配置商户和场景维度信息；咨询先享后付渠道时必传。
   * 示例：100001
   */
  @SerializedName("service_id")
  private String serviceId;
  /**
   * 字段含义：营销优惠标记。
   * 格式规则：string[1,512]，键值对类型的 JSON 数据序列化后的字符串。
   * 业务规则：用于营销差异化展示的标记信息，需与抖音支付协商后传递；可传入业务场景 biz_scene、个性化策略 product_tag。
   * 示例：{"biz_scene":"pre_consult","product_tag":"default"}
   */
  @SerializedName("goods_tag")
  private String goodsTag;
  /**
   * 字段含义：订单总金额。
   * 格式规则：string[1,11]。
   * 业务规则：单位为分；若需要查询用户营销（例如获取 operation_tip），本字段为必传字段；有订单金额且参与计算的优惠金额大于 0
   * 时，返回满足条件的营销信息。
   * 示例：2000
   */
  @SerializedName("total_amount")
  private String totalAmount;
  /**
   * 字段含义：不参与优惠计算订单金额。
   * 格式规则：string[1,11]。
   * 业务规则：单位为分，表示订单中不参与优惠计算的金额。
   * 示例：100
   */
  @SerializedName("undiscountable_amount")
  private String undiscountableAmount;
  /**
   * 字段含义：支付产品。
   * 格式规则：字符串数组，暂时只支持传一个支付产品。
   * 业务规则：若需要查询用户营销（例如获取 operation_tip），本字段为必传字段；取值需与
   * commerical_product_code、trade_type 按官方文档映射表组合传入。
   * 示例：["NormalPay"]
   */
  @SerializedName("product_code")
  private List<String> productCode;
  /**
   * 字段含义：商业产品码。
   * 格式规则：string，暂时只支持传一个商业产品码。
   * 业务规则：商家和抖音支付签约的产品码；若需要查询用户营销（例如获取 operation_tip），本字段为必传字段。
   * 示例：CO_PAY_APP
   */
  @SerializedName("commerical_product_code")
  private String commericalProductCode;
  /**
   * 字段含义：交易类型。
   * 格式规则：string。
   * 业务规则：当前订单的交易类型；若需要查询用户营销（例如获取 operation_tip），本字段为必传字段；取值需与
   * product_code、commerical_product_code 按官方文档映射表组合传入。
   * 示例：APP
   */
  @SerializedName("trade_type")
  private String tradeType;
  /**
   * 字段含义：签约模板号。
   * 格式规则：string。
   * 业务规则：代扣签约的模板 ID，商户接入时由支付系统分配；签约、代扣类咨询请求可传入。
   * 示例：2420
   */
  @SerializedName("template_id")
  private String templateId;
  /**
   * 字段含义：商品列表信息。
   * 格式规则：对象数组。
   * 业务规则：订单包含的商品列表信息；传入的商品数量与商品单价乘积总和不可超过订单金额，即 sum{quantity*unit_price} <=
   * total_amount，不满足时返回参数错误。
   * 示例：[{"merchant_goods_id":"app-01","goods_name":"ipad","quantity":2,"unit_price":2000}]
   */
  @SerializedName("goods_detail")
  private List<ApiGoodsDetail> goodsDetail;
  /**
   * 字段含义：用户唯一标识。
   * 格式规则：string[1,64]。
   * 业务规则：openid 是用户在应用下的唯一用户标识；openid、加密手机号、设备号能获取到任意一项则真实上送，三项均无法获取时支持全部留空；推荐优先传
   * openid 以获得最佳接口性能，传入后以 openid 为最高优先级查询用户身份；三项均未传时按抖音新用户查询新用户营销信息。
   * 示例：V3WvSshYq9wWnB
   */
  @SerializedName("openid")
  private String openid;
  /**
   * 字段含义：设备号。
   * 格式规则：string[1,64]。
   * 业务规则：设备号类型由 device_type 字段指定；openid、加密手机号、设备号能获取到任意一项则真实上送；当 openid
   * 无法获取时，推荐同时传入 device_id 和 blind_mobile_list 以提升匹配精度。
   * 示例：14b07957e368d91
   */
  @SerializedName("device_id")
  private String deviceId;
  /**
   * 字段含义：设备号类型。
   * 格式规则：string[1,16]，枚举字符串。
   * 业务规则：与设备号 device_id 字段组合使用；OAID 表示 OAID，IDFA 表示 IDFA，CAID 表示 CAID（若有多个取最新的）。
   * 示例：OAID
   */
  @SerializedName("device_type")
  private String deviceType;
  /**
   * 字段含义：手机号列表。
   * 格式规则：字符串数组，使用 SHA256 算法盲化后的手机号，目前最多支持同时查询两个手机号。
   * 业务规则：仅支持境内手机号；openid、加密手机号、设备号能获取到任意一项则真实上送；当 openid 无法获取时，推荐同时传入 device_id 和
   * blind_mobile_list 以提升匹配精度。
   * 示例：["66d0fba82f83396b8c37c47e151f8076a479064eccd78517b604646040e8fcfd"]
   */
  @SerializedName("blind_mobile_list")
  private List<String> blindMobileList;
  /**
   * 字段含义：手机号加密方式。
   * 格式规则：string[1,32]，枚举字符串。
   * 业务规则：与手机号列表 blind_mobile_list 组合使用，目前仅支持 SHA256 算法。
   * 示例：SHA256
   */
  @SerializedName("encrypt_type")
  private String encryptType;
  /**
   * 字段含义：拓展字段。
   * 格式规则：string[1,1024]，键值对类型的 JSON 数据。
   * 业务规则：用于传递拓展信息，需与抖音支付协商后传递。
   */
  @SerializedName("ext_info")
  private String extInfo;

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

  public String getServiceId() {
    return serviceId;
  }

  public void setServiceId(String serviceId) {
    this.serviceId = serviceId;
  }

  public String getGoodsTag() {
    return goodsTag;
  }

  public void setGoodsTag(String goodsTag) {
    this.goodsTag = goodsTag;
  }

  public String getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(String totalAmount) {
    this.totalAmount = totalAmount;
  }

  public String getUndiscountableAmount() {
    return undiscountableAmount;
  }

  public void setUndiscountableAmount(String undiscountableAmount) {
    this.undiscountableAmount = undiscountableAmount;
  }

  public List<String> getProductCode() {
    return productCode;
  }

  public void setProductCode(List<String> productCode) {
    this.productCode = productCode;
  }

  public String getCommericalProductCode() {
    return commericalProductCode;
  }

  public void setCommericalProductCode(String commericalProductCode) {
    this.commericalProductCode = commericalProductCode;
  }

  public String getTradeType() {
    return tradeType;
  }

  public void setTradeType(String tradeType) {
    this.tradeType = tradeType;
  }

  public String getTemplateId() {
    return templateId;
  }

  public void setTemplateId(String templateId) {
    this.templateId = templateId;
  }

  public List<ApiGoodsDetail> getGoodsDetail() {
    return goodsDetail;
  }

  public void setGoodsDetail(List<ApiGoodsDetail> goodsDetail) {
    this.goodsDetail = goodsDetail;
  }

  public String getOpenid() {
    return openid;
  }

  public void setOpenid(String openid) {
    this.openid = openid;
  }

  public String getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }

  public String getDeviceType() {
    return deviceType;
  }

  public void setDeviceType(String deviceType) {
    this.deviceType = deviceType;
  }

  public List<String> getBlindMobileList() {
    return blindMobileList;
  }

  public void setBlindMobileList(List<String> blindMobileList) {
    this.blindMobileList = blindMobileList;
  }

  public String getEncryptType() {
    return encryptType;
  }

  public void setEncryptType(String encryptType) {
    this.encryptType = encryptType;
  }

  public String getExtInfo() {
    return extInfo;
  }

  public void setExtInfo(String extInfo) {
    this.extInfo = extInfo;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiPrePayConsultRequest {\n");
    sb.append("    appid: ").append(toIndentedString(appid)).append("\n");
    sb.append("    mchid: ").append(toIndentedString(mchid)).append("\n");
    sb.append("    outTradeNo: ").append(toIndentedString(outTradeNo)).append("\n");
    sb.append("    serviceId: ").append(toIndentedString(serviceId)).append("\n");
    sb.append("    goodsTag: ").append(toIndentedString(goodsTag)).append("\n");
    sb.append("    totalAmount: ").append(toIndentedString(totalAmount)).append("\n");
    sb.append("    undiscountableAmount: ").append(toIndentedString(undiscountableAmount)).append("\n");
    sb.append("    productCode: ").append(toIndentedString(productCode)).append("\n");
    sb.append("    commericalProductCode: ").append(toIndentedString(commericalProductCode)).append("\n");
    sb.append("    tradeType: ").append(toIndentedString(tradeType)).append("\n");
    sb.append("    templateId: ").append(toIndentedString(templateId)).append("\n");
    sb.append("    goodsDetail: ").append(toIndentedString(goodsDetail)).append("\n");
    sb.append("    openid: ").append(toIndentedString(openid)).append("\n");
    sb.append("    deviceId: ").append(toIndentedString(deviceId)).append("\n");
    sb.append("    deviceType: ").append(toIndentedString(deviceType)).append("\n");
    sb.append("    blindMobileList: ").append(toIndentedString(blindMobileList)).append("\n");
    sb.append("    encryptType: ").append(toIndentedString(encryptType)).append("\n");
    sb.append("    extInfo: ").append(toIndentedString(extInfo)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
