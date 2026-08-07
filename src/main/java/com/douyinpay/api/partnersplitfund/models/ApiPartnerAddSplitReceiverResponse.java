package com.douyinpay.api.partnersplitfund.models;

import com.douyinpay.enums.SplitFundReceiverTypeEnum;
import com.douyinpay.enums.SplitFundRelationTypeEnum;
import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiPartnerAddSplitReceiverResponse {
    /**
     * 字段含义：特约商户商户号。
     */
    @SerializedName("sub_mchid")
    private String subMchid;

    /**
     * 字段含义：分账接收方类型。
     * @see SplitFundReceiverTypeEnum
     */
    @SerializedName("type")
    private String type;

    /**
     * 字段含义：分账接收方账号。
     */
    @SerializedName("account")
    private String account;

    /**
     * 字段含义：分账接收方全称。
     */
    @SerializedName("name")
    private String name;

    /**
     * 字段含义：与分账方的关系类型。
     * @see SplitFundRelationTypeEnum
     */
    @SerializedName("relation_type")
    private String relationType;

    /**
     * 字段含义：自定义的分账关系。
     */
    @SerializedName("custom_relation")
    private String customRelation;

    public String getSubMchid() {
        return subMchid;
    }

    public void setSubMchid(String subMchid) {
        this.subMchid = subMchid;
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
