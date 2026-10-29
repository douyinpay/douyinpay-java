package com.douyinpay.component.certificate;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AutoCertificateServiceTest {

    @Test
    public void getCertificateReturnsCopyAndMissingMerchantReturnsNull() throws Exception {
        AutoCertificateService.shutdown();
        X509Certificate certificate = newSelfSignedCertificate();
        putCertificate("mch-RSA", "serial", certificate);

        X509Certificate returned = AutoCertificateService.getCertificate("mch", "RSA", "serial");

        Assert.assertNotSame(certificate, returned);
        Assert.assertArrayEquals(certificate.getEncoded(), returned.getEncoded());
        Assert.assertNull(AutoCertificateService.getCertificate("missing", "RSA", "serial"));
    }

    @Test
    public void getAvailableCertificateReturnsCopy() throws Exception {
        AutoCertificateService.shutdown();
        X509Certificate certificate = newSelfSignedCertificate();
        putCertificate("mch-RSA", "serial", certificate);

        X509Certificate returned = AutoCertificateService.getAvailableCertificate("mch", "RSA");

        Assert.assertNotSame(certificate, returned);
        Assert.assertArrayEquals(certificate.getEncoded(), returned.getEncoded());
    }

    @SuppressWarnings("unchecked")
    private static void putCertificate(String key, String serial, X509Certificate certificate) throws Exception {
        Field field = AutoCertificateService.class.getDeclaredField("certificateMap");
        field.setAccessible(true);
        ConcurrentHashMap<String, Map<String, X509Certificate>> certificateMap =
                (ConcurrentHashMap<String, Map<String, X509Certificate>>) field.get(null);
        Map<String, X509Certificate> certificates = new HashMap<>();
        certificates.put(serial, certificate);
        certificateMap.put(key, certificates);
    }

    private static X509Certificate newSelfSignedCertificate() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        KeyPair keyPair = generator.generateKeyPair();
        Date notBefore = new Date(System.currentTimeMillis() - 1000);
        Date notAfter = new Date(System.currentTimeMillis() + 86400000);
        X500Name subject = new X500Name("CN=douyinpay-java-test");
        JcaX509v3CertificateBuilder builder = new JcaX509v3CertificateBuilder(
                subject,
                BigInteger.ONE,
                notBefore,
                notAfter,
                subject,
                keyPair.getPublic());
        ContentSigner signer = new JcaContentSignerBuilder("SHA256withRSA").build(keyPair.getPrivate());
        X509CertificateHolder holder = builder.build(signer);
        return new JcaX509CertificateConverter().getCertificate(holder);
    }
}
