package com.lti.service;

import java.util.List;
import com.lti.dto.TaskDto;
import com.lti.pojo.Tasks;

public interface TaskService {

	void addTask(TaskDto taskInfo, Integer empId);
	List<Tasks> getEmployeeTask(int empId);
	void updateStatus(int taskId, String updatedStatus);

}
