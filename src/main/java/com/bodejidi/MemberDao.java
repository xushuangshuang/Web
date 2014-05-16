package com.bodejidi;

public class MemberDao
{
	public void userSave(Member member)
	{
	
		String Email = member.getEmail();
		String username = member.getUsername();
		String password = member.getPassword();
		String firstName = member.getFirstName();
		String lastName = member.getLastName();
		String address = member.getAddress();

		String tb_username_sql = "INSERT INTO tb_username (username, userEmail) VALUE(?, ?) ";
		String tb_personalInformation_sql = "INSERT INTO tb_personalInformation (username, password, firstName, lastName,  address) VALUE(?, ?, ?, ?, ?)";
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

}
