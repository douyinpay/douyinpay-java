
package com.douyinpay.api.refund.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** Promotion */
public class ApiRefundPromotion {
  /** 券ID 说明：券或者立减优惠id */
  @SerializedName("promotion_id")
  private String promotionId;
  /** 优惠券面额 说明：用户享受优惠的金额（优惠券面额=抖音支付出资金额+商家出资金额+其他出资方金额 ），单位为分 */
  @SerializedName("amount")
  private Long amount;
  /** 优惠退款金额 说明：优惠退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为用户支付的现金，说明详见代金券或立减优惠，单位为分 */
  @SerializedName("refund_amount")
  private Long refundAmount;
  /** 商品列表 说明：优惠商品发生退款时返回商品信息 */
  @SerializedName("goods_detail")
  private List<ApiGoodsDetail> goodsDetail;
  /**
   *  优惠范围 说明：枚举值： - GLOBAL- 全场代金券 - SINGLE- 单品优惠
   * @see com.douyinpay.enums.PromotionScopeEnum
   * */
  @SerializedName("scope")
  private String promotionScope;
  /**
   * 优惠类型 说明：枚举值：
   * - COUPON- 代金券，需要走结算资金的充值型代金券
   * - DISCOUNT- 优惠券，不走结算资金的免充值型优惠券
   * @see com.douyinpay.enums.RefundPromotionTypeEnum
   *
   * */
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
