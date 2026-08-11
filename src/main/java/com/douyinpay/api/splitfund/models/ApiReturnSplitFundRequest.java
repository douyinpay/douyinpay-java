package com.douyinpay.api.splitfund.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiReturnSplitFundRequest {

    /**
     * 字段含义：直连商户号。
     * 格式规则：字符串。
     * 业务规则：由抖音支付生成并下发。
     * 示例：6020240223833009
     */
    @SerializedName("mchid")
    private String merchantId;

    /**
     * 字段含义：抖音支付分账单号。
     * 格式规则：字符串。
     * 业务规则：由抖音支付生成，用于标识分账单。
     * 示例：11777200250103110500000223502022
     */
    @SerializedName("order_id")
    private String orderId;

    /**
     * 字段含义：商户分账单号。
     * 格式规则：仅支持数字、大小写字母、_、-、*。
     * 业务规则：用于标识商户侧的分账单。
     * 示例：OUT_1666688488
     */
    @SerializedName("out_order_no")
    private String outOrderNo;

    /**
     * 字段含义：商户回退单号。
     * 格式规则：字符串。
     * 业务规则：用于标识商户侧的分账回退单。
     * 示例：RETURN_1666688488
     */
    @SerializedName("out_return_no")
    private String outReturnNo;

    /**
     * 字段含义：回退商户号。
     * 格式规则：字符串。
     * 业务规则：表示分账回退资金的接收商户号。
     * 示例：6020240223833009
     */
    @SerializedName("return_mchid")
    private String returnMchid;

    /**
     * 字段含义：金额。
     * 格式规则：单位为分的整数。
     * 业务规则：具体语义取决于所在结构，可能表示分账金额、回退金额或完结金额。
     * 示例：10
     */
    @SerializedName("amount")
    private Integer amount;

    /**
     * 字段含义：描述。
     * 格式规则：字符串。
     * 业务规则：用于说明分账、回退或完结分账的原因。
     * 示例：分给合作方
     */
    @SerializedName("description")
    private String description;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
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
