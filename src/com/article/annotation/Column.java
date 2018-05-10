package com.article.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 字段的注解
 * @author WZW
 * @version 1.0 2018年5月10日 下午4:11:21
 *
 */
@Target(ElementType.FIELD) //注解目标：变量
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {

	public String field();//字段名称
	public boolean primaryKey() default false;//是否为主键
	public String type() default "varchar(100)";//字段类型
	public boolean defaultNull() default true;//是否为空
}
