package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

/**
 * 直连服务商取消服务订单响应。
 */
public class ApiCancelServiceOrderForSPResponse {
    // 字段含义：抖音支付服务订单号。
    // 格式规则：string。
    // 业务规则：每个抖音支付服务订单号与商户号下对应的商户服务订单号一一对应。
    // 示例：10050100220208060900000023310957。
    @SerializedName("order_id")
    private String orderId;
    // 字段含义：服务订单状态。
    // 格式规则：string。
    // 业务规则：枚举值：CREATED表示商户已创建服务订单；DOING表示服务订单进行中；DONE表示服务订单完成；REVOKED表示商户取消服务订单；EXPIRED表示服务订单已失效。
    // 示例：DOING。
    @SerializedName("state")
    private String state;
    // 字段含义：订单状态说明。
    // 格式规则：string。
    // 业务规则：对服务订单“进行中”状态的附加说明：MCH_COMPLETE: 商户完结；USER_PAYING: 用户支付中；USER_CONFIRM: 用户已确认。
    // 示例：USER_PAYING。
    @SerializedName("state_description")
    private String stateDescription;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateDescription() {
        return stateDescription;
    }

    public void setStateDescription(String stateDescription) {
        this.stateDescription = stateDescription;
    }
}
