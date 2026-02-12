
package com.douyinpay.api.deduct.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** PrepayResponse */
public class ApiDeductResponse {
  /** prepayId 说明：预支付交易会话标识 */
  @SerializedName("prepay_id")
  private String prepayId;

    /** resultCode 说明：业务处理结果 */
    @SerializedName("result_code")
    private String resultCode;

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiDeductResponse {\n");
        sb.append("    prepayId: ").append(toIndentedString(prepayId)).append("\n");
        sb.append("    resultCode: ").append(toIndentedString(resultCode)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
