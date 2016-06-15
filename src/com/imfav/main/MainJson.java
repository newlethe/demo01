package com.imfav.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;



public class MainJson {
	
	public static void main(String[] args) {
		
		// 全部
		String baiduImageUrl = "http://image.baidu.com/data/imgs?col=%E7%BE%8E%E5%A5%B3&tag=%E5%85%A8%E9%83%A8&sort=0&tag3=&pn=0&rn=60&p=channel&from=1";
		try {
			URLConnection connection = null;
			connection = new URL(baiduImageUrl).openConnection();
			connection.connect();
			InputStream fin = connection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(fin));
			StringBuffer buffer = new StringBuffer();
			String temp = null;
			while ((temp = br.readLine()) != null) {
				buffer.append(temp);
			}
			System.out.println("1>>"+buffer.toString());
			
//			JSONObject jsonObject = JSONObject.fromObject(buffer.toString());
			JSONObject jsonObject = JSONObject.parseObject(buffer.toString());
			System.out.println("2>>"+jsonObject);
			System.out.println(jsonObject.get("col"));
			System.out.println(jsonObject.get("tag"));
			System.out.println(jsonObject.get("tag3"));
			System.out.println(jsonObject.get("sort"));
			System.out.println(jsonObject.get("totalNum"));
			System.out.println(jsonObject.get("startIndex"));
			System.out.println(jsonObject.get("returnNumber"));
			System.out.println(jsonObject.get("imgs"));
			
//			JSONArray jsonArray = JSONArray.fromObject(jsonObject.get("imgs"));
			JSONArray jsonArray = JSONArray.parseArray(jsonObject.getString("imgs"));
			System.out.println(jsonArray);
			
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject obj = jsonArray.getJSONObject(i);
//				System.out.println(i+">>>>"+obj);
//				System.out.println(i+">>>>"+(obj.containsKey("imageUrl") ? obj.getString("imageUrl") : ""));
				System.out.println(obj.containsKey("objUrl") ? "<img src=\""+obj.getString("objUrl")+"\"><br>" : "");
				//obj.get("key");// key...
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
