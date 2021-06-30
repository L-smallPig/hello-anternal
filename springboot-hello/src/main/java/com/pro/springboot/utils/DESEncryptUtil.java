package com.pro.springboot.utils;


import org.apache.tomcat.util.buf.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.SecureRandom;
import java.util.*;

/**
 * DES对称加密
 */
public class DESEncryptUtil {

    /**
     * DES加密
     * @param plaintext 明文
     * @param secret 8字节密钥，超出部分将被忽略
     * @return 密文
     */
    public static String encrypt(String plaintext, String secret) {
        try {
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            Key key = keyFactory.generateSecret(new DESKeySpec(secret.getBytes(StandardCharsets.UTF_8)));
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] cipherBytes = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(cipherBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * DES解密
     * @param cipherText 密文
     * @param secret 8字节密钥，超出部分将被忽略
     * @return 明文
     */
    public static String decrypt(String cipherText, String secret) {
        try {
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            Key key = keyFactory.generateSecret(new DESKeySpec(secret.getBytes(StandardCharsets.UTF_8)));
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] cipherBytes = Base64.getDecoder().decode(cipherText);
            byte[] plaintext = cipher.doFinal(cipherBytes);
            return new String(plaintext);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 使用种子数产生的密钥DES加密
     * @param plaintext 明文
     * @param seed 种子数
     * @return 密文
     */
    public static String encryptUseSeed(String plaintext, String seed) {
        try {
            KeyGenerator generator = KeyGenerator.getInstance("DES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(seed.getBytes());
            generator.init(secureRandom);
            Key key = generator.generateKey();
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] cipherBytes = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(cipherBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 使用种子数产生的密钥DES解密
     * @param cipherText 密文
     * @param seed 种子数
     * @return 明文
     */
    public static String decryptUseSeed(String cipherText, String seed) {
        try {
            KeyGenerator generator = KeyGenerator.getInstance("DES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(seed.getBytes());
            generator.init(secureRandom);
            Key key = generator.generateKey();
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] cipherBytes = Base64.getDecoder().decode(cipherText);
            byte[] plaintext = cipher.doFinal(cipherBytes);
            return new String(plaintext);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据原作者的意图，当第三方系统调用BHRView接口时，第三方系统首先用DES算法加密timestamp;openid字符串，得到密文sign，作为请求参数。
     * 再由BHRView对比sign加密结果，当双方加密结果一致时，则用户验证通过。然后第三方系统再用Triple DES算法加密其他用户参数，再由BHRView解密
     * 得到所需要的参数。所有密钥均由创业提供，详情请查看接口文档《大数据健康档案浏览器接口调用说明书v1.7.2》。
     *
     * 但是原作者并不熟悉DES和Triple DES加密，实际上，当原作者在加密openid;timestamp字符串时，并不是将openkey直接作为密钥，
     * 而是将openkey作为随机数的种子，再由随机数对象作为参数生成密钥，最后使用标准DES算法加密。当原作者在加密用户参数时，
     * 却直接将key作为密钥，并且没有使用Triple DES算法，而是同样使用标准的DES算法。详情请查看上一次提交的DESUtil.java和DESedeUtil.java
     *
     * @see DESEncryptUtil#decrypt(String, String) 标准DES加密
     * @see DESEncryptUtil#decryptUseSeed(String, String) 使用随机数生成密钥的DES加密
     *
     * 这里不妨将产生密钥的随机数种子openkey称为————随机密钥
     * 将直接作为密钥的key称为————直接密钥
     *
     * 由于上述的原因，当其他编程语言（例如PowerBuilder）系统调用BHRView接口时，由于随机数算法和Java的不同，无法对比sign，导致用户验证失败。
     * 目前已有众多系统对接BHRView，所以无法重写加密方式。
     *
     * 因此，既然所有加密方式都是标准DES加密，就不必要使用两个不同密钥，这里取直接密钥，同时要保证随机密钥加密的结果和直接密钥加密的结果相同，
     * 以后第三方系统再调用接口，就可以使用直接密钥加密所有参数，而忽略随机密钥这个坑。
     *
     * 产生符合条件的密钥的方法如下，运行时长看运气，不再详细阐释。
     *
     * @author qianps
     */
    private static String generateSecret() throws Exception {
        String openkey = "abc*123";
        KeyGenerator generator = KeyGenerator.getInstance("DES");
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(openkey.getBytes());
        generator.init(secureRandom);
        Key key = generator.generateKey();
        byte[] keyBytes = key.getEncoded();

        byte[] abcBytes = new byte[126-33+1];
        for (int i=0; i<abcBytes.length; i++) {
            abcBytes[i] = (byte) (33+i);
        }
        // 可打印字符串
        String abc = new String(abcBytes);
        boolean flag = true;    // 循环标志
        while (flag) {
            flag = false;
            for (byte b : keyBytes) {
                // 可打印字符范围
                if (b < 33 || b > 126) {
                    Random random = new Random();
                    random.setSeed(System.currentTimeMillis());
                    // 生成的openkey最大为16字节
                    char[] chars = new char[random.nextInt(16)];
                    for (int i=0; i<chars.length; i++) {
                        chars[i] = abc.charAt(random.nextInt(abc.length()));
                    }
                    openkey = new String(chars);
                    secureRandom = SecureRandom.getInstance("SHA1PRNG");
                    secureRandom.setSeed(openkey.getBytes());
                    generator.init(secureRandom);
                    key = generator.generateKey();
                    keyBytes = key.getEncoded();
                    flag = true;
                    break;
                }
            }
        }
        System.out.println("openkey:" + "\u001B[31m" + openkey + "\u001B[0m");
        System.out.println("key:" + "\u001B[31m" + new String(key.getEncoded()) + "\u001B[0m");
        return new String(key.getEncoded());
    }

    /**
     * 生成示例url
     * @param secret 密钥
     * @param params 接口参数，以管道符号|连接secret表示参数加密
     */
    private static void generateSample(String secret, String interfaceName ,Map<String, String> params) throws UnsupportedEncodingException {
        String sampleUrl = "http://localhost:8080/BHRView/api/v1/" + interfaceName + "?";
        String openid = params.get("openid");
        String sign = params.get("sign");
        String timestamp = params.get("timestamp");
        String idCard = params.get("idcard");
        if (secret == null || interfaceName == null || openid == null || sign == null || timestamp == null || idCard == null) {
            System.out.println("\u001B[31m参数缺失，请查阅文档！\u001B[0m");
        }
        StringBuilder sb = new StringBuilder(sampleUrl);
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String k = entry.getKey();
            String v = entry.getValue();
            String[] s = v.split("[|]");
            if (s.length > 1 && s[s.length - 1].equals("secret")) {
                v = DESEncryptUtil.encrypt(StringUtils.join(Arrays.copyOf(s, s.length - 1)), secret);
            }
            sb.append(k).append("=").append(URLEncoder.encode(v, "utf-8")).append("&");
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }

    public static void main(String[] args) throws Exception {
        String openid = "bsoft0005";
        String timestamp = String.valueOf(System.currentTimeMillis());
        Map<String, String> param = new HashMap<>();
        param.put("openid", openid);
        param.put("timestamp", timestamp);
        param.put("sign", timestamp+";"+openid+"|secret");
        param.put("idcard", "210203200408080880|secret");
        param.put("sys_organ_code", "1000");
        param.put("sys_code", "2000");
//        String secret = generateSecret();
        generateSample("Tm=4R,v|","getMedicinesPage.do", param);
    }

}
