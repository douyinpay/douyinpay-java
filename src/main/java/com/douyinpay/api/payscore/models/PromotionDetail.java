package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

// 优惠信息
public class PromotionDetail {
    // 字段含义：券ID。
    // 格式规则：string。
    // 示例：1001。
    @SerializedName("coupon_id")
    private String couponId;
    // 字段含义：优惠名称。
    // 格式规则：string。
    // 示例：下单立减1元。
    @SerializedName("name")
    private String name;
    // 字段含义：优惠范围。
    // 格式规则：string。
    // 业务规则：枚举值：GLOBAL：全场优惠；SINGLE：单品优惠。
    // 示例：GLOBAL。
    @SerializedName("scope")
    private String scope;
    // 字段含义：优惠类型。
    // 格式规则：string。
    // 业务规则：枚举值：CASH：充值；NOCASH：免充值。
    // 示例：CASH。
    @SerializedName("type")
    private String type;
    // 字段含义：优惠券面额。
    // 格式规则：int64。
    // 业务规则：单位分。
    // 示例：100。
    @SerializedName("amount")
    private Integer amount;
    // 字段含义：活动ID。
    // 格式规则：string。
    // 示例：1001。
    @SerializedName("stock_id")
    private String stockId;
    // 字段含义：抖音支付出资。
    // 格式规则：int64。
    // 业务规则：单位分。
    // 示例：100。
    @SerializedName("douyinpay_contribute")
    private Integer douyinpayContribute;
    // 字段含义：商户出资。
    // 格式规则：int64。
    // 业务规则：单位分。
    // 示例：100。
    @SerializedName("merchant_contribute")
    private Integer merchantContribute;
    // 字段含义：其他出资。
    // 格式规则：int64。
    // 业务规则：单位分。
    // 示例：100。
    @SerializedName("other_contribute")
    private Integer otherContribute;
    // 字段含义：优惠币种。
    // 格式规则：string。
    // 业务规则：CNY：人民币，境内商户号仅支持人民币。
    // 示例：CNY。
    @SerializedName("currency")
    private String currency;
    // 字段含义：商品列表。
    // 格式规则：array。
    // 业务规则：预留字段。
    // 示例：[{"goods_id":"D123456","quantity":1,"unit_price":10000,"discount_amount":0,"goods_remark":"商品备注"}]。
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
