<html>
	<head>
		<title>Information</title>
	</head>
	<body>
		<%String username = (String)request.getSession().getAttribute("username");%>
		<h2><%=username%></h2>
		<form action="display" method="POST">
		<input type="submit" name="action" value="注销"/>
		</form>
		<a href="/practice/practice">登录</a><br/>
		<a href="/practice/register">注册</a><br/>

	</body>
</html>
