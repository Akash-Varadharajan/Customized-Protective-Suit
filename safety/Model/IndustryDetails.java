package com.safety.Model;

public class IndustryDetails {
	
	private int industryId;
	private String industryType;
	private String industryName;
	private String location;
	private String phoneNo;
	private int noOfEmp;
	private String webUrl;
	private String email;
	


	
	
	
	public IndustryDetails() {
		
	}
	public IndustryDetails(String industryType, String industryName, String location, String phoneNo, int noOfEmp,
			String webUrl,String email) {
		super();
		this.industryType = industryType;
		this.industryName = industryName;
		this.location = location;
		this.phoneNo = phoneNo;
		this.noOfEmp = noOfEmp;
		this.webUrl = webUrl;
		this.email = email;
	}
	
	public IndustryDetails(int industryId, String industryType, String industryName, String location, String phoneNo, int noOfEmp,
			String webUrl,String email) {
		
		super();
		this.industryId = industryId;
		this.industryType = industryType;
		this.industryName = industryName;
		this.location = location;
		this.phoneNo = phoneNo;
		this.noOfEmp = noOfEmp;
		this.webUrl = webUrl;
		this.email = email;
		
	}
	
	
	
	public int getIndustryId() {
		return industryId;
	}
	
	public String getIndustryType() {
		return industryType;
	}
	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}
	public String getIndustryName() {
		return industryName;
	}
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public int getNoOfEmp() {
		return noOfEmp;
	}
	public void setNoOfEmp(int noOfEmp) {
		this.noOfEmp = noOfEmp;
	}
	public String getWebUrl() {
		return webUrl;
	}
	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "IndustryDetails [industryId=" + industryId + ", industryType=" + industryType + ", industryName="
				+ industryName + ", location=" + location + ", phoneNo=" + phoneNo + ", noOfEmp=" + noOfEmp
				+ ", webUrl=" + webUrl + ", email=" + email + "]";
	}
	

	
	
}
