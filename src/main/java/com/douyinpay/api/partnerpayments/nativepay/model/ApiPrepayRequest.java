
package com.douyinpay.api.partnerpayments.nativepay.model;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;


public class ApiPrepayRequest {
    /**
     * 字段含义：服务商户号。
     * 格式规则：字符串。
     * 业务规则：由抖音支付生成并下发，用于标识服务商主体。
     * 示例：6020230301343000
     */
    @SerializedName("sp_mchid")
    private String spMchid;
    /**
     * 字段含义：服务商应用ID。
     * 格式规则：字符串。
     * 业务规则：由服务商在抖音开放平台申请，全局唯一；此处应填写网站应用类型的 AppID，并确保与 sp_mchid 存在绑定关系。
     * 示例：awofz9bncda6w000
     */
    @SerializedName("sp_appid")
    private String spAppid;
    /**
     * 字段含义：子商户号。
     * 格式规则：字符串。
     * 业务规则：由抖音支付生成并下发，用于标识子商户主体。
     * 示例：6020230307605000
     */
    @SerializedName("sub_mchid")
    private String subMchid;
    /**
     * 字段含义：子商户应用ID。
     * 格式规则：字符串。
     * 业务规则：由子商户在抖音开放平台申请，全局唯一；此处应填写网站应用类型的 AppID，并确保与 sub_mchid 存在绑定关系。
     * 示例：awofz9bncda6x000
     */
    @SerializedName("sub_appid")
    private String subAppid;
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
        sb.append("settleInfo=").append(toIndentedString(settleInfo));
        sb.append('}');
        return sb.toString();
    }
}
