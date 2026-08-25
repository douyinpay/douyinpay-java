package com.douyinpay.api.partnersplitfund.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiPartnerFinishSplitFundRequest {
    /**
     * 字段含义：服务商户号。
     * 格式规则：字符串，长度为 1-32 位。
     * 业务规则：由抖音支付生成并下发，用于标识服务商主体。
     * 示例：6020250310533405
     */
    @SerializedName("sp_mchid")
    private String spMchid;

    /**
     * 字段含义：特约商户号。
     * 格式规则：字符串，长度为 1-32 位。
     * 业务规则：由抖音支付生成并下发，用于标识被服务的特约商户主体。
     * 示例：6020250314534907
     */
    @SerializedName("sub_mchid")
    private String subMchid;

    /**
     * 字段含义：交易订单号。
     * 格式规则：字符串，长度为 1-32 位。
     * 业务规则：填写抖音支付订单号，用于定位需完结分账的交易。
     * 示例：TP2022101317144741443210681000
     */
    @SerializedName("transaction_id")
    private String transactionId;

    /**
     * 字段含义：商户分账单号。
     * 格式规则：字符串，长度为 6-32 位，仅支持数字、大小写字母及 _-*。
     * 业务规则：商户系统内部的分账单号，在商户系统内部唯一，同一分账单号多次请求等同一次。
     * 示例：OUT_1666688488
     */
    @SerializedName("out_order_no")
    private String outOrderNo;

    /**
     * 字段含义：完结分账描述。
     * 格式规则：字符串，长度为 1-64 位。
     * 业务规则：填写完结分账的原因描述，会在分账账单中体现。
     * 示例：测试商品分账
     */
    @SerializedName("description")
    private String description;

    /**
     * 字段含义：通知地址。
     * 格式规则：HTTPS URL，不允许携带查询串。
     * 业务规则：交易成功后，通过该地址通知完结分账结果；要求为直接可访问的地址。
     * 示例：https://www.notify.com
     */
    @SerializedName("notify_url")
    private String notifyUrl;

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

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    @Override
    public String toString() {
        return GsonUtil.objectToJson(this);
    }
}
