package com.douyinpay.api.payments.common;

import java.util.List;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

/**
 * ApiTransaction
 */
public class ApiTransaction {
    /**
     * 字段含义：金额信息。
     * 格式规则：对象。
     * 业务规则：包含订单或退款金额相关字段。
     * 示例：{"total":100,"currency":"CNY"}
     */
    @SerializedName("amount")
    private ApiTransactionAmount amount;
    /**
     * 字段含义：应用ID。
     * 格式规则：字符串。
     * 业务规则：由抖音开放平台生成，需与当前商户号完成绑定。
     * 示例：awofz9bncda6w123
     */
    @SerializedName("appid")
    private String appid;
    /**
     * 字段含义：附加数据。
     * 格式规则：字符串。
     * 业务规则：在查询接口和支付通知中原样返回，可作为商户自定义透传参数。
     * 示例：自定义数据
     */
    @SerializedName("attach")
    private String attach;
    /**
     * 字段含义：委托代扣协议号。
     * 格式规则：字符串。
     * 业务规则：用于标识本次交易关联的代扣签约关系；仅在相关扣款或签约支付场景返回。
     * 示例：1692684772559785378
     */
    @SerializedName("contract_id")
    private String contractId;
    /**
     * 字段含义：付款银行。
     * 格式规则：字符串。
     * 业务规则：默认不返回，如需具体信息需联系抖音支付运营。
     * 示例：CMC
     */
    @SerializedName("bank_type")
    private String bankType;
    /**
     * 字段含义：直连商户号。
     * 格式规则：字符串。
     * 业务规则：由抖音支付生成并下发，用于标识当前直连商户。
     * 示例：6020230307605084
     */
    @SerializedName("mchid")
    private String mchid;
    /**
     * 字段含义：错误码。
     * 格式规则：字符串。
     * 业务规则：仅在交易失败或状态异常时返回，用于标识具体错误原因。
     * 示例：PARAM_ERROR
     */
    @SerializedName("err_code")
    private String errCode;
    /**
     * 字段含义：错误码描述。
     * 格式规则：字符串。
     * 业务规则：对 err_code 的补充说明，便于定位失败原因。
     * 示例：参数错误
     */
    @SerializedName("err_code_des")
    private String errCodeDes;
    /**
     * 字段含义：商户订单号。
     * 格式规则：仅支持数字、大小写字母、_、-、*。
     * 业务规则：同一商户号下需保持唯一；同一订单号重复请求按同一笔订单处理。
     * 示例：OUT_1666688488
     */
    @SerializedName("out_trade_no")
    private String outTradeNo;
    /**
     * 字段含义：支付者信息。
     * 格式规则：对象。
     * 业务规则：订单支付成功后返回；JSAPI 下单时用于传入用户 openid。
     * 示例：{"openid":"b8e6c6fe-fc06-573b-9987-deda78c15000"}
     */
    @SerializedName("payer")
    private ApiTransactionPayer payer;
    /**
     * 字段含义：优惠明细。
     * 格式规则：数组。
     * 业务规则：返回参与本次交易的优惠券或立减明细。
     * 示例：
     */
    @SerializedName("promotion_detail")
    private List<ApiPromotionDetail> promotionDetail;
    /**
     * 字段含义：成功时间。
     * 格式规则：遵循 RFC 3339 标准格式。
     * 业务规则：支付或退款成功后返回。
     * 示例：2025-01-01T16:18:12+08:00
     */
    @SerializedName("success_time")
    private String successTime;

    /**
     * 字段含义：交易状态。
     * 格式规则：枚举字符串。
     * 业务规则：开放文档示例包含 SUCCESS、REFUND、NOTPAY、CLOSED 等取值。
     * 示例：SUCCESS
     *
     * @see com.douyinpay.enums.TradeStatusEnum
     */
    @SerializedName("trade_state")
    private String tradeState;
    /**
     * 字段含义：交易状态描述。
     * 格式规则：字符串。
     * 业务规则：用于说明 trade_state 对应的人类可读状态。
     * 示例：支付成功
     */
    @SerializedName("trade_state_desc")
    private String tradeStateDesc;

    /**
     * 字段含义：交易类型。
     * 格式规则：枚举字符串。
     * 业务规则：开放文档示例包含 APP、MWEB、JSAPI、NATIVE 等取值。
     * 示例：APP
     *
     * @see com.douyinpay.enums.TradeTypeEnum
     */
    @SerializedName("trade_type")
    private String tradeType;
    /**
     * 字段含义：抖音支付订单号。
     * 格式规则：字符串。
     * 业务规则：由抖音支付生成，用于标识支付订单。
     * 示例：21000125010103000993845301123
     */
    @SerializedName("transaction_id")
    private String transactionId;

    /**
     * 字段含义：支付场景信息。
     * 格式规则：对象。
     * 业务规则：用于补充终端 IP、设备号、门店信息等场景数据。
     * 示例：
     */
    @SerializedName("scene_info")
    private ApiTransactionSceneInfo sceneInfo;

    public ApiTransactionAmount getAmount() {
        return amount;
    }

    public void setAmount(ApiTransactionAmount amount) {
        this.amount = amount;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrCodeDes() {
        return errCodeDes;
    }

    public void setErrCodeDes(String errCodeDes) {
        this.errCodeDes = errCodeDes;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public ApiTransactionPayer getPayer() {
        return payer;
    }

    public void setPayer(ApiTransactionPayer payer) {
        this.payer = payer;
    }

    public List<ApiPromotionDetail> getPromotionDetail() {
        return promotionDetail;
    }

    public void setPromotionDetail(List<ApiPromotionDetail> promotionDetail) {
        this.promotionDetail = promotionDetail;
    }

    public String getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(String successTime) {
        this.successTime = successTime;
    }

    public String getTradeStateDesc() {
        return tradeStateDesc;
    }

    public void setTradeStateDesc(String tradeStateDesc) {
        this.tradeStateDesc = tradeStateDesc;
    }

    public String getTradeState() {
        return tradeState;
    }

    public void setTradeState(String tradeState) {
        this.tradeState = tradeState;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public ApiTransactionSceneInfo getSceneInfo() {
        return sceneInfo;
    }

    public void setSceneInfo(ApiTransactionSceneInfo sceneInfo) {
        this.sceneInfo = sceneInfo;
    }

    @Override
    public String toString() {
        return GsonUtil.getGson().toJson(this);
    }
}
