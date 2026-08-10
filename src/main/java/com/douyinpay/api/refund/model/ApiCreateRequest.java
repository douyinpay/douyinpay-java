package com.douyinpay.api.refund.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiCreateRequest {

    /**
     * 字段含义：应用ID。
     * 格式规则：字符串。
     * 业务规则：由抖音开放平台生成，需与当前商户号完成绑定。
     * 示例：awofz9bncda6w123
     */
    @SerializedName("appid")
    private String appid;
    /**
     * 字段含义：直连商户号。
     * 格式规则：字符串。
     * 业务规则：由抖音支付生成并下发。
     * 示例：6020230307605084
     */
    @SerializedName("mchid")
    private String mchid;
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
     * 字段含义：商户退款单号。
     * 格式规则：仅支持数字、大小写字母、_、-、|、*、@。
     * 业务规则：商户系统内部唯一；同一退款单号多次请求只退一笔。
     * 示例：REFUND_1666688488
     */
    @SerializedName("out_refund_no")
    private String outRefundNo;
    /**
     * 字段含义：退款原因。
     * 格式规则：字符串。
     * 业务规则：传入后会展示在下发给用户的退款消息中。
     * 示例：用户申请退款
     */
    @SerializedName("reason")
    private String reason;
    /**
     * 字段含义：退款结果回调地址。
     * 格式规则：外网可访问地址，且不能携带参数。
     * 业务规则：传入后优先于商户平台上配置的退款回调地址。
     * 示例：https://www.mock.douyinpay.com/refund/notify
     */
    @SerializedName("notify_url")
    private String notifyUrl;
    /**
     * 字段含义：退款商品明细。
     * 格式规则：数组。
     * 业务规则：指定商品退款时传入，其他场景无需传递。
     * 示例：
     */
    @SerializedName("goods_detail")
    private List<ApiGoodsDetail> goodsDetail;
    /**
     * 字段含义：金额信息。
     * 格式规则：对象。
     * 业务规则：包含退款金额、原订单金额和退款币种等字段。
     * 示例：{"refund":100,"total":100,"currency":"CNY"}
     */
    @SerializedName("amount")
    private ApiAmountReq amount;
    /**
     * 字段含义：退款资金来源。
     * 格式规则：枚举字符串。
     * 业务规则：不传时默认使用未结算资金退款；仅对老资金流商户适用。
     * 补充说明：若传递此参数则使用对应的资金账户退款。
     * 示例：AVAILABLE
     * @see com.douyinpay.enums.ReqFundsAccountEnum
     */
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
