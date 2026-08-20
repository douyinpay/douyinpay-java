package com.douyinpay.api.contract.models;
import com.google.gson.annotations.SerializedName;
import static com.douyinpay.util.StringUtil.toIndentedString;

/** H5 预签约下单响应参数。 */
public class ApiH5EntrustWebResponse {
    /**
     * 字段含义：预签约页面跳转地址。
     * 格式规则：URL 字符串。
     * 业务规则：用于跳转至预签约页面。
     */
    @SerializedName("redirect_url")
    private String redirectUrl;

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiH5EntrustWebResponse {\n");
        sb.append("    redirectUrl: ").append(toIndentedString(redirectUrl)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
