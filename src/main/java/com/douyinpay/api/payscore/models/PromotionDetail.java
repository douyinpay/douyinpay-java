package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

// 优惠信息
public class PromotionDetail {
    /**
     * 券ID
     */
    @SerializedName("coupon_id")
    private String couponId;
    /**
     * 优惠名称
     */
    @SerializedName("name")
    private String name;
    /**
     * 优惠范围
     */
    @SerializedName("scope")
    private String scope;
    /**
     * 优惠类型
     */
    @SerializedName("type")
    private String type;
    /**
     * 优惠面额
     */
    @SerializedName("amount")
    private Integer amount;
    /**
     * 活动ID
     */
    @SerializedName("stock_id")
    private String stockId;
    /**
     * 抖音支付出资
     */
    @SerializedName("douyinpay_contribute")
    private Integer douyinpayContribute;
    /**
     * 商户出资
     */
    @SerializedName("merchant_contribute")
    private Integer merchantContribute;
    /**
     * 其他出资
     */
    @SerializedName("other_contribute")
    private Integer otherContribute;
    /**
     * 优惠币种
     */
    @SerializedName("currency")
    private String currency;
    /**
     * 单品列表
     */
    @SerializedName("goods_detail")
    private List<GoodsDetail> goodsDetails;

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public Integer getDouyinpayContribute() {
        return douyinpayContribute;
    }

    public void setDouyinpayContribute(Integer douyinpayContribute) {
        this.douyinpayContribute = douyinpayContribute;
    }

    public Integer getMerchantContribute() {
        return merchantContribute;
    }

    public void setMerchantContribute(Integer merchantContribute) {
        this.merchantContribute = merchantContribute;
    }

    public Integer getOtherContribute() {
        return otherContribute;
    }

    public void setOtherContribute(Integer otherContribute) {
        this.otherContribute = otherContribute;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<GoodsDetail> getGoodsDetails() {
        return goodsDetails;
    }

    public void setGoodsDetails(List<GoodsDetail> goodsDetails) {
        this.goodsDetails = goodsDetails;
    }

    @Override
    public String toString() {
        return "PromotionDetail{" +
                "couponId='" + couponId + '\'' +
                ", name='" + name + '\'' +
                ", scope='" + scope + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", stockId='" + stockId + '\'' +
                ", douyinpayContribute=" + douyinpayContribute +
                ", merchantContribute=" + merchantContribute +
                ", otherContribute=" + otherContribute +
                ", currency='" + currency + '\'' +
                ", goodsDetails=" + goodsDetails +
                '}';
    }
}
