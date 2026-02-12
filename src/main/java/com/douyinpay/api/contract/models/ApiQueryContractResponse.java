package com.douyinpay.api.contract.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiQueryContractResponse {

    /**
     * mchid 抖音支付分配的商户号
     */
    @SerializedName("mchid")
    private String mchid;
    /**
     * appid 抖音支付分配的appid
     */
    @SerializedName("appid")
    private String appid;
    /**
     * contractId 抖音支付生成的签约协议号
     */
    @SerializedName("contract_id")
    private String contractId;
    /**
     * planId 抖音支付下发的模版ID
     */
    @SerializedName("plan_id")
    private String planId;
    /**
     * requestSerial 商户请求签约时的序列号，商户侧须唯一。序列号主要用于排序，不作为查询条件，纯数字,范围不能超过int64的范围
     */
    @SerializedName("request_serial")
    private Long requestSerial;
    /**
     * outContractCode
     */
    @SerializedName("out_contract_code")
    private String outContractCode;
    /**
     * contractDisplayAccount
     */
    @SerializedName("contract_display_account")
    private String contractDisplayAccount;
    /**
     * contractStatus
     */
    @SerializedName("contract_status")
    private String contractStatus;

    /**
     * contractSignedTime
     */

    @SerializedName("contract_signed_time")
    private String contractSignedTime;
    /**
     * contractExpiredTime
     */
    @SerializedName("contract_expired_time")
    private String contractExpiredTime;

    /**
     * contractTerminatedTime
     */
    @SerializedName("contract_terminated_time")
    private String contractTerminatedTime;

    /**
     * contractTerminationMode
     */
    @SerializedName("contract_termination_mode")
    private Integer contractTerminationMode;

    /**
     * contractTerminationRemark
     */
    @SerializedName("contract_termination_remark")
    private String contractTerminationRemark;


    /**
     * openId
     */
    @SerializedName("openid")
    private String openId;


    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }



    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public Long getRequestSerial() {
        return requestSerial;
    }

    public void setRequestSerial(Long requestSerial) {
        this.requestSerial = requestSerial;
    }

    public String getOutContractCode() {
        return outContractCode;
    }

    public void setOutContractCode(String outContractCode) {
        this.outContractCode = outContractCode;
    }

    public String getContractDisplayAccount() {
        return contractDisplayAccount;
    }

    public void setContractDisplayAccount(String contractDisplayAccount) {
        this.contractDisplayAccount = contractDisplayAccount;
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }

    public String getContractSignedTime() {
        return contractSignedTime;
    }

    public void setContractSignedTime(String contractSignedTime) {
        this.contractSignedTime = contractSignedTime;
    }

    public String getContractExpiredTime() {
        return contractExpiredTime;
    }

    public void setContractExpiredTime(String contractExpiredTime) {
        this.contractExpiredTime = contractExpiredTime;
    }

    public String getContractTerminatedTime() {
        return contractTerminatedTime;
    }

    public void setContractTerminatedTime(String contractTerminatedTime) {
        this.contractTerminatedTime = contractTerminatedTime;
    }

    public Integer getContractTerminationMode() {
        return contractTerminationMode;
    }

    public void setContractTerminationMode(Integer contractTerminationMode) {
        this.contractTerminationMode = contractTerminationMode;
    }

    public String getContractTerminationRemark() {
        return contractTerminationRemark;
    }

    public void setContractTerminationRemark(String contractTerminationRemark) {
        this.contractTerminationRemark = contractTerminationRemark;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiQueryContractResponse {\n");
        sb.append("    mchid: ").append(toIndentedString(mchid)).append("\n");
        sb.append("    appid: ").append(toIndentedString(appid)).append("\n");
        sb.append("    contractId: ").append(toIndentedString(contractId)).append("\n");
        sb.append("    planId: ").append(toIndentedString(planId)).append("\n");
        sb.append("    requestSerial: ").append(toIndentedString(requestSerial)).append("\n");
        sb.append("    outContractCode: ").append(toIndentedString(outContractCode)).append("\n");
        sb.append("    contractDisplayAccount: ").append(toIndentedString(contractDisplayAccount)).append("\n");
        sb.append("    contractStatus: ").append(toIndentedString(contractStatus)).append("\n");
        sb.append("    contractSignedTime: ").append(toIndentedString(contractSignedTime)).append("\n");
        sb.append("    contractExpiredTime: ").append(toIndentedString(contractExpiredTime)).append("\n");
        sb.append("    contractTerminatedTime: ").append(toIndentedString(contractTerminatedTime)).append("\n");
        sb.append("    contractTerminationMode: ").append(toIndentedString(contractTerminationMode)).append("\n");
        sb.append("    contractTerminationRemark: ").append(toIndentedString(contractTerminationRemark)).append("\n");
        sb.append("    openId: ").append(toIndentedString(openId)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
