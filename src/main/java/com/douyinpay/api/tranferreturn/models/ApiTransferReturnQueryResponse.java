package com.douyinpay.api.tranferreturn.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiTransferReturnQueryResponse {
    @SerializedName("mchid")
    private String merchantId; //商户号

    @SerializedName("order_id")
    private String orderId; // 抖音正向转账单号

    @SerializedName("refund_order_id")
    private String refundOrderId; // 退款单号

    @SerializedName("out_request_no")
    private String outRequestNo; // 外部请求流水号

    @SerializedName("refund_amount")
    private Amount refundAmount; // 退款请求

    @SerializedName("status")
    private String status; // 备注

    @SerializedName("refund_date")
    private String refundDate; // 扩展信息

    @SerializedName("fail_reason_desp")
    private String failReasonDesp; // 失败原因描述

    @SerializedName("fail_reason")
    private String failReason; // 失败原因


    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

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

    public String getFailReasonDesp() {
        return failReasonDesp;
    }

    public void setFailReasonDesp(String failReasonDesp) {
        this.failReasonDesp = failReasonDesp;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    @Override
    public String toString() {
        return GsonUtil.objectToJson(this);
    }
}
