<html>
	<head>
		<title>admin Register success</title>
		<meta http-equiv="refresh" content="5; url=/practice/manage">
	</head>
	<body>
		<%
			String username = request.getParameter("username");
		%>
		<p align=center>添加为<%=username%>管理员成功</p>
	</body>
</html>
