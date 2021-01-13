package com.lti.controller;


import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.EmployeeDto;
import com.lti.dto.UpdateEmployeeDto;
import com.lti.exception.ServiceException;
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
		try {
			empServiceObj.registerEmployee(empInfo);
			status.setMessage("Registered Successfully");
			status.setStatus(statusType.SUCCESS);
			return status;
		}
		catch(ServiceException err) {
			status.setMessage(err.getMessage());
			status.setStatus(statusType.FAILURE);
			return status;
		}
	}
	
	@PutMapping(path="addEmployeeToProject")
	public Status addEmployee(@RequestParam int empId,@RequestParam int projectId) {
		try {
			empServiceObj.addEmployeee(empId,projectId);
			status.setMessage("Employee Added Successfully to the Project");
			status.setStatus(statusType.SUCCESS);
			return status;
		}
		catch(ServiceException err) {
			status.setMessage(err.getMessage());
			status.setStatus(statusType.FAILURE);
			return status;
		}
	}
	@DeleteMapping(path="removeEmployeeFromProject")
	public Status deleteEmployee(@RequestParam int empId,@RequestParam int projectId) {
		try {
			empServiceObj.deleteEmployeee(empId,projectId);
			status.setMessage("Employee Delete Successfully from the Project");
			status.setStatus(statusType.SUCCESS);
			return status;
		}
		catch(ServiceException err) {
			status.setMessage(err.getMessage());
			status.setStatus(statusType.FAILURE);
			return status;
		}
	}
	
	@GetMapping(path="getEmployees")
	public List<Employees> getEmployees(@RequestParam Integer projectId) {
		try {
		return empServiceObj.getEmployees(projectId);
		}
		catch (ServiceException err) {
			return Collections.emptyList();
		}
	}
	
	@PutMapping(path="updateEmployee")
	public Status UpdateEmployee(@RequestBody UpdateEmployeeDto empInfo,@RequestParam Integer empId) {
		try {
			empServiceObj.updateEmployee(empId,empInfo);
			status.setMessage("Employee Details updated successfully");
			status.setStatus(statusType.SUCCESS);
			return status;
		}
		catch(ServiceException err) {
			status.setMessage(err.getMessage());
			status.setStatus(statusType.FAILURE);
			return status;
		}
	}
	
	@GetMapping(path="employee/{empId}")
	public Employees getEmployee(@PathVariable int empId){
		try {
			return empServiceObj.getEmployee(empId);
		}
		catch(ServiceException err) {
			return new Employees();
		}
	}
	
}
