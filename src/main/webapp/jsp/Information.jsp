<html>
	<head>
		<title>Information</title>
	</head>
	<body>
		<table align="center">
		<%String username = (String)request.getSession().getAttribute("username");%>
		<td>
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
		</td>
		<td><a href="/practice/practice">登录</a></td>
		<td><a href="?action=logout">注销</a></td>
		<td><a href="/practice/register">注册</a><br/></td>	
	</table>
		

	</body>
</html>
