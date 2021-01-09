package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.lti.dto.UpdateTeamDto;
import com.lti.exception.ServiceException;
import com.lti.pojo.Teams;

@Repository
public class TeamRepositoryImpl implements TeamRepository {
	
	@PersistenceContext 
	private EntityManager emObj;
	
	Teams team = new Teams();
	
	@Transactional
	@Override
	public void addTeam(Teams teamInfo) {
		// TODO Auto-generated method stub
		emObj.persist(teamInfo);
	}

	@Override
	public Teams getTeamById(int teamId) {
		// TODO Auto-generated method stub
		if(emObj.find(Teams.class, teamId)==null) {
			throw new ServiceException("Team Doesn't Exist");
		}
		return emObj.find(Teams.class, teamId);
	}
	
	@Transactional
	@Override
	public void updateTeamStatus(int teamId) {
		// TODO Auto-generated method stub
		emObj.createNamedQuery("updateStatus")
		.setParameter("id",teamId).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teams> getAllTeams() {
		// TODO Auto-generated method stub
		return emObj.createNamedQuery("getAllTeams").getResultList();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub

		return (Long)emObj.createNamedQuery("isTeamEmpty").getSingleResult()==0 ? true : false;
	}

	@Override
	public int getTeamId() {
		// TODO Auto-generated method stub
		return (Integer)emObj.createNamedQuery("getTeamId").getSingleResult();
	}

	@Override
	@Transactional
	public void updateDetails(UpdateTeamDto teamInfo,Integer teamId) {
		// TODO Auto-generated method stub
		team=getTeamById(teamId);
		
		team.setApplicationName(teamInfo.getApplicationName());
		team.setClient(teamInfo.getClientName());
		team.setTeamName(teamInfo.getTeamName());
		
	}

	@Override
	@Transactional
	public void updateManager(Integer managerId, Integer teamId,String managerName) {
		// TODO Auto-generated method stub
		team=getTeamById(teamId);
		
		team.setManagerId(managerId);
		team.setManagerName(managerName);
	}

	@Override
	public int getTeamManagerId(int teamId) {
		// TODO Auto-generated method stub
		team = getTeamById(teamId);
		return team.getManagerId();
	}

}
