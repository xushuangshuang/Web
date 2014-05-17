package com.bodejidi;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.RequestDispatcher;

public class Web extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	{
	
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{ 
		
		MemberService memberService = new MemberService();
		memberService.save(Constants.doParma(req));	
		getServletContext()
			.getRequestDispatcher("/jsp/registerSuccess.jsp")
			.forward(req, resp);	
	}
}
