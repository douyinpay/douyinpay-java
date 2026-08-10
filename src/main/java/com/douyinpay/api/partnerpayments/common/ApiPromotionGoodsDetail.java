package com.douyinpay.api.partnerpayments.common;
import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;


public class ApiPromotionGoodsDetail {
    /**
     * 字段含义：商品编码。
     * 格式规则：字符串。
     * 业务规则：用于标识参与优惠的商品。
     * 示例：1001
     */
    @SerializedName("goods_id")
    private String goodsId;
    /**
     * 字段含义：商品数量。
     * 格式规则：整数。
     * 业务规则：表示该优惠明细对应的商品数量。
     * 示例：1
     */
    @SerializedName("quantity")
    private Integer quantity;
    /**
     * 字段含义：商品价格。
     * 格式规则：单位为分的整数。
     * 业务规则：表示该优惠明细对应的商品单价。
     * 示例：100
     */
    @SerializedName("unit_price")
    private Integer unitPrice;
    /**
     * 字段含义：商品优惠金额。
     * 格式规则：单位为分的整数。
     * 业务规则：表示该商品维度的优惠金额。
     * 示例：100
     */
    @SerializedName("discount_amount")
    private Integer discountAmount;
    /**
     * 字段含义：商品备注。
     * 格式规则：字符串。
     * 业务规则：用于补充该商品维度的备注信息。
     * 示例：
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
        return GsonUtil.getGson().toJson(this);
    }
}
