package com.douyinpay.api.contract.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** 查询直连商户签约协议请求参数。 */
public class ApiQueryContractRequest {
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

    /** 抖音支付生成的签约协议号，和contract_code 必须二传其一 */
    @SerializedName("contract_id")
    private String contractId;

    /** 商户生成的签约协议号，contract_code 必须二传其一 */
    @SerializedName("out_contract_code")
    private String contractCode;

    /** 抖音支付生成的模版ID，传contract_code时 该参数必传 */
    @SerializedName("plan_id")
    private String planId;


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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiQueryContractRequest {\n");
        sb.append("    mchid: ").append(toIndentedString(mchid)).append("\n");
        sb.append("    appid: ").append(toIndentedString(appid)).append("\n");
        sb.append("    contractId: ").append(toIndentedString(contractId)).append("\n");
        sb.append("    contractCode: ").append(toIndentedString(contractCode)).append("\n");
        sb.append("    planId: ").append(toIndentedString(planId)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
