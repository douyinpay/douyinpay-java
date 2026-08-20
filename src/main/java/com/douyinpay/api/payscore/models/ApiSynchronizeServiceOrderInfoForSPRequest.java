package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

/**
 * 直连服务商同步服务订单信息请求。
 */
public class ApiSynchronizeServiceOrderInfoForSPRequest {
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
    /** 商户服务单号。 */
    @SerializedName("out_order_no")
    private String outOrderNo;
    /** 服务 ID。 */
    @SerializedName("service_id")
    private String serviceId;
    /** 同步类型。 */
    @SerializedName("type")
    private String type;
    /** 同步内容详情。 */
    @SerializedName("detail")
    private SyncDetail detail;

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

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public SyncDetail getDetail() {
        return detail;
    }

    public void setDetail(SyncDetail detail) {
        this.detail = detail;
    }
}
