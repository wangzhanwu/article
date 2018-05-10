package com.article.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类的注解
 * @author WZW
 * @version 1.0 2018年5月10日 下午4:20:12
 *
 */
@Target(ElementType.TYPE)//注解目标：类
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {

	public String tableName();//表名
}
