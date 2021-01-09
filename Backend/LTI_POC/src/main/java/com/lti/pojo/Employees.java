package com.lti.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="employee_info")
@NamedQuery(name="isEmployeeEmpty",query="select count(*) from Employees ")
@NamedQuery(name="getEmpId",query="select max(e.empId) from Employees e")
@NamedQuery(name="updateBench",query="update Employees set teamInfo=:bench where teamInfo=:id")
@NamedQuery(name="getEmployeesOfTeam",query="select e from Employees e where e.teamInfo=:teamId")
@NamedQuery(name="getBenchedManagers",query="select e from Employees e where e.teamInfo=:teamId and e.designation='Manager'")
@NamedQuery(name="getBenchedEmployees",query="select e from Employees e where e.teamInfo=:teamId and e.designation!='Manager'")
public class Employees {
	@Id
	@Column(length=5)
	private Integer empId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="teamId",nullable=false)
	private Teams teamInfo;
	@Column(length=15,nullable = false)
	private String firstName;
	@Column(length=15,nullable=false)
	private String lastName;
	@Column(length=30,nullable=false)
	private String email;
	@Column(length=10,nullable=false)
	private String mobileNumber;
	@Column(length=15,nullable=false)
	private String designation;
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public Teams getTeamId() {
		return teamInfo;
	}
	public void setTeamId(Teams teamId) {
		this.teamInfo = teamId;
	}
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
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "Employees [empId=" + empId + ", teamInfo=" + teamInfo + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", mobileNumber=" + mobileNumber + ", designation=" + designation
				+ "]";
	}
}
