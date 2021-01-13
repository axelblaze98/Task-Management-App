package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.dto.UpdateEmployeeDto;
import com.lti.exception.ServiceException;
import com.lti.pojo.Employees;
import com.lti.pojo.Projects;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
	
	@PersistenceContext
	private EntityManager emObj;
	
	Employees emp = new Employees();
	
	@Transactional
	@Override
	public void register(Employees empInfo) {
		// TODO Auto-generated method stub
		emObj.persist(empInfo);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (Long)emObj.createNamedQuery("isEmployeeEmpty").getSingleResult()==0 ? true : false;
	}

	@Override
	public int getEmpId() {
		// TODO Auto-generated method stub
		return (Integer)emObj.createNamedQuery("getEmpId").getSingleResult();
	}

	@Override
	public Employees getEmployee(int empId) {
		// TODO Auto-generated method stub
		if(emObj.find(Employees.class, empId)==null) {
			throw new ServiceException("Employee Doesn't Exist");
		}
		return emObj.find(Employees.class, empId);
	}

	@Override
	@Transactional
	public void addEmployeeToProject(Projects project, Employees emp) {
		// TODO Auto-generated method stub
		project.addEmployee(emp);
		emp.addProject(project);
	}

	@Override
	@Transactional
	public void deleteEmployeeFromProject(Projects project, Employees emp) {
		// TODO Auto-generated method stub
		project.removeEmployee(emp);
		emp.removeProject(project);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employees> getEmployees() {
		// TODO Auto-generated method stub
		return emObj.createNamedQuery("getEmployees").getResultList();
	}

	@Override
	@Transactional
	public void updateEmployee(Integer empId, UpdateEmployeeDto empInfo) {
		// TODO Auto-generated method stub
		emp = getEmployee(empId);
		emp.setFirstName(empInfo.getFirstName());
		emp.setLastName(empInfo.getLastName());
		emp.setEmail(empInfo.getEmailId());
		emp.setMobileNumber(empInfo.getMobNo());
	}
	
	
}
