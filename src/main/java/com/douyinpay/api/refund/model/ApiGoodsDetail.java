
package com.douyinpay.api.refund.model;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** ApiGoodsDetail */
public class ApiGoodsDetail {
  /** 商户侧商品编码 说明：由半角的大小写字母、数字、中划线、下划线中的一种或几种组成 */
  @SerializedName("merchant_goods_id")
  private String merchantGoodsId;
  /** 抖音侧商品编码 说明：抖音支付定义的统一商品编号（没有可不传） */
  @SerializedName("douyinpay_goods_id")
  private String douyinpayGoodsId;
  /** 商品名称 说明：商品的实际名称 */
  @SerializedName("goods_name")
  private String goodsName;
  /** 商品单价 说明：商品单价金额，单位为分 */
  @SerializedName("unit_price")
  private Long unitPrice;
  /** 商品退款金额 说明：商品退款金额，单位为分 */
  @SerializedName("refund_amount")
  private Long refundAmount;
  /** 商品退货数量 说明：对应商品的退货数量 */
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
