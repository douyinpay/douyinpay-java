
package com.douyinpay.api.refund.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** Promotion */
public class ApiRefundPromotion {
  /**
   * 字段含义：券ID。
   * 格式规则：字符串。
   * 业务规则：表示券或者立减优惠 ID。
   * 示例：109519
   */
  @SerializedName("promotion_id")
  private String promotionId;
  /**
   * 字段含义：优惠券面额。
   * 格式规则：单位为分的整数。
   * 业务规则：表示用户享受优惠的金额，等于抖音出资金额、商家出资金额和其他出资方金额之和。
   * 示例：100
   */
  @SerializedName("amount")
  private Long amount;
  /**
   * 字段含义：商品退款金额。
   * 格式规则：单位为分的整数。
   * 业务规则：表示该商品维度的退款金额。
   * 示例：100
   */
  @SerializedName("refund_amount")
  private Long refundAmount;
  /**
   * 字段含义：退款商品明细。
   * 格式规则：数组。
   * 业务规则：优惠商品发生退款时返回商品信息。
   * 示例：
   */
  @SerializedName("goods_detail")
  private List<ApiGoodsDetail> goodsDetail;
  /**
   * 字段含义：优惠范围。
   * 格式规则：枚举字符串。
   * 业务规则：开放文档示例包含 GLOBAL、SINGLE。
   * 补充说明：GLOBAL 表示全场代金券，以订单整体可优惠金额为门槛；SINGLE 表示单品优惠，以具体单品总金额为门槛。
   * 示例：GLOBAL
   * @see com.douyinpay.enums.PromotionScopeEnum
   */
  @SerializedName("scope")
  private String promotionScope;
  /**
   * 字段含义：优惠类型。
   * 格式规则：枚举字符串。
   * 业务规则：开放文档示例包含 COUPON、DISCOUNT。
   * 补充说明：COUPON 表示需要走结算资金的充值型代金券，会随订单结算给订单收款商户；DISCOUNT 表示不走结算资金的免充值型优惠券。
   * 示例：COUPON
   * @see com.douyinpay.enums.RefundPromotionTypeEnum
   */
  @SerializedName("type")
  private String promotionType;

  public String getPromotionId() {
    return promotionId;
  }

  public void setPromotionId(String promotionId) {
    this.promotionId = promotionId;
  }

  public Long getAmount() {
    return amount;
  }

  public void setAmount(Long amount) {
    this.amount = amount;
  }

  public Long getRefundAmount() {
    return refundAmount;
  }

  public void setRefundAmount(Long refundAmount) {
    this.refundAmount = refundAmount;
  }

  public List<ApiGoodsDetail> getGoodsDetail() {
    return goodsDetail;
  }

  public void setGoodsDetail(List<ApiGoodsDetail> goodsDetail) {
    this.goodsDetail = goodsDetail;
  }

  public String getPromotionScope() {
    return promotionScope;
  }

  public void setPromotionScope(String promotionScope) {
    this.promotionScope = promotionScope;
  }

  public String getPromotionType() {
    return promotionType;
  }

  public void setPromotionType(String promotionType) {
    this.promotionType = promotionType;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Promotion {\n");
    sb.append("    promotionId: ").append(toIndentedString(promotionId)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    refundAmount: ").append(toIndentedString(refundAmount)).append("\n");
    sb.append("    goodsDetail: ").append(toIndentedString(goodsDetail)).append("\n");
    sb.append("    scope: ").append(toIndentedString(promotionScope)).append("\n");
    sb.append("    type: ").append(toIndentedString(promotionType)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
