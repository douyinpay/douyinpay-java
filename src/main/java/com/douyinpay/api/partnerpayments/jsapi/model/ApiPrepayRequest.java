package com.douyinpay.api.partnerpayments.jsapi.model;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import static com.douyinpay.util.StringUtil.toIndentedString;


public class ApiPrepayRequest {
    /** 服务商户号 */
    @SerializedName("sp_mchid")
    private String spMchid;
    /** 服务商应用ID */
    @SerializedName("sp_appid")
    private String spAppid;
    /** 子商户号 */
    @SerializedName("sub_mchid")
    private String subMchid;
    /** 子商户应用ID */
    @SerializedName("sub_appid")
    private String subAppid;
    /** 商品描述 */
    @SerializedName("description")
    private String description;
    /** 商户订单号 */
    @SerializedName("out_trade_no")
    private String outTradeNo;
    /** 交易结束时间 */
    @SerializedName("time_expire")
    private String timeExpire;
    /** 附加数据 */
    @SerializedName("attach")
    private String attach;
    /** 通知地址 */
    @SerializedName("notify_url")
    private String notifyUrl;
    /** 商品标签 */
    @SerializedName("goods_tag")
    private String goodsTag;
    // 传入true时，支付成功消息和支付详情页将出现开票入口。需要在抖音支付商户平台或抖音公众平台开通电子发票功能，传此字段才可生效。
    @SerializedName("support_fapiao")
    private Boolean supportFapiao;
    /** 订单金额 */
    @SerializedName("amount")
    private Amount amount;
    /** 订单详情 */
    @SerializedName("detail")
    private ApiDetail detail;
    /** 场景信息 */
    @SerializedName("scene_info")
    private ApiSceneInfo sceneInfo;
    /** 结算信息 */
    @SerializedName("settle_info")
    private ApiSettleInfo settleInfo;
    /** 支付者信息 */
    @SerializedName("payer")
    private ApiPayerInfo payer;

    public String getSpAppid() {
        return spAppid;
    }
     /**
     * 设置服务商应用ID
     * @param spAppid 服务商应用ID
     */
    public void setSpAppid(String spAppid) {
        this.spAppid = spAppid;
    }
     /**
     * 服务商商户号
     * @return spMchid 服务商商户号
     */
    public String getSpMchid() {
        return spMchid;
    }
     /**
     * 设置服务商商户号
     * @param spMchid 服务商商户号
     */
    public void setSpMchid(String spMchid) {
        this.spMchid = spMchid;
    }
     /**
     * 子商户号
     * @return subMchid 子商户号
     */
    public String getSubMchid() {
        return subMchid;
    }
     /**
     * 设置子商户号
     * @param subMchid 子商户号
     */
    public void setSubMchid(String subMchid) {
        this.subMchid = subMchid;
    }
     /**
     * 子商户应用ID
     * @return subAppid 子商户应用ID
     */
    public String getSubAppid() {
        return subAppid;
    }
     /**
     * 设置子商户应用ID
     * @param subAppid 子商户应用ID
     */
    public void setSubAppid(String subAppid) {
        this.subAppid = subAppid;
    }

    public Amount getAmount() {
        return amount;
    }
        /**
     * 设置订单金额
     * @param amount 订单金额
     */
    public void setAmount(Amount amount) {
        this.amount = amount;
    }
        /**
     * 商品描述
     * @return description 商品描述
     */
    public String getDescription() {
        return description;
    }
        /**
     * 设置商品描述
     * @param description 商品描述
     */
    public void setDescription(String description) {
        this.description = description;
    }
        /**
     * 商户订单号
     * @return outTradeNo 商户订单号
     */
    public String getOutTradeNo() {
        return outTradeNo;
    }
        /**
     * 设置商户订单号
     * @param outTradeNo 商户订单号
     */
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }
        /**
     * 订单失效时间，格式为rfc3339格式
     * @return timeExpire 订单失效时间，格式为rfc3339格式
     */
    public String getTimeExpire() {
        return timeExpire;
    }
        /**
     * 设置订单失效时间，格式为rfc3339格式
     * @param timeExpire 订单失效时间，格式为rfc3339格式
     */
    public void setTimeExpire(String timeExpire) {
        this.timeExpire = timeExpire;
    }
        /**
     * 附加数据
     * @return attach 附加数据
     */
    public String getAttach() {
        return attach;
    }
        /**
     * 设置附加数据
     * @param attach 附加数据
     */
    public void setAttach(String attach) {
        this.attach = attach;
    }
        /**
     * 通知地址
     * @return notifyUrl 通知地址
     */
    public String getNotifyUrl() {
        return notifyUrl;
    }
        /**
     * 设置通知地址
     * @param notifyUrl 通知地址
     */
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
        /**
     * 商品标签
     * @return goodsTag 商品标签
     */
    public String getGoodsTag() {
        return goodsTag;
    }
        /**
     * 设置商品标签
     * @param goodsTag 商品标签
     */
    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }
        /**
     * 是否支持电子发票
     * @return supportFapiao 是否支持电子发票
     */
    public Boolean getSupportFapiao() {
        return supportFapiao;
    }
        /**
     * 设置是否支持电子发票
     * @param supportFapiao 是否支持电子发票
     */
    public void setSupportFapiao(Boolean supportFapiao) {
        this.supportFapiao = supportFapiao;
    }

    public ApiDetail getDetail() {
        return detail;
    }
        /**
     * 设置订单详情
     * @param detail 订单详情
     */
    public void setDetail(ApiDetail detail) {
        this.detail = detail;
    }
        /**
     * 场景信息
     * @return sceneInfo 场景信息
     */
    public ApiSceneInfo getSceneInfo() {
        return sceneInfo;
    }
        /**
     * 设置场景信息
     * @param sceneInfo 场景信息
     */
    public void setSceneInfo(ApiSceneInfo sceneInfo) {
        this.sceneInfo = sceneInfo;
    }
        /**
     * 结算信息
     * @return settleInfo 结算信息
     */
    public ApiSettleInfo getSettleInfo() {
        return settleInfo;
    }
        /**
     * 设置结算信息
     * @param settleInfo 结算信息
     */
    public void setSettleInfo(ApiSettleInfo settleInfo) {
        this.settleInfo = settleInfo;
    }
        /**
     * 付款人信息
     * @return payerInfo 付款人信息
     */
    public ApiPayerInfo getPayer() {
        return payer;
    }
        /**S
     * 设置付款人信息
     * @param payerInfo 付款人信息E
     *
     */
    public void setPayer(ApiPayerInfo payer) {
        this.payer = payer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ApiPrepayRequest{");
        sb.append("spMchid='").append(toIndentedString(spMchid)).append("', ");
        sb.append("spAppid='").append(toIndentedString(spAppid)).append("', ");
        sb.append("subMchid='").append(toIndentedString(subMchid)).append("', ");
        sb.append("subAppid='").append(toIndentedString(subAppid)).append("', ");
        sb.append("description='").append(toIndentedString(description)).append("', ");
        sb.append("outTradeNo='").append(toIndentedString(outTradeNo)).append("', ");
        sb.append("timeExpire='").append(toIndentedString(timeExpire)).append("', ");
        sb.append("attach='").append(toIndentedString(attach)).append("', ");
        sb.append("notifyUrl='").append(toIndentedString(notifyUrl)).append("', ");
        sb.append("goodsTag='").append(toIndentedString(goodsTag)).append("', ");
        sb.append("supportFapiao=").append(toIndentedString(supportFapiao)).append(", ");
        sb.append("amount=").append(toIndentedString(amount)).append(", ");
        sb.append("detail=").append(toIndentedString(detail)).append(", ");
        sb.append("sceneInfo=").append(toIndentedString(sceneInfo)).append(", ");
        sb.append("settleInfo=").append(toIndentedString(settleInfo)).append(", ");
        sb.append("payer=").append(toIndentedString(payer));
        sb.append('}');
        return sb.toString();
    }
}
 
