package com.lti.repository;

import java.util.ArrayList;
import java.util.List;

import com.lti.dto.UpdateEmployeeDto;
import com.lti.pojo.Employees;
import com.lti.pojo.Teams;

public interface EmployeeRepository {
	public Employees getEmployee(int empId);
	public void register(Employees empInfo);
	public String getEmployeeNameById(int empId); 
	public boolean isEmpty();
	public int getEmpId();
	public void updateTeamId(int empId,Teams teamInfo);
	public void moveToBench(Teams bench,Teams deletedTeam);
	public List<Employees> getTeamEmployees(Teams teamId);
	public String getEmployeeDesignation(int empId);
	public int getTeamId(int empId);
	public void updateEmployeeInfo(int empId, UpdateEmployeeDto empInfo);
	public ArrayList<Employees> getBenchManagers(Teams teamId);
	public ArrayList<Employees> getBenchedEmployees(Teams teamId);
}
