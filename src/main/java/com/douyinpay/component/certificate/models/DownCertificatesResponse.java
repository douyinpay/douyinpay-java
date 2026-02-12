package com.douyinpay.component.certificate.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/** 获取平台证书列表返回数据 */
public class DownCertificatesResponse {
 
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