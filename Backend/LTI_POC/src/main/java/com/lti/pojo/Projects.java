package com.lti.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="project_info")
@NamedQuery(name="getAllProjects", query = "select t from Projects t where status='ACTIVE'")
@NamedQuery(name="isProjectEmpty",query="select count(*) from Projects ")
@NamedQuery(name="getProjectId",query="select max(t.projectId) from Projects t")
public class Projects {
	@Id
	@Column(length=5)
	private Integer projectId;
	@Column(length=30,nullable = false)
	private String projectName;
	@Column(length=30,nullable = false)
	private String applicationName;
	@Column(length=20)
	private String projectLocation;
	@Column(length=20,nullable=false)
	private String client;
	@Column
	private Integer sprint;
	@Column
	private String status;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="project_employee",
			joinColumns = @JoinColumn(name="projectId"),
			inverseJoinColumns=@JoinColumn(name="empId")
	)
	private Set<Employees> employees = new HashSet<>();
	
	public void addEmployee(Employees emp) {
		this.employees.add(emp);
	}
	
	public void removeEmployee(Employees emp) {
		this.employees.remove(emp);
	}

	public Set<Employees> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employees> employees) {
		this.employees = employees;
	}

	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getApplicationName() {
		return applicationName;
	}
	
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	public String getProjectLocation() {
		return projectLocation;
	}
	public void setProjectLocation(String projectLocation) {
		this.projectLocation = projectLocation;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public Integer getSprint() {
		return sprint;
	}
	public void setSprint(Integer sprint) {
		this.sprint = sprint;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Projects [projectId=" + projectId + ", projectName=" + projectName + ", applicationName="
				+ applicationName + ", projectLocation=" + projectLocation + ", client=" + client + ", sprint=" + sprint
				+ ", status=" + status + "]";
	}

	
}

