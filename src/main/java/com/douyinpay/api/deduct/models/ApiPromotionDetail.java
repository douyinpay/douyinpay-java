package com.douyinpay.api.deduct.models;

import com.douyinpay.enums.PayPromotionTypeEnum;
import com.douyinpay.enums.PromotionScopeEnum;
import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * ApiPromotionDetail
 */
public class ApiPromotionDetail {
    /**
     * 券ID 说明：券ID
     */
    @SerializedName("coupon_id")
    private String couponId;
    /**
     * 优惠名称 说明：优惠名称
     */
    @SerializedName("name")
    private String name;

    /**
     * GLOBAL：全场代金券；SINGLE：单品优惠
     * @see PromotionScopeEnum
     */
    @SerializedName("scope")
    private String scope;

    /**
     * CASH：充值；NOCASH：预充值。
     * @seePayPromotionTypeEnum
     */
    @SerializedName("type")
    private String type;
    /**
     * 优惠券面额 说明：优惠券面额
     */
    @SerializedName("amount")
    private Integer amount;
    /**
     * 活动ID 说明：活动ID，批次ID
     */
    @SerializedName("stock_id")
    private String stockId;
    /**
     * 抖音支付出资 说明：单位为分
     */
    @SerializedName("douyinpay_contribute")
    private Integer douyinpayContribute;
    /**
     * 商户出资 说明：单位为分
     */
    @SerializedName("merchant_contribute")
    private Integer merchantContribute;
    /**
     * 其他出资 说明：单位为分
     */
    @SerializedName("other_contribute")
    private Integer otherContribute;
    /**
     * 优惠币种 说明：CNY：人民币，境内商户号仅支持人民币。
     */
    @SerializedName("currency")
    private String currency;
    /**
     * 单品列表
     */
    @SerializedName("goods_detail")
    private List<ApiPromotionGoodsDetail> goodsDetail;

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

    public void setDouyinContribute(Integer DouyinpayContribute) {
        this.douyinpayContribute = DouyinpayContribute;
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

    public List<ApiPromotionGoodsDetail> getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(List<ApiPromotionGoodsDetail> goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    @Override
    public String toString() {
        return GsonUtil.getGson().toJson(this);
    }
}
