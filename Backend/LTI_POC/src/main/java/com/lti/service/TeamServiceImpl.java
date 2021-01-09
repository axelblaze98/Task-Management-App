package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.TeamDto;
import com.lti.dto.UpdateTeamDto;
import com.lti.exception.ServiceException;
import com.lti.pojo.Employees;
import com.lti.pojo.Teams;
import com.lti.repository.EmployeeRepository;
import com.lti.repository.TeamRepository;

@Service
public class TeamServiceImpl implements TeamService {
	
	@Autowired
	private TeamRepository teamRepoObj;
	@Autowired
	private EmployeeRepository empRepoObj;
	
	private Teams team = new Teams();
	@Override
	public void addTeam(TeamDto teamInfo) {
		// TODO Auto-generated method stub
		int teamId = 14325;
		
		if(teamRepoObj.isEmpty()) team.setTeamId(teamId);
		else {
			teamId = teamRepoObj.getTeamId();
			team.setTeamId(teamId+1);
		}
		
		if(!empRepoObj.getEmployeeDesignation(teamInfo.getTeamManagerId()).equals("Manager")) 
		{
			throw new ServiceException("Please Enter the Employee Id of a Manager");
		}
		if(empRepoObj.getTeamId(teamInfo.getTeamManagerId())!=14325) {
			throw new ServiceException("Please Enter the EmployeeId of Manager on Bench");
		}
		team.setManagerId(teamInfo.getTeamManagerId());
		team.setManagerName(empRepoObj.getEmployeeNameById(teamInfo.getTeamManagerId()));
		team.setApplicationName(teamInfo.getApplicationName());
		team.setClient(teamInfo.getClient());
		team.setTeamName(teamInfo.getTeamName());
		team.setTeamLocation(teamInfo.getTeamLocation());
		team.setStatus("ACTIVE");
		
		
		teamRepoObj.addTeam(team);
		
		empRepoObj.updateTeamId(teamInfo.getTeamManagerId(),team);
	}
	@Override
	public void deleteTeam(int teamId) {
		// TODO Auto-generated method stub
		teamRepoObj.updateTeamStatus(teamId);
		empRepoObj.moveToBench(teamRepoObj.getTeamById(14325),teamRepoObj.getTeamById(teamId));
	}
	@Override
	public List<Teams> getAllTeams() {
		// TODO Auto-generated method stub
		return teamRepoObj.getAllTeams();
	}
	@Override
	public void updateTeamDetails(UpdateTeamDto teamInfo,Integer teamId) {
		// TODO Auto-generated method stub
		teamRepoObj.updateDetails(teamInfo,teamId);
	}
	@Override
	public void updateManager(Integer managerId, Integer teamId) {
		// TODO Auto-generated method stub
		if(!empRepoObj.getEmployeeDesignation(managerId).equals("Manager")) 
		{
			throw new ServiceException("Please Enter the Employee Id of a Manager");
		}
		if(empRepoObj.getTeamId(managerId)!=14325) {
			throw new ServiceException("Please Enter the EmployeeId of Manager on Bench");
		}
		empRepoObj.updateTeamId(teamRepoObj.getTeamManagerId(teamId),teamRepoObj.getTeamById(14325));
		teamRepoObj.updateManager(managerId,teamId,empRepoObj.getEmployeeNameById(managerId));
		empRepoObj.updateTeamId(managerId,teamRepoObj.getTeamById(teamId));
	}
	@Override
	public Teams getTeamById(int teamId) {
		// TODO Auto-generated method stub
		return teamRepoObj.getTeamById(teamId);
	}
}
