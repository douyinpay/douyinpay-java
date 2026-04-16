package com.douyinpay.api.splitfund.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiSplitFundRequest {

    /**
     * 应用ID
     */
    @SerializedName("appid")
    private String appId;

    /**
     * 直连商户号
     */
    @SerializedName("mchid")
    private String merchantId;

    /**
     * 抖音支付订单号
     */
    @SerializedName("transaction_id")
    private String tradeNo;

    /**
     * 商户分账单号
     */
    @SerializedName("out_order_no")
    private String outTradeNo;

    /**
     * 分账接收方列表
     */
    @SerializedName("receivers")
    private List<ReceiverInfoDto> receiverInfoDtos;

    /**
     * 是否解冻剩余未分账资金
     */
    @SerializedName("unfreeze_unsplit")
    private Boolean unfreezeUnsplit;

    /**
     * 分账回调地址
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
