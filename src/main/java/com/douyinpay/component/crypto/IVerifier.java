package com.douyinpay.component.crypto;

import com.douyinpay.exception.DouyinpayException;

import java.security.cert.X509Certificate;

public interface IVerifier {

    boolean verifyPlatformSign(String plainText, X509Certificate platformCertificate, String sign, String serialNumber) throws DouyinpayException;

}

