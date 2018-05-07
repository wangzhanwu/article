package com.article.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.article.bean.User;
import com.article.dao.UserDao;
import com.article.dao.impl.UserDaoImpl;

/**
 * 用户注册
 * @author WZW
 * @version 1.0 2018年5月6日 下午3:29:02
 *
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String id = UUID.randomUUID().toString().replace("-", "");
		
		
		PrintWriter out = response.getWriter();
		//用户名称和密码不能为空
		if(username == null || username.length() == 0 || password == null || password.length() == 0) {
			out.write("-1");//错误码-1  用户名和密码不能为空
		} else {
			UserDao userDao = new UserDaoImpl();
			User user = userDao.getUserByUsername(username);
			if(user != null) {//用户名被占用
				out.write("-2");//错误码：-2    该用户名已存在
			} else {
				//校验密码只能输入6-20位的字母、数字、下划线
				Pattern pattern = Pattern.compile("[\\w]{6,20}");
				Matcher matcher = pattern.matcher(password);
				if(!matcher.find()) {
					out.write("-3");//密码只能输入6-20位的字母、数字、下划线
				} else {
					int row = userDao.insert(id, username, password);
					if(row == 1) {
						out.write("1");//注册成功
					}
				}
				
			}
			
		}
	}
	
	public static void main(String[] args) {
		String id = UUID.randomUUID().toString().replace("-", "");
		
		//校验密码
		Pattern pattern = Pattern.compile("[\\w]{6,20}");
		Matcher matcher = pattern.matcher("12345@");
		System.out.println(matcher.find());
		
	}

}
