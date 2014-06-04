<html>
	<head>
		<title>login</title>
		<style type="text/css">
  			 a:link,a:visited{text-decoration:none;}
		</style>
	</head>
	<body>
		
		<h1 align=center>欢迎</h1>
		</br>

		<table align=center>
			<th><a onclick="javascript:history.back(-1);" >返回</a></th>
		</table>
		</br>

		<table align=center>		
		<form action="practice" method="POST">
		<tr>			
			<th><label>用户名</label></th>
			<th>&nbsp;</th>
			<th><input type="text" name="username"/></th>
		</tr>
		<tr>
			<th><label>密码</label></th>
			<th>&nbsp;</th>
			<th><input type="password" name="password"/></th>
		</tr>
		<tr>
			<th><input type="submit" name="action" value="登录"/></th>
			<th>&nbsp;</th>
			<th><a href="personal?action=password">忘记密码</a></th>
		</form>
			<th><a href="/practice/register">注册</a></th>
		</tr>
	</table>
		
	</body>
</html>
