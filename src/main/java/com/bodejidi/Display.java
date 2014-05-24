package com.bodejidi;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

public class Display extends HttpServlet
{
	static final Logger logger = LoggerFactory.getLogger(Display.class);
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		Member member = Constants.doParma(req);
		String action = member.getAction();
		System.out.println(" display " + action);
		if("logout".equals(action))
		{
			try
			{
				req.getSession().removeAttribute("username");
				resp.sendRedirect("/practice/display");
				action = "benben";
			}
			catch(Exception e)
			{
				logger.debug("sendRedirect Exception");	
			}
		}
		else
		{
			getServletContext()
				.getRequestDispatcher("/jsp/Information.jsp")
				.forward(req, resp);
		
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
	{

	}
}
