package com.bodejidi;

public class MemberService
{
	public void save(Member member)
	{
		MemberDao memberDao = new MemberDao();
		memberDao.userSave(member);
		
	}
	public Boolean loadQuery(String username, String password)
	{
		MemberDao memberDao = new MemberDao();
		Member member = memberDao.getMemberByUsername(username);
		String paraUsername = member.getUsername();
		String paraPassword = member.getPassword();
		String session = member.getSession();
		System.out.println(" member service  " + session);
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
