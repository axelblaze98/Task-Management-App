package com.lti.repository;

import java.util.List;

import com.lti.pojo.Employees;
import com.lti.pojo.Tasks;

public interface TaskRepository {

	public boolean isEmpty();
	public int getTaskId();
	public void setTask(Tasks task);
	public List<Tasks> getEmployeeTask(Employees empInfo);
	public void updateStatus(int taskId, String updatedStatus);
}
