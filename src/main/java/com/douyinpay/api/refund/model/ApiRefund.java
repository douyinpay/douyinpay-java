
package com.douyinpay.api.refund.model;

import com.douyinpay.enums.FundsAccountEnum;
import com.douyinpay.enums.RefundChannelEnum;
import com.douyinpay.enums.RefundStatusEnum;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import static com.douyinpay.util.StringUtil.toIndentedString;

/**
 * Refund
 */
public class ApiRefund {
    /**
     * 抖音支付退款号 说明：抖音支付退款号
     */
    @SerializedName("refund_id")
    private String refundId;
    /**
     * 商户退款单号 说明：商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。
     */
    @SerializedName("out_refund_no")
    private String outRefundNo;
    /**
     * 抖音支付支付订单号 说明：抖音支付交易订单号
     */
    @SerializedName("transaction_id")
    private String transactionId;
    /**
     * 商户订单号 说明：原支付交易对应的商户订单号
     */
    @SerializedName("out_trade_no")
    private String outTradeNo;
    @SerializedName("user_received_account")
    private String userReceivedAccount;
    /**
     * 退款成功时间
     * 说明：退款成功时间，退款状态status为SUCCESS（退款成功）时，返回该字段。遵循rfc3339标准格式，格式为YYYY-MM-DDTHH:mm:ss+TIMEZONE，YYYY-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss表示时分秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC
     * 8小时，即北京时间）。例如：2015-05-20T13:29:35+08:00表示，北京时间2015年5月20日13点29分35秒。
     */
    @SerializedName("success_time")
    private String successTime;
    /**
     * 退款创建时间
     * 说明：退款受理时间，遵循rfc3339标准格式，格式为YYYY-MM-DDTHH:mm:ss+TIMEZONE，YYYY-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss表示时分秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC
     * 8小时，即北京时间）。例如：2015-05-20T13:29:35+08:00表示，北京时间2015年5月20日13点29分35秒。
     */
    @SerializedName("create_time")
    private String createTime;
    /**
     * 优惠退款信息 说明：优惠退款信息
     */
    @SerializedName("promotion_detail")
    private List<ApiRefundPromotion> apiRefundPromotionDetail;
    /**
     * 金额信息 说明：金额详细信息
     */
    @SerializedName("amount")
    private Amount amount;
    /**
     * 退款渠道 说明：枚举值： - ORIGINAL—原路退款 - BALANCE—退回到余额 - OTHER_BALANCE—原账户异常退到其他余额账户 -
     * OTHER_BANKCARD—原银行卡异常退到其他银行卡
     * @see RefundChannelEnum
     */
    @SerializedName("channel")
    private String channel;
    /**
     * 资金账户 说明：退款所使用资金对应的资金账户类型 枚举值： - UNSETTLED : 未结算资金 - AVAILABLE : 可用余额 - UNAVAILABLE : 不可用余额 -
     * OPERATION : 运营户 - BASIC : 基本账户（含可用余额和不可用余额）
     * @see FundsAccountEnum
     */
    @SerializedName("funds_account")
    private String fundsAccount;
    /**
     * SUCCESS—退款成功 - CLOSED—退款关闭 - PROCESSING—退款处理中 - ABNORMAL—退款异常
     * @see RefundStatusEnum
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
