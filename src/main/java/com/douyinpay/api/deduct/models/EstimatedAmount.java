package com.douyinpay.api.deduct.models;

public class EstimatedAmount {
    private int amount;
    private String currency;
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public int getAmount() {
        return amount;
    }
    public String getCurrency() {
        return currency;
    }
    @Override
    public String toString() {
    
        StringBuilder sb = new StringBuilder();
        sb.append("EstimatedAmount{")
            .append("amount=").append(amount)
            .append(", currency='").append(currency).append('\'')
            .append('}');
        return sb.toString();
    }
}
