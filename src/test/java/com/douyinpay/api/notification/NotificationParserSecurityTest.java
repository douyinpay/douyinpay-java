package com.douyinpay.api.notification;

import com.douyinpay.component.crypto.IVerifier;
import com.douyinpay.define.Constants;
import com.douyinpay.exception.DouyinpayException;
import org.junit.Assert;
import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Instant;

public class NotificationParserSecurityTest {

    @Test
    public void parseRejectsExpiredCallbackTimestamp() throws Exception {
        NotificationParser parser = newParserWithPassVerifier();
        RequestParam requestParam = new RequestParam.Builder()
                .body("{}")
                .signType(Constants.SIGN_TYPE_RSA)
                .signature("signature")
                .timestamp(String.valueOf(Instant.now().getEpochSecond() - 301))
                .nonce("nonce")
                .serialNumber("serial")
                .build();

        try {
            invokeValidateRequest(parser, requestParam);
            Assert.fail("expected expired callback timestamp error");
        } catch (DouyinpayException e) {
            Assert.assertTrue(e.getMessage().contains("callback timestamp expired"));
        }
    }

    private static NotificationParser newParserWithPassVerifier() throws Exception {
        NotificationParser parser = (NotificationParser) unsafe().allocateInstance(NotificationParser.class);
        Field verifier = NotificationParser.class.getDeclaredField("verifier");
        verifier.setAccessible(true);
        verifier.set(parser, (IVerifier) (plainText, platformCertificate, sign, serialNumber) -> true);
        return parser;
    }

    private static void invokeValidateRequest(NotificationParser parser, RequestParam requestParam) throws Exception {
        Method method = NotificationParser.class.getDeclaredMethod("validateRequest", RequestParam.class);
        method.setAccessible(true);
        try {
            method.invoke(parser, requestParam);
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
