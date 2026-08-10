package com.douyinpay.api.splitfund.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiQuerySplitFundResponse {
    /**
     * 字段含义：直连商户号。
     * 格式规则：字符串。
     * 业务规则：由抖音支付生成并下发。
     * 示例：6020240223833009
     */
    @SerializedName("mchid")
    private String merchantId;

    /**
     * 字段含义：抖音支付订单号。
     * 格式规则：字符串。
     * 业务规则：用于标识原支付订单。
     * 示例：21000125010103000993845301123
     */
    @SerializedName("transaction_id")
    private String tradeNo;

    /**
     * 字段含义：商户分账单号。
     * 格式规则：仅支持数字、大小写字母、_、-、*。
     * 业务规则：用于标识商户侧的分账单。
     * 示例：OUT_1666688488
     */
    @SerializedName("out_order_no")
    private String outTradeNo;

    /**
     * 字段含义：抖音支付分账单号。
     * 格式规则：字符串。
     * 业务规则：由抖音支付生成，用于标识分账单。
     * 示例：11777200250103110500000223502022
     */
    @SerializedName("order_id")
    private String orderId;

    /**
     * 字段含义：分账单状态。
     * 格式规则：枚举字符串。
     * 业务规则：开放文档示例包含 PROCESSING、FINISHED。
     * 示例：FINISHED
     */
    @SerializedName("state")
    private String state;

    /**
     * 字段含义：分账接收方列表。
     * 格式规则：数组。
     * 业务规则：包含分账接收方信息以及对应的分账结果。
     * 示例：
     */
    @SerializedName("receivers")
    private List<ReceiverSplitResultDto> receiverSplitResultDtos;

    /**
     * 字段含义：完结分账金额。
     * 格式规则：单位为分的整数。
     * 业务规则：表示完结分账时解冻给商户的金额。
     * 示例：0
     */
    @SerializedName("finish_amount")
    private Integer finishAmount;

    /**
     * 字段含义：完结分账描述。
     * 格式规则：字符串。
     * 业务规则：表示完结分账的说明信息。
     * 示例：不再继续分账
     */
    @SerializedName("finish_description")
    private String finishDescription;

    /**
     * 字段含义：分账完结时间。
     * 格式规则：遵循 RFC 3339 标准格式。
     * 业务规则：表示分账单完结的时间。
     * 示例：2015-05-20T13:29:35+08:00
     */
    @SerializedName("split_finish_time")
    private String splitFinishTime;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
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

    public Integer getFinishAmount() {
        return finishAmount;
    }

    public void setFinishAmount(Integer finishAmount) {
        this.finishAmount = finishAmount;
    }

    public String getFinishDescription() {
        return finishDescription;
    }

    public void setFinishDescription(String finishDescription) {
        this.finishDescription = finishDescription;
    }

    public String getSplitFinishTime() {
        return splitFinishTime;
    }

    public void setSplitFinishTime(String splitFinishTime) {
        this.splitFinishTime = splitFinishTime;
    }

    @Override
    public String toString() {
        return GsonUtil.objectToJson(this);
    }
}
