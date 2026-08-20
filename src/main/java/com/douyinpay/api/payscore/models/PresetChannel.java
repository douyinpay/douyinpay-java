package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

/**
 * 预设支付渠道。
 */
public class PresetChannel {
    /** 指定必用渠道编码。 */
    @SerializedName("channel_code")
    private String channelCode;
    /** 指定必用渠道 ID。 */
    @SerializedName("channel_id")
    private String channelId;
    /** 指定渠道金额。 */
    @SerializedName("channel_amount")
    private Long channelAmount;
    /** 渠道扩展参数。 */
    @SerializedName("channel_ext_info")
    private String channelExtInfo;

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Long getChannelAmount() {
        return channelAmount;
    }

    public void setChannelAmount(Long channelAmount) {
        this.channelAmount = channelAmount;
    }

    public String getChannelExtInfo() {
        return channelExtInfo;
    }

    public void setChannelExtInfo(String channelExtInfo) {
        this.channelExtInfo = channelExtInfo;
    }
}
