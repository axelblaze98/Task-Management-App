package com.lti.repository;

import java.util.List;

import com.lti.dto.UpdateTeamDto;
import com.lti.pojo.Teams;

public interface TeamRepository {
	public void addTeam(Teams teamInfo);
	public Teams getTeamById(int teamId);
	public List<Teams> getAllTeams();
	public void updateTeamStatus(int teamId);
	public boolean isEmpty();
	public int getTeamId();
	public int getTeamManagerId(int teamId);
	public void updateDetails(UpdateTeamDto teamInfo,Integer teamId);
	public void updateManager(Integer managerId,Integer teamId,String managerName);
}
