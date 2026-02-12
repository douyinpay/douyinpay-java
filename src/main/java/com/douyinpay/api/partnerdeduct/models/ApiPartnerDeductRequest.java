package com.douyinpay.api.partnerdeduct.models;
import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiPartnerDeductRequest {
    /** 应用ID  */
    @SerializedName("sp_appid")
    private String spAppid;
    /** 服务商商户号 */
    @SerializedName("sp_mchid")
    private String spMchid;
    /** 子商户appid */
    @SerializedName("sub_appid")
    private String subAppid;
    /** 特约商户号 */
    @SerializedName("sub_mchid")
    private String subMchid;
    /** 商户订单号 */
    @SerializedName("out_trade_no")
    private String outTradeNo;
    /** 交易结束时间 */
    @SerializedName("time_expire")
    private String timeExpire;
    /** 委托代扣协议id */
    @SerializedName("contract_id")
    private String contractId;
    /** 交易类型 */
    @SerializedName("trade_type")
    private String tradeType;
    /** 商品描述 */
    @SerializedName("description")
    private String description;
    /** 通知地址 */
    @SerializedName("notify_url")
    private String notifyUrl;
    /** 附加数据 */
    @SerializedName("attach")
    private String attach;
    /** 优惠标记 **/
    @SerializedName("goods_tag")
    private String goodsTag;
    /** 优惠信息 */
    @SerializedName("detail")
    private ApiDetail detail;
    /** 订单金额 */
    @SerializedName("amount")
    private Amount amount;
    /** 场景信息 */
    @SerializedName("scene_info")
    private ApiSceneInfo sceneInfo;
    /** 结算信息 */
    @SerializedName("settle_info")
    private ApiSettleInfo settleInfo;

  
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

    public String getOutTradeNo() {
      return outTradeNo;
    }
  
    public void setOutTradeNo(String outTradeNo) {
      this.outTradeNo = outTradeNo;
    }
  
    public String getTimeExpire() {
      return timeExpire;
    }
  
    public void setTimeExpire(String timeExpire) {
      this.timeExpire = timeExpire;
    }
  
    public String getContractId() {
      return contractId;
    }
  
    public void setContractId(String contractId) {
      this.contractId = contractId;
    }
  
    public String getTradeType() {
      return tradeType;
    }
  
    public void setTradeType(String tradeType) {
      this.tradeType = tradeType;
    }
  
    public String getDescription() {
      return description;
    }
  
    public void setDescription(String description) {
      this.description = description;
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
  
    public ApiDetail getDetail() {
      return detail;
    }
  
    public void setDetail(ApiDetail detail) {
      this.detail = detail;
    }
  
    public Amount getAmount() {
      return amount;
    }
  
    public void setAmount(Amount amount) {
      this.amount = amount;
    }
  
    public ApiSceneInfo getSceneInfo() {
      return sceneInfo;
    }
  
    public void setSceneInfo(ApiSceneInfo sceneInfo) {
      this.sceneInfo = sceneInfo;
    }
  
    public ApiSettleInfo getSettleInfo() {
      return settleInfo;
    }
  
    public void setSettleInfo(ApiSettleInfo settleInfo) {
      this.settleInfo = settleInfo;
    }
  
    public String getGoodsTag() {
      return goodsTag;
    }
  
    public void setGoodsTag(String goodsTag) {
      this.goodsTag = goodsTag;
    }
  
    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ApiPartnerDeductRequest {\n");
      sb.append("    spAppid: ").append(toIndentedString(spAppid)).append("\n");
      sb.append("    spMchid: ").append(toIndentedString(spMchid)).append("\n");
      sb.append("    subAppid: ").append(toIndentedString(subAppid)).append("\n");
      sb.append("    subMchid: ").append(toIndentedString(subMchid)).append("\n");
      sb.append("    outTradeNo: ").append(toIndentedString(outTradeNo)).append("\n");
      sb.append("    timeExpire: ").append(toIndentedString(timeExpire)).append("\n");
      sb.append("    contractId: ").append(toIndentedString(contractId)).append("\n");
      sb.append("    tradeType: ").append(toIndentedString(tradeType)).append("\n");
      sb.append("    description: ").append(toIndentedString(description)).append("\n");
      sb.append("    notifyUrl: ").append(toIndentedString(notifyUrl)).append("\n");
      sb.append("    attach: ").append(toIndentedString(attach)).append("\n");
      sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
      sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
      sb.append("    sceneInfo: ").append(toIndentedString(sceneInfo)).append("\n");
      sb.append("    settleInfo: ").append(toIndentedString(settleInfo)).append("\n");
      sb.append("    goodsTag: ").append(toIndentedString(goodsTag)).append("\n");
      sb.append("}");
      return sb.toString();
    }
}
