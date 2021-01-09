package com.lti.extraClasses;

public class EmployeeInfo {
	
	Integer empId;
	String empName;
	
	public Integer getEmployeeId() {
		return empId;
	}
	public void setEmployeeId(Integer empId) {
		this.empId = empId;
	}
	public String getEmployeeName() {
		return empName;
	}
	public void setEmployeeName(String empName) {
		this.empName = empName;
	}
	@Override
	public String toString() {
		return "EmployeeInfo [empId=" + empId + ", empName=" + empName + "]";
	}
	
	
	
}
