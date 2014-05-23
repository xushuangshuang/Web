<html>
	<head>
		<title>Information</title>
	</head>
	<body>
		<%String username = (String)request.getSession().getAttribute("username");%>

		<h2><%=username%></h2>
		<a href="/practice/practice">登录</a><br/>
		<a href="/register/register">注册</a><br/>
		<input type="submit" name="action" value="注销"/>

	</body>
</html>
