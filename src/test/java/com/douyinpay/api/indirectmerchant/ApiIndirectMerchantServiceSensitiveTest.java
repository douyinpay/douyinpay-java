package com.douyinpay.api.indirectmerchant;

import com.douyinpay.api.DouyinpayClient;
import com.douyinpay.api.DouyinpayRequest;
import com.douyinpay.api.DouyinpayResponse;
import com.douyinpay.api.indirectmerchant.models.ApplyResponse;
import com.douyinpay.api.indirectmerchant.models.CreateApplyRequest;
import com.douyinpay.api.indirectmerchant.models.IdentificationInfo;
import com.douyinpay.api.indirectmerchant.models.Locator;
import com.douyinpay.api.indirectmerchant.models.QueryMerchantResponse;
import com.douyinpay.exception.DouyinpayException;
import com.douyinpay.util.GsonUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * {@link ApiIndirectMerchantService} 敏感字段加解密集成测试。
 *
 * 使用桩客户端模拟平台加解密，验证：入驻申请发送前对证件敏感字段做副本加密且不污染调用方对象、
 * 查询商户返回后对证件敏感字段原位解密，以及加解密失败时异常向上传播。
 */
public class ApiIndirectMerchantServiceSensitiveTest {

    private static final String ENC_PREFIX = "ENC(";
    private static final String ENC_SUFFIX = ")";

    /** 桩客户端：捕获请求体，模拟可逆的敏感字段加解密，并返回预置响应。 */
    private static class StubClient implements DouyinpayClient {
        String capturedBody;
        QueryMerchantResponse queryMerchantResponse;
        boolean failCrypto;

        @Override
        @SuppressWarnings("unchecked")
        public <T> DouyinpayResponse<T> execute(DouyinpayRequest request, Class<T> responseClass) {
            capturedBody = request.getBody();
            DouyinpayResponse<T> response = new DouyinpayResponse<>(request, 200, "application/json", null, "");
            if (responseClass == ApplyResponse.class) {
                ApplyResponse apply = new ApplyResponse();
                apply.applymentId = "APPLY_123";
                response.setApiResponse((T) apply);
            } else if (responseClass == QueryMerchantResponse.class) {
                response.setApiResponse((T) queryMerchantResponse);
            }
            return response;
        }

        @Override
        public String encryptSensitive(String plainText) {
            if (failCrypto) {
                throw new DouyinpayException("boom encrypt");
            }
            return ENC_PREFIX + plainText + ENC_SUFFIX;
        }

        @Override
        public String decryptSensitive(String cipherText) {
            if (failCrypto) {
                throw new DouyinpayException("boom decrypt");
            }
            if (cipherText.startsWith(ENC_PREFIX) && cipherText.endsWith(ENC_SUFFIX)) {
                return cipherText.substring(ENC_PREFIX.length(), cipherText.length() - ENC_SUFFIX.length());
            }
            throw new DouyinpayException("illegal cipher text: " + cipherText);
        }
    }

    private static CreateApplyRequest newCreateApplyRequest() {
        CreateApplyRequest request = new CreateApplyRequest();
        request.outIndirectMerchantId = "20434920032";
        request.outPaymentInstId = "4043424032";
        request.businessCode = "biz_001";
        IdentificationInfo info = new IdentificationInfo();
        info.identificationType = "IDENTIFICATION_TYPE_IDCARD";
        info.identificationName = "张三";
        info.identificationNumber = "110101199001011234";
        request.identificationInfo = info;
        return request;
    }

    @Test
    public void createApplyEncryptsSensitiveFieldsWithoutMutatingRequest() {
        StubClient client = new StubClient();
        ApiIndirectMerchantService service = new ApiIndirectMerchantService.Builder()
                .douyinpayClient(client).build();
        CreateApplyRequest request = newCreateApplyRequest();

        ApplyResponse response = service.createApply(request);

        Assert.assertEquals("APPLY_123", response.applymentId);
        // 调用方传入的原始对象不被修改。
        Assert.assertEquals("张三", request.identificationInfo.identificationName);
        Assert.assertEquals("110101199001011234", request.identificationInfo.identificationNumber);
        // 实际发送的报文中敏感字段已加密。
        CreateApplyRequest sent = GsonUtil.getGson().fromJson(client.capturedBody, CreateApplyRequest.class);
        Assert.assertEquals("ENC(张三)", sent.identificationInfo.identificationName);
        Assert.assertEquals("ENC(110101199001011234)", sent.identificationInfo.identificationNumber);
        // 非敏感字段保持不变。
        Assert.assertEquals("IDENTIFICATION_TYPE_IDCARD", sent.identificationInfo.identificationType);
        Assert.assertEquals("biz_001", sent.businessCode);
    }

    @Test
    public void createApplyWithoutIdentificationInfoSendsAsIs() {
        StubClient client = new StubClient();
        ApiIndirectMerchantService service = new ApiIndirectMerchantService.Builder()
                .douyinpayClient(client).build();
        CreateApplyRequest request = newCreateApplyRequest();
        request.identificationInfo = null;

        service.createApply(request);

        CreateApplyRequest sent = GsonUtil.getGson().fromJson(client.capturedBody, CreateApplyRequest.class);
        Assert.assertNull(sent.identificationInfo);
    }

    @Test(expected = DouyinpayException.class)
    public void createApplyPropagatesEncryptionFailure() {
        StubClient client = new StubClient();
        client.failCrypto = true;
        ApiIndirectMerchantService service = new ApiIndirectMerchantService.Builder()
                .douyinpayClient(client).build();
        service.createApply(newCreateApplyRequest());
    }

    @Test
    public void queryMerchantDecryptsSensitiveFieldsInPlace() {
        StubClient client = new StubClient();
        QueryMerchantResponse canned = new QueryMerchantResponse();
        canned.indirectMerchantId = "2026045587123820";
        IdentificationInfo info = new IdentificationInfo();
        info.identificationName = "ENC(李四)";
        info.identificationNumber = "ENC(440101199202022345)";
        canned.identificationInfo = info;
        client.queryMerchantResponse = canned;

        ApiIndirectMerchantService service = new ApiIndirectMerchantService.Builder()
                .douyinpayClient(client).build();
        Locator locator = new Locator();
        locator.indirectMerchantId = "2026045587123820";

        QueryMerchantResponse response = service.queryMerchant(locator);

        Assert.assertEquals("李四", response.identificationInfo.identificationName);
        Assert.assertEquals("440101199202022345", response.identificationInfo.identificationNumber);
    }

    @Test(expected = DouyinpayException.class)
    public void queryMerchantPropagatesDecryptionFailure() {
        StubClient client = new StubClient();
        QueryMerchantResponse canned = new QueryMerchantResponse();
        IdentificationInfo info = new IdentificationInfo();
        info.identificationName = "garbage-cipher";
        canned.identificationInfo = info;
        client.queryMerchantResponse = canned;

        ApiIndirectMerchantService service = new ApiIndirectMerchantService.Builder()
                .douyinpayClient(client).build();
        Locator locator = new Locator();
        locator.indirectMerchantId = "2026045587123820";

        service.queryMerchant(locator);
    }

    @Test
    public void locatorValidationRejectsAmbiguousAndMissingLocators() {
        Locator both = new Locator();
        both.outIndirectMerchantId = "20434920032";
        both.outPaymentInstId = "4043424032";
        both.indirectMerchantId = "2026045587123820";
        assertThrows(both);

        Locator none = new Locator();
        assertThrows(none);

        Locator channelOnly = new Locator();
        channelOnly.indirectMerchantId = "2026045587123820";
        channelOnly.outChannelSpId = "sp_1";
        assertThrows(channelOnly);
    }

    private static void assertThrows(Locator locator) {
        try {
            locator.validate();
            Assert.fail("expected IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            // expected
        }
    }
}
