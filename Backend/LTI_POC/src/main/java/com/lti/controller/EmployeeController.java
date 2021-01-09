package com.lti.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.EmployeeDto;
import com.lti.dto.UpdateEmployeeDto;
import com.lti.exception.ServiceException;
import com.lti.extraClasses.EmployeeInfo;
import com.lti.pojo.Employees;
import com.lti.service.EmployeeService;
import com.lti.status.Status;
import com.lti.status.Status.statusType;

@RestController
@CrossOrigin(origins = "http://localhost:4200",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
public class EmployeeController {
	
	@Autowired
	EmployeeService empServiceObj;
	
	Status status = new Status();
	
	@PostMapping(path="registerEmployee")
	public Status registerEmployee(@RequestBody EmployeeDto empInfo) {
		empServiceObj.registerEmployee(empInfo);
		status.setMessage("Registered Successfully");
		status.setStatus(statusType.SUCCESS);
		return status;
	}
	
	@GetMapping(path="getEmployeeByTeam")
	public List<Employees> getTeamEmployees(@RequestParam int teamId) {
		try {
		return empServiceObj.getTeamEmployees(teamId);
		}
		catch (ServiceException err) 
		{
			return Collections.emptyList();
		}
	}
	
	@PutMapping(path="removeEmployee")
	public Status removeEmployeeFromTeam(@RequestParam int empId) {
		try {
			empServiceObj.removeEmployeeFromTeam(empId);
			status.setStatus(statusType.SUCCESS);
			status.setMessage("Employee Removed from the Team");
			return status;
		}
		catch(ServiceException err) {
			status.setStatus(statusType.FAILURE);
			status.setMessage(err.getMessage());
			return status;
		}
	}
	
	@PutMapping(path="addEmployee")
	public Status addEmployeeToTeam(@RequestParam int empId,@RequestParam int teamId) {
		try {
			empServiceObj.addEmployeeToTeam(empId,teamId);
			status.setStatus(statusType.SUCCESS);
			status.setMessage("Employee Added to the Team");
			return status;
		}
		catch(ServiceException err) {
			status.setStatus(statusType.FAILURE);
			status.setMessage(err.getMessage());
			return status;
		}
	}
	
	@PutMapping(path="updateEmployee")
	public Status updateEmployee(@RequestParam int empId,@RequestBody UpdateEmployeeDto empInfo) {
		try {
		empServiceObj.updateEmployee(empId,empInfo);
		status.setStatus(statusType.SUCCESS);
		status.setMessage("Employee's Information Updated");
		return status;
		}
		catch(ServiceException err) {
			status.setStatus(statusType.FAILURE);
			status.setMessage(err.getMessage());
			return status;
		}
	}
	
	@GetMapping(path="getBenchedManagers")
	public List<EmployeeInfo> getBenchedManagers(){
		return empServiceObj.getBenchedManagers();
	}
	
	@GetMapping(path="getBenchedEmployees")
	public List<EmployeeInfo> getBenchedEmployees(){
		return empServiceObj.getBenchedEmployees();
	}
	
	@GetMapping(path="getEmployee")
	public Employees getEmployee(@RequestParam Integer empId) {
		try {
		return empServiceObj.getEmployee(empId);
		}
		catch(ServiceException err){
			Employees emp = new Employees();
			return emp;
		}
	}
}
