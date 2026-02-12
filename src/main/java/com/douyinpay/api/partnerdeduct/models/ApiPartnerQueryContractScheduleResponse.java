package com.douyinpay.api.partnerdeduct.models;

import com.google.gson.annotations.SerializedName;
import static com.douyinpay.util.StringUtil.toIndentedString;



public class ApiPartnerQueryContractScheduleResponse {
    /*可扣费开始日期 */
    @SerializedName("deduct_start_date")
    private String deductStartDate;

    /*可扣费结束日期 */
    @SerializedName("deduct_end_date")
    private String deductEndDate;

    /*预约扣费金额信息 */
    @SerializedName("scheduled_amount")
    private ScheduleAmount scheduledAmount;

    /*预约扣费状态 */
    @SerializedName("schedule_state")
    private String scheduleState;

    /*实际扣费金额 */
    @SerializedName("deduct_amount")
    private ScheduleAmount deductAmount;

    /*实际扣费日期 */
    @SerializedName("deduct_date")
    private String deductDate;

    public ScheduleAmount getDeductAmount() {
        return deductAmount;
    }

    public String getDeductDate() {
        return deductDate;
    }

    public String getDeductEndDate() {
        return deductEndDate;
    }

    public String getDeductStartDate() {
        return deductStartDate;
    }

    public ScheduleAmount getScheduledAmount() {
        return scheduledAmount;
    }

    public String getScheduleState() {
        return scheduleState;
    }
    public void setDeductAmount(ScheduleAmount deductAmount) {
        this.deductAmount = deductAmount;
    }

    public void setDeductDate(String deductDate) {
        this.deductDate = deductDate;
    }

    public void setDeductEndDate(String deductEndDate) {
        this.deductEndDate = deductEndDate;
    }

    public void setDeductStartDate(String deductStartDate) {
        this.deductStartDate = deductStartDate;
    }

    public void setScheduleState(String scheduleState) {
        this.scheduleState = scheduleState;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiPartnerQueryContractScheduleResponse {\n");
        sb.append("    deductStartDate: ").append(toIndentedString(deductStartDate)).append("\n");
        sb.append("    deductEndDate: ").append(toIndentedString(deductEndDate)).append("\n");
        sb.append("    scheduledAmount: ").append(toIndentedString(scheduledAmount)).append("\n");
        sb.append("    scheduleState: ").append(toIndentedString(scheduleState)).append("\n");
        sb.append("    deductAmount: ").append(toIndentedString(deductAmount)).append("\n");
        sb.append("    deductDate: ").append(toIndentedString(deductDate)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
