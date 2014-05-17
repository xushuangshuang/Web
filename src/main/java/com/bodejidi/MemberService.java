package com.bodejidi;



public class MemberService
{
	public void save(Member member)
	{
		MemberDao memberDao = new MemberDao();
		memberDao.userSave(member);
		
	}
}
