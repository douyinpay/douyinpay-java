package com.douyinpay.component.crypto;

import com.douyinpay.exception.DouyinpayException;

import java.io.IOException;
import java.security.cert.X509Certificate;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.gm.GMObjectIdentifiers;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;

import java.math.BigInteger;

import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;

import java.security.cert.CertificateException;
import java.util.Collection;

import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.SignerInformation;
import org.bouncycastle.cms.SignerInformationStore;

import java.security.NoSuchProviderException;

public class Sm2Verifier implements IVerifier {

    @Override
    public boolean verifyPlatformSign(String plainText, X509Certificate platformCertificate, String sign, String serialNumber) throws DouyinpayException {
        if (plainText == null || plainText.isEmpty()) {
            throw new DouyinpayException("SM2签名原文[plainText]不能为空");
        }
        if (platformCertificate == null) {
            throw new DouyinpayException("平台证书不能为空");
        }
        if (platformCertificate.getPublicKey() == null) {
            throw new DouyinpayException("SM2公钥[publicKey]不能为空");
        }
        if (sign == null || sign.isEmpty()) {
            throw new DouyinpayException("SM2待验证的签名[sign]不能为空");
        }

        String serial = com.douyinpay.util.PemUtil.getSerialNumber(platformCertificate);
        if (!serial.equals(serialNumber)) {
            throw new DouyinpayException(String.format("response serialNo[%s] not equal platformCertificate serialNo[%s]", serialNumber, serial));
        }

        return verifyPlatformCertificate(plainText, platformCertificate, sign);
    }


    protected boolean verifyPlatformCertificate(String plainText, X509Certificate platformCertificate, String sign) throws DouyinpayException {

        try {
            // 按照PKCS7格式解析sign值
            byte[] signByte = Base64.decode(sign);
            CMSSignedData s = new CMSSignedData(signByte);
            SignerInformationStore signers = s.getSignerInfos();
            // 只验证第一个签名者,参考java-cfca
            SignerInformation signerInfo = signers.getSigners().iterator().next();

            // SID是签名者的唯一标识，用于关联签名者和对应的证书
            Collection<?> certCollection = s.getCertificates().getMatches(signerInfo.getSID());
            if (certCollection.isEmpty()) {
                throw new CMSException("未找到与签名者SID匹配的证书");
            }
            // 转换为标准X509Certificate
            X509Certificate cert = new JcaX509CertificateConverter()
                    .setProvider(BouncyCastleProvider.PROVIDER_NAME)
                    .getCertificate((X509CertificateHolder) certCollection.iterator().next());
            // 验证签名证书与平台证书一致
            if (!cert.getPublicKey().equals(platformCertificate.getPublicKey())) {
                throw new SecurityException("签名证书与平台证书公钥不匹配");
            }

            byte[] encryptedDigest = signerInfo.toASN1Structure().getEncryptedDigest().getOctets();
            // 规范化 r、s，解决前导0的问题
            byte[] canonicalSig = fixSignatureEncoding(encryptedDigest);
            Signature signatureVerifier = Signature.getInstance(GMObjectIdentifiers.sm2sign_with_sm3.toString(), BouncyCastleProvider.PROVIDER_NAME);
            signatureVerifier.initVerify(platformCertificate.getPublicKey());
            signatureVerifier.update(plainText.getBytes());
            return signatureVerifier.verify(canonicalSig);
        } catch (CMSException | CertificateException e) {
            throw new DouyinpayException("SM2 signature parse fail.", e);
        } catch (InvalidKeyException e) {
            throw new DouyinpayException("SM2 verify uses an illegal certificate.", e);
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            throw new DouyinpayException("The current Java environment does not support SM2withSM3", e);
        } catch (SignatureException e) {
            throw new DouyinpayException("SM2 verify not pass", e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] fixSignatureEncoding(byte[] signatureRaw) throws IOException {
        try {
            // 不存在前导0
            ASN1Sequence seq = ASN1Sequence.getInstance(ASN1Primitive.fromByteArray(signatureRaw));
            return signatureRaw;
        } catch (Exception e) {
            // 手动解析R、S
            BigInteger r, s;
            // signature的TLV（tag、length、value）
            // 若L大于127，需要多一个字节存长度值
            if (signatureRaw[0] == 0x30) {
                // 找到R的TLV
                int off = 2;
                if ((signatureRaw[1] & 0x80) != 0) off += (signatureRaw[1] & 0x7F);
                // 开始解析R
                if (signatureRaw[off] == 0x02) {
                    int lenR = signatureRaw[off + 1]; // 理论上固定32位
                    byte[] rBytes = new byte[lenR];
                    System.arraycopy(signatureRaw, off + 2, rBytes, 0, lenR);
                    r = new BigInteger(1, rBytes);

                    // 找到S的TLV
                    off += 2 + lenR;
                    // 开始解析S
                    if (signatureRaw[off] == 0x02) {
                        int lenS = signatureRaw[off + 1]; // 理论上固定32位
                        byte[] sBytes = new byte[lenS];
                        System.arraycopy(signatureRaw, off + 2, sBytes, 0, lenS);
                        s = new BigInteger(1, sBytes);

                        // 构造新的DER
                        ASN1EncodableVector v = new ASN1EncodableVector();
                        v.add(new ASN1Integer(r));
                        v.add(new ASN1Integer(s));
                        return new DERSequence(v).getEncoded();
                    }
                }
            }
        }
        return null;
    }

}