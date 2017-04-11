package com.ele.system.utils;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author wangping-ds5
 *
 */
public class BeanUtils {
	
	public static <T> T jsonToBean(String str,Class<T> clazz) {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(str)) return null;
		JSONObject json = JSON.parseObject(str);
		T t = null;
		try {
			t = JSON.toJavaObject(json, clazz);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("待解析的字符串为：str:" + str);
		}
		return t;
	}
	
}
