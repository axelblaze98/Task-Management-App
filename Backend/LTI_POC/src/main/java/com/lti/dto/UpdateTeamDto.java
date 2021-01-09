package com.lti.dto;

public class UpdateTeamDto {
	
	String applicationName;
	String clientName;
	String teamName;
	
	public String getApplicationName() {
		return applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	@Override
	public String toString() {
		return "UpdateTeamDto [applicationName=" + applicationName + ", clientName=" + clientName + ", teamName="
				+ teamName + "]";
	}
	
}
