<%@page import="com.bodejidi.Member"%>

<html>
	<head>
		<%
			Member member = (Member)request.getSession().getAttribute("informationList");
		%>
		<title>username</title>
	</head>
	<body>	
		<p align=center><%=member.getUsername()%></p>
		</br>
		</br>
		<table align=center>
			<tr>
				<td><label>用户名</label></td>
				<td><input type="text" name="username" value="<%=member.getUsername()%>"/></td>
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
				<td><input type="text" name="address" value="<%=member.getAddress()%>"/></td>
			</tr>
			<tr>
				<td><label>电话</label></td>
				<td><input type="text" name="phone" value="<%=member.getPhone()%>"/></td>
			</tr>
			<tr>
				<td><label>卡上余额</label></td>
				<td><input type="text" name="endAccounts" value="<%=member.getEndAccounts()%>"/></td>
			</tr>
			<tr>
				<td><label>状态</label></td>
				<td><input type="text" name="u_static" value="<%=member.getU_static()%>"/></td>
			</tr>
			<tr>
				<td><label>注册时间</label></td>
				<td><p><%=member.getRegisterDate()%></p></td>
			</tr>

	</body>
</html>
