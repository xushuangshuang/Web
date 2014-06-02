package com.bodejidi;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;

public class Manage extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		getServletContext()
			.getRequestDispatcher("/admin/manageIndex.jsp")
			.forward(req, resp);
		Member member = Constants.doParma(req);
		String action = member.getAction();
		MemberService ms = new MemberService();
		Member parm_member = ms.informationByUsername(action);
		req.getSession().setAttribute("informationList", parm_member);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
	{

	}
}
