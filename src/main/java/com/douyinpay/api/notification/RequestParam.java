package com.douyinpay.api.notification;

import com.douyinpay.define.Constants;
import com.douyinpay.util.GsonUtil;

/** 抖音支付通知请求参数 */
public class RequestParam {

  private final String serialNumber;
  private final String signature;
  private final String message;
  private final String body;
  private final String signType;

  private RequestParam(
      String serialNumber, String signature, String message, String body, String signType) {
    this.serialNumber = serialNumber;
    this.signature = signature;
    this.message = message;
    this.body = body;
    if (signType == null || signType.isEmpty()) {
      this.signType = Constants.SIGN_TYPE_RSA;
    } else {
      this.signType = signType;
    }
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public String getMessage() {
    return message;
  }

  public String getSignature() {
    return signature;
  }

  public String getBody() {
    return body;
  }

  public String getSignType() {
    return signType;
  }

  @Override
  public String toString() {
    return GsonUtil.getGson().toJson(this);
  }

  public static class Builder {

    String signType;
    private String serialNumber;
    private String timestamp;
    private String nonce;
    private String signature;
    private String body;

    public Builder serialNumber(String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
    }

    public Builder timestamp(String timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    public Builder nonce(String nonce) {
      this.nonce = nonce;
      return this;
    }

    public Builder signature(String signature) {
      this.signature = signature;
      return this;
    }

    public Builder signType(String signType) {
      this.signType = signType;
      return this;
    }

    public Builder body(String body) {
      this.body = body;
      return this;
    }

    public RequestParam build() {
      String message = timestamp + "\n" + nonce + "\n" + body + "\n";
      return new RequestParam(serialNumber, signature, message, body, signType);
    }
  }
}
