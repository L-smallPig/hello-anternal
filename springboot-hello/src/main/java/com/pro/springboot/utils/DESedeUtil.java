package com.pro.springboot.utils;

/**
 * Created by Administrator on 2016/11/18.
 */

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.Key;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据机密工具类
 */
public class DESedeUtil {
    private static final String DESede = "DES";
    private Key key;

    public DESedeUtil(String str) {
        this.setKey(str);
    }

    public DESedeUtil() {
        this.setKey("123abc.*");
    }

    public void setKey(String strKey) {
        try {
            SecretKeyFactory e = SecretKeyFactory.getInstance("DES");
            this.key = e.generateSecret(new DESKeySpec(strKey.getBytes("UTF8")));
        } catch (Exception var3) {
            throw new RuntimeException("Error initializing SqlMap class. Cause: " + var3);
        }
    }

    public String jiami(String strMing) {
        Object byteMi = null;
        Object byteMing = null;
        String strMi = "";
        BASE64Encoder base64en = new BASE64Encoder();

        try {
            byte[] byteMing1 = strMing.getBytes("UTF-8");
            Object e = null;

            Cipher cipher;
            byte[] e1;
            try {
                cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
                cipher.init(1, this.key, SecureRandom.getInstance("SHA1PRNG"));
                e1 = cipher.doFinal(byteMing1);
            } catch (Exception var19) {
                throw new RuntimeException("Error initializing SqlMap class. Cause: " + var19);
            } finally {
                cipher = null;
            }

            strMi = base64en.encode(e1);
        } catch (Exception var21) {
            throw new RuntimeException("Error initializing SqlMap class. Cause: " + var21);
        } finally {
            base64en = null;
            byteMi = null;
        }

        return strMi;
    }

    public String jiemi(String strMi) {
        BASE64Decoder base64De = new BASE64Decoder();
        Object byteMing = null;
        Object byteMi = null;
        String strMing = "";

        try {
            byte[] byteMi1 = base64De.decodeBuffer(strMi);
            Object byteFina = null;

            Cipher e;
            byte[] byteFina1;
            try {
                e = Cipher.getInstance("DES/ECB/PKCS5Padding");
                e.init(2, this.key, SecureRandom.getInstance("SHA1PRNG"));
                byteFina1 = e.doFinal(byteMi1);
            } catch (Exception var19) {
                throw new RuntimeException("Error initializing SqlMap class. Cause: " + var19);
            } finally {
                e = null;
            }

            strMing = new String(byteFina1, "UTF8");
        } catch (Exception var21) {
            throw new RuntimeException("Error initializing SqlMap class. Cause: " + var21);
        } finally {
            base64De = null;
            byteMi = null;
        }

        return strMing;
    }

    private byte[] getEncCode(byte[] byteS) {
        Object byteFina = null;

        Cipher cipher;
        byte[] byteFina1;
        try {
            cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(1, this.key, SecureRandom.getInstance("SHA1PRNG"));
            byteFina1 = cipher.doFinal(byteS);
        } catch (Exception var8) {
            throw new RuntimeException("Error initializing SqlMap class. Cause: " + var8);
        } finally {
            cipher = null;
        }

        return byteFina1;
    }


    /**
     * 日志保存请求参数头部
     */
    public static final String LOG_XML_HEAD = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ws=\"http://ws.access.hai/\">\n" +
            " <soapenv:Header/>\n"+
            "  <soapenv:Body>\n" +
            "   <ws:invoke>\n";

    /**
     *  日志保存请求参数尾部
     */
    public static final String LOG_XML_TAIL = "   </ws:invoke>\n" +
            "  </soapenv:Body>\n" +
            "</soapenv:Envelope>";

    private static String getRequestParams(Map<String, Object> params)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(LOG_XML_HEAD);
        sb.append("    <service>saveAccessWarningLog</service>\n");
        sb.append("    <urid/>\n");
        sb.append("    <pwd/>\n");
        sb.append("     <parameter>\n");
        sb.append("     <![CDATA[ \n");
        sb.append("     <BSxml> \n");
        sb.append("       <syslog> \n");
        sb.append("       <user>c3lzdGVt</user> \n");
        sb.append("       <password>YnNvZnRAMTIz</password> \n");
        sb.append("       <idCard>" + params.get("idcard") + "</idCard> \n");
        sb.append("       <organizationcode>" + params.get("sys_organ_code") + "</organizationcode> \n");
        sb.append("       <docid>" + params.get("openid") + "</docid> \n");
        sb.append("       <docidcard>" + params.get("idCardNo") + "</docidcard> \n");  // 解密的身份证号码
        sb.append("       <docname>" + params.get("opeName") + "</docname> \n");
        sb.append("       <datasource>" + params.get("sys_code") + "</datasource> \n");
        sb.append("       <viewreason>健康档案调阅</viewreason> \n");
        sb.append("       <organizationname>南京市溧水区卫生健康委员会</organizationname> \n");
        sb.append("       </syslog> \n");
        sb.append("     </BSxml> \n");
        sb.append("     ]]> \n");
        sb.append("     </parameter>\n");
        sb.append(LOG_XML_TAIL);
        return sb.toString();
    }

    public static void main(String[] args) {
        //String s = "{\"credentialType\":\"1\",\"credentialNum\":\"420526197503271824\",\"name\":\"邹学艳\",\"hoscode\":\"3304830105\",\"medicalNum\":\"100193\",\"treatBeginDate\":\"20140116\",\"treatEndDate\":\"20140116\",\"ichosNo\":\"12\",\"type\":2,\"pageNum\":1}";
//        String s = "320111201108126423";
//        System.out.println(new DESedeUtil("17780c4e4e376e40f1e5d7ec4916e44f").jiami(s));
//        String ss = "2017-03-06 18:37:21";
//        System.out.println(new DESedeUtil("17780c4e4e376e40f1e5d7ec4916e44f").jiami(ss));
//        String sss = "2017-03-07 18:37:21";
//        System.out.println(new DESedeUtil("17780c4e4e376e40f1e5d7ec4916e44f").jiami(sss));
//        String ssss = "0.9%氯化钠注射液(直立式),,,;";
//        System.out.println(new DESedeUtil("17780c4e4e376e40f1e5d7ec4916e44f").jiami(ssss));
//        /*String ss = "sZa0I1Dy1rGZZTpuIhnteSonT3/QvBwBx7dSJyPGYZTgeeFjV43DrklG8uD8UppD/CAViIRr7CT0\n" +
//                "X/A+6gUg8zOc5WrBG5694mBKkWaAjRDssD3DrXtbp7ORSWdCgOTp2tlu1i27a3KaqqZvUVPcqvke\n" +
//                "I5ZkBRz4/4FCn0pgQGsl01y0EyvKDXcJkwLIg7uo4+vKU6XKZvF2D8Zlq1Sh6NKFh/v+QYBkzf2U\n" +
//                "5YQ4189yTpn4BYIb+eAR8G97xEnN5VA9NSEylRZZrbtrFJaMw7Le7IzxdkZ+";*/
//        String sssss = "4uebB0zj5bcQB7Y0T9c1mg==";
//        System.out.println(new DESedeUtil("17780c4e4e376e40f1e5d7ec4916e44f").jiemi(sssss));
        Map<String, Object> params = new HashMap<>();
        params.put("idcard","111");
        params.put("sys_organ_code","1111");
        params.put("openid","111");
        params.put("idCardNo","111");
        params.put("opeName","111");
        params.put("sys_code","11");
        System.out.println(getRequestParams(params));
    }
}

