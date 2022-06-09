package com.examples.empapp.model;

public class User {
	
	private String userName;
	private String password;
	private String emailID;

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public User()
	{
		
	}

	public User(String userName, String password, String emailID) {
		this.userName = userName;
		this.password = password;
		this.emailID = emailID;
	}

	public User(String userName, String password)
	{
		this.userName = userName;
		this.password = password;
	}	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	

}
