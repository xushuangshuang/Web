package com.bodejidi;

import java.util.List;

public class MemberService
{
	static final Logger logger = LoggerFactory.getLogger(MemberDao.class);
	public List<Member> showList()
	{
		String show_user_list = "SELECT * FROM  tb_username_account";
		MemberDao memberDao = new MemberDao();
		List<Member> member = memberDao.showList(show_user_list);
		return member;	
	}
	public void save(Member member, String workcode)
	{
		String tb_username_sql = "INSERT INTO tb_username (username, userEmail) VALUE(?, ?) ";
		String tb_personalInformation_sql = "INSERT INTO tb_personalInformation (username, password, phone, firstName, lastName,  address) VALUE(?, ?, ?, ?, ?, ?)";
		String admin_register_sql = "INSERT INTO administrator (username, password, workcode, loginDate, workAddress, position) VALUE(?, ?, ?, ?, ?, ?)";
		String tb_user_accounts = "INSERT INTO tb_username_account (username) VALUE(?)";
		System.out.println("MemberService  " + workcode);
		userSave(member, workcode, tb_username_sql, tb_personalInformation_sql, admin_register_sql, tb_user_accounts);
	}
	public void userSave(Member member, String workcode, String username_sql, String Information_sql, String admin_register_sql, String tb_user_accounts)
	{
		DatabaseService bs = DatabaseService.newInstance();
		MemberDao dao = new MemberDao();
		try
		{
			if(workcode == null)
			{
				
				dao.parUserSave(member, username_sql, Information_sql, tb_user_accounts, bs);
			}
			else
			{
				dao.parAdminSave(member, admin_register_sql, workcode, bs);			
			}
		}
		catch(Exception e)
		{
			logger.error("memberDao userSave " + e);
		
		}
		finally
		{
			bs.close();
		}
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
		String username_sql = "SELECT * FROM tb_personalInformation WHERE username = ? ";
		String admin_sql = "SELECT * FROM administrator WHERE username = ? ";
		MemberDao memberDao = new MemberDao();
		Member member = memberDao.getMemberByUsername(username, admin, username_sql, admin_sql);
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
