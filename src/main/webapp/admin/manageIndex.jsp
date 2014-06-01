<%@page import="com.bodejidi.Member, java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>manageIndex</title>
		<style type="text/css">
  			 a:link,a:visited{text-decoration:none;}
		</style>
	</head>
	<body>
		<%
			String username = (String)request.getSession().getAttribute("adminUsername");
		%>
		<p align=center>欢迎管理员 <%=username%></p>
		<p align=center><a href = "register?action=admin">添加管理员</a></p>
		<p align=center>会员列表</p>	
		<%List<Member> member = (List<Member>)request.getSession().getAttribute("member");%>
		<table align=center borde="1">
			<tr>
				<th>用户名</th>
				<th>状态</th>
			</tr>
			
			<c:forEach var="member" items="${member}">
			
			<tr>
				<td>
					<a href="?action=${member.username}">${member.username}</a>
				</td>
      		   	</tr>
      			</c:forEach>
		</table>
	</body>　
</html>
