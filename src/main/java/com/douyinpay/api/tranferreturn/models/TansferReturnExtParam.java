package com.douyinpay.api.tranferreturn.models;

import com.douyinpay.util.GsonUtil;
import com.google.gson.annotations.SerializedName;

public class TansferReturnExtParam {
  /** 是否需要收款方通知 */
  @SerializedName("need_payee_notify")
  private Boolean needPayeeNotify;
  /** 收款方通知参数 */
  @SerializedName("payee_notify_params")
  private String payeeNotifyParams;


  public Boolean getNeedPayeeNotify() {
    return needPayeeNotify;
  }

  public void setNeedPayeeNotify(Boolean needPayeeNotify) {
    this.needPayeeNotify = needPayeeNotify;
  }

  public String getPayeeNotifyParams() {
    return payeeNotifyParams;
  }

  public void setPayeeNotifyParams(String payeeNotifyParams) {
    this.payeeNotifyParams = payeeNotifyParams;
  }


  @Override
  public String toString() {
    return GsonUtil.objectToJson(this);
  }
}
