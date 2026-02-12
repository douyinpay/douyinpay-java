package com.douyinpay.api.contract.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiDeleteContractRequest {
    /** 商户号 说明：由抖音支付生成并下发。必须传递此参数 */
    @SerializedName("mchid")
    private String mchid;

    @SerializedName("appid")
    private String appid;

    /** 抖音支付生成的签约协议号，和contract_code 必须二传其一 */
    @SerializedName("contract_id")
    private String contractId;

    /** 商户生成的签约协议号，contract_code 必须二传其一 */
    @SerializedName("out_contract_code")
    private String contractCode;

    /** 抖音支付生成的模版ID，传contract_code时 该参数必传 */
    @SerializedName("plan_id")
    private String planId;

    /** 解约原因 */
    @SerializedName("contract_termination_remark")
    private String contractTerminationRemark;



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


    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }


    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getContractTerminationRemark() {
        return contractTerminationRemark;
    }

    public void setContractTerminationRemark(String contractTerminationRemark) {
        this.contractTerminationRemark = contractTerminationRemark;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiDeleteContractRequest {\n");
        sb.append("    mchid: ").append(toIndentedString(mchid)).append("\n");
        sb.append("    appid: ").append(toIndentedString(appid)).append("\n");
        sb.append("    contractId: ").append(toIndentedString(contractId)).append("\n");
        sb.append("    contractCode: ").append(toIndentedString(contractCode)).append("\n");
        sb.append("    planId: ").append(toIndentedString(planId)).append("\n");
        sb.append("    contractTerminationRemark: ").append(toIndentedString(contractTerminationRemark)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
