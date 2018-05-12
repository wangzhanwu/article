package com.article.dao.impl;

import java.util.UUID;

import com.article.bean.User;
import com.article.dao.UserDao;
import com.article.util.DBUtils;

public class UserDaoImpl implements UserDao {

	/**
	 * 根据用户名查询用户信息
	 */
	@Override
	public User getUserByUsername(String username) {
		String sql = "select * from t_user where username = ?";
		User user = DBUtils.queryForBean(sql, User.class, username);
		return user;
	}
	
	/**
	 * 用户注册
	 */
	public int register(String username, String password) {
		//用UUID生成一个32位的字符串
		String id = UUID.randomUUID().toString().replace("-", "");
		//SQL
		String sql = "insert into t_user(id, username, password) values(?, ?, ?)";
		//将注册信息插入数据库
		int row = DBUtils.update(sql, id, username, password);//返回受影响的行数
		return row;
	}
	
	public static void main(String[] args) {
		UserDao userDao = new UserDaoImpl();
		User user = userDao.getUserByUsername("wang");
		if(user!=null) {
			System.out.println(user.getUsername());
		} else {
			System.out.println("user.getUsername()");
		}
	}

}
