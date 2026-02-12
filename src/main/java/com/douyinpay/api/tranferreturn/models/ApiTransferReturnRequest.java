package com.douyinpay.api.tranferreturn.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiTransferReturnRequest {
    @SerializedName("appid") //商户应用号
    private String appId;
    @SerializedName("mchid") //商户号
    private String merchantId;
    @SerializedName("order_id") //抖音正向转账单号
    private String orderId;
    @SerializedName("out_request_no") //请求流水号
    private String outRequestNo;
    @SerializedName("refund_amount")
    private Amount refundAmount; // 退款金额
    @SerializedName("remark")
    private String remark; // 备注
    @SerializedName("ext_params")
    private TansferReturnExtParam extParams; //扩展信息
    @SerializedName("attach")
    private String attach; // 附加信息（商户回调时透传）
    @SerializedName("notify_url")
    private String notifyUrl; // 商家回调地址

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public TansferReturnExtParam getExtParams() {
        return extParams;
    }

    public void setExtParams(TansferReturnExtParam extParams) {
        this.extParams = extParams;
    }

    @Override
    public String toString() {
        return GsonUtil.objectToJson(this);
    }
}
