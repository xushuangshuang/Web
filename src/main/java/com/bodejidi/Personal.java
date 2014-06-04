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
		Member member = Constants.doParma(req);
		String action = member.getAction();
		System.out.println(" personal " + action);
		if(username != null)
		{
			MemberService ms = new MemberService();
			Member parMember = ms.doInformation(username);
			req.getSession().setAttribute("personal", parMember);
			getServletContext()
				.getRequestDispatcher("/jsp/personal.jsp")
				.forward(req, resp);
		}
		else if("password".equals(action))
		{
			getServletContext()
				.getRequestDispatcher("/jsp/alterPassword.jsp")
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
		Member member = Constants.doParma(req);
		System.out.println(member.getNewPassword() + " newPassword  " );
		String action = member.getAction();
		MemberService ms = new MemberService();
		
		if("确认修改".equals(action))
		{
		
			ms.alter(member);
			getServletContext()
				.getRequestDispatcher("/jsp/alter.jsp")
				.forward(req, resp);
				
		}
		else if("确认".equals(action))
		{	
			boolean alter = ms.alterPassword(member);
			System.out.println(alter);
			if(alter)
			{
				ms.parPersonal(member);
				getServletContext()
					.getRequestDispatcher("/jsp/alter.jsp")
					.forward(req, resp);
			}
			else
			{
				getServletContext()
					.getRequestDispatcher("/jsp/failed.jsp")
					.forward(req, resp);	
			}
		}
	}
}	
