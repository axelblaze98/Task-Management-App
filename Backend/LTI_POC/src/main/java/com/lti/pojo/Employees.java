package com.lti.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="employee_info")
@NamedQuery(name="isEmployeeEmpty",query="select count(*) from Employees ")
@NamedQuery(name="getEmpId",query="select max(e.empId) from Employees e")
@NamedQuery(name="getEmployees",query = "select e from Employees e")
public class Employees {
	@Id
	@Column(length=5)
	private Integer empId;
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
	@ManyToMany(mappedBy = "employees")
	@JsonIgnore
	private Set<Projects> projects = new HashSet<>();
	
	public void addProject(Projects project) {
		this.projects.add(project);
	}
	public void removeProject(Projects project) {
		this.projects.remove(project);
	}
	public Set<Projects> getProjects() {
		return this.projects;
	}
	public void setProjects(Set<Projects> projects) {
		this.projects = projects;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
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
		return "Employees [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + ", designation=" + designation + ", projects=" + projects + "]";
	}
	
}
