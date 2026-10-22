package com.douyinpay.api.indirectmerchant.models;

import java.util.List;

/**
 * 经营信息。
 *
 * 对应入驻申请（create_apply）/查询间连商户（query_merchant）中的 business_info。
 */
public class BusinessInfo {

    /** 商户简称，在支付完成页向买家展示。 */
    public String merchantShortName;

    /** 客服电话，将在交易记录中向买家展示。 */
    public String servicePhone;

    /** 所属行业，间连商户在清算机构侧登记的行业 MCC 编码。 */
    public String mcc;

    /** 特殊资质图片的 MediaID 列表，支持 1-5 张图片。 */
    public List<String> specialIndustryPics;
}
