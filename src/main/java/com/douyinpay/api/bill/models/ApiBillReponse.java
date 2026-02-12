package com.douyinpay.api.bill.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiBillReponse {

    /**
     * 哈希类型
     */
    @SerializedName("hash_type")
    private String hashType;
    /**
     * 哈希值
     */
    @SerializedName("hash_value")
    private String hashValue;
    /**
     * 账单下载地址
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
