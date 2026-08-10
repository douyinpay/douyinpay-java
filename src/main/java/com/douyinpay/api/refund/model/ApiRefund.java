
package com.douyinpay.api.refund.model;

import static com.douyinpay.util.StringUtil.toIndentedString;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Refund
 */
public class ApiRefund {
    /**
     * 字段含义：抖音支付退款号。
     * 格式规则：字符串。
     * 业务规则：由抖音支付生成，用于标识退款单。
     * 示例：503027044522231010001
     */
    @SerializedName("refund_id")
    private String refundId;
    /**
     * 字段含义：商户退款单号。
     * 格式规则：仅支持数字、大小写字母、_、-、|、*、@。
     * 业务规则：商户系统内部唯一；同一退款单号多次请求只退一笔。
     * 示例：REFUND_1666688488
     */
    @SerializedName("out_refund_no")
    private String outRefundNo;
    /**
     * 字段含义：抖音支付订单号。
     * 格式规则：字符串。
     * 业务规则：表示原支付交易对应的抖音支付订单号。
     * 示例：21000125010103000993845301123
     */
    @SerializedName("transaction_id")
    private String transactionId;
    /**
     * 字段含义：商户订单号。
     * 格式规则：仅支持数字、大小写字母、_、-、|、*、@。
     * 业务规则：表示原支付交易对应的商户订单号。
     * 示例：OUT_1666688488
     */
    @SerializedName("out_trade_no")
    private String outTradeNo;
    /**
     * 字段含义：退款入账账户。
     * 格式规则：字符串。
     * 业务规则：表示退款实际入账的目标账户。
     * 示例：
     */
    @SerializedName("user_received_account")
    private String userReceivedAccount;
    /**
     * 字段含义：退款成功时间。
     * 格式规则：遵循 RFC 3339 标准格式。
     * 业务规则：退款状态为成功时返回。
     * 补充说明：格式为 YYYY-MM-DDTHH:mm:ss+TIMEZONE，例如北京时间 2015-05-20T13:29:35+08:00。
     * 示例：2015-05-20T13:29:35+08:00
     */
    @SerializedName("success_time")
    private String successTime;
    /**
     * 字段含义：退款创建时间。
     * 格式规则：遵循 RFC 3339 标准格式。
     * 业务规则：表示退款受理时间。
     * 补充说明：格式为 YYYY-MM-DDTHH:mm:ss+TIMEZONE，例如北京时间 2015-05-20T13:29:35+08:00。
     * 示例：2015-05-20T13:29:35+08:00
     */
    @SerializedName("create_time")
    private String createTime;
    /**
     * 字段含义：优惠退款信息。
     * 格式规则：数组。
     * 业务规则：返回参与退款的优惠信息。
     * 示例：
     */
    @SerializedName("promotion_detail")
    private List<ApiRefundPromotion> apiRefundPromotionDetail;
    /**
     * 字段含义：金额信息。
     * 格式规则：对象。
     * 业务规则：包含退款金额、原订单金额和退款币种等字段。
     * 示例：{"refund":100,"total":100,"currency":"CNY"}
     */
    @SerializedName("amount")
    private Amount amount;
    /**
     * 字段含义：退款渠道。
     * 格式规则：枚举字符串。
     * 业务规则：开放文档示例包含 ORIGINAL、BALANCE、OTHER_BALANCE、OTHER_BANKCARD。
     * 补充说明：ORIGINAL 表示原路退款，BALANCE 表示退回到余额，OTHER_BALANCE
     * 表示原账户异常退到其他余额账户，OTHER_BANKCARD 表示原银行卡异常退到其他银行卡。
     * 示例：ORIGINAL
     *
     * @see com.douyinpay.enums.RefundChannelEnum
     */
    @SerializedName("channel")
    private String channel;
    /**
     * 字段含义：退款资金来源。
     * 格式规则：枚举字符串。
     * 业务规则：表示退款所使用资金对应的资金账户类型。
     * 补充说明：开放文档示例包含 UNSETTLED、AVAILABLE、UNAVAILABLE、OPERATION、BASIC。
     * 示例：AVAILABLE
     *
     * @see com.douyinpay.enums.FundsAccountEnum
     */
    @SerializedName("funds_account")
    private String fundsAccount;
    /**
     * 字段含义：退款状态。
     * 格式规则：枚举字符串。
     * 业务规则：开放文档示例包含 SUCCESS、CLOSED、PROCESSING、ABNORMAL。
     * 示例：SUCCESS
     *
     * @see com.douyinpay.enums.RefundStatusEnum
     */
    @SerializedName("status")
    private String refundStatus;

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getUserReceivedAccount() {
        return userReceivedAccount;
    }

    public void setUserReceivedAccount(String userReceivedAccount) {
        this.userReceivedAccount = userReceivedAccount;
    }

    public String getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(String successTime) {
        this.successTime = successTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public List<ApiRefundPromotion> getPromotionDetail() {
        return apiRefundPromotionDetail;
    }

    public void setPromotionDetail(List<ApiRefundPromotion> apiRefundPromotionDetail) {
        this.apiRefundPromotionDetail = apiRefundPromotionDetail;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public List<ApiRefundPromotion> getApiPromotionDetail() {
        return apiRefundPromotionDetail;
    }

    public void setApiPromotionDetail(List<ApiRefundPromotion> apiRefundPromotionDetail) {
        this.apiRefundPromotionDetail = apiRefundPromotionDetail;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getFundsAccount() {
        return fundsAccount;
    }

    public void setFundsAccount(String fundsAccount) {
        this.fundsAccount = fundsAccount;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiRefund {\n");
        sb.append("    refundId: ").append(toIndentedString(refundId)).append("\n");
        sb.append("    outRefundNo: ").append(toIndentedString(outRefundNo)).append("\n");
        sb.append("    transactionId: ").append(toIndentedString(transactionId)).append("\n");
        sb.append("    outTradeNo: ").append(toIndentedString(outTradeNo)).append("\n");
        sb.append("    userReceivedAccount: ")
                .append(toIndentedString(userReceivedAccount))
                .append("\n");
        sb.append("    successTime: ").append(toIndentedString(successTime)).append("\n");
        sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
        sb.append("    promotionDetail: ").append(toIndentedString(apiRefundPromotionDetail)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
        sb.append("    fundsAccount: ").append(toIndentedString(fundsAccount)).append("\n");
        sb.append("    status: ").append(toIndentedString(refundStatus)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
