package com.lti.dto;

public class TeamDto {
	private String teamName;
	private String applicationName;
	private String teamLocation;
	private int teamManagerId;
	private String client;
	
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
	public String getTeamLocation() {
		return teamLocation;
	}
	public void setTeamLocation(String teamLocation) {
		this.teamLocation = teamLocation;
	}
	public int getTeamManagerId() {
		return teamManagerId;
	}
	public void setTeamManagerId(int teamManagerId) {
		this.teamManagerId = teamManagerId;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
}
