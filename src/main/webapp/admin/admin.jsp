<html>
	<head>
		<title>login</title>
		<style type="text/css">
  			 a:link,a:visited{text-decoration:none;}
		</style>
	</head>
	<body>
		<table align=center>
		<h1 align=center>欢迎</h1>		
		<form action="admin" method="POST">
			<tr>			
				<td><label>用户名</label></td>
				<td>&nbsp;</td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td><label>密码</label></td>
				<td>&nbsp;</td>
				<td><input type="password" name="password"/></br></td>
			</tr>
			<tr>
				<td><input type="submit" name="action" value="登录"/></td>
				<td><input type="hidden"  name="admin" value="admin"></td>
			</form>
			<td><a href="/practice/register?workcode=1">注册</a></td>
			</tr>
		</table>
		
	</body>
</html>
