package com.douyinpay.api.payments.contractorder.models;

import com.douyinpay.util.StringUtil;
import com.google.gson.annotations.SerializedName;

public class ContractInfo {
    @SerializedName("contract_mchid")
    private String contractMerchantId;                 // 签约商户号
    @SerializedName("contract_appid")
    private String contractAppId;                      // 签约appid
    @SerializedName("plan_id")
    private String planId;                             // 模板id
    @SerializedName("out_contract_code")
    private String outContractCode;                    // 签约协议号
    @SerializedName("request_serial")
    private Long requestSerial;                     // 请求序列号
    @SerializedName("contract_display_account")
    private String contractDisplayAccount;             // 用户账户展示名称
    @SerializedName("contract_notify_url")
    private String contractNotifyUrl;                   // 签约信息通知url

    public String getContractMerchantId() {
        return contractMerchantId;
    }

    public void setContractMerchantId(String contractMerchantId) {
        this.contractMerchantId = contractMerchantId;
    }

    public String getContractAppId() {
        return contractAppId;
    }

    public void setContractAppId(String contractAppId) {
        this.contractAppId = contractAppId;
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

    public Long getRequestSerial() {
        return requestSerial;
    }

    public void setRequestSerial(Long requestSerial) {
        this.requestSerial = requestSerial;
    }

    public String getContractDisplayAccount() {
        return contractDisplayAccount;
    }

    public void setContractDisplayAccount(String contractDisplayAccount) {
        this.contractDisplayAccount = contractDisplayAccount;
    }

    public String getContractNotifyUrl() {
        return contractNotifyUrl;
    }

    public void setContractNotifyUrl(String contractNotifyUrl) {
        this.contractNotifyUrl = contractNotifyUrl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ContractInfo {\n");
        sb.append("    contractMerchantId: ").append(StringUtil.toIndentedString(contractMerchantId)).append("\n");
        sb.append("    contractAppId: ").append(StringUtil.toIndentedString(contractAppId)).append("\n");
        sb.append("    planId: ").append(StringUtil.toIndentedString(planId)).append("\n");
        sb.append("    outContractCode: ").append(StringUtil.toIndentedString(outContractCode)).append("\n");
        sb.append("    requestSerial: ").append(StringUtil.toIndentedString(requestSerial)).append("\n");
        sb.append("    contractDisplayAccount: ").append(StringUtil.toIndentedString(contractDisplayAccount)).append("\n");
        sb.append("    contractNotifyUrl: ").append(StringUtil.toIndentedString(contractNotifyUrl)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
