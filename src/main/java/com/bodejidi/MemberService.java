package com.bodejidi;

import java.util.List;
public class MemberService
{
	public List<Member> showList()
	{
		MemberDao memberDao = new MemberDao();
		 List<Member> member = memberDao.showList();
		return member;	
	}
	public void save(Member member, String workcode)
	{
		System.out.println("MemberService  " + workcode);
		MemberDao memberDao = new MemberDao();
		memberDao.userSave(member, workcode);
	}
	public Member inquireUsername(String username)
	{
	
		MemberDao getInformation = new MemberDao();
		Member member =	getInformation.getUsernameInformation(username);
		return member;	
	}
	public Boolean loadQuery(String username, String password, String admin)
	{
		MemberDao memberDao = new MemberDao();
		Member member = memberDao.getMemberByUsername(username, admin);
		String paraUsername = member.getUsername();
		String paraPassword = member.getPassword();
		System.out.println(" member service  " +paraUsername);
		System.out.println(" member service  " +paraPassword);
		if(username.equals(paraUsername) && password.equals(paraPassword))
		{
			return true;
		}
		else
		{
			return false;
		}

	}
}
