package com.douyinpay.define;

import com.douyinpay.component.certificate.CertificateProvider;
import com.douyinpay.component.crypto.AutoSm2Verifier;
import com.douyinpay.component.crypto.IVerifier;
import com.douyinpay.component.crypto.RsaVerifier;
import com.douyinpay.component.crypto.Sm2Verifier;
import com.douyinpay.exception.DouyinpayException;
import com.douyinpay.util.PemUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;


/**
 * 自动平台证书配置
 * 【注意】：该配置类为自动平台证书配置，应该作为全局唯一变量，不可重复创建。
 */
public final class AutoPlatformCertificateConfig {


  private String mchId;//商户id

  /**
   * 签名算法类型，推荐：RSA
   */
  private String signType = "RSA";

  /**
   * 证书序列号
   */
  private String merchantSerialNumber;


  /**
   * 商户私钥；下面二者传任意一个就可以
   */
  private String privateKey;
  /**
   * 商户私钥路径
   */
  private String privateKeyPath;


  /**
   * 敏感信息对称加密算法类型，推荐：AEAD-AES-256-GCM
   */
  private String encryptType = "AEAD-AES-256-GCM";

  /**
   * 敏感信息对称加密算法密钥
   */
  private String encryptKey;

  /**
   * 自定义HTTP Header
   */
  private Map<String, String> customHeaders;

  private CertificateProvider certificateProvider;


  /**
   * 实际使用的商户私钥
   * @return
   */
  public String praticalPrivateKey() {
    if (StringUtils.isEmpty(privateKeyPath) && StringUtils.isEmpty(privateKey)){
      throw new DouyinpayException("缺少私钥配置信息");
    }
    // 优先使用配置的私钥
    if (StringUtils.isNotEmpty(privateKey)){
      return PemUtil.loadPrivateKeyBase64(privateKey);
    }

    return PemUtil.readPemPrivateKeyBase64(privateKeyPath);

  }


  public String getMchId() {
    return mchId;
  }

  public void setMchId(String mchId) {
    this.mchId = mchId;
  }

  public void setSignType(String signType) {
    this.signType = signType;
  }

  public String getSignType() {
    return signType;
  }

  public String getMerchantSerialNumber() {
    return merchantSerialNumber;
  }

  public void setMerchantSerialNumber(String merchantSerialNumber) {
    this.merchantSerialNumber = merchantSerialNumber;
  }

  public void setPrivateKey(String privateKey) {
    this.privateKey = privateKey;
  }

  public String getPrivateKeyPath() {
    return privateKeyPath;
  }

  public void setPrivateKeyPath(String privateKeyPath) {
    this.privateKeyPath = privateKeyPath;
  }

  public String getEncryptType() {
    return encryptType;
  }

  public void setEncryptType(String encryptType) {
    this.encryptType = encryptType;
  }

  public String getEncryptKey() {
    return encryptKey;
  }

  public void setEncryptKey(String encryptKey) {
    this.encryptKey = encryptKey;
  }

  public Map<String, String> getCustomHeaders() {
    return customHeaders;
  }

  public void setCustomHeaders(Map<String, String> customHeaders) {
    this.customHeaders = customHeaders;
  }

  public CertificateProvider getCertificateProvider() {
    return certificateProvider;
  }

  public void setCertificateProvider(CertificateProvider certificateProvider) {
    this.certificateProvider = certificateProvider;
  }

}





