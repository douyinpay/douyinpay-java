package com.douyinpay.api.notification;

import com.douyinpay.component.crypto.AsymmetricFactory;
import com.douyinpay.component.crypto.IAsymmetricCrypto;
import com.douyinpay.component.crypto.ISymmetricCrypto;
import com.douyinpay.component.crypto.SymmetricFactory;
import com.douyinpay.component.crypto.IVerifier;
import com.douyinpay.component.crypto.VerifierFactory;
import com.douyinpay.define.AutoPlatformCertificateConfig;
import com.douyinpay.exception.DouyinpayException;
import com.douyinpay.util.GsonUtil;
import com.google.gson.Gson;
import java.security.cert.X509Certificate;

import static java.util.Objects.requireNonNull;

/**
 * 通知解析器
 */
public class NotificationParser {

    private final Gson gson = GsonUtil.getGson();

    private X509Certificate publicKeyCertificate;

    private String encryptKey;

    private IAsymmetricCrypto signer;
    private IVerifier verifier;

    private ISymmetricCrypto encryptor;//对称算法


    public NotificationParser(NotificationConfig config) {

        this.encryptKey = config.getEncryptKey();
        this.signer = AsymmetricFactory.getByName(config.getSignType());
        this.verifier = VerifierFactory.getByName(config.getSignType());
        this.encryptor = SymmetricFactory.getByName(config.getCipherType());
        this.publicKeyCertificate = this.signer.loadX509Certificate(config.getCetificate());
    }


    /**
     * 自动平台证书配置构造器
     *
     * @param autoConfig 自动平台证书配置【应取全局唯一的config】
     */
    public NotificationParser(AutoPlatformCertificateConfig autoConfig) {
        this.encryptKey = autoConfig.getEncryptKey();
        this.signer = AsymmetricFactory.getByName(autoConfig.getSignType());
        this.verifier = VerifierFactory.getByName(autoConfig.getSignType(), autoConfig.getCertificateProvider());
        this.encryptor = SymmetricFactory.getByName(autoConfig.getEncryptType());
    }


    /**
     * 解析抖音支付回调通知
     *
     * @param requestParam       解析通知所需要的请求参数
     * @param decryptObjectClass 解密数据的Class对象
     * @param <T>                由Class对象建模的类的类型
     * @return 解密后的回调报文
     */
    public <T> T parse(RequestParam requestParam, Class<T> decryptObjectClass) {
        validateRequest(requestParam);
        return getDecryptObject(requestParam, requireNonNull(decryptObjectClass));
    }

    private void validateRequest(RequestParam requestParam) {
        if (requestParam == null) {
            throw new DouyinpayException(
                    "Verify douyinpay notification parameters, requestParam is null.");
        }
        if (requestParam.getSignType() == null) {
            throw new DouyinpayException(
                    String.format(
                            "Verify douyinpay notification parameters, signType is empty" + ".RequestParam[%s]",
                            requestParam));
        }
        if (requestParam.getSerialNumber() == null) {
            throw new DouyinpayException(
                    String.format(
                            "Verify douyinpay notification parameters, serialNumber is empty"
                                    + ".RequestParam[%s]",
                            requestParam));
        }
        if (requestParam.getMessage() == null) {
            throw new DouyinpayException(
                    String.format(
                            "Verify douyinpay notification parameters, message is empty" + ".RequestParam[%s]",
                            requestParam));
        }
        if (requestParam.getSignature() == null) {
            throw new DouyinpayException(
                    String.format(
                            "Verify douyinpay notification parameters, signature is empty" + ".RequestParam[%s]",
                            requestParam));
        }
        if (!this.verifier.verifyPlatformSign(requestParam.getMessage(), this.publicKeyCertificate, requestParam.getSignature(),requestParam.getSerialNumber())) {
            throw new DouyinpayException(
                    String.format(
                            "Processing douyinpay notification,signature verification failed,"
                                    + "signType[%s]\tserial[%s]\tmessage[%s]\tsign[%s]",
                            requestParam.getSignType(),
                            requestParam.getSerialNumber(),
                            requestParam.getMessage(),
                            requestParam.getSignature()));
        }
    }

    private <T> T getDecryptObject(RequestParam requestParam, Class<T> decryptObjectClass) {
        Notification notification = gson.fromJson(requestParam.getBody(), Notification.class);
        validateNotification(notification);
        String nonce = notification.getResource().getNonce();
        String ciphertext = notification.getResource().getCiphertext();
        String associatedData = notification.getResource().getAssociatedData();
        String plaintext = decryptData(nonce, ciphertext,associatedData);
        return gson.fromJson(plaintext, decryptObjectClass);
    }

    private void validateNotification(Notification notification) {
        if (notification == null) {
            throw new DouyinpayException(
                    "The notification obtained by parsing the Douyinpay notification is null.");
        }
        Resource resource = notification.getResource();
        if (resource == null) {
            throw new DouyinpayException(
                    String.format(
                            "The resource obtained by parsing the Douyinpay notification is null"
                                    + ".Notification[%s]",
                            notification));
        }
        if (resource.getCiphertext() == null) {
            throw new DouyinpayException(
                    String.format(
                            "The ciphertext obtained by parsing the Douyinpay notification is empty.Notification[%s]",
                            notification));
        }
        if (resource.getNonce() == null) {
            throw new DouyinpayException(
                    String.format(
                            "The nonce obtained by parsing the Douyinpay notification is empty.Notification[%s]",
                            notification));
        }
    }

    private String decryptData(String nonce, String ciphertext,String associatedData) {

        return this.encryptor.decrypt(ciphertext, this.encryptKey, nonce,associatedData);
    }
}
