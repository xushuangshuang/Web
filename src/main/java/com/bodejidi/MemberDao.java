package com.bodejidi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class MemberDao
{
	static final Logger logger = LoggerFactory.getLogger(MemberDao.class);
	String username_sql = "SELECT * FROM tb_personalInformation WHERE username = ? ";
	String admin_sql = "SELECT * FROM administrator WHERE username = ? ";


	String admin_register_sql = "INSERT INTO administrator (username, password, workcode, loginDate, workAddress, position) VALUE(?, ?, ?, ?, ?, ?)";

	
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
				member.setFirstName(rs.getString("firstname"));
				member.setLastName(rs.getString("lastname"));
				member.setPhone(rs.getString("phone"));
				member.setAddress(rs.getString("address"));
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
	public void userSave(Member member, String workcode, String username_sql, String Information_sql)
	{
		String Email = member.getEmail();
		String username = member.getUsername();
		String password = member.getPassword();
		String firstName = member.getFirstName();
		String lastName = member.getLastName();
		String position = member.getPosition();
		String workAddress = member.getWorkAddress(); 
		String address = member.getAddress();
		DatabaseService bs = DatabaseService.newInstance();
		try
		{
			if(workcode == null)
			{
				Long phone = Long.valueOf(member.getPhone());	
				bs.prepare(username_sql)
					.setString(username)
					.setString(Email)
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
			}
			else
			{
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
	public Member getMemberByUsername(String username, String admin) 
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
