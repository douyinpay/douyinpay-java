package com.douyinpay.api;

import com.douyinpay.component.crypto.IVerifier;
import com.douyinpay.define.Constants;
import com.douyinpay.exception.DouyinpayException;
import org.junit.Assert;
import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class DefaultDouyinpayClientSecurityTest {

    @Test
    public void noPublicAutoDownloadConstructorWithBypassVerifier() {
        for (java.lang.reflect.Constructor<?> constructor : DefaultDouyinpayClient.class.getConstructors()) {
            boolean oldAutoDownloadSignature = constructor.getParameterTypes().length == 6
                    && Modifier.isPublic(constructor.getModifiers());
            if (oldAutoDownloadSignature) {
                Assert.fail("auto certificate downloader constructor must not be public");
            }
        }
    }

    @Test
    public void validatePlatformSignRejectsResponseOlderThanFiveMinutes() throws Exception {
        DefaultDouyinpayClient client = newClientWithPassVerifier();
        Map<String, String> headers = new HashMap<>();
        headers.put(Constants.DOUYIN_PAY_TIMESTAMP, String.valueOf(Instant.now().getEpochSecond() - 301));
        headers.put(Constants.DOUYIN_PAY_NONCE, "nonce");
        headers.put(Constants.DOUYIN_PAY_SIGNATURE, "signature");
        headers.put(Constants.DOUYIN_PAY_SERIAL, "serial");
        headers.put(Constants.DOUYIN_REQUEST_ID, "request-id");

        try {
            invokeValidatePlatformSign(client, headers, "{}");
            Assert.fail("expected expired response timestamp error");
        } catch (DouyinpayException e) {
            Assert.assertTrue(e.getMessage().contains("httpResponse is expires"));
        }
    }

    private static DefaultDouyinpayClient newClientWithPassVerifier() throws Exception {
        DefaultDouyinpayClient client = (DefaultDouyinpayClient) unsafe().allocateInstance(DefaultDouyinpayClient.class);
        Field verifier = DefaultDouyinpayClient.class.getDeclaredField("verifier");
        verifier.setAccessible(true);
        verifier.set(client, (IVerifier) (plainText, platformCertificate, sign, serialNumber) -> true);
        return client;
    }

    private static void invokeValidatePlatformSign(DefaultDouyinpayClient client, Map<String, String> headers, String body) throws Exception {
        Method method = DefaultDouyinpayClient.class.getDeclaredMethod("validatePlatformSign", Map.class, String.class);
        method.setAccessible(true);
        try {
            method.invoke(client, headers, body);
        } catch (InvocationTargetException e) {
            if (e.getCause() instanceof DouyinpayException) {
                throw (DouyinpayException) e.getCause();
            }
            throw e;
        }
    }

    private static Unsafe unsafe() throws Exception {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        return (Unsafe) field.get(null);
    }
}
