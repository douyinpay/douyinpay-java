package com.doupay.api.notification;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.doupay.api.secret.Config;
import com.douyinpay.api.notification.Notification;
import com.douyinpay.api.notification.NotificationConfig;
import com.douyinpay.api.notification.NotificationParser;
import com.douyinpay.api.notification.RequestParam;
import com.douyinpay.api.payments.common.ApiTransaction;
import com.douyinpay.define.Constants;
import com.douyinpay.util.GsonUtil;

public class NotificationParserTest {

    private static NotificationConfig config;

    private static final String body = "";
    private static final String data = "";

    @BeforeClass
    public static void init() {
        config = new NotificationConfig.Builder()
                .signType(Constants.SIGN_TYPE_RSA)
                .cipherType(Constants.ENCRYPT_TYPE_AES)
                .platformCertPath(Config.PLATFORM_CERTIFICATE_PATH)
                .encryptKey(Config.ENCRYPT_KEY)
                .build();
    }

    @Test
    public void TestParse() throws Exception {
        NotificationParser parser = new NotificationParser(config);
        String timeStamp = "";
        String nonce = "";
        String sign = "";
        RequestParam param = new RequestParam.Builder()
                .body(body)
                .signType(Constants.SIGN_TYPE_RSA)
                .signature(sign)
                .timestamp(timeStamp)
                .nonce(nonce)
                .serialNumber("")
                .build();
        String originData = parser.parse(param, String.class);
        System.out.println(originData);
        Assert.assertEquals(data, originData);
    }

    /** 交易通知解析示例。 */
    public void parseTransactionNotificationDemo(
            NotificationParser parser,
            String requestBody,
            String serial,
            String timestamp,
            String nonce,
            String signature) {
        RequestParam requestParam = new RequestParam.Builder()
                .body(requestBody)
                .signType(Constants.SIGN_TYPE_RSA)
                .signature(signature)
                .timestamp(timestamp)
                .nonce(nonce)
                .serialNumber(serial)
                .build();

        Notification notification = GsonUtil.getGson().fromJson(requestBody, Notification.class);
        ApiTransaction content = parser.parse(requestParam, ApiTransaction.class);

        String eventType = notification.getEventType();
        String tradeType = content.getTradeType();

        switch (eventType) {
            case "TRANSACTION.SUCCESS":
                if ("SGP".equals(tradeType) || "NPP".equals(tradeType)) {
                    // 处理直连商户扣款成功通知。
                } else {
                    // 处理普通支付成功通知。
                }
                break;
            case "TRANSACTION.FAIL":
                if ("SGP".equals(tradeType) || "NPP".equals(tradeType)) {
                    // 处理直连商户扣款失败通知。
                } else {
                    // 处理普通支付失败通知。
                }
                break;
            default:
                // 处理其他通知类型。
                break;
        }

        System.out.printf("content=%s, notification=%s\n", content, notification);
    }
}
