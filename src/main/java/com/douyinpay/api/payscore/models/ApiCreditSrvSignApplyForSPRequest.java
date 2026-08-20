package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

/**
 * 直连服务商申请服务授权请求。
 */
public class ApiCreditSrvSignApplyForSPRequest {
    /** 服务商商户号。 */
    @SerializedName("sp_mchid")
    private String spMchid;
    /** 服务商应用 ID。 */
    @SerializedName("sp_appid")
    private String spAppid;
    /** 子商户商户号。 */
    @SerializedName("sub_mchid")
    private String subMchid;
    /** 子商户应用 ID。 */
    @SerializedName("sub_appid")
    private String subAppid;
    /** 服务实体 ID。 */
    @SerializedName("service_id")
    private String serviceId;
    /** 商户协议号。 */
    @SerializedName("authorization_code")
    private String authorizationCode;
    /** 授权结果回调地址。 */
    @SerializedName("notify_url")
    private String notifyUrl;
    /** 商户透传数据。 */
    @SerializedName("attach")
    private String attach;
    /** 业务场景信息。 */
    @SerializedName("scene_info")
    private SceneInfo sceneInfo;
    /** 营销透传参数。 */
    @SerializedName("goods_tag")
    private String goodsTag;
    /** 扩展参数。 */
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
