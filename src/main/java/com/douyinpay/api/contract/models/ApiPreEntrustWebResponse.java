package com.douyinpay.api.contract.models;
import com.google.gson.annotations.SerializedName;
import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiPreEntrustWebResponse {
    /** 预签约id */
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
