package com.douyinpay.api.partnersplitfund.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiPartnerQueryReturnSplitFundRequest {
    /**
     * 字段含义：商户回退单号。
     * 格式规则：字符串，长度为 1-32 位。
     * 业务规则：商户在自己后台生成的新回退单号，在商户后台唯一，用于定位回退结果。
     * 示例：OUT_338004
     */
    @SerializedName("out_return_no")
    private String outReturnNo;

    /**
     * 字段含义：服务商户号。
     * 格式规则：字符串，长度为 1-32 位。
     * 业务规则：由抖音支付生成并下发，用于标识服务商主体。
     * 示例：6020230307605001
     */
    @SerializedName("sp_mchid")
    private String spMchid;

    /**
     * 字段含义：特约商户号。
     * 格式规则：字符串，长度为 1-32 位。
     * 业务规则：由抖音支付生成并下发，用于标识被服务的特约商户主体。
     * 示例：6020230307605002
     */
    @SerializedName("sub_mchid")
    private String subMchid;

    /**
     * 字段含义：商户分账单号。
     * 格式规则：字符串，长度为 6-32 位，仅支持数字、大小写字母及 _-*。
     * 业务规则：商户系统内部的分账单号，在商户系统内部唯一，同一分账单号多次请求等同一次。
     * 示例：OUT_3135780230025060619983
     */
    @SerializedName("out_order_no")
    private String outOrderNo;

    public String getOutReturnNo() {
        return outReturnNo;
    }

    public void setOutReturnNo(String outReturnNo) {
        this.outReturnNo = outReturnNo;
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

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    @Override
    public String toString() {
        return GsonUtil.objectToJson(this);
    }
}
