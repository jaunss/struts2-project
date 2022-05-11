package com.joaogcm.struts2.hibernate.bean;

public class AuthenticateBean {

	private String username;
	private String password;

	public AuthenticateBean() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}