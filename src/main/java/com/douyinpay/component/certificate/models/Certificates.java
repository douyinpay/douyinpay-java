package com.douyinpay.component.certificate.models;

import com.douyinpay.util.GsonUtil;

/** 获取平台证书列表返回数据 */
public class Certificates {

    private String certNo;
    private String effectiveTime;
    private String expireTime;
    private String certType;
    private EncryptCertificate encryptCertificate;
    
    /** 证书编号 */
    public String getCertNo() {
      return certNo;
    }
  
    public void setCertNo(String certNo) {
      this.certNo = certNo;
    }
  
    public EncryptCertificate getEncryptCertificate() {
      return encryptCertificate;
    }
  
    public void setEncryptCertificate(EncryptCertificate encryptCertificate) {
      this.encryptCertificate = encryptCertificate;
    }
  
    public String getEffectiveTime() {
      return effectiveTime;
    }
  
    public void setEffectiveTime(String effectiveTime) {
      this.effectiveTime = effectiveTime;
    }
  
    public String getExpireTime() {
      return expireTime;
    }
  
    public void setExpireTime(String expireTime) {
      this.expireTime = expireTime;
    }
  
    @Override
    public String toString() {
      return GsonUtil.getGson().toJson(this);
    }

    public String getCertType() {
      return certType;
    }
  
    public void setCertType(String certType) {
      this.certType = certType;
    }
  }
  