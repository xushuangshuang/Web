<%@page import="com.bodejidi.Member"%>

<html>
	<head>
		<%
			Member member = (Member)request.getSession().getAttribute("personal");
		%>
		<title><%=member.getUsername()%> information</title>
		<style type="text/css">
  			 a:link,a:visited{text-decoration:none;}
		</style>
	</head>
	<body>	
		<p align=center>关于 <%=member.getUsername()%> 的详细个人信息</p>
		</br>
		<table align=center>
			<tr>
			<th><a onclick="javascript:history.back(-1);" >返回</a></th>
			<th></br></th>
			<th></br></th>
			<th><a href="?action=password">修改密码</a></th>
			</tr>
		</table>
		</br>
		<table align=center>
		<form align=center action="personal" method="POST">
			<tr>
				<td><label>用户名</label></td>
				<td><p><%=member.getUsername()%></p></td>
			</tr>
			<tr>
				<td><label>Email</label></td>
				<td><input type="text" name="Email" value="<%=member.getEmail()%>"/></td>
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
				<td><input type="text" name="phone" value="<%=member.getPhone()%>"></td>
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
			<tr>
				<td><input type="hidden" name="username" value="<%=member.getUsername()%>">
				<td><input type="submit" name="action" value="确认修改"/></td>
			</tr>
			</form>
		</table>
	</body>
</html>

