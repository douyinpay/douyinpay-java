package com.douyinpay.api.partnerdeduct.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;


public class ApiGoodsDetail {
  /** 商户侧商品编码 */
  @SerializedName("merchant_goods_id")
  private String merchantGoodsId;

  /** 抖音支付商品编码 */
  @SerializedName("douyinpay_goods_id")
  private String douyinpayGoodsId;
  /** 商品名称 */
  @SerializedName("goods_name")
  private String goodsName;
  /** 商品数量 */
  @SerializedName("quantity")
  private Integer quantity;
  /** 商品单价 */
  @SerializedName("unit_price")
  private Integer unitPrice;

  public String getMerchantGoodsId() {
    return merchantGoodsId;
  }

  public void setMerchantGoodsId(String merchantGoodsId) {
    this.merchantGoodsId = merchantGoodsId;
  }

  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Integer getUnitPrice() {
    return unitPrice;
  }
  public String getDouyinpayGoodsId() {
    return douyinpayGoodsId;
  }

  public void setDouyinpayGoodsId(String douyinpayGoodsId) {
    this.douyinpayGoodsId = douyinpayGoodsId;
  }
  public void setUnitPrice(Integer unitPrice) {
    this.unitPrice = unitPrice;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiGoodsDetail {\n");
    sb.append("    merchantGoodsId: ").append(toIndentedString(merchantGoodsId)).append("\n");
    sb.append("    douyinpayGoodsId: ").append(toIndentedString(douyinpayGoodsId)).append("\n");
    sb.append("    goodsName: ").append(toIndentedString(goodsName)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    unitPrice: ").append(toIndentedString(unitPrice)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
