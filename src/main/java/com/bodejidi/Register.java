package com.bodejidi;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

public class Register extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		Member member = Constants.doParma(req);
		String action = member.getAction();
		if("admin".equals(action))
		{
			String username = (String)req.getSession().getAttribute("adminUsername");
			if("benben".equals(username))
			{
				getServletContext()
					.getRequestDispatcher("/servlet/adminRegister.jsp")
					.forward(req, resp);	
			}
			else
			{
				getServletContext()
					.getRequestDispatcher("/error/competenceError.jsp")
					.forward(req, resp);
			}
		}
		else
		{
			String par = (String)req.getSession().getAttribute("username"); 
			if(par == null)
			{
				getServletContext()
					.getRequestDispatcher("/servlet/register.jsp")
					.forward(req, resp);
			}
			else
			{
				getServletContext()
					.getRequestDispatcher("/error/errorRegister.jsp")
					.forward(req, resp);
			}

		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		MemberService memberService = new MemberService();
		Member member = Constants.doParma(req);
		String action = member.getAction();
		String workcode = member.getWorkcode();
		System.out.println(action + "  " + workcode);
		String username = member.getUsername();
		

		if(workcode != null)
		{
			memberService.save(member, workcode);
			getServletContext()
				.getRequestDispatcher("/servlet/adminRegisterSuccess.jsp")
				.forward(req, resp);
		}
		else
		{
				req.getSession().setAttribute("username", username);	
				memberService.save(member, workcode);
				getServletContext()
					.getRequestDispatcher("/servlet/registerSuccess.jsp")
					.forward(req, resp);
		}
	}

}
