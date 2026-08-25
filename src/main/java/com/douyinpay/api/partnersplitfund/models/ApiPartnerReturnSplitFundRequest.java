package com.douyinpay.api.partnersplitfund.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiPartnerReturnSplitFundRequest {
    /**
     * 字段含义：服务商户号。
     * 格式规则：字符串，长度为 1-32 位。
     * 业务规则：由抖音支付生成并下发，用于标识服务商主体。
     * 示例：6020230307605001
     */
    @SerializedName("sp_mchid")
    private String spMchid;

    /**
     * 字段含义：特约商户号。
     * 格式规则：字符串，长度为 1-32 位。
     * 业务规则：由抖音支付生成并下发，用于标识被服务的特约商户主体。
     * 示例：6020230307605002
     */
    @SerializedName("sub_mchid")
    private String subMchid;

    /**
     * 字段含义：抖音支付分账单号。
     * 格式规则：字符串，长度为 1-32 位。
     * 业务规则：抖音支付返回的唯一分账单标识，与商户分账单号二选一定位原分账单。
     * 示例：11777200250103110500000223512022
     */
    @SerializedName("order_id")
    private String orderId;

    /**
     * 字段含义：商户分账单号。
     * 格式规则：字符串，长度为 6-32 位，仅支持数字、大小写字母及 _-*。
     * 业务规则：商户系统内部的分账单号，在商户系统内部唯一，同一分账单号多次请求等同一次；与抖音支付分账单号二选一定位原分账单。
     * 示例：OUT_31357802300250606199830
     */
    @SerializedName("out_order_no")
    private String outOrderNo;

    /**
     * 字段含义：商户回退单号。
     * 格式规则：字符串，长度为 1-32 位。
     * 业务规则：商户在自己后台生成的新回退单号，在商户后台唯一。
     * 示例：OUT_338004
     */
    @SerializedName("out_return_no")
    private String outReturnNo;

    /**
     * 字段含义：回退商户号。
     * 格式规则：字符串，长度为 1-32 位。
     * 业务规则：分账回退的出资商户，只能对原分账请求中成功分给商户接收方的资金执行回退。
     * 示例：6020231219024876
     */
    @SerializedName("return_mchid")
    private String returnMchid;

    /**
     * 字段含义：回退金额。
     * 格式规则：整数。
     * 业务规则：单位为分，只能为整数，不能超过原始分账单分给该接收方的金额。
     * 示例：10
     */
    @SerializedName("amount")
    private Integer amount;

    /**
     * 字段含义：回退描述。
     * 格式规则：字符串，长度为 1-80 位。
     * 业务规则：填写分账回退的原因描述。
     * 示例：退分账
     */
    @SerializedName("description")
    private String description;

    public String getSpMchid() {
        return spMchid;
    }

    public void setSpMchid(String spMchid) {
        this.spMchid = spMchid;
    }

    public String getSubMchid() {
        return subMchid;
    }

    public void setSubMchid(String subMchid) {
        this.subMchid = subMchid;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public String getOutReturnNo() {
        return outReturnNo;
    }

    public void setOutReturnNo(String outReturnNo) {
        this.outReturnNo = outReturnNo;
    }

    public String getReturnMchid() {
        return returnMchid;
    }

    public void setReturnMchid(String returnMchid) {
        this.returnMchid = returnMchid;
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
