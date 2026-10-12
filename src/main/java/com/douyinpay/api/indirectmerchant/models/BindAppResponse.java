package com.douyinpay.api.indirectmerchant.models;

/**
 * 绑定应用 APPID 响应（bind_app_id）。
 *
 * 官方文档：
 * https://partner.douyinpay.com/wiki/682c7a8e82b07604fd4deccb/693fc694da453b056b7353d0
 */
public class BindAppResponse {

    /** 应用信息，绑定成功或待授权情况下返回。 */
    public AppInfo appInfo;
}
