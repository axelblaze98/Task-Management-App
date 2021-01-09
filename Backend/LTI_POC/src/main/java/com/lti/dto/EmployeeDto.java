package com.lti.dto;

public class EmployeeDto {
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNo;
	private String designation;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "EmployeeDto [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", mobileNo="
				+ mobileNo + ", designation=" + designation + "]";
	}
	
	
	
}
