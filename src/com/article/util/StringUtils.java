package com.article.util;

/**
 * 字符串工具类
 * @author WZW
 * @version 1.0 2018年5月10日 下午3:50:07
 *
 */
public class StringUtils {

	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || "".equals(str) || str.matches("\\s*");
	}
	
	/**
	 * 给字符串设置默认值
	 * @param content
	 * @param defaultValue
	 * @return
	 */
	public static String defaultValue(String content, String defaultValue) {
		if(isEmpty(content)) {
			return defaultValue;
		}
		return content;
	}
}
