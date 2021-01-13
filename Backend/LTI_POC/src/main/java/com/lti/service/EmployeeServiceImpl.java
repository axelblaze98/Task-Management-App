package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.EmployeeDto;
import com.lti.dto.UpdateEmployeeDto;
import com.lti.exception.ServiceException;
import com.lti.pojo.Employees;
import com.lti.pojo.Projects;
import com.lti.repository.EmployeeRepository;
import com.lti.repository.TaskRepository;
import com.lti.repository.ProjectRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository empRepoObj;
	@Autowired
	ProjectRepository projectRepoObj;
	@Autowired 
	TaskRepository taskRepoObj;
	
	Employees emp = new Employees();
	Projects project = new Projects();
	
	@Override
	public void registerEmployee(EmployeeDto empInfo) {
		// TODO Auto-generated method stub
		int empId=96785;
		if(empRepoObj.isEmpty()) emp.setEmpId(empId);
		else {
			empId = empRepoObj.getEmpId();
			emp.setEmpId(empId+1);
		}
		project = projectRepoObj.getProjectById(empInfo.getProjectId());
		emp.setFirstName(empInfo.getFirstName());
		emp.setLastName(empInfo.getLastName());
		emp.setEmail(empInfo.getEmail());
		emp.setMobileNumber(empInfo.getMobileNo());
		emp.setDesignation(empInfo.getDesignation());
		emp.addProject(project);
		project.addEmployee(emp);
		empRepoObj.register(emp);
		
	}

	@Override
	public void addEmployeee(int empId, int projectId) {
		// TODO Auto-generated method stub
		emp = empRepoObj.getEmployee(empId);
		project = projectRepoObj.getProjectById(projectId);
		empRepoObj.addEmployeeToProject(project,emp);
	}

	@Override
	public void deleteEmployeee(int empId, int projectId) {
		// TODO Auto-generated method stub
		emp = empRepoObj.getEmployee(empId);
		project = projectRepoObj.getProjectById(projectId);
		
		if(emp.getProjects().contains(project) && project.getEmployees().contains(emp)) {
			empRepoObj.deleteEmployeeFromProject(project,emp);
		}
		else throw new ServiceException("Employee Doesn't exist in this project");
	}

	@Override
	public List<Employees> getEmployees(Integer projectId) {
		// TODO Auto-generated method stub
		project = projectRepoObj.getProjectById(projectId);
		List<Employees> employees = empRepoObj.getEmployees();
		employees.removeAll(project.getEmployees());
		return employees;
	}

	@Override
	public void updateEmployee(Integer empId,UpdateEmployeeDto empInfo) {
		// TODO Auto-generated method stub
		empRepoObj.updateEmployee(empId,empInfo);
	}

	@Override
	public Employees getEmployee(int empId) {
		// TODO Auto-generated method stub
		return empRepoObj.getEmployee(empId);
	}
	
	
}
