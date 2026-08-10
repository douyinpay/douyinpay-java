package com.douyinpay.api.partnerdeduct.models;

import com.google.gson.annotations.SerializedName;
import static com.douyinpay.util.StringUtil.toIndentedString;
public class ApiPartnerDeductResponse {
    /**
     * 字段含义：业务结果。
     * 格式规则：枚举字符串。
     * 业务规则：开放文档示例包含 SUCCESS、FAIL；扣款最终结果以回调通知或后续查单结果为准。
     * 示例：SUCCESS
     */
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
