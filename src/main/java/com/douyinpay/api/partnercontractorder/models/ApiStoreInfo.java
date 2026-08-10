package com.douyinpay.api.partnercontractorder.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** 门店信息。开放文档标注为预留字段。 */
public class ApiStoreInfo {
  /**
   * 字段含义：门店编号。
   * 格式规则：字符串。
   * 业务规则：表示商户侧门店编号。
   * 示例：0001
   */
  @SerializedName("id")
  private String id;
  /**
   * 字段含义：门店名称。
   * 格式规则：字符串。
   * 业务规则：表示商户侧门店名称。
   * 示例：测试店铺
   */
  @SerializedName("name")
  private String name;
  /**
   * 字段含义：地区编码。
   * 格式规则：地区编码字符串。
   * 业务规则：取值请以抖音支付开放文档提供的地区编码表为准。
   * 示例：440305
   */
  @SerializedName("area_code")
  private String areaCode;
  /**
   * 字段含义：详细地址。
   * 格式规则：字符串。
   * 业务规则：表示商户门店的详细地址。
   * 示例：北京市海淀区中关村大街
   */
  @SerializedName("address")
  private String address;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAreaCode() {
    return areaCode;
  }

  public void setAreaCode(String areaCode) {
    this.areaCode = areaCode;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiStoreInfo {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    areaCode: ").append(toIndentedString(areaCode)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
