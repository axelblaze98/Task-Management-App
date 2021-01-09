package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.exception.ServiceException;
import com.lti.pojo.Employees;
import com.lti.pojo.Tasks;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

	@PersistenceContext
	EntityManager emObj;
	
	Tasks task = new Tasks();
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (Long)emObj.createNamedQuery("isTaskEmpty").getSingleResult()==0 ? true: false;
	}

	@Override
	public int getTaskId() {
		// TODO Auto-generated method stub
		return (Integer)emObj.createNamedQuery("getTaskId").getSingleResult();
	}
	
	@Override
	@Transactional
	public void setTask(Tasks task) {
		// TODO Auto-generated method stub
		emObj.persist(task);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tasks> getEmployeeTask(Employees empInfo) {
		// TODO Auto-generated method stub
		return emObj.createNamedQuery("getEmployeeTask").setParameter("empId", empInfo).getResultList();
	}

	@Override
	@Transactional
	public void updateStatus(int taskId, String updatedStatus) {
		// TODO Auto-generated method stub
		task = getTask(taskId);
		task.setTaskStatus(updatedStatus);
	}
	
	public Tasks getTask(int taskId) {
		if(emObj.find(Tasks.class, taskId)==null) {
			throw new ServiceException("Task not Found");
		}
		return emObj.find(Tasks.class, taskId);
	}

	@Override
	@Transactional
	public void deleteTask(Employees empId) {
		// TODO Auto-generated method stub
		emObj.createNamedQuery("deleteEmployeeTask").setParameter("empId",empId).executeUpdate();
	}
}
