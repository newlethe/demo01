package com.zh.test;

import java.util.*;
import java.util.Map.Entry;

/**
 * 类说明
 * 
 * @author zhangh
 * @version 创建时间：2016年4月15日 上午1:07:32
 */
public class Test {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap();
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> en = (Entry<String, String>) it.next();
			String key = en.getKey();
			String val = en.getValue();
		}

	}
}
