package com.douyinpay.component.crypto;

import com.douyinpay.exception.DouyinpayException;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.security.auth.x500.X500Principal;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Date;

/**
 * {@link RsaCryptor} 敏感字段 RSA PKCS#1 v1.5 加解密单元测试。
 */
public class RsaCryptorTest {

    private static X509Certificate certificate;
    private static PrivateKey privateKey;
    private static PrivateKey otherPrivateKey;
    private static final RsaCryptor CRYPTOR = new RsaCryptor();

    @BeforeClass
    public static void setUp() throws Exception {
        KeyPair keyPair = generateRsaKeyPair();
        privateKey = keyPair.getPrivate();
        certificate = selfSignedCertificate(keyPair);
        otherPrivateKey = generateRsaKeyPair().getPrivate();
    }

    @Test
    public void encryptThenDecryptRoundTrip() {
        String plainText = "张三";
        String cipherText = CRYPTOR.encrypt(plainText, certificate);
        Assert.assertNotNull(cipherText);
        Assert.assertNotEquals(plainText, cipherText);
        Assert.assertEquals(plainText, CRYPTOR.decrypt(cipherText, privateKey));
    }

    @Test(expected = DouyinpayException.class)
    public void encryptWithNullCertificateThrows() {
        CRYPTOR.encrypt("110101199001011234", null);
    }

    @Test(expected = DouyinpayException.class)
    public void decryptWithNullPrivateKeyThrows() {
        CRYPTOR.decrypt("whatever", null);
    }

    @Test(expected = DouyinpayException.class)
    public void decryptWithEmptyCipherThrows() {
        CRYPTOR.decrypt("", privateKey);
    }

    @Test(expected = DouyinpayException.class)
    public void decryptIllegalBase64Throws() {
        CRYPTOR.decrypt("not-a-valid-base64-ciphertext===", privateKey);
    }

    @Test(expected = DouyinpayException.class)
    public void decryptWithWrongPrivateKeyThrows() {
        String cipherText = CRYPTOR.encrypt("110101199001011234", certificate);
        CRYPTOR.decrypt(cipherText, otherPrivateKey);
    }

    private static KeyPair generateRsaKeyPair() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        return generator.generateKeyPair();
    }

    private static X509Certificate selfSignedCertificate(KeyPair keyPair) throws Exception {
        X500Principal subject = new X500Principal("CN=douyinpay-test");
        long now = System.currentTimeMillis();
        Date notBefore = new Date(now - 1000L);
        Date notAfter = new Date(now + 365L * 24 * 60 * 60 * 1000);
        JcaX509v3CertificateBuilder builder = new JcaX509v3CertificateBuilder(
                subject, BigInteger.valueOf(now), notBefore, notAfter, subject, keyPair.getPublic());
        ContentSigner signer = new JcaContentSignerBuilder("SHA256withRSA").build(keyPair.getPrivate());
        return new JcaX509CertificateConverter().getCertificate(builder.build(signer));
    }
}
