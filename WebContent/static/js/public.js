/**
 * 登录
 */
function login() {
	window.location.href = 'login.jsp';
}

/**
 * 注册
 */
function register() {
	window.location.href = 'register.jsp';
}

/**
 * 退出
 */
function logout() {
	if(confirm('确认退出？')) {
		var xmlhttp;
		//创建XMLHttpRequest对象
		if(window.XMLHttpRequest) {
			 //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
			xmlhttp = new XMLHttpRequest();
		} else {
			// IE6, IE5 浏览器执行代码
			xmlhttp = new ActiveXObject('Microsoft.XMLHTTP');
		}
		
		xmlhttp.onreadystatechange = function() {
			if(xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				window.location.href = 'login.jsp';
			}
		}
		xmlhttp.open('get', 'logoutServlet', true);
		xmlhttp.send();
	}
}

function loadData() {
	
}