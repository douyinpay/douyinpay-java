package com.douyinpay.util;

import com.douyinpay.component.crypto.Sm2Verifier;
import com.douyinpay.define.Constants;
import org.bouncycastle.asn1.x500.X500NameBuilder;
import org.bouncycastle.asn1.x500.style.BCStyle;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.pkcs.PKCS10CertificationRequestBuilder;
import org.bouncycastle.pkcs.jcajce.JcaPKCS10CertificationRequestBuilder;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemWriter;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class PemUtilTest {

    @Test
    public void testFixSignatureEncoding() throws IOException {
        byte[] RzeroSig= Sm2Verifier.fixSignatureEncoding(new byte[]{
                48, 68,
                2, 32, 0, 16, 107, 26, 113, -72, 76, 36, 69, -70, 108, -74, 67, 91, 16, -117, 44, 32, 70, -9, 98, 90, 34, -60, -53, 105, -49, -105, 31, 108, -51, -89,
                2, 32, 126, -22, -118, 99, 89, -127, -28, 8, 125, -10, -3, -49, -9, -74, 100, 58, 45, -30, -50, -23, 80, 97, -47, 54, -122, -60, 75, 119, -99, -119, -88, 68
        });
       byte[] SzeroSig= Sm2Verifier.fixSignatureEncoding(new byte[]{
                48, 68,
                2, 32, 126, 16, 107, 26, 113, -72, 76, 36, 69, -70, 108, -74, 67, 91, 16, -117, 44, 32, 70, -9, 98, 90, 34, -60, -53, 105, -49, -105, 31, 108, -51, -89,
                2, 32, 0, 16, -118, 99, 89, -127, -28, 8, 125, -10, -3, -49, -9, -74, 100, 58, 45, -30, -50, -23, 80, 97, -47, 54, -122, -60, 75, 119, -99, -119, -88, 68
        });
    }


    @Test
    public void testRsaCSR() {
        try {

            String rsaKeyPath = "src/test/rsa/doupay.req.pem";
            String rsaPrivateKeyPath = "src/test/rsa/doupay.key.pem";
            //参数需要替换成商户自己相关信息
            createCsrFile();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 创建私钥和csr文件
     *
     * @throws Exception
     */
    public void createCsrFile() throws Exception {
        String rsaKeyPath = "src/test/rsa/doupay.req.pem";
        String rsaPrivateKeyPath = "src/test/rsa/doupay.key.pem";
        String rsaPublicKeyPath = "src/test/rsa/doupay.pub.pem";


        Files.createDirectories(Paths.get("src/test/rsa"));

        //1.创建密钥对
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(Constants.SIGN_TYPE_RSA);
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();


        X500NameBuilder localX500NameBuilder = new X500NameBuilder(BCStyle.INSTANCE);
        localX500NameBuilder.addRDN(BCStyle.C, "CN");  //国家：默认中国
        localX500NameBuilder.addRDN(BCStyle.O, "抖音支付科技有限公司"); //默认不需要修改

        org.bouncycastle.asn1.x500.X500Name localX500Name = localX500NameBuilder.build();

        // 使用私钥和 SHA256WithRSA/SM3withSM2 算法创建签名者对象
        ContentSigner signer = new JcaContentSignerBuilder("SHA256WithRSA")
                .setProvider(new BouncyCastleProvider())
                .build(keyPair.getPrivate());

        // 创建 CSR
        PKCS10CertificationRequestBuilder builder = new JcaPKCS10CertificationRequestBuilder(localX500Name, keyPair.getPublic());
        PKCS10CertificationRequest csr = builder.build(signer);

        //2.生成本地文件CSR
        try (FileWriter fileWriter = new FileWriter(rsaKeyPath)) {
            PemWriter pemWriter = new PemWriter(fileWriter);
            PemObject pem = new PemObject("CERTIFICATE REQUEST", csr.getEncoded());
            pemWriter.writeObject(pem);
            pemWriter.close();

        } catch (IOException e) {
            throw e;
        }

        //3.生成本地文件私钥
        try (FileWriter fileWriter = new FileWriter(rsaPrivateKeyPath)) {
            PemWriter pemWriter = new PemWriter(fileWriter);
            PemObject pem = new PemObject("PRIVATE KEY", keyPair.getPrivate().getEncoded());
            pemWriter.writeObject(pem);
            pemWriter.close();

        } catch (IOException e) {
            throw e;
        }

        //4.生成本地文件公钥
        try (FileWriter fileWriter = new FileWriter(rsaPublicKeyPath)) {
            PemWriter pemWriter = new PemWriter(fileWriter);
            PemObject pem = new PemObject("PUBLIC KEY", keyPair.getPublic().getEncoded());
            pemWriter.writeObject(pem);
            pemWriter.close();

        } catch (IOException e) {
            throw e;
        }


    }


}
