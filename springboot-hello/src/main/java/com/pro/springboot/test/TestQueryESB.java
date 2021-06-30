package com.pro.springboot.test;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName TestQueryESB
 * @Description 测试esb提供的接口
 * @Author liguangyue
 * @Date 2021/3/29 16:01
 * @Version 1.0
 **/
public class TestQueryESB {

    /**
     * 日志对象
     */
    private static final Logger log = LoggerFactory.getLogger(TestQueryESB.class);

    /**
     * 字符编码
     */
    public static final String UTF_8 = "UTF-8";

    /**
     * content_type
     */
    public static final String CONTENT_TYPE = "Content-Type";

    /**
     * content_type_value
     */
    public static final String CONTENT_TYPE_VALUE = "text/xml;charset=utf-8";

    /**
     * 日志保存访问地址
     */
    public static final String LOG_REQUEST_URL = "http://192.168.10.205:9566/hai/WebServiceEntry?wsdl";

    /**
     * 请求参数头部
     */
    public static final String LOG_XML_HEAD = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ws=\"http://ws.access.hai/\">\n" +
            " <soapenv:Header/>\n"+
            "  <soapenv:Body>\n" +
            "   <ws:invoke>\n";

    /**
     *  请求参数尾部
     */
    public static final String LOG_XML_TAIL = "   </ws:invoke>\n" +
            "  </soapenv:Body>\n" +
            "</soapenv:Envelope>";

    /**
     *
     * @description: 获取httpPost对象
     * @author: liguangyue
     * @param: req 请求参数
     * @return: HttpPost 对象
     * @date: 2021/1/13 14:35
     **/
    private HttpPost getHttpPost(String req)
    {
        HttpPost httpPost = new HttpPost(LOG_REQUEST_URL);
        httpPost.setHeader(CONTENT_TYPE, CONTENT_TYPE_VALUE);
        StringEntity entity = new StringEntity(req, UTF_8);
        httpPost.setEntity(entity);
        return httpPost;
    }

    /**
     *
     * @description: 日志保存参数拼接
     * @author: liguangyue
     * @param: params 传参
     * @return: String
     * @date: 2021/3/11 9:18
     **/
    private static String getRequestParams(Map<String, Object> params)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(LOG_XML_HEAD);
        sb.append("    <service>etjc</service>\n");
        sb.append("    <urid/>\n");
        sb.append("    <pwd/>\n");
        sb.append("     <parameter>\n");
        sb.append("     <![CDATA[ \n");
        sb.append("        {\"beginDate\":\"2021-03-15\",\"endDate\":\"2021-03-29\"}");
        sb.append("     ]]> \n");
        sb.append("     </parameter>\n");
        sb.append(LOG_XML_TAIL);
        return sb.toString();
    }

    /**
     *
     * @description: 保存日志
     * @author: liguangyue
     * @param: params 传参
     * @return: void
     * @date: 2021/3/9 16:22
     **/
    public String queryEsb(Map<String, Object> params)
    {
        String req = getRequestParams(params);
        HttpPost httpPost = getHttpPost(req);
        httpPost.setHeader("SOAPAction", "saveAccessWarningLog");
        try (CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
             CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpPost))
        {
            String result = EntityUtils.toString(closeableHttpResponse.getEntity());
            Document resultDoc = DocumentHelper.parseText(result);
            Element books = resultDoc.getRootElement();
            String resultMsg = books.getStringValue();
            String aa  = "<xmlMsg><row _g=\"1\"><num>0</num></row></xmlMsg>";
            Document doc = DocumentHelper.parseText(resultMsg);
            return doc.getRootElement().getStringValue();
        } catch (Exception e) {
            log.error("查询esb发生错误！");
        }
        return null;
    }


    public String httpPost()
    {

        return null;
    }


    public static Map<String, Object> XmlToMap(String xml) throws DocumentException {
        Document doc = DocumentHelper.parseText(xml);
        Element books = doc.getRootElement();
        System.out.println("rootNode:" + books.getName());
        Iterator Elements = books.elementIterator();
        Map<String, Object> map = new HashMap<>();
        while (Elements.hasNext()) {
            Element user = (Element) Elements.next();
            System.out.println("node=" + user.getName() + "\ttext=" + user.getText());
            map.put(user.getName(), user.getText());
        }


//        if (result != null && !result.equals("")) {
//            Document document = DocumentHelper.parseText(strXml);
//            Element root = document.getRootElement();
//            Element xmlMsg = root.element("xmlMsg");
//            Element row = xmlMsg.element("row");
//            if (row != null) {
//                Element xzTime = row.element("XZTIME");
//                Element yyName = row.element("YYNAME");
//                String strXzTime = xzTime.getTextTrim();
//                String strYyName = yyName.getTextTrim();
//                result.put("xzTime", strXzTime);
//                result.put("yyName", strYyName);
//            }
//        }
        return map;
    }

    public static void main(String[] args) throws DocumentException {
//        TestQueryESB tsb = new TestQueryESB();
//        tsb.queryEsb(new HashMap<>());

//        String value = "<result>\n" +
//                "  <xmlMsg><row _g=\"1\"><num>655</num></row></xmlMsg>\n" +
//                "</result>";
//
//        XmlToMap(value);

//        Map<String,Object> requestParams = new HashMap<>();
//        requestParams.put("beginDate","2021-03-15");
//        requestParams.put("endDate","2021-03-29");
//
//        httpPost("http://192.168.10.205:8528/hai/HttpEntry", JSON.toJSONString(getRequestParams(requestParams)));

        String aa  = "<row _g=\"1\">\n" +
                "<healthno>32010017923706</healthno>\n" +
                "<secondcardno/><idcard/>\n" +
                "<name>刘汐妍</name>\n" +
                "<cardno/>\n" +
                "<checkdate>2020-08-01</checkdate>\n" +
                "<firstcardno>320723199007293263</firstcardno>\n" +
                "</row>";
        Map<String, Object> resultMap = XmlToMap(aa);
        resultMap.get("");
        System.out.println();
    }



    /**
     *
     * @description: HTTP 请求公共方法
     * @author: liguangyue
     * @param: url 请求地址
     * @param requestParams 请求参数
     * @return: String 请求返回结果
     * @date: 2020/12/27 12:48
     **/
    public static String httpPost(String url, String requestParams){
        String retSrc = "";
        try (CloseableHttpClient httpClient = HttpClients.createDefault()){
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(12 * 1000)
                    .setConnectTimeout(12 * 1000)
                    .build();
            HttpPost post = new HttpPost(url);
            post.addHeader("service", "etjc");
            post.setConfig(requestConfig);
            post.setHeader(CONTENT_TYPE,CONTENT_TYPE_VALUE);
            StringEntity postingString = new StringEntity(requestParams, UTF_8);
            post.setEntity(postingString);
            HttpResponse response = httpClient.execute(post);
            retSrc = EntityUtils.toString(response.getEntity());
            System.out.println(retSrc);
        } catch (IOException e) {
            log.warn("请求发生异常！");
        }
        return retSrc;
    }
}
