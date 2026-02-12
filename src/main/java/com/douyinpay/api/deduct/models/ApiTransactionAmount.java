package com.douyinpay.api.deduct.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

/**
 * ApiTransactionAmount
 */
public class ApiTransactionAmount {
    /**
     * currency
     */
    @SerializedName("currency")
    private String currency;
    /**
     * payerCurrency
     */
    @SerializedName("payer_currency")
    private String payerCurrency;
    /**
     * payerTotal
     */
    @SerializedName("payer_total")
    private Integer payerTotal;
    /**
     * total
     */
    @SerializedName("total")
    private Integer total;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPayerCurrency() {
        return payerCurrency;
    }

    public void setPayerCurrency(String payerCurrency) {
        this.payerCurrency = payerCurrency;
    }

    public Integer getPayerTotal() {
        return payerTotal;
    }

    public void setPayerTotal(Integer payerTotal) {
        this.payerTotal = payerTotal;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return GsonUtil.getGson().toJson(this);
    }
}