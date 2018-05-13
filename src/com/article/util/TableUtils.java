package com.article.util;

import java.lang.reflect.Field;

import com.article.annotation.Column;
import com.article.annotation.Table;
import com.article.bean.Article;

/**
 * 根据注解给实体类生成SQL
 * @author WZW
 * @version 1.0 2018年5月10日 下午4:55:25
 *
 */
public class TableUtils {

	public static String getCreateTableSQL(Class<?> clazz) {
		StringBuilder sb = new StringBuilder();
		
		//获取表名
		Table table = clazz.getAnnotation(Table.class); //返回此元素上存在的所有注释。
		String tableName = table.tableName();
		sb.append("drop table if exists ").append(tableName).append(";\n");
		sb.append("create table").append(" ");
		sb.append(tableName).append("(\n");
		
		Field[] fields =clazz.getDeclaredFields();//返回一个 Field 对象数组，这些对象反映此 Class 对象所表示的类或接口所声明的所有字段。
		String primaryKey = "";
		
		for(int i=0; i<fields.length; i++) {
			Column column = (Column) fields[i].getDeclaredAnnotations()[0];//返回直接存在于此元素上的所有注释。
			String field = column.field();
			String type = column.type();
			boolean defaultNull = column.defaultNull();
			
			sb.append("\t" + field).append(" ").append(type +" ");
			if(defaultNull) {
				if(type.toUpperCase().equals("TIMESTAMP")) {
					sb.append(",\n");
				} else {
					sb.append("default null,\n");
				}
			} else {
				sb.append("not null,\n");
				if(column.primaryKey()) {
					primaryKey = "primary key("+field+")";
				}
			}
		}
		if(!StringUtils.isEmpty(primaryKey)) {
			sb.append("\t").append(primaryKey);
		}
		sb.append("\n ) ENGINE=InnoDB DEFAULT CHARSET=utf8;");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(getCreateTableSQL(Article.class));
	}
}
