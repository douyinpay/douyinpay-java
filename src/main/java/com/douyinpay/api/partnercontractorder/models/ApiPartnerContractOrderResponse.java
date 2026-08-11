package com.douyinpay.api.partnercontractorder.models;

import com.google.gson.annotations.SerializedName;
import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiPartnerContractOrderResponse {

    /**
     * 字段含义：预支付交易会话标识。
     * 格式规则：字符串。
     * 业务规则：用于后续调起签约并支付流程；返回内容会随 trade_type 不同而变化。
     * 示例：dy96y894ox66yv43x10uquv34s5s7sx3oso28squqsx
     */
    @SerializedName("prepay_id")
    private String prepayId;

    public String getPrepayId() {
        return prepayId;
    }
    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiPartnerContractOrderResponse {\n");
        sb.append("    prepayId: ").append(toIndentedString(prepayId)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
