package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

// 单品详情
public class GoodsDetail {
    /**
     * 商品编码
     */
    @SerializedName("goods_id")
    private String goodsId;
    /**
     * 商品数量
     */
    @SerializedName("quantity")
    private Integer quantity;
    /**
     * 商品价格
     */
    @SerializedName("unit_price")
    private Integer unitPrice;
    /**
     * 商品优惠金额
     */
    @SerializedName("discount_amount")
    private Integer discountAmount;
    /**
     * 商品备注
     */
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
