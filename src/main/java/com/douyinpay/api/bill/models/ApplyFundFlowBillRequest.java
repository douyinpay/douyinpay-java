package com.douyinpay.api.bill.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApplyFundFlowBillRequest {
    /**
     * 字段含义：直连商户号。
     * 格式规则：字符串。
     * 业务规则：由抖音支付生成并下发。
     * 示例：6020230307605084
     */
    @SerializedName("mchid")
    private String mchid;


    /**
     * 字段含义：账单日期。
     * 格式规则：yyyy-MM-dd。
     * 业务规则：仅支持申请三个月内的账单。
     * 示例：2023-02-25
     */
    @SerializedName("bill_date")
    private String billDate;

    /**
     * 字段含义：账户类型。
     * 格式规则：枚举字符串。
     * 业务规则：开放文档示例包含 BaseAccount、OperationAccount，默认值为基本账户。
     * 示例：BaseAccount
     */
    @SerializedName("account_type")
    private String accountType;

    /**
     * 字段含义：压缩类型。
     * 格式规则：枚举字符串。
     * 业务规则：开放文档示例值为 GZIP，返回 gzip 压缩包账单。
     * 示例：GZIP
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