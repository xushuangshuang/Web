package com.bodejidi;

import java.util.List;

public class MemberService
{
	public List<Member> showList()
	{
		String show_user_list = "SELECT * FROM  tb_personalInformation";
		MemberDao memberDao = new MemberDao();
		List<Member> member = memberDao.showList(show_user_list);
		return member;	
	}
	public void save(Member member, String workcode)
	{
		String tb_username_sql = "INSERT INTO tb_username (username, userEmail) VALUE(?, ?) ";
		String tb_personalInformation_sql = "INSERT INTO tb_personalInformation (username, password, phone, firstName, lastName,  address) VALUE(?, ?, ?, ?, ?, ?)";
		System.out.println("MemberService  " + workcode);
		MemberDao memberDao = new MemberDao();
		memberDao.userSave(member, workcode, tb_username_sql, tb_personalInformation_sql);
	}
	public Member inquireUsername(String username)
	{
		String user_inquiry_username = "SELECT * FROM tb_personalInformation WHERE username = ?";	
		MemberDao getInformation = new MemberDao();
		Member member =	getInformation.getUsernameInformation(username, user_inquiry_username);
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
