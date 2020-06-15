package com.incomehigher;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpUtils {

	 // 创建httpclient实例
    private static CloseableHttpClient httpclient = HttpClients.createDefault();
	
    
    public static String  httpContent(String url) throws ClientProtocolException, IOException {
        // 创建httpget实例
        HttpGet httpget = new HttpGet(url);
        // 模拟浏览器 ✔
        httpget.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
        // 执行get请求
        CloseableHttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
        // 获取返回实体
        String content = EntityUtils.toString(entity, "utf-8");
        return content;
	}
    	
    
	public static String  httpContent(String url,HttpProxy proxy) throws ClientProtocolException, IOException {
        // 创建httpget实例
        HttpGet httpget = new HttpGet(url);
        // 模拟浏览器 ✔
        httpget.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
        if (proxy!=null) {
          // 使用代理 IP ✔
            HttpHost httpHost = new HttpHost(proxy.getIp(),proxy.getPort());
            RequestConfig config = RequestConfig.custom().setProxy(httpHost)
                    //设置连接超时 ✔
                    .setConnectTimeout(10000) // 设置连接超时时间 10秒钟
                    .setSocketTimeout(10000) // 设置读取超时时间10秒钟
                    .build();
            httpget.setConfig(config);
		}

        // 执行get请求
        CloseableHttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
        // 获取返回实体
        String content = EntityUtils.toString(entity, "utf-8");
        return content;
	}
}
