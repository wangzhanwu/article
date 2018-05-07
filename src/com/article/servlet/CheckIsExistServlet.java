package com.article.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.article.bean.User;
import com.article.dao.UserDao;
import com.article.dao.impl.UserDaoImpl;

public class CheckIsExistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		
		UserDao userDao = new UserDaoImpl();
		User user = userDao.getUserByUsername(username);
		if(user != null) {
			PrintWriter out = response.getWriter();
			out.write("1");//用户名已存在
		}
				
	}

}
 