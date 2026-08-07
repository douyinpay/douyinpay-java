package com.douyinpay.api.partnersplitfund.models;

import com.douyinpay.enums.SplitFundReceiverTypeEnum;
import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiPartnerDeleteSplitReceiverRequest {
    /**
     * 字段含义：服务商户号。
     * 格式规则：字符串，长度为 1-32 位。
     * 业务规则：由抖音支付生成并下发，用于标识服务商主体。
     * 示例：6020221212167701
     */
    @SerializedName("sp_mchid")
    private String spMchid;

    /**
     * 字段含义：服务商应用ID。
     * 格式规则：字符串，长度为 1-32 位。
     * 业务规则：由服务商在抖音开放平台申请，并确保与 sp_mchid 存在绑定关系。
     * 示例：awofz9bncda6w2w4
     */
    @SerializedName("sp_appid")
    private String spAppid;

    /**
     * 字段含义：特约商户号。
     * 格式规则：字符串，长度为 1-32 位。
     * 业务规则：由抖音支付生成并下发，用于标识特约商户主体。
     * 示例：6020221212167702
     */
    @SerializedName("sub_mchid")
    private String subMchid;

    /**
     * 字段含义：特约商户应用号。
     * 格式规则：字符串，长度为 1-32 位。
     * 业务规则：由特约商户在抖音开放平台申请，并确保与 sub_mchid 存在绑定关系。
     * 示例：awofz9bncda6w2w4
     */
    @SerializedName("sub_appid")
    private String subAppid;

    /**
     * 字段含义：分账接收方类型。
     * 格式规则：枚举字符串。
     * 业务规则：支持 MERCHANT_ID、PERSONAL_SP_OPENID、PERSONAL_SUB_OPENID。
     * 示例：MERCHANT_ID
     * @see SplitFundReceiverTypeEnum
     */
    @SerializedName("type")
    private String type;

    /**
     * 字段含义：分账接收方账号。
     * 格式规则：字符串，长度为 1-64 位。
     * 业务规则：MERCHANT_ID 传商户号，PERSONAL_SP_OPENID 传服务商 AppID 作用域下 openid，PERSONAL_SUB_OPENID 传特约商户 AppID 作用域下 openid。
     * 示例：6020230307605084
     */
    @SerializedName("account")
    private String account;

    public String getSpMchid() {
        return spMchid;
    }

    public void setSpMchid(String spMchid) {
        this.spMchid = spMchid;
    }

    public String getSpAppid() {
        return spAppid;
    }

    public void setSpAppid(String spAppid) {
        this.spAppid = spAppid;
    }

    public String getSubMchid() {
        return subMchid;
    }

    public void setSubMchid(String subMchid) {
        this.subMchid = subMchid;
    }

    public String getSubAppid() {
        return subAppid;
    }

    public void setSubAppid(String subAppid) {
        this.subAppid = subAppid;
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
