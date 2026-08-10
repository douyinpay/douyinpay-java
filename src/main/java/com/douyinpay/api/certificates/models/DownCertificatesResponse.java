package com.douyinpay.api.certificates.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/** 获取平台证书列表返回数据 */
public class DownCertificatesResponse {
 
    /**
     * 字段含义：平台证书列表。
     * 格式规则：数组。
     * 业务规则：返回当前可用的平台证书信息。
     * 示例：
     */
    @SerializedName("certificates")
    List<Certificates> certificates;
  
    public List<Certificates> getCertificates() {
      return certificates;
    }
  
    public void setCertificates(List<Certificates> certificates) {
      this.certificates = certificates;
    }
  
    @Override
    public String toString() {
      return GsonUtil.getGson().toJson(this);
    }
  
}
