package com.lti.repository;

import java.util.List;

import com.lti.dto.UpdateEmployeeDto;
import com.lti.pojo.Employees;
import com.lti.pojo.Projects;

public interface EmployeeRepository {
	public Employees getEmployee(int empId);
	public void register(Employees empInfo);
	public boolean isEmpty();
	public int getEmpId();
	public void addEmployeeToProject(Projects project, Employees emp);
	public void deleteEmployeeFromProject(Projects project, Employees emp);
	public List<Employees> getEmployees();
	public void updateEmployee(Integer empId, UpdateEmployeeDto empInfo);
}
