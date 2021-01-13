package com.lti.repository;

import java.util.List;

import com.lti.dto.UpdateProjectDto;
import com.lti.pojo.Projects;

public interface ProjectRepository {
	//
	public void addProject(Projects projectInfo);
	//
	public Projects getProjectById(int projectId);
	//
	public List<Projects> getAllProjects();
	//
	public void updateProjectStatus(int projectId);
	//
	public boolean isEmpty();
	//
	public int getProjectId();
	//
	public void updateDetails(UpdateProjectDto projectInfo,Integer projectId);
}
