package com.douyinpay.api.cashier.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** ApiGoodsDetail */
public class ApiGoodsDetail {
  /**
   * 字段含义：商户侧商品编码。
   * 格式规则：string[1,32]。
   * 业务规则：商户系统内部的商品编码。
   * 示例：app-01
   */
  @SerializedName("merchant_goods_id")
  private String merchantGoodsId;
  /**
   * 字段含义：抖音支付商品编码。
   * 格式规则：string[1,32]。
   * 业务规则：抖音支付侧的商品编码，选填。
   * 示例：
   * TODO: 官方文档未提供标准示例值，暂留空。
   */
  @SerializedName("douyinpay_goods_id")
  private String douyinpayGoodsId;
  /**
   * 字段含义：商品名称。
   * 格式规则：string[1,256]。
   * 业务规则：商品的名称，选填。
   * 示例：ipad
   */
  @SerializedName("goods_name")
  private String goodsName;
  /**
   * 字段含义：商品数量。
   * 格式规则：int。
   * 业务规则：与商品单价共同参与订单金额校验。
   * 示例：2
   */
  @SerializedName("quantity")
  private Integer quantity;
  /**
   * 字段含义：商品单价。
   * 格式规则：int。
   * 业务规则：单位为分；与商品数量共同参与订单金额校验。
   * 示例：2000
   */
  @SerializedName("unit_price")
  private Long unitPrice;

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

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Long getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(Long unitPrice) {
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
