package com.zl.autism.utils;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSON;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

//网络请求工具
public class AuthUtil {

	public static final String APPID = "";
	public static final String APPSCERET="";
	
	public static JSONObject doGetJson(String url) {
		
		JSONObject jsonObject = null;
		
		CloseableHttpClient client = HttpClientBuilder.create().build();
		
		HttpGet httpGet = new HttpGet(url);
		
		try {
			HttpResponse response = client.execute(httpGet);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String result = EntityUtils.toString(entity,"UTF-8");
				jsonObject =JSON.parseObject(result);
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonObject;
		
	}
	
}
