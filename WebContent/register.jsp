<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/common.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>注册界面</title>
		<link rel="stylesheet" href="${basePath }/static/css/reset.css" />
		<link rel="stylesheet" href="${basePath }/static/css/common.css" />
		<link rel="stylesheet" href="${basePath }/static/css/font-awesome.min.css" />
	</head>
	<body>
		<div class="wrap login_wrap">
			<div class="content">
				
				<div class="logo"></div>
				
				<div class="login_box">	
					
					<div class="login_form">
						<div class="login_title">
							注册
						</div>
						<form action="#" method="post">
							
							<div class="form_text_ipt">
								<input id="username" name="username" type="text" placeholder="手机号/邮箱/用户名" onkeyup="checkIsExist(this)">
							</div>
							<div class="ececk_warning"><span>手机号/邮箱不能为空</span></div>
							<div class="form_text_ipt">
								<input id="password" name="password" type="password" placeholder="密码" onblur="checkPassword(this)">
							</div>
							<div class="ececk_warning"><span>密码不能为空</span></div>
							<div class="form_text_ipt">
								<input id="repassword" name="repassword" type="password" placeholder="重复密码" onblur="checkRepassword(this)">
							</div>
							<div class="ececk_warning"><span>密码不能为空</span></div>
							<!-- <div class="form_text_ipt">
								<input name="code" type="text" placeholder="验证码">
							</div>
							<div class="ececk_warning"><span>验证码不能为空</span></div> -->
							
							<div class="form_btn">
								<button type="button" onclick="register()">注册</button>
							</div>
							<div class="form_reg_btn">
								<span>已有帐号？</span><a href="login.jsp">马上登录</a>
							</div>
						</form>
						<div class="other_login">
							<div class="left other_left">
								<span>其它登录方式</span>
							</div>
							<div class="right other_right">
								<a href="#"><i class="fa fa-qq fa-2x"></i></a>
								<a href="#"><i class="fa fa-weixin fa-2x"></i></a>
								<a href="#"><i class="fa fa-weibo fa-2x"></i></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="${basePath }/static/js/jquery.min.js" ></script>
		<script type="text/javascript" src="${basePath }/static/js/common.js" ></script>
		<script type="text/javascript" src="${basePath }/static/js/register.js" ></script>
		<div style="text-align:center;"></div>
	</body>
</html>
