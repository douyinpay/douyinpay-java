package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 支付渠道信息。
 */
public class ChannelInfo {
    /** 预设支付渠道列表。 */
    @SerializedName("preset_channel")
    private List<PresetChannel> presetChannel;

    public List<PresetChannel> getPresetChannel() {
        return presetChannel;
    }

    public void setPresetChannel(List<PresetChannel> presetChannel) {
        this.presetChannel = presetChannel;
    }
}
