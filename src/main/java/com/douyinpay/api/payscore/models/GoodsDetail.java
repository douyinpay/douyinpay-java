package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

// 单品详情
public class GoodsDetail {
    // 字段含义：商品编码。
    // 格式规则：string。
    // 示例：1001。
    @SerializedName("goods_id")
    private String goodsId;
    // 字段含义：商品数量。
    // 格式规则：int32。
    // 示例：100。
    @SerializedName("quantity")
    private Integer quantity;
    // 字段含义：商品价格。
    // 格式规则：int。
    // 业务规则：单位分。
    // 示例：100。
    @SerializedName("unit_price")
    private Integer unitPrice;
    // 字段含义：商品优惠金额。
    // 格式规则：int。
    // 业务规则：单位分。
    // 示例：100。
    @SerializedName("discount_amount")
    private Integer discountAmount;
    // 字段含义：商品备注。
    // 格式规则：string。
    // 示例：商品备注。
    @SerializedName("goods_remark")
    private String goodsRemark;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
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

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Integer discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getGoodsRemark() {
        return goodsRemark;
    }

    public void setGoodsRemark(String goodsRemark) {
        this.goodsRemark = goodsRemark;
    }

    @Override
    public String toString() {
        return "GoodsDetail{" +
                "goodsId='" + goodsId + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", discountAmount=" + discountAmount +
                ", goodsRemark='" + goodsRemark + '\'' +
                '}';
    }
}
