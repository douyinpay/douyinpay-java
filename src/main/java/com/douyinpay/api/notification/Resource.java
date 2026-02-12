package com.douyinpay.api.notification;

import com.douyinpay.util.GsonUtil;

/**
 * 通知数据
 */
public class Resource {

    private String algorithm;
    private String ciphertext;
    private String associatedData;
    private String nonce;
    private String originalType;
    private String mchid;

    public String getAlgorithm() {
        return algorithm;
    }

    public String getCiphertext() {
        return ciphertext;
    }

    public String getAssociatedData() {
        return associatedData;
    }

    public String getOriginalType() {
        return originalType;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public void setCiphertext(String ciphertext) {
        this.ciphertext = ciphertext;
    }

    public void setAssociatedData(String associatedData) {
        this.associatedData = associatedData;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public void setOriginalType(String originalType) {
        this.originalType = originalType;
    }

    @Override
    public String toString() {
        return GsonUtil.getGson().toJson(this);
    }

    public String getNonce() {
        return nonce;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }
}
