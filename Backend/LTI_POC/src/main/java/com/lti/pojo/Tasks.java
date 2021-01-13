package com.lti.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="task_info")
@NamedQuery(name = "isTaskEmpty",query = "select count(*) from Tasks")
@NamedQuery(name = "getTaskId",query = "select max(t.taskId) from Tasks t")
@NamedQuery(name = "getEmployeeTask",query="select t from Tasks t where empInfo=:empId")
public class Tasks {
	@Id
	@Column(length=5)
	private Integer taskId;
	@Column(length=8,nullable=false)
	private String taskJiraId;
	@Column(length=20,nullable=false)
	private String taskStatus;
	@Column(length=200)
	private String task;
	@Column(length=30)
	private String taskDescription;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="empId",nullable=false)
	@JsonIgnore
	private Employees empInfo;
	
	
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public String getTaskJiraId() {
		return taskJiraId;
	}
	public void setTaskJiraId(String taskJiraId) {
		this.taskJiraId = taskJiraId;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	public Employees getEmpInfo() {
		return empInfo;
	}
	public void setEmpInfo(Employees empInfo) {
		this.empInfo = empInfo;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	@Override
	public String toString() {
		return "Tasks [taskId=" + taskId + ", taskJiraId=" + taskJiraId + ", taskStatus=" + taskStatus + ", task="
				+ task + ", taskDescription=" + taskDescription + ", empInfo=" + empInfo + "]";
	}
}
