package com.douyinpay.api.partnersplitfund.models;

import com.douyinpay.enums.SplitFundReceiverTypeEnum;
import com.douyinpay.enums.SplitFundRelationTypeEnum;
import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiPartnerAddSplitReceiverRequest {
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
     * 业务规则：含 PERSONAL_SP_OPENID 类型的分账接收方时需填写，并确保与 sp_mchid 存在绑定关系。
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
     * 字段含义：特约商户应用ID。
     * 格式规则：字符串，长度为 1-32 位。
     * 业务规则：含 PERSONAL_SUB_OPENID 类型的分账接收方时需填写，并确保与 sub_mchid 存在绑定关系。
     * 示例：awofz9bncda6w2w4
     */
    @SerializedName("sub_appid")
    private String subAppid;

    /**
     * 字段含义：分账接收方账号类型。
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
     * 示例：6020260126898210
     */
    @SerializedName("account")
    private String account;

    /**
     * 字段含义：分账接收方全称。
     * 格式规则：字符串，长度为 1-1024 位。
     * 业务规则：该字段需使用抖音支付平台证书公钥加密；MERCHANT_ID 时传商户全称，PERSONAL_SP_OPENID 和 PERSONAL_SUB_OPENID 时传姓名可用于实名匹配校验。
     * 示例：CDEgKhcAkOQVESRENiMsdtfoRDOsLPOfCmJPR
     */
    @SerializedName("name")
    private String name;

    /**
     * 字段含义：与分账方的关系类型。
     * 格式规则：枚举字符串。
     * 业务规则：支持 SERVICE_PROVIDER、STORE、STAFF、STORE_OWNER、PARTNER、HEADQUARTER、BRAND、DISTRIBUTOR、USER、SUPPLIER、CUSTOM。
     * 示例：STORE
     * @see SplitFundRelationTypeEnum
     */
    @SerializedName("relation_type")
    private String relationType;

    /**
     * 字段含义：自定义的分账关系。
     * 格式规则：字符串，长度为 1-10 位。
     * 业务规则：仅当 relation_type 为 CUSTOM 时填写。
     * 示例：合作门店
     */
    @SerializedName("custom_relation")
    private String customRelation;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelationType() {
        return relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public String getCustomRelation() {
        return customRelation;
    }

    public void setCustomRelation(String customRelation) {
        this.customRelation = customRelation;
    }

    @Override
    public String toString() {
        return GsonUtil.objectToJson(this);
    }
}
