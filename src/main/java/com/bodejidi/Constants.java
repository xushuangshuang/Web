package com.bodejidi;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class Constants extends HttpServlet
{
	public static final String MEMBER_USERNAME = "username";
	public static final String MEMBER_PASSWORD = "password";
	public static final String MEMBER_FIRSTNAME = "firstName";
	public static final String MEMBER_LASTNAME = "lastName";
	public static final String MEMBER_PHONE = "phone";
	public static final String MEMBER_ADDRESS = "address";
	public static final String MEMBER_ENDACCOUNTS = "endAccounts";
	public static final String MEMBER_U_STATIC = "u_static";
	
	public static Member doParma(HttpServletRequest req)
	{
		Member member = new Member();
		String newPassword = req.getParameter("newPassword");	
		member.setNewPassword(newPassword); 
		String payment = req.getParameter("payment");	
		member.setPayment(payment); 
		String number = req.getParameter("number");	
		member.setNumber(number); 
		String username = req.getParameter("username");	
		member.setUsername(username); 
		String firstName = req.getParameter("firstName");
		member.setFirstName(firstName);
		String lastName = req.getParameter("lastName");
		member.setLastName(lastName);
	        String password = req.getParameter("password");	
		member.setPassword(password);
		String phone = req.getParameter("phone");
		member.setPhone(phone);
		String Email = req.getParameter("Email");
		member.setEmail(Email);
		String address = req.getParameter("address");
		member.setAddress(address);
		String action = req.getParameter("action");
		member.setAction(action);
		String admin = req.getParameter("admin");
		member.setSession(admin);
		String workcode = req.getParameter("workcode");
		member.setWorkcode(workcode);
		String workAddress = req.getParameter("workAddress");
		member.setWorkAddress(workAddress);
		String position = req.getParameter("position");
		member.setPosition(position);
		String endAccounts = req.getParameter("endAccounts");
		member.setEndAccounts(endAccounts);
		String u_static = req.getParameter("u_static");
		member.setU_static(u_static);
		return member;
	}
}
