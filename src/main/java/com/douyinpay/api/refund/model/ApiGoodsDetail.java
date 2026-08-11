
package com.douyinpay.api.refund.model;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** ApiGoodsDetail */
public class ApiGoodsDetail {
  /**
   * 字段含义：商户侧商品编码。
   * 格式规则：由半角大小写字母、数字、中划线、下划线组成。
   * 业务规则：用于标识商户侧商品。
   * 示例：ABC
   */
  @SerializedName("merchant_goods_id")
  private String merchantGoodsId;
  /**
   * 字段含义：抖音支付商品编码。
   * 格式规则：字符串。
   * 业务规则：抖音支付定义的统一商品编号，没有可不传。
   * 示例：1001
   */
  @SerializedName("douyinpay_goods_id")
  private String douyinpayGoodsId;
  /**
   * 字段含义：商品名称。
   * 格式规则：字符串。
   * 业务规则：表示商品的实际名称。
   * 示例：iPhoneX 256G
   */
  @SerializedName("goods_name")
  private String goodsName;
  /**
   * 字段含义：商品单价。
   * 格式规则：单位为分的整数。
   * 业务规则：表示商品单价金额。
   * 示例：100
   */
  @SerializedName("unit_price")
  private Long unitPrice;
  /**
   * 字段含义：商品退款金额。
   * 格式规则：单位为分的整数。
   * 业务规则：表示该商品维度的退款金额。
   * 示例：100
   */
  @SerializedName("refund_amount")
  private Long refundAmount;
  /**
   * 字段含义：商品退货数量。
   * 格式规则：整数。
   * 业务规则：表示对应商品的退货数量。
   * 示例：1
   */
  @SerializedName("refund_quantity")
  private Integer refundQuantity;

  public String getMerchantGoodsId() {
    return merchantGoodsId;
  }

  public void setMerchantGoodsId(String merchantGoodsId) {
    this.merchantGoodsId = merchantGoodsId;
  }

  public String getDouyinpayGoodsId() {
    return douyinpayGoodsId;
  }

  public void setDouyinpayGoodsId(String douyinpayGoodsId) {
    this.douyinpayGoodsId = douyinpayGoodsId;
  }

  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }

  public Long getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(Long unitPrice) {
    this.unitPrice = unitPrice;
  }

  public Long getRefundAmount() {
    return refundAmount;
  }

  public void setRefundAmount(Long refundAmount) {
    this.refundAmount = refundAmount;
  }

  public Integer getRefundQuantity() {
    return refundQuantity;
  }

  public void setRefundQuantity(Integer refundQuantity) {
    this.refundQuantity = refundQuantity;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiGoodsDetail {\n");
    sb.append("    merchantGoodsId: ").append(toIndentedString(merchantGoodsId)).append("\n");
    sb.append("    douyinpayGoodsId: ").append(toIndentedString(douyinpayGoodsId)).append("\n");
    sb.append("    goodsName: ").append(toIndentedString(goodsName)).append("\n");
    sb.append("    unitPrice: ").append(toIndentedString(unitPrice)).append("\n");
    sb.append("    refundAmount: ").append(toIndentedString(refundAmount)).append("\n");
    sb.append("    refundQuantity: ").append(toIndentedString(refundQuantity)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
