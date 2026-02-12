package com.douyinpay.api.bill.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApplyFundFlowBillRequest {
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
     * 账户类型
     */
    @SerializedName("account_type")
    private String accountType;

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

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String billType) {
        this.accountType = billType;
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
        sb.append("class ApplyFundFlowBillRequest {\n");
        sb.append("    mchid: ").append(toIndentedString(mchid)).append("\n");
        sb.append("    billDate: ").append(toIndentedString(billDate)).append("\n");
        sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
        sb.append("    tarType: ").append(toIndentedString(tarType)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}