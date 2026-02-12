package com.douyinpay.api.contract.models;
import com.google.gson.annotations.SerializedName;
import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiH5EntrustWebRequest {
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
         
        /** 签约拓展参数 */
        @SerializedName("contract_ext")
        private String contractExt;

        /** 回调通知url */
        @SerializedName("notify_url")
        private String notifyUrl;

        /** 时间戳 */
        @SerializedName("timestamp")
        private String timestamp;

        /** 客户端 IP */
        @SerializedName("clientip")
        private String clientip;

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getOutContractCode() {
            return outContractCode;
        }

        public void setOutContractCode(String outContractCode) {
            this.outContractCode = outContractCode;
        }

        public String getPlanId() {
            return planId;
        }

        public void setPlanId(String planId) {
            this.planId = planId;
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
        public String getContractExt() {
            return contractExt;
        }

        public void setContractExt(String contractExt) {
            this.contractExt = contractExt;
        }
        public String getNotifyUrl() {
            return notifyUrl;
        }

        public void setNotifyUrl(String notifyUrl) {
            this.notifyUrl = notifyUrl;
        }
        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }
        public String getClientip() {
            return clientip;
        }

        public void setClientip(String clientip) {
            this.clientip = clientip;
        }
        public String getMchid() {
            return mchid;
        }

        public void setMchid(String mchid) {
            this.mchid = mchid;
        }

        @Override
        public String toString() {
             StringBuilder sb = new StringBuilder();
             sb.append("class ApiH5EntrustWebRequest {\n");
             sb.append("    mchid: ").append(toIndentedString(mchid)).append("\n");
             sb.append("    appid: ").append(toIndentedString(appid)).append("\n");
             sb.append("    outContractCode: ").append(toIndentedString(outContractCode)).append("\n");
             sb.append("    planId: ").append(toIndentedString(planId)).append("\n");
             sb.append("    requestSerial: ").append(toIndentedString(requestSerial)).append("\n");
             sb.append("    contractDisplayAccount: ").append(toIndentedString(contractDisplayAccount)).append("\n");
             sb.append("    notifyUrl: ").append(toIndentedString(notifyUrl)).append("\n");
             sb.append("    contractExt: ").append(toIndentedString(contractExt)).append("\n");
             sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
             sb.append("    clientip: ").append(toIndentedString(clientip)).append("\n");
             sb.append("}");
             return sb.toString();
        }
}
