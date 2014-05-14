package com.bodejidi;

public class MemberDao
{
	public void save(Member member)
	{
		String sql = "INSERT INTO tb_username (username, userEmail, ordered, ordering, orderedlist, orderingDate) ";
		DatabaseService bs = DatabaseService.newInstance();
		try
		{
			bs.prepare(sql)
				.setString()
		}
	}

}
