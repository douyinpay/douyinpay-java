package com.douyinpay.api.partnercontract.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiPartnerTerminateContractRequest {
    /** 委托代扣模板ID */
    @SerializedName("plan_id")
    private Integer planId;

    /* 商户签约协议号*/
    @SerializedName("out_contract_code")
    private String outContractCode;
    
    /**服务商商户号 */
    @SerializedName("sp_mchid")
    private String spMchid;

    /** 子商户号 */
    @SerializedName("sub_mchid")
    private String subMchid;

    /** 解约备注 */
    @SerializedName("contract_termination_remark")
    private String contractTerminationRemark;

    public String getSubMchid() {
        return subMchid;
    }
    public String getSpMchid() {
        return spMchid;
    }
    public String getContractTerminationRemark() {
        return contractTerminationRemark;
    }
    public Integer getPlanId() {
        return planId;
    }
    public String getOutContractCode() {
        return outContractCode;
    }
    public void setSubMchid(String subMchid) {
        this.subMchid = subMchid;
    }
    public void setSpMchid(String spMchid) {
        this.spMchid = spMchid;
    }
    public void setContractTerminationRemark(String contractTerminationRemark) {
        this.contractTerminationRemark = contractTerminationRemark;
    }
    public void setPlanId(Integer planId) {
        this.planId = planId;
    }
    public void setOutContractCode(String outContractCode) {
        this.outContractCode = outContractCode;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiPartnerTerminateContractRequest {\n");
        sb.append("    spMchid: ").append(toIndentedString(spMchid)).append("\n");
        sb.append("    subMchid: ").append(toIndentedString(subMchid)).append("\n");
        sb.append("    contractTerminationRemark: ").append(toIndentedString(contractTerminationRemark)).append("\n");
        sb.append("    planId: ").append(toIndentedString(planId)).append("\n");
        sb.append("    outContractCode: ").append(toIndentedString(outContractCode)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
