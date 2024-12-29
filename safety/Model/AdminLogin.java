package com.safety.Model;

public class AdminLogin {
	
	private String email;
	private String password;

	public AdminLogin() {
		
	}
	public AdminLogin(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AdminLogin [email=" + email + ", password=" + password + "]";
	}
	
	
	
	
}