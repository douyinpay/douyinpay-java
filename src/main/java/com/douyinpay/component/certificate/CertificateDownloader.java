package com.douyinpay.component.certificate;

import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.DouyinpayRequest;
import com.douyinpay.api.DouyinpayResponse;
import com.douyinpay.api.certificates.models.Certificates;
import com.douyinpay.api.certificates.models.DownCertificatesResponse;
import com.douyinpay.api.certificates.models.EncryptCertificate;
import com.douyinpay.component.crypto.ISymmetricCrypto;
import com.douyinpay.component.crypto.SymmetricFactory;
import com.douyinpay.component.http.HttpMethod;
import com.douyinpay.define.Constants;
import com.douyinpay.define.DomainName;
import com.douyinpay.exception.DouyinpayException;
import com.douyinpay.util.PemUtil;


public final class CertificateDownloader {
    private final DouyinpayClient douyinpayClient;
    private final String encryptKey;
    private final String signType;

    public CertificateDownloader(Builder builder) {
        this.douyinpayClient = builder.douyinpayClient;
        this.encryptKey = builder.encryptKey;
        this.signType = builder.signType;
    }

    public static class Builder {
        private DouyinpayClient douyinpayClient;
        private String encryptKey;
        private String signType;

        public Builder douyinpayClient(DouyinpayClient douyinpayClient) {
            this.douyinpayClient = douyinpayClient;
            return this;
        }

        public Builder encryptKey(String encryptKey) {
            this.encryptKey = encryptKey;
            return this;
        }

        public Builder signType(String signType) {
            this.signType = signType;
            return this;
        }

        public CertificateDownloader build() {
            return new CertificateDownloader(this);
        }
    }

    /**
     * 下载证书
     */
    public Map<String, X509Certificate> download() {

        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.GET,
                DomainName.API.getValue(),
                "/v1/merchant/certificates/getPlatformCertificates", null, null);

        DouyinpayResponse<DownCertificatesResponse> apiResponse = this.douyinpayClient.execute(douyinpayRequest, DownCertificatesResponse.class);
        return decryptCertificate(apiResponse.getApiResponse());
    }

    /**
     * 从应答报文中解密证书
     *
     * @param downCertificatesResponse httpResponse
     * @return 应答报文解密后，生成X.509证书对象的Map
     */
    private Map<String, X509Certificate> decryptCertificate(
            DownCertificatesResponse downCertificatesResponse) {
        if (downCertificatesResponse == null || downCertificatesResponse.getCertificates() == null || downCertificatesResponse.getCertificates().isEmpty()) {
            throw new DouyinpayException("Download certificates response is null");
        }
        Map<String, X509Certificate> downloadCertMap = new HashMap<>();
        for (Certificates data : downCertificatesResponse.getCertificates()) {
            EncryptCertificate encryptCertificate = data.getEncryptCertificate();
            ISymmetricCrypto encryptor = SymmetricFactory.getByName(encryptCertificate.getAlgorithm());
            String decryptCertificate = encryptor.decrypt(encryptCertificate.getCipherText(), this.encryptKey, encryptCertificate.getNonce(), null);
            if (decryptCertificate == null) {
                throw new DouyinpayException("Decrypt certificate is null");
            }

            X509Certificate certificate;
            if (Constants.SIGN_TYPE_RSA.equals(signType)) {
                certificate = PemUtil.loadX509FromString(decryptCertificate);
            } else if (Constants.SIGN_TYPE_SM2.equals(signType)) {
                certificate = PemUtil.loadSMX509FromString(decryptCertificate);
            } else {
                throw new DouyinpayException("SignType is invaild");
            }

            downloadCertMap.put(data.getCertNo(), certificate);
        }
        return downloadCertMap;
    }
}
