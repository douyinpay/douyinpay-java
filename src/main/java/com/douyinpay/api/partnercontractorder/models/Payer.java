package com.douyinpay.api.partnercontractorder.models;
import com.google.gson.annotations.SerializedName;
import static com.douyinpay.util.StringUtil.toIndentedString;

public class Payer {
    /**
     * 用户服务标识
     */
    @SerializedName("sp_openid")
    private String spOpenid;
    /**
     * 用户子标识
     */
    @SerializedName("sub_openid")
    private String subOpenid;
    
    public String getSpOpenid() {
        return spOpenid;
    }

    public void setSpOpenid(String spOpenid) {
        this.spOpenid = spOpenid;
    }

    public String getSubOpenid() {
        return subOpenid;
    }

    public void setSubOpenid(String subOpenid) {
        this.subOpenid = subOpenid;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Payer {\n");
        sb.append("    spOpenid: ").append(toIndentedString(spOpenid)).append("\n");
        sb.append("    subOpenid: ").append(toIndentedString(subOpenid)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
