package com.douyinpay.api.indirectmerchant.models;

/**
 * 应用信息。
 *
 * 对应绑定应用 APPID 响应（bind_app_id）/查询应用 APPID 响应（query_app_id）中的 app_info。
 */
public class AppInfo {

    /** 应用 APPID。 */
    public String appId;

    /** 应用类型（中文），枚举包括“小程序应用”、“移动应用”、“网站应用”。 */
    public String appType;

    /** 绑定状态，枚举包括 BIND（已绑定）、WAIT_CONFIRM（待应用开发者确认）。 */
    public String bindStatus;
}
