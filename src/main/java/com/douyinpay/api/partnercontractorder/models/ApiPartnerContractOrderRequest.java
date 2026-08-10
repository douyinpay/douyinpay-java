
package com.douyinpay.api.partnercontractorder.models;

import com.google.gson.annotations.SerializedName;
import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiPartnerContractOrderRequest {
    /**
     * 字段含义：服务商应用ID。
     * 格式规则：字符串。
     * 业务规则：由服务商在抖音开放平台申请；应用属性需与 trade_type 场景匹配，APP 场景使用移动应用 AppID，JSAPI/H5 场景使用网站应用 AppID，并确保与 sp_mchid 存在绑定关系。
     * 示例：awofz9bncda6w200
     */
    @SerializedName("sp_appid")
    private String spAppid;

    /**
     * 字段含义：服务商户号。
     * 格式规则：字符串。
     * 业务规则：由抖音支付生成并下发，用于标识服务商主体。
     * 示例：6020230301343000
     */
    @SerializedName("sp_mchid")
    private String spMchid;

    /**
     * 字段含义：子商户应用ID。
     * 格式规则：字符串。
     * 业务规则：由子商户在抖音开放平台申请，全局唯一；应用属性需与 trade_type 场景匹配，APP 场景使用移动应用 AppID，JSAPI/H5 场景使用网站应用 AppID；若传 sub_openid，则 sub_appid 必填，且需与 sub_openid 对应。
     * 示例：awofz9bncda6x000
     */
    @SerializedName("sub_appid")
    private String subAppid;

    /**
     * 字段含义：子商户号。
     * 格式规则：字符串。
     * 业务规则：由抖音支付生成并下发，用于标识子商户主体。
     * 示例：6020230307605000
     */
    @SerializedName("sub_mchid")
    private String subMchid;

    /**
     * 字段含义：商品描述。
     * 格式规则：字符串。
     * 业务规则：用于描述本次交易商品或服务信息。
     * 示例：抖音支付测试
     */
    @SerializedName("description")
    private String description;

    /**
     * 字段含义：商户订单号。
     * 格式规则：仅支持数字、大小写字母、_、-、*。
     * 业务规则：服务商系统内部订单号，在同一服务商商户号下需保持唯一；同一订单号重复请求按同一笔订单处理。
     * 示例：OUT_1666688488
     */
    @SerializedName("out_trade_no")
    private String outTradeNo;

    /**
     * 字段含义：交易结束时间。
     * 格式规则：遵循 RFC 3339 标准格式。
     * 业务规则：需在下单时间 15 天内；若用户支付已超时，应使用新的商户订单号重新下单。
     * 示例：2018-06-08T10:34:56+08:00
     */
    @SerializedName("time_expire")
    private String timeExpire;

    /**
     * 字段含义：交易类型。
     * 格式规则：枚举字符串。
     * 业务规则：开放文档示例包含 APP、JSAPI、MWEB，不同取值决定后续调起支付方式。
     * 示例：APP
     * @see com.douyinpay.enums.TradeTypeEnum
     */
    @SerializedName("trade_type")
    private String tradeType;

    /**
     * 字段含义：附加数据。
     * 格式规则：字符串。
     * 业务规则：在查询接口和支付通知中原样返回，可作为商户自定义透传参数。
     * 示例：自定义数据
     */
    @SerializedName("attach")
    private String attach;

    /**
     * 字段含义：通知地址。
     * 格式规则：HTTPS 外网可访问地址，且不允许携带查询串。
     * 业务规则：用于接收抖音支付异步通知。
     * 示例：https://www.mock.douyinpay.com
     */
    @SerializedName("notify_url")
    private String notifyUrl;

    /**
     * 字段含义：优惠标记。
     * 格式规则：JSON 字符串。
     * 业务规则：需与抖音支付协商使用，可区分业务场景、产品标签或指定优惠信息。
     * 示例：{"biz_scene":"","product_tag":"","assign_discounts":""}
     */
    @SerializedName("goods_tag")
    private String goodsTag;

    /**
     * 字段含义：电子发票入口开放标识。
     * 格式规则：boolean。
     * 业务规则：预留字段，开放文档说明商户无需传入。
     * 示例：false
     */
    @SerializedName("support_fapiao")
    private Boolean supportFapiao;

    /**
     * 字段含义：金额信息。
     * 格式规则：对象。
     * 业务规则：包含订单或退款金额相关字段。
     * 示例：{"total":100,"currency":"CNY"}
     */
    @SerializedName("amount")
    private Amount amount;

    /**
     * 字段含义：支付者信息。
     * 格式规则：对象。
     * 业务规则：JSAPI 场景下用于传入用户标识，sp_openid 和 sub_openid 至少二选一。
     * 示例：{"sp_openid":"897ae8bd9f194107-9cb3-85f5672037de","sub_openid":"823ae8bd9f893402-9cb3-85f8794657ea"}
     */
    @SerializedName("payer")
    private Payer payer;

    /**
     * 字段含义：优惠信息。
     * 格式规则：对象。
     * 业务规则：包含订单原价、商品小票 ID 和单品列表等信息。
     * 示例：
     */
    @SerializedName("detail")
    private ApiDetail detail;

    /**
     * 字段含义：支付场景信息。
     * 格式规则：对象。
     * 业务规则：用于补充终端 IP、设备号、门店信息等场景数据。
     * 示例：
     */
    @SerializedName("scene_info")
    private ApiSceneInfo sceneInfo;
    
    /**
     * 字段含义：结算信息。
     * 格式规则：对象。
     * 业务规则：可指定订单是否支持分账。
     * 示例：{"profit_sharing":false}
     */
    @SerializedName("settle_info")
    private ApiSettleInfo settleInfo;

    /**
     * 字段含义：签约信息。
     * 格式规则：对象。
     * 业务规则：包含签约商户号、模板 ID、签约协议号和签约通知地址等信息。
     * 示例：
     */
    @SerializedName("contract_info")
    private ContractInfo contractInfo;

    public Amount getAmount() {
        return amount;
    }

    public ContractInfo getContractInfo() {
        return contractInfo;
    }
    public Payer getPayer() {
        return payer;
    }
    public ApiSceneInfo getSceneInfo() {
        return sceneInfo;
    }
    public ApiSettleInfo getSettleInfo() {
        return settleInfo;
    }
    public String getGoodsTag() {
        return goodsTag;
    }
    public String getAttach() {
        return attach;
    }   
    public String getNotifyUrl() {
        return notifyUrl;
    }
    public String getSpAppid() {
        return spAppid;
    }
    public String getSpMchid() {
        return spMchid;
    }
    public String getSubAppid() {
        return subAppid;
    }
    public String getSubMchid() {
        return subMchid;
    }
    public String getDescription() {
        return description;
    }
    public String getOutTradeNo() {
        return outTradeNo;
    }
    public String getTimeExpire() {
        return timeExpire;
    }
    public String getTradeType() {
        return tradeType;
    }
    public Boolean getSupportFapiao() {
        return supportFapiao;
    }
    public ApiDetail getDetail() {
        return detail;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }
    public void setContractInfo(ContractInfo contractInfo) {
        this.contractInfo = contractInfo;
    }
    public void setPayer(Payer payer) {
        this.payer = payer;
    }
    public void setSceneInfo(ApiSceneInfo sceneInfo) {
        this.sceneInfo = sceneInfo;
    }
    public void setSettleInfo(ApiSettleInfo settleInfo) {
        this.settleInfo = settleInfo;
    }
    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }
    public void setAttach(String attach) {
        this.attach = attach;
    }
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
    public void setSpAppid(String spAppid) {
        this.spAppid = spAppid;
    }
    public void setSpMchid(String spMchid) {
        this.spMchid = spMchid;
    }
    public void setSubAppid(String subAppid) {
        this.subAppid = subAppid;
    }
    public void setSubMchid(String subMchid) {
        this.subMchid = subMchid;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }
    public void setTimeExpire(String timeExpire) {
        this.timeExpire = timeExpire;
    }
    public void setSupportFapiao(Boolean supportFapiao) {
        this.supportFapiao = supportFapiao;
    }
    public void setDetail(ApiDetail detail) {
        this.detail = detail;
    }
    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }
 
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiPartnerContractOrderRequest {\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    contractInfo: ").append(toIndentedString(contractInfo)).append("\n");
        sb.append("    payer: ").append(toIndentedString(payer)).append("\n");
        sb.append("    sceneInfo: ").append(toIndentedString(sceneInfo)).append("\n");
        sb.append("    settleInfo: ").append(toIndentedString(settleInfo)).append("\n");
        sb.append("    goodsTag: ").append(toIndentedString(goodsTag)).append("\n");
        sb.append("    attach: ").append(toIndentedString(attach)).append("\n");
        sb.append("    notifyUrl: ").append(toIndentedString(notifyUrl)).append("\n");
        sb.append("    spAppid: ").append(toIndentedString(spAppid)).append("\n");
        sb.append("    spMchid: ").append(toIndentedString(spMchid)).append("\n");
        sb.append("    subAppid: ").append(toIndentedString(subAppid)).append("\n");
        sb.append("    subMchid: ").append(toIndentedString(subMchid)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    outTradeNo: ").append(toIndentedString(outTradeNo)).append("\n");
        sb.append("    timeExpire: ").append(toIndentedString(timeExpire)).append("\n");
        sb.append("    tradeType: ").append(toIndentedString(tradeType)).append("\n");
        sb.append("    supportFapiao: ").append(toIndentedString(supportFapiao)).append("\n");
        sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
