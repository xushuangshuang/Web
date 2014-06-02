<html>
	<head>
		<title>register</title>
		<style type="text/css">
  			 a:link,a:visited{text-decoration:none;}
		</style>
	</head>
	<body>
		<h1 align=center>注册</h1>
		<form action="/practice/register" method="POST">
			<table align=center>
				<tr>
					<td><label>用户名</label></td>
					<td><input type="text" name="username"/></td>
				</tr>
				<tr>
					<td><label>密码</label></td>
					<td><input type="password" name="password"/></td>
				</tr>
				<tr>
					<td><label>重复密码</label></td>
					<td><input type="password" name="repassword"/></td>
				</tr>
				<tr>
					<td><label>工作编号</label></td>
					<td><input type="text" name="workcode"/></td>
				</tr>
				<tr>	
					<td><label>工作地点</label></td>
					<td><input type="text" name="workAddress"/></td>
				</tr>
				<tr>	
					<td><label>职位</label></td>
					<td><input type="text" name="position"/></td>
				</tr>
				
			</table>
			<table align=center>
				<tr>	
					<td><input type="submit" name="action" value="注册"/></td>
				</tr>
			</table>
		</form>
	</body>

</html>

