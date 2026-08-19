package com.douyinpay.api.contract.models;
import com.google.gson.annotations.SerializedName;
import static com.douyinpay.util.StringUtil.toIndentedString;

/** H5 预签约下单请求参数。 */
public class ApiH5EntrustWebRequest {
        /**
         * 字段含义：直连商户应用 ID。
         * 格式规则：字符串，由抖音支付生成并下发。
         * 业务规则：与商户号匹配使用。
         */
        @SerializedName("appid")
        private String appid;

        /**
         * 字段含义：直连商户号。
         * 格式规则：字符串，由抖音支付生成并下发。
         * 业务规则：与应用 ID 匹配使用。
         */
        @SerializedName("mchid")
        private String mchid;

        /**
         * 字段含义：商户签约协议号。
         * 格式规则：字符串。
         * 业务规则：商户侧需保证在同一商户范围内唯一。
         */
        @SerializedName("out_contract_code")
        private String outContractCode;

        /**
         * 字段含义：签约协议模板 ID。
         * 格式规则：字符串或数字字符串。
         * 业务规则：商户在抖音支付申请的签约模板标识。
         */
        @SerializedName("plan_id")
        private String planId;

        /**
         * 字段含义：商户请求签约时的序列号。
         * 格式规则：正整数，取值不超过 Long 最大值。
         * 业务规则：商户侧需保证唯一，主要用于排序，不作为查询条件。
         */
        @SerializedName("request_serial")
        private Long requestSerial;

         /**
          * 字段含义：签约用户的账户展示名称。
          * 格式规则：字符串。
          * 业务规则：用于签约页面展示。
          */
         @SerializedName("contract_display_account")
         private String contractDisplayAccount;
         
        /**
         * 字段含义：签约扩展参数。
         * 格式规则：JSON 字符串。
         * 业务规则：仅在与抖音支付线下约定后使用。
         */
        @SerializedName("contract_ext")
        private String contractExt;

        /**
         * 字段含义：签约结果通知地址。
         * 格式规则：以 http 或 https 开头的 URL，且不得携带参数。
         * 业务规则：必须可被公网访问，用于接收签约成功通知。
         */
        @SerializedName("notify_url")
        private String notifyUrl;

        /**
         * 字段含义：请求时间戳。
         * 格式规则：按接口约定传递当前时间字符串。
         * 业务规则：用于标识请求生成时间。
         */
        @SerializedName("timestamp")
        private String timestamp;

        /**
         * 字段含义：用户客户端 IP 地址。
         * 格式规则：合法的 IPv4 或 IPv6 地址。
         * 业务规则：传递发起签约请求的客户端地址。
         */
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
