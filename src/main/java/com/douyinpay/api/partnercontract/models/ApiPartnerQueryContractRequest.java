package com.douyinpay.api.partnercontract.models;
import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiPartnerQueryContractRequest {
    /*
     * 委托代扣模板ID
     */
    @SerializedName("plan_id")
    private Integer planId;
    /*
     * 商户签约协议号
     */
    @SerializedName("out_contract_code")
    private String outContractCode;
    /*
     * 服务商商户号
     */
    @SerializedName("sp_mchid")
    private String spMchid;
    /*
     * 子商户号
     */
    @SerializedName("sub_mchid")
    private String subMchid;

    public Integer getPlanId() {
        return planId;
    }
    public void setPlanId(Integer planId) {
        this.planId = planId;
    }
    public String getOutContractCode() {
        return outContractCode;
    }
    public void setOutContractCode(String outContractCode) {
        this.outContractCode = outContractCode;
    }
    public String getSpMchid() {
        return spMchid;
    }
    public void setSpMchid(String spMchid) {
        this.spMchid = spMchid;
    }
    public String getSubMchid() {
        return subMchid;
    }
    public void setSubMchid(String subMchid) {
        this.subMchid = subMchid;
    }
    @Override
    public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("class ApiPartnerQueryContractRequest {\n");
            sb.append("    planId: ").append(toIndentedString(planId)).append("\n");
            sb.append("    outContractCode: ").append(toIndentedString(outContractCode)).append("\n");
            sb.append("    spMchid: ").append(toIndentedString(spMchid)).append("\n");
            sb.append("    subMchid: ").append(toIndentedString(subMchid)).append("\n");
            sb.append("}");
            return sb.toString();
    }
}
