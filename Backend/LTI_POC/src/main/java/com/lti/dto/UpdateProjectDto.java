package com.lti.dto;

public class UpdateProjectDto {
	
	String applicationName;
	String clientName;
	String projectName;
	
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
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String teamName) {
		this.projectName = teamName;
	}
	@Override
	public String toString() {
		return "UpdateTeamDto [applicationName=" + applicationName + ", clientName=" + clientName + ", teamName="
				+ projectName + "]";
	}
	
}
