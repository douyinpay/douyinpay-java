package com.doupay.api.partnersplitfund;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.douyinpay.api.DefaultDouyinpayClient;
import com.douyinpay.api.DouyinpayRequest;
import com.douyinpay.api.DouyinpayResponse;
import com.douyinpay.api.notification.NotificationParser;
import com.douyinpay.api.notification.RequestParam;
import com.douyinpay.api.partnersplitfund.ApiPartnerSplitFundPaymentsService;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerAddSplitReceiverRequest;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerAddSplitReceiverResponse;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerDeleteSplitReceiverRequest;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerDeleteSplitReceiverResponse;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerFinishSplitFundRequest;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerFinishSplitFundResponse;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerQueryMerchantConfigRequest;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerQueryMerchantConfigResponse;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerQueryReturnSplitFundRequest;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerQueryReturnSplitFundResponse;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerQuerySplitFundRequest;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerQuerySplitFundResponse;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerQueryUnSplitFundRequest;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerQueryUnSplitFundResponse;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerReturnSplitFundRequest;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerReturnSplitFundResponse;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerSplitFundNotification;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerSplitFundRequest;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerSplitFundResponse;
import com.douyinpay.api.partnersplitfund.models.ApiPartnerSplitReceiverNotification;
import com.douyinpay.api.partnersplitfund.models.PartnerReceiverInfoDto;
import com.douyinpay.api.partnersplitfund.models.PartnerReceiverSplitResultDto;
import com.douyinpay.component.crypto.RsaCryptor;
import com.douyinpay.define.Constants;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ApiPartnerSplitFundPaymentsServiceTest {

        @Test
        public void splitFundShouldUsePartnerFieldsAndEncryptReceiverName() throws Exception {
                DefaultDouyinpayClient douyinpayClient = mock(DefaultDouyinpayClient.class);
                X509Certificate certificate = mock(X509Certificate.class);
                when(douyinpayClient.getSignType()).thenReturn(Constants.SIGN_TYPE_RSA);
                when(douyinpayClient.getPlatformCertificate()).thenReturn(certificate);
                when(certificate.getPublicKey()).thenReturn(loadPublicKey());
                when(certificate.getSerialNumber()).thenReturn(new BigInteger("1234", Constants.HEX));

                ApiPartnerSplitFundResponse expectedResponse = new ApiPartnerSplitFundResponse();
                expectedResponse.setSpMchid("6020221212167701");
                expectedResponse.setSubMchid("6020221212167702");
                expectedResponse.setTradeNo("TP2022101317144741443210681000");
                expectedResponse.setOutOrderNo("OUT_1666688488");
                expectedResponse.setOrderId("11777200250103110500000223502022");

                DouyinpayResponse<ApiPartnerSplitFundResponse> response = new DouyinpayResponse<ApiPartnerSplitFundResponse>(
                                null, 200, null, Collections.<String, String>emptyMap(), null);
                response.setApiResponse(expectedResponse);
                when(douyinpayClient.execute(any(DouyinpayRequest.class), eq(ApiPartnerSplitFundResponse.class)))
                                .thenReturn(response);

                PartnerReceiverInfoDto receiver = new PartnerReceiverInfoDto();
                receiver.setType("MERCHANT_ID");
                receiver.setAccount("6020230307605084");
                receiver.setName("Partner Receiver");
                receiver.setAmount(100);
                receiver.setDescription("split to partner");
                List<PartnerReceiverInfoDto> receivers = new ArrayList<PartnerReceiverInfoDto>();
                receivers.add(receiver);

                ApiPartnerSplitFundRequest request = new ApiPartnerSplitFundRequest();
                request.setSpMchid("6020221212167701");
                request.setSpAppid("awofz9bncda6w2w4");
                request.setSubMchid("6020221212167702");
                request.setSubAppid("awofz9bncda6w2w5");
                request.setTradeNo("TP2022101317144741443210681000");
                request.setOutOrderNo("OUT_1666688488");
                request.setReceivers(receivers);
                request.setUnfreezeUnsplit(Boolean.TRUE);
                request.setNotifyUrl("https://www.mock.douyinpay.com");

                ApiPartnerSplitFundPaymentsService service = new ApiPartnerSplitFundPaymentsService.Builder()
                                .douyinpayClient(douyinpayClient).build();

                ApiPartnerSplitFundResponse actualResponse = service.splitFund(request);

                ArgumentCaptor<DouyinpayRequest> requestCaptor = ArgumentCaptor.forClass(DouyinpayRequest.class);
                verify(douyinpayClient).execute(requestCaptor.capture(), eq(ApiPartnerSplitFundResponse.class));
                DouyinpayRequest capturedRequest = requestCaptor.getValue();

                Assert.assertEquals("/v1/trade/profitsharing/orders", capturedRequest.getPath());
                Assert.assertEquals("1234", capturedRequest.getHeaders().get(Constants.DOUYIN_PAY_SERIAL));

                JsonObject body = com.douyinpay.util.GsonUtil.getGson().fromJson(capturedRequest.getBody(),
                                JsonObject.class);
                Assert.assertEquals("6020221212167701", body.get("sp_mchid").getAsString());
                Assert.assertEquals("awofz9bncda6w2w4", body.get("sp_appid").getAsString());
                Assert.assertEquals("6020221212167702", body.get("sub_mchid").getAsString());
                Assert.assertEquals("awofz9bncda6w2w5", body.get("sub_appid").getAsString());
                Assert.assertEquals("TP2022101317144741443210681000", body.get("transaction_id").getAsString());
                Assert.assertEquals("OUT_1666688488", body.get("out_order_no").getAsString());
                Assert.assertTrue(body.get("unfreeze_unsplit").getAsBoolean());
                Assert.assertEquals("https://www.mock.douyinpay.com", body.get("notify_url").getAsString());

                JsonArray receiverArray = body.getAsJsonArray("receivers");
                Assert.assertEquals(1, receiverArray.size());
                JsonObject receiverBody = receiverArray.get(0).getAsJsonObject();
                Assert.assertEquals("MERCHANT_ID", receiverBody.get("type").getAsString());
                Assert.assertEquals("6020230307605084", receiverBody.get("account").getAsString());
                Assert.assertEquals(100, receiverBody.get("amount").getAsInt());
                Assert.assertEquals("split to partner", receiverBody.get("description").getAsString());
                Assert.assertNotEquals("Partner Receiver", receiverBody.get("name").getAsString());
                Assert.assertFalse(capturedRequest.getBody().contains("Partner Receiver"));

                Assert.assertEquals("6020221212167701", actualResponse.getSpMchid());
                Assert.assertEquals("6020221212167702", actualResponse.getSubMchid());
                Assert.assertEquals("TP2022101317144741443210681000", actualResponse.getTradeNo());
                Assert.assertEquals("OUT_1666688488", actualResponse.getOutOrderNo());
                Assert.assertEquals("11777200250103110500000223502022", actualResponse.getOrderId());
        }

        @Test
        public void querySplitFundShouldUsePartnerQueryParameters() {
                DefaultDouyinpayClient douyinpayClient = mock(DefaultDouyinpayClient.class);

                PartnerReceiverSplitResultDto receiver = new PartnerReceiverSplitResultDto();
                receiver.setAmount(10);
                receiver.setDescription("split to partner");
                receiver.setType("MERCHANT_ID");
                receiver.setAccount("6020230307605084");
                receiver.setResult("SUCCESS");
                receiver.setCreateTime("2025-01-03T11:34:22+08:00");
                receiver.setFinishTime("2025-01-03T11:34:22+08:00");
                receiver.setDetailId("11777400250103110500000430472022");
                List<PartnerReceiverSplitResultDto> receivers = new ArrayList<PartnerReceiverSplitResultDto>();
                receivers.add(receiver);

                ApiPartnerQuerySplitFundResponse expectedResponse = new ApiPartnerQuerySplitFundResponse();
                expectedResponse.setSpMchid("6020221212167701");
                expectedResponse.setSubMchid("6020221212167702");
                expectedResponse.setTradeNo("2100012501030500000618413371");
                expectedResponse.setOutOrderNo("OUT_3135780230025060619983034");
                expectedResponse.setOrderId("11777200250103110500000223502022");
                expectedResponse.setState("FINISHED");
                expectedResponse.setReceivers(receivers);
                expectedResponse.setFinishAmount(10);
                expectedResponse.setFinishDescription("分账完成");
                expectedResponse.setSplitFinishTime("2025-01-03T11:34:22+08:00");

                DouyinpayResponse<ApiPartnerQuerySplitFundResponse> response = new DouyinpayResponse<ApiPartnerQuerySplitFundResponse>(
                                null, 200, null, Collections.<String, String>emptyMap(), null);
                response.setApiResponse(expectedResponse);
                when(douyinpayClient.execute(any(DouyinpayRequest.class), eq(ApiPartnerQuerySplitFundResponse.class)))
                                .thenReturn(response);

                ApiPartnerQuerySplitFundRequest request = new ApiPartnerQuerySplitFundRequest();
                request.setSpMchid("6020221212167701");
                request.setSubMchid("6020221212167702");
                request.setTradeNo("2100012501030500000618413371");
                request.setOutOrderNo("OUT_3135780230025060619983034");
                request.setOrderId("11777200250103110500000223502022");

                ApiPartnerSplitFundPaymentsService service = new ApiPartnerSplitFundPaymentsService.Builder()
                                .douyinpayClient(douyinpayClient).build();

                ApiPartnerQuerySplitFundResponse actualResponse = service.querySplitFund(request);

                ArgumentCaptor<DouyinpayRequest> requestCaptor = ArgumentCaptor.forClass(DouyinpayRequest.class);
                verify(douyinpayClient).execute(requestCaptor.capture(), eq(ApiPartnerQuerySplitFundResponse.class));
                DouyinpayRequest capturedRequest = requestCaptor.getValue();

                String requestPath = capturedRequest.getPath();
                Assert.assertTrue(requestPath
                                .startsWith("/v1/trade/profitsharing/orders/OUT_3135780230025060619983034?"));
                String queryString = requestPath.substring(requestPath.indexOf('?') + 1);
                String[] queryItems = queryString.split("&");
                Set<String> actualParams = new HashSet<String>();
                Collections.addAll(actualParams, queryItems);
                Set<String> expectedParams = new HashSet<String>();
                expectedParams.add("sp_mchid=6020221212167701");
                expectedParams.add("sub_mchid=6020221212167702");
                expectedParams.add("transaction_id=2100012501030500000618413371");
                expectedParams.add("order_id=11777200250103110500000223502022");
                Assert.assertEquals(expectedParams, actualParams);
                Assert.assertNull(capturedRequest.getBody());

                Assert.assertEquals("6020221212167701", actualResponse.getSpMchid());
                Assert.assertEquals("6020221212167702", actualResponse.getSubMchid());
                Assert.assertEquals("2100012501030500000618413371", actualResponse.getTradeNo());
                Assert.assertEquals("OUT_3135780230025060619983034", actualResponse.getOutOrderNo());
                Assert.assertEquals("11777200250103110500000223502022", actualResponse.getOrderId());
                Assert.assertEquals("FINISHED", actualResponse.getState());
                Assert.assertEquals(Integer.valueOf(10), actualResponse.getFinishAmount());
                Assert.assertEquals("分账完成", actualResponse.getFinishDescription());
                Assert.assertEquals("2025-01-03T11:34:22+08:00", actualResponse.getSplitFinishTime());
                Assert.assertEquals(1, actualResponse.getReceivers().size());
                Assert.assertEquals("SUCCESS", actualResponse.getReceivers().get(0).getResult());
        }

        @Test
        public void returnSplitFundShouldUsePartnerFields() {
                DefaultDouyinpayClient douyinpayClient = mock(DefaultDouyinpayClient.class);

                ApiPartnerReturnSplitFundResponse expectedResponse = new ApiPartnerReturnSplitFundResponse();
                expectedResponse.setSpMchid("6020230307605001");
                expectedResponse.setSubMchid("6020230307605002");
                expectedResponse.setOrderId("11777200250103110500000223512022");
                expectedResponse.setOutOrderNo("OUT_31357802300250606199830");
                expectedResponse.setOutReturnNo("OUT_338004");
                expectedResponse.setReturnId("11777200250103110500000222552022");
                expectedResponse.setReturnMchid("6020231219024876");
                expectedResponse.setAmount(10);
                expectedResponse.setDescription("退分账");
                expectedResponse.setResult("SUCCESS");
                expectedResponse.setCreateTime("2025-01-03T11:46:32+08:00");
                expectedResponse.setFinishTime("2025-01-03T11:46:32+08:00");

                DouyinpayResponse<ApiPartnerReturnSplitFundResponse> response = new DouyinpayResponse<ApiPartnerReturnSplitFundResponse>(
                                null, 200, null, Collections.<String, String>emptyMap(), null);
                response.setApiResponse(expectedResponse);
                when(douyinpayClient.execute(any(DouyinpayRequest.class), eq(ApiPartnerReturnSplitFundResponse.class)))
                                .thenReturn(response);

                ApiPartnerReturnSplitFundRequest request = new ApiPartnerReturnSplitFundRequest();
                request.setSpMchid("6020230307605001");
                request.setSubMchid("6020230307605002");
                request.setOrderId("11777200250103110500000223512022");
                request.setOutOrderNo("OUT_31357802300250606199830");
                request.setOutReturnNo("OUT_338004");
                request.setReturnMchid("6020231219024876");
                request.setAmount(10);
                request.setDescription("退分账");

                ApiPartnerSplitFundPaymentsService service = new ApiPartnerSplitFundPaymentsService.Builder()
                                .douyinpayClient(douyinpayClient).build();

                ApiPartnerReturnSplitFundResponse actualResponse = service.returnSplitFund(request);

                ArgumentCaptor<DouyinpayRequest> requestCaptor = ArgumentCaptor.forClass(DouyinpayRequest.class);
                verify(douyinpayClient).execute(requestCaptor.capture(), eq(ApiPartnerReturnSplitFundResponse.class));
                DouyinpayRequest capturedRequest = requestCaptor.getValue();

                Assert.assertEquals("/v1/trade/profitsharing/return-orders", capturedRequest.getPath());
                JsonObject body = com.douyinpay.util.GsonUtil.getGson().fromJson(capturedRequest.getBody(),
                                JsonObject.class);
                Assert.assertEquals("6020230307605001", body.get("sp_mchid").getAsString());
                Assert.assertEquals("6020230307605002", body.get("sub_mchid").getAsString());
                Assert.assertEquals("11777200250103110500000223512022", body.get("order_id").getAsString());
                Assert.assertEquals("OUT_31357802300250606199830", body.get("out_order_no").getAsString());
                Assert.assertEquals("OUT_338004", body.get("out_return_no").getAsString());
                Assert.assertEquals("6020231219024876", body.get("return_mchid").getAsString());
                Assert.assertEquals(10, body.get("amount").getAsInt());
                Assert.assertEquals("退分账", body.get("description").getAsString());

                Assert.assertEquals("6020230307605001", actualResponse.getSpMchid());
                Assert.assertEquals("6020230307605002", actualResponse.getSubMchid());
                Assert.assertEquals("11777200250103110500000223512022", actualResponse.getOrderId());
                Assert.assertEquals("OUT_31357802300250606199830", actualResponse.getOutOrderNo());
                Assert.assertEquals("OUT_338004", actualResponse.getOutReturnNo());
                Assert.assertEquals("11777200250103110500000222552022", actualResponse.getReturnId());
                Assert.assertEquals("6020231219024876", actualResponse.getReturnMchid());
                Assert.assertEquals(Integer.valueOf(10), actualResponse.getAmount());
                Assert.assertEquals("退分账", actualResponse.getDescription());
                Assert.assertEquals("SUCCESS", actualResponse.getResult());
                Assert.assertEquals("2025-01-03T11:46:32+08:00", actualResponse.getCreateTime());
                Assert.assertEquals("2025-01-03T11:46:32+08:00", actualResponse.getFinishTime());
        }

        @Test
        public void queryReturnSplitFundShouldUsePartnerQueryParameters() {
                DefaultDouyinpayClient douyinpayClient = mock(DefaultDouyinpayClient.class);

                ApiPartnerQueryReturnSplitFundResponse expectedResponse = new ApiPartnerQueryReturnSplitFundResponse();
                expectedResponse.setSpMchid("6020230307605001");
                expectedResponse.setSubMchid("6020230307605002");
                expectedResponse.setOrderId("11777200250103120500000220632022");
                expectedResponse.setOutOrderNo("OUT_3135780230025060619983");
                expectedResponse.setOutReturnNo("OUT_3380044");
                expectedResponse.setReturnId("11777200250103120500000239102022");
                expectedResponse.setReturnMchid("6020240223833009");
                expectedResponse.setAmount(10);
                expectedResponse.setDescription("退分账测试");
                expectedResponse.setResult("SUCCESS");
                expectedResponse.setCreateTime("2025-01-03T12:05:34+08:00");
                expectedResponse.setFinishTime("2025-01-03T12:05:34+08:00");

                DouyinpayResponse<ApiPartnerQueryReturnSplitFundResponse> response = new DouyinpayResponse<ApiPartnerQueryReturnSplitFundResponse>(
                                null, 200, null, Collections.<String, String>emptyMap(), null);
                response.setApiResponse(expectedResponse);
                when(douyinpayClient.execute(any(DouyinpayRequest.class),
                                eq(ApiPartnerQueryReturnSplitFundResponse.class))).thenReturn(response);

                ApiPartnerQueryReturnSplitFundRequest request = new ApiPartnerQueryReturnSplitFundRequest();
                request.setOutReturnNo("OUT_3380044");
                request.setSpMchid("6020230307605001");
                request.setSubMchid("6020230307605002");
                request.setOutOrderNo("OUT_3135780230025060619983");

                ApiPartnerSplitFundPaymentsService service = new ApiPartnerSplitFundPaymentsService.Builder()
                                .douyinpayClient(douyinpayClient).build();

                ApiPartnerQueryReturnSplitFundResponse actualResponse = service.queryReturnSplitFund(request);

                ArgumentCaptor<DouyinpayRequest> requestCaptor = ArgumentCaptor.forClass(DouyinpayRequest.class);
                verify(douyinpayClient).execute(requestCaptor.capture(),
                                eq(ApiPartnerQueryReturnSplitFundResponse.class));
                DouyinpayRequest capturedRequest = requestCaptor.getValue();

                String requestPath = capturedRequest.getPath();
                Assert.assertTrue(requestPath.startsWith("/v1/trade/profitsharing/return-orders/OUT_3380044?"));
                String queryString = requestPath.substring(requestPath.indexOf('?') + 1);
                String[] queryItems = queryString.split("&");
                Set<String> actualParams = new HashSet<String>();
                Collections.addAll(actualParams, queryItems);
                Set<String> expectedParams = new HashSet<String>();
                expectedParams.add("sp_mchid=6020230307605001");
                expectedParams.add("sub_mchid=6020230307605002");
                expectedParams.add("out_order_no=OUT_3135780230025060619983");
                Assert.assertEquals(expectedParams, actualParams);
                Assert.assertNull(capturedRequest.getBody());

                Assert.assertEquals("6020230307605001", actualResponse.getSpMchid());
                Assert.assertEquals("6020230307605002", actualResponse.getSubMchid());
                Assert.assertEquals("11777200250103120500000220632022", actualResponse.getOrderId());
                Assert.assertEquals("OUT_3135780230025060619983", actualResponse.getOutOrderNo());
                Assert.assertEquals("OUT_3380044", actualResponse.getOutReturnNo());
                Assert.assertEquals("11777200250103120500000239102022", actualResponse.getReturnId());
                Assert.assertEquals("6020240223833009", actualResponse.getReturnMchid());
                Assert.assertEquals(Integer.valueOf(10), actualResponse.getAmount());
                Assert.assertEquals("退分账测试", actualResponse.getDescription());
                Assert.assertEquals("SUCCESS", actualResponse.getResult());
                Assert.assertEquals("2025-01-03T12:05:34+08:00", actualResponse.getCreateTime());
                Assert.assertEquals("2025-01-03T12:05:34+08:00", actualResponse.getFinishTime());
        }

        @Test
        public void finishSplitFundShouldUsePartnerFields() {
                DefaultDouyinpayClient douyinpayClient = mock(DefaultDouyinpayClient.class);

                ApiPartnerFinishSplitFundResponse expectedResponse = new ApiPartnerFinishSplitFundResponse();
                expectedResponse.setSpMchid("6000000000000001");
                expectedResponse.setSubMchid("6000000000000002");
                expectedResponse.setTransactionId("TP2022101317144741443210681000");
                expectedResponse.setOutOrderNo("OUT_1666688488");
                expectedResponse.setOrderId("11777200260111180300003115170066");
                expectedResponse.setState("PROCESSING");

                DouyinpayResponse<ApiPartnerFinishSplitFundResponse> response = new DouyinpayResponse<ApiPartnerFinishSplitFundResponse>(
                                null, 200, null, Collections.<String, String>emptyMap(), null);
                response.setApiResponse(expectedResponse);
                when(douyinpayClient.execute(any(DouyinpayRequest.class), eq(ApiPartnerFinishSplitFundResponse.class)))
                                .thenReturn(response);

                ApiPartnerFinishSplitFundRequest request = new ApiPartnerFinishSplitFundRequest();
                request.setSpMchid("6020250310533405");
                request.setSubMchid("6020250314534907");
                request.setTransactionId("TP2022101317144741443210681000");
                request.setOutOrderNo("OUT_1666688488");
                request.setDescription("测试商品分账");
                request.setNotifyUrl("https://www.notify.com");

                ApiPartnerSplitFundPaymentsService service = new ApiPartnerSplitFundPaymentsService.Builder()
                                .douyinpayClient(douyinpayClient).build();

                ApiPartnerFinishSplitFundResponse actualResponse = service.finishSplitFund(request);

                ArgumentCaptor<DouyinpayRequest> requestCaptor = ArgumentCaptor.forClass(DouyinpayRequest.class);
                verify(douyinpayClient).execute(requestCaptor.capture(), eq(ApiPartnerFinishSplitFundResponse.class));
                DouyinpayRequest capturedRequest = requestCaptor.getValue();

                Assert.assertEquals("/v1/trade/profitsharing/finish-orders", capturedRequest.getPath());
                JsonObject body = com.douyinpay.util.GsonUtil.getGson().fromJson(capturedRequest.getBody(),
                                JsonObject.class);
                Assert.assertEquals("6020250310533405", body.get("sp_mchid").getAsString());
                Assert.assertEquals("6020250314534907", body.get("sub_mchid").getAsString());
                Assert.assertEquals("TP2022101317144741443210681000", body.get("transaction_id").getAsString());
                Assert.assertEquals("OUT_1666688488", body.get("out_order_no").getAsString());
                Assert.assertEquals("测试商品分账", body.get("description").getAsString());
                Assert.assertEquals("https://www.notify.com", body.get("notify_url").getAsString());

                Assert.assertEquals("6000000000000001", actualResponse.getSpMchid());
                Assert.assertEquals("6000000000000002", actualResponse.getSubMchid());
                Assert.assertEquals("TP2022101317144741443210681000", actualResponse.getTransactionId());
                Assert.assertEquals("OUT_1666688488", actualResponse.getOutOrderNo());
                Assert.assertEquals("11777200260111180300003115170066", actualResponse.getOrderId());
                Assert.assertEquals("PROCESSING", actualResponse.getState());
        }

        @Test
        public void queryUnSplitFundShouldUsePartnerFields() {
                DefaultDouyinpayClient douyinpayClient = mock(DefaultDouyinpayClient.class);

                ApiPartnerQueryUnSplitFundResponse expectedResponse = new ApiPartnerQueryUnSplitFundResponse();
                expectedResponse.setSpMchid("6000000000000001");
                expectedResponse.setTransactionId("TP2022101317144741443210681000");
                expectedResponse.setUnsplitAmount(100);

                DouyinpayResponse<ApiPartnerQueryUnSplitFundResponse> response = new DouyinpayResponse<ApiPartnerQueryUnSplitFundResponse>(
                                null, 200, null, Collections.<String, String>emptyMap(), null);
                response.setApiResponse(expectedResponse);
                when(douyinpayClient.execute(any(DouyinpayRequest.class), eq(ApiPartnerQueryUnSplitFundResponse.class)))
                                .thenReturn(response);

                ApiPartnerQueryUnSplitFundRequest request = new ApiPartnerQueryUnSplitFundRequest();
                request.setTransactionId("TP2022101317144741443210681000");
                request.setSpMchid("6000000000000001");

                ApiPartnerSplitFundPaymentsService service = new ApiPartnerSplitFundPaymentsService.Builder()
                                .douyinpayClient(douyinpayClient).build();

                ApiPartnerQueryUnSplitFundResponse actualResponse = service.queryUnSplitFund(request);

                ArgumentCaptor<DouyinpayRequest> requestCaptor = ArgumentCaptor.forClass(DouyinpayRequest.class);
                verify(douyinpayClient).execute(requestCaptor.capture(), eq(ApiPartnerQueryUnSplitFundResponse.class));
                DouyinpayRequest capturedRequest = requestCaptor.getValue();

                Assert.assertEquals(
                                "/v1/trade/profitsharing/order/TP2022101317144741443210681000/amounts?sp_mchid=6000000000000001",
                                capturedRequest.getPath());
                Assert.assertNull(capturedRequest.getBody());

                Assert.assertEquals("6000000000000001", actualResponse.getSpMchid());
                Assert.assertEquals("TP2022101317144741443210681000", actualResponse.getTransactionId());
                Assert.assertEquals(Integer.valueOf(100), actualResponse.getUnsplitAmount());
        }

        @Test
        public void queryMerchantConfigShouldUsePartnerFields() {
                DefaultDouyinpayClient douyinpayClient = mock(DefaultDouyinpayClient.class);

                ApiPartnerQueryMerchantConfigResponse expectedResponse = new ApiPartnerQueryMerchantConfigResponse();
                expectedResponse.setSubMchid("6020221212167702");
                expectedResponse.setMaxRatio(2000);

                DouyinpayResponse<ApiPartnerQueryMerchantConfigResponse> response = new DouyinpayResponse<ApiPartnerQueryMerchantConfigResponse>(
                                null, 200, null, Collections.<String, String>emptyMap(), null);
                response.setApiResponse(expectedResponse);
                when(douyinpayClient.execute(any(DouyinpayRequest.class),
                                eq(ApiPartnerQueryMerchantConfigResponse.class))).thenReturn(response);

                ApiPartnerQueryMerchantConfigRequest request = new ApiPartnerQueryMerchantConfigRequest();
                request.setSubMchid("6020221212167702");
                request.setSpMchid("6020221212167701");

                ApiPartnerSplitFundPaymentsService service = new ApiPartnerSplitFundPaymentsService.Builder()
                                .douyinpayClient(douyinpayClient).build();

                ApiPartnerQueryMerchantConfigResponse actualResponse = service.queryMerchantConfig(request);

                ArgumentCaptor<DouyinpayRequest> requestCaptor = ArgumentCaptor.forClass(DouyinpayRequest.class);
                verify(douyinpayClient).execute(requestCaptor.capture(),
                                eq(ApiPartnerQueryMerchantConfigResponse.class));
                DouyinpayRequest capturedRequest = requestCaptor.getValue();

                Assert.assertEquals(
                                "/v1/trade/profitsharing/merchant-configs/6020221212167702?sp_mchid=6020221212167701",
                                capturedRequest.getPath());
                Assert.assertNull(capturedRequest.getBody());

                Assert.assertEquals("6020221212167702", actualResponse.getSubMchid());
                Assert.assertEquals(Integer.valueOf(2000), actualResponse.getMaxRatio());
        }

        @Test
        public void parseNotificationShouldUseNotificationParser() {
                NotificationParser notificationParser = mock(NotificationParser.class);

                ApiPartnerSplitFundNotification expectedNotification = new ApiPartnerSplitFundNotification();
                expectedNotification.setSpMchid("6020230307605084");
                expectedNotification.setSubMchid("6020230307605085");
                expectedNotification.setTradeNo("2100012501030500000618413371");
                expectedNotification.setOutOrderNo("OUT_3135780230025060619983034");
                expectedNotification.setOrderId("11777200250103110500000223502022");
                expectedNotification.setState("FINISHED");
                expectedNotification.setFinishAmount(10);
                expectedNotification.setFinishDescription("完结分账");
                expectedNotification.setSplitFinishTime("2025-01-03T11:34:22+08:00");

                RequestParam requestParam = new RequestParam.Builder()
                                .body("{\"resource\":{}}")
                                .serialNumber("serial")
                                .signature("signature")
                                .timestamp("1710000000")
                                .nonce("nonce")
                                .build();

                when(notificationParser.parse(any(RequestParam.class), eq(ApiPartnerSplitFundNotification.class)))
                                .thenReturn(expectedNotification);

                ApiPartnerSplitFundPaymentsService service = new ApiPartnerSplitFundPaymentsService.Builder()
                                .douyinpayClient(null).build();

                ApiPartnerSplitFundNotification actualNotification = service.parseNotification(requestParam,
                                notificationParser);

                verify(notificationParser).parse(requestParam, ApiPartnerSplitFundNotification.class);
                Assert.assertEquals("6020230307605084", actualNotification.getSpMchid());
                Assert.assertEquals("6020230307605085", actualNotification.getSubMchid());
                Assert.assertEquals("2100012501030500000618413371", actualNotification.getTradeNo());
                Assert.assertEquals("OUT_3135780230025060619983034", actualNotification.getOutOrderNo());
                Assert.assertEquals("11777200250103110500000223502022", actualNotification.getOrderId());
                Assert.assertEquals("FINISHED", actualNotification.getState());
                Assert.assertEquals(Integer.valueOf(10), actualNotification.getFinishAmount());
                Assert.assertEquals("完结分账", actualNotification.getFinishDescription());
                Assert.assertEquals("2025-01-03T11:34:22+08:00", actualNotification.getSplitFinishTime());
        }

        @Test
        public void addSplitReceiverShouldUsePartnerFieldsAndDecryptName() throws Exception {
                DefaultDouyinpayClient douyinpayClient = mock(DefaultDouyinpayClient.class);
                X509Certificate certificate = mock(X509Certificate.class);
                KeyPair keyPair = loadKeyPair();
                when(douyinpayClient.getSignType()).thenReturn(Constants.SIGN_TYPE_RSA);
                when(douyinpayClient.getPlatformCertificate()).thenReturn(certificate);
                when(douyinpayClient.getMerchantPrivateKey()).thenReturn(keyPair.getPrivate());
                when(certificate.getPublicKey()).thenReturn(keyPair.getPublic());
                when(certificate.getSerialNumber()).thenReturn(new BigInteger("1234", Constants.HEX));

                ApiPartnerAddSplitReceiverResponse expectedResponse = new ApiPartnerAddSplitReceiverResponse();
                expectedResponse.setSubMchid("6020221212167701");
                expectedResponse.setType("MERCHANT_ID");
                expectedResponse.setAccount("6020260126898210");
                expectedResponse.setName(new RsaCryptor().encrypt("合作门店", certificate));
                expectedResponse.setRelationType("STORE");

                DouyinpayResponse<ApiPartnerAddSplitReceiverResponse> response = new DouyinpayResponse<ApiPartnerAddSplitReceiverResponse>(
                                null, 200, null, Collections.<String, String>emptyMap(), null);
                response.setApiResponse(expectedResponse);
                when(douyinpayClient.execute(any(DouyinpayRequest.class), eq(ApiPartnerAddSplitReceiverResponse.class)))
                                .thenReturn(response);

                ApiPartnerAddSplitReceiverRequest request = new ApiPartnerAddSplitReceiverRequest();
                request.setSpMchid("6020221212167701");
                request.setSpAppid("awofz9bncda6w2w4");
                request.setSubMchid("6020221212167702");
                request.setSubAppid("awofz9bncda6w2w4");
                request.setType("MERCHANT_ID");
                request.setAccount("6020260126898210");
                request.setName("合作门店");
                request.setRelationType("STORE");

                ApiPartnerSplitFundPaymentsService service = new ApiPartnerSplitFundPaymentsService.Builder()
                                .douyinpayClient(douyinpayClient).build();

                ApiPartnerAddSplitReceiverResponse actualResponse = service.addSplitReceiver(request);

                ArgumentCaptor<DouyinpayRequest> requestCaptor = ArgumentCaptor.forClass(DouyinpayRequest.class);
                verify(douyinpayClient).execute(requestCaptor.capture(), eq(ApiPartnerAddSplitReceiverResponse.class));
                DouyinpayRequest capturedRequest = requestCaptor.getValue();

                Assert.assertEquals("/v1/trade/profitsharing/receivers/add", capturedRequest.getPath());
                Assert.assertEquals("1234", capturedRequest.getHeaders().get(Constants.DOUYIN_PAY_SERIAL));

                JsonObject body = com.douyinpay.util.GsonUtil.getGson().fromJson(capturedRequest.getBody(),
                                JsonObject.class);
                Assert.assertEquals("6020221212167701", body.get("sp_mchid").getAsString());
                Assert.assertEquals("awofz9bncda6w2w4", body.get("sp_appid").getAsString());
                Assert.assertEquals("6020221212167702", body.get("sub_mchid").getAsString());
                Assert.assertEquals("awofz9bncda6w2w4", body.get("sub_appid").getAsString());
                Assert.assertEquals("MERCHANT_ID", body.get("type").getAsString());
                Assert.assertEquals("6020260126898210", body.get("account").getAsString());
                Assert.assertEquals("STORE", body.get("relation_type").getAsString());
                Assert.assertNotEquals("合作门店", body.get("name").getAsString());
                Assert.assertFalse(capturedRequest.getBody().contains("合作门店"));

                Assert.assertEquals("6020221212167701", actualResponse.getSubMchid());
                Assert.assertEquals("MERCHANT_ID", actualResponse.getType());
                Assert.assertEquals("6020260126898210", actualResponse.getAccount());
                Assert.assertEquals("合作门店", actualResponse.getName());
                Assert.assertEquals("STORE", actualResponse.getRelationType());
        }

        @Test
        public void deleteSplitReceiverShouldUsePartnerFields() {
                DefaultDouyinpayClient douyinpayClient = mock(DefaultDouyinpayClient.class);

                ApiPartnerDeleteSplitReceiverResponse expectedResponse = new ApiPartnerDeleteSplitReceiverResponse();
                expectedResponse.setSubMchid("6020221212167701");
                expectedResponse.setType("MERCHANT_ID");
                expectedResponse.setAccount("6020230307605084");

                DouyinpayResponse<ApiPartnerDeleteSplitReceiverResponse> response = new DouyinpayResponse<ApiPartnerDeleteSplitReceiverResponse>(
                                null, 200, null, Collections.<String, String>emptyMap(), null);
                response.setApiResponse(expectedResponse);
                when(douyinpayClient.execute(any(DouyinpayRequest.class),
                                eq(ApiPartnerDeleteSplitReceiverResponse.class)))
                                .thenReturn(response);

                ApiPartnerDeleteSplitReceiverRequest request = new ApiPartnerDeleteSplitReceiverRequest();
                request.setSpMchid("6020221212167701");
                request.setSpAppid("awofz9bncda6w2w4");
                request.setSubMchid("6020221212167702");
                request.setSubAppid("awofz9bncda6w2w4");
                request.setType("MERCHANT_ID");
                request.setAccount("6020230307605084");

                ApiPartnerSplitFundPaymentsService service = new ApiPartnerSplitFundPaymentsService.Builder()
                                .douyinpayClient(douyinpayClient).build();

                ApiPartnerDeleteSplitReceiverResponse actualResponse = service.deleteSplitReceiver(request);

                ArgumentCaptor<DouyinpayRequest> requestCaptor = ArgumentCaptor.forClass(DouyinpayRequest.class);
                verify(douyinpayClient).execute(requestCaptor.capture(),
                                eq(ApiPartnerDeleteSplitReceiverResponse.class));
                DouyinpayRequest capturedRequest = requestCaptor.getValue();

                Assert.assertEquals("/v1/trade/profitsharing/receivers/delete", capturedRequest.getPath());
                JsonObject body = com.douyinpay.util.GsonUtil.getGson().fromJson(capturedRequest.getBody(),
                                JsonObject.class);
                Assert.assertEquals("6020221212167701", body.get("sp_mchid").getAsString());
                Assert.assertEquals("awofz9bncda6w2w4", body.get("sp_appid").getAsString());
                Assert.assertEquals("6020221212167702", body.get("sub_mchid").getAsString());
                Assert.assertEquals("awofz9bncda6w2w4", body.get("sub_appid").getAsString());
                Assert.assertEquals("MERCHANT_ID", body.get("type").getAsString());
                Assert.assertEquals("6020230307605084", body.get("account").getAsString());

                Assert.assertEquals("6020221212167701", actualResponse.getSubMchid());
                Assert.assertEquals("MERCHANT_ID", actualResponse.getType());
                Assert.assertEquals("6020230307605084", actualResponse.getAccount());
        }

        @Test
        public void parseReceiverNotificationShouldUseNotificationParser() {
                NotificationParser notificationParser = mock(NotificationParser.class);

                ApiPartnerSplitReceiverNotification expectedNotification = new ApiPartnerSplitReceiverNotification();
                expectedNotification.setSpMchid("6020230301343900");
                expectedNotification.setSubMchid("6020240806234773");
                expectedNotification.setTradeNo("4200009876202603181234567891");
                expectedNotification.setOutOrderNo("SPLIT20260318143001");
                expectedNotification.setOrderId("P20260318143015259300001");
                expectedNotification.setSuccessTime("2026-03-18T14:30:20+08:00");
                PartnerReceiverInfoDto receiver = new PartnerReceiverInfoDto();
                receiver.setAmount(5000);
                receiver.setDescription("分账到商户");
                receiver.setType("MERCHANT_ID");
                receiver.setAccount("6020230301343998");
                expectedNotification.setReceiver(receiver);

                RequestParam requestParam = new RequestParam.Builder()
                                .body("{\"resource\":{}}")
                                .serialNumber("serial")
                                .signature("signature")
                                .timestamp("1710000000")
                                .nonce("nonce")
                                .build();

                when(notificationParser.parse(any(RequestParam.class), eq(ApiPartnerSplitReceiverNotification.class)))
                                .thenReturn(expectedNotification);

                ApiPartnerSplitFundPaymentsService service = new ApiPartnerSplitFundPaymentsService.Builder()
                                .douyinpayClient(null).build();

                ApiPartnerSplitReceiverNotification actualNotification = service.parseReceiverNotification(requestParam,
                                notificationParser);

                verify(notificationParser).parse(requestParam, ApiPartnerSplitReceiverNotification.class);
                Assert.assertEquals("6020230301343900", actualNotification.getSpMchid());
                Assert.assertEquals("6020240806234773", actualNotification.getSubMchid());
                Assert.assertEquals("4200009876202603181234567891", actualNotification.getTradeNo());
                Assert.assertEquals("SPLIT20260318143001", actualNotification.getOutOrderNo());
                Assert.assertEquals("P20260318143015259300001", actualNotification.getOrderId());
                Assert.assertEquals("2026-03-18T14:30:20+08:00", actualNotification.getSuccessTime());
                Assert.assertEquals(Integer.valueOf(5000), actualNotification.getReceiver().getAmount());
                Assert.assertEquals("分账到商户", actualNotification.getReceiver().getDescription());
                Assert.assertEquals("MERCHANT_ID", actualNotification.getReceiver().getType());
                Assert.assertEquals("6020230301343998", actualNotification.getReceiver().getAccount());
        }

        private PublicKey loadPublicKey() throws Exception {
                KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
                keyPairGenerator.initialize(2048);
                KeyPair keyPair = keyPairGenerator.generateKeyPair();
                byte[] keyBytes = keyPair.getPublic().getEncoded();
                return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(keyBytes));
        }

        private KeyPair loadKeyPair() throws Exception {
                KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
                keyPairGenerator.initialize(2048);
                return keyPairGenerator.generateKeyPair();
        }
}
