package com.douyinpay.api.partnercontractorder.models;

import com.douyinpay.util.StringUtil;
import com.google.gson.annotations.SerializedName;

public class ContractInfo {
    /**
     * 字段含义：签约商户号。
     * 格式规则：字符串。
     * 业务规则：必须与 sub_mchid 保持一致。
     * 示例：6020230307605000
     */
    @SerializedName("contract_mchid")
    private String contractMerchantId;
    /**
     * 字段含义：签约应用ID。
     * 格式规则：字符串。
     * 业务规则：必须与 sub_appid 保持一致。
     * 示例：awofz9bncda6x700
     */
    @SerializedName("contract_appid")
    private String contractAppId;
    /**
     * 字段含义：模板ID。
     * 格式规则：字符串。
     * 业务规则：联系抖音支付运营申请。
     * 示例：48
     */
    @SerializedName("plan_id")
    private String planId;
    /**
     * 字段含义：签约协议号。
     * 格式规则：字符串。
     * 业务规则：由商户生成，只能是数字和大小写字母组成的描述。
     * 示例：100001258
     */
    @SerializedName("out_contract_code")
    private String outContractCode;
    /**
     * 字段含义：请求序列号。
     * 格式规则：int64 整数。
     * 业务规则：商户请求签约时的唯一序列号；禁止使用 0 开头，且取值范围不能超过 int64 上限。
     * 示例：1
     */
    @SerializedName("request_serial")
    private Long requestSerial;
    /**
     * 字段含义：用户账户展示名称。
     * 格式规则：字符串。
     * 业务规则：用于页面展示；参数值不支持 UTF8 非 3 字节编码字符，例如表情符号。
     * 示例：测试账号
     */
    @SerializedName("contract_display_account")
    private String contractDisplayAccount;
    /**
     * 字段含义：签约信息通知地址。
     * 格式规则：HTTPS 外网可访问地址，且不能携带参数。
     * 业务规则：用于接收签约结果通知。
     * 示例：https://www.mock.douyinpay.com/contract/notify
     */
    @SerializedName("contract_notify_url")
    private String contractNotifyUrl;
    /**
     * 字段含义：签约扩展业务参数。
     * 格式规则：JSON 字符串。
     * 业务规则：仅与抖音支付线下约定后使用。
     * 示例：
     */
    @SerializedName("contract_ext")
    private String contractExt;
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
    public String getContractExt() {
        return contractExt;
    }

    public void setContractExt(String contractExt) {
        this.contractExt = contractExt;
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
        sb.append("    contractExt: ").append(StringUtil.toIndentedString(contractExt)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
