package com.lti.service;

import java.util.List;

import com.lti.dto.ProjectDto;
import com.lti.dto.UpdateProjectDto;
import com.lti.pojo.Projects;

public interface ProjectService {
	public void addProject(ProjectDto projectInfo);
	public void deleteProject(int projectId);
	public List<Projects> getAllProjects();
	public void updateProjectDetails(UpdateProjectDto projectInfo,Integer projectId);
	public Projects getProjectById(int projectId);
	public void updateSprint(int projectId, String sprint);
}
