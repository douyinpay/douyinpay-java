package com.douyinpay.api.indirectmerchant.models;

/**
 * 间连商户定位信息，用于查询/绑定/修改等接口。
 *
 * 支持两种定位方式二选一：外部定位（outIndirectMerchantId + outPaymentInstId，可选 outChannelSpId）
 * 或抖音支付间连商户号（indirectMerchantId）。
 */
public class Locator {

    /** 间连商户外部商户号，从业机构在清算机构侧登记的间连商户唯一标识。 */
    public String outIndirectMerchantId;

    /** 从业机构外部商户号，从业机构在清算机构侧登记的商户号。 */
    public String outPaymentInstId;

    /** 渠道商外部商户号，仅能与外部定位方式组合使用。 */
    public String outChannelSpId;

    /** 抖音支付间连商户号。 */
    public String indirectMerchantId;

    /**
     * 校验商户定位信息必须且仅能提供一种定位方式。
     *
     * @throws IllegalArgumentException 定位信息缺失、同时提供两种定位方式，
     *                                  或 outChannelSpId 未与外部定位组合使用时抛出
     */
    public void validate() {
        boolean external = isNotEmpty(outIndirectMerchantId) || isNotEmpty(outPaymentInstId);
        if (external && (isEmpty(outIndirectMerchantId) || isEmpty(outPaymentInstId))) {
            throw new IllegalArgumentException("external merchant locator requires both identifiers");
        }
        if (external == isNotEmpty(indirectMerchantId)) {
            throw new IllegalArgumentException("exactly one merchant locator is required");
        }
        if (isNotEmpty(outChannelSpId) && !external) {
            throw new IllegalArgumentException("out_channel_sp_id requires external merchant locator");
        }
    }

    private static boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }

    private static boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }
}
