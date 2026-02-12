package com.douyinpay.api.certificates.models;

import com.douyinpay.util.GsonUtil;

public class EncryptCertificate {

    private String algorithm;
    private String nonce;
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