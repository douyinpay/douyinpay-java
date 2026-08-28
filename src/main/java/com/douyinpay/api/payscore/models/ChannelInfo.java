package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 支付渠道信息。
 */
public class ChannelInfo {
    // 字段含义：指定渠道列表。
    // 格式规则：array。
    // 示例：[{"channel_code":"OUTSIDE_MC","channel_id":"M2025042914432001250054700","channel_amount":100,"channel_ext_info":""}]。
    @SerializedName("preset_channel")
    private List<PresetChannel> presetChannel;

    public List<PresetChannel> getPresetChannel() {
        return presetChannel;
    }

    public void setPresetChannel(List<PresetChannel> presetChannel) {
        this.presetChannel = presetChannel;
    }
}
