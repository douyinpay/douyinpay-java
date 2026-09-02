package com.douyinpay.api.cashier.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** ApiPrePayOperationInfo */
public class ApiPrePayOperationInfo {
  /**
   * 字段含义：支付产品，即请求中传入的产品编码。
   */
  @SerializedName("product_code")
  private String productCode;
  /**
   * 字段含义：运营展示数据，可用于展示营销内容的文案组合。
   */
  @SerializedName("view_data")
  private ApiPrePayOperationInfoViewData viewData;

  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public ApiPrePayOperationInfoViewData getViewData() {
    return viewData;
  }

  public void setViewData(ApiPrePayOperationInfoViewData viewData) {
    this.viewData = viewData;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiPrePayOperationInfo {\n");
    sb.append("    productCode: ").append(toIndentedString(productCode)).append("\n");
    sb.append("    viewData: ").append(toIndentedString(viewData)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
