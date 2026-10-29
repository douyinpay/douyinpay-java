package com.douyinpay.define;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CustomHeadersDefensiveCopyTest {

    @Test
    public void globalConfigCopiesCustomHeadersOnSetAndGet() {
        Map<String, String> headers = new HashMap<>();
        headers.put("X-Test", "initial");
        GlobalConfig config = new GlobalConfig();
        config.setCustomHeaders(headers);

        headers.put("X-Test", "changed");
        Assert.assertEquals("initial", config.getCustomHeaders().get("X-Test"));

        try {
            config.getCustomHeaders().put("X-Other", "value");
            Assert.fail("expected unmodifiable custom headers");
        } catch (UnsupportedOperationException expected) {
            // expected
        }
    }

    @Test
    public void autoPlatformCertificateConfigCopiesCustomHeadersOnSetAndGet() {
        Map<String, String> headers = new HashMap<>();
        headers.put("X-Test", "initial");
        AutoPlatformCertificateConfig config = new AutoPlatformCertificateConfig();
        config.setCustomHeaders(headers);

        headers.put("X-Test", "changed");
        Assert.assertEquals("initial", config.getCustomHeaders().get("X-Test"));

        try {
            config.getCustomHeaders().put("X-Other", "value");
            Assert.fail("expected unmodifiable custom headers");
        } catch (UnsupportedOperationException expected) {
            // expected
        }
    }
}
