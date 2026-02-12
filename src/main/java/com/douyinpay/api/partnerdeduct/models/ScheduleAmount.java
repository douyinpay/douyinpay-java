package com.douyinpay.api.partnerdeduct.models;
import com.google.gson.annotations.SerializedName;
import static com.douyinpay.util.StringUtil.toIndentedString;

public class ScheduleAmount {
    /**
     * 金额
     */
    @SerializedName("total")
    private Integer total;
    /**
     * 货币类型
     */
    @SerializedName("currency")
    private String currency;

    public String getCurrency() {
        return currency;
    }
    public Integer getTotal() {
        return total;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ScheduleAmount {\n");
        sb.append("    total: ").append(toIndentedString(total)).append("\n");
        sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
