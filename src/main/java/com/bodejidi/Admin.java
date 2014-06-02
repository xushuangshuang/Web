package com.bodejidi;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.HttpSession;


public class Admin extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		getServletContext()
			.getRequestDispatcher("/admin/admin.jsp")
			.forward(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		MemberService memberService = new MemberService();
		Member member = Constants.doParma(req);
		String action = member.getAction();
		String admin = member.getSession();
		System.out.println(admin);
		String username = member.getUsername();
		String password = member.getPassword();
		if("登录".equals(action))
		{
			Boolean  boo = memberService.loadQuery(username , password, admin);
				if(boo == true)
				{
					HttpSession session = req.getSession();
					req.getSession().setAttribute("adminUsername", username);
					resp.sendRedirect("/practice/manage");
				}
				else
				{
					getServletContext()
						.getRequestDispatcher("/jsp/loadFailed.jsp")
						.forward(req, resp);
				}
		}
	}
}
