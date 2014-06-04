<%@page import="com.bodejidi.Member"%>

<html>
	<head>
		<%
			Member member = (Member)request.getSession().getAttribute("personal");
		%>
		<title>alter password</title>
		<style type="text/css">
  			 a:link,a:visited{text-decoration:none;}
		</style>
	</head>
	<body>	
		<p align=center>密码修改</p>
		</br>
		<table align=center>
			<th><a onclick="javascript:history.back(-1);" >返回</a></th>
		</table>
		</br>
		<table align=center>
		<form align=center action="personal" method="POST">
			<tr>
				<td><label>用户名</label></td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td><label>Email</label></td>
				<td><input type="text" name="Email"/></td>
			</tr>
			<tr>
				<td><label>真实姓名</label></td>
				<td><input type="text" name="firstName"/></td>
			</tr>
			<tr>
				<td><label>旧密码</label></td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td><label>新密码</label></td>
				<td><input type="password" name="newPassword"/></td>
			</tr>
			<tr>
				<td><input type="submit" name="action" value="确认"/></td>
			</tr>
			</form>
		</table>
	</body>
</html>


