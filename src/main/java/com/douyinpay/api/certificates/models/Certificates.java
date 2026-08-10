package com.douyinpay.api.certificates.models;

import com.douyinpay.util.GsonUtil;

/** 获取平台证书列表返回数据 */
public class Certificates {

    /**
     * 字段含义：证书序列号。
     * 格式规则：字符串。
     * 业务规则：用于唯一标识平台证书。
     * 示例：763CC8F6EF3A8802
     */
    private String certNo;
    /**
     * 字段含义：证书生效时间。
     * 格式规则：YYMMDDHHMMSS。
     * 业务规则：表示平台证书开始生效的时间。
     * 示例：20230322042245
     */
    private String effectiveTime;
    /**
     * 字段含义：证书失效时间。
     * 格式规则：YYMMDDHHMMSS。
     * 业务规则：表示平台证书失效的时间。
     * 示例：20280320042245
     */
    private String expireTime;
    /**
     * 字段含义：证书类型。
     * 格式规则：字符串。
     * 业务规则：开放文档示例值为 RSA。
     * 示例：RSA
     */
    private String certType;
    /**
     * 字段含义：加密证书内容。
     * 格式规则：对象。
     * 业务规则：包含证书密文、加密算法和随机串。
     * 示例：
     */
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
