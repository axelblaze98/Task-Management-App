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

import com.lti.dto.ProjectDto;
import com.lti.dto.UpdateProjectDto;
import com.lti.exception.ServiceException;
import com.lti.pojo.Projects;
import com.lti.service.ProjectService;
import com.lti.status.Status;
import com.lti.status.Status.statusType;

@RestController
@CrossOrigin(origins = "http://localhost:4200",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class ProjectController {
	
	@Autowired
	private ProjectService projectServiceObj;
	
	private Status status = new Status();
	
	@PostMapping(path="addProject")
	public Status addProject(@RequestBody ProjectDto projectInfo) {
		try {
		projectServiceObj.addProject(projectInfo);
		status.setStatus(statusType.SUCCESS);
		status.setMessage("Project Added Successfully");
		return status;
		}
		catch(ServiceException err) {
			status.setStatus(statusType.FAILURE);
			status.setMessage(err.getMessage());
			return status;
		}
	}
	
	@DeleteMapping(path="deleteProject")
	public Status deleteProject(@RequestParam int projectId) {
		try{
			projectServiceObj.deleteProject(projectId);
			status.setStatus(statusType.SUCCESS);
			status.setMessage("Projects Data Successfully Deleted");
			return status;
			}
		catch(ServiceException err) {
			status.setStatus(statusType.FAILURE);
			status.setMessage(err.getMessage());
			return status;
		}
	}
	
	@GetMapping(path="getProjects")
	public List<Projects> getProjects(){
		return projectServiceObj.getAllProjects();
		
	}
	
	@GetMapping(path="getProject/{projectId}")
	public Projects getProjectById(@PathVariable Integer projectId) {
		try{
			return projectServiceObj.getProjectById(projectId);
		}
		catch(ServiceException err) {
			Projects projectObj = new Projects();
			return projectObj;
		}
		
	}

	@PutMapping(path="updateProjectDetails")
	public Status updateProjectDetails(@RequestBody UpdateProjectDto projectInfo,@RequestParam Integer projectId) {
		try {
			projectServiceObj.updateProjectDetails(projectInfo,projectId);
			status.setStatus(statusType.SUCCESS);
			status.setMessage("Project Information Updated");
			return status;
		}
		catch(ServiceException err) {
			status.setMessage(err.getMessage());
			status.setStatus(statusType.FAILURE);
			return status;
		}
	}
}