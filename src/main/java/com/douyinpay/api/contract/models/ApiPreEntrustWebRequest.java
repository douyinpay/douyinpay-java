package com.douyinpay.api.contract.models;
import com.google.gson.annotations.SerializedName;
import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiPreEntrustWebRequest {
        /** 应用ID*/
        @SerializedName("appid")
        private String appid;

        /** 直联商户号 */
        @SerializedName("mchid")
        private String mchid;
    
        /** 签约协议号 */
        @SerializedName("out_contract_code")
        private String outContractCode;

        /** 模板id */
        @SerializedName("plan_id")
        private String planId;

        /** 请求序列号 */
        @SerializedName("request_serial")
        private Long requestSerial;

        /** 用户账户展示名称 */
        @SerializedName("contract_display_account")
        private String contractDisplayAccount;

        /** 回调通知url */
        @SerializedName("notify_url")
        private String notifyUrl;

        /** 签约拓展参数 */
        @SerializedName("contract_ext")
        private String contractExt;

        public String getMchid() {
            return mchid;
        }
        public String getAppid() {
            return appid;
        }
        public String getOutContractCode() {
            return outContractCode;
        }
        public String getPlanId() {
            return planId;
        }
        public Long getRequestSerial() {
            return requestSerial;
        }
        public String getContractDisplayAccount() {
            return contractDisplayAccount;
        }
        public String getNotifyUrl() {
            return notifyUrl;
        }
        public String getContractExt() {
            return contractExt;
        }
        public void setMchid(String mchid) {
            this.mchid = mchid;
        }
        public void setAppid(String appid) {
            this.appid = appid;
        }
        public void setOutContractCode(String outContractCode) {
            this.outContractCode = outContractCode;
        }
        public void setPlanId(String planId) {
            this.planId = planId;
        }
        public void setRequestSerial(Long requestSerial) {
            this.requestSerial = requestSerial;
        }
        public void setContractDisplayAccount(String contractDisplayAccount) {
            this.contractDisplayAccount = contractDisplayAccount;
        }
        public void setNotifyUrl(String notifyUrl) {
            this.notifyUrl = notifyUrl;
        }
        public void setContractExt(String contractExt) {
            this.contractExt = contractExt;
        }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("class ApiPreEntrustWebRequest {\n");
            sb.append("    mchid: ").append(toIndentedString(mchid)).append("\n");
            sb.append("    appid: ").append(toIndentedString(appid)).append("\n");
            sb.append("    outContractCode: ").append(toIndentedString(outContractCode)).append("\n");
            sb.append("    planId: ").append(toIndentedString(planId)).append("\n");
            sb.append("    requestSerial: ").append(toIndentedString(requestSerial)).append("\n");
            sb.append("    contractDisplayAccount: ").append(toIndentedString(contractDisplayAccount)).append("\n");
            sb.append("    notifyUrl: ").append(toIndentedString(notifyUrl)).append("\n");
            sb.append("    contractExt: ").append(toIndentedString(contractExt)).append("\n");
            sb.append("}");
            return sb.toString();
        }
}
