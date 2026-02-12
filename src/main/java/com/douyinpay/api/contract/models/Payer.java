package com.douyinpay.api.contract.models;
import com.google.gson.annotations.SerializedName;
import static com.douyinpay.util.StringUtil.toIndentedString;

public class Payer {
    /**
     * 商户openid
     */
    @SerializedName("sp_openid")
    private String spOpenid;
    /**
     * 子商户openid
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
