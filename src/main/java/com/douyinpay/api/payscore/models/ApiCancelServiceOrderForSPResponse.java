package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

/**
 * 直连服务商取消服务订单响应。
 */
public class ApiCancelServiceOrderForSPResponse {
    /** 抖音支付服务单号。 */
    @SerializedName("order_id")
    private String orderId;
    /** 服务订单状态。 */
    @SerializedName("state")
    private String state;
    /** 订单状态说明。 */
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
