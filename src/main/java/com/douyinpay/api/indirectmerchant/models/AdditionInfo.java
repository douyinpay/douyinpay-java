package com.douyinpay.api.indirectmerchant.models;

import java.util.List;

/**
 * 补充信息。
 *
 * 对应入驻申请（create_apply）中的 addition_info，根据审核情况额外要求商家提供的补充资料。
 */
public class AdditionInfo {

    /** 补充材料图片的 MediaID 列表，最多 5 张图片。 */
    public List<String> additionPics;

    /** 补充说明，文案不超过 100 字。 */
    public String additionRemark;
}
