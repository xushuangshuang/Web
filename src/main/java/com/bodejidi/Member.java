package com.bodejidi;

public class Member
{
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String Email;
	private Long phone;
	private String address;
	private String action;

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getUsername()
	{
		return username;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPhone(Long phone)
	{
		this.phone = phone;
	}
	public Long getPhone()
	{
		return phone;
	}
	public void setEmail(String Email)
	{
		this.Email = Email;	
	}
	public String getEmail()
	{
		return Email;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAction(String action)
	{
		this.action = action;
	}
	public String getAction()
	{
		return action;
	}
}
