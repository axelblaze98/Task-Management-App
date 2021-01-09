package com.lti.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="team_info")
@NamedQuery(name="getAllTeams", query = "select t from Teams t where status='ACTIVE'")
@NamedQuery(name="updateStatus",query="update Teams set Status='INACTIVE' where teamId=:id")
@NamedQuery(name="isTeamEmpty",query="select count(*) from Teams ")
@NamedQuery(name="getTeamId",query="select max(t.teamId) from Teams t")
public class Teams {
	@Id
	@Column(length=5)
	private Integer teamId;
	@Column(length=30,nullable = false)
	private String teamName;
	@Column(length=30,nullable = false)
	private String applicationName;
	@Column(length=5)
	Integer managerId;
	@Column(length=20)
	private String managerName;
	@Column
	private String teamLocation;
	@Column(length=20,nullable=false)
	private String client;
	@Column
	private String status;


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Integer getTeamId() {
		return teamId;
	}


	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}


	public String getTeamName() {
		return teamName;
	}


	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


	public String getApplicationName() {
		return applicationName;
	}


	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	
	public Integer getManagerId() {
		return managerId;
	}


	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}


	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}


	public String getTeamLocation() {
		return teamLocation;
	}


	public void setTeamLocation(String teamLocation) {
		this.teamLocation = teamLocation;
	}


	public String getClient() {
		return client;
	}


	public void setClient(String client) {
		this.client = client;
	}


	@Override
	public String toString() {
		return "Teams [teamId=" + teamId + ", teamName=" + teamName + ", applicationName=" + applicationName
				+ ", managerName=" + managerName + ", teamLocation=" + teamLocation + ", client=" + client + ", status="
				+ status + "]";
	}
	
}

