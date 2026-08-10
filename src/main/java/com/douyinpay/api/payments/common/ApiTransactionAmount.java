package com.douyinpay.api.payments.common;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

/**
 * ApiTransactionAmount
 */
public class ApiTransactionAmount {
    /**
     * 字段含义：订单币种。
     * 格式规则：符合 ISO 4217 标准的三位字母代码。
     * 业务规则：境内商户号当前仅支持人民币。
     * 示例：CNY
     */
    @SerializedName("currency")
    private String currency;
    /**
     * 字段含义：用户支付币种。
     * 格式规则：符合 ISO 4217 标准的三位字母代码。
     * 业务规则：境内商户号当前仅支持人民币。
     * 示例：CNY
     */
    @SerializedName("payer_currency")
    private String payerCurrency;
    /**
     * 字段含义：用户支付金额。
     * 格式规则：单位为分的整数。
     * 业务规则：表示用户实际支付的现金金额。
     * 示例：100
     */
    @SerializedName("payer_total")
    private Integer payerTotal;
    /**
     * 字段含义：订单总金额。
     * 格式规则：单位为分的整数。
     * 业务规则：表示订单总金额。
     * 示例：100
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