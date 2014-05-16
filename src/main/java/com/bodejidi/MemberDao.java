package com.bodejidi;

public class MemberDao
{
	public void userSave(Member member)
	{
		String sql = "INSERT INTO tb_username (username, userEmail) VALUE(?, ?) ";
		DatabaseService bs = DatabaseService.newInstance();
		try
		{
			bs.prepare(sql)
				.setString(member.getUsername())
				.setString(member.getEmail())
				.execute();
			System.out.println("SQL: " + sql);
		}
		catch(Exception e)
		{
			
		}

	

	}

}
