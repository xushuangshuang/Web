package com.bodejidi;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class Constants extends HttpServlet
{
	public Member doParma(HttpServletRequest req)
	{
		Member member = new Member();
		String username = req.getParameter("username");	
		member.setUsername("username"); 
		String firstName = req.getParameter("firstName");
		member.setFirstName("firstName");
		String lastName = req.getParameter("lastName");
		member.setLastName("lastName");
	        String password = req.getParameter("password");	
		member.setPassword("password");
		String phone = req.getParameter("phone");
		member.setPhone("phone");
		String Email = req.getParameter("Email");
		member.setEmail("Email");
		return member;
	}
}
