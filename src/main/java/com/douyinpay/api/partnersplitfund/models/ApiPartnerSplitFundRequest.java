package com.douyinpay.api.partnersplitfund.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiPartnerSplitFundRequest {
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
     * 业务规则：填写服务商在抖音开放平台申请的 AppID，需确保与 sp_mchid 存在绑定关系；当分账接收方包含 PERSONAL_SP_OPENID 类型时使用该应用作用域。
     * 示例：awofz9bncda6w2w4
     */
    @SerializedName("sp_appid")
    private String spAppid;

    /**
     * 字段含义：特约商户号。
     * 格式规则：字符串，长度为 1-32 位。
     * 业务规则：由抖音支付生成并下发，用于标识被服务的特约商户主体。
     * 示例：6020221212167702
     */
    @SerializedName("sub_mchid")
    private String subMchid;

    /**
     * 字段含义：特约商户应用ID。
     * 格式规则：字符串，长度为 1-32 位。
     * 业务规则：填写特约商户在抖音开放平台申请的 AppID，需确保与 sub_mchid 存在绑定关系；当分账接收方包含 PERSONAL_SUB_OPENID 类型时使用该应用作用域。
     * 示例：awofz9bncda6w2w4
     */
    @SerializedName("sub_appid")
    private String subAppid;

    /**
     * 字段含义：抖音支付订单号。
     * 格式规则：字符串，长度为 1-32 位。
     * 业务规则：填写原支付交易对应的交易订单号。
     * 示例：TP2022101317144741443210681000
     */
    @SerializedName("transaction_id")
    private String tradeNo;

    /**
     * 字段含义：商户分账单号。
     * 格式规则：字符串，长度为 6-32 位，仅支持数字、大小写字母及 _-*。
     * 业务规则：商户系统内部的分账单号，在商户系统内部唯一，同一分账单号多次请求等同一次。
     * 示例：OUT_1666688488
     */
    @SerializedName("out_order_no")
    private String outOrderNo;

    /**
     * 字段含义：分账接收方列表。
     * 格式规则：对象数组。
     * 业务规则：最多可传 50 个分账接收方，可以设置出资商户作为分账接收方。
     * 示例：[{"type":"MERCHANT_ID","account":"6020230307605084","amount":100,"description":"分给合作方"}]
     */
    @SerializedName("receivers")
    private List<PartnerReceiverInfoDto> receivers;

    /**
     * 字段含义：是否解冻剩余未分账资金。
     * 格式规则：布尔值。
     * 业务规则：true 表示该笔订单剩余未分账金额会结算给商户；false 表示剩余未分账金额不会解冻回分账方商户，后续仍可继续分账。
     * 示例：true
     */
    @SerializedName("unfreeze_unsplit")
    private Boolean unfreezeUnsplit;

    /**
     * 字段含义：分账回调地址。
     * 格式规则：URL 字符串，长度为 1-1024 位，必须为 HTTPS 直连可访问地址且不允许携带查询串。
     * 业务规则：交易成功后，通过该地址接收分账结果通知。
     * 示例：https://www.mock.douyinpay.com
     */
    @SerializedName("notify_url")
    private String notifyUrl;

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

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public List<PartnerReceiverInfoDto> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<PartnerReceiverInfoDto> receivers) {
        this.receivers = receivers;
    }

    public Boolean getUnfreezeUnsplit() {
        return unfreezeUnsplit;
    }

    public void setUnfreezeUnsplit(Boolean unfreezeUnsplit) {
        this.unfreezeUnsplit = unfreezeUnsplit;
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
