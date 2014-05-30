package com.bodejidi;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequset;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Manage extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	{
	
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
	{
		MemberService memberService = new MemberService();
		Member memberJsp = Constants.doPatma(req);
		String action = memberJsp.getAction();
		String username = memberJsp.getUsername();
		System.out.println(action);
		if("查询".equals(action))
		{
			Member member = memerService.inquireUsername(username);
			req.getSession().setAttribute("member", member);
		}

	}
}
