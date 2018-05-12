package com.article.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.article.util.StringUtils;

/**
 * 用户退出
 * @author WZW
 * @version 1.0 2018年5月12日 下午8:06:49
 *
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		if(!StringUtils.isEmpty(session.getAttribute("username").toString())) {
			session.removeAttribute("username");
			session.removeAttribute("user");
			session.invalidate();
		} else {
			out.write("-5");//用户已退出
		}
		
		
//		String basePath = null;
//		String path = request.getContextPath();
//		int port = request.getServerPort();
//		if(port == 80) {
//			basePath = request.getScheme()+"://"+request.getServerName()+path;
//		} else {
//			basePath = request.getScheme()+"://"+request.getServerName()+":"+port+path;
//		}
//		response.sendRedirect(basePath+"/login.jsp");
	}
	
}
