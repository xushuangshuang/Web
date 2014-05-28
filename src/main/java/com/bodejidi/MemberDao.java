package com.bodejidi;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao
{
	static final Logger logger = LoggerFactory.getLogger(MemberDao.class);
	String username_sql = "SELECT * FROM tb_personalInformation WHERE username = ? ";
	String admin_sql = "SELECT * FROM administrator WHERE username = ? ";
	String tb_username_sql = "INSERT INTO tb_username (username, userEmail) VALUE(?, ?) ";
	String tb_personalInformation_sql = "INSERT INTO tb_personalInformation (username, password, phone, firstName, lastName,  address) VALUE(?, ?, ?, ?, ?, ?)";
	String admin_register_sql = "INSERT INTO administrator (username, password, workcode, loginDate, workAddress, position) VALUE(?, ?, ?, ?, ?, ?)";
	public void userSave(Member member, String workcode)
	{
		Long code = (Long)Long.valueOf(workcode);
		String Email = member.getEmail();
		String username = member.getUsername();
		String password = member.getPassword();
		String firstName = member.getFirstName();
		String lastName = member.getLastName();
		String position = member.getPosition();
		String workAddress = member.getWorkAddress(); 
		Long phone = Long.valueOf(member.getPhone());
		String address = member.getAddress();
		DatabaseService bs = DatabaseService.newInstance();
		try
		{
			if(workcode == null)
			{	
				bs.prepare(tb_username_sql)
					.setString(username)
					.setString(Email)
					.execute();
				System.out.println("SQL: " + tb_username_sql );
				bs.prepare(tb_personalInformation_sql)
					.setString(username)
					.setString(password)
					.setLong(phone)
					.setString(firstName)
					.setString(lastName)
					.setString(address)
					.execute();
				System.out.println("SQL: " + tb_personalInformation_sql );
			}
			else
			{
				bs.prepare(admin_register_sql)
					.setString(username)
					.setString(password)
					.setLong(code)
					.setDate()
					.setString(workAddress)
					.setString(position)
					.execute();
				System.out.println("SQL: " + admin_sql);
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
}
