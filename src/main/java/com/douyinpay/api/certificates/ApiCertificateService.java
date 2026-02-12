package com.douyinpay.api.certificates;

import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

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


public class ApiCertificateService {

    private final DouyinpayClient douyinpayClient;
    private final DomainName domainName;//请求域名

    private ApiCertificateService(DouyinpayClient douyinpayClient, DomainName domainName) {
        this.douyinpayClient = douyinpayClient;
        this.domainName = domainName;
    }


    public static class Builder {

        private DouyinpayClient douyinpayClient;
        private DomainName domainName;

        /**
         * 设置抖音支付域名 默认为api.douyinpay.com
         *
         * @param domainName 抖音支付域名
         * @return Builder
         */
        public Builder domainName(DomainName domainName) {
            this.domainName = domainName;
            return this;
        }

        /**
         * 设置自定义httpclient
         *
         * @param douyinpayClient
         * @return Builder
         */
        public Builder douyinpayClient(DouyinpayClient douyinpayClient) {
            this.douyinpayClient = douyinpayClient;
            return this;
        }

        /**
         * 构造服务
         *
         * @return AppService
         */
        public ApiCertificateService build() {
            return new ApiCertificateService(douyinpayClient, domainName);
        }
    }

    public String getRequestUrl() {
        String domainName = DomainName.API.getValue();


        if (this.domainName != null) {
            domainName = this.domainName.getValue();
        }

        return domainName;
    }


    /**
     * 获取平台证书
     *
     * @param
     * @return
     */
    public DownCertificatesResponse getPlatformCertificates() {

        String requestPath = "/v1/merchant/certificates/getPlatformCertificates";

        String requestUrl = getRequestUrl();
        // 发起请求
        DouyinpayRequest douyinpayRequest = new DouyinpayRequest(HttpMethod.GET, requestUrl, requestPath, null, null);

        DouyinpayResponse<DownCertificatesResponse> apiResponse = douyinpayClient.execute(douyinpayRequest, DownCertificatesResponse.class);

        return apiResponse.getApiResponse();
    }

    public List<X509Certificate> downloadCertificate(String encryptKey) {

        DownCertificatesResponse downCertificatesResponse = getPlatformCertificates();

        if (downCertificatesResponse == null || downCertificatesResponse.getCertificates() == null || downCertificatesResponse.getCertificates().isEmpty()) {
            throw new DouyinpayException("Download certificates response is null");
        }

        List<X509Certificate> certificates = new ArrayList<>();
        for (Certificates data : downCertificatesResponse.getCertificates()) {
            EncryptCertificate encryptCertificate = data.getEncryptCertificate();
            ISymmetricCrypto encryptor = SymmetricFactory.getByName(encryptCertificate.getAlgorithm());
            String decryptCertificate = encryptor.decrypt(
                    encryptCertificate.getCipherText(), encryptKey, encryptCertificate.getNonce(), null);
            if (decryptCertificate == null) {
                throw new DouyinpayException("Decrypt certificate is null");
            }

            X509Certificate certificate;
            String signType = data.getCertType();
            if (Constants.SIGN_TYPE_RSA.equals(signType)) {
                certificate = PemUtil.loadX509FromString(decryptCertificate);
            } else if (Constants.SIGN_TYPE_SM2.equals(signType)) {
                certificate = PemUtil.loadSMX509FromString(decryptCertificate);
            } else {
                throw new DouyinpayException("SignType is invaild");
            }
            certificates.add(certificate);

        }
        return certificates;
    }

}
