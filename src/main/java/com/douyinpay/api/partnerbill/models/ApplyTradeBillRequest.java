package com.douyinpay.api.partnerbill.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApplyTradeBillRequest {
    /**
     * 字段含义：服务商商户号。
     * 格式规则：字符串。
     * 业务规则：由抖音支付生成并下发，服务商模式必传。
     * 示例：699000000000001
     */
    @SerializedName("sp_mchid")
    private String spMchid;

    /**
     * 字段含义：子商户号。
     * 格式规则：字符串。
     * 业务规则：选填；传入后仅返回该子商户对应的账单数据。
     * 示例：699000000000101
     */
    @SerializedName("sub_mchid")
    private String subMchid;

    /**
     * 字段含义：账单日期。
     * 格式规则：yyyy-MM-dd。
     * 业务规则：仅支持申请近三个月内且为昨日及以前的账单。
     * 示例：2023-02-25
     */
    @SerializedName("bill_date")
    private String billDate;

    /**
     * 字段含义：压缩类型。
     * 必填规则：必填。
     * 格式规则：枚举字符串。
     * 业务规则：常用值为 GZIP，返回 gzip 压缩包账单。
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
        sb.append("class ApplyTradeBillRequest {\n");
        sb.append("    spMchid: ").append(toIndentedString(spMchid)).append("\n");
        sb.append("    subMchid: ").append(toIndentedString(subMchid)).append("\n");
        sb.append("    billDate: ").append(toIndentedString(billDate)).append("\n");
        sb.append("    tarType: ").append(toIndentedString(tarType)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
