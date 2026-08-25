package com.douyinpay.api.bill.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApplySplitBillRequest {
    /**
     * 字段含义：直连商户号。
     * 必填规则：OpenAPI 文档标注为选填。
     * 格式规则：string，[1,32]。
     * 业务规则：直连商户的商户号，由抖音支付生成并下发。
     * 示例：6020230307605084
     */
    @SerializedName("mchid")
    private String mchid;

    /**
     * 字段含义：账单日期。
     * 必填规则：OpenAPI 文档标注为选填。
     * 格式规则：yyyy-MM-dd，[1,10]。
     * 业务规则：仅支持三个月内的账单下载申请。
     * 示例：2023-02-25
     */
    @SerializedName("bill_date")
    private String billDate;


    /**
     * 字段含义：压缩类型。
     * 必填规则：OpenAPI 文档标注为选填。
     * 格式规则：string，[1,32]。
     * 业务规则：GZIP 表示返回 .gzip 格式的压缩包账单。
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
        sb.append("    mchid: ").append(toIndentedString(mchid)).append("\n");
        sb.append("    billDate: ").append(toIndentedString(billDate)).append("\n");
        sb.append("    tarType: ").append(toIndentedString(tarType)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
