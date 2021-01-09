package com.lti.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.EmployeeDto;
import com.lti.dto.UpdateEmployeeDto;
import com.lti.exception.ServiceException;
import com.lti.extraClasses.EmployeeInfo;
import com.lti.pojo.Employees;
import com.lti.repository.EmployeeRepository;
import com.lti.repository.TaskRepository;
import com.lti.repository.TeamRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository empRepoObj;
	@Autowired
	TeamRepository teamRepoObj;
	@Autowired 
	TaskRepository taskRepoObj;
	
	Employees emp = new Employees();
	
	ArrayList<Employees> EmployeesDetails = new ArrayList<Employees>();
	
	@Override
	public void registerEmployee(EmployeeDto empInfo) {
		// TODO Auto-generated method stub
		int empId=96785;
		if(empRepoObj.isEmpty()) emp.setEmpId(empId);
		else {
			empId = empRepoObj.getEmpId();
			emp.setEmpId(empId+1);
		}
		emp.setFirstName(empInfo.getFirstName());
		emp.setLastName(empInfo.getLastName());
		emp.setEmail(empInfo.getEmail());
		emp.setMobileNumber(empInfo.getMobileNo());
		emp.setDesignation(empInfo.getDesignation());
		emp.setTeamId(teamRepoObj.getTeamById(14325));

		empRepoObj.register(emp);
		
	}

	@Override
	public List<Employees> getTeamEmployees(int teamId) {
		// TODO Auto-generated method stub
		return empRepoObj.getTeamEmployees(teamRepoObj.getTeamById(teamId));
	}

	@Override
	public void removeEmployeeFromTeam(int empId) {
		// TODO Auto-generated method stub
		taskRepoObj.deleteTask(empRepoObj.getEmployee(empId));
		empRepoObj.updateTeamId(empId,teamRepoObj.getTeamById(14325));
	}

	@Override
	public void addEmployeeToTeam(int empId, int teamId) {
		// TODO Auto-generated method stub
		if(empRepoObj.getTeamId(empId)!=14325) {
			throw new ServiceException("Employee Already a part of Another Team");
		}
		empRepoObj.updateTeamId(empId,teamRepoObj.getTeamById(teamId));
	}

	@Override
	public void updateEmployee(int empId, UpdateEmployeeDto empInfo) {
		// TODO Auto-generated method stub
		System.out.println(empInfo);
		empRepoObj.updateEmployeeInfo(empId,empInfo);
	}

	@Override
	public List<EmployeeInfo> getBenchedManagers() {
		// TODO Auto-generated method stub
		
		ArrayList<EmployeeInfo> BenchedEmployees = new ArrayList<EmployeeInfo>();
		
		EmployeesDetails = empRepoObj.getBenchManagers(teamRepoObj.getTeamById(14325));
		
		for(Employees employee:EmployeesDetails) 
		{	
			
			EmployeeInfo benchedEmp = new EmployeeInfo();
			benchedEmp.setEmployeeId(employee.getEmpId());
			benchedEmp.setEmployeeName(empRepoObj.getEmployeeNameById(employee.getEmpId()));
			BenchedEmployees.add(benchedEmp);
		}
		return BenchedEmployees;
	}

	@Override
	public List<EmployeeInfo> getBenchedEmployees() {
		// TODO Auto-generated method stub
		EmployeesDetails = empRepoObj.getBenchedEmployees(teamRepoObj.getTeamById(14325));
		
		ArrayList<EmployeeInfo> BenchedEmployees = new ArrayList<EmployeeInfo>();
		for(Employees employee:EmployeesDetails) 
		{	
			
			EmployeeInfo benchedEmp = new EmployeeInfo();
			benchedEmp.setEmployeeId(employee.getEmpId());
			benchedEmp.setEmployeeName(empRepoObj.getEmployeeNameById(employee.getEmpId()));
			BenchedEmployees.add(benchedEmp);
		}
		return BenchedEmployees;
	}

	@Override
	public Employees getEmployee(Integer empId) {
		// TODO Auto-generated method stub
		return empRepoObj.getEmployee(empId);
	}

}
