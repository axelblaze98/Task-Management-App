package com.lti.dto;

public class TaskDto {
	
	String taskJiraId;
	String taskDescription;
	
	public String getTaskJiraId() {
		return taskJiraId;
	}
	public void setTaskJiraID(String taskJiraId) {
		this.taskJiraId = taskJiraId;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	@Override
	public String toString() {
		return "TaskDto [taskJiraID=" + taskJiraId + ", taskDescription=" + taskDescription + "]";
	}
	
	
	
}
