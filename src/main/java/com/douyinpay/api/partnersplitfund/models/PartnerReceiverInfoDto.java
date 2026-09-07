package com.douyinpay.api.partnersplitfund.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class PartnerReceiverInfoDto {
    /**
     * 字段含义：分账接收方类型。
     * 格式规则：枚举字符串，长度为 1-32 位。
     * 业务规则：MERCHANT_ID 表示商户号；PERSONAL_SP_OPENID 表示用户在服务商 AppID
     * 下的唯一标识；PERSONAL_SUB_OPENID 表示用户在特约商户 AppID 下的唯一标识。
     * 示例：MERCHANT_ID
     */
    @SerializedName("type")
    private String type;

    /**
     * 字段含义：分账接收方账号。
     * 格式规则：字符串，长度为 1-64 位。
     * 业务规则：接收方类型为 MERCHANT_ID 时填写商户号；为 PERSONAL_SP_OPENID 时填写由服务商 AppID 转换得到的个人
     * OpenID；为 PERSONAL_SUB_OPENID 时填写由特约商户 AppID 转换得到的个人 OpenID。
     * 示例：6020230307605084
     */
    @SerializedName("account")
    private String account;

    /**
     * 字段含义：分账接收方全称。
     * 格式规则：字符串，长度为 1-1024 位。
     * 业务规则：接收方类型为 MERCHANT_ID 时填写商户全称；为 PERSONAL_SP_OPENID 或 PERSONAL_SUB_OPENID
     * 时可选填个人姓名，传入时会校验实名一致性；该字段需使用抖音支付平台证书公钥按 RSA-PKCS#1 v1.5 算法加密，并在请求头中传入
     * Douyinpay-Serial。
     * 示例：
     */
    @SerializedName("name")
    private String name;

    /**
     * 字段含义：分账金额。
     * 格式规则：整数。
     * 业务规则：单位为分，只能为整数，不能超过原订单支付金额乘以最大分账比例。
     * 示例：100
     */
    @SerializedName("amount")
    private Integer amount;

    /**
     * 字段含义：分账描述。
     * 格式规则：字符串，长度为 1-80 位。
     * 业务规则：分账原因描述，会在分账账单中体现。
     * 示例：分给合作方
     */
    @SerializedName("description")
    private String description;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return GsonUtil.objectToJson(this);
    }
}
