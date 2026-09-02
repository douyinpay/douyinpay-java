package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

/**
 * 预设支付渠道。
 */
public class PresetChannel {
    // 字段含义：指定渠道。
    // 格式规则：string[1,128]。
    // 业务规则：指定必用渠道名称，上传与抖音支付约定的值。
    // 示例：OUTSIDE_MC。
    @SerializedName("channel_code")
    private String channelCode;
    // 字段含义：指定渠道ID。
    // 格式规则：string[1,64]。
    // 业务规则：指定必用渠道ID，上传与抖音支付约定的渠道。
    // 示例：HLQXK。
    @SerializedName("channel_id")
    private String channelId;
    // 字段含义：指定渠道金额。
    // 格式规则：int64。
    // 示例：100。
    @SerializedName("channel_amount")
    private Long channelAmount;
    // 字段含义：扩展信息。
    // 格式规则：string。
    // 示例：""。
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
