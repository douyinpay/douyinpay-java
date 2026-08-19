package com.douyinpay.api.contract.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** 删除直连商户签约协议请求参数。 */
public class ApiDeleteContractRequest {
    /**
     * 字段含义：直连商户号。
     * 格式规则：字符串，由抖音支付生成并下发。
     * 业务规则：必填，与应用 ID 匹配使用。
     */
    @SerializedName("mchid")
    private String mchid;

    /**
     * 字段含义：直连商户应用 ID。
     * 格式规则：字符串，由抖音支付生成并下发。
     * 业务规则：必填，与商户号匹配使用。
     */
    @SerializedName("appid")
    private String appid;

    /**
     * 字段含义：抖音支付生成的签约协议号。
     * 格式规则：字符串。
     * 业务规则：与商户签约协议号、模板 ID 二选一使用。
     */
    @SerializedName("contract_id")
    private String contractId;

    /**
     * 字段含义：商户生成的签约协议号。
     * 格式规则：字符串。
     * 业务规则：与抖音支付签约协议号二选一；传入时必须同时传入模板 ID。
     */
    @SerializedName("out_contract_code")
    private String contractCode;

    /**
     * 字段含义：抖音支付生成的签约模板 ID。
     * 格式规则：字符串。
     * 业务规则：使用商户签约协议号解除签约时必填。
     */
    @SerializedName("plan_id")
    private String planId;

    /**
     * 字段含义：解除签约的原因或备注。
     * 格式规则：字符串。
     * 业务规则：必填。
     */
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
