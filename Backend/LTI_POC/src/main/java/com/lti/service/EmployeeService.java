package com.lti.service;

import com.lti.dto.EmployeeDto;


public interface EmployeeService {
	public void registerEmployee(EmployeeDto empInfo);
	public void addEmployeee(int empId, int projectId);
	public void deleteEmployeee(int empId, int projectId);
}
