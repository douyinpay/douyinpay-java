package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

/**
 * 直连服务商申请服务授权请求。
 */
public class ApiCreditSrvSignApplyForSPRequest {
    // 字段含义：服务商商户号。
    // 格式规则：string[1,32]。
    // 业务规则：服务商的商户号，由抖音支付生成并下发。
    // 示例：6020230307605084。
    @SerializedName("sp_mchid")
    private String spMchid;
    // 字段含义：服务商应用ID。
    // 格式规则：string[1,32]。
    // 业务规则：由抖音支付生成的应用ID，全局唯一。
    // 示例：awofz9bncda6w2w4。
    @SerializedName("sp_appid")
    private String spAppid;
    // 字段含义：子商户商户号。
    // 格式规则：string[1,32]。
    // 业务规则：子商户的商户号，由抖音支付生成并下发。
    // 示例：6020230307605085。
    @SerializedName("sub_mchid")
    private String subMchid;
    // 字段含义：子商户应用ID。
    // 格式规则：string[1,32]。
    // 业务规则：由抖音支付生成的应用ID，全局唯一。
    // 示例：awofz9bncda6w2w4。
    @SerializedName("sub_appid")
    private String subAppid;
    // 字段含义：服务ID。
    // 格式规则：string[1,32]。
    // 业务规则：业务接入时分配，用于配置商户和场景维度信息。
    // 示例：101。
    @SerializedName("service_id")
    private String serviceId;
    // 字段含义：商户协议号。
    // 格式规则：string[1,64]。
    // 业务规则：商户侧生成的协议号，在同一个商户号下唯一。
    // 示例：1736173225954193889。
    @SerializedName("authorization_code")
    private String authorizationCode;
    // 字段含义：通知地址。
    // 格式规则：string[1,255]，必须为https地址。请确保回调URL是外部可正常访问的，且不能携带后缀参数。
    // 示例：https://www.bytedance.com。
    @SerializedName("notify_url")
    private String notifyUrl;
    // 字段含义：商户数据包。
    // 格式规则：string[1,1024]。
    // 示例：{"out_product_category":"BATTERY_CHANGE"}。
    @SerializedName("attach")
    private String attach;
    // 字段含义：场景信息。
    // 格式规则：object。
    // 示例：{"client_ip":"14.23.150.211","device_id":"13467007045764","store_info":{"id":"1089"}}。
    @SerializedName("scene_info")
    private SceneInfo sceneInfo;
    // 字段含义：优惠标记。
    // 格式规则：string[1,512]，json格式。
    // 业务规则：和抖音支付协商后可用。
    // 示例：{"product_tag":"xxxx","biz_scene":"aaaa"}。
    @SerializedName("goods_tag")
    private String goodsTag;
    // 字段含义：扩展参数。
    // 格式规则：string[1,2048]，json字符串。
    // 业务规则：和抖音支付协商后可用。
    // 示例：{"A":"a"}。
    @SerializedName("ext_info")
    private String extInfo;

    public String getSpMchid() {
        return spMchid;
    }

    public void setSpMchid(String spMchid) {
        this.spMchid = spMchid;
    }

    public String getSpAppid() {
        return spAppid;
    }

    public void setSpAppid(String spAppid) {
        this.spAppid = spAppid;
    }

    public String getSubMchid() {
        return subMchid;
    }

    public void setSubMchid(String subMchid) {
        this.subMchid = subMchid;
    }

    public String getSubAppid() {
        return subAppid;
    }

    public void setSubAppid(String subAppid) {
        this.subAppid = subAppid;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public SceneInfo getSceneInfo() {
        return sceneInfo;
    }

    public void setSceneInfo(SceneInfo sceneInfo) {
        this.sceneInfo = sceneInfo;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }
}
