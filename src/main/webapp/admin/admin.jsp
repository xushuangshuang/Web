<html>
	<head>
		<title>login</title>
		<style type="text/css">
  			 a:link,a:visited{text-decoration:none;}
		 </style>
		<script type="text/javascript">

			function validate_required(field,alerttxt)
			{
				with (field)
				{
  					if (value==null||value=="")
					{
						alert(alerttxt);
						return false
					}
					else
				       	{
						return true
					}
  				}
			}

			function validate_form(thisform)
			{
				with (thisform)
				{
  					if (validate_required(username,"username cannot null !")==false)
					{
						email.focus();
						return false
					}
  				}
			}
		</script>
		 
	</head>
	<body>
		<table align=center>
		<h1 align=center>欢迎</h1>		
		<form action="manage" onsubmit="return validate_form(this)" method="POST">
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
			</tr>
		</table>
		
	</body>
</html>
