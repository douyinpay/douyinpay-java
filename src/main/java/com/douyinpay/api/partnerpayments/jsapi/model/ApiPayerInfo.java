package com.douyinpay.api.partnerpayments.jsapi.model;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiPayerInfo {
    /** 用户服务标识 */
    @SerializedName("sp_openid")
    private String spOpenid;
    /** 用户子标识 */
    @SerializedName("sub_openid")
    private String subOpenid;

    /**
     * 支付者抖音OpenID
     * @return spOpenid 支付者抖音OpenID
     */
    public String getSpOpenid() {
        return spOpenid;
    }

    /**
     * 子商户抖音OpenID
     * @return subOpenid 子商户抖音OpenID
     */
    public String getSubOpenid() {
        return subOpenid;
    }
     /**
     * 设置支付者抖音OpenID
     * @param spOpenid 支付者抖音OpenID
     */
    public void setSpOpenid(String spOpenid) {
        this.spOpenid = spOpenid;
    }

    /**
     * 设置子商户抖音OpenID
     * @param subOpenid 子商户抖音OpenID
     */
    public void setSubOpenid(String subOpenid) {
        this.subOpenid = subOpenid;
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
        sb.append("class ApiPayerInfo {\n");
        sb.append("    spOpenid: ").append(toIndentedString(spOpenid)).append("\n");
        sb.append("    subOpenid: ").append(toIndentedString(subOpenid)).append("\n");
        sb.append("}");
        return sb.toString();

    }
}
