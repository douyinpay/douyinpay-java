package com.douyinpay.api.transfer.models;

import com.douyinpay.api.refund.model.*;
import com.douyinpay.api.tranferreturn.models.Amount;
import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TransferPayeeNotification {
    /** 应用ID */
    @SerializedName("appid")
    private String appId;
    /** 商户号  */
    @SerializedName("mchid")
    private String merchantId;
    /** 抖音系统内部的转账单据ID */
    @SerializedName("order_id")
    private String orderId;
    /** 交易状态 */
    @SerializedName("status")
    private String status;
    /** 交易描述 */
    @SerializedName("status_desc")
    private String statusDesc;
    /** 创建时间  */
    @SerializedName("create_time")
    private String createTime;
    /** 成功时间  */
    @SerializedName("success_time")
    private String successTime;
    /** 付款方信息 */
    @SerializedName("payer")
    private PayerInfo payer;
    /** 金额信息 */
    @SerializedName("amount")
    private com.douyinpay.api.tranferreturn.models.Amount amount;
    /** 订单名称 */
    @SerializedName("order_title")
    private String orderTitle;
    /** 备注信息*/
    @SerializedName("remark")
    private String remark;

    @SerializedName("ext_info")
    private String extInfo;

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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(String successTime) {
        this.successTime = successTime;
    }

    public PayerInfo getPayer() {
        return payer;
    }

    public void setPayer(PayerInfo payer) {
        this.payer = payer;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public String getOrderTitle() {
        return orderTitle;
    }

    public void setOrderTitle(String orderTitle) {
        this.orderTitle = orderTitle;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }

    @Override
    public String toString() {
        return GsonUtil.getGson().toJson(this);
    }
}
