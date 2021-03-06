package com.pro.springboot.httputils;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.SocketTimeoutException;

public class HttpclientUtil {
	private static final Logger logger = LoggerFactory
			.getLogger(HttpclientUtil.class);
	public static  String sendHttpPost_JSON(String url, String requestParams,String token)
			throws Exception, IOException {
		String content = "";
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(12 * 1000)
                    .setConnectTimeout(12 * 1000)
                    .build();
            HttpPost post = new HttpPost(url);
            post.setConfig(requestConfig);
            post.setHeader("Content-Type","application/json;charset=utf-8");
            StringEntity postingString = new StringEntity(requestParams,"utf-8");
			post.setHeader("X-TOKEN",token);
            post.setEntity(postingString);
            HttpResponse response = httpClient.execute(post);
//            content = EntityUtils.toString(response.getEntity());
//			JSONObject resJson=new JSONObject(content);
//			if(resJson.optString("code").equals("200") || resJson.optString("code").equals("000000")){
//				content = resJson.optString("body");
//			}else{
//	        	logger.error("调用接口失败,url：" + url + ",参数：" + requestParams + ",接口返回：" + content);
////				throw new ServiceException("调用接口失败,url：" + url + ",参数：" + requestParams  + ",接口返回：" + content);
//			}
        } catch (SocketTimeoutException e) {
//        	logger.error("调用接口超时,超时时间：5秒,url：" + url + ",参数：" + requestParams, e);
//			throw new ServiceException("调用接口超时,超时时间：5秒,url：" + url + ",参数：" + requestParams,e);
        } catch (Exception e) {
//        	logger.error("调用接口失败,url：" + url + ",参数：" + requestParams,e);
//			throw new ServiceException("调用接口失败,url：" + url + ",参数：" + requestParams,e);
        }
        return content;
	}
	 public static void main(String[] args) throws Exception {
			String url="http://192.168.10.108:8080/api/invoke";
//			String res = sendHttpPost("{\"serviceId\":\"hms.person\",\"method\":\"getAccessToken\",\"body\":[]}");
//			String res = sendHttpPost_JSON(url,"{\"serviceId\":\"hms.person\",\"method\":\"code\",\"body\":[\"userId=1&token=22222\"]}");
//			System.out.println(res);
    }
}
