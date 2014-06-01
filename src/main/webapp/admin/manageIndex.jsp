<%@page import="com.bodejidi.Member, java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>manageIndex</title>
	</head>
	<body>
		<p align=center>欢迎管理员</p>

		<p align>会员列表</p>	
		<%List<Member> member = (List<Member>)request.getSession().getAttribute("member");%>
		<table align=center borde="1">
			<tr>
				<th>用户名</th>
				<th>菜品</th>
				<th>状态</th>
				<th>余额</th>
			</tr>
			
			<c:forEach var="member" items="${member}">
			
			<tr>
				<td>
					<a href="?action=${member.username}">${member.username}</a>
				</td>
        		<td>${member.firstName} ${member.lastName}</td>
      		   	</tr>
      			</c:forEach>
		</table>
	</body>　
</html>
