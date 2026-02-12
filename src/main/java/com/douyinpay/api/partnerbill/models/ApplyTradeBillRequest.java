package com.douyinpay.api.partnerbill.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApplyTradeBillRequest {
    /**
     * mchid 说明：商户号
     */
    @SerializedName("sp_mchid")
    private String spMchid;

    /**
     * mchid 说明：子商户号
     */
    @SerializedName("sub_mchid")
    private String subMchid;

    /**
     * 账单日期
     */
    @SerializedName("bill_date")
    private String billDate;

    /**
     * 压缩类型
     */
    @SerializedName("tar_type")
    private String tarType;

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

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getTarType() {
        return tarType;
    }

    public void setTarType(String tarType) {
        this.tarType = tarType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApplyTradeBillRequest {\n");
        sb.append("    spMchid: ").append(toIndentedString(spMchid)).append("\n");
        sb.append("    subMchid: ").append(toIndentedString(subMchid)).append("\n");
        sb.append("    billDate: ").append(toIndentedString(billDate)).append("\n");
        sb.append("    tarType: ").append(toIndentedString(tarType)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
