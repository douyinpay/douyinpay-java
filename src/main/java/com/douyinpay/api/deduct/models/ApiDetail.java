
package com.douyinpay.api.deduct.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import static com.douyinpay.util.StringUtil.toIndentedString;


/**
 * 优惠功能
 */
public class ApiDetail {
    /**
     * 字段含义：订单原价。
     * 格式规则：整型，单位为分。
     * 业务规则：为预留字段，商户不需要传。
     * 示例：
     */
    @SerializedName("cost_price")
    private Integer costPrice;
    /**
     * 字段含义：商品小票ID。
     * 格式规则：字符串，长度 1-32 位。
     * 业务规则：为预留字段，商户不需要传。
     * 示例：
     */
    @SerializedName("invoice_id")
    private String invoiceId;
    /**
     * 字段含义：单品列表。
     * 格式规则：数组。
     * 业务规则：为预留字段，商户不需要传；如传入时至少包含 1 条商品明细。
     * 示例：
     */
    @SerializedName("goods_detail")
    private List<ApiGoodsDetail> goodsDetail;

    public Integer getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Integer costPrice) {
        this.costPrice = costPrice;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public List<ApiGoodsDetail> getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(List<ApiGoodsDetail> goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiDetail {\n");
        sb.append("    costPrice: ").append(toIndentedString(costPrice)).append("\n");
        sb.append("    invoiceId: ").append(toIndentedString(invoiceId)).append("\n");
        sb.append("    goodsDetail: ").append(toIndentedString(goodsDetail)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
