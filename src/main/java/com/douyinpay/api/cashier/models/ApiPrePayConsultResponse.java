package com.douyinpay.api.cashier.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import static com.douyinpay.util.StringUtil.toIndentedString;

/** ApiPrePayConsultResponse */
public class ApiPrePayConsultResponse {
  /**
   * 字段含义：渠道信息列表，包含产品、优惠信息，只有查询用户成功才返回对应的查询内容。
   */
  @SerializedName("channel_info_list")
  private List<ApiChannelInfo> channelInfoList;

  public List<ApiChannelInfo> getChannelInfoList() {
    return channelInfoList;
  }

  public void setChannelInfoList(List<ApiChannelInfo> channelInfoList) {
    this.channelInfoList = channelInfoList;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiPrePayConsultResponse {\n");
    sb.append("    channelInfoList: ").append(toIndentedString(channelInfoList)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
