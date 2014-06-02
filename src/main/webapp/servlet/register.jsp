<html>
	<head>
		<title>register</title>
		<style type="text/css">
  			 a:link,a:visited{text-decoration:none;}
		</style>
	</head>
	<body>
		<h1 align=center>注册</h1>
		</br>
		<table align=center>
			<th><a onclick="javascript:history.back(-1);" >返回</a></th>
		</table>
		</br>
		<form action="/practice/register" method="POST">
			<table align=center>
				<tr>
					<td><label>firstName</label></td>
					<td><input type="text" name="firstName"/></td>
				</tr>
				<tr>
					<td><label>lastName</label></td>
					<td><input type="text" name="lastName"/></td>
				</tr>
				<tr>
					<td><label>username</label></td>
					<td><input type="text" name="username"/></td>
				</tr>
				<tr>
					<td><label>password</label></td>
					<td><input type="password" name="password"/></td>
				</tr>
				<tr>
					<td><label>repassword</label></td>
					<td><input type="password" name="repassword"/></td>
				</tr>
				<tr>	
					<td><label>Email</label></td>
					<td><input type="text" name="Email"/></td>
				</tr>
				<tr>	
					<td><label>phone</label></td>
					<td><input type="text" name="phone"/></td>
				</tr>
				<tr>	
					<td><label>address</label></td>
					<td><input type="text" name="address"/></td>
				</tr>
				<tr>
					<td>&nbsp;</td>	
					<td><input type="submit" name="action" value="注册"/></td>
				</tr>
			</table>
		</form>
	</body>

</html>
