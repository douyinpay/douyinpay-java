package com.douyinpay.api.splitfund.models;

import com.douyinpay.enums.SplitFundReceiverTypeEnum;
import com.douyinpay.enums.SplitFundRelationTypeEnum;
import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiAddSplitReceiverRequest {

    /**
     * 直连商户号
     */
    @SerializedName("mchid")
    private String merchantId;

    /**
     * 商户应用号
     */
    @SerializedName("appid")
    private String appId;

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

    /**
     * 抖音支付平台证书序列号。
     * 该字段透传到请求头 Douyinpay-Serial，不参与 body 序列化。
     */
    private transient String serialNo;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
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

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    @Override
    public String toString() {
        return GsonUtil.objectToJson(this);
    }
}
