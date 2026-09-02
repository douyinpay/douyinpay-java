package com.douyinpay.api.cashier.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** ApiPrePayOperationInfoViewData */
public class ApiPrePayOperationInfoViewData {
  /**
   * 字段含义：运营文案描述，可用于展示营销内容的具体文案。
   */
  @SerializedName("operation_tip")
  private String operationTip;
  /**
   * 字段含义：固定立减金额，单位为元，只有当立减金额最小值与最大值相等时返回，否则为空。
   */
  @SerializedName("operation_amount")
  private String operationAmount;
  /**
   * 字段含义：立减金额最小值，单位为元，固定立减和随机立减均有值。
   */
  @SerializedName("operation_min_amount")
  private String operationMinAmount;
  /**
   * 字段含义：立减金额最大值，单位为元，固定立减和随机立减均有值。
   */
  @SerializedName("operation_max_amount")
  private String operationMaxAmount;
  /**
   * 字段含义：立减金额单位，默认为“元”。
   */
  @SerializedName("operation_unit")
  private String operationUnit;

  public String getOperationTip() {
    return operationTip;
  }

  public void setOperationTip(String operationTip) {
    this.operationTip = operationTip;
  }

  public String getOperationAmount() {
    return operationAmount;
  }

  public void setOperationAmount(String operationAmount) {
    this.operationAmount = operationAmount;
  }

  public String getOperationMinAmount() {
    return operationMinAmount;
  }

  public void setOperationMinAmount(String operationMinAmount) {
    this.operationMinAmount = operationMinAmount;
  }

  public String getOperationMaxAmount() {
    return operationMaxAmount;
  }

  public void setOperationMaxAmount(String operationMaxAmount) {
    this.operationMaxAmount = operationMaxAmount;
  }

  public String getOperationUnit() {
    return operationUnit;
  }

  public void setOperationUnit(String operationUnit) {
    this.operationUnit = operationUnit;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiPrePayOperationInfoViewData {\n");
    sb.append("    operationTip: ").append(toIndentedString(operationTip)).append("\n");
    sb.append("    operationAmount: ").append(toIndentedString(operationAmount)).append("\n");
    sb.append("    operationMinAmount: ").append(toIndentedString(operationMinAmount)).append("\n");
    sb.append("    operationMaxAmount: ").append(toIndentedString(operationMaxAmount)).append("\n");
    sb.append("    operationUnit: ").append(toIndentedString(operationUnit)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
