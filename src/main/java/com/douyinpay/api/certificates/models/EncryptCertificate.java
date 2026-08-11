package com.douyinpay.api.certificates.models;

import com.douyinpay.util.GsonUtil;

public class EncryptCertificate {

    /**
     * 字段含义：加密算法。
     * 格式规则：字符串。
     * 业务规则：开放文档示例值为 AEAD-AES-256-GCM。
     * 示例：AEAD-AES-256-GCM
     */
    private String algorithm;
    /**
     * 字段含义：随机串。
     * 格式规则：字符串。
     * 业务规则：对应加密算法中的 IV。
     * 示例：6tKL7i5sEaO4
     */
    private String nonce;
    /**
     * 字段含义：证书密文。
     * 格式规则：字符串。
     * 业务规则：需结合接口加密密钥进行解密。
     * 示例：lRatST1Wlxoxxxxxxxxxxxxxxxx
     */
    private String cipherText;
  
    public String getAlgorithm() {
      return algorithm;
    }
  
    public void setAlgorithm(String algorithm) {
      this.algorithm = algorithm;
    }
  
    public void setNonce(String nonce) {
      this.nonce = nonce;
    }
  
    public String getCipherText() {
      return cipherText;
    }
  
    public void setCipherText(String cipherText) {
      this.cipherText = cipherText;
    }
  
    @Override
    public String toString() {
      return GsonUtil.getGson().toJson(this);
    }
  
    public String getNonce() {
      return nonce;
    }
  }
