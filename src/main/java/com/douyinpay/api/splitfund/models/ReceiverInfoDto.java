package com.douyinpay.api.splitfund.models;

import com.douyinpay.enums.SplitFundReceiverTypeEnum;
import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ReceiverInfoDto {

    /**
     * 分账接收方类型，MERCHANT_ID：商户号， PERSONAL_OPENID：个人
     * @see SplitFundReceiverTypeEnum
     */
    @SerializedName("type")
    private String type;

    /**
     * type = MERCHANT_ID 时为商户号，type = PERSONAL_OPENID 时为个人openid
     */
    @SerializedName("account")
    private String account;

    /**
     * type = MERCHANT_ID 时为商户名称，type = PERSONAL_OPENID 时为个人姓名
     */
    @SerializedName("name")
    private String name;

    /**
     * 分账金额
     */
    @SerializedName("amount")
    private Integer amount;

    /**
     * 分账描述
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
