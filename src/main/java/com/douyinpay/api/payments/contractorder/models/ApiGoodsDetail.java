package com.douyinpay.api.payments.contractorder.models;

import static com.douyinpay.util.StringUtil.toIndentedString;

import com.google.gson.annotations.SerializedName;

/** GoodsDetail */
public class ApiGoodsDetail {
  /**
   * 字段含义：商户侧商品编码。
   * 格式规则：字符串，长度 1-32 位，由半角大小写字母、数字、中划线、下划线组成。
   * 业务规则：当前接口文档未明确说明该字段的详细业务规则，暂保留字段定义以兼容现有模型。
   * 示例：
   */
  @SerializedName("merchant_goods_id")
  private String merchantGoodsId;

  /**
   * 字段含义：抖音支付商品编码。
   * 格式规则：字符串，长度 1-32 位。
   * 业务规则：抖音支付定义的统一商品编号，没有可不传。
   * 示例：
   */
  @SerializedName("douyinpay_goods_id")
  private String douyinpayGoodsId;
  /**
   * 字段含义：商品名称。
   * 格式规则：字符串，长度 1-256 位。
   * 业务规则：当前接口文档未明确说明该字段的详细业务规则，暂保留字段定义以兼容现有模型。
   * 示例：
   */
  @SerializedName("goods_name")
  private String goodsName;
  /**
   * 字段含义：商品数量。
   * 格式规则：整数。
   * 业务规则：当前接口文档未明确说明该字段的详细业务规则，暂保留字段定义以兼容现有模型。
   * 示例：
   */
  @SerializedName("quantity")
  private Integer quantity;
  /**
   * 字段含义：商品单价。
   * 格式规则：单位为分的整数。
   * 业务规则：当前接口文档未明确说明该字段的详细业务规则，暂保留字段定义以兼容现有模型。
   * 示例：
   */
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
