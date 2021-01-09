package com.lti.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.TaskDto;
import com.lti.exception.ServiceException;
import com.lti.pojo.Tasks;
import com.lti.service.TaskService;
import com.lti.status.Status;
import com.lti.status.Status.statusType;

@RestController
@CrossOrigin(origins = "http://localhost:4200",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
public class TaskController {
	
	@Autowired
	TaskService taskServiceObj;
	Status status = new Status();
	
	@PostMapping(path="addTask")
	public Status addTask(@RequestBody TaskDto taskInfo,@RequestParam Integer empId) {
		try {
			taskServiceObj.addTask(taskInfo,empId);
			status.setStatus(statusType.SUCCESS);
			status.setMessage("Task Added Successfully");
			return status;
		}
		catch(ServiceException err) {
			status.setStatus(statusType.FAILURE);
			status.setMessage(err.getMessage());
			return status;
		}
	}
	
	@GetMapping(path="getEmployeeTasks")
	public List<Tasks> getEmployeeTask(@RequestParam Integer empId){
		try {
		return taskServiceObj.getEmployeeTask(empId);
		}
		catch(ServiceException err) {
			return Collections.emptyList();
		}
	}
	
	@PutMapping(path="updateTaskStatus")
	public Status updateStatus(@RequestParam int taskId,@RequestParam String updatedStatus) {
		try {
			taskServiceObj.updateStatus(taskId,updatedStatus);
			status.setStatus(statusType.SUCCESS);
			status.setMessage("Task Status Updated");
			return status;
		}
		catch (ServiceException err) {
			status.setStatus(statusType.FAILURE);
			status.setMessage(err.getMessage());
			return status;
		}
	}
}	