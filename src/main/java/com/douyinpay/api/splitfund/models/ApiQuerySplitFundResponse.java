package com.douyinpay.api.splitfund.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiQuerySplitFundResponse {
    @SerializedName("transaction_id")
    private String tradeNo;

    @SerializedName("out_order_no")
    private String outTradeNO;

    @SerializedName("order_id")
    private String orderId;

    @SerializedName("state")
    private String state;

    @SerializedName("receivers")
    private List<ReceiverSplitResultDto> receiverSplitResultDtos;

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOutTradeNO() {
        return outTradeNO;
    }

    public void setOutTradeNO(String outTradeNO) {
        this.outTradeNO = outTradeNO;
    }

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

    public List<ReceiverSplitResultDto> getReceiverSplitResultDtos() {
        return receiverSplitResultDtos;
    }

    public void setReceiverSplitResultDtos(List<ReceiverSplitResultDto> receiverSplitResultDtos) {
        this.receiverSplitResultDtos = receiverSplitResultDtos;
    }

    @Override
    public String toString() {
        return GsonUtil.objectToJson(this);
    }
}
