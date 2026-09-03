package com.douyinpay.api.partnerbill.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiBillReponse {

    /**
     * 字段含义：哈希类型。
     * 格式规则：string，[1,32]。
     * 业务规则：SHA1 表示账单文件摘要使用 SHA1 算法。
     * 示例：SHA1
     */
    @SerializedName("hash_type")
    private String hashType;
    /**
     * 字段含义：哈希值。
     * 格式规则：string，[1,1024]。
     * 业务规则：原始账单（gzip 需要解压缩）的摘要值，用于校验文件完整性。
     * 示例：b3d51ec31534a5e027b49e78a61e20770973f70f
     */
    @SerializedName("hash_value")
    private String hashValue;
    /**
     * 字段含义：账单下载地址。
     * 格式规则：URL，[1,2048]。
     * 业务规则：供下一步请求账单文件的下载地址，该地址 5 分钟内有效。
     * 示例：https://download.douyinpay.com/v1/billdownload/file?token=shgvbeh1BWB84eXGz8rptvm5Po2uTKOnkqwc8W2DS721jY9rGL6ETWHEpARlSswz
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
