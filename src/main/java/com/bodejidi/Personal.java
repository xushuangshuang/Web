package com.bodejidi;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.HttpSession;

public class Personal extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String username = (String)req.getSession().getAttribute("username");
		if(username != null)
		{
			MemberService ms = new MemberService();
			Member parMember = ms.doInformation(username);
			req.getSession().setAttribute("personal", parMember);
			getServletContext()
				.getRequestDispatcher("/jsp/personal.jsp")
				.forward(req, resp);
		}
		else
		{
			getServletContext()
				.getRequestDispatcher("/error/noLoad.jsp")
				.forward(req, resp);
		
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{

	}
}	