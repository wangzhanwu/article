<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common/public.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>首页</title>
		<link rel="stylesheet" type="text/css" href="${basePath }/static/css/public.css" />
	</head>
	<body>
		<div id="container">
			<!-- 引入header文件 -->
			<%@ include file="common/header.jsp" %>
			
			<div class="content">
				<div class="category">
					<div class="title">连载小说</div>
					<ul class="items">
						<li class="item">
							<div class="item-banner">
								<div class="item-name">《明朝那些事儿》</div>
								<div class="item-author">当年明月 著</div>
								<div class="item-description">一本精彩的历史书</div>
							</div>
						</li>
						<li class="item"></li>
						<li class="item"></li>
						<li class="clear-float"></li>
					</ul>
				</div>
				<div class="category">
					<div class="title">编程类</div>
					<ul class="items">
						<li class="item"></li>
						<li class="item"></li>
						<li class="item"></li>
						<li class="clear-float"></li>
					</ul>
				</div>
			</div>
			
			<%@include file="common/footer.jsp" %>
		</div>

		<script type="text/javascript" src="${basePath }/static/js/jquery.min.js"></script>
		<script type="text/javascript" src="${basePath }/static/js/public.js"></script>
	</body>
</html>