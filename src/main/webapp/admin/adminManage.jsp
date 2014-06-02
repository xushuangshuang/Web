<%@page import="com.bodejidi.Member"%>

<html>
	<head>
		<%
			Member member = (Member)request.getSession().getAttribute("informationList");
		%>
		<title><%=member.getUsername()%></title>
	</head>
	<body>	
		<p align=center>关于 <%=member.getUsername()%> 的详细个人信息</p>
		</br>
		<table align=center>
			<th><a onclick="javascript:history.back(-1);" >返回</a></th>
		</table>
		</br>
		<table align=center>
			<tr>
				<td><label>用户名</label></td>
				<td><p><%=member.getUsername()%></p></td>
			</tr>
			<tr>
				<td><label>密码</label></td>
				<td><p><%=member.getPassword()%></p></td>
			</tr>
			<tr>
				<td><label>Email</label></td>
				<td><p><%=member.getEmail()%></p></td>
			</tr>
			<tr>
				<td><label>真实姓名</label></td>
				<td><p><%=member.getFirstName()%> <%=member.getLastName()%></p></td>
			</tr>
			<tr>
				<td><label>地址</label></td>
				<td><p><%=member.getAddress()%></p></td>
			</tr>
			<tr>
				<td><label>电话</label></td>
				<td><p><%=member.getPhone()%></p></td>
			</tr>
			<tr>
				<td><label>卡上余额</label></td>
				<td><p><%=member.getEndAccounts()%></p></td>
			</tr>
			<tr>
				<td><label>状态</label></td>
				<td><p><%=member.getU_static()%></p></td>
			</tr>
			<tr>
				<td><label>注册时间</label></td>
				<td><p><%=member.getRegisterDate()%></p></td>
			</tr>
		</table>
	</body>
</html>
