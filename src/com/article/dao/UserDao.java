package com.article.dao;

import com.article.bean.User;

public interface UserDao {
	
	/**
	 * 根据用户名称查询用户信息
	 * @param username
	 * @return
	 */
	public User getUserByUsername(String username);

	/**
	 * 用户注册
	 * @param id
	 * @param username
	 * @param password
	 */
	public int insert(String id, String username, String password);
}
