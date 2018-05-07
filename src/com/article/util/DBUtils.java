package com.article.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库工具类
 * @author WZW
 * @version 1.0 2018年5月3日 下午10:31:44
 *
 */
public class DBUtils {

	private static String username;
	private static String password;
	private static String driver;
	private static String url;
	
	static {
		config("jdbc.properties");
	}
	
	/**
	 * 读取配置文件中的数据库信息
	 * @param path
	 */
	public static void config(String path) {
		InputStream is = DBUtils.class.getClassLoader().getResourceAsStream(path);
		Properties p = new Properties();
		try {
			p.load(is);
			username = p.getProperty("username");
			password = p.getProperty("password");
			driver = p.getProperty("driver");
			url = p.getProperty("url");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭资源
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public static void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		Connection conn = getConnection();
		System.out.println(conn);
	}
}
