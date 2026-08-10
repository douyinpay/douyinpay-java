package com.douyinpay.api.splitfund.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiSplitFundRequest {

    /**
     * 字段含义：商户应用号。
     * 格式规则：字符串。
     * 业务规则：用于标识分账业务对应的商户应用。
     * 示例：byOOJzkcOJWYmSPBuPWLbDjSSqf
     */
    @SerializedName("appid")
    private String appId;

    /**
     * 字段含义：直连商户号。
     * 格式规则：字符串。
     * 业务规则：由抖音支付生成并下发。
     * 示例：6020240223833009
     */
    @SerializedName("mchid")
    private String merchantId;

    /**
     * 字段含义：抖音支付订单号。
     * 格式规则：字符串。
     * 业务规则：用于标识原支付订单。
     * 示例：21000125010103000993845301123
     */
    @SerializedName("transaction_id")
    private String tradeNo;

    /**
     * 字段含义：商户分账单号。
     * 格式规则：仅支持数字、大小写字母、_、-、*。
     * 业务规则：用于标识商户侧的分账单。
     * 示例：OUT_1666688488
     */
    @SerializedName("out_order_no")
    private String outTradeNo;

    /**
     * 字段含义：分账接收方列表。
     * 格式规则：数组。
     * 业务规则：包含分账接收方信息以及对应的分账结果。
     * 示例：
     */
    @SerializedName("receivers")
    private List<ReceiverInfoDto> receiverInfoDtos;

    /**
     * 字段含义：是否解冻剩余未分账资金。
     * 格式规则：boolean。
     * 业务规则：用于控制分账后剩余未分账资金是否解冻。
     * 示例：false
     */
    @SerializedName("unfreeze_unsplit")
    private Boolean unfreezeUnsplit;

    /**
     * 字段含义：分账回调地址。
     * 格式规则：HTTPS 外网可访问地址。
     * 业务规则：用于接收分账异步通知。
     * 示例：https://www.mock.douyinpay.com/profitsharing/notify
     */
    @SerializedName("notify_url")
    private String notifyUrl;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public List<ReceiverInfoDto> getReceiverInfoDtos() {
        return receiverInfoDtos;
    }

    public void setReceiverInfoDtos(List<ReceiverInfoDto> receiverInfoDtos) {
        this.receiverInfoDtos = receiverInfoDtos;
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
