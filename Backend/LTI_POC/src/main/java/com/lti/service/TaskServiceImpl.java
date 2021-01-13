package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.TaskDto;
import com.lti.pojo.Employees;
import com.lti.pojo.Tasks;
import com.lti.repository.EmployeeRepository;
import com.lti.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	TaskRepository taskRepoObj;
	@Autowired
	EmployeeRepository empRepoObj;
	
	Tasks task = new Tasks();
	Employees emp = new Employees();
	@Override
	public void addTask(TaskDto taskInfo, Integer empId) {
		// TODO Auto-generated method stub
	
		int taskId = 13579;
		
		if(taskRepoObj.isEmpty()) {
			task.setTaskId(taskId);
			}
		
		else {
			taskId = taskRepoObj.getTaskId();
			task.setTaskId(taskId+1);
		}
		
		task.setTaskJiraId(taskInfo.getTaskJiraId());
		task.setTaskDescription(taskInfo.getTaskDescription());
		task.setTask(taskInfo.getTask());
		task.setTaskStatus("Assigned");
		task.setEmpInfo(empRepoObj.getEmployee(empId));
		
		taskRepoObj.setTask(task);
	}
	@Override
	public List<Tasks> getEmployeeTask(int empId) {
		// TODO Auto-generated method stub
		return taskRepoObj.getEmployeeTask(empRepoObj.getEmployee(empId));
	}
	@Override
	public void updateStatus(int taskId, String updatedStatus) {
		// TODO Auto-generated method stub
		taskRepoObj.updateStatus(taskId,updatedStatus);
	}

}
