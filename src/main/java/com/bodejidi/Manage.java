package com.bodejidi;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.util.List;
import javax.servlet.http.HttpSession;

public class Manage extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		String adminUsername = (String)req.getSession().getAttribute("adminUsername");
		if(null == adminUsername)
		{
			getServletContext()
				.getRequestDispatcher("/error/404.jsp")
				.forward(req, resp);
		}
		else
		{
			MemberService memberService = new MemberService();
			List<Member> memberList = memberService.showList();
			HttpSession session = req.getSession();
			System.out.println("memberList " + memberList);
			req.getSession().setAttribute("member", memberList);
			Member member = Constants.doParma(req);
			String action = member.getAction();
			System.out.println("Manage " + action);
			String number = member.getNumber();
			if(action != null)
			{
				MemberService ms = new MemberService();
				Member parm_member = ms.informationByUsername(action);
				req.getSession().setAttribute("informationList", parm_member);
				if(number != null)
				{
					getServletContext()
						.getRequestDispatcher("/admin/accounts.jsp")
						.forward(req, resp);
				}
				else
				{
					getServletContext()
						.getRequestDispatcher("/admin/adminManage.jsp")
						.forward(req, resp);
				}
			}
			else
			{
				getServletContext()
					.getRequestDispatcher("/admin/manageIndex.jsp")
					.forward(req, resp);
		
			}
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException ,ServletException
	{
		Member member = Constants.doParma(req);
		String payment = member.getPayment(); 
		if(Util.isNumeric(payment))
		{
			System.out.println(" Manage  else" + payment);
			MemberService ms = new MemberService();
			ms.usernameAccount(member);	
			ms.payment(member);
			resp.sendRedirect("/practice/manage");
		}
		else
		{
			System.out.println(" Manage " + payment);
			getServletContext()
				.getRequestDispatcher("/error/operate.jsp")
				.forward(req, resp);
		}
	}
	
}
