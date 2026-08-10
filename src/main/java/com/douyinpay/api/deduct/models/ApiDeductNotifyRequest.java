package com.douyinpay.api.deduct.models;

import com.google.gson.annotations.SerializedName;
import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiDeductNotifyRequest {
    /**
     * 字段含义：委托代扣协议ID。
     * 格式规则：字符串。
     * 业务规则：表示签约成功后的委托代扣协议标识。
     * 示例：
     */
    @SerializedName("contract_id")
    private String contractId;

    /**
     * 字段含义：直连商户号。
     * 格式规则：字符串。
     * 业务规则：表示发起预约扣费通知的直连商户主体。
     * 示例：
     */
    @SerializedName("mchid")
    private String mchid;

    /**
     * 字段含义：应用ID。
     * 格式规则：字符串。
     * 业务规则：表示发起预约扣费通知的应用标识。
     * 示例：
     */
    @SerializedName("appid")
    private String appid;

    /**
     * 字段含义：预计扣费金额信息。
     * 格式规则：对象。
     * 业务规则：用于描述预约扣费通知中的预计扣费金额。
     * 示例：
     */
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
