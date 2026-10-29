package com.douyinpay.component.certificate;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.security.NoSuchProviderException;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/** 定时更新证书的服务，它是一个由静态函数构成的工具类 */
public class AutoCertificateService {
    private static final Logger logger = LoggerFactory.getLogger(AutoCertificateService.class);

    protected static final int UPDATE_INTERVAL_MINUTE = 60;
    private static final Duration defaultUpdateInterval = Duration.ofMinutes(UPDATE_INTERVAL_MINUTE);
    private static final ConcurrentHashMap<String, Map<String, X509Certificate>> certificateMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Runnable> downloadWorkerMap = new ConcurrentHashMap<>();
    private static final ScheduledThreadPoolExecutor serviceExecutor = new ScheduledThreadPoolExecutor(
            1,
            new ThreadFactory() {

                private final AtomicInteger threadCount = new AtomicInteger(0);

                @Override
                public Thread newThread(Runnable r) {
                    Thread t = new Thread(r, "auto-certificate-service-daemon-" + threadCount.incrementAndGet());
                    // 用户线程执行完成后不会阻止 JVM 退出
                    t.setDaemon(true);
                    return t;
                }
            });

    static {
        // 取消时立即从工作队列中删除
        serviceExecutor.setRemoveOnCancelPolicy(true);
    }

    private static ScheduledFuture<?> future;

    private static int updateCount;

    private AutoCertificateService() {
        throw new IllegalStateException("this class cannot be instantiated");
    }

    /**
     * 注册证书下载任务 如果是第一次注册，会先下载证书。如果能成功下载，再保存下载器，供定时更新证书使用。如果下载失败，会抛出异常。
     * 如果已经注册过，当前传入的下载器将覆盖之前的下载器。如果当前下载器不能下载证书，定时更新证书会失败。
     *
     * @param merchantId 商户号
     * @param type       调用方自定义的证书类型，例如 RSA/SM2
     * @param downloader 证书下载器
     */
    public static void register(String merchantId, String type, CertificateDownloader downloader) {
        String key = calculateDownloadWorkerMapKey(merchantId, type);
        Runnable worker = () -> {
            Map<String, X509Certificate> result = downloader.download();
            certificateMap.put(key, result);
        };

        // 下载证书，以验证配置是正确的
        // 如果错误将抛出异常，fast-fail
        worker.run();
        // 更新配置
        downloadWorkerMap.put(key, worker);

        start(defaultUpdateInterval);
    }

    /**
     * 注销证书下载任务
     *
     * @param merchantId 商户号
     * @param type       调用方自定义的证书类型，应等于 `register()` 时的值
     */
    public static void unregister(String merchantId, String type) {
        String key = calculateDownloadWorkerMapKey(merchantId, type);
        downloadWorkerMap.remove(key);
    }

    /** 清理所有已注册的下载器和已下载的证书，并取消定时更新证书的动作。 */
    public static void shutdown() {
        downloadWorkerMap.clear();
        certificateMap.clear();
        synchronized (AutoCertificateService.class) {
            if (future != null) {
                future.cancel(false);
                future = null;
            }
        }
    }

    /**
     * 启动更新证书的周期性动作
     *
     * @param updateInterval 更新证书的周期
     */
    public static void start(Duration updateInterval) {
        synchronized (AutoCertificateService.class) {
            if (future == null) {
                future = serviceExecutor.scheduleAtFixedRate(
                        AutoCertificateService::update,
                        updateInterval.toMillis() / TimeUnit.SECONDS.toMillis(1),
                        updateInterval.toMillis() / TimeUnit.SECONDS.toMillis(1),
                        TimeUnit.SECONDS);
            }
        }
    }

    private static void update() {

        logger.info("auto update certificate, count: {}", updateCount);
        downloadWorkerMap.forEach(
                (k, v) -> {
                    try {
                        v.run();
                        logger.info("auto update certificate success, key: {}", k);
                    } catch (Exception e) {
                        logger.error("auto update certificate failed, key: {}", k, e);
                    }
                });
        updateCount++;
    }

    private static String calculateDownloadWorkerMapKey(String merchantId, String type) {
        return merchantId + "-" + type;
    }

    private static X509Certificate getAvailableCertificate(
            Map<String, X509Certificate> certificateMap) {
        if (certificateMap == null || certificateMap.isEmpty()) {
            return null;
        }
        // 假设拿到的都是可用的，选取一个能用最久的
        X509Certificate longest = null;
        for (X509Certificate item : certificateMap.values()) {
            if (longest == null || item.getNotAfter().after(longest.getNotAfter())) {
                longest = item;
            }
        }
        return copyCertificate(longest);
    }

    // 根据证书序列号获取证书
    public static X509Certificate getCertificate(
            String merchantId, String type, String serialNumber) {
        String key = calculateDownloadWorkerMapKey(merchantId, type);
        Map<String, X509Certificate> certificates = certificateMap.get(key);
        if (certificates == null) {
            return null;
        }
        return copyCertificate(certificates.get(serialNumber));
    }

    // 获取最新可用的抖音支付平台证书
    public static X509Certificate getAvailableCertificate(String merchantId, String type) {
        String key = calculateDownloadWorkerMapKey(merchantId, type);
        return getAvailableCertificate(certificateMap.get(key));
    }

    private static X509Certificate copyCertificate(X509Certificate certificate) {
        if (certificate == null) {
            return null;
        }
        try {
            X509Certificate copy = (X509Certificate) CertificateFactory.getInstance("X.509")
                    .generateCertificate(new ByteArrayInputStream(certificate.getEncoded()));
            return copy == certificate ? new DelegatingX509Certificate(certificate) : copy;
        } catch (CertificateException e) {
            throw new IllegalArgumentException("平台证书拷贝失败", e);
        }
    }

    private static final class DelegatingX509Certificate extends X509Certificate {
        private final X509Certificate delegate;

        private DelegatingX509Certificate(X509Certificate delegate) {
            this.delegate = delegate;
        }

        @Override
        public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
            delegate.checkValidity();
        }

        @Override
        public void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
            delegate.checkValidity(date);
        }

        @Override
        public int getVersion() {
            return delegate.getVersion();
        }

        @Override
        public BigInteger getSerialNumber() {
            return delegate.getSerialNumber();
        }

        @Override
        public Principal getIssuerDN() {
            return delegate.getIssuerDN();
        }

        @Override
        public Principal getSubjectDN() {
            return delegate.getSubjectDN();
        }

        @Override
        public Date getNotBefore() {
            return delegate.getNotBefore();
        }

        @Override
        public Date getNotAfter() {
            return delegate.getNotAfter();
        }

        @Override
        public byte[] getTBSCertificate() throws CertificateEncodingException {
            return delegate.getTBSCertificate();
        }

        @Override
        public byte[] getSignature() {
            return delegate.getSignature();
        }

        @Override
        public String getSigAlgName() {
            return delegate.getSigAlgName();
        }

        @Override
        public String getSigAlgOID() {
            return delegate.getSigAlgOID();
        }

        @Override
        public byte[] getSigAlgParams() {
            return delegate.getSigAlgParams();
        }

        @Override
        public boolean[] getIssuerUniqueID() {
            return delegate.getIssuerUniqueID();
        }

        @Override
        public boolean[] getSubjectUniqueID() {
            return delegate.getSubjectUniqueID();
        }

        @Override
        public boolean[] getKeyUsage() {
            return delegate.getKeyUsage();
        }

        @Override
        public List<String> getExtendedKeyUsage() throws CertificateParsingException {
            return delegate.getExtendedKeyUsage();
        }

        @Override
        public int getBasicConstraints() {
            return delegate.getBasicConstraints();
        }

        @Override
        public Collection<List<?>> getSubjectAlternativeNames() throws CertificateParsingException {
            return delegate.getSubjectAlternativeNames();
        }

        @Override
        public Collection<List<?>> getIssuerAlternativeNames() throws CertificateParsingException {
            return delegate.getIssuerAlternativeNames();
        }

        @Override
        public byte[] getEncoded() throws CertificateEncodingException {
            return delegate.getEncoded();
        }

        @Override
        public void verify(PublicKey key) throws CertificateException, NoSuchAlgorithmException,
                InvalidKeyException, NoSuchProviderException, SignatureException {
            delegate.verify(key);
        }

        @Override
        public void verify(PublicKey key, String sigProvider) throws CertificateException,
                NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
            delegate.verify(key, sigProvider);
        }

        @Override
        public String toString() {
            return delegate.toString();
        }

        @Override
        public PublicKey getPublicKey() {
            return delegate.getPublicKey();
        }

        @Override
        public Set<String> getCriticalExtensionOIDs() {
            return delegate.getCriticalExtensionOIDs();
        }

        @Override
        public Set<String> getNonCriticalExtensionOIDs() {
            return delegate.getNonCriticalExtensionOIDs();
        }

        @Override
        public byte[] getExtensionValue(String oid) {
            return delegate.getExtensionValue(oid);
        }

        @Override
        public boolean hasUnsupportedCriticalExtension() {
            return delegate.hasUnsupportedCriticalExtension();
        }
    }
}
