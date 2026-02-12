package com.douyinpay.api.partnerdeduct.models;

import com.google.gson.annotations.SerializedName;
import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiPartnerQueryContractScheduleRequest {
    /*委托代扣协议 id */
    @SerializedName("contract_id")
    private String contractId;

    /*服务商商户号 */
    @SerializedName("sp_mchid")
    private String spMchid;

    /*子商户号 */
    @SerializedName("sub_mchid")
    private String subMchid;

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
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiPartnerQueryContractScheduleRequest {\n");
        sb.append("    contractId: ").append(toIndentedString(contractId)).append("\n");
        sb.append("    spMchid: ").append(toIndentedString(spMchid)).append("\n");
        sb.append("    subMchid: ").append(toIndentedString(subMchid)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
