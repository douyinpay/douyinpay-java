package com.douyinpay.api.splitfund.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiAddSplitReceiverResponse {

    /**
     * 字段含义：分账接收方类型。
     * 格式规则：枚举字符串。
     * 业务规则：开放文档示例包含 MERCHANT_ID、PERSONAL_OPENID。
     * 示例：MERCHANT_ID
     *
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

    /**
     * 字段含义：分账接收方全称。
     * 格式规则：字符串。
     * 业务规则：该字段为已加密返回值，需按接口证书解密规则处理。
     * 补充说明：表示分账接收方全称。
     * 示例：分账接收方名称
     */
    @SerializedName("name")
    private String name;

    /**
     * 字段含义：与分账方的关系类型。
     * 格式规则：枚举字符串。
     * 业务规则：开放文档示例包含 SERVICE_PROVIDER、STORE、STAFF、CUSTOM 等取值。
     * 示例：STORE
     *
     * @see com.douyinpay.enums.SplitFundRelationTypeEnum
     */
    @SerializedName("relation_type")
    private String relationType;

    /**
     * 字段含义：自定义分账关系。
     * 格式规则：最多 10 个字。
     * 业务规则：当 relation_type 为 CUSTOM 时必传，其他情况无需填写。
     * 补充说明：用于描述特约商户与接收方的具体关系。
     * 示例：合作渠道
     */
    @SerializedName("custom_relation")
    private String customRelation;

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
