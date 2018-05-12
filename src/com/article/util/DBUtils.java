package com.article.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.article.bean.User;

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
	
	/**
	 * DML操作（增、删、改）
	 * @param sql
	 * @param objects
	 */
	public static int update(String sql, Object...objects) {
		if(StringUtils.isEmpty(sql)) {
			return 0;
		}
		
		Connection conn = getConnection();
		PreparedStatement ps = null;
		int row = 0;
		try {
			ps = conn.prepareStatement(sql);
			for(int i = 0; i < objects.length; i++) {
				ps.setObject(i+1, objects[i]);
			}
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(conn, ps, null);
		}
		return row;
	}
	
	/**
	 * 查询数据，返回List（查询多条数据）
	 * @param sql
	 * @param objects
	 * @return
	 */
	public static List<Map<String, Object>> queryForList(String sql, Object...objects) {
		if(StringUtils.isEmpty(sql)) {
			return null;
		}
		
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			for(int i = 0; i < objects.length; i++) {
				ps.setObject(i+1, objects[i]);
			}
			rs = ps.executeQuery();
			while(rs.next()) {
				//获取关于 ResultSet对象中列的类型和属性信息的对象
				ResultSetMetaData rsmd = rs.getMetaData();
				//每一行的列数
				int count = rsmd.getColumnCount();
				Map<String, Object> map = new HashMap<String, Object>();
				for(int i = 0; i < count; i++) {
					/*
					 * 列的序号从1开始
					 * 注：如果在sql中给字段取别名，getColumnName()会报错找不到该字段
					 */
					map.put(rsmd.getColumnName(i+1), rs.getObject(rsmd.getColumnName(i+1)));
				}
				result.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(conn, ps, rs);
		}
		return result;
	}
	
	/**
	 * 查询数据，返回Map（查询一条数据）
	 * @param sql
	 * @param objects
	 * @return
	 */
	public static Map<String, Object> queryForMap(String sql, Object...objects) {
		if(StringUtils.isEmpty(sql)) {
			return null;
		}
		List<Map<String, Object>> list = queryForList(sql, objects);
		//查询出多条数据或查询结果为空
		if(list.size() != 1) {
			return null;
		}
		return list.get(0);
	}
	
	/**
	 * 查询数据并返回一个Javabean
	 * @param sql
	 * @param clazz
	 * @param objects
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T>T queryForBean(String sql, Class<?> clazz, Object...objects) {
		if(StringUtils.isEmpty(sql) || clazz == null) {
			return null;
		}
		
		//查询数据
		Map<String, Object> map = queryForMap(sql, objects);
		if(map == null || map.isEmpty()) {
			return null;
		}
		
		T obj = null;
		try {
			obj = (T) clazz.newInstance();//创建一个新的bean
		} catch (InstantiationException | IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		Field field = null;
		for(String column : map.keySet()) {
			Method method = null;
			String property = StringUtils.columnToProperty(column);
			try {
				//获取字段
				field = clazz.getDeclaredField(property);
			} catch (NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
			//获取字段类型
			String fieldType = field.toString().split(" ")[1];
			//获取字段值
			Object value = map.get(column);
			if(value == null) {
				continue;
			}
			
			//获取字段set方法的名字
			String setMethodName = "set"+StringUtils.upperCaseFirstCharacter(property);
			//获取值的类型
			String valueType = value.getClass().getName();
			if(!fieldType.equalsIgnoreCase(valueType)) {
				if(fieldType.equalsIgnoreCase("java.lang.String")) {
					value = String.valueOf(value);
				} else if(fieldType.equalsIgnoreCase("java.lang.Integer")) {
					value = Integer.parseInt(String.valueOf(value));
				} else if(fieldType.equalsIgnoreCase("java.lang.Date")) {
					String date = String.valueOf(value);
					Timestamp ts = Timestamp.valueOf(date);
					value = new Date(ts.getTime());
				}
			}
			
			try {
				//获取set方法
				method = clazz.getDeclaredMethod(setMethodName, Class.forName(fieldType));
				//执行set方法
				method.invoke(obj, value);
			} catch (NoSuchMethodException | SecurityException | ClassNotFoundException  e) {
				e.printStackTrace();
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
				e1.printStackTrace();
			}
		}
		return obj;
	}
	
	
	public static void main(String[] args) throws SQLException, NoSuchFieldException, SecurityException {
		User user = queryForBean("select * from t_user where username = ?", User.class, "wang");
		System.out.println(user);
	}
	

}
