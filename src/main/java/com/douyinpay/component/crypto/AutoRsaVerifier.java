package com.douyinpay.component.crypto;

import com.douyinpay.component.certificate.CertificateProvider;
import com.douyinpay.exception.DouyinpayException;
import org.apache.commons.lang3.StringUtils;

import java.security.cert.X509Certificate;

public class AutoRsaVerifier extends RsaVerifier {
    private final CertificateProvider certificateProvider;

    public AutoRsaVerifier(CertificateProvider certificateProvider) {
        this.certificateProvider = certificateProvider;
    }

    @Override
    public boolean verifyPlatformSign(String plainText, X509Certificate platformCertificate, String sign, String serialNumber) throws DouyinpayException {
        if (this.certificateProvider == null) {
            throw new DouyinpayException("证书提供器未初始化");
        }
        if (StringUtils.isEmpty(serialNumber)) {
            throw new DouyinpayException("平台证书序列号不能为空");
        }
        X509Certificate cert = this.certificateProvider.getCertificate(serialNumber);
        if (cert == null) {
            throw new DouyinpayException("未找到对应序列号的平台证书");
        }
        return verify(plainText, cert.getPublicKey(), sign);
    }
}

