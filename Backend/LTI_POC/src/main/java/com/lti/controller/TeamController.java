package com.lti.controller;

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

import com.lti.dto.TeamDto;
import com.lti.dto.UpdateTeamDto;
import com.lti.exception.ServiceException;
import com.lti.pojo.Teams;
import com.lti.service.TeamService;
import com.lti.status.Status;
import com.lti.status.Status.statusType;

@RestController
@CrossOrigin(origins = "http://localhost:4200",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class TeamController {
	
	@Autowired
	private TeamService teamServiceObj;
	
	private Status status = new Status();
	
	@PostMapping(path="addTeam")
	public Status addTeam(@RequestBody TeamDto teamInfo) {
		try {
		teamServiceObj.addTeam(teamInfo);
		status.setStatus(statusType.SUCCESS);
		status.setMessage("Team Added Successfully");
		return status;
		}
		catch(ServiceException err) {
			status.setStatus(statusType.FAILURE);
			status.setMessage(err.getMessage());
			return status;
		}
	}
	
	@DeleteMapping(path="deleteTeam")
	public Status deleteTeam(@RequestParam int teamId) {
		try{
			teamServiceObj.deleteTeam(teamId);
			status.setStatus(statusType.SUCCESS);
			status.setMessage("Teams Data Successfully Deleted");
			return status;
			}
		catch(ServiceException err) {
			status.setStatus(statusType.FAILURE);
			status.setMessage(err.getMessage());
			return status;
		}
	}
	
	@GetMapping(path="getTeams")
	public List<Teams> getTeams(){
		return teamServiceObj.getAllTeams();
		
	}
	
	@GetMapping(path="getTeam/{teamId}")
	public Teams getTeamById(@PathVariable Integer teamId) {
		try{
			return teamServiceObj.getTeamById(teamId);
		}
		catch(ServiceException err) {
			Teams teamObj = new Teams();
			return teamObj;
		}
		
	}

	@PutMapping(path="updateTeamDetails")
	public Status updateTeamDetails(@RequestBody UpdateTeamDto teamInfo,@RequestParam Integer teamId) {
		try {
			teamServiceObj.updateTeamDetails(teamInfo,teamId);
			status.setStatus(statusType.SUCCESS);
			status.setMessage("Team Information Updated");
			return status;
		}
		catch(ServiceException err) {
			status.setMessage(err.getMessage());
			status.setStatus(statusType.FAILURE);
			return status;
		}
	}
	@PutMapping(path="updateManager")
	public Status updateManager(@RequestParam Integer managerId,@RequestParam Integer teamId) {
		try {
			teamServiceObj.updateManager(managerId,teamId);
			status.setMessage("Manager Updated");
			status.setStatus(statusType.SUCCESS);
			return status;
		}
		catch(ServiceException err) {
			status.setMessage(err.getMessage());
			status.setStatus(statusType.FAILURE);
			return status;
		}
	}
}