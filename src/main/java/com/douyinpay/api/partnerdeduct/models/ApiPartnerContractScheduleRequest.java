package com.douyinpay.api.partnerdeduct.models;

import com.google.gson.annotations.SerializedName;
import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiPartnerContractScheduleRequest {
    /** 委托代扣协议 id */
    @SerializedName("contract_id")
    private String contractId;
    
    /** 服务商商户号 */
    @SerializedName("sp_mchid")
    private String spMchid;

    /** 子商户号 */
    @SerializedName("sub_mchid")
    private String subMchid;

    /** 预计扣费金额信息 */
    @SerializedName("schedule_amount")
    private ScheduleAmount scheduleAmount;

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getSpMchid() {
        return spMchid;
    }

    public void setSpMchid(String spMchid) {
        this.spMchid = spMchid;
    }

    public String getSubMchid() {
        return subMchid;
    }

    public void setSubMchid(String subMchid) {
        this.subMchid = subMchid;
    }

    public ScheduleAmount getScheduleAmount() {
        return scheduleAmount;
    }

    public void setScheduleAmount(ScheduleAmount scheduleAmount) {
        this.scheduleAmount = scheduleAmount;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiPartnerContractScheduleRequest {\n");
        sb.append("    contractId: ").append(toIndentedString(contractId)).append("\n");
        sb.append("    spMchid: ").append(toIndentedString(spMchid)).append("\n");
        sb.append("    subMchid: ").append(toIndentedString(subMchid)).append("\n");
        sb.append("    scheduleAmount: ").append(toIndentedString(scheduleAmount)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
