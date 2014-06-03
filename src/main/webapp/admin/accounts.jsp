<%@page import="com.bodejidi.Member"%>

<html>
	<head>
		<%
			Member member = (Member)request.getSession().getAttribute("informationList");
		%>
		<title><%=member.getUsername()%></title>
	</head>
	<body>	
		<p align=center>关于 <%=member.getUsername()%> 的消费信息</p>
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
				<td><label>曾消费金额</label></td>
				<td><p><%=member.getAccountsed()%></p></td>
			</tr>
			<tr>
				<td><label>卡上余额</label></td>
				<td><p><%=member.getEndAccounts()%></p></td>
			</tr>
			<tr>	
				<td><label>VIP</label></td>
				<td><p><%=member.getVIP()%></p></td>
			</tr>
			<tr>
				<td><label>状态</label></td>
				<td><p><%=member.getU_static()%></p></td>
			</tr>
			<tr>
				<td><label>上次缴费时间</label></td>
				<td><p><%=member.getPaymentDate()%></p></td>
			</tr>
			<form align=center action="manage" method="POST">
				<tr>
					<td><input type="hidden" name="username" value="<%=member.getUsername()%>"></td>
				</tr>
				<tr>			
					<td><label>缴纳金额</label></td>
						
					<td><input type="text" name="payment"/></td>
				</tr>
					<td><input type="submit" name="action" value="缴费"/></td>
				<tr>

				</tr>

			</form>
		</table>
	</body>
</html>

