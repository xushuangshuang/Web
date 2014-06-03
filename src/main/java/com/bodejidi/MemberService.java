package com.bodejidi;

import java.util.List;

public class MemberService
{
	static final Logger logger = LoggerFactory.getLogger(MemberDao.class);
	public void payment(Member member)
	{
		String tb_use_payment = "INSERT INTO tb_username (username, payment, VIP, paymentDate) VALUE(?, ?, ?, ?) ";
		MemberDao dao = new MemberDao();
		dao.paymentSave(member, tb_use_payment);	
	}
	public Member informationByUsername(String username)
	{		
		Member register_username = doInformation(username);
		return register_username;
	}
	public Member doInformation(String username)
	{
		Member member = new Member();
		Member member_Information = parInformationByUsername(member, username);
		Member member_Accounts = parUsernameAccounts(member_Information, username);
		Member register_username = parRegisterUsername(member_Accounts, username);
		Member user_payment = payment(register_username, username);
		return 	user_payment;
		
	}
	public Member payment(Member member, String username)
	{
		String username_by_payment = "SELECT * FROM tb_user_payment WHERE username = ?";
		MemberDao memberDao = new MemberDao();
		Member parm = memberDao.paymentByUsername(member, username, username_by_payment);
		return parm;
	}
	public Member parRegisterUsername(Member member, String username)
	{
		String username_by_register = "SELECT * FROM tb_username_account WHERE username = ?";
		MemberDao memberDao = new MemberDao();
		Member parm = memberDao.registerByUsername(member, username, username_by_register);
		return parm;
	}
	public Member parUsernameAccounts(Member member, String username)
	{
		String username_by_accounts = "SELECT * FROM tb_username_account WHERE username = ?";
		MemberDao memberDao = new MemberDao();
		Member parm = memberDao.accountsByUsername(member, username, username_by_accounts);
		return parm;
	}
	public Member parInformationByUsername(Member member, String username)
	{
		String Information_by_username = "SELECT * FROM tb_personalInformation WHERE username = ?";
		MemberDao memberDao = new MemberDao();
		Member parm = memberDao.informationByUsername(member, username, Information_by_username);
		return parm;
	}
	public List<Member> showList()
	{
		String show_user_list = "SELECT * FROM  tb_username_account , tb_user_payment WHERE tb_username_account.username = tb_user_payment.username";
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
			if(workcode == null)
			{
				
				dao.parUserSave(member, username_sql, Information_sql, tb_user_accounts, bs);
			}
			else
			{
				dao.parAdminSave(member, admin_register_sql, workcode, bs);			
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
