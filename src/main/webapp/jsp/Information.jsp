<html>
	<head>
		<title>Information</title>
	</head>
	<body>
		<%String username = (String)request.getSession().getAttribute("username");%>

		<h2><%=username%></h2>

	</body>
</html>
