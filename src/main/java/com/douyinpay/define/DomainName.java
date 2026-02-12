package com.douyinpay.define;

import static java.util.Objects.requireNonNull;

/**
 * 抖音支付域名
 */
public enum DomainName {
    API("https://api.douyinpay.com"),
    PAYSCORE_API("https://api.doupay.com");

    private final String value;

    DomainName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public boolean equalsWith(String string) {
        requireNonNull(string);
        return string.startsWith(value);
    }
}
