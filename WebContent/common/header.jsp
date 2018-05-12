<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
		<c:choose>
			<c:when test="${empty sessionScope.username }">
				<span><a href="javascript:void(0)" onclick="login()">登录</a></span>
				<span>|</span> 
				<span><a href="javascript:void(0)" onclick="register()">注册</a></span>
			</c:when>
			<c:otherwise>
				<span><a href="javascript:void(0)">欢迎您，${sessionScope.username }</a></span>
				<span>|</span> 
				<span><a href="javascript:void(0)" onclick="logout()">退出</a></span>
			</c:otherwise>
		</c:choose>
		
	</div>
</div>