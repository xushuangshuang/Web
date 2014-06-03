package com.bodejidi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class MemberDao
{
	static final Logger logger = LoggerFactory.getLogger(MemberDao.class);
	public void endAccountsUpdate(Member member, String sql)
	{
		DatabaseService bs = DatabaseService.newInstance();
			try
		{
			String username = member.getUsername();
			System.out.println(" paymentSave " + username);
			String payment = member.getPayment();

				bs.prepare(sql)
					.setString(payment)
					.setString(username)
					.execute();
				System.out.println("SQL: " + sql);
		}
		catch(Exception e)
		{
			logger.debug("Payment by username " + e);
		}
		finally
		{
			bs.close();
		}
	}
	public void paymentSave(Member member, String sql)
	{
		DatabaseService bs = DatabaseService.newInstance();
			try
		{
			String username = member.getUsername();
			System.out.println(" paymentSave " + username);
			String payment = member.getPayment();
			String VIP = "Y";

				bs.prepare(sql)
					.setString(payment)
					.setString(VIP)
					.setDate()
					.setString(username)
					.execute();
				System.out.println("SQL: " + sql);
		}
		catch(Exception e)
		{
			logger.debug("Payment by username " + e);
		}
		finally
		{
			bs.close();
		}
	}
	public Member paymentByUsername(Member member, String username, String sql)
	{
		DatabaseService bs = DatabaseService.newInstance();
		try
		{
			ResultSet rs = bs.prepare(sql).setString(username).executeQuery();
			while(rs.next())
			{
				member.setVIP(rs.getString("VIP"));
				member.setAccountsed(rs.getString("accounted"));
				member.setPaymentDate(rs.getString("paymentDate"));
			}
		}
		catch(Exception e)
		{
			logger.debug("Payment by username " + e);
		}
		finally
		{
			bs.close();
		}
		return member;	
	}
	public Member registerByUsername(Member member, String username, String sql)
	{
		DatabaseService bs = DatabaseService.newInstance();
		try
		{
			ResultSet rs = bs.prepare(sql).setString(username).executeQuery();
			while(rs.next())
			{
				member.setRegisterDate(rs.getString("registerDate"));
				member.setRemark(rs.getString("remark"));
				member.setEmail(rs.getString("userEmail"));

			}
		}
		catch(Exception e)
		{
			logger.debug("Accounts " + e);
		}
		finally
		{
			bs.close();
		}
		return member;	
	}
	public Member accountsByUsername(Member member, String username, String sql)
	{
			DatabaseService bs = DatabaseService.newInstance();
		try
		{
			ResultSet rs = bs.prepare(sql).setString(username).executeQuery();
			while(rs.next())
			{
				member.setEndAccounts(rs.getString("endAccounts"));
				member.setU_static(rs.getString("u_static"));
			}
		}
		catch(Exception e)
		{
			logger.debug("Accounts " + e);
		}
		finally
		{
			bs.close();
		}
		return member;	
	}
	public Member informationByUsername(Member member, String username, String sql)
	{
		DatabaseService bs = DatabaseService.newInstance();
		try
		{
			ResultSet rs = bs.prepare(sql).setString(username).executeQuery();
			while(rs.next())
			{
				member.setUsername(rs.getString("username"));
				member.setPassword(rs.getString("password"));
				member.setFirstName(rs.getString("firstName"));
				member.setLastName(rs.getString("lastName"));
				member.setPhone(rs.getString("phone"));
				member.setAddress(rs.getString("address"));
			}
		}
		catch(Exception e)
		{
			logger.debug(" Information  " + e);
		}
		finally
		{
			bs.close();
		}
		return member;	
	}
	public List<Member> showList(String sql)
	{
		DatabaseService bs = DatabaseService.newInstance();
		ResultSet rs = null;
		List<Member> memberList = new ArrayList<Member>();
		try
		{
			rs = bs.executeQuery(sql);
			while(rs.next())
			{
				Member member = new Member();
				member.setUsername(rs.getString("username"));
				System.out.println(member.getUsername());
				member.setEndAccounts(rs.getString("endAccounts"));
				System.out.println(member.getEndAccounts());
				member.setU_static(rs.getString("u_static"));
				System.out.println(member.getU_static());
				member.setPayment(rs.getString("payment"));
				System.out.println(member.getPayment());
				memberList.add(member);
			}
		}
		catch(Exception e)
		{
			logger.error("memberDao show list " + e);
		}
		finally
		{
			bs.close();
		}
		return memberList;
	}	
	
	public void parAdminSave(Member member, String admin_register_sql, String workcode, DatabaseService bs) 
	{
		try
		{
		String username = member.getUsername();
		String password = member.getPassword();	
		String position = member.getPosition();
		String workAddress = member.getWorkAddress(); 
		String address = member.getAddress();
		Long code = Long.valueOf(workcode);
				bs.prepare(admin_register_sql)
					.setString(username)
					.setString(password)
					.setLong(code)
					.setDate()
					.setString(workAddress)
					.setString(position)
					.execute();
				System.out.println("SQL: " + admin_register_sql);
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
	public void parUserSave(Member member, String username_sql, String Information_sql, String tb_user_accounts, DatabaseService bs, String tb_user_payment) 
	{
		try
		{
			String username = member.getUsername();
			String password = member.getPassword();	
			String Email = member.getEmail();
			String firstName = member.getFirstName();
			String lastName = member.getLastName();
			String address = member.getAddress();
			Long phone = Long.valueOf(member.getPhone());	
				bs.prepare(tb_user_payment)
					.setString(username)
					.setString("N")
					.execute();
				System.out.println("SQL: " +tb_user_payment);
				bs.prepare(username_sql)
					.setString(username)
					.setString(Email)
					.setDate()
					.execute();
				System.out.println("SQL: " + username_sql);
				bs.prepare(Information_sql)
					.setString(username)
					.setString(password)
					.setLong(phone)
					.setString(firstName)
					.setString(lastName)
					.setString(address)
					.execute();
				System.out.println("SQL: " + Information_sql);
				bs.prepare(tb_user_accounts)
					.setString(username)
					.setString("0")
					.execute();
				System.out.println("SQL: " + tb_user_accounts);
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
	public Member getMemberByUsername(String username, String admin, String username_sql, String admin_sql) 
	{
		Member member = new Member();
		DatabaseService ds = DatabaseService.newInstance();
		String sql;
		if(admin == null)
		{
			sql = username_sql;
		}
		else
		{
			sql = admin_sql;
		}	
		try
		{
			ResultSet rs = ds.prepare(sql).setString(username).executeQuery();
			while(rs.next())
			{
				member.setUsername(rs.getString(Constants.MEMBER_USERNAME));
				System.out.println("Member  dao" + rs.getString(Constants.MEMBER_USERNAME));
				member.setPassword(rs.getString(Constants.MEMBER_PASSWORD));
				System.out.println("Member  dao" + rs.getString(Constants.MEMBER_PASSWORD));
			}
		}
		catch(SQLException e)
		{
			logger.error("memberDao getMemberByUsername" + e);
		}
		finally
		{
			ds.close();
		}
		return member;
	}

	public Member getUsernameInformation(String username, String inquiry_sql)
	{
		Member member = new Member();
		DatabaseService ds = DatabaseService.newInstance();
		try
		{
			ResultSet rs = ds.prepare(inquiry_sql).setString(username).executeQuery();
			while(rs.next())
			{
				member.setUsername(rs.getString(Constants.MEMBER_USERNAME));
				System.out.println("Member  dao" + rs.getString(Constants.MEMBER_USERNAME));
				member.setPassword(rs.getString(Constants.MEMBER_PASSWORD));
				System.out.println("Member  dao" + rs.getString(Constants.MEMBER_PASSWORD));
			}
		}
		catch(Exception e)
		{
			logger.error("memberDao getUsernameInformation" + e);
		}
		finally
		{
			ds.close();
		}
		return member;
	}
}
