/**
 * 用户登录
 */
function login() {
	var username = $('#username').val();
	var password = $('#password').val();
	if(username == null || username.length == 0|| password == null || password.length == 0) {
		alert('用户名和密码不能为空！');
		return;
	}
	
	$.ajax({
		type: 'post',//请求方式
		url: 'loginServlet',//请求地址
		data: {'username':username, 'password': password},
		error: function() {//返回失败
			alert('登录失败！');
		},
		success: function(data) {//返回成功执行回调函数
			if(data == -1) {
				alert('用户名和密码不能为空！');
			} else if(data == -2) {
				alert('用户不存在！');
			} else if(data == -3) {
				alert('用户名或密码错误！');
			} else {
				window.location.href = 'index.jsp';
			}
		}
	});
} 