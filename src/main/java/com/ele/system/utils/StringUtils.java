package com.ele.system.utils;

import java.util.UUID;

/**
 * 
 * @author wangping-ds5
 *
 */
public class StringUtils {
	
	/**
	 * 基于uuid生成纯英文字母的随机数
	 * @return
	 */
	public static String getUUIDCode(){
		UUID ui = UUID.randomUUID();
		return ui.toString().replaceAll("-", "");
	}
	
	/**
	 * 判断字符串是否不为NULL和空串。
	 * 
	 * @param str
	 *            字符串
	 * @return boolean
	 */
	public static boolean notEmpty(String str) {
		return str != null && str.trim().length() > 0;
	}
	
	/**
	 * 判断字符串是否为NULL和空串。
	 * 
	 * @param str
	 *            字符串
	 * @return boolean
	 */
	public static boolean isEmpty(String str) {
		return !notEmpty(str);
	}
	
	/**
	 * 判断字符串是否为纯数字
	 * @param pStr
	 * @return
	 */
	public static boolean isNumber(String pStr) {
		return pStr.matches("\\d+");
	}

}
