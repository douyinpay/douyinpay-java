package com.douyinpay.component.certificate;

import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.component.crypto.AsymmetricFactory;

import java.security.cert.X509Certificate;
import static java.util.Objects.requireNonNull;

public final class AutoCertificateProvider implements CertificateProvider {

  private final String signType;
  private final String merchantId;

  private AutoCertificateProvider(String merchantId, String signType, String encryptKey, DouyinpayClient client) {
    this.merchantId = requireNonNull(merchantId);
    this.signType = requireNonNull(signType);

    CertificateDownloader downloader =
        new CertificateDownloader.Builder()
            .encryptKey(requireNonNull(encryptKey))
            .signType(requireNonNull(signType))
            .douyinpayClient(requireNonNull(client))
            .build();
    AutoCertificateService.register(merchantId, signType, downloader);
  }

  @Override
  public X509Certificate getCertificate(String serialNumber) {
    return AutoCertificateService.getCertificate(merchantId, signType, serialNumber);
  }

  @Override
  public X509Certificate getAvailableCertificate() {
    return AutoCertificateService.getAvailableCertificate(merchantId, signType);
  }

  public static class Builder {
    private String merchantId;
    private String signType;
    private String encryptKey;
    private DouyinpayClient douyinpayClient;

    public Builder merchantId(String merchantId) {
      this.merchantId = merchantId;
      return this;
    }

    public Builder signType(String signType) {
      this.signType = signType;
      return this;
    }

    public Builder encryptKey(String encryptKey) {
      this.encryptKey = encryptKey;
      return this;
    }

    public Builder douyinpayClient(DouyinpayClient client) {
      this.douyinpayClient = client;
      return this;
    }

    public AutoCertificateProvider build() {
      return new AutoCertificateProvider(merchantId, signType, encryptKey, douyinpayClient);
    }
  }
}
