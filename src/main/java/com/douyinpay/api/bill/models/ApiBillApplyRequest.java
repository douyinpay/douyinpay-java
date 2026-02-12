package com.douyinpay.api.bill.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiBillApplyRequest {
    /**
     * mchid 说明：直连商户号
     */
    @SerializedName("mchid")
    private String mchid;


    /**
     * 账单日期
     */
    @SerializedName("bill_date")
    private String billDate;
    /**
     * 账单类型
     */
    @SerializedName("bill_type")
    private String billType;

    /**
     * 压缩类型
     */
    @SerializedName("tar_type")
    private String tarType;

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
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
        sb.append("class ApiBillApplyRequest {\n");
        sb.append("    mchid: ").append(toIndentedString(mchid)).append("\n");
        sb.append("    billDate: ").append(toIndentedString(billDate)).append("\n");
        sb.append("    billType: ").append(toIndentedString(billType)).append("\n");
        sb.append("    tarType: ").append(toIndentedString(tarType)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
