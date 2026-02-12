package com.douyinpay.api.tranferreturn.models;

import com.douyinpay.api.refund.model.*;
import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TransferReturnNotification {
    /** 应用ID */
    @SerializedName("appid")
    private String appId;
    /** 商户号  */
    @SerializedName("mchid")
    private String merchantId;
    /** 商户转账退回订单号 */
    @SerializedName("out_request_no")
    private String outRequestNo;
    /** 正向转账在抖音系统内部的单据ID */
    @SerializedName("order_id")
    private String orderId;
    /** 转账退回在抖音系统内部的单据ID */
    @SerializedName("refund_order_id")
    private String refundOrderId;
    /** 转账退回状态 */
    @SerializedName("status")
    private String status;
    /*** 退款完成时间*/
    @SerializedName("refund_time")
    private String refundTime;
    /** 金额信息 说明：金额详细信息 */
    @SerializedName("refund_amount")
    private com.douyinpay.api.tranferreturn.models.Amount refundAmount;
    /** 备注信息*/
    @SerializedName("remark")
    private String remark;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getOutRequestNo() {
        return outRequestNo;
    }

    public void setOutRequestNo(String outRequestNo) {
        this.outRequestNo = outRequestNo;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(String refundTime) {
        this.refundTime = refundTime;
    }

    public Amount getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Amount refundAmount) {
        this.refundAmount = refundAmount;
    }

    @Override
    public String toString() {
        return GsonUtil.getGson().toJson(this);
    }

}