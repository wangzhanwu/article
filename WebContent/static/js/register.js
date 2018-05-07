/**
 * 用户注册
 * */
function register() {
	var username = $('#username').val();
	var password = $('#password').val();
	var repassword = $('#repassword').val();
	
	if(username == null || username.length == 0) {
		alert('用户名不能为空！');
		return false;
	}
	if(password == null || password.length == 0) {
		alert('密码不能为空！');
		return false;
	}
	if(/^[\w]{6,20}$/g.test(password) == false) {
		alert('只能输入6-20位的数字、字母、下划线！');
		return false;
	}
	if(repassword == null || repassword.length == 0) {
		alert('请再次输入密码');
		return false;
	}
	if(password != repassword) {
		alert("两次输入密码不一致！");
		return false;
	}
	
	$.ajax({
		type: 'post',
		url: 'registerServlet',
		data: {'username': username, 'password': password},
		error: function() {
			alter('注册失败！');
		},
		success: function(data) {
			if(data == -1) {
				alert('用户名和密码不能为空！');
			} if(data == -2) {
				alert('用户名已存在！');
			} if(data == -3) {
				alert("只能输入6-20位的字母、数字、下划线！");
			} else {
				if(confirm('注册成功！')) {
					window.location.href = 'login.jsp';
				}
			}
		}
	});
}

/**
 * 检查用户名称是否被占用
 */
function checkIsExist(mine) {
	var username = $(mine).val();
	if(username == null || username.length == 0) return false; 
	$.ajax({
		type: 'post',//请求方式
		url: 'checkIsExistServlet',//请求地址
		data: {'username':username},
		success: function(data) {//返回成功执行回调函数
			if(data == 1) {
				$(mine).css({
					'color':'red',
				});
				$(mine).parent().css({
					'border':'solid 1px red',
				});
				$(mine).parent().next().find('span').html('用户名已被占用');
				$(mine).parent().next().show();
			} else {
				$(mine).css({
					'color':'#ccc',
				});
				$(mine).parent().css({
					'border':'solid 1px #ccc',
				});
				$(mine).parent().next().hide();
			}
		}
		
	});
}

/**
 * 校验密码
 * @param mine
 */
function checkPassword(mine) {
	var password = $(mine).val();
	var reg = /^[\w]{6,20}$/g;//正则表达式的简写形式，这种形式不加引号。还可以用RegExp对象声明正则表达式。
	if(reg.test(password) == false) {//！reg.test(password)在前面加感叹号不能取反（不知道为什么），只好用==的方式来判断
		$(mine).css({
			'color':'red',
		});
		$(mine).parent().css({
			'border':'solid 1px red',
		});
		$(mine).parent().next().find('span').html('只能输入6-20位的字母、数字、下划线');
		$(mine).parent().next().show();
	} else {
		$(mine).css({
			'color':'#ccc',
		});
		$(mine).parent().css({
			'border':'solid 1px #ccc',
		});
		$(mine).parent().next().hide();
	}
}

function checkRepassword(mine) {
	var repassword = $(mine).val();
	var password = $('#password').val();
	if(password != repassword) {
		$(mine).css({
			'color':'red',
		});
		$(mine).parent().css({
			'border':'solid 1px red',
		});
		$(mine).parent().next().find('span').html('两次输入的密码不一致');
		$(mine).parent().next().show();
	} else {
		$(mine).css({
			'color':'#ccc',
		});
		$(mine).parent().css({
			'border':'solid 1px #ccc',
		});
		$(mine).parent().next().hide();
	}
}


