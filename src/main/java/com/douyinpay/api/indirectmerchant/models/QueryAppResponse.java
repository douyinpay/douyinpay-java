package com.douyinpay.api.indirectmerchant.models;

import java.util.List;

/**
 * 查询应用 APPID 响应（query_app_id）。
 *
 * 官方文档：
 * https://partner.douyinpay.com/wiki/682c7a8e82b07604fd4deccb/6940170bda453b056b767637
 */
public class QueryAppResponse {

    /** 应用信息列表。 */
    public List<AppInfo> appInfoList;
}
