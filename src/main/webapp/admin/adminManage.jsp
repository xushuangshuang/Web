<%@import javax.servlet.http.HttpSession%>
<%@import com.bodejidi.Member%>

<html>
	<title>manage</title>

	<body>
		<table align=center>
			<form action="manage" align=center method="POST">
				<tr><input type="text" name=username/><tr>

			</form>	
				<%Member memer = req.getSession().getAttribute("member")%>
				<p align=center> 您查找的<%=member.getUsername%>如下</p>
				<tr>
					<th>username</th>
					<th>firstName</th>
					<th>lastName</th>
					<th>phone</th>
					<th>address</th>
					<th>money</th>
				</tr>	
		</table>			
	</body>
<html>
