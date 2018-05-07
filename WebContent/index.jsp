<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>首页</title>
		
		<style>
			*{
				padding:0;
				margin: 0;
				font-family: "微软雅黑";
			}
			.header {
				height: 72px;
				width: 90%;
				margin: 0 auto;
				background: #458fce;
			}
			
			.header .logo {
				color: #ffffff;
				line-height: 72px;
				font-size: 30px;
				margin-left: 20px;
				display: inline-block;
				font-weight: 500;
				float: left;
			}
			
			.header ul li.first {
				margin-left: 30px;
				background: #74b0e2;
			}
			
			.header ul li {
				list-style: none;
				float: left;
				color: #ffffff;
				display: inline-block;
				width: 112px;
				height: 72px;
				text-align: center;
				line-height: 72px;
				cursor: pointer;
			}
			
			.header ul li:hover {
				background: #74b0e2;
			}
			a {
				color: #ffffff;
				text-decoration: none;
			}
			
			.header .login {
				float:right;
				color: #ffffff;
				margin-right: 20px;
				line-height: 72px;
				
			}
		</style>
	</head>
	<body>
		<div class="header">
			<div class="logo">我的博客</div>
			<ul>
				<li class="first"><a href="javascript:void(0)">首页</a></li>
				<li><a href="javascript:void(0)">导航一</a></li>
				<li><a href="javascript:void(0)">导航二</a></li>
				<li><a href="javascript:void(0)">导航三</a></li>
				<li><a href="javascript:void(0)">导航四</a></li>
			</ul>
			
			<div class="login">
				<span><a href="javascript:void(0)">登录</a></span>
				<span>|</span>
				<span><a href="javascript:void(0)">注册</a></span>
			</div>
		</div>
		
	</body>
</html>