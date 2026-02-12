package com.douyinpay.api.partnerdeduct.models;

import com.google.gson.annotations.SerializedName;
import static com.douyinpay.util.StringUtil.toIndentedString;
public class ApiPartnerDeductResponse {
    /** 业务结果 */
    @SerializedName("result_code")
    private String resultCode ;
    public String getResultCode() {
        return resultCode;
    }
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiPartnerDeductResponse {\n");
        sb.append("    resultCode: ").append(toIndentedString(resultCode)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
