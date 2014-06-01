<%@page import="com.bodejidi.Member"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>manage</title>
	</head>
	<body>	
			<form action="manage" align=left method="POST">
				<th><input type="text" name=username/><tr>
				<th><input type="submit" name=action value="查询"/></td>	
			</form>

			<table align=center>
				<%Member memer = request.getSession().getAttribute("member");%>
				<p align=center> 您查找的<%=member.getUsername%>如下</p>
				<tr>
					<th>username</th>
					<th>firstName</th>
					<th>lastName</th>
					<th>phone</th>
					<th>address</th>
					<th>money</th>
				</tr>
				<tr>
					<td><%=member.getUsername%></td>
				</tr>
				<tr>
					<td><%=member.getFirstname%></td>
				</tr>	
				<tr>
					<td><%=member.getLastname%></td>
				</tr>
				<tr>
					<td><%=member.getPhone%></td>
				</tr>
				<tr>
					<td><%=member.getAddress%></td>
				</tr>
				<tr>
					<td><%=member.getMoney%></td>
				</tr>		
		</table>			
	</body>
</html>
