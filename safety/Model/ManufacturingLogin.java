package com.safety.Model;

public class ManufacturingLogin {
	
	private String email;
	private String password;
	
	
	
	public ManufacturingLogin() {
		
	}
	public ManufacturingLogin(String email, String password) {
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
		return "ManufacturingLogin [email=" + email + ", password=" + password + "]";
	}
	
	
}
