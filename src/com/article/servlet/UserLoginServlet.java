package com.article.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.article.bean.User;
import com.article.dao.UserDao;
import com.article.dao.impl.UserDaoImpl;

/**
 * 用户登录
 * @author WZW
 * @version 1.0 2018年5月5日 下午6:10:30
 *
 */
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// 用户名和密码不能为空
		if(username == null || username.length() == 0 || password == null || password.length() == 0) {
			out.write("-1");//错误码-1   用户名和密码不能为空
			return;//结束程序，若果不添加该语句程序会继续向下执行，直到程序执行完毕
		}
		UserDao userDao = new UserDaoImpl();
		User user = userDao.getUserByUsername(username);
		//判断用户名是否存在
		if(user == null) {
			out.write("-2");//错误码-2   用户不存在
			return;
		} else {
			//如果用户名存在，验证用户名和密码是否匹配
			if(!Objects.equals(username, user.getUsername())  || !Objects.equals(password, user.getPassword())) {
				out.write("-3");//错误码-3  用户名或密码错误
				return;
			} else {
				//用户存在且账号密码正确，将use放入session
				out.write("1");
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				session.setAttribute("username", user.getUsername());
			}
		}
	}

}
 