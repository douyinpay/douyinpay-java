package com.douyinpay.api.tranferreturn.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiTransferReturnResponse {
    @SerializedName("refund_order_id")
    private String refundOrderId; // 退款单号

    @SerializedName("out_request_no")
    private String outRequestNo; // 外部请求流水号

    @SerializedName("refund_amount")
    private Amount refundAmount; // 退款金额

    @SerializedName("status")
    private String status; // 退款状态

    @SerializedName("refund_date")
    private String refundDate; // 退款日期

    public String getRefundOrderId() {
        return refundOrderId;
    }

    public void setRefundOrderId(String refundOrderId) {
        this.refundOrderId = refundOrderId;
    }

    public String getOutRequestNo() {
        return outRequestNo;
    }

    public void setOutRequestNo(String outRequestNo) {
        this.outRequestNo = outRequestNo;
    }

    public Amount getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Amount refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(String refundDate) {
        this.refundDate = refundDate;
    }

    @Override
    public String toString() {
        return GsonUtil.objectToJson(this);
    }
}
