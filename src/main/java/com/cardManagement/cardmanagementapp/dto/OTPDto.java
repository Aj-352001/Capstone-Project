package com.cardManagement.cardmanagementapp.dto;

public class OTPDto {
	
	private String email;
	private Integer otp;
	
	public OTPDto() {
		super();
	}
	public OTPDto(String email, Integer otp) {
		super();
		this.email = email;
		this.otp = otp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getOtp() {
		return otp;
	}
	public void setOtp(Integer otp) {
		this.otp = otp;
	}
	
	

}
