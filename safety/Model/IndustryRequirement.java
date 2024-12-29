package com.safety.Model;

public class IndustryRequirement {
	
	private int industryId;
	private String industryType;
	private float minTemp;
	private float maxTemp;
	private float minCold;
	private float maxCold;
	private float minPressure;
	private float maxPressure;
	private int flexibility;
	private String status;
	private String email;
	

	public IndustryRequirement() {
		
	}
	public IndustryRequirement(int industryId, String industryType, float minTemp, float maxTemp, float minCold,
			float maxCold, float minPressure, float maxPressure, int flexibility, String status, String email) {
		super();
		this.industryId = industryId;
		this.industryType = industryType;
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
		this.minCold = minCold;
		this.maxCold = maxCold;
		this.minPressure = minPressure;
		this.maxPressure = maxPressure;
		this.flexibility = flexibility;
		this.status = status;
		this.email = email;
	}
	public int getIndustryId() {
		return industryId;
	}
	public void setIndustryId(int industryId) {
		this.industryId = industryId;
	}
	public String getIndustryType() {
		return industryType;
	}
	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}
	public float getMinTemp() {
		return minTemp;
	}
	public void setMinTemp(float minTemp) {
		this.minTemp = minTemp;
	}
	public float getMaxTemp() {
		return maxTemp;
	}
	public void setMaxTemp(float maxTemp) {
		this.maxTemp = maxTemp;
	}
	public float getMinCold() {
		return minCold;
	}
	public void setMinCold(float minCold) {
		this.minCold = minCold;
	}
	public float getMaxCold() {
		return maxCold;
	}
	public void setMaxCold(float maxCold) {
		this.maxCold = maxCold;
	}
	public float getMinPressure() {
		return minPressure;
	}
	public void setMinPressure(float minPressure) {
		this.minPressure = minPressure;
	}
	public float getMaxPressure() {
		return maxPressure;
	}
	public void setMaxPressure(float maxPressure) {
		this.maxPressure = maxPressure;
	}
	public int getFlexibility() {
		return flexibility;
	}
	public void setFlexibility(int flexibility) {
		this.flexibility = flexibility;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "IndustryRequirement [industryId=" + industryId + ", industryType=" + industryType + ", minTemp="
				+ minTemp + ", maxTemp=" + maxTemp + ", minCold=" + minCold + ", maxCold=" + maxCold + ", minPressure="
				+ minPressure + ", maxPressure=" + maxPressure + ", flexibility=" + flexibility + ", status=" + status
				+ ", email=" + email + "]";
	}
	
}
