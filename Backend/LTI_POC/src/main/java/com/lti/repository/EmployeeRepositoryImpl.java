package com.lti.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.dto.UpdateEmployeeDto;
import com.lti.exception.ServiceException;
import com.lti.pojo.Employees;
import com.lti.pojo.Teams;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
	
	@PersistenceContext
	private EntityManager emObj;
	private Employees emp = new Employees();
	
	@Transactional
	@Override
	public void register(Employees empInfo) {
		// TODO Auto-generated method stub
		emObj.persist(empInfo);
	}
	
	public Employees getEmployee(int empId) {
		if(emObj.find(Employees.class,empId)==null) {
			throw new ServiceException("Employee Doesn't Exist");
		}
		
		return emObj.find(Employees.class,empId);
	}
	@Override
	public String getEmployeeNameById(int empId) {
		// TODO Auto-generated method stub
		emp = getEmployee(empId);
		return emp.getFirstName()+" "+emp.getLastName();
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
	@Transactional
	public void updateTeamId(int empId,Teams teamInfo) {
		// TODO Auto-generated method stub
		emp = getEmployee(empId);
		emp.setTeamId(teamInfo);
	}

	@Override
	@Transactional
	public void moveToBench(Teams bench,Teams deletedTeam) {
		// TODO Auto-generated method stub
		
		emObj.createNamedQuery("updateBench")
		.setParameter("bench", bench)
		.setParameter("id", deletedTeam)
		.executeUpdate();
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employees> getTeamEmployees(Teams teamId) {
		// TODO Auto-generated method stub
		return (List<Employees>)emObj.createNamedQuery("getEmployeesOfTeam").setParameter("teamId", teamId).getResultList();
	}

	@Override
	public String getEmployeeDesignation(int empId) {
		// TODO Auto-generated method stub
		emp = getEmployee(empId);
		return emp.getDesignation();
		
	}

	@Override
	public int getTeamId(int empId) {
		// TODO Auto-generated method stub
		emp= getEmployee(empId);
		return emp.getTeamId().getTeamId();
	}

	@Override
	@Transactional
	public void updateEmployeeInfo(int empId, UpdateEmployeeDto empInfo) {
		// TODO Auto-generated method stub
		emp = getEmployee(empId);
		
		emp.setFirstName(empInfo.getFirstName());
		emp.setLastName(empInfo.getLastName());
		emp.setMobileNumber(empInfo.getMobNo());
		emp.setEmail(empInfo.getEmailId());
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Employees> getBenchManagers(Teams teamId) {
		// TODO Auto-generated method stub
		return (ArrayList<Employees>)emObj.createNamedQuery("getBenchedManagers").setParameter("teamId", teamId).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Employees> getBenchedEmployees(Teams teamId) {
		// TODO Auto-generated method stub
		return (ArrayList<Employees>)emObj.createNamedQuery("getBenchedEmployees").setParameter("teamId", teamId).getResultList();
	}
	
	
	
}
