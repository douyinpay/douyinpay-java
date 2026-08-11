package com.douyinpay.api.splitfund.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiDeleteSplitReceiverResponse {

    /**
     * 字段含义：直连商户号。
     * 格式规则：字符串。
     * 业务规则：由抖音支付生成并下发。
     * 示例：6020240223833009
     */
    @SerializedName("mchid")
    private String merchantId;

    /**
     * 字段含义：分账接收方类型。
     * 格式规则：枚举字符串。
     * 业务规则：开放文档示例包含 MERCHANT_ID、PERSONAL_OPENID。
     * 示例：MERCHANT_ID
     * @see com.douyinpay.enums.SplitFundReceiverTypeEnum
     */
    @SerializedName("type")
    private String type;

    /**
     * 字段含义：分账接收方账号。
     * 格式规则：字符串。
     * 业务规则：当类型为 MERCHANT_ID 时传商户号；当类型为 PERSONAL_OPENID 时传个人 OpenID。
     * 示例：6020260126898210
     */
    @SerializedName("account")
    private String account;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return GsonUtil.objectToJson(this);
    }
}
