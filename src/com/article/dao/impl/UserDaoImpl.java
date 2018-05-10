package com.article.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.article.bean.User;
import com.article.dao.UserDao;
import com.article.util.DBUtils;

public class UserDaoImpl implements UserDao {

	/**
	 * 根据用户名查询用户信息
	 */
	@Override
	public User getUserByUsername(String username) {
		Connection conn = DBUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		
		String sql = "select * from t_user where username = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setId(rs.getString("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setPhoto(rs.getString("photo"));
				user.setEmail(rs.getString("sex"));
				user.setAddress(rs.getString("address"));
				user.setDescription(rs.getString("description"));
				user.setAge(rs.getInt("age"));
				user.setIsDelete(rs.getString("is_delete"));
				user.setCreateTime(rs.getTimestamp("create_time"));
				user.setModifyTime(rs.getString("modify_time"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * 用户注册
	 */
	public int insert(String id, String username, String password) {
		Connection conn = DBUtils.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into t_user(id, username, password) values(?, ?, ?)";
		int row = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, username);
			ps.setString(3, password);
			row = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
