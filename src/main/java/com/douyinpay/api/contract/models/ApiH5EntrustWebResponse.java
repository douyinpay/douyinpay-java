package com.douyinpay.api.contract.models;
import com.google.gson.annotations.SerializedName;
import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiH5EntrustWebResponse {
    /*跳转URL*/
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
