package com.douyinpay.api.indirectmerchant;

import com.douyinpay.api.indirectmerchant.models.ApplyStatusNotification;
import com.douyinpay.api.notification.NotificationParser;
import com.douyinpay.api.notification.RequestParam;
import com.douyinpay.exception.DouyinpayException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * 校验间连商户申请状态通知解析助手的事件类型守卫逻辑。
 */
public class IndirectMerchantNotificationParserTest {

    private RequestParam requestParamWithBody(String body) {
        return new RequestParam.Builder()
                .serialNumber("serial")
                .timestamp("1700000000")
                .nonce("nonce")
                .signature("sign")
                .signType("DouyinPay-SHA256-RSA2048")
                .body(body)
                .build();
    }

    /** 事件类型匹配时应解密并返回业务数据。 */
    @Test
    public void parseReturnsDecryptedDataWhenEventTypeMatches() {
        NotificationParser inner = mock(NotificationParser.class);
        ApplyStatusNotification expected = new ApplyStatusNotification();
        expected.applymentId = "APL123";
        RequestParam param = requestParamWithBody(
                "{\"event_type\":\"INDIRECT_MERCHANT_APPLYMENT_STATUS\",\"resource\":{}}");
        when(inner.parse(eq(param), eq(ApplyStatusNotification.class))).thenReturn(expected);

        ApplyStatusNotification got = new IndirectMerchantNotificationParser(inner).parse(param);
        assertSame(expected, got);
    }

    /** 事件类型为空时按兼容处理，不拦截，照常解密。 */
    @Test
    public void parseAllowsEmptyEventType() {
        NotificationParser inner = mock(NotificationParser.class);
        ApplyStatusNotification expected = new ApplyStatusNotification();
        RequestParam param = requestParamWithBody("{\"resource\":{}}");
        when(inner.parse(any(RequestParam.class), eq(ApplyStatusNotification.class))).thenReturn(expected);

        assertSame(expected, new IndirectMerchantNotificationParser(inner).parse(param));
    }

    /** 非预期事件类型应抛出异常，且不触发解密。 */
    @Test
    public void parseRejectsUnexpectedEventType() {
        NotificationParser inner = mock(NotificationParser.class);
        RequestParam param = requestParamWithBody(
                "{\"event_type\":\"OTHER_EVENT\",\"resource\":{}}");
        try {
            new IndirectMerchantNotificationParser(inner).parse(param);
            fail("expected DouyinpayException for unexpected event_type");
        } catch (DouyinpayException e) {
            // 期望异常
        }
        verify(inner, never()).parse(any(RequestParam.class), any());
    }

    /** 事件类型常量应与官方约定一致。 */
    @Test
    public void eventTypeConstantMatchesContract() {
        assertEquals("INDIRECT_MERCHANT_APPLYMENT_STATUS",
                IndirectMerchantNotificationParser.EVENT_TYPE);
    }

    /** 解析器为空时构造应抛出异常。 */
    @Test
    public void constructRejectsNullParser() {
        try {
            new IndirectMerchantNotificationParser(null);
            fail("expected DouyinpayException for null parser");
        } catch (DouyinpayException e) {
            // 期望异常
        }
    }
}
