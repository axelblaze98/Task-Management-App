package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.ProjectDto;
import com.lti.dto.UpdateProjectDto;
import com.lti.pojo.Projects;
import com.lti.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectRepository projectRepoObj;

	
	private Projects project = new Projects();
	@Override
	public void addProject(ProjectDto projectInfo) {
		// TODO Auto-generated method stub
		int projectId = 14325;
		
		if(projectRepoObj.isEmpty()) project.setProjectId(projectId);
		else {
			projectId = projectRepoObj.getProjectId();
			project.setProjectId(projectId+1);
		}
		
		project.setSprint(1);
		project.setApplicationName(projectInfo.getApplicationName());
		project.setClient(projectInfo.getClient());
		project.setProjectName(projectInfo.getProjectName());
		project.setProjectLocation(projectInfo.getProjectLocation());
		project.setStatus("ACTIVE");
		
		projectRepoObj.addProject(project);
	}
	@Override
	public void deleteProject(int projectId) {
		// TODO Auto-generated method stub
		project = projectRepoObj.getProjectById(projectId);
		projectRepoObj.updateProjectStatus(projectId);
	}
	@Override
	public List<Projects> getAllProjects() {
		// TODO Auto-generated method stub
		return projectRepoObj.getAllProjects();
	}
	@Override
	public void updateProjectDetails(UpdateProjectDto projectInfo,Integer projectId) {
		// TODO Auto-generated method stub
		projectRepoObj.updateDetails(projectInfo,projectId);
	}
	@Override
	public Projects getProjectById(int projectId) {
		// TODO Auto-generated method stub
		return projectRepoObj.getProjectById(projectId);
	}
	@Override
	public void updateSprint(int projectId) {
		// TODO Auto-generated method stub
		projectRepoObj.updateSprint(projectId);
	}
}
