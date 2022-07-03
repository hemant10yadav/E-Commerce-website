package com.e_com.Entity;

public class JwtRequest {

	String username;
	String Password;
	
	
	public JwtRequest() {
		// TODO Auto-generated constructor stub
	}


	public JwtRequest(String username, String password) {
		this.username = username;
		Password = password;
	}


	public String getUsername() {
		System.out.println(username);
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		System.out.println(Password);
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}
	
	
	
}
