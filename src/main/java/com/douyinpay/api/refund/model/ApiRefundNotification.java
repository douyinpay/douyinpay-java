package com.douyinpay.api.refund.model;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ApiRefundNotification {

    /** 抖音支付退款号*/
    @SerializedName("refund_id")
    private String refundId;
    /** 商户退款单号 */
    @SerializedName("out_refund_no")
    private String outRefundNo;
    /** 抖音支付订单号*/
    @SerializedName("transaction_id")
    private String transactionId;
    /** 商户订单号 说明：原支付交易对应的商户订单号 */
    @SerializedName("out_trade_no")
    private String outTradeNo;
    /**
     * 退款入账账户
     */
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
    /** 优惠退款信息 说明：优惠退款信息 */
    @SerializedName("promotion_detail")
    private List<ApiRefundPromotion> promotionDetail = new ArrayList<ApiRefundPromotion>();
    /** 金额信息 说明：金额详细信息 */
    @SerializedName("amount")
    private Amount amount;
    /**
     * 退款渠道 说明：枚举值： - ORIGINAL—原路退款 - BALANCE—退回到余额 - OTHER_BALANCE—原账户异常退到其他余额账户 -
     * OTHER_BANKCARD—原银行卡异常退到其他银行卡
     * @see com.douyinpay.enums.RefundChannelEnum
     */
    @SerializedName("channel")
    private String channel;
    /**
     * 资金账户 说明：退款所使用资金对应的资金账户类型 枚举值： - UNSETTLED : 未结算资金 - AVAILABLE : 可用余额 - UNAVAILABLE : 不可用余额 -
     * OPERATION : 运营户 - BASIC : 基本账户（含可用余额和不可用余额）
     * @see com.douyinpay.enums.FundsAccountEnum
     */
    @SerializedName("funds_account")
    private String fundsAccount;
    /**
     * 退款状态 说明：枚举值： - SUCCESS—退款成功 - CLOSED—退款关闭 - PROCESSING—退款处理中 - ABNORMAL—退款异常
     * @see com.douyinpay.enums.RefundStatusEnum
     */
    @SerializedName("refund_status")
    private String refundRefundStatus;

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
        return promotionDetail;
    }

    public void setPromotionDetail(List<ApiRefundPromotion> promotionDetail) {
        this.promotionDetail = promotionDetail;
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

    public String getRefundRefundStatus() {
        return refundRefundStatus;
    }

    public void setRefundRefundStatus(String refundRefundStatus) {
        this.refundRefundStatus = refundRefundStatus;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return GsonUtil.getGson().toJson(this);
    }

}