
package com.douyinpay.api.partnerpayments.nativepay.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiDetail {
    @SerializedName("cost_price")
    private Integer costPrice;
    @SerializedName("invoice_id")
    private String invoiceId;
    @SerializedName("goods_detail")
    private List goodsDetail;

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

    public List getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(List goodsDetail) {
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
