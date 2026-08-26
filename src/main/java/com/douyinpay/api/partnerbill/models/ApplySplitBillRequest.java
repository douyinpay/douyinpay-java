package com.douyinpay.api.partnerbill.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApplySplitBillRequest {
    /**
     * 字段含义：商户号。
     * 必填规则：必填。
     * 格式规则：string，[1,32]。
     * 业务规则：由抖音支付生成并下发，支持服务商和平台商户传入。
     * 示例：6020230301343998
     */
    @SerializedName("sp_mchid")
    private String spMchid;

    /**
     * 字段含义：子商户号。
     * 必填规则：选填。
     * 格式规则：string，[1,32]。
     * 业务规则：不填则默认返回服务商下的所有分账账单；如需下载某个子商户下的分账账单，则传入指定子商户号。
     * 示例：6020230307605084
     */
    @SerializedName("sub_mchid")
    private String subMchid;

    /**
     * 字段含义：账单日期。
     * 必填规则：必填。
     * 格式规则：yyyy-MM-dd，[1,10]。
     * 业务规则：仅支持三个月内的账单下载申请。
     * 示例：2024-10-10
     */
    @SerializedName("bill_date")
    private String billDate;

    /**
     * 字段含义：压缩类型。
     * 必填规则：必填。
     * 格式规则：string，[1,32]。
     * 业务规则：GZIP 表示返回 .gzip 格式的压缩包账单。
     * 示例：GZIP
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
        sb.append("class ApplySplitBillRequest {\n");
        sb.append("    spMchid: ").append(toIndentedString(spMchid)).append("\n");
        sb.append("    subMchid: ").append(toIndentedString(subMchid)).append("\n");
        sb.append("    billDate: ").append(toIndentedString(billDate)).append("\n");
        sb.append("    tarType: ").append(toIndentedString(tarType)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
