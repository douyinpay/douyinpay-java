package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

/**
 * 直连服务商同步服务订单信息请求。
 */
public class ApiSynchronizeServiceOrderInfoForSPRequest {
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
    // 字段含义：商户服务单号。
    // 格式规则：string，只能是数字、大小写字母_-*。
    // 业务规则：商户系统内部服务订单号，在同一个商户号下唯一。
    // 示例：OUT_1666688488。
    @SerializedName("out_order_no")
    private String outOrderNo;
    // 字段含义：服务ID。
    // 格式规则：string[1,32]。
    // 业务规则：业务接入时分配，用于配置商户和场景维度信息。
    // 示例：101。
    @SerializedName("service_id")
    private String serviceId;
    // 字段含义：同步类型。
    // 格式规则：string[1,20]。
    // 业务规则：枚举值：订单已支付-ORDER_PAID。
    // 示例：ORDER_PAID。
    @SerializedName("type")
    private String type;
    // 字段含义：同步内容信息详情。
    // 格式规则：object。
    // 业务规则：描述订单同步所需的内容信息。
    // 示例：{"paid_time":20220208060910}。
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
