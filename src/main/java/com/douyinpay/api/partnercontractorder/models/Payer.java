package com.douyinpay.api.partnercontractorder.models;
import com.google.gson.annotations.SerializedName;
import static com.douyinpay.util.StringUtil.toIndentedString;

public class Payer {
    /**
     * 字段含义：用户服务标识。
     * 格式规则：字符串。
     * 业务规则：表示用户在服务商 AppID 下的唯一标识；在需要支付者信息的场景下，与 sub_openid 至少二选一传入。
     * 示例：897ae8bd9f194107-9cb3-85f5672037de
     */
    @SerializedName("sp_openid")
    private String spOpenid;
    /**
     * 字段含义：用户子标识。
     * 格式规则：字符串。
     * 业务规则：表示用户在子商户 AppID 下的唯一标识；若传该字段，则 sub_appid 必填，且与 sp_openid 至少二选一传入。
     * 示例：823ae8bd9f893402-9cb3-85f8794657ea
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
