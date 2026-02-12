package com.douyinpay.api.refund.model;

import com.douyinpay.enums.ReqFundsAccountEnum;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiCreateRequest {

    @SerializedName("appid")
    private String appid;
    /** 直连商户号 说明：直连商户号 */
    @SerializedName("mchid")
    private String mchid;
    /** 抖音支付订单号 说明：原支付交易对应的订单号 */
    @SerializedName("transaction_id")
    private String transactionId;
    /** 商户订单号 说明：原支付交易对应的商户订单号 */
    @SerializedName("out_trade_no")
    private String outTradeNo;
    /** 商户退款单号 说明：商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。 */
    @SerializedName("out_refund_no")
    private String outRefundNo;
    /** 退款原因 说明：若商户传入，会在下发给用户的退款消息中体现退款原因 */
    @SerializedName("reason")
    private String reason;
    /**
     * 退款结果回调url 说明：异步接收抖音支付退款结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
     * 如果参数中传了notify_url，则商户平台上配置的回调地址将不会生效，优先回调当前传的这个地址。
     */
    @SerializedName("notify_url")
    private String notifyUrl;
    /** 退款商品 说明：指定商品退款需要传此参数，其他场景无需传递 */
    @SerializedName("goods_detail")
    private List<ApiGoodsDetail> goodsDetail;
    /** 金额信息 说明：订单金额信息 */
    @SerializedName("amount")
    private ApiAmountReq amount;
    /**
     * 退款资金来源 说明：若传递此参数则使用对应的资金账户退款，否则默认使用未结算资金退款（仅对老资金流商户适用） 枚举值： - AVAILABLE：可用余额账户
     * @see ReqFundsAccountEnum
     * */
    @SerializedName("funds_account")
    private String fundsAccount;
    /** 服务商户号 */
    @SerializedName("sp_mchid")
    private String spMchid;
    /** 子商户号 */
    @SerializedName("sub_mchid")
    private String subMchid;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
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

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public List<ApiGoodsDetail> getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(List<ApiGoodsDetail> goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public ApiAmountReq getAmount() {
        return amount;
    }

    public void setAmount(ApiAmountReq amount) {
        this.amount = amount;
    }

    public String getFundsAccount() {
        return fundsAccount;
    }

    public void setFundsAccount(String fundsAccount) {
        this.fundsAccount = fundsAccount;
    }

    public String getSpMchid() {
        return spMchid;
    }
    public void setSpMchid(String spMchid) {
        this.spMchid = spMchid;
    }

    public String getSubMchid() {
        return subMchid;
    }

    public void setSubMchid(String subMchid) {
        this.subMchid = subMchid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiCreateRequest {\n");
        sb.append("    appid: ").append(toIndentedString(appid)).append("\n");
        sb.append("    mchid: ").append(toIndentedString(mchid)).append("\n");
        sb.append("    transactionId: ").append(toIndentedString(transactionId)).append("\n");
        sb.append("    outTradeNo: ").append(toIndentedString(outTradeNo)).append("\n");
        sb.append("    outRefundNo: ").append(toIndentedString(outRefundNo)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    notifyUrl: ").append(toIndentedString(notifyUrl)).append("\n");
        sb.append("    goodsDetail: ").append(toIndentedString(goodsDetail)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    fundsAccount: ").append(toIndentedString(fundsAccount)).append("\n");
        sb.append("    spMchid: ").append(toIndentedString(spMchid)).append("\n");
        sb.append("    subMchid: ").append(toIndentedString(subMchid)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}

