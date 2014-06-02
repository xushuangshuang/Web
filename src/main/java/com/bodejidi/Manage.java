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
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
	{
		MemberService memberService = new MemberService();
		Member memberJsp = Constants.doParma(req);
		String action = memberJsp.getAction();
		String username = memberJsp.getUsername();
		System.out.println(action);
		if("查询".equals(action))
		{
			Member member = memberService.inquireUsername(username);
			req.getSession().setAttribute("member", member);
		}

		

	}
}
