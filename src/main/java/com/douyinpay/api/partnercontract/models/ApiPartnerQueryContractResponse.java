package com.douyinpay.api.partnercontract.models;
import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiPartnerQueryContractResponse {
    /*
     * 服务商应用ID
     */
    @SerializedName("sp_appid")
    private String spAppid;
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
    /*
     * 子商户应用ID
     */
    @SerializedName("sub_appid")
    private String subAppid;
    /*
     * 委托代扣协议号 
     */
    @SerializedName("contract_id")
    private String contractId;
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
     * 用户账户展示名称 
     */
    @SerializedName("contract_display_account")
    private String contractDisplayAccount;

    /*
     * 委托代扣协议状态
     */
    @SerializedName("contract_state")
    private String contractState; 

    /*
     * 协议签署时间 
     */
    @SerializedName("contract_signed_time")
    private String contractSignedTime;

    /*
     * 协议到期时间 
     */
    @SerializedName("contract_expired_time")
    private String contractExpiredTime;

    /*
     * 协议解约信息
     */
    @SerializedName("contract_terminate_info")
    private ContractTerminateInfo contractTerminateInfo;

    /*
     * 子商户AppID对应的用户OpenID
     */
    @SerializedName("sub_openid")
    private String subOpenid;

    /*
     * 用户OpenID
     */
    @SerializedName("sp_openid")
    private String spOpenid;

    public String getContractDisplayAccount() {
        return contractDisplayAccount;
    }
    public ContractTerminateInfo getContractTerminateInfo() {
        return contractTerminateInfo;
    }

    public String getSubOpenid() {
        return subOpenid;
    }

    public String getSpOpenid() {
        return spOpenid;
    }

    public String getContractId() {
        return contractId;
    }

    public Integer getPlanId() {
        return planId;
    }

    public String getOutContractCode() {
        return outContractCode;
    }

    public String getContractExpiredTime() {
        return contractExpiredTime;
    }

    public String getContractSignedTime() {
        return contractSignedTime;
    }

    public String getContractState() {
        return contractState;
    }

    public String getSpAppid() {
        return spAppid;
    }

    public String getSpMchid() {
        return spMchid;
    }

    public String getSubAppid() {
        return subAppid;
    }

    public String getSubMchid() {
        return subMchid;
    }

    public void setContractDisplayAccount(String contractDisplayAccount) {
        this.contractDisplayAccount = contractDisplayAccount;
    }
    public void setContractTerminateInfo(ContractTerminateInfo contractTerminateInfo) {
        this.contractTerminateInfo = contractTerminateInfo;
    }
    public void setSubOpenid(String subOpenid) {
        this.subOpenid = subOpenid;
    }
    public void setSpOpenid(String spOpenid) {
        this.spOpenid = spOpenid;
    }
    public void setContractId(String contractId) {
        this.contractId = contractId;
    }
    public void setPlanId(Integer planId) {
        this.planId = planId;
    }
    public void setOutContractCode(String outContractCode) {
        this.outContractCode = outContractCode;
    }
    public void setContractExpiredTime(String contractExpiredTime) {
        this.contractExpiredTime = contractExpiredTime;
    }
    public void setContractSignedTime(String contractSignedTime) {
        this.contractSignedTime = contractSignedTime;
    }
    public void setContractState(String contractState) {
        this.contractState = contractState;
    }
    public void setSpAppid(String spAppid) {
        this.spAppid = spAppid;
    }
    public void setSpMchid(String spMchid) {
        this.spMchid = spMchid;
    }
    public void setSubAppid(String subAppid) {
        this.subAppid = subAppid;
    }
    public void setSubMchid(String subMchid) {
        this.subMchid = subMchid;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiPartnerQueryContractResponse {\n");
        sb.append("    spAppid: ").append(toIndentedString(spAppid)).append("\n");
        sb.append("    spMchid: ").append(toIndentedString(spMchid)).append("\n");
        sb.append("    subMchid: ").append(toIndentedString(subMchid)).append("\n");
        sb.append("    subAppid: ").append(toIndentedString(subAppid)).append("\n");
        sb.append("    contractId: ").append(toIndentedString(contractId)).append("\n");
        sb.append("    planId: ").append(toIndentedString(planId)).append("\n");
        sb.append("    outContractCode: ").append(toIndentedString(outContractCode)).append("\n");
        sb.append("    contractDisplayAccount: ").append(toIndentedString(contractDisplayAccount)).append("\n");
        sb.append("    contractState: ").append(toIndentedString(contractState)).append("\n");
        sb.append("    contractSignedTime: ").append(toIndentedString(contractSignedTime)).append("\n");
        sb.append("    contractExpiredTime: ").append(toIndentedString(contractExpiredTime)).append("\n");
        sb.append("    contractTerminateInfo: ").append(toIndentedString(contractTerminateInfo)).append("\n");
        sb.append("    subOpenid: ").append(toIndentedString(subOpenid)).append("\n");
        sb.append("    spOpenid: ").append(toIndentedString(spOpenid)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}