package com.douyinpay.api.partnersplitfund.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class ApiPartnerQuerySplitFundRequest {
    /**
     * 字段含义：服务商户号。
     * 格式规则：字符串，长度为 1-32 位。
     * 业务规则：由抖音支付生成并下发，用于标识服务商主体。
     * 示例：6020221212167701
     */
    @SerializedName("sp_mchid")
    private String spMchid;

    /**
     * 字段含义：特约商户号。
     * 格式规则：字符串，长度为 1-32 位。
     * 业务规则：由抖音支付生成并下发，用于标识被服务的特约商户主体。
     * 示例：6020221212167702
     */
    @SerializedName("sub_mchid")
    private String subMchid;

    /**
     * 字段含义：抖音支付订单号。
     * 格式规则：字符串，长度为 1-32 位。
     * 业务规则：填写原支付交易对应的交易订单号。
     * 示例：2100012501030500000618413371
     */
    @SerializedName("transaction_id")
    private String tradeNo;

    /**
     * 字段含义：商户分账单号。
     * 格式规则：字符串，长度为 6-32 位，仅支持数字、大小写字母及 _-*。
     * 业务规则：商户系统内部的分账单号，在商户系统内部唯一，同一分账单号多次请求等同一次；与抖音支付分账单号二选一定位分账单。
     * 示例：OUT_3135780230025060619983034
     */
    @SerializedName("out_order_no")
    private String outOrderNo;

    /**
     * 字段含义：抖音支付分账单号。
     * 格式规则：字符串，长度为 1-32 位。
     * 业务规则：由抖音支付生成的分账单号，与商户分账单号二选一定位分账单。
     * 示例：11777200250103110500000223502022
     */
    @SerializedName("order_id")
    private String orderId;

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

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return GsonUtil.objectToJson(this);
    }
}
