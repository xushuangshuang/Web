package com.bodejidi;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;


public class Web extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException
	{
		Member member = Constants.doParma(req);
		String action = member.getAction();
		if("register".equals(action))
		{
			getServletContext()
				.getRequestDispatcher("/servlet/register.jsp")
				.forward(req, resp);
		}
		else
		{
			getServletContext()
				.getRequestDispatcher("/jsp/index.jsp")
				.forward(req, resp);
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{ 
			
		MemberService memberService = new MemberService();
		Member member = Constants.doParma(req);
		String action = member.getAction();
		System.out.println(action);
		
		if("注册".equals(action))
		{
			memberService.save(member);	
				getServletContext()
					.getRequestDispatcher("/jsp/registerSuccess.jsp")
					.forward(req, resp);	
		}
		else if("登录".equals(action))
		{
			String username = member.getUsername();
			String password = member.getPassword();
			Boolean  boo = memberService.loadQuery(username , password);
			if(boo == true)
			{
				HttpSession session = req.getSession();
				req.getSession().setAttribute("username", username);
				getServletContext()
					.getRequestDispatcher("/jsp/loadSuccess.jsp")
					.forward(req, resp);
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
