package com.e_com.Entity;

public class JwtResponse {

	String token;
	
	public JwtResponse() {
	}

	public JwtResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
