
package com.douyinpay.api.contract.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiDetail {
    /** 订单原价*/
    @SerializedName("cost_price")
    private Integer costPrice;
    /** 商品小票ID 说明：商家小票ID。*/
    @SerializedName("invoice_id")
    private String invoiceId;
    /** 单品列表 说明：为预留字段，商户不需要传 */
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
