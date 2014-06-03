<html>
	<head>
		<title>personal</title>
	</head>
	<body>
		<%String username =  (String)request.getSession().getAttribute("username");%>
		<p align=center>关于<%=username%>的个人信息</p>
	</body>
</html>
