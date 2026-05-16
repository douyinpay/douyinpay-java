package com.douyinpay.component.crypto;

import com.douyinpay.exception.DouyinpayException;
import org.bouncycastle.crypto.engines.SM2Engine;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.interfaces.BCECPrivateKey;
import org.bouncycastle.jce.interfaces.BCECPublicKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECParameterSpec;
import org.bouncycastle.math.ec.ECPoint;

import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.util.Base64;

public class Sm2Cryptor implements ICryptor {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    private static final String SM2_CURVE = "sm2p256v1";

    @Override
    public String encrypt(String plainText, X509Certificate certificate) throws DouyinpayException {
        if (certificate == null) {
            throw new DouyinpayException("SM2加密证书不能为空");
        }
        if (plainText == null || plainText.isEmpty()) {
            return plainText;
        }
        ECPublicKeyParameters publicKeyParameters = toPublicKeyParameters(certificate.getPublicKey());
        SM2Engine engine = new SM2Engine(SM2Engine.Mode.C1C3C2);
        engine.init(true, new ParametersWithRandom(publicKeyParameters, new SecureRandom()));
        try {
            byte[] input = plainText.getBytes(StandardCharsets.UTF_8);
            byte[] encrypted = engine.processBlock(input, 0, input.length);
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            throw new DouyinpayException("SM2加密失败", e);
        }
    }

    @Override
    public String decrypt(String cipherText, PrivateKey privateKey) throws DouyinpayException {
        if (cipherText == null || cipherText.isEmpty()) {
            return cipherText;
        }
        if (privateKey == null) {
            throw new DouyinpayException("SM2解密私钥不能为空");
        }
        ECPrivateKeyParameters privateKeyParameters = toPrivateKeyParameters(privateKey);
        SM2Engine engine = new SM2Engine(SM2Engine.Mode.C1C3C2);
        engine.init(false, privateKeyParameters);
        try {
            byte[] encrypted = Base64.getDecoder().decode(cipherText);
            byte[] decrypted = engine.processBlock(encrypted, 0, encrypted.length);
            return new String(decrypted, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new DouyinpayException("SM2解密失败", e);
        }
    }

    private ECPublicKeyParameters toPublicKeyParameters(PublicKey publicKey) throws DouyinpayException {
        if (publicKey instanceof BCECPublicKey) {
            BCECPublicKey bcKey = (BCECPublicKey) publicKey;
            ECDomainParameters domain = new ECDomainParameters(
                    bcKey.getParameters().getCurve(),
                    bcKey.getParameters().getG(),
                    bcKey.getParameters().getN(),
                    bcKey.getParameters().getH()
            );
            return new ECPublicKeyParameters(bcKey.getQ(), domain);
        }
        if (publicKey instanceof ECPublicKey) {
            ECPublicKey ecKey = (ECPublicKey) publicKey;
            ECParameterSpec sm2Spec = ECNamedCurveTable.getParameterSpec(SM2_CURVE);
            if (sm2Spec == null) {
                throw new DouyinpayException("SM2曲线参数加载失败");
            }
            ECPoint point = sm2Spec.getCurve().createPoint(
                    ecKey.getW().getAffineX(),
                    ecKey.getW().getAffineY()
            );
            ECDomainParameters domain = new ECDomainParameters(
                    sm2Spec.getCurve(),
                    sm2Spec.getG(),
                    sm2Spec.getN(),
                    sm2Spec.getH()
            );
            return new ECPublicKeyParameters(point, domain);
        }
        throw new DouyinpayException("SM2公钥类型不支持");
    }

    private ECPrivateKeyParameters toPrivateKeyParameters(PrivateKey privateKey) throws DouyinpayException {
        if (privateKey instanceof BCECPrivateKey) {
            BCECPrivateKey bcKey = (BCECPrivateKey) privateKey;
            ECDomainParameters domain = new ECDomainParameters(
                    bcKey.getParameters().getCurve(),
                    bcKey.getParameters().getG(),
                    bcKey.getParameters().getN(),
                    bcKey.getParameters().getH()
            );
            return new ECPrivateKeyParameters(bcKey.getD(), domain);
        }
        if (privateKey instanceof ECPrivateKey) {
            ECPrivateKey ecKey = (ECPrivateKey) privateKey;
            ECParameterSpec sm2Spec = ECNamedCurveTable.getParameterSpec(SM2_CURVE);
            if (sm2Spec == null) {
                throw new DouyinpayException("SM2曲线参数加载失败");
            }
            ECDomainParameters domain = new ECDomainParameters(
                    sm2Spec.getCurve(),
                    sm2Spec.getG(),
                    sm2Spec.getN(),
                    sm2Spec.getH()
            );
            return new ECPrivateKeyParameters(ecKey.getS(), domain);
        }
        throw new DouyinpayException("SM2私钥类型不支持");
    }
}
