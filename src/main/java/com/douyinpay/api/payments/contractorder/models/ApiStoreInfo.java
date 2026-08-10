package com.douyinpay.api.payments.contractorder.models;

import static com.douyinpay.util.StringUtil.toIndentedString;

import com.google.gson.annotations.SerializedName;

/** 商户门店信息 （预留字段） */
public class ApiStoreInfo {
  /**
   * 字段含义：门店编号。
   * 格式规则：字符串。
   * 业务规则：当前接口文档未明确说明 id 字段的使用规则，暂保留该字段以兼容现有模型。
   * 示例：
   */
  @SerializedName("id")
  private String id;
  /**
   * 字段含义：门店名称。
   * 格式规则：字符串。
   * 业务规则：当前接口文档未明确说明 name 字段的使用规则，暂保留该字段以兼容现有模型。
   * 示例：
   */
  @SerializedName("name")
  private String name;
  /**
   * 字段含义：地区编码。
   * 格式规则：字符串。
   * 业务规则：当前接口文档未明确说明 area_code 字段的使用规则，暂保留该字段以兼容现有模型。
   * 示例：
   */
  @SerializedName("area_code")
  private String areaCode;
  /**
   * 字段含义：详细地址。
   * 格式规则：字符串。
   * 业务规则：当前接口文档未明确说明 address 字段的使用规则，暂保留该字段以兼容现有模型。
   * 示例：
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
