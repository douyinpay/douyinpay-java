package com.douyinpay.api.partnerpayments.common;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiTransactionAmount {
    /**
     * 货币类型
     */
    @SerializedName("currency")
    private String currency;
    /**
     * 用户支付币种
     */
    @SerializedName("payer_currency")
    private String payerCurrency;
    /**
     * 用户支付金额
     */
    @SerializedName("payer_total")
    private Integer payerTotal;
    /**
     * 总金额
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