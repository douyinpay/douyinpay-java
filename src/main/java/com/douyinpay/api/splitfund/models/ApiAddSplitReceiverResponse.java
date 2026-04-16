package com.douyinpay.api.splitfund.models;

import com.douyinpay.enums.SplitFundReceiverTypeEnum;
import com.douyinpay.enums.SplitFundRelationTypeEnum;
import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiAddSplitReceiverResponse {

    /**
     * 分账接收方类型
     * @see SplitFundReceiverTypeEnum
     */
    @SerializedName("type")
    private String type;

    /**
     * 分账接收方账号
     */
    @SerializedName("account")
    private String account;

    /**
     * type = MERCHANT_ID 时为商户名称，type = PERSONAL_OPENID 时为个人姓名
     */
    @SerializedName("name")
    private String name;

    /**
     * 与分账方的关系类型
     * @see SplitFundRelationTypeEnum
     */
    @SerializedName("relation_type")
    private String relationType;

    /**
     * 自定义的分账关系
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
