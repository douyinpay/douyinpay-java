package com.douyinpay.api.deduct.models;

import com.google.gson.annotations.SerializedName;
import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiDeductNotifyRequest {
    /** 委托代扣协议id */
    @SerializedName("contract_id")
    private String contractId;

    /** 直连商户号 */
    @SerializedName("mchid")
    private String mchid;

    /** 应用id */
    @SerializedName("appid")
    private String appid;

    /** 预计扣费金额信息 */
    @SerializedName("estimated_amount")
    private EstimatedAmount estimatedAmount;

    public String getAppid() {
        return appid;
    }
    public String getContractId() {
        return contractId;
    }
    public String getMchid() {
        return mchid;
    }
    public EstimatedAmount getEstimatedAmount() {
        return estimatedAmount;
    }
    public void setAppid(String appid) {
        this.appid = appid;
    }
    public void setContractId(String contractId) {
        this.contractId = contractId;
    }
    public void setMchid(String mchid) {
        this.mchid = mchid;
    }
    public void setEstimatedAmount(EstimatedAmount estimatedAmount) {
        this.estimatedAmount = estimatedAmount;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiDeductNotifyRequest {\n");
        sb.append("    contractId: ").append(toIndentedString(contractId)).append("\n");
        sb.append("    mchid: ").append(toIndentedString(mchid)).append("\n");
        sb.append("    appid: ").append(toIndentedString(appid)).append("\n");
        sb.append("    estimatedAmount: ").append(toIndentedString(estimatedAmount)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
