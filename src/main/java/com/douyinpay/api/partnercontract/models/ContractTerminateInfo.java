package com.douyinpay.api.partnercontract.models;
import com.douyinpay.util.StringUtil;
import com.google.gson.annotations.SerializedName;

public class ContractTerminateInfo {
    /** 协议解约时间 */
    @SerializedName("contract_terminated_time")
    private String contractTerminatedTime;

    /** 协议解约方式 */
    @SerializedName("contract_termination_mode")
    private String contractTerminationMode;

    /** 解约备注 */
    @SerializedName("contract_termination_remark")
    private String contractTerminationRemark;

    public String getContractTerminatedTime() {
        return contractTerminatedTime;
    }
    public String getContractTerminationMode() {
        return contractTerminationMode;
    }
    public String getContractTerminationRemark() {
        return contractTerminationRemark;
    }
    public void setContractTerminatedTime(String contractTerminatedTime) {
        this.contractTerminatedTime = contractTerminatedTime;
    }
    public void setContractTerminationMode(String contractTerminationMode) {
        this.contractTerminationMode = contractTerminationMode;
    }
    public void setContractTerminationRemark(String contractTerminationRemark) {
        this.contractTerminationRemark = contractTerminationRemark;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ContractTerminateInfo {\n");
        sb.append("    contractTerminatedTime: ").append(StringUtil.toIndentedString(contractTerminatedTime)).append("\n");
        sb.append("    contractTerminationMode: ").append(StringUtil.toIndentedString(contractTerminationMode)).append("\n");
        sb.append("    contractTerminationRemark: ").append(StringUtil.toIndentedString(contractTerminationRemark)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
