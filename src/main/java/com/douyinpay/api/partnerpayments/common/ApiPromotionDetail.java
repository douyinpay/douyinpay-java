package com.douyinpay.api.partnerpayments.common;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiPromotionDetail {
    /**
     * 字段含义：券 ID。
     * 格式规则：字符串。
     * 业务规则：表示优惠券或立减优惠 ID。
     * 示例：109123
     */
    @SerializedName("coupon_id")
    private String couponId;
    /**
     * 字段含义：优惠名称。
     * 格式规则：字符串。
     * 业务规则：表示本次交易命中的优惠名称。
     * 示例：下单立减1元
     */
    @SerializedName("name")
    private String name;

    /**
     * 字段含义：优惠范围。
     * 格式规则：枚举字符串。
     * 业务规则：开放文档示例包含 GLOBAL、SINGLE。
     * 示例：GLOBAL
     * 补充说明：GLOBAL 表示全场代金券，SINGLE 表示单品优惠。
     * @see com.douyinpay.enums.PromotionScopeEnum
     */
    @SerializedName("scope")
    private String scope;

    /**
     * 字段含义：优惠类型。
     * 格式规则：枚举字符串。
     * 业务规则：开放文档示例包含 CASH、NOCASH。
     * 示例：CASH
     * 补充说明：CASH 表示充值，NOCASH 表示预充值。
     * @see com.douyinpay.enums.PayPromotionTypeEnum
     */
    @SerializedName("type")
    private String type;
    /**
     * 字段含义：优惠券面额。
     * 格式规则：单位为分的整数。
     * 业务规则：表示本次优惠的总面额。
     * 示例：100
     */
    @SerializedName("amount")
    private Integer amount;
    /**
     * 字段含义：活动 ID。
     * 格式规则：字符串。
     * 业务规则：表示优惠活动批次 ID。
     * 示例：3321123
     */
    @SerializedName("stock_id")
    private String stockId;
    /**
     * 字段含义：抖音支付出资金额。
     * 格式规则：单位为分的整数。
     * 业务规则：表示优惠中由抖音支付承担的部分。
     * 示例：50
     */
    @SerializedName("douyinpay_contribute")
    private Integer douyinpayContribute;
    /**
     * 字段含义：商户出资金额。
     * 格式规则：单位为分的整数。
     * 业务规则：表示优惠中由商户承担的部分。
     * 示例：40
     */
    @SerializedName("merchant_contribute")
    private Integer merchantContribute;
    /**
     * 字段含义：其他出资金额。
     * 格式规则：单位为分的整数。
     * 业务规则：表示优惠中由其他出资方承担的部分。
     * 示例：10
     */
    @SerializedName("other_contribute")
    private Integer otherContribute;
    /**
     * 字段含义：优惠币种。
     * 格式规则：符合 ISO 4217 标准的三位字母代码。
     * 业务规则：境内商户号当前仅支持人民币。
     * 示例：CNY
     */
    @SerializedName("currency")
    private String currency;
    /**
     * 字段含义：优惠商品明细。
     * 格式规则：数组。
     * 业务规则：当优惠作用到具体商品时返回。
     * 示例：
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

    public void setDouyinpayContribute(Integer douyinpayContribute) {
        this.douyinpayContribute = douyinpayContribute;
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
