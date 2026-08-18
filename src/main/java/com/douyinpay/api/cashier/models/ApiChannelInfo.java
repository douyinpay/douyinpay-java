package com.douyinpay.api.cashier.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** ApiChannelInfo */
public class ApiChannelInfo {
  /**
   * 字段含义：加密手机号，即请求参数中传入的手机号。
   */
  @SerializedName("blind_mobile")
  private String blindMobile;
  /**
   * 字段含义：渠道唯一索引。
   */
  @SerializedName("channel_index")
  private String channelIndex;
  /**
   * 字段含义：支付渠道名称。
   */
  @SerializedName("channel_name")
  private String channelName;
  /**
   * 字段含义：支付渠道是否可用，true 表示可用，false 表示不可用。
   */
  @SerializedName("channel_enable")
  private Boolean channelEnable;
  /**
   * 字段含义：当次咨询匹配到的营销内容，商户可直接取值展示；需先与抖音支付行业运营沟通，由行业运营配置对应的前置咨询策略及营销活动后才会返回。
   */
  @SerializedName("operation_info")
  private ApiPrePayOperationInfo operationInfo;
  /**
   * 字段含义：指定优惠信息，商户无需关注内容；抖音支付渠道在调用下单接口时需将取值放在优惠标记 goods_tag 中透传带入，先享后付渠道在调用先享后付相关接口时需将取值放在 ext_info 中透传带入，key 均为 assign_discounts。
   */
  @SerializedName("assign_discounts")
  private String assignDiscounts;
  /**
   * 字段含义：扩展信息，JSON 格式，例如返回人群标签信息 biz_tag_list，其中 tag_code 为与抖音支付线下约定的人群标签编码。
   */
  @SerializedName("ext_info")
  private String extInfo;

  public String getBlindMobile() {
    return blindMobile;
  }

  public void setBlindMobile(String blindMobile) {
    this.blindMobile = blindMobile;
  }

  public String getChannelIndex() {
    return channelIndex;
  }

  public void setChannelIndex(String channelIndex) {
    this.channelIndex = channelIndex;
  }

  public String getChannelName() {
    return channelName;
  }

  public void setChannelName(String channelName) {
    this.channelName = channelName;
  }

  public Boolean getChannelEnable() {
    return channelEnable;
  }

  public void setChannelEnable(Boolean channelEnable) {
    this.channelEnable = channelEnable;
  }

  public ApiPrePayOperationInfo getOperationInfo() {
    return operationInfo;
  }

  public void setOperationInfo(ApiPrePayOperationInfo operationInfo) {
    this.operationInfo = operationInfo;
  }

  public String getAssignDiscounts() {
    return assignDiscounts;
  }

  public void setAssignDiscounts(String assignDiscounts) {
    this.assignDiscounts = assignDiscounts;
  }

  public String getExtInfo() {
    return extInfo;
  }

  public void setExtInfo(String extInfo) {
    this.extInfo = extInfo;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiChannelInfo {\n");
    sb.append("    blindMobile: ").append(toIndentedString(blindMobile)).append("\n");
    sb.append("    channelIndex: ").append(toIndentedString(channelIndex)).append("\n");
    sb.append("    channelName: ").append(toIndentedString(channelName)).append("\n");
    sb.append("    channelEnable: ").append(toIndentedString(channelEnable)).append("\n");
    sb.append("    operationInfo: ").append(toIndentedString(operationInfo)).append("\n");
    sb.append("    assignDiscounts: ").append(toIndentedString(assignDiscounts)).append("\n");
    sb.append("    extInfo: ").append(toIndentedString(extInfo)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
