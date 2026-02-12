package com.douyinpay.api.partnerdeduct.models;

import com.google.gson.annotations.SerializedName;
import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiPartnerContractScheduleResponse {
    /*可扣费开始日期 */
    @SerializedName("deduct_start_date")
    private String deductStartDate;

    /*可扣费结束日期 */
    @SerializedName("deduct_end_date")
    private String deductEndDate;

    /*已预约的扣费金额信息 */
    @SerializedName("scheduled_amount")
    private ScheduleAmount scheduledAmount;

    public String getDeductEndDate() {
        return deductEndDate;
    }

    public ScheduleAmount getScheduledAmount() {
        return scheduledAmount;
    }

    public String getDeductStartDate() {
        return deductStartDate;
    }
    public void setDeductEndDate(String deductEndDate) {
        this.deductEndDate = deductEndDate;
    }

    public void setScheduledAmount(ScheduleAmount scheduledAmount) {
        this.scheduledAmount = scheduledAmount;
    }

    public void setDeductStartDate(String deductStartDate) {
        this.deductStartDate = deductStartDate;
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiPartnerContractScheduleRseponse {\n");
        sb.append("    deductStartDate: ").append(toIndentedString(deductStartDate)).append("\n");
        sb.append("    deductEndDate: ").append(toIndentedString(deductEndDate)).append("\n");
        sb.append("    scheduledAmount: ").append(toIndentedString(scheduledAmount)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
