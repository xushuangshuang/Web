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
		else if(action == "登录")
		{
			
		
		}	
	}
}
