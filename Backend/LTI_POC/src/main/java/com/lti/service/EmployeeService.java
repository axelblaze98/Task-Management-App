package com.lti.service;

import java.util.List;

import com.lti.dto.EmployeeDto;
import com.lti.dto.UpdateEmployeeDto;
import com.lti.extraClasses.EmployeeInfo;
import com.lti.pojo.Employees;

public interface EmployeeService {
	public void registerEmployee(EmployeeDto empInfo);
	public List<Employees> getTeamEmployees(int teamId);
	public void removeEmployeeFromTeam(int empId);
	public void addEmployeeToTeam(int empId, int teamId);
	public void updateEmployee(int empId, UpdateEmployeeDto empInfo);
	public List<EmployeeInfo> getBenchedManagers();
	public List<EmployeeInfo> getBenchedEmployees();
	public Employees getEmployee(Integer empId);
}
