package com.bodejidi;

public class MemberService
{
	public void save(Member member, String workcode)
	{
		System.out.println("MemberService  " + workcode);
		MemberDao memberDao = new MemberDao();
		memberDao.userSave(member, workcode);
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
