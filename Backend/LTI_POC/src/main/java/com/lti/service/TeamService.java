package com.lti.service;

import java.util.List;

import com.lti.dto.TeamDto;
import com.lti.dto.UpdateTeamDto;
import com.lti.pojo.Employees;
import com.lti.pojo.Teams;

public interface TeamService {
	public void addTeam(TeamDto teamInfo);
	public void deleteTeam(int teamId);
	public List<Teams> getAllTeams();
	public void updateTeamDetails(UpdateTeamDto teamInfo,Integer teamId);
	public void updateManager(Integer managerId, Integer teamId);
	public Teams getTeamById(int teamId);
}
