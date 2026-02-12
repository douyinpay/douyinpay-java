package com.douyinpay.api.tranferreturn.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiTransferReturnQueryByIdRequest {
    @SerializedName("mchid")
    private String merchantId; // 直联商户号，必填且非空

    @SerializedName("refund_order_id")
    private String refundOrderId; // 抖音转账退回唯一订单号

    public String getMerchantId() {
        return merchantId;
    }
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }
    public String getRefundOrderId() {
        return refundOrderId;
    }
    public void setRefundOrderId(String refundOrderId) {
        this.refundOrderId = refundOrderId;
    }
    @Override
    public String toString() {
        return GsonUtil.objectToJson(this);
    }
}
