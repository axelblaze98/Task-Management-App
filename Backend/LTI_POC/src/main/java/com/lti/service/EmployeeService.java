package com.lti.service;

import java.util.List;

import com.lti.dto.EmployeeDto;
import com.lti.dto.UpdateEmployeeDto;
import com.lti.pojo.Employees;


public interface EmployeeService {
	public void registerEmployee(EmployeeDto empInfo);
	public void addEmployeee(int empId, int projectId);
	public void deleteEmployeee(int empId, int projectId);
	public List<Employees> getEmployees(Integer projectId);
	public void updateEmployee(Integer empId, UpdateEmployeeDto empInfo);
	public Employees getEmployee(int empId);
}
