package com.douyinpay.api.bill.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiBillReponse {

    /**
     * 字段含义：哈希类型。
     * 格式规则：字符串。
     * 业务规则：用于描述账单下载文件校验值的算法类型。
     * 示例：
     */
    @SerializedName("hash_type")
    private String hashType;
    /**
     * 字段含义：哈希值。
     * 格式规则：字符串。
     * 业务规则：用于校验账单下载文件完整性。
     * 示例：
     */
    @SerializedName("hash_value")
    private String hashValue;
    /**
     * 字段含义：账单下载地址。
     * 格式规则：URL。
     * 业务规则：开放文档说明下载地址有时效限制。
     * 示例：https://download.example.com/bill.gz
     */
    @SerializedName("download_url")
    private String downloadUrl;


    public String getHashType() {
        return hashType;
    }

    public void setHashType(String hashType) {
        this.hashType = hashType;
    }

    public String getHashValue() {
        return hashValue;
    }

    public void setHashValue(String hashValue) {
        this.hashValue = hashValue;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiBillReponse {\n");
        sb.append("    hashType: ").append(toIndentedString(hashType)).append("\n");
        sb.append("    hashValue: ").append(toIndentedString(hashValue)).append("\n");
        sb.append("    downloadUrl: ").append(toIndentedString(downloadUrl)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
