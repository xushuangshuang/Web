package com.bodejidi;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;

public class Register extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		getServletContext()
			.getRequestDispatcher("/servlet/register.jsp")
			.forward(req, resp);	
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
	{
		MemberService memberService = new MemberService();
		Member member = Constants.doParma(req);
		memberService.save(member);
	
	}

}
