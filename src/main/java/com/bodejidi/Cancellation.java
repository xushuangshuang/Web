package com.bodejidi;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.HttpSession;


public class Cancellation extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		req.getSession().removeAttribute("adminUsername");
		resp.sendRedirect("/practice/admin");	

	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{

	}
}
