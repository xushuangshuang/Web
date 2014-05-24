<html>
	<head>
		<title>Information</title>
	</head>
	<body>
		<%String username = (String)request.getSession().getAttribute("username");%>
		<%
			if(null == username)
			{
		       		out.print("你还没有登录");
				
			}
			else
			{
				out.print("您好  " + username);
			}
		%>
		<a href="/practice/practice">登录</a><br/>
		<form action="display" method="POST">
		<input type="submit" name="action" value="注销"/>
		</form>
		<a href="/practice/register">注册</a><br/>

	</body>
</html>
