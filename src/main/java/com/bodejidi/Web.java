package com.bodejidi;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;

public class Web extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	{
	
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("web");
		Constants cons = new Constants();
		MemberDao member = new MemberDao();
		
		member.userSave(cons.doParma(req));
		getServletContext()
			.getRequestDispatcher("/jsp/registerSuccess.jsp")
			.forward(req, resp);		
	}
}
