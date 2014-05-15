package com.bodejidi;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Web extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	{
	
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
	{
		Constants cons = new Constants();
		MemberDao member = new MemberDao();
		
		member.userSave(cons.doParma(req));		
	}
}
