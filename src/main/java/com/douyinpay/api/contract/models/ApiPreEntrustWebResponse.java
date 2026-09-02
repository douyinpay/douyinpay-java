package com.douyinpay.api.contract.models;
import com.google.gson.annotations.SerializedName;
import static com.douyinpay.util.StringUtil.toIndentedString;

/** APP 预签约下单响应参数。 */
public class ApiPreEntrustWebResponse {
    /**
     * 字段含义：预签约标识。
     * 格式规则：字符串。
     * 业务规则：用于标识本次 APP 预签约请求。
     */
    @SerializedName("pre_entrustweb_id")
    private String preEntrustwebId ;

    public String getPreEntrustwebId() {
        return preEntrustwebId;
    }
    public void setPreEntrustwebId(String preEntrustwebId) {
        this.preEntrustwebId = preEntrustwebId;
    }
    @Override
    public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("class ApiPreEntrustWebResponse {\n");
            sb.append("    preEntrustwebId: ").append(toIndentedString(preEntrustwebId)).append("\n");
            sb.append("}");
            return sb.toString();
    }
}
