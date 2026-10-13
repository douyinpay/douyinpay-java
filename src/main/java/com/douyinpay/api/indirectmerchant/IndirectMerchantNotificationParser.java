package com.douyinpay.api.indirectmerchant;

import com.douyinpay.api.indirectmerchant.models.ApplyStatusNotification;
import com.douyinpay.api.notification.Notification;
import com.douyinpay.api.notification.NotificationParser;
import com.douyinpay.api.notification.RequestParam;
import com.douyinpay.exception.DouyinpayException;
import com.douyinpay.util.GsonUtil;

/**
 * 间连商户申请状态通知解析助手。
 *
 * 复用通用 {@link NotificationParser} 完成验签与 AES-256-GCM 解密，并在此基础上追加
 * 事件类型（event_type）守卫，确保回调确为间连商户申请状态通知后再返回业务数据，
 * 与 Go SDK 的 ParseApplyStatusNotify 行为对齐。
 *
 * 官方文档：
 * https://partner.douyinpay.com/wiki/682c7a8e82b07604fd4deccb/6a7489dbaa9a5804d014c2ce
 */
public class IndirectMerchantNotificationParser {

    /** 间连商户申请状态通知的事件类型。 */
    public static final String EVENT_TYPE = "INDIRECT_MERCHANT_APPLYMENT_STATUS";

    private final NotificationParser parser;

    /**
     * @param parser 已按平台证书/密钥配置初始化的通用通知解析器
     */
    public IndirectMerchantNotificationParser(NotificationParser parser) {
        if (parser == null) {
            throw new DouyinpayException("notification parser is required");
        }
        this.parser = parser;
    }

    /**
     * 验签解密间连商户申请状态通知（event_type=INDIRECT_MERCHANT_APPLYMENT_STATUS）。
     *
     * <p>先校验回调信封的事件类型，仅当为间连商户申请状态通知时才解密并返回业务数据；
     * 事件类型为空时按兼容处理不拦截，非预期事件类型时抛出异常。
     *
     * @param requestParam 解析通知所需的请求参数
     * @return 解密后的申请状态通知业务数据
     * @throws DouyinpayException 事件类型非预期或验签/解密失败时抛出
     */
    public ApplyStatusNotification parse(RequestParam requestParam) {
        if (requestParam == null) {
            throw new DouyinpayException("requestParam is required");
        }
        String eventType = resolveEventType(requestParam.getBody());
        if (eventType != null && !eventType.isEmpty() && !EVENT_TYPE.equals(eventType)) {
            throw new DouyinpayException(
                    String.format("unexpected event_type %s", eventType));
        }
        return parser.parse(requestParam, ApplyStatusNotification.class);
    }

    private String resolveEventType(String body) {
        if (body == null || body.isEmpty()) {
            return null;
        }
        try {
            Notification notification = GsonUtil.getGson().fromJson(body, Notification.class);
            return notification == null ? null : notification.getEventType();
        } catch (RuntimeException e) {
            throw new DouyinpayException("parse notification envelope failed", e);
        }
    }
}
