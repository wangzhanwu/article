package com.article.util;

import java.io.IOException;

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
	
	/**
	 * 将数据库字段名转换为驼峰命名方式
	 * @param column
	 * @return
	 */
	public static String columnToProperty(String column) {
		
		if(StringUtils.isEmpty(column)) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		//遍历每一个字符
		for(int i = 0; i < column.length(); i++) {
			//匹配到第一个_
			if(column.charAt(i) == '_') {
				//如果后面还有_，也就是连续有多个_
				while(column.charAt(i+1) == '_') {
					i++;
				}
				//将下划线后面的字母转换为大写，拼接到字符串
				sb.append((""+column.charAt(++i)).toUpperCase());
			} else {
				sb.append(column.charAt(i));
			}
			
		}
		return sb.toString();
	}
	
	/**
	 * 将字符串的首字母改成大写
	 * @param str
	 * @return
	 */
	public static String upperCaseFirstCharacter(String str) {
		StringBuilder sb = new StringBuilder();
		//将字符串转换成字符数组
		char[] arr = str.toCharArray();
		for(int i=0; i < arr.length; i++) {
			if(i==0) {
				sb.append((arr[i]+"").toUpperCase());
			} else {
				sb.append(arr[i]);
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(columnToProperty("modify_name"));
	}
}
