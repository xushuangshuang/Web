package com.bodejidi;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;

public class Admin extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		getServletContext()
			.getRequestDispatcher("/admin/admin.jsp")
			.forward(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
	{
	
	}
}
