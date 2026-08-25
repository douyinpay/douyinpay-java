package com.douyinpay.api.partnersplitfund.models;

import com.douyinpay.enums.SplitFundReceiverTypeEnum;
import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiPartnerDeleteSplitReceiverResponse {
    /**
     * 字段含义：特约商户号。
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

    @Override
    public String toString() {
        return GsonUtil.objectToJson(this);
    }
}
