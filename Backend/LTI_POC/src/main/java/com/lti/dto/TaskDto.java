package com.lti.dto;

public class TaskDto {
	
	String taskJiraId;
	String taskDescription;
	String task;
	public String getTaskJiraId() {
		return taskJiraId;
	}
	public void setTaskJiraId(String taskJiraId) {
		this.taskJiraId = taskJiraId;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	@Override
	public String toString() {
		return "TaskDto [taskJiraId=" + taskJiraId + ", taskDescription=" + taskDescription + ", task=" + task + "]";
	}
	
	
}
