package com.bodejidi;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao
{
	public void userSave(Member member)
	{
	
		String Email = member.getEmail();
		String username = member.getUsername();
		String password = member.getPassword();
		String firstName = member.getFirstName();
		String lastName = member.getLastName();
		Long phone = member.getPhone();
		String address = member.getAddress();

		String tb_username_sql = "INSERT INTO tb_username (username, userEmail) VALUE(?, ?) ";
		String tb_personalInformation_sql = "INSERT INTO tb_personalInformation (username, password, phone, firstName, lastName,  address) VALUE(?, ?, ?, ?, ?, ?)";
		DatabaseService bs = DatabaseService.newInstance();
		try
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
		catch(Exception e)
		{
		
		
		}
		finally
		{
			bs.close();
		}
	}
	public Member getMemberByUsername(String username) throws SQLException
	{
		String sql = "SELECT * FORM tb_personalInformation WHERE username = ? ";
		Member member = new Member();
		DatabaseService ds = DatabaseService.newInstance();
		ResultSet rs = ds.prepare(sql).setString(username).executeQuery();
		rs.next();
		member.setUsername(rs.getString(Constants.MEMBER_USERNAME));
		member.setPassword(rs.getString(Constants.MEMBER_PASSWORD));
		member.setFirstName(rs.getString(Constants.MEMBER_FIRSTNAME));
		member.setLastName(rs.getString(Constants.MEMBER_LASTNAME));
		member.setAddress(rs.getString(Constants.MEMBER_ADDRESS));
		return member;
	
	}
}
