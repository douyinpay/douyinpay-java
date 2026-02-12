package com.douyinpay.api.contract.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiDeleteContractResponse {

    /** 由抖音支付生成的应用ID，全局唯一*/
    @SerializedName("appid")
    private String appid;

    /** 委托代扣签约成功后，抖音返回的委托代扣协议号 */
    @SerializedName("contract_id")
    private String contractId;

    /** 商户在抖音平台申请的委托代扣模版id*/
    @SerializedName("plan_id")
    private String planId;

    /** 商户发起签约时传入的签约协议号，商户侧需保证唯一 */
    @SerializedName("out_contract_code")
    private String outContractCode;

    /* SUCCESS/FAIL，标识业务处理结果解约结果以查询或回调为准 */
    @SerializedName("result_code")
    private String resultCode;

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

    public String getOutContractCode() {
        return outContractCode;
    }

    public void setOutContractCode(String outContractCode) {
        this.outContractCode = outContractCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiDeleteContractResponse {\n");
        sb.append("    appid: ").append(toIndentedString(appid)).append("\n");
        sb.append("    contractId: ").append(toIndentedString(contractId)).append("\n");
        sb.append("    planId: ").append(toIndentedString(planId)).append("\n");
        sb.append("    outContractCode: ").append(toIndentedString(outContractCode)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
