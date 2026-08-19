
package com.douyinpay.api.deduct.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

/** 扣款申请响应参数。 */
public class ApiDeductResponse {
  /**
   * 字段含义：预支付交易会话标识。
   * 格式规则：字符串。
   * 业务规则：用于后续支付处理。
   */
  @SerializedName("prepay_id")
  private String prepayId;

    /**
     * 字段含义：业务处理结果。
     * 格式规则：枚举字符串。
     * 业务规则：SUCCESS 表示处理成功，FAIL 表示处理失败。
     * 示例：SUCCESS
     */
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
