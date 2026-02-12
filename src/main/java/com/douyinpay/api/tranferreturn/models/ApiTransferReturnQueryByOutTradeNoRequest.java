package com.douyinpay.api.tranferreturn.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiTransferReturnQueryByOutTradeNoRequest {
    @SerializedName("mchid")
    private String merchantId; // 直联商户号，必填且非空

    @SerializedName("out_request_no")
    private String outRequestNo; // 商家转账退回唯一订单号

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

    @Override
    public String toString() {
        return GsonUtil.objectToJson(this);
    }
}
