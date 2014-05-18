<%@ com.bodejidi.Member%>
<%
	Member member = (Member) req.getAttribute("member");
%> 
<html>
	<head>
		<title>Information</title>
	</head>
	<body>
		<h1><%= member.getUsername%></h1>

	</body>
</html>
